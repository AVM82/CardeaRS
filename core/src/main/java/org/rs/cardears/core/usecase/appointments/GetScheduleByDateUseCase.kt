package org.rs.cardears.core.usecase.appointments

import org.rs.cardears.core.model.Appointment

interface GetScheduleByDateUseCase {
    suspend operator fun invoke(uuid: String, date: String, callback: (List<Appointment>) -> Unit)
}
