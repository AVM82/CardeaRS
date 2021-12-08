package org.rs.cardears.providers.helpers

import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import org.rs.cardears.providers.R

fun getDefaultRequestOptions() = RequestOptions()
    .placeholder(R.drawable.loading_animation)
    .error(R.drawable.ic_account_box_24)
    .fallback(R.drawable.ic_account_box_24)
    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
