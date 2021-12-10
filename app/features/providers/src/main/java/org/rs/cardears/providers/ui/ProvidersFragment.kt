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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.rs.cardears.core.Response
import org.rs.cardears.core.model.Provider
import org.rs.cardears.providers.R
import org.rs.cardears.providers.adapter.ProvidersAdapter
import org.rs.cardears.providers.databinding.ProvidersFragmentBinding
import org.rs.cardears.providers.state.ProvidersListState

@AndroidEntryPoint
class ProvidersFragment : Fragment() {

    private val viewModel: ProvidersViewModel by viewModels()
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        ProvidersAdapter(ProvidersAdapter.OnClickListener { renderDetailFragment(it) })
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

        addRepeatingJob(Lifecycle.State.CREATED) {
            viewModel.syncProvidersStateFlow.onEach {
                when (it) {
                    is Response.Success<*> -> onSuccessSyncProviders(it)
                    is Response.Error -> onErrorSyncProviders()
                    is Response.Loading -> views { progress.isVisible = it.loading }
                    Response.Idle -> Unit
                }
            }.launchIn(lifecycleScope)
        }

        addRepeatingJob(Lifecycle.State.STARTED) {
            viewModel.providersListFlow.onEach {
                when (it) {
                    is ProvidersListState.Success -> onSuccessFetchProviders(it)
                    is ProvidersListState.Failed -> onFailedFetchProviders()
                }
            }.launchIn(lifecycleScope)
        }
    }

    private fun onFailedFetchProviders() = views { emptyList.isVisible = true }

    private fun onSuccessFetchProviders(it: ProvidersListState.Success) {
        adapter.submitList(it.providers)
        views { emptyList.isVisible = it.providers.isEmpty() }
    }

    private fun onErrorSyncProviders() {
        views {
            Snackbar.make(
                providersContainer,
                "No Internet Connection",
                Snackbar.LENGTH_LONG
            ).show()
            noInternet.visibility = View.VISIBLE
        }
    }

    private fun onSuccessSyncProviders(it: Response.Success<*>) {
        viewModel.updateLocalProviderStorage(it.data as List<Provider>)
        views { noInternet.visibility = View.GONE }
    }

    private fun renderDetailFragment(provider: Provider) {

        val action = ProvidersFragmentDirections.providersFragmentAction(
            uuid = provider.uuid.toString(),
            title = provider.title,
            desc = provider.description ?: getString(R.string.no_desc_msg),
            imageUrl = provider.imageUrl ?: ""
        )
        findNavController().navigate(action)
    }

    private fun <T> views(block: ProvidersFragmentBinding.() -> T) = binding.block()
}
