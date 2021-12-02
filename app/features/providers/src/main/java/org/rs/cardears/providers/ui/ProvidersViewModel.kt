package org.rs.cardears.providers.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.rs.cardears.core.dataSource.ProvidersLocalDataSource
import javax.inject.Inject

@HiltViewModel
class ProvidersViewModel @Inject constructor(providersLocalDataSource: ProvidersLocalDataSource) : ViewModel() {

}
