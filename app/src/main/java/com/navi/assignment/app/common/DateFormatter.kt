package com.navi.assignment.app.common

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {
    private const val TAG = "DateFormatter"

    private const val ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    private const val READABLE_FORMAT = "E, dd MMM yyyy, HH:mm aa"

    fun getISOFormattedDateString(date: String): String {
        try {
            val originalFormat = SimpleDateFormat(ISO_DATE_FORMAT, Locale.getDefault())
            val transformedFormat = SimpleDateFormat(READABLE_FORMAT, Locale.getDefault())
            val originalDate = originalFormat.parse(date)
            originalDate?.let { return transformedFormat.format(originalDate) }
        } catch (e: ParseException) {
            Log.d(TAG, "setDateText: + ${e.localizedMessage}")
        }
        return Constants.EMPTY
    }
}