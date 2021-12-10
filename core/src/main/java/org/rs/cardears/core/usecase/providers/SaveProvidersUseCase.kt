package org.rs.cardears.core.usecase.providers

import org.rs.cardears.core.model.Provider

interface SaveProvidersUseCase {

    suspend operator fun invoke(providers: List<Provider>)

}