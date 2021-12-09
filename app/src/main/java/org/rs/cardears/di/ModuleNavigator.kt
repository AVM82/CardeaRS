package org.rs.cardears.di

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import org.rs.cardears.R
import org.rs.cardears.core.dataSource.ProvidersLocalDataSource
import org.rs.cardears.core.route.RouteActions
import org.rs.cardears.localstorage.repository.ProvidersLocalRepository
import org.rs.cardears.providers.ui.ProvidersFragmentDirections
import javax.inject.Inject

@ActivityScoped
class ModuleNavigator @Inject constructor(
    private val navController: NavController?,
) : RouteActions {

    override fun back() {
        navController?.popBackStack()
    }

    override fun navigateToSchedule(dataToPass: String) {
//        val action = ProvidersFragmentDirections.providersFragmentAction(
//            uuid = provider.uuid.toString(),
//            title = provider.title,
//            desc = provider.description ?: getString(org.rs.cardears.providers.R.string.no_desc_msg),
//            imageUrl = provider.imageUrl ?: ""
//        )
        val bundle = Bundle()
        bundle.putString("uuid", dataToPass)
        navController?.navigate(R.id.action_to_schedule, bundle)
    }

    override fun navigateToProviders(dataToPass: String) {
        navController?.navigate(R.id.action_to_providers)
    }

    @Module
    @InstallIn(ActivityComponent::class)
    object NavControllerModule {
        @Provides
        fun navController(activity: FragmentActivity): NavController? {
            return activity.supportFragmentManager.findFragmentById(R.id.container)?.let {
                NavHostFragment.findNavController(it)
            }
        }
    }

    @Module
    @InstallIn(ActivityComponent::class)
    abstract class RouteModule {
        @Binds
        abstract fun routeActions(moduleNavigator: ModuleNavigator): RouteActions
    }
}
