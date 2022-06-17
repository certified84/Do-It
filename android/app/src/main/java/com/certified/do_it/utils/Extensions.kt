package com.certified.do_it.utils

import android.content.Context
import android.widget.Toast

object Extensions {

    fun showToast(context: Context, message: String) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_LONG
        ).show()
    }
}