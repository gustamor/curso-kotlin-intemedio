package com.example.horrorscope.ui.home.DetailActivity

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsHoroscopeViewModel @Inject constructor() : ViewModel() {

    private var _UiState = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val UiState: StateFlow<HoroscopeDetailState> = _UiState
}