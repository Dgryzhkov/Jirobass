package com.example.jirobass.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 *@Author Dgryzhkov
 */
object TimeUtils {
    @SuppressLint("SimpleDateFormat")
    val formatter = SimpleDateFormat("mm:ss")

    fun getTime(time: Long): String{

        val cv = Calendar.getInstance()

        cv.timeInMillis = time

        return formatter.format(cv.time)
    }

}