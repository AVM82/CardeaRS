package org.rs.cardears.localstorage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ProviderEntity.TABLE_NAME)
data class ProviderEntity(

    @PrimaryKey
    @ColumnInfo(name = PROVIDER_ID)
    val uuid: String = "",

    @ColumnInfo(name = TITLE)
    val title: String = "",

    @ColumnInfo(name = SHORT_DESCRIPTION)
    val shortDesc: String?,

    @ColumnInfo(name = DESCRIPTION)
    val description: String?

) {

    companion object {
        const val TABLE_NAME = "providers"

        const val PROVIDER_ID = "uuid"
        const val TITLE = "title"
        const val SHORT_DESCRIPTION = "short_desc"
        const val DESCRIPTION = "description"
    }

}
