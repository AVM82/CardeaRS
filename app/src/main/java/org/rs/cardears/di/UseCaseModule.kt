package org.rs.cardears.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.rs.cardears.core.usecase.providers.GetProvidersUseCase
import org.rs.cardears.localstorage.usecase.providers.GetProvidersUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun getProvidersUseCase(impl: GetProvidersUseCaseImpl): GetProvidersUseCase

}