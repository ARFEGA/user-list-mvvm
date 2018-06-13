package com.example.armando.userlist.data.mapper

import com.example.armando.userlist.data.model.User
import com.example.armando.userlist.data.model.UserEntity

class UserEntityMapper : Mapper<User,UserEntity> //Indicamos que entra (User) y que sale (UserEntity)
{
    override fun transform(input: User): UserEntity {
        return UserEntity(0,input.name.last,input.picture.large)
    }

    override fun transformList(input: List<User>): List<UserEntity> {
        return input.map { transform(it) }
    }


}