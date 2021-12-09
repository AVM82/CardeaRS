package org.rs.cardears.remotestorage.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import org.rs.cardears.core.Response
import org.rs.cardears.core.dataSource.ProvidersRemoteDataSource
import org.rs.cardears.core.model.Appointment
import org.rs.cardears.core.model.Customer
import org.rs.cardears.remotestorage.di.RemoteStorageModule
import org.rs.cardears.remotestorage.model.ProviderDto
import org.rs.cardears.remotestorage.model.toProvider

class ProviderRemoteRepository(private var db: FirebaseFirestore) :
    ProvidersRemoteDataSource {
    override suspend fun syncProviders(): Flow<Response> = flow {
        try {
            emit(Response.Loading(true))
            val snapshot = db.collection(RemoteStorageModule.PROVIDERS_COLLECTION_NAME)
                .get().await()
            if (!snapshot.metadata.isFromCache) {
                emit(
                    Response.Success(
                        snapshot.toList().map {
                            it.toObject<ProviderDto>().toProvider()
                        }.toList()
                    )
                )
            } else {
                emit(Response.Error("Remote DB is unavailable"))
            }

        } catch (e: FirebaseFirestoreException) {
            emit(Response.Error("Remote DB is unavailable"))
        } finally {
            delay(500)
            emit(Response.Loading(false))
        }
    }

    override suspend fun getScheduleByDate(date: String) =
        listOf(
            Appointment(
                time = "09:00",
                null
            ),
            Appointment(
                time = "10:00",
                Customer(name = "Iavn", phone = "0503333333")
            ),
            Appointment(
                time = "11:00",
                null
            )
        )
}
