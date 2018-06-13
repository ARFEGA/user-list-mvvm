package com.example.armando.userlist.data.net

import com.example.armando.userlist.data.model.UserApiResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface UserService {
    @GET("api/?results=20")
    fun getUsers(): Flowable<UserApiResponse>

}