package com.example.armando.userlist.data.repository.datasource

import com.example.armando.userlist.data.model.UserEntity
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class UserFakeDataSource2 : UserDataSource{

    val user = listOf<UserEntity>(
            UserEntity(1,"Pili","https://randomuser.me/api/portraits/women/9.jpg"),
            UserEntity(2,"Andrea","https://randomuser.me/api/portraits/women/27.jpg")



    )

    override fun getUserList(): Observable<List<UserEntity>> {
        return Observable.just(user)
                .delay(1, TimeUnit.SECONDS)
    }

    override fun getUserDetail(userId: Long): Observable<UserEntity> {
        return Observable.just(user.find { it.userId == userId })
    }


}