package com.example.armando.userlist.presentation.UserDetail

import android.arch.lifecycle.MutableLiveData
import com.example.armando.userlist.data.model.UserEntity
import com.example.armando.userlist.data.repository.datasource.UserRepository
import com.example.armando.userlist.presentation.servicelocator.Inject
import com.example.armando.userlist.util.mvvm.BaseViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class UserDetailViewModel() :BaseViewModel(){

    val userState : MutableLiveData<UserEntity> = MutableLiveData()

   /* fun loadUserById(userId:Long){
        Inject.userRepository.getUserDetail(userId)
                .subscribeOn(Schedulers.io())//Por que hilo nos subscribimos
                .observeOn(AndroidSchedulers.mainThread())//Por que hilo escuchamos
                .subscribeBy (
                    onNext = {
                        userState.value = it
                    },
                        onError = {

                        }
                        , onComplete = {

                        }

                ).addTo(compositeDisposable)//compositeDisposable pertenece a BaseViewModel y evita memory leaks destruyendo los observer cuando procede
    }*/
}
