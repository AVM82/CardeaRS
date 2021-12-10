package org.rs.cardears.remotestorage.usecase

import org.rs.cardears.core.dataSource.ProvidersRemoteDataSource
import org.rs.cardears.core.usecase.appointments.SetAppointmentUseCase
import javax.inject.Inject

class SetAppointmentUseCaseImpl @Inject constructor(private val datasource: ProvidersRemoteDataSource) :
    SetAppointmentUseCase {
    override suspend fun invoke(uuid: String, date: String, time: String, callback: () -> Unit) =
        datasource.setAppointment(uuid, date, time, callback)
}
