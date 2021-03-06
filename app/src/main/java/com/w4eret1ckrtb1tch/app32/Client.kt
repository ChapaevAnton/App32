package com.w4eret1ckrtb1tch.app32

import android.widget.TextView
import androidx.databinding.BindingAdapter

data class Client(val name: String, var cash: Int) {

    companion object {
        @BindingAdapter("app:client_list")
        @JvmStatic
        fun clientToString(view: TextView, client:Client) {
            view.text = client.toString()
        }
    }


}