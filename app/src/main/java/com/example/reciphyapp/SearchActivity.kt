package com.example.reciphyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recipeList: ArrayList<Recipes>
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setInput()
    }

    private fun setInput() {
        recyclerView = findViewById(R.id.rv_ingredients_tag)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recipeList = ArrayList()

        addToList()

        searchAdapter = SearchAdapter(recipeList)
        recyclerView.adapter = searchAdapter

    }

    private fun addToList(){
        recipeList.add(Recipes(R.drawable.nasi_goreng, "Nasi Goreng", "nasi"))
        recipeList.add(Recipes(R.drawable.nasi_goreng, "Nasi Goreng", "telur"))
        recipeList.add(Recipes(R.drawable.nasi_goreng, "Nasi Goreng", "daun bawang"))

    }
}