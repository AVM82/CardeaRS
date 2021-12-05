package org.rs.cardears.providers.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.rs.cardears.core.model.Provider
import org.rs.cardears.core.usecase.providers.GetProvidersUseCase
import org.rs.cardears.core.usecase.providers.SaveProvidersUseCase
import org.rs.cardears.providers.state.ProvidersListState
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ProvidersViewModel @Inject constructor(
    var getProvidersUseCase: GetProvidersUseCase,
    var saveProvidersUseCase: SaveProvidersUseCase
) :
    ViewModel() {

    private val _providersListFlow = MutableStateFlow(ProvidersListState.Success(emptyList()))
    val providersListFlow: Flow<ProvidersListState> = _providersListFlow

    fun fetchProviders() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getProvidersUseCase().onEach {
                    _providersListFlow.value = ProvidersListState.Success(it)
                }.launchIn(viewModelScope)
                delay(3000)
                saveProvidersUseCase.invoke(
                    listOf(
                        Provider(
                            uuid = UUID.randomUUID(),
                            title = "qwerty",
                            shortDesc = "description",
                            description = null

                        )
                    )
                )
            } catch (e: Exception) {
                e.message?.let { ProvidersListState.Failed(it) }
            }
        }
    }
}
