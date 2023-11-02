package com.example.horrorscope.ui.home.DetailActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horrorscope.domain.model.HoroscopeModel
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

    private var _uiState = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val uiState: StateFlow<HoroscopeDetailState> = _uiState

    lateinit var horoscope: HoroscopeModel
    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign
        viewModelScope.launch {
            _uiState.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO) {
                getPredictionsUseCase(sign.name)
            }
            if (result != null) {
                _uiState.value = HoroscopeDetailState.Success(result.horoscope,
                                                            result.sign,
                                                            horoscopeModel = horoscope)
            } else {
                _uiState.value = HoroscopeDetailState.Error("No ha cargado en meses")
            }
        }


    }
}