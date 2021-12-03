package org.rs.cardears.providers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.rs.cardears.core.model.Provider
import org.rs.cardears.providers.databinding.ItemProviderListBinding

class ProviderViewHolder(private val binding: ItemProviderListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Provider) {
        itemView.run {
//            setOnClickListener { listener.onClickListener(item) }
//            setOnLongClickListener { listener.onLongClickListener(item) }
        }

        views {
            providerTitle.text = item.title
            shortDesc.text = item.shortDesc
        }
    }


    companion object {
        fun from(parent: ViewGroup) = ItemProviderListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).let(::ProviderViewHolder)
    }

    private fun <T> views(block: ItemProviderListBinding.() -> T): T? = binding.block()
}
