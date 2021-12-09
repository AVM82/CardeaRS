package org.rs.cardears.core.model

data class Schedule(
    val uuid: String,
    val date: String,
    val appointment: List<Appointment>
)
