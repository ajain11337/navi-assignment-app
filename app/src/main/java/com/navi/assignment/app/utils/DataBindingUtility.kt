package com.navi.assignment.app.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object DataBindingUtility {
    private const val TAG = "DataBindingUtility"

    @JvmStatic
    @BindingAdapter("app:imgUrl")
    fun setImgUrl(imageView: ImageView, imgUrl: String) {
        Glide.with(imageView.context)
            .load(imgUrl)
            .centerCrop()
            .circleCrop()
            .into(imageView);
    }
}