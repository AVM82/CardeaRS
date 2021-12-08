package org.rs.schedule

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.rs.cardears.core.route.RouteActions
import org.rs.schedule.databinding.AppointmentFragmentBinding
import java.util.*
import javax.inject.Inject


@AndroidEntryPoint
class AppointmentFragment : Fragment(R.layout.appointment_fragment) {
    @Inject
    lateinit var routeActions: RouteActions

    private val binding get() = requireNotNull(_binding)
    private var _binding: AppointmentFragmentBinding? = null

    private val date: Calendar = Calendar.getInstance()

    private var changeDateListener = OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
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
    }

    private fun <T> views(block: AppointmentFragmentBinding.() -> T) = binding.block()

}