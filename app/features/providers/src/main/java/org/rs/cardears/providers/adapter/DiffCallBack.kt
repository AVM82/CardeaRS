package org.rs.cardears.providers.adapter

import androidx.recyclerview.widget.DiffUtil
import org.rs.cardears.core.model.ProviderDTO

object DiffCallBack : DiffUtil.ItemCallback<ProviderDTO>() {
    override fun areItemsTheSame(oldItem: ProviderDTO, newItem: ProviderDTO): Boolean =
        oldItem.uuid == newItem.uuid

    override fun areContentsTheSame(oldItem: ProviderDTO, newItem: ProviderDTO): Boolean =
        oldItem == newItem
}
