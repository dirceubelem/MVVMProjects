package com.fingermidia.mvvmproject2.repositories

import com.fingermidia.mvvmproject2.service.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getStores() = retrofitService.getStores()

}