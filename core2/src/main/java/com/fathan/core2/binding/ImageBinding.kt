package com.fathan.core2.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fathan.core2.R

@BindingAdapter("avatar")
fun avatar(imageView: ImageView, avatar: String) =
    Glide.with(imageView)
        .load(avatar)
        .apply(RequestOptions.circleCropTransform()).placeholder(R.drawable.ic_user)
        .into(imageView)