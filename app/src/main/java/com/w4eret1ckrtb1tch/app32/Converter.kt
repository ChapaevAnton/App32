package com.w4eret1ckrtb1tch.app32

import androidx.databinding.InverseMethod

object Converter {


    @JvmStatic
    fun stringToDouble(value: String): Double {
        return if (value.isNotEmpty()) value.toDouble() else 0.0
    }

    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double): String {
        return String.format("%1$.2f $.", value)
    }

    @JvmStatic
    fun rubleToDollar(ruble: Int, rate: Double): Double {
        return (ruble / rate)
    }

}