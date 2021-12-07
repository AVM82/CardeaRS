package org.rs.cardears.providers.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.rs.cardears.core.model.Provider

class ProvidersAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Provider, ProviderViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProviderViewHolder =
        ProviderViewHolder.from(parent)

    override fun onBindViewHolder(holder: ProviderViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            item?.let { item -> onClickListener.onClick(item) }
        }
        holder.bind(item)
    }

    class OnClickListener(private val clickListener: (item: Provider) -> Unit) {
        fun onClick(item: Provider) = clickListener(item)
    }

}
