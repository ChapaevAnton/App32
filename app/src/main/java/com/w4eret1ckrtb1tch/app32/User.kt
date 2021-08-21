package com.w4eret1ckrtb1tch.app32

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class User(private val _cash: Int, val stockList: ArrayList<Stock>) : BaseObservable() {

    @get:Bindable
    var cash: Int = _cash
        set(value) {
            field = value
            notifyPropertyChanged(BR.cash)
        }

}