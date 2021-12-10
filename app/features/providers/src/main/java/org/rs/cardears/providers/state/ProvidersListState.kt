package org.rs.cardears.providers.state

import org.rs.cardears.core.model.Provider

sealed class ProvidersListState {
    data class Success(val providers: List<Provider>) : ProvidersListState()
    data class Failed(val errorMsg: String) : ProvidersListState()
}
