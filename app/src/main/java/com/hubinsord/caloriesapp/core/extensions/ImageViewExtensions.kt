package com.hubinsord.caloriesapp.core.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(imageAddress: String) {
    Glide.with(this)
        .load(imageAddress)
        .into(this)
}