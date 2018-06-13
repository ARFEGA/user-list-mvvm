package com.example.armando.userlist.data.mapper

interface Mapper<in R, out T> {
    fun transform(input:R):T
    fun transformList(inpt:List<R>):List<T>
}