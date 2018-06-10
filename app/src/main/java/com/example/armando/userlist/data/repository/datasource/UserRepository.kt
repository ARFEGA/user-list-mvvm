package com.example.armando.userlist.data.repository.datasource

import com.example.armando.userlist.data.model.UserEntity
import io.reactivex.Observable

class UserRepository(private val userFakeDataSource: UserFakeDataSource) {

    fun getUserList(): Observable<List<UserEntity>> {
        return userFakeDataSource.getUserList()
    }

    fun getUserDetail(userId: Long): Observable<UserEntity> {
        return userFakeDataSource.getUserDetail(userId)
    }
}