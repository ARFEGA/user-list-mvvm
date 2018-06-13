package com.example.armando.userlist.data.repository.datasource

import com.example.armando.userlist.data.model.UserEntity
import io.reactivex.Flowable
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class UserFakeDataSource : UserDataSource{

    val user = listOf(
            UserEntity(0,"Hilla","https://randomuser.me/api/portraits/women/63.jpg"),
            UserEntity(0,"Patricia","https://randomuser.me/api/portraits/women/22.jpg"),
            UserEntity(0,"Lola","https://randomuser.me/api/portraits/women/40.jpg"),
            UserEntity(0,"Pepa","https://randomuser.me/api/portraits/women/62.jpg"),
            UserEntity(0,"Andrea","https://randomuser.me/api/portraits/women/65.jpg")


    )

    override fun getUserList(): Flowable<List<UserEntity>> {
        return Flowable.just(user)
                .delay(1,TimeUnit.SECONDS)
    }

//    override fun getUserDetail(userId: Long): Observable<UserEntity> {
//        val user = user.find { it.userId == userId }
//        return if(user != null) {
//            Observable.just(user)
//        }else {
//            Observable.empty()
//        }
//
//    }


}