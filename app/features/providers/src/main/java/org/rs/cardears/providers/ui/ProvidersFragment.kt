package org.rs.cardears.providers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.rs.cardears.providers.databinding.ProvidersFragmentBinding

@AndroidEntryPoint
class ProvidersFragment : Fragment() {

    private val binding get() = requireNotNull(_binding)

    private var _binding: ProvidersFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ProvidersFragmentBinding.inflate(inflater).also { _binding = it }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        views {
//            click.setOnClickListener {
//                findNavController().navigate(R.id.action_providersFragment_to_providerDetailsFragment)
//            }
//        }
    }

    private fun <T> views(block: ProvidersFragmentBinding.() -> T) = binding.block()

}