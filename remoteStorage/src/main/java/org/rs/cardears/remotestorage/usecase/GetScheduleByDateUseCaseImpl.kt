package org.rs.cardears.remotestorage.usecase

import kotlinx.coroutines.flow.Flow
import org.rs.cardears.core.Response
import org.rs.cardears.core.dataSource.ProvidersRemoteDataSource
import org.rs.cardears.core.model.Appointment
import org.rs.cardears.core.usecase.appointments.GetScheduleByDateUseCase
import javax.inject.Inject

class GetScheduleByDateUseCaseImpl @Inject constructor(private val datasource: ProvidersRemoteDataSource) :
    GetScheduleByDateUseCase {
    override suspend fun invoke(date: String): List<Appointment> = datasource.getScheduleByDate(date)
}
