package com.example.jirobass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jirobass.fragments.DaysFragment
import com.example.jirobass.utils.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentManager.setFragment(DaysFragment.newInstance(), this)
    }

    override fun onBackPressed() {
        if (FragmentManager.currentFragment is DaysFragment)
            super.onBackPressed()
        else FragmentManager.setFragment(DaysFragment.newInstance(), this)
    }
}