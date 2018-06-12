package com.example.armando.userlist.presentation.servicelocator

import android.content.SharedPreferences
import com.example.armando.userlist.data.repository.datasource.UserFakeDataSource
import com.example.armando.userlist.data.repository.datasource.UserFakeDataSource2
import com.example.armando.userlist.data.repository.datasource.UserRepository
import com.example.armando.userlist.util.SettingsManager
import java.util.prefs.Preferences

//Para crear un singleton, con Object
object Inject {

    lateinit var settingsManager: SettingsManager
    val fakeDataSource = UserFakeDataSource()
    val fakeDataSource2 = UserFakeDataSource2()


    val userRepository = UserRepository(fakeDataSource, fakeDataSource2)

}