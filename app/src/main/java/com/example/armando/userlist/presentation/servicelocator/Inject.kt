package com.example.armando.userlist.presentation.servicelocator

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.example.armando.userlist.data.db.UserDatabase
import com.example.armando.userlist.data.mapper.UserEntityMapper
import com.example.armando.userlist.data.net.UserService
import com.example.armando.userlist.data.repository.datasource.*
import com.example.armando.userlist.util.SettingsManager
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.prefs.Preferences

//Para crear un singleton, con Object para toda la app
object Inject {

    lateinit var database : UserDatabase


    //Todo Retrofit
    val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    val userService = retrofit.create(UserService::class.java)

    val userEntityMapper = UserEntityMapper()



    lateinit var settingsManager: SettingsManager

    //val fakeDataSource = UserFakeDataSource()
    //val fakeDataSource2 = UserFakeDataSource2()

    val apiDataSource = ApiDataSource(userService,userEntityMapper)

    lateinit var localDataSource : LocalDataSource
    lateinit var userRepository : UserRepository

    fun initDatabase(context: Context){
        database = Room.databaseBuilder(context,UserDatabase::class.java,"users.db").build()
        localDataSource = LocalDataSource(database)
        userRepository = UserRepository(localDataSource, apiDataSource)

    }

}