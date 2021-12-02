package org.rs.cardears.providers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import org.rs.cardears.providers.adapter.ProvidersAdapter
import org.rs.cardears.providers.databinding.ProvidersFragmentBinding

@AndroidEntryPoint
class ProvidersFragment : Fragment() {

    private val viewModel: ProvidersViewModel by viewModels()

    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        ProvidersAdapter()
    }
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
//            providersList.adapter = ProvidersAdapter()
        }

        addRepeatingJob(Lifecycle.State.STARTED) {
            viewModel.providersListFlow.collectLatest { it -> run {
                adapter.submitList(it)
            } }
        }
    }

    private fun <T> views(block: ProvidersFragmentBinding.() -> T) = binding.block()

}
