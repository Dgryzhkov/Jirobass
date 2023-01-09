package com.example.jirobass.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


import com.example.jirobass.adapters.ExerciseModel

/**
 *@Author Dgryzhkov
 */
class MainViewModel: ViewModel() {
    val mutableListExercises = MutableLiveData<ArrayList<ExerciseModel>>()

}