package com.example.reciphyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FragmentAdapter(private var context : Context,
                      private var listRecipe: ArrayList<Recipes>)
    : RecyclerView.Adapter<FragmentAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val RecipeTitle = view.findViewById<TextView>(R.id.iv_recommend)
        val RecipeImg = view.findViewById<ImageView>(R.id.btn_recommend)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        ViewHolder( LayoutInflater.from(viewGroup.context).inflate(R.layout.rv_item_recommend, viewGroup, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Glide.with(context).load(listRecipe[position].recipeImg).into(viewHolder.RecipeImg)
        viewHolder.RecipeTitle.text = listRecipe[position].recipeTitle
    }

    override fun getItemCount(): Int = listRecipe.size
}