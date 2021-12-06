package org.rs.cardears.core.usecase.providers

import org.rs.cardears.core.model.Provider

interface SyncProvidersUseCase {

    suspend operator fun invoke(): List<Provider>

}
