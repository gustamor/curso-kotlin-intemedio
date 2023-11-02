package com.example.horrorscope.ui.home.DetailActivity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horrorscope.databinding.ActivityDetailHoroscopeActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailHoroscopeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailHoroscopeActivityBinding
    private val detailsHoroscopeViewModel: DetailsHoroscopeViewModel by viewModels()
    private val args: DetailHoroscopeActivityArgs by navArgs();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHoroscopeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                detailsHoroscopeViewModel.uiState.collect {
                    when (it) {
                        is HoroscopeDetailState.Loading -> {
                            loadingState()
                        }

                        is HoroscopeDetailState.Error -> {
                            errorState()
                        }

                        is HoroscopeDetailState.Success -> {
                            succesState()
                        }
                    }
                }
            }
        }
    }

    private fun errorState() {

    }

    private fun succesState() {
        binding.tvBody.isVisible = true
        binding.pb.isVisible = false
    }

    private fun loadingState() {
        binding.pb.isVisible = true
        binding.tvBody.isVisible = false
    }
}