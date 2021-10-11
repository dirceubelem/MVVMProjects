package com.fingermidia.mvvmproject2.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fingermidia.mvvmproject2.R
import com.fingermidia.mvvmproject2.databinding.ActivityStoreBinding
import com.fingermidia.mvvmproject2.models.Store
import com.fingermidia.mvvmproject2.ui.adapters.StoreViewHolder
import com.fingermidia.mvvmproject2.viewmodel.main.StoreViewModel

class StoreActivity : AppCompatActivity() {

    lateinit var viewModel: StoreViewModel
    lateinit var binding: ActivityStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)
        binding = ActivityStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val store = intent.getSerializableExtra("store") as Store

        viewModel = ViewModelProvider(this).get(StoreViewModel::class.java)
        viewModel.setStore(store)

        viewModel.store.observe(this, { store ->
            binding.name.text = store.fantasyName
        })

    }
}