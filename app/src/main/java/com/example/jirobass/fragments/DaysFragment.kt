package com.example.jirobass.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jirobass.R
import com.example.jirobass.adapters.DayModel
import com.example.jirobass.adapters.DaysAdapter
import com.example.jirobass.adapters.ExercisesModel
import com.example.jirobass.databinding.FragmentDaysBinding
import com.example.jirobass.utils.FragmentManager
import com.example.jirobass.utils.MainViewModel


class DaysFragment : Fragment(), DaysAdapter.Listener {
    private lateinit var binding: FragmentDaysBinding
    private val model: MainViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding) {
        val adapter = DaysAdapter(this@DaysFragment)
        rcViewDays.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
        rcViewDays.adapter = adapter
        adapter.submitList(fillDaysArray())
    }

    private fun fillDaysArray(): ArrayList<DayModel> {
        val tArray = ArrayList<DayModel>()
        resources.getStringArray(R.array.day_exercises).forEach {
            tArray.add(DayModel(it, false))
        }
        return tArray
    }


    private fun fillExercisesList(day: DayModel) {
        val tempList = ArrayList<ExercisesModel>()
        day.exercises.split(",").forEach {
            val exercisesList = resources.getStringArray(R.array.exercise)
            val exercise = exercisesList[it.toInt()]
            val exerciseArray = exercise.split("|")
            tempList.add(ExercisesModel(exerciseArray[0], exerciseArray[1], exerciseArray[2]))
        }
        model.mutableListExercises.value = tempList
    }

    companion object {
        @JvmStatic
        fun newInstance() = DaysFragment()
    }

    override fun onClick(day: DayModel) {
        fillExercisesList(day)
        FragmentManager.setFragment(
            ExercisesListFragment.newInstance(),
            activity as AppCompatActivity
        )
    }
}