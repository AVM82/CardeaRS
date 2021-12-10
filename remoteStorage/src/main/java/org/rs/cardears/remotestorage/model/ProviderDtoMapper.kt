package org.rs.cardears.remotestorage.model

import org.rs.cardears.core.model.Provider
import java.util.*

internal fun ProviderDto.toProvider() = Provider(
    uuid = UUID.fromString(this.uuid),
    title = this.title.orEmpty(),
    shortDesc = this.shortDesc,
    description = this.description,
    imageUrl = this.imageUrl
)

internal fun Provider.toProviderDto() = ProviderDto(
    uuid = this.uuid.toString(),
    title = this.title,
    shortDesc = this.shortDesc,
    description = this.description,
    imageUrl = this.imageUrl
)