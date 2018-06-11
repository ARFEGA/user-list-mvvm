package com.example.armando.userlist.presentation.servicelocator

import com.example.armando.userlist.data.repository.datasource.UserFakeDataSource
import com.example.armando.userlist.data.repository.datasource.UserFakeDataSource2
import com.example.armando.userlist.data.repository.datasource.UserRepository

//Para crear un singleton, con Object
object Inject {

    val fakeDataSource = UserFakeDataSource()
    val fakeDataSource2 = UserFakeDataSource2()


    val userRepository = UserRepository(fakeDataSource, fakeDataSource2)

}