package com.example.armando.userlist.data.repository.datasource

import com.example.armando.userlist.data.mapper.UserEntityMapper
import com.example.armando.userlist.data.model.UserEntity
import com.example.armando.userlist.data.net.UserService
import io.reactivex.Flowable

class ApiDataSource(private val userService: UserService,
                    private val userEntityMapper: UserEntityMapper)
    :UserDataSource {
    override fun getUserList(): Flowable<List<UserEntity>> =
         userService.getUsers()
                .map { it.results }
                .map { userEntityMapper.transformList(it)}
        //todo


}