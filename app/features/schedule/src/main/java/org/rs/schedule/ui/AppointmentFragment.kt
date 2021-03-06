package org.rs.schedule.ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.rs.cardears.core.model.Appointment
import org.rs.cardears.core.route.RouteActions
import org.rs.schedule.R
import org.rs.schedule.adapter.AppointmentAdapter
import org.rs.schedule.databinding.AppointmentFragmentBinding
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class AppointmentFragment : Fragment(R.layout.appointment_fragment) {
    @Inject
    lateinit var routeActions: RouteActions

    private val args by navArgs<AppointmentFragmentArgs>()
    private val viewModel: AppointmentFragmentViewModal by viewModels()

    private val binding get() = requireNotNull(_binding)

    private var _binding: AppointmentFragmentBinding? = null

    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        AppointmentAdapter(AppointmentAdapter.OnClickListener {
            viewModel.setAppointment(
                uuid = args.uuid,
                date = Appointment.dateFormatPattern.getDateFormatString(),
                it
            )
        })
    }

    private val date: Calendar = Calendar.getInstance()

    private var changeDateListener = OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
        date.set(Calendar.YEAR, year)
        date.set(Calendar.MONTH, monthOfYear)
        date.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        setDate()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        AppointmentFragmentBinding.inflate(inflater).also { _binding = it }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getScheduleByDate(
            uuid = args.uuid,
            date = Appointment.dateFormatPattern.getDateFormatString()
        )
        views {
            timeList.adapter = adapter
        }

        addRepeatingJob(Lifecycle.State.CREATED) {
            viewModel.appointmentListFlow.onEach {
                adapter.submitList(it)
                views { emptyList.isVisible = it.isEmpty() }
            }.launchIn(lifecycleScope)
        }

        views {
            toolBarTitle.text = getString(R.string.appointment_tool_bar_title)
            setDate()
            currentDate.setOnClickListener {
                DatePickerDialog(
                    requireContext(),
                    changeDateListener,
                    date.get(Calendar.YEAR),
                    date.get(Calendar.MONTH),
                    date.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
            appointmentBackButton.setOnClickListener {
                routeActions.back()
            }
        }
    }

    private fun setDate() {
        views {
            currentDate.text = DateUtils.formatDateTime(
                requireContext(), date.timeInMillis,
                DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
            )
        }
        viewModel.getScheduleByDate(
            args.uuid,
            Appointment.dateFormatPattern.getDateFormatString()
        )
    }

    @SuppressLint("SimpleDateFormat")
    private fun String.getDateFormatString(): String {
        val format = SimpleDateFormat(this)
        return format.format(date.time)
    }

    private fun <T> views(block: AppointmentFragmentBinding.() -> T) = binding.block()
}
