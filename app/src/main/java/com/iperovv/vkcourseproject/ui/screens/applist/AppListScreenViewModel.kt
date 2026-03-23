package com.iperovv.vkcourseproject.ui.screens.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iperovv.vkcourseproject.domain.AppSummaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListScreenViewModel @Inject constructor(
    private val appSummaryRepository: AppSummaryRepository,
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

    fun onRetry() {
        loadApps()
    }

    fun loadApps() {
        viewModelScope.launch {
            _state.value = AppListScreenState.Loading
            runCatching {
                val apps = appSummaryRepository.getApps()
                _state.value = AppListScreenState.Success(apps)
            }.onFailure {
                // TODO Знаю, что это нечеловекочитаемо, но пусть временно будет так
                _state.value = AppListScreenState.Error(it.message)
            }
        }
    }
}
