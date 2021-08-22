package com.w4eret1ckrtb1tch.app32

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import com.w4eret1ckrtb1tch.app32.databinding.ActivityMain323Binding
import kotlin.random.Random

fun getExRate(): Double {
    return 75.50
}


class MainActivity_32_3 : AppCompatActivity() {

    private lateinit var countDownTimer: CountDownTimer
    private var flag: ObservableBoolean = ObservableBoolean(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMain323Binding>(
            this,
            R.layout.activity_main_32_3
        )
        val user =
            User(
                50_000, arrayListOf(
                    Stock("Яндекс", 5000, R.drawable.ic_baseline_account_box_24),
                    Stock("Mail.ru", 10_000, R.drawable.ic_baseline_adb_24)
                )
            )
        binding.user = user
        binding.exRate = getExRate()
        binding.function = {
            flag.set(!flag.get())
            if (flag.get()) {
                countDownTimer.start()
            } else countDownTimer.cancel()
        }
        binding.flag = flag

        binding.recyclerView.adapter = StockAdapter(user.stockList)
        val random = Random(System.currentTimeMillis())
        countDownTimer = object : CountDownTimer(10_000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                user.cash += -1000 + random.nextInt(2000)
                user.stockList.forEach {
                    it.price += (-0.1 * it.price).toInt() + random.nextInt((0.2 * it.price).toInt())
                }
            }

            override fun onFinish() {
                countDownTimer.start()
            }
        }
        countDownTimer.start()
    }
}