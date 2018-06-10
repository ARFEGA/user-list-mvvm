package com.example.armando.userlist.data.repository.datasource

import com.example.armando.userlist.data.model.UserEntity
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class UserFakeDataSource : UserDataSource{

    val user = listOf<UserEntity>(
            UserEntity(1,"Hilla","https://randomuser.me/api/portraits/women/63.jpg"),
            UserEntity(2,"Patricia","https://randomuser.me/api/portraits/women/22.jpg"),
            UserEntity(3,"Lola","https://randomuser.me/api/portraits/women/63.jpg"),
            UserEntity(4,"Pepa","https://randomuser.me/api/portraits/women/62.jpg"),
            UserEntity(5,"Andrea","https://randomuser.me/api/portraits/women/65.jpg")


    )

    override fun getUserList(): Observable<List<UserEntity>> {
        return Observable.just(user)
                .delay(1,TimeUnit.SECONDS)
    }

    override fun getUserDetail(userId: Long): Observable<UserEntity> {
        return Observable.just(user.find { it.userId == userId })
    }


}