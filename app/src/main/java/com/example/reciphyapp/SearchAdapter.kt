package com.example.reciphyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(private val recipeList : List<Recipes>) : RecyclerView.Adapter<SearchAdapter.InputViewHolder>() {

    class InputViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tv_inputIng = itemView.findViewById<TextView>(R.id.tv_input)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InputViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_input, parent, false)
        return InputViewHolder(view)
    }

    override fun onBindViewHolder(holder: InputViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.tv_inputIng.text = recipe.ingredient
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }
}