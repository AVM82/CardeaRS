package org.rs.cardears.localstorage.db

import androidx.room.Database
import androidx.room.RoomDatabase
import org.rs.cardears.localstorage.entity.ProviderEntity

@Database(
    entities = [ProviderEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CardeaDb :RoomDatabase() {
    abstract fun providersDao(): ProviderDao

    companion object {
        const val DATABASE_NAME = "cardea_db"
    }
}
