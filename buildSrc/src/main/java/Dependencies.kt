
object Dependencies{

    object Version{
        const val kotlin = "1.3.71"
        const val material = "1.1.0"
        const val junit = "4.12"
        const val junitX = "1.1.1"
        const val room = "2.2.5"
        const val constraintLayout = "1.1.3"
        const val appCompat = "1.1.0"
        const val coreKtx = "1.2.0"
        const val coroutines = "1.3.5"
        const val espresso = "3.2.0"
        const val fFireStore = "21.4.1"
        const val fMessaging = "20.1.3"
        const val fAuth = "19.3.0"
        const val dagger2 = "2.23.1"
        const val swipeRefresh = "1.0.0"
        const val glide = "4.11.0"
        const val lifecycle = "2.2.0"
        const val truth = "1.0"
        const val mockito = "3.2.4"
        const val robolectric = "4.3"
        const val mockWebServer = "4.2.1"
        const val retrofit2 = "2.3.0"
        const val okhttp3 = "3.4.1"
        const val gson = "2.3.0"
        const val gsonVersion = "2.8.0"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    const val material = "com.google.android.material:material:${Version.material}"
    const val junit = "junit:junit:${Version.junit}"
    const val junitX = "androidx.test.ext:junit:${Version.junitX}"
    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"

    const val swipeRefreshLayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Version.swipeRefresh}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"

    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"

    const val firebaseAuth = "com.google.firebase:firebase-auth:${Version.fAuth}"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging:${Version.fMessaging}"

    const val dagger = "com.google.dagger:dagger:${Version.dagger2}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger2}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Version.dagger2}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Version.dagger2}"
    const val daggerAndroidProcessor =
        "com.google.dagger:dagger-android-processor:${Version.dagger2}"

    const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glide}"

    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"

    const val truth = "com.google.truth:truth:${Version.truth}"

    const val mockito = "org.mockito:mockito-core:${Version.mockito}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Version.mockWebServer}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit2}"
    const val gson = "com.google.code.gson:gson:${Version.gsonVersion}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Version.gson}"
    const val okhttp3 = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp3}"


}