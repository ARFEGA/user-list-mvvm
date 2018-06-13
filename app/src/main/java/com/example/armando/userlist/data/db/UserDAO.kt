package com.example.armando.userlist.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.armando.userlist.data.model.UserEntity
import io.reactivex.Flowable
import io.reactivex.Maybe


@Dao
abstract class UserDAO {
    @Query("Select * from users")
    //abstract fun getAllUsers(): Flowable<List<UserEntity>>//Devuelve un flujo de datos
    abstract fun getAllUsers(): Maybe<List<UserEntity>>//Devuelve datos si los hay y si no, hace un complete

    @Insert(onConflict = OnConflictStrategy.REPLACE)//Si el valor está duplicado, toma la decisión de sustituirlo
    abstract fun insertAll(users : List<UserEntity>)

}