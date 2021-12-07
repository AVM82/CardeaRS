package org.rs.cardears.providers.ui.providersDetails

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import org.rs.cardears.core.route.RouteActions
import org.rs.cardears.providers.R
import javax.inject.Inject

@AndroidEntryPoint
class ProviderDetailsFragment : Fragment(R.layout.provider_details_fragment) {


    @Inject
    lateinit var routeActions: RouteActions

    private val args by navArgs<ProviderDetailsFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val next = requireActivity().findViewById<Button>(R.id.next_graph)
        Log.d("TAG", args.uuid)
        next.setOnClickListener {
            routeActions.navigateToSchedule("")
        }
    }
}
