package org.rs.cardears.localstorage.usecase.providers

import kotlinx.coroutines.flow.Flow
import org.rs.cardears.core.dataSource.ProvidersLocalDataSource
import org.rs.cardears.core.model.Provider
import org.rs.cardears.core.usecase.providers.GetProvidersUseCase
import javax.inject.Inject

class GetProvidersUseCaseImpl @Inject constructor(
    private val providersLocalDataSource: ProvidersLocalDataSource
) : GetProvidersUseCase {
    override suspend fun invoke(): Flow<List<Provider>> = providersLocalDataSource.getAllProviders()
}
