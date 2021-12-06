package org.rs.cardears.localstorage.usecase.providers

import org.rs.cardears.core.dataSource.ProvidersLocalDataSource
import org.rs.cardears.core.usecase.providers.DeleteLocalProvidersUseCase
import javax.inject.Inject

class DeleteLocalProvidersUseCaseImpl @Inject constructor(
    private val providersLocalDataSource: ProvidersLocalDataSource
) : DeleteLocalProvidersUseCase {
    override suspend fun invoke() {
        providersLocalDataSource.deleteAllProviders()
    }
}
