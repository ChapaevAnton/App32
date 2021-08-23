package com.w4eret1ckrtb1tch.app32

import androidx.annotation.DrawableRes
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableInt

class StockObservable(var name: String, _price: Int = 0, @DrawableRes val iconId: Int) {

    val priceObservable = ObservableInt(_price)
    var price = _price
        set(value) {
            field = value
            priceObservable.set(value)
        }
}