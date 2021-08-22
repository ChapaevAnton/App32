package com.w4eret1ckrtb1tch.app32

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.w4eret1ckrtb1tch.app32.databinding.ItemList323Binding

class StockAdapter(var data: List<Stock>) : RecyclerView.Adapter<StockAdapter.StockHolder>() {

    inner class StockHolder(var binding: ItemList323Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StockHolder(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_list_32_3,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StockHolder, position: Int) {
        holder.binding.stock = data[position]
        holder.binding.exRate = getExRate()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}