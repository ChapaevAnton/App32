package com.w4eret1ckrtb1tch.app32

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.*
import com.w4eret1ckrtb1tch.app32.databinding.ActivityMain323Binding
import kotlin.random.Random

fun getExRate(): Double {
    return 75.50
}


class MainActivity_32_3 : AppCompatActivity() {


    private lateinit var countDownTimer: CountDownTimer
    private lateinit var user1: User
    private lateinit var user2: UserObservable
    private lateinit var user3: UserObservable
    private lateinit var userObservable: ObservableField<UserObservable>


    // TODO: 22.08.2021 32.5. Data Binding Observables
    private var flag: ObservableBoolean = ObservableBoolean(true)
    private val client: ObservableField<Client> = ObservableField(Client("Nik", 10_000))
    private var clientList: ObservableList<Client> =
        ObservableArrayList<Client>().apply {
            addAll(
                arrayListOf(
                    Client("Maik", 1000),
                    Client("Mati", 2000),
                    Client("Mary", 3000)
                )
            )
        }

    private var clientMap: ObservableMap<Int, Client> = ObservableArrayMap<Int, Client>().apply {
        put(1, Client("Anton", 80_000))
        put(2, Client("Egor", 100_000))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMain323Binding>(
            this,
            R.layout.activity_main_32_3
        )

        // TODO: 22.08.2021  32.5. Data Binding Observables
        binding.client = client
        client.get()?.cash = 120
        binding.clientList = clientList

        clientList.add(Client("Ivan", 10_000))

        binding.clientMap = clientMap
        clientMap[3] = Client("Mak", 22_222)
        clientMap[3]?.cash = 88_888
        binding.index = 3

        // TODO: 23.08.2021 32.3-4
        user1 =
            User(
                50_000, arrayListOf(
                    Stock("Яндекс1", 5000, R.drawable.ic_baseline_account_box_24),
                    Stock("Mail.ru1", 10_000, R.drawable.ic_baseline_adb_24)
                )
            )
        user2 =
            UserObservable(
                "Anton",
                88_888, arrayListOf(
                    StockObservable("Яндекс2", 5000, R.drawable.ic_baseline_account_box_24),
                    StockObservable("Mail.ru2", 10_000, R.drawable.ic_baseline_adb_24)
                )
            )

        user3 =
            UserObservable(
                "Sergey",
                777_888, arrayListOf(
                    StockObservable("Яндекс3", 500001, R.drawable.ic_baseline_account_box_24),
                    StockObservable("Mail.ru3", 10_00001, R.drawable.ic_baseline_adb_24)
                )
            )

        userObservable = ObservableField(user2)

        //binding.user = user1
        binding.userObservable = userObservable
        binding.exRate = getExRate()
        binding.function = {
            flag.set(!flag.get())
            if (flag.get()) {
                countDownTimer.start()
            } else countDownTimer.cancel()
        }



        binding.flag = flag
        val adapter = userObservable.get()?.stockList?.let { StockAdapter(it) }
        binding.recyclerView.adapter = adapter
        val random = Random(System.currentTimeMillis())
        countDownTimer = object : CountDownTimer(10_000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
//                user1.cash += -1000 + random.nextInt(2000)
//                user1.stockList.forEach {
//                    it.price += (-0.1 * it.price).toInt() + random.nextInt((0.2 * it.price).toInt())
//                }
                // TODO: 23.08.2021 observable field
                val user: UserObservable? = userObservable.get()
                if (user != null) {
                    user.cash += -1000 + random.nextInt(2000)
                    user.stockList.forEach {
                        it.price += (-0.1 * it.price).toInt() + random.nextInt((0.2 * it.price).toInt())
                    }
                }
            }

            override fun onFinish() {
                countDownTimer.start()
            }
        }
        countDownTimer.start()

        // TODO: 23.08.2021 32.5.3
        binding.name.setOnClickListener {
            if (userObservable.get() == user2)
                userObservable.set(user3)
            else
                userObservable.set(user2)

            userObservable.get()?.stockList?.let {
                adapter?.data = it
                adapter?.notifyDataSetChanged()
            }
        }
    }
}