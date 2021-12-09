package org.rs.schedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.rs.cardears.core.model.Appointment
import org.rs.cardears.core.usecase.appointments.GetScheduleByDateUseCase
import javax.inject.Inject

@HiltViewModel
class AppointmentFragmentViewModal @Inject constructor(
    private val getScheduleByDateUseCase: GetScheduleByDateUseCase
) : ViewModel() {

    init {
        getScheduleByDate("160b0486-8804-4c0f-9b01-bbb3e2098534", "09-12-2021")
    }

    private val _appointmentListFlow = MutableStateFlow<List<Appointment>>(emptyList())

    var appointmentListFlow: Flow<List<Appointment>> = _appointmentListFlow

    fun getScheduleByDate(uuid: String, date: String) = viewModelScope.launch {
        getScheduleByDateUseCase.invoke(uuid, date) {
            _appointmentListFlow.value = it
        }
    }
}
