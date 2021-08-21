package com.w4eret1ckrtb1tch.app32.temp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.w4eret1ckrtb1tch.app32.R
import com.w4eret1ckrtb1tch.app32.databinding.ItemListBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    inner class MyHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() {
            binding.text1.text = "test"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyHolder(DataBindingUtil.inflate(inflater, R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}