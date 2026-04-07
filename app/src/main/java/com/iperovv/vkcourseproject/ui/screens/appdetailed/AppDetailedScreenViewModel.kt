package com.iperovv.vkcourseproject.ui.screens.appdetailed

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iperovv.vkcourseproject.domain.usecase.ObserveAppDetailedUseCase
import com.iperovv.vkcourseproject.domain.usecase.RefreshAppDetailedUseCase
import com.iperovv.vkcourseproject.domain.usecase.ToggleWishlistUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailedScreenViewModel @Inject constructor(
    private val observeAppDetailedUseCase: ObserveAppDetailedUseCase,
    private val refreshAppDetailedUseCase: RefreshAppDetailedUseCase,
    private val toggleWishlistUseCase: ToggleWishlistUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val appId: String = checkNotNull(savedStateHandle["appId"])

    private val _state = MutableStateFlow<AppDetailedScreenState>(AppDetailedScreenState.Loading)
    val state: StateFlow<AppDetailedScreenState> = _state.asStateFlow()

    init {
        observeDetailedApp()
        refreshData()
    }

    fun refreshData() {
        viewModelScope.launch {
            if (_state.value !is AppDetailedScreenState.Success) {
                _state.value = AppDetailedScreenState.Loading
            }
            runCatching {
                refreshAppDetailedUseCase(appId)
            }.onFailure { error ->
                if (_state.value is AppDetailedScreenState.Success) {
                    // Можно показать снек, что видим возможно устаревшие данные
                } else {
                    _state.value = AppDetailedScreenState.Error(error.message)
                }
            }
        }
    }

    fun toggleWishlist() {
        viewModelScope.launch {
            toggleWishlistUseCase(appId)
        }
    }

    private fun observeDetailedApp() {
        viewModelScope.launch {
            observeAppDetailedUseCase(appId)
                .catch { error ->
                    _state.value = AppDetailedScreenState.Error(error.message)
                }.collect { app ->
                    _state.value = AppDetailedScreenState.Success(app)
                }
        }
    }
}
