package org.rs.schedule

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.rs.cardears.core.route.RouteActions
import javax.inject.Inject

@AndroidEntryPoint
class ScheduleFragment : Fragment(R.layout.schedule_fragment) {
    @Inject
    lateinit var routeActions: RouteActions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requireActivity().onBackPressedDispatcher.addCallback(this) {
//            routeActions.back()
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = requireActivity().findViewById<Button>(R.id.btn)
        button.setOnClickListener {
            routeActions.back()
        }

    }

}
