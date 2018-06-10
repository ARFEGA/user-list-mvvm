package com.example.armando.userlist.repository.datasource

import com.example.armando.userlist.model.UserEntity
import io.reactivex.Observable
import java.util.*

interface UserDataSource {

    fun getUserList(): Observable<List<UserEntity>>
    fun getUserDetail(userId:Long) : Observable<UserEntity>
}