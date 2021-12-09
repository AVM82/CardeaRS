package org.rs.cardears.providers.ui.providersDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import org.rs.cardears.core.route.RouteActions
import org.rs.cardears.providers.databinding.ProviderDetailsFragmentBinding
import org.rs.cardears.providers.helpers.getDefaultRequestOptions
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class ProviderDetailsFragment : Fragment() {

    @Inject
    lateinit var routeActions: RouteActions

    private val args by navArgs<ProviderDetailsFragmentArgs>()
    private val binding get() = requireNotNull(_binding)
    private var _binding: ProviderDetailsFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ProviderDetailsFragmentBinding.inflate(inflater).also { _binding = it }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views {
            providerDetailsBackButton.setOnClickListener {
                routeActions.back()
            }
            providerTitle.text = args.title
            providerDesc.text = args.desc
            Glide
                .with(this@ProviderDetailsFragment)
                .load(args.imageUrl)
                .apply(
                    getDefaultRequestOptions()
                ).into(providerImage)
            toScheduleButton.setOnClickListener {
//                val db = Firebase.firestore
//                db.collection("appointments").document().set(
//                    Schedule(
//                        uuid = "160b0486-8804-4c0f-9b01-bbb3e2098534",
//                        date = "09-12-2021",
//                        appointment = listOf(
//                            Appointment(
//                                time = "08:30",
//                                Customer(name = "name", phone = "0503333333")
//                            ),
//                            Appointment(time = "9:00", null),
//                            Appointment(time = "10:00", null)
//                        )
//                    )
//                )
//                db.collection("appointments").document().set(
//                    Schedule(
//                        uuid = "160b0486-8804-4c0f-9b01-bbb3e2098534",
//                        date = "10-12-2021",
//                        appointment = listOf(
//                            Appointment(
//                                time = "08:30",
//                                Customer(name = "name2", phone = "0507777777")
//                            ),
//                            Appointment(time = "9:00", null),
//                            Appointment(time = "10:00", null)
//                        )
//                    )
//                )


//                db
//                    .collection("appointments")
//                    .whereEqualTo("uuid", "160b0486-8804-4c0f-9b01-bbb3e2098534")
//                    .whereEqualTo("date", "09-12-2021")
//                    .get()
//                    .addOnSuccessListener { documents ->
//                        for (document in documents) {
//                            Log.d("TAG", "${document.id} => ${document.data}")
//                        }
////                        Log.d("TAG", "${documents.id} => ${documents.data}")
//                    }
//                    .addOnFailureListener { exception ->
//                        Log.d("TAG", "get failed with ", exception)
//                    }
                routeActions.navigateToSchedule(args.uuid)
//
            }
        }
    }

    private fun <T> views(block: ProviderDetailsFragmentBinding.() -> T) = binding.block()
}
