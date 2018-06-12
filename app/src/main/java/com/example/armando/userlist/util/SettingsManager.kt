package com.example.armando.userlist.util

import android.content.SharedPreferences
import android.preference.PreferenceManager
//Con esta clase, controlamos si es el primer acceso a datos o no.
class SettingsManager (private val sharedPreferences: SharedPreferences){

    companion object {
        const val PREF_VAL_LOAD = "first_load"
    }
    var firstLoad:Boolean
    get()= sharedPreferences.getBoolean(PREF_VAL_LOAD,true)
    set(value){
        sharedPreferences
                .edit()
                .putBoolean(PREF_VAL_LOAD,value)
                .apply()
    }
}