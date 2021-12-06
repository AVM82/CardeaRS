package org.rs.cardears.remotestorage.usecase

import com.google.firebase.ktx.Firebase
import org.rs.cardears.core.dataSource.ProvidersRemoteDataSource
import org.rs.cardears.core.model.Provider
import org.rs.cardears.core.usecase.providers.SyncProvidersUseCase
import org.rs.cardears.remotestorage.repository.ProviderRemoteRepository
import java.util.*
import javax.inject.Inject


class SyncProvidersUseCaseImpl @Inject constructor(private val datasource: ProvidersRemoteDataSource): SyncProvidersUseCase {
    override suspend fun invoke(): List<Provider> {
            return datasource.syncProviders().map {  }
//        return listOf(Provider(UUID.randomUUID(), "title", "short Desc", "DescriptionDescriptionDescriptionDescription"))
    }
}
