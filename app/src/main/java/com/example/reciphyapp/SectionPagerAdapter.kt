package com.example.reciphyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    var recipe: String = ""

    override fun createFragment(position: Int): Fragment {
        val fragment = FragmentRecommend()
        fragment.arguments = Bundle().apply {
            putInt(FragmentRecommend.ARG_POSITION, position + 1)
            putString(FragmentRecommend.ARG_RECIPE, recipe)
        }
        return fragment
    }
    override fun getItemCount(): Int {
        return 3
    }
}