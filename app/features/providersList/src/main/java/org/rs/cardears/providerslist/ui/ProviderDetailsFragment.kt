package org.rs.cardears.providerslist.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.rs.cardears.core.route.RouteActions
import org.rs.cardears.providerslist.R
import javax.inject.Inject

@AndroidEntryPoint
class ProviderDetailsFragment : Fragment(R.layout.provider_details_fragment) {


    @Inject
    lateinit var routeActions: RouteActions

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val next = requireActivity().findViewById<Button>(R.id.next_graph)
        next.setOnClickListener {
            routeActions.navigateToSchedule("")
        }
    }
}
