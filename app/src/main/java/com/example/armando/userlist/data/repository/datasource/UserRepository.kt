package com.example.armando.userlist.data.repository.datasource

import com.example.armando.userlist.data.model.UserEntity
import io.reactivex.Flowable
import io.reactivex.Flowable.*
import io.reactivex.Observable
import io.reactivex.rxkotlin.zipWith
import java.util.concurrent.TimeUnit

class UserRepository(private  val localDataSource: LocalDataSource,private val apiDataSource: ApiDataSource){
                     //private val userFakeDataSource2: UserFakeDataSource2) {

    fun getUserList(): Flowable<List<UserEntity>> {
        return getUsersFromDb()
                .delay(1,TimeUnit.SECONDS)
                .concatWith(getUsersFromApi())
                //Con mergeWith, devuelve la primera solicitud que llega
                //.mergeWith(apiDataSource.getUserList())


        //.concatWith(userFakeDataSource2.getUserList())
                //CON ZipWith y map, concatenemos las respuestas que llegan
                /*.zipWith(userFakeDataSource2.getUserList())
                .map {pair->
                    val newList = mutableListOf<UserEntity>()
                    newList.addAll(pair.first)
                    newList.addAll(pair.second)
                    newList.toList()
                }*/
    }
    private fun getUsersFromDb(): Flowable<List<UserEntity>> = localDataSource.getUserList()
    private fun getUsersFromApi(): Flowable<List<UserEntity>> =
            apiDataSource.getUserList()
                    .doOnNext { localDataSource.saveUsers(it) }

    /*fun getUserDetail(userId: Long): Flowable<UserEntity> {
        return userFakeDataSource.getUserDetail(userId)//Si no lo encuentra en el primer repositorio, se pide que lo busque en el segundo
                //.switchIfEmpty(userFakeDataSource2.getUserDetail(userId))
        //.onErrorResumeNext{it:Throwable -> userFakeDataSource2.getUserDetail(userId)}

    }*/
}