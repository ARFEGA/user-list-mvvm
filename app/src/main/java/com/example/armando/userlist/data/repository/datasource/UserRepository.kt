package com.example.armando.userlist.data.repository.datasource

import com.example.armando.userlist.data.model.UserEntity
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class UserRepository(private val userFakeDataSource: UserFakeDataSource,
                     private val userFakeDataSource2: UserFakeDataSource2) {

    fun getUserList(): Observable<List<UserEntity>> {
        return userFakeDataSource.getUserList()
                .delay(3,TimeUnit.SECONDS)
                .concatWith(userFakeDataSource2.getUserList())
    }

    fun getUserDetail(userId: Long): Observable<UserEntity> {
        return userFakeDataSource.getUserDetail(userId)
                .concatWith(userFakeDataSource2.getUserDetail(userId))
    }
}