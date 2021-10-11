package com.fingermidia.mvvmproject2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fingermidia.mvvmproject2.databinding.ItemStoreBinding
import com.fingermidia.mvvmproject2.models.Store

class StoreAdapter(private val onItemClicked: (Store) -> Unit) :
    RecyclerView.Adapter<StoreViewHolder>() {

    private var list = mutableListOf<Store>()

    fun setStoreList(lives: List<Store>) {
        this.list = lives.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStoreBinding.inflate(inflater, parent, false)
        return StoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bind(list[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class StoreViewHolder(val binding: ItemStoreBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(store: Store, onItemClicked: (Store) -> Unit) {

        binding.name.text = store.fantasyName
        binding.address.text = store.address.plus(", ").plus(store.number)
        binding.category.text = store.category

        itemView.setOnClickListener {
            onItemClicked(store)
        }

    }

}