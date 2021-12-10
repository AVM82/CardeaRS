package org.rs.cardears.localstorage.entity

import org.rs.cardears.core.model.Provider
import java.util.*

internal fun ProviderEntity.toProvider() = Provider(
    uuid = UUID.fromString(this.uuid),
    title = this.title,
    shortDesc = this.shortDesc,
    description = this.description,
    imageUrl = this.imageUrl
)

internal fun Provider.toProviderEntity() = ProviderEntity(
    uuid = this.uuid.toString(),
    title = this.title,
    shortDesc = this.shortDesc,
    description = this.description,
    imageUrl = this.imageUrl
)
