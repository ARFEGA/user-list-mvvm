package com.example.armando.userlist.data.repository.datasource

import com.example.armando.userlist.data.model.UserEntity
import io.reactivex.Flowable
import io.reactivex.Observable

interface UserDataSource {
    fun getUserList(): Flowable<List<UserEntity>>
    //fun getUserList(): Observable<List<UserEntity>>
    //fun getUserDetail(userId:Long) : Observable<UserEntity>
}