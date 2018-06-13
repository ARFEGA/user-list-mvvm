package com.example.armando.userlist.data.model


import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



@Entity (tableName = "users")//Nombre de la tabla
@Parcelize
data class UserEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val name: String,
        @ColumnInfo(name = "avatar_url")//Para indicar que avatarUrl en base se llama avatar_url
        val avatarUrl: String
):Parcelable