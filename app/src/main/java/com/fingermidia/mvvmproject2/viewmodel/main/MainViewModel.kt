package com.fingermidia.mvvmproject2.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fingermidia.mvvmproject2.models.Store
import com.fingermidia.mvvmproject2.models.StoreList
import com.fingermidia.mvvmproject2.repositories.MainRepository
import retrofit2.Call
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val storeList = MutableLiveData<List<Store>>()
    val errorMessage = MutableLiveData<String>()

    fun getStores() {
        val r = repository.getStores()
        r.enqueue(object : retrofit2.Callback<StoreList> {
            override fun onResponse(call: Call<StoreList>, response: Response<StoreList>) {
                response.body()?.let { stores ->
                    storeList.postValue(stores.items)
                }

            }

            override fun onFailure(call: Call<StoreList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }


}