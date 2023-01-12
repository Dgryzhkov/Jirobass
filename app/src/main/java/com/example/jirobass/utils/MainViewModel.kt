package com.example.jirobass.utils

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


import com.example.jirobass.adapters.ExerciseModel

/**
 *@Author Dgryzhkov
 */
class MainViewModel : ViewModel() {
    val mutableListExercises = MutableLiveData<ArrayList<ExerciseModel>>()
    var pref: SharedPreferences? = null
    var currentDay = 0

    fun savePref(key: String, value: Int) {
        pref?.edit()?.putInt(key, value)?.apply()
    }

    fun getPref(key: String): Int {
        return pref?.getInt(key, 0) ?: 0
    }
}