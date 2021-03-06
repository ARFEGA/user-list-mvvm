package com.example.armando.userlist.presentation

import android.app.Application
import android.net.wifi.WifiManager
import android.preference.Preference
import android.preference.PreferenceManager
import com.example.armando.userlist.presentation.servicelocator.Inject
import com.example.armando.userlist.util.SettingsManager
import com.facebook.stetho.Stetho

//Esta clase es con la que se inicia la app y está indicado en el manifest
class UserApp:Application() {
    override fun onCreate() {
        super.onCreate()
        //Para debugear en el terminal
        Stetho.initializeWithDefaults(this)
        //Lo hacemos desde aquí pq desde inject, no podemos acceder al contexto y así debe de estar.
        //Esta clase al implementar Application(), accede a un contexto, que mientras no se cierre la app siempre durará
        //evitando memory leaks
        Inject.settingsManager = SettingsManager(PreferenceManager.getDefaultSharedPreferences(this))
        Inject.initDatabase(this)

    }
}