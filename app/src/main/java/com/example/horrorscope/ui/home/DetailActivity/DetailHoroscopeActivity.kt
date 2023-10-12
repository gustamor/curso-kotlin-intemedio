package com.example.horrorscope.ui.home.DetailActivity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.horrorscope.databinding.ActivityDetailHoroscopeActivityBinding
import com.example.horrorscope.ui.horoscope.HoroscopeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailHoroscopeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailHoroscopeActivityBinding
    private val horoscopeViewModel: HoroscopeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHoroscopeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {

    }
}