package org.rs.cardears.localstorage.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.rs.cardears.core.dataSource.ProvidersLocalDataSource
import org.rs.cardears.localstorage.repository.ProvidersLocalRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class ProvidersModule {

    @Binds
    abstract fun provideProvidersLocalDataSource(impl: ProvidersLocalRepository): ProvidersLocalDataSource

}