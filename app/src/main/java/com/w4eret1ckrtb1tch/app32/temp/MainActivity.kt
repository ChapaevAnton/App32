package com.w4eret1ckrtb1tch.app32.temp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.w4eret1ckrtb1tch.app32.R
import com.w4eret1ckrtb1tch.app32.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        );

        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, OneFragment())
            .commit()
    }
}