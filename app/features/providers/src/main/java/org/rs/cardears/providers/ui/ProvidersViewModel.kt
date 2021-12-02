package org.rs.cardears.providers.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.rs.cardears.core.dataSource.ProvidersLocalDataSource
import org.rs.cardears.core.model.Provider
import javax.inject.Inject

class ProvidersViewModel @Inject constructor(private val providersLocalDataSource: ProvidersLocalDataSource) : ViewModel() {

    private val _providersListFlow = MutableStateFlow<List<Provider>>(emptyList())
    val providersListFlow: Flow<List<Provider>> = _providersListFlow

    fun fetchProviders() {
        providersLocalDataSource.getAllProviders().onEach { _providersListFlow.value = it }.launchIn(viewModelScope)
    }

}
