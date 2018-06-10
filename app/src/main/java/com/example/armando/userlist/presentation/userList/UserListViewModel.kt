package com.example.armando.userlist.presentation.userList

import android.arch.lifecycle.MutableLiveData
import com.example.armando.userlist.data.model.UserEntity
import com.example.armando.userlist.data.repository.datasource.UserFakeDataSource
import com.example.armando.userlist.data.repository.datasource.UserRepository
import com.example.armando.userlist.util.mvvm.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class UserListViewModel : BaseViewModel(){

    val userListState: MutableLiveData<List<UserEntity>> = MutableLiveData()
    val isLoadingState: MutableLiveData<Boolean> = MutableLiveData()
//todo:mejorar dependencias (no por inyección con service locator)
    private val fakeDataSource= UserFakeDataSource()
    private val userRepository = UserRepository(fakeDataSource)

    fun loadUserList()
    {
        userRepository.getUserList()
                .subscribeOn(Schedulers.io()) //Nos subscribimos por el hilo io
                .observeOn(AndroidSchedulers.mainThread())//Escuchamos en el hilo principal
                .doOnSubscribe { isLoadingState.postValue(true) }
                .doOnTerminate { isLoadingState.postValue(false) }
                .subscribeBy(
                        onNext = {
                            userListState.value = it
                        },
                        onError = {

                        },
                        onComplete = {

                        }
                ).addTo(compositeDisposable)//Para que libere memoria y evitar memory leaks

    }
}