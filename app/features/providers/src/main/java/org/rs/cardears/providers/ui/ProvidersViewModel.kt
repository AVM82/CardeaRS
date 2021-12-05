package org.rs.cardears.providers.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.rs.cardears.core.model.Provider
import org.rs.cardears.core.usecase.providers.GetProvidersUseCase
import javax.inject.Inject

@HiltViewModel
class ProvidersViewModel @Inject constructor(var getProvidersUseCase: GetProvidersUseCase) :
    ViewModel() {

    private val _providersListFlow = MutableStateFlow<List<Provider>>(emptyList())
    val providersListFlow: Flow<List<Provider>> = _providersListFlow

    init {
        fetchProviders()
    }

    fun fetchProviders() {
        viewModelScope.launch(Dispatchers.IO) {
            getProvidersUseCase().onEach { _providersListFlow.value = it }.launchIn(viewModelScope)
        }
    }
}
