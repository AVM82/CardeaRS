package org.rs.cardears.core.dataSource

import org.rs.cardears.core.model.Provider

interface ProvidersRemoteDataSource {

    suspend fun syncProviders(): List<Provider>

}
