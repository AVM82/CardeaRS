package org.rs.cardears

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import org.rs.cardears.core.route.RouteActions
import javax.inject.Inject

@ActivityScoped
class ModuleNavigator @Inject constructor(
    private val navController: NavController?,
) : RouteActions {

    override fun back() {
        navController?.popBackStack()
    }

    override fun navigateToSchedule(dataToPass: String) {
        navController?.navigate(R.id.action_to_schedule)
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
    abstract class SplashModule {
        @Binds
        abstract fun routeActions(moduleNavigator: ModuleNavigator): RouteActions
    }
}
