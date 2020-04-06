package com.gotellabs.gotel.utils

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


/**
 * Created by Enzo Lizama Paredes on 4/5/20.
 * Contact: lizama.enzo@gmail.com
 */


/**
 * This class observes the current [FirebaseUser]. If there is no logged in user, [FirebaseUser] will
 * be null
 *
 * [LiveData.onActive] and [LiveData.onInactive] will get triggered when the configuration changes,
 * for example when the device rotate.
 */
class FirebaseUserLiveData : LiveData<FirebaseUser?>() {
    private val firebaseAuth = FirebaseAuth.getInstance()

    private val authStateListener = FirebaseAuth.AuthStateListener {
        value = it.currentUser
    }


    override fun onActive() {
        firebaseAuth.addAuthStateListener(authStateListener)
    }

    override fun onInactive() {
        firebaseAuth.removeAuthStateListener(authStateListener)
    }
}