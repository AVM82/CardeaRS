package org.rs.cardears.providers.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.rs.cardears.core.model.Provider

class ProvidersAdapter : ListAdapter<Provider, ProviderViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProviderViewHolder =
        ProviderViewHolder.from(parent)

    override fun onBindViewHolder(holder: ProviderViewHolder, position: Int) =
        holder.bind(getItem(position))

}