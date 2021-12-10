package org.rs.schedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.rs.cardears.core.model.Appointment
import org.rs.cardears.core.usecase.appointments.GetScheduleByDateUseCase
import org.rs.cardears.core.usecase.appointments.SetAppointmentUseCase
import javax.inject.Inject

@HiltViewModel
class AppointmentFragmentViewModal @Inject constructor(
    private val getScheduleByDateUseCase: GetScheduleByDateUseCase,
    private val setAppointmentUseCase: SetAppointmentUseCase
) : ViewModel() {

    private val _appointmentListFlow = MutableStateFlow<List<Appointment>>(emptyList())

    var appointmentListFlow: Flow<List<Appointment>> = _appointmentListFlow

    fun getScheduleByDate(uuid: String, date: String) = viewModelScope.launch {
        getScheduleByDateUseCase.invoke(uuid, date) {
            _appointmentListFlow.value = it
        }
    }

    fun setAppointment(uuid: String, date: String, appointment: Appointment) {
        viewModelScope.launch {
            setAppointmentUseCase.invoke(
                uuid = uuid,
                date = date,
                time = appointment.time ?: ""
            ) {
                getScheduleByDate(uuid, date)
            }
        }
    }
}
