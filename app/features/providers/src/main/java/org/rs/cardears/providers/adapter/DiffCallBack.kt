package org.rs.cardears.providers.adapter

import androidx.recyclerview.widget.DiffUtil
import org.rs.cardears.core.model.Provider

object DiffCallBack : DiffUtil.ItemCallback<Provider>() {
    override fun areItemsTheSame(oldItem: Provider, newItem: Provider): Boolean =
        oldItem.uuid == newItem.uuid

    override fun areContentsTheSame(oldItem: Provider, newItem: Provider): Boolean =
        oldItem == newItem
}
