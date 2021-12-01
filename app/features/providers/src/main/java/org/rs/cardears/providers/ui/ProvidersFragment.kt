package org.rs.cardears.providers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.rs.cardears.providers.adapter.ProvidersAdapter
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

        views {
            providersList.adapter = ProvidersAdapter()
        }
    }

    private fun <T> views(block: ProvidersFragmentBinding.() -> T) = binding.block()

}
