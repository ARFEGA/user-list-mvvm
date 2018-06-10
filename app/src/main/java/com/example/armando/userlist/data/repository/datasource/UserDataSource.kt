package com.example.armando.userlist.data.repository.datasource

import com.example.armando.userlist.data.model.UserEntity
import io.reactivex.Observable

interface UserDataSource {

    fun getUserList(): Observable<List<UserEntity>>
    fun getUserDetail(userId:Long) : Observable<UserEntity>
}