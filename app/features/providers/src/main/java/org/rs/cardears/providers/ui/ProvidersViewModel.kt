package org.rs.cardears.providers.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.rs.cardears.core.Response
import org.rs.cardears.core.model.Provider
import org.rs.cardears.core.usecase.providers.DeleteLocalProvidersUseCase
import org.rs.cardears.core.usecase.providers.GetProvidersUseCase
import org.rs.cardears.core.usecase.providers.SaveProvidersUseCase
import org.rs.cardears.core.usecase.providers.SyncProvidersUseCase
import org.rs.cardears.providers.state.ProvidersListState
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ProvidersViewModel @Inject constructor(
    var getProvidersUseCase: GetProvidersUseCase,
    var saveProvidersUseCase: SaveProvidersUseCase,
    var deleteLocalProvidersUseCase: DeleteLocalProvidersUseCase,
    var syncProvidersUseCase: SyncProvidersUseCase
) :
    ViewModel() {

    private val _providersListFlow = MutableStateFlow(ProvidersListState.Success(emptyList()))
    val providersListFlow: Flow<ProvidersListState> = _providersListFlow

    private val _syncProvidersStateFlow = MutableStateFlow<Response>(Response.Idle)
    val syncProvidersStateFlow: Flow<Response> = _syncProvidersStateFlow

    fun fetchProviders() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                saveProvidersUseCase.invoke(
                    listOf(
                        Provider(
                            UUID.randomUUID(),
                            "Title",
                            "ShortDesc",
                            "",
                            ""
                        )
                    )
                )
                getProvidersUseCase().onEach {
                    _providersListFlow.value = ProvidersListState.Success(it)
                }.launchIn(viewModelScope)
                syncProviders()
            } catch (e: Exception) {
                e.message?.let { ProvidersListState.Failed(it) }
            }
        }
    }

    suspend fun syncProviders() = syncProvidersUseCase.invoke().onEach {
        _syncProvidersStateFlow.value = it
    }.launchIn(viewModelScope)

    fun updateLocalProviderStorage(newData: List<Provider>) {
        Log.d("NEW", newData.toString())
        viewModelScope.launch(Dispatchers.IO) {
            deleteLocalProvidersUseCase()
            if (newData.isNotEmpty()) {
                saveProvidersUseCase(newData)
            }
        }

    }

//        when(val providerFbResponse = syncProvidersUseCase()) {
//            is Response.Success -> {
//                deleteLocalProvidersUseCase()
//                saveProvidersUseCase(providerFbResponse)
//            }
//            is Error -> Log.d()
//        }

}
