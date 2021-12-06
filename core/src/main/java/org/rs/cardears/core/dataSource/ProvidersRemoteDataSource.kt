package org.rs.cardears.core.dataSource

import kotlinx.coroutines.flow.Flow
import org.rs.cardears.core.Response

interface ProvidersRemoteDataSource {

    suspend fun syncProviders(): Flow<Response>

}
