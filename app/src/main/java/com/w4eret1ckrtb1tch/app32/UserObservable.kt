package com.w4eret1ckrtb1tch.app32

import androidx.databinding.*
import androidx.databinding.adapters.TextViewBindingAdapter

class UserObservable(_name: String, _cash: Int, _stockList: ArrayList<StockObservable>) {

    val nameObservable = ObservableField(_name)
    val name:String = _name

    val cashObservable = ObservableInt(_cash)
    var cash: Int = _cash
        set(value) {
            field = value
            cashObservable.set(value)
        }

    val stockListObservable = ObservableField(_stockList)
    var stockList: ArrayList<StockObservable> = _stockList
        set(value) {
            field = value
            stockListObservable.set(value)
        }
}