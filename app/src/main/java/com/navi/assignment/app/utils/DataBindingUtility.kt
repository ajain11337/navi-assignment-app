package com.navi.assignment.app.utils

import android.annotation.SuppressLint
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.navi.assignment.app.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DataBindingUtility {
    private const val TAG = "DataBindingUtility"

    @JvmStatic
    @BindingAdapter("app:imgUrl")
    fun setImgUrl(imageView: ImageView, imgUrl: String) {
        Glide.with(imageView.context)
            .load(imgUrl)
            .centerCrop()
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView);
    }
}