package com.fingermidia.mvvmproject2.service

import com.fingermidia.mvvmproject2.models.StoreList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("pharmacy")
    fun getStores(): Call<StoreList>

    companion object {

        private val retrofitServices: RetrofitService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.basestudio.com.br/v1/132a2266fe1c8c76229217/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)

        }

        fun getInstance(): RetrofitService {
            return retrofitServices
        }

    }

}