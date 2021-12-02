package org.rs.cardears.core.dataSource

import org.rs.cardears.core.model.ProviderDTO
import kotlinx.coroutines.flow.Flow
import java.util.*

interface ProvidersLocalDataSource {

    suspend fun getAllProviders(): Flow<List<ProviderDTO>>

    suspend fun deleteAllProviders()

    suspend fun getProviderById(uuid: UUID): ProviderDTO?

    suspend fun insertAll(providers: List<ProviderDTO>)

}
