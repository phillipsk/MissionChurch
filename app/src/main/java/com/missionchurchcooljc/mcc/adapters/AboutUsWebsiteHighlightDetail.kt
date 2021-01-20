package com.missionchurchcooljc.mcc.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
//                centercrop, and all other two options had no effect
//            .fitCenter()
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}