package com.example.horrorscope.ui.home.DetailActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horrorscope.domain.model.usecases.GetPredictionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsHoroscopeViewModel @Inject constructor(
    private val getPredictionsUseCase: GetPredictionsUseCase
) : ViewModel() {

    private var _UiState = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val UiState: StateFlow<HoroscopeDetailState> = _UiState

    fun getHoroscope(sign: String) {

        viewModelScope.launch {
            _UiState.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO) {
                getPredictionsUseCase(sign)
            }
            if (result != null) {
                _UiState.value = HoroscopeDetailState.Success(result.horoscope, result.sign)
            } else {
                _UiState.value = HoroscopeDetailState.Error("No ha cargado en meses")
            }
        }


    }
}