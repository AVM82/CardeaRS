package org.rs.cardears.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.rs.cardears.core.usecase.appointments.GetScheduleByDateUseCase
import org.rs.cardears.core.usecase.providers.DeleteLocalProvidersUseCase
import org.rs.cardears.core.usecase.providers.GetProvidersUseCase
import org.rs.cardears.core.usecase.providers.SaveProvidersUseCase
import org.rs.cardears.core.usecase.providers.SyncProvidersUseCase
import org.rs.cardears.localstorage.usecase.providers.DeleteLocalProvidersUseCaseImpl
import org.rs.cardears.localstorage.usecase.providers.GetProvidersUseCaseImpl
import org.rs.cardears.localstorage.usecase.providers.SaveProvidersUseCaseImpl
import org.rs.cardears.remotestorage.usecase.GetScheduleByDateUseCaseImpl
import org.rs.cardears.remotestorage.usecase.SyncProvidersUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun getProvidersUseCase(impl: GetProvidersUseCaseImpl): GetProvidersUseCase

    @Binds
    abstract fun saveProvidersUseCase(impl: SaveProvidersUseCaseImpl): SaveProvidersUseCase

    @Binds
    abstract fun deleteLocalProvidersUseCase(impl: DeleteLocalProvidersUseCaseImpl): DeleteLocalProvidersUseCase

    @Binds
    abstract fun syncProvidersUseCase(impl: SyncProvidersUseCaseImpl): SyncProvidersUseCase

    @Binds
    abstract fun getScheduleByDateUseCase(impl: GetScheduleByDateUseCaseImpl): GetScheduleByDateUseCase

}
