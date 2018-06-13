package com.example.armando.userlist.data.repository.datasource

import com.example.armando.userlist.data.model.UserEntity
import io.reactivex.Flowable
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class UserFakeDataSource2 : UserDataSource{

    val user = listOf(
            UserEntity(0,"Pili","https://randomuser.me/api/portraits/women/9.jpg"),
            UserEntity(0,"Andrea","https://randomuser.me/api/portraits/women/27.jpg")



    )

    override fun getUserList(): Flowable<List<UserEntity>> {
        return Flowable.just(user)
                .delay(1, TimeUnit.SECONDS)
    }
/*
    override fun getUserDetail(userId: Long): Observable<UserEntity> {
        val user = user.find { it.userId == userId }
        return if(user != null) {
            Observable.just(user)
        }else {
            Observable.empty()
        }
    }*/


}