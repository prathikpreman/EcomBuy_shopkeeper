package com.prathik.ecomshopkeeper.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences


object PreferenceManager {

    private var mSharedPref: SharedPreferences? = null

    private fun SharedPreferenceManager() {}


    var SESSION:String="SESSION"
    var USER_NAME:String="USER_NAME"
    var USER_ID:String="USER_ID"
    var PHONE_NUMBER:String="PHONE_NUMBER"
    var IS_LOGGED_IN:String="IS_LOGGED_IN"

    var FCM_TOKEN:String="FCM_TOKEN"

    var SET_WORKMANAGER:String="SET_WORKMANAGER"

    var ADDRESS_ROOM:String="ADDRESS_ROOM"
    var ADDRESS_LOCALITY:String="ADDRESS_LOCALITY"
    var ADDRESS_LANDMARK:String="ADDRESS_LANDAMARK"
    var ADDRESS_LATITUDE:String="ADDRESS_LATITUDE"
    var ADDRESS_LONGITUDE:String="ADDRESS_LONGITUDE"


    fun init(context: Context) {
        if (mSharedPref == null) mSharedPref =
            context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE)
    }

    fun getString(key: String?, defValue: String?): String? {
        return mSharedPref!!.getString(key, defValue)
    }

    fun setString(key: String?, value: String?) {
        val prefsEditor = mSharedPref!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.commit()
    }

    fun getBoolean(key: String?, defValue: Boolean): Boolean {
        return mSharedPref!!.getBoolean(key, defValue)
    }

    fun setBoolean(key: String?, value: Boolean) {
        val prefsEditor = mSharedPref!!.edit()
        prefsEditor.putBoolean(key, value)
        prefsEditor.commit()
    }

    fun getInt(key: String?, defValue: Int): Int? {
        return mSharedPref!!.getInt(key, defValue)
    }

    fun setInt(key: String?, value: Int?) {
        val prefsEditor = mSharedPref!!.edit()
        prefsEditor.putInt(key, value!!).commit()
    }

}