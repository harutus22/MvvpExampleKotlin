package com.example.mvvpexamplekotlin.network

import android.content.Context
import android.net.ConnectivityManager

class NetworkManager (private var appContext: Context){
    private var status: Boolean? = false
    val isConnectedToInternet: Boolean?
    get() {
        val conManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val net = conManager.activeNetworkInfo
        return net != null && net.isConnected
    }
}