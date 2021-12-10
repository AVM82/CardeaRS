package org.rs.cardears.core.model

data class Appointment(
    val time: String? = null,
    var customer: Customer? = null
) {
    companion object {
        const val dateFormatPattern = "dd-MM-yyyy"
    }
}
