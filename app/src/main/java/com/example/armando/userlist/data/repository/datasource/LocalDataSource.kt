package com.example.armando.userlist.data.repository.datasource

import com.example.armando.userlist.data.db.UserDatabase
import com.example.armando.userlist.data.model.UserEntity
import io.reactivex.Flowable
import java.util.*
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class LocalDataSource(val userDatabase: UserDatabase): UserDataSource {
    override fun getUserList(): Flowable<List<UserEntity>> {
        return userDatabase
                .getUserDao()
                .getAllUsers()//devuelve un Maybe, por lo que hay que pasarlo a Flowabel
                .toFlowable()
    }

    //Las inserciones hay que hacerlas en segundo plano
    fun saveUsers(users: List<UserEntity>){
        Observable.fromCallable{//fromCallable se emplea para indicar donde se ejecutará
            userDatabase.getUserDao().removeAndInsertUsers(users)
        }
                .subscribeOn(Schedulers.io())//Hilo en segundo plano
                .subscribe()//Para que arranque

    }
}