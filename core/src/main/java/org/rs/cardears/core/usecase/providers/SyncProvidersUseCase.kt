package org.rs.cardears.core.usecase.providers

import kotlinx.coroutines.flow.Flow
import org.rs.cardears.core.Response
import org.rs.cardears.core.model.Provider

interface SyncProvidersUseCase {

    suspend operator fun invoke(): Flow<Response>

}
