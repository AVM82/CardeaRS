package org.rs.cardears.core.usecase.appointments

interface SetAppointmentUseCase {
    suspend operator fun invoke(uuid: String, date: String, time: String, callback: () -> Unit)
}
