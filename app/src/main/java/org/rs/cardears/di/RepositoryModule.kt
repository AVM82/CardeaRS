package org.rs.cardears.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import org.rs.cardears.core.dataSource.ProvidersLocalDataSource
import org.rs.cardears.localstorage.repository.ProvidersLocalRepository
//
@Module
@InstallIn(SingletonComponent::class)
abstract class ProviderRepositoryModule {

    @Binds
    abstract fun provideProviderRepository(providersLocalRepository: ProvidersLocalRepository): ProvidersLocalDataSource
}
//@Module
//@InstallIn(SingletonComponent::class)
//object ProviderRepositoryModule {
//
//    @Provides
//    fun provideProviderRepository(providersLocalRepository: ProvidersLocalRepository): ProvidersLocalDataSource = providersLocalRepository
//}
