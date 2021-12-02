package org.rs.cardears.localstorage.entity

import org.rs.cardears.core.model.ProviderDTO
import java.util.*

internal fun ProviderEntity.toProviderDto() = ProviderDTO(
    uuid = UUID.fromString(this.uuid),
    title = this.title,
    shortDesc = this.shortDesc,
    description = description
)

internal fun ProviderDTO.toProviderEntity() = ProviderEntity(
    uuid = this.uuid.toString(),
    title = this.title,
    shortDesc = this.shortDesc,
    description = description
)
