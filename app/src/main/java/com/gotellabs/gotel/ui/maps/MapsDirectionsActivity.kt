package com.gotellabs.gotel.ui.maps

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.gotellabs.gotel.BuildConfig
import com.gotellabs.gotel.R
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.api.directions.v5.models.DirectionsResponse
import com.mapbox.api.directions.v5.models.DirectionsRoute
import com.mapbox.geojson.Feature
import com.mapbox.geojson.Point
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.location.LocationComponent
import com.mapbox.mapboxsdk.location.modes.CameraMode
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.style.layers.PropertyFactory.*
import com.mapbox.mapboxsdk.style.layers.SymbolLayer
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncher
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncherOptions
import com.mapbox.services.android.navigation.ui.v5.route.NavigationMapRoute
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute
import kotlinx.android.synthetic.main.activity_maps_directions.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MapsDirectionsActivity : AppCompatActivity(), OnMapReadyCallback, PermissionsListener {

    private lateinit var mapView: MapView
    private lateinit var mapboxMap: MapboxMap
    private lateinit var mapboxToken: String
    private lateinit var locationComponent: LocationComponent
    private lateinit var permissionsManager: PermissionsManager
    private lateinit var currentRoute: DirectionsRoute
    private lateinit var navigationMapRoute: NavigationMapRoute

    private lateinit var lat: String
    private lateinit var lng: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lat = intent.extras!!.get("lat") as String
        lng = intent.extras!!.get("lng") as String

        mapboxToken = BuildConfig.MAPBOX_TOKEN
        Mapbox.getInstance(this, mapboxToken)
        setContentView(R.layout.activity_maps_directions)
        mapView = findViewById<MapView>(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
    }

    override fun onMapReady(mapboxMap: MapboxMap) {
        this.mapboxMap = mapboxMap
        mapboxMap.setStyle(
            getString(R.string.navigation_guidance_day)
        ) {
            enableLocationComponent(it)
            addDestinationIconSymbolLayer(it)
            val destinationPoint = Point.fromLngLat(lng.toDouble(), lat.toDouble())
            val originPoint = Point.fromLngLat(
                locationComponent.lastKnownLocation!!.longitude,
                locationComponent.lastKnownLocation!!.latitude
            )

            val source =
                mapboxMap.style!!.getSourceAs<GeoJsonSource>("destination-source-id")
            source?.setGeoJson(Feature.fromGeometry(destinationPoint))

            getRoute(originPoint, destinationPoint)
            maps_directions_button.isEnabled = true
            maps_directions_button.setOnClickListener {
                val simulateRoute = true
                val options: NavigationLauncherOptions = NavigationLauncherOptions.builder()
                    .directionsRoute(currentRoute)
                    .shouldSimulateRoute(simulateRoute)
                    .build()

                NavigationLauncher.startNavigation(this, options)
            }
        }

    }


    private fun getRoute(origin: Point, destination: Point) {
        Mapbox.getAccessToken()?.let {
            NavigationRoute.builder(this)
                .accessToken(it)
                .origin(origin)
                .destination(destination)
                .build()
                .getRoute(object : Callback<DirectionsResponse?> {
                    override fun onFailure(call: Call<DirectionsResponse?>, t: Throwable) {
                        Log.e("ERROR", "Error: " + t.message)
                    }

                    override fun onResponse(
                        call: Call<DirectionsResponse?>,
                        response: Response<DirectionsResponse?>
                    ) {
                        if (response.body() == null) {
                            return
                        } else if (response.body()!!.routes().size < 1) {
                            return
                        }
                        currentRoute = response.body()!!.routes()[0]
                        navigationMapRoute = NavigationMapRoute(
                            null,
                            mapView,
                            mapboxMap,
                            R.style.NavigationMapRoute
                        )
                        navigationMapRoute.removeRoute()
                        navigationMapRoute.addRoute(currentRoute)
                    }
                })
        }
    }

    private fun addDestinationIconSymbolLayer(loadedMapStyle: Style) {
        loadedMapStyle.addImage(
            "destination-icon-id",
            BitmapFactory.decodeResource(this.resources, R.drawable.mapbox_marker_icon_default)
        )
        val geoJsonSource = GeoJsonSource("destination-source-id")
        loadedMapStyle.addSource(geoJsonSource)
        val destinationSymbolLayer =
            SymbolLayer("destination-symbol-layer-id", "destination-source-id")
        destinationSymbolLayer.withProperties(
            iconImage("destination-icon-id"),
            iconAllowOverlap(true),
            iconIgnorePlacement(true)
        )
        loadedMapStyle.addLayer(destinationSymbolLayer)
    }

    private fun enableLocationComponent(loadedMapStyle: Style) {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            permissionsManager = PermissionsManager(this)
            permissionsManager.requestLocationPermissions(this)
            return
        }
        locationComponent = mapboxMap.locationComponent
        locationComponent.activateLocationComponent(this, loadedMapStyle)
        locationComponent.isLocationComponentEnabled = true
        locationComponent.cameraMode = CameraMode.TRACKING
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onExplanationNeeded(permissionsToExplain: MutableList<String>?) {
        Toast.makeText(
            this,
            getString(R.string.user_location_permission_explanation),
            Toast.LENGTH_LONG
        )
            .show()
    }

    override fun onPermissionResult(granted: Boolean) {
        if (granted) {
            mapboxMap.style?.let { enableLocationComponent(it) }
        } else {
            Toast.makeText(this, getString(R.string.permissions_not_allowed), Toast.LENGTH_LONG)
                .show()
            finish()
        }
    }

    // region Lifecycle methods

    override fun onStart() {
        mapView.onStart()
        super.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        super.onStop()
    }

    override fun onPause() {
        mapView.onPause()
        super.onPause()
    }

    override fun onResume() {
        mapView.onResume()
        super.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        mapView.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        mapView.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        mapView.onLowMemory()
        super.onLowMemory()
    }

    // endregion

}