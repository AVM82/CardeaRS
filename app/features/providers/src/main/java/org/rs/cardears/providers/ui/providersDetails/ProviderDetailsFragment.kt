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
                routeActions.navigateToSchedule(args.uuid)
            }
        }
    }

    private fun <T> views(block: ProviderDetailsFragmentBinding.() -> T) = binding.block()
}
