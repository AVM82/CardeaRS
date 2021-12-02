package org.rs.cardears.localstorage.entity

import org.rs.cardears.core.model.Provider
import java.util.*

internal fun ProviderEntity.toProviderDto() = Provider(
    uuid = UUID.fromString(this.uuid),
    title = this.title,
    shortDesc = this.shortDesc,
    description = description
)

internal fun Provider.toProviderEntity() = ProviderEntity(
    uuid = this.uuid.toString(),
    title = this.title,
    shortDesc = this.shortDesc,
    description = description
)
