package com.example.armando.userlist.data.model

import android.support.v7.util.DiffUtil

class UserEntityDiff:DiffUtil.ItemCallback<UserEntity>() {
    override fun areItemsTheSame(oldItem: UserEntity?, newItem: UserEntity?): Boolean =
           // oldItem?.userId == newItem?.userId
            true

    override fun areContentsTheSame(oldItem: UserEntity?, newItem: UserEntity?): Boolean =
        oldItem == newItem
}