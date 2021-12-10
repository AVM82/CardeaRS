package org.rs.cardears.core.dataSource

import org.rs.cardears.core.model.Provider
import kotlinx.coroutines.flow.Flow
import java.util.*

interface ProvidersLocalDataSource {

    suspend fun getAllProviders(): Flow<List<Provider>>

    suspend fun deleteAllProviders()

    suspend fun getProviderById(uuid: UUID): Provider?

    suspend fun insertAll(providers: List<Provider>)

}
