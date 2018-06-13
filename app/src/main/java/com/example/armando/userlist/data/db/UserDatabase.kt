package com.example.armando.userlist.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.armando.userlist.data.model.UserEntity


@Database(entities = [UserEntity::class],version = 1)

abstract class UserDatabase:RoomDatabase() {
    abstract fun getUserDao():UserDAO
}