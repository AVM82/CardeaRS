package org.rs.cardears.localstorage.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import org.rs.cardears.localstorage.entity.ProviderEntity


@Dao
interface ProviderDao {

    @Transaction
    @Query("DELETE FROM ${ProviderEntity.TABLE_NAME}")
    fun deleteAll(): Int

    @Insert(onConflict = REPLACE)
    fun insertAll(providers: List<ProviderEntity>)

    @Query("SELECT * FROM ${ProviderEntity.TABLE_NAME}")
    fun getAll(): Flow<List<ProviderEntity>>

    @Query("SELECT * FROM ${ProviderEntity.TABLE_NAME} WHERE ${ProviderEntity.PROVIDER_ID}=:uuid LIMIT 1")
    fun getProviderById(uuid: String): ProviderEntity?


}
