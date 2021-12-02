package org.rs.cardears.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import org.rs.cardears.core.dataSource.ProvidersLocalDataSource
import org.rs.cardears.localstorage.repository.ProvidersLocalRepository
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class ProviderRepositoryModule {

    @Provides
    fun provideProviderRepository(providersLocalRepository: ProvidersLocalRepository): ProvidersLocalDataSource =
        providersLocalRepository

}
