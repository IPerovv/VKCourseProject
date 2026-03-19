package com.iperovv.vkcourseproject.ui.screens.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iperovv.vkcourseproject.data.AppSummaryRepositoryImpl
import com.iperovv.vkcourseproject.domain.AppSummaryRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppListScreenViewModel(
    private val appSummaryRepository: AppSummaryRepository = AppSummaryRepositoryImpl(),
) : ViewModel() {
    private val _state = MutableStateFlow<AppListScreenState>(AppListScreenState.Loading)
    val state: StateFlow<AppListScreenState> = _state.asStateFlow()

    private val _isSnackShown = MutableStateFlow<Boolean>(false)
    val isSnackShown: StateFlow<Boolean> = _isSnackShown

    init {
        loadApps()
    }

    fun onSnackShown() {
        _isSnackShown.value = true
    }

    fun loadApps() {
        viewModelScope.launch {
            _state.value = AppListScreenState.Loading
            runCatching {
                delay(2000L)
                val apps = appSummaryRepository.getApps()
                _state.value = AppListScreenState.Success(apps)
            }.onFailure {
                // TODO Знаю, что это нечеловекочитаемо, но пусть временно будет так
                _state.value = AppListScreenState.Error(it.message)
            }
        }
    }
}
