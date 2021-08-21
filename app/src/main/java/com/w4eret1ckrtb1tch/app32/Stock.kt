package com.w4eret1ckrtb1tch.app32

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter

class Stock(var name: String, private var _price: Int = 0, @DrawableRes val iconId: Int) :
    BaseObservable() {

    @get:Bindable
    var price = _price
        set(value) {
            field = value
            notifyPropertyChanged(BR.price)
        }


    companion object {
        @BindingAdapter("imageId")
        @JvmStatic
        fun loadImage(view: ImageView, iconId: Int) {
            view.setImageResource(iconId)
        }
    }

}