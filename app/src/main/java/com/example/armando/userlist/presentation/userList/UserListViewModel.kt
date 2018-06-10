package com.example.armando.userlist.presentation.userList

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.armando.userlist.model.UserEntity
import com.example.armando.userlist.repository.datasource.UserFakeDataSource
import com.example.armando.userlist.repository.datasource.UserRepository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class UserListViewModel : ViewModel() {

    val userListState: MutableLiveData<List<UserEntity>> = MutableLiveData()

    private val fakeDataSource= UserFakeDataSource()
    private val userRepository = UserRepository(fakeDataSource)

    fun loadUserList()
    {
        userRepository.getUserList()
                .subscribeOn(Schedulers.io()) //Nos subscribimos por el hilo io
                .observeOn(AndroidSchedulers.mainThread())//Escuchamos en el hilo principal
                .subscribeBy(
                        onNext = {
                            userListState.value = it
                        },
                        onError = {

                        },
                        onComplete = {

                        }
                )

    }
}