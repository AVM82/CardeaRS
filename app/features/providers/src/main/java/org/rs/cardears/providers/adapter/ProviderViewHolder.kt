package org.rs.cardears.providers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.rs.cardears.core.model.Provider
import org.rs.cardears.providers.databinding.ItemProviderListBinding
import org.rs.cardears.providers.helpers.getDefaultRequestOptions

class ProviderViewHolder(private val binding: ItemProviderListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Provider) {
        views {
            providerTitle.text = item.title
            shortDesc.text = item.shortDesc
            Glide.with(itemView.context)
                .load(item.imageUrl)
                .apply(getDefaultRequestOptions())
                .into(providerImage)
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
