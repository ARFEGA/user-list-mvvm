package com.example.armando.userlist.util

import android.app.Activity
import android.content.Intent
import com.example.armando.userlist.data.model.UserEntity
import com.example.armando.userlist.presentation.UserDetail.UserDetailActivity

object Navigator {

    fun openUserDetail(activity:Activity, userEntity:UserEntity){
        val intent = Intent(activity, UserDetailActivity::class.java)
        intent.putExtra(UserDetailActivity.PARAM_USER_ID,userEntity)
        activity.startActivity(intent)

    }
}