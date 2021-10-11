package com.fingermidia.mvvmproject2.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fingermidia.mvvmproject2.models.Store

class StoreViewModel : ViewModel() {

    val store = MutableLiveData<Store>()

    fun setStore(store: Store) {
        this.store.postValue(store)
    }

}