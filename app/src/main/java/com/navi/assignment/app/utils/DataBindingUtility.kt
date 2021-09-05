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

    private const val ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"
    private const val READABLE_FORMAT = "yyyy-MM-dd hh:mm"

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

    @JvmStatic
    @BindingAdapter("app:date")
    fun setDateText(textView: TextView, date: String) {
        try {
            val originalFormat = SimpleDateFormat(ISO_DATE_FORMAT, Locale.getDefault())
            val transformedFormat = SimpleDateFormat(READABLE_FORMAT, Locale.getDefault())
            val originalDate = originalFormat.parse(date)
            originalDate?.let { textView.text = transformedFormat.format(originalDate) }
        } catch (e: ParseException) {
            Log.d(TAG, "setDateText: + ${e.localizedMessage}")
        }
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("app:username")
    fun setUserName(textView: TextView, username: String) {
        textView.text = "Author : $username"
    }
}