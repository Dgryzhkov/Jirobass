package com.example.jirobass.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.jirobass.R
import org.w3c.dom.DocumentFragment

/**
 *@Author Dgryzhkov
 */
object FragmentManager {
    fun setFragment(newFragment: Fragment, act: AppCompatActivity) {
        val transaction = act.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeHolder, newFragment)
        transaction.commit()
    }
}