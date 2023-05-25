package com.example.reciphyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.reciphyapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recipeList: ArrayList<Recipes>
    private lateinit var mainAdapter: MainAdapter
    private lateinit var binding: ActivityMainBinding

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.daging,
            R.string.ayam,
            R.string.telur
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        findRecommend()
    }

    private fun findRecommend() {
        recyclerView = findViewById(R.id.rv_recent)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recipeList = ArrayList()

        addToList()

        mainAdapter = MainAdapter(recipeList)
        recyclerView.adapter = mainAdapter

    }

    private fun addToList(){
        recipeList.add(Recipes(R.drawable.nasi_goreng, "Nasi Goreng", "nasi"))
        recipeList.add(Recipes(R.drawable.nasi_goreng, "Nasi Goreng", "telur"))
        recipeList.add(Recipes(R.drawable.nasi_goreng, "Nasi Goreng", "daun bawang"))
        recipeList.add(Recipes(R.drawable.nasi_goreng, "Nasi Goreng", "bawang merah"))
        recipeList.add(Recipes(R.drawable.nasi_goreng, "Nasi Goreng", "bawang putih"))

    }
}