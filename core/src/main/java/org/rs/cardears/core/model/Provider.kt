package org.rs.cardears.core.model

import java.util.*

data class Provider(
    val uuid: UUID,
    val title: String,
    val shortDesc: String? = null,
    val description: String? = null,
    val imageUrl: String? = null
)
