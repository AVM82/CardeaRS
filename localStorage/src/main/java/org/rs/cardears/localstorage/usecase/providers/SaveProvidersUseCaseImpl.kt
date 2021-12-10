package org.rs.cardears.localstorage.usecase.providers

import org.rs.cardears.core.dataSource.ProvidersLocalDataSource
import org.rs.cardears.core.model.Provider
import org.rs.cardears.core.usecase.providers.SaveProvidersUseCase
import javax.inject.Inject

class SaveProvidersUseCaseImpl @Inject constructor(
    private val providersLocalDataSource: ProvidersLocalDataSource
) : SaveProvidersUseCase {
    override suspend fun invoke(providers: List<Provider>) {
        providersLocalDataSource.insertAll(providers)
    }
}