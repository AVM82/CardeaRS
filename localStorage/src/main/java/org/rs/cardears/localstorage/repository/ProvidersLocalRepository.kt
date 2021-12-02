package org.rs.cardears.localstorage.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.rs.cardears.core.dataSource.ProvidersLocalDataSource
import org.rs.cardears.core.model.Provider
import org.rs.cardears.localstorage.db.ProviderDao
import org.rs.cardears.localstorage.entity.toProviderDto
import org.rs.cardears.localstorage.entity.toProviderEntity
import java.util.*
import javax.inject.Inject

class ProvidersLocalRepository @Inject constructor(private val providerDao: ProviderDao) :
    ProvidersLocalDataSource {
    override suspend fun getAllProviders(): Flow<List<Provider>> =
        providerDao.getAll().map { it.map { entity -> entity.toProviderDto() } }

    override suspend fun deleteAllProviders() {
        providerDao.deleteAll()
    }

    override suspend fun getProviderById(uuid: UUID): Provider? =
        providerDao.getProviderById(uuid = uuid.toString())?.toProviderDto()

    override suspend fun insertAll(providers: List<Provider>) {
        providerDao.insertAll(providers = providers.map { it.toProviderEntity() } )
    }
}
