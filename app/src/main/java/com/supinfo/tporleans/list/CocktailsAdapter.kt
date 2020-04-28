package com.supinfo.tporleans.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.supinfo.tporleans.R
import com.supinfo.tporleans.core.model.Cocktail
import kotlinx.android.synthetic.main.cocktail_item_view.view.*

class CocktailsAdapter(val context: Context, val listener: OnCocktailSeletedListener)
    : RecyclerView.Adapter<CocktailsAdapter.ViewHolder>() {


    private  var cocktails : List<Cocktail> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailsAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.cocktail_item_view, parent, false))
    }

    fun setCocktails(data : List<Cocktail>) {
        cocktails = data;
    }

    override fun getItemCount(): Int {
        if(cocktails == null){
            return 0
        }
        return cocktails.size
    }

    override fun onBindViewHolder(holder: CocktailsAdapter.ViewHolder, position: Int) {
        val cocktail = cocktails.get(position)

        Glide.with(context)
            .load(cocktail.strDrinkThumb)
            .into(holder.cocktailImage)

        holder.cocktailName.text = cocktail.strDrink

        holder.itemView.setOnClickListener{
            listener.onCocktailSelected(cocktail)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cocktailImage = itemView.cocktailImageView
        val cocktailName = itemView.cocktailName
    }

}