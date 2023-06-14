package com.example.reciphyapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailSectionPageAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    var ingredients: String = ""
    var steps: String = ""
    
    override fun createFragment(position: Int): Fragment {
        val fragment = DetailFragment()
        fragment.arguments = Bundle().apply {
            putInt(DetailFragment.ARG_POSITION, position + 1)
            putString(DetailFragment.ARG_INGREDIENTS, ingredients)
            putString(DetailFragment.ARG_STEPS, steps)
        }
        return fragment
    }
    override fun getItemCount(): Int {
        return 2
    }
}