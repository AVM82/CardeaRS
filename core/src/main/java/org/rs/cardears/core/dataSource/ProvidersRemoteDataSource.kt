package org.rs.cardears.core.dataSource

import kotlinx.coroutines.flow.Flow
import org.rs.cardears.core.Response
import org.rs.cardears.core.model.Appointment

interface ProvidersRemoteDataSource {

    suspend fun syncProviders(): Flow<Response>
    suspend fun getScheduleByDate(uuid: String, date: String, callback: (List<Appointment>) -> Unit)

}
