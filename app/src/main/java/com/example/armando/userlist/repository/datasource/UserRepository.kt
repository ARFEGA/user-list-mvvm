package com.example.armando.userlist.repository.datasource

import com.example.armando.userlist.model.UserEntity
import io.reactivex.Observable

class UserRepository(private val userFakeDataSource: UserFakeDataSource) {

    fun getUserList(): Observable<List<UserEntity>> {
        return userFakeDataSource.getUserList()
    }

    fun getUserDetail(userId: Long): Observable<UserEntity> {
        return userFakeDataSource.getUserDetail(userId)
    }
}