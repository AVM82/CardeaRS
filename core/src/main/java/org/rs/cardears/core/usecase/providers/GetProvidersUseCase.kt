package org.rs.cardears.core.usecase.providers

import kotlinx.coroutines.flow.Flow
import org.rs.cardears.core.model.Provider

interface GetProvidersUseCase {

    suspend operator fun invoke(): Flow<List<Provider>>

}
