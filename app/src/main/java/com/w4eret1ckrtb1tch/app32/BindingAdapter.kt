package com.w4eret1ckrtb1tch.app32

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @BindingAdapter(value = ["color1", "color2", "color3"], requireAll = true)
    @JvmStatic
    fun setBackgroundGradient(view: ImageView, color1: Int, color2: Int, color3: Int) {
        val colors = intArrayOf(color1, color2, color3)
        val gradientDrawable = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, colors)
        gradientDrawable.cornerRadius = 0f
        view.background = gradientDrawable
    }

    @BindingAdapter(value = ["color1", "color2", "color3"], requireAll = true)
    @JvmStatic
    fun setBackgroundGradient(view: ImageView, color1: String, color2: String, color3: String) {
        val colors =
            intArrayOf(Color.parseColor(color1), Color.parseColor(color2), Color.parseColor(color3))
        val gradientDrawable = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors)
        gradientDrawable.cornerRadius = 0f
        view.background = gradientDrawable
    }
}