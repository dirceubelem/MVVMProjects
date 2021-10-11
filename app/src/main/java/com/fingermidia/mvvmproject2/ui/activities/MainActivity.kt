package com.fingermidia.mvvmproject2.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.fingermidia.mvvmproject2.R
import com.fingermidia.mvvmproject2.databinding.ActivityMainBinding
import com.fingermidia.mvvmproject2.models.Store
import com.fingermidia.mvvmproject2.repositories.MainRepository
import com.fingermidia.mvvmproject2.service.RetrofitService
import com.fingermidia.mvvmproject2.ui.adapters.StoreAdapter
import com.fingermidia.mvvmproject2.viewmodel.main.MainViewModel
import com.fingermidia.mvvmproject2.viewmodel.main.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()

    private val storeAdapter = StoreAdapter {
        onItemClick(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        viewModel.storeList.observe(this, { stores ->
            storeAdapter.setStoreList(stores)
        })

        binding.stores.adapter = storeAdapter

        viewModel.getStores()
    }

    private fun onItemClick(store: Store) {
        var intent = Intent(this, StoreActivity::class.java)
        intent.putExtra("store", store)
        startActivity(intent)
    }
}