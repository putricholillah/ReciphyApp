package com.example.reciphyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val recipeList : List<Recipes>) : RecyclerView.Adapter<MainAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val iv_recipe = itemView.findViewById<ImageView>(R.id.iv_recommend)
        val tv_recipe = itemView.findViewById<TextView>(R.id.tv_recommend)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.iv_recipe.setImageResource(recipe.recipeImg)
        holder.tv_recipe.text = recipe.recipeTitle
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }
}