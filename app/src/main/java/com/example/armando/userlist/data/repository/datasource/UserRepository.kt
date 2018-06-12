package com.example.armando.userlist.data.repository.datasource

import com.example.armando.userlist.data.model.UserEntity
import io.reactivex.Flowable.combineLatest
import io.reactivex.Flowable.zip
import io.reactivex.Observable
import io.reactivex.rxkotlin.zipWith
import java.util.concurrent.TimeUnit

class UserRepository(private val userFakeDataSource: UserFakeDataSource,
                     private val userFakeDataSource2: UserFakeDataSource2) {

    fun getUserList(): Observable<List<UserEntity>> {
        return userFakeDataSource.getUserList()
                .zipWith(userFakeDataSource2.getUserList())
                .map {pair->
                    val newList = mutableListOf<UserEntity>()
                    newList.addAll(pair.first)
                    newList.addAll(pair.second)
                    newList.toList()
                }

                .delay(3,TimeUnit.SECONDS)



    }

    fun getUserDetail(userId: Long): Observable<UserEntity> {
        return userFakeDataSource.getUserDetail(userId)
                .concatWith(userFakeDataSource2.getUserDetail(userId))
    }
}