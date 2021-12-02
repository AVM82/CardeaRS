package org.rs.cardears.localstorage.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.rs.cardears.localstorage.db.CardeaDb
import org.rs.cardears.localstorage.db.ProviderDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalStorageModule {

    @Singleton
    @Provides
    fun provideRoomDb(application: Application): CardeaDb = Room.databaseBuilder(
        application,
        CardeaDb::class.java,
        CardeaDb.DATABASE_NAME
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

    @Provides
    fun provideProviderDao(db: CardeaDb): ProviderDao = db.providersDao()

}
