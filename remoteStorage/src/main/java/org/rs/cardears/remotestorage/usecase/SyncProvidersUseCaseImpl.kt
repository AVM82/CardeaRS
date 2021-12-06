package org.rs.cardears.remotestorage.usecase

import kotlinx.coroutines.flow.Flow
import org.rs.cardears.core.Response
import org.rs.cardears.core.dataSource.ProvidersRemoteDataSource
import org.rs.cardears.core.usecase.providers.SyncProvidersUseCase
import javax.inject.Inject


class SyncProvidersUseCaseImpl @Inject constructor(private val datasource: ProvidersRemoteDataSource) :
    SyncProvidersUseCase {
    override suspend fun invoke(): Flow<Response> = datasource.syncProviders()
}
