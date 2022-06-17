package com.certified.do_it.utils

import android.content.Context
import com.certified.do_it.R
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


fun currentDate(): Calendar = Calendar.getInstance()

fun formatDate(date: Long, context: Context): String {

    val now = Date()
    val seconds = TimeUnit.MILLISECONDS.toSeconds(now.time - date)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(now.time - date)
    val hours = TimeUnit.MILLISECONDS.toHours(now.time - date)
    val days = TimeUnit.MILLISECONDS.toDays(now.time - date)

    return when {
        seconds < 60 -> context.getString(R.string.just_now)
        minutes == 1L -> context.getString(R.string.a_minute_ago)
        minutes in 2..59L -> "$minutes ${context.getString(R.string.minutes_ago)}"
        hours == 1L -> context.getString(R.string.an_hour_ago)
        hours in 2..23 -> "$hours ${context.getString(R.string.hours_ago)}"
        days == 1L -> context.getString(R.string.a_day_ago)
        else -> formatSimpleDate(date)
    }
}

fun formatSimpleDate(date: Long): String =
    SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(date)