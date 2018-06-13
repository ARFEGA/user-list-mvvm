package com.example.armando.userlist.data.db

import android.arch.persistence.room.*
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

    @Query("Delete from users")
    abstract fun deleteAllUsers()


    //Tareas donde se controla que tienen un fin correcto
    //Con open hacemos publica la función, de otra forma da problemas
    @Transaction
    open fun removeAndInsertUsers(users: List<UserEntity>){
        deleteAllUsers()
        insertAll(users)
    }

}