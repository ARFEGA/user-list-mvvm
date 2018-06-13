package com.example.armando.userlist.presentation.userList

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.example.armando.userlist.R
import com.example.armando.userlist.data.model.UserEntity
import com.example.armando.userlist.presentation.UserDetail.UserDetailActivity
import com.example.armando.userlist.util.Navigator
import kotlinx.android.synthetic.main.activity_main.*


class UserListActivity : AppCompatActivity() {

    lateinit var userListViewModel: UserListViewModel
    val adapter = UserListAdapter{onUserClicked(it)}

    private fun onUserClicked(userEntity: UserEntity){
        Navigator.openUserDetail(this,userEntity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecycler()
        setUpViewModel()
    }
    private fun setUpRecycler(){
        user_list_recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        user_list_recycler.itemAnimator = DefaultItemAnimator()
        user_list_recycler.adapter = adapter

    }
    private fun setUpViewModel(){
        userListViewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)
        bindEvents()
        userListViewModel.loadUserList()
    }

    private fun bindEvents(){
        //Utilizando liveData para subscribir a eventos
        userListViewModel.isLoadingState.observe(this, Observer { isLoading ->
            isLoading?.let {
                showLoading(it)
            }

        })
        userListViewModel.userListState.observe(this, Observer {usersList ->
            usersList?.let {
                onUserListLoaded(it)
            }

        })
    }

    private fun onUserListLoaded(userList:List<UserEntity>){
        adapter.submitList(userList)
    }

    private fun showLoading(isLoading:Boolean){
        user_list_loading.visibility = if(isLoading) View.VISIBLE else View.GONE
    }

//    override fun onResume() {
//        super.onResume()
//        userListViewModel.loadUserList()
//    }


}
