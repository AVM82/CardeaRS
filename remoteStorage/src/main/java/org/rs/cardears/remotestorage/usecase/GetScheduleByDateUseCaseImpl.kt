package org.rs.cardears.remotestorage.usecase

import org.rs.cardears.core.dataSource.ProvidersRemoteDataSource
import org.rs.cardears.core.model.Appointment
import org.rs.cardears.core.usecase.appointments.GetScheduleByDateUseCase
import javax.inject.Inject

class GetScheduleByDateUseCaseImpl @Inject constructor(private val datasource: ProvidersRemoteDataSource) :
    GetScheduleByDateUseCase {
    override suspend fun invoke(uuid: String, date: String, callback: (List<Appointment>) -> Unit) =
        datasource.getScheduleByDate(uuid, date, callback)
}
