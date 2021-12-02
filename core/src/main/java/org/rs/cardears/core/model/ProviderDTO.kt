package org.rs.cardears.core.model

import java.util.*

data class ProviderDTO(
    val uuid: UUID,
    val title: String,
    val shortDesc: String?,
    val description: String?
    )
