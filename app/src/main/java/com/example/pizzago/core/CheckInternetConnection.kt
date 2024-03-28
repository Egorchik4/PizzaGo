package com.example.pizzago.core

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class CheckInternetConnectionImpl @Inject constructor(var context: Context) : CheckInternetConnection {

	override fun internetIsAvailable(): Boolean {
		val connectManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
		val wifiConnection = connectManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
		val mobileConnection = connectManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
		return (wifiConnection!!.isConnectedOrConnecting || mobileConnection!!.isConnectedOrConnecting)
	}
}

interface CheckInternetConnection {

	fun internetIsAvailable(): Boolean
}