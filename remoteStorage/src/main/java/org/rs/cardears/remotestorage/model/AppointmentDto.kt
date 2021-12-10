package org.rs.cardears.remotestorage.model

import org.rs.cardears.core.model.Appointment

data class AppointmentDto(
    val date: String? = null,
    val uuid: String? = null,
    val appointment: List<Appointment>? = null
)
