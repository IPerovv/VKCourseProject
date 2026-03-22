package com.iperovv.vkcourseproject.ui.screens.appdetailed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iperovv.vkcourseproject.data.AppDetailedRepositoryImpl
import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppDetailedScreenViewModel(
    private val appDetailedRepository: AppDetailedRepository = AppDetailedRepositoryImpl(),
) : ViewModel() {
    private val _state = MutableStateFlow<AppDetailedScreenState>(AppDetailedScreenState.Loading)
    val state: StateFlow<AppDetailedScreenState> = _state.asStateFlow()

    init {
        loadApp()
    }

    fun loadApp() {
        viewModelScope.launch {
            _state.value = AppDetailedScreenState.Loading
            runCatching {
                delay(2000L)
                val app = appDetailedRepository.getDetailedApp()
                _state.value = AppDetailedScreenState.Success(app)
            }.onFailure {
                // TODO Знаю, что это нечеловекочитаемо, но пусть временно будет так
                _state.value = AppDetailedScreenState.Error(it.message)
            }
        }
    }
}
