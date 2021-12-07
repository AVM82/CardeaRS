package org.rs.cardears.providers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import org.rs.cardears.core.Response
import org.rs.cardears.core.model.Provider
import org.rs.cardears.providers.adapter.ProvidersAdapter
import org.rs.cardears.providers.databinding.ProvidersFragmentBinding
import org.rs.cardears.providers.state.ProvidersListState

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
            providersList.adapter = adapter
        }

        addRepeatingJob(Lifecycle.State.STARTED) {
            viewModel.syncProvidersStateFlow.collectLatest {
                when (it) {
                    //todo  remove unchecked cast 07.12.2021
                    is Response.Success<*> -> viewModel.updateLocalProviderStorage(it.data as List<Provider>)
                    is Response.Error -> Unit
                    is Response.Loading -> views { progress.isVisible = it.loading }
                    Response.Idle -> Unit
                }
            }
        }

        addRepeatingJob(Lifecycle.State.STARTED) {
            viewModel.fetchProviders()
            viewModel.providersListFlow.collectLatest {
                when (it) {
                    is ProvidersListState.Success -> {
                        adapter.submitList(it.providers)
                        views {
                            emptyList.isVisible = it.providers.isEmpty()
                        }
                    }
                    is ProvidersListState.Failed -> {
                        views {
                            emptyList.isVisible = true
                        }
                    }
                }
            }
        }
    }

    private fun <T> views(block: ProvidersFragmentBinding.() -> T) = binding.block()

}
