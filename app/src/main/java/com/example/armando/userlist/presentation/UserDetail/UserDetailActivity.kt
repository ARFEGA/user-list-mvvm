package com.example.armando.userlist.presentation.UserDetail

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide

import com.example.armando.userlist.R
import com.example.armando.userlist.data.model.UserEntity
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity:AppCompatActivity() {

    companion object {
        const val PARAM_USER_ID = "user_id"
    }
    lateinit var userDetailViewModel : UserDetailViewModel
    var userEntity : UserEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        userEntity = intent.getParcelableExtra(PARAM_USER_ID)
        init()
    }

    private fun init(){
        userDetailViewModel = ViewModelProviders.of(this).get(UserDetailViewModel::class.java)
        //bindEvents()
        loadUserData()
    }
    /*private fun bindEvents(){
        userDetailViewModel.userState.observe(this, Observer{
            it?.let {
                onUserLoaded(it)
            }
        })
    }*/
    private fun loadUserData(){
        //Si es -1, es que no tenemos un valor correcto
        if (userEntity == null){//La L es para indicar que es un long
            setResult(Activity.RESULT_CANCELED)
            finish()//finish cierra la actividad
        }
            //userDetailViewModel.loadUserById(userId)
            onUserLoaded(userEntity!!)


    }

    private fun onUserLoaded(userEntity:UserEntity){

        user_detail_name.text = userEntity.name
        Glide.with(this)
                .load(userEntity.avatarUrl)
                .into(user_detail_avatar)
    }
}