package com.iperovv.vkcourseproject.ui.screens.appdetailed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailedScreenViewModel
    @Inject
    constructor(
        private val appDetailedRepository: AppDetailedRepository,
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
