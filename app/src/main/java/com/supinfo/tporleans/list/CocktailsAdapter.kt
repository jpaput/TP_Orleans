package com.supinfo.tporleans.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.supinfo.tporleans.R
import com.supinfo.tporleans.core.model.Cocktail
import kotlinx.android.synthetic.main.cocktail_item_view.view.*

class CocktailsAdapter(private val cocktails: List<Cocktail>, val context: Context, val listener: OnCocktailSeletedListener)
    : RecyclerView.Adapter<CocktailsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailsAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.cocktail_item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return cocktails.size
    }

    override fun onBindViewHolder(holder: CocktailsAdapter.ViewHolder, position: Int) {
        val cocktail = cocktails.get(position)

        holder.cocktailImage.setImageDrawable(context.getDrawable(cocktail.drawable))
        holder.cocktailName.text = cocktail.name

        holder.itemView.setOnClickListener{
            listener.onCocktailSelected(cocktail)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cocktailImage = itemView.cocktailImageView
        val cocktailName = itemView.cocktailName
    }

}