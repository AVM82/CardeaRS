package org.rs.cardears.remotestorage.repository

import com.google.firebase.firestore.FirebaseFirestore
import org.rs.cardears.core.dataSource.ProvidersRemoteDataSource
import org.rs.cardears.core.model.Provider
import org.rs.cardears.remotestorage.model.ProviderDto
import javax.inject.Inject

class ProviderRemoteRepository @Inject constructor(db: FirebaseFirestore) : ProvidersRemoteDataSource {
    override suspend fun syncProviders(): List<Provider> {
        TODO("Not yet implemented")
    }
}
