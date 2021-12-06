package org.rs.cardears.remotestorage.di

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.rs.cardears.core.dataSource.ProvidersRemoteDataSource
import org.rs.cardears.remotestorage.repository.ProviderRemoteRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteStorageModule {

    @Provides
    @Singleton
    fun provideProvidersRemoteRepository(): ProvidersRemoteDataSource =
        ProviderRemoteRepository(Firebase.firestore)

    companion object {
        const val PROVIDERS_COLLECTION_NAME = "providers"
    }

}
