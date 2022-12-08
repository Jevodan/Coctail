package ru.jevo.coctail

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.jevo.coctail.network.Drinks
import ru.jevo.coctail.network.Ingredients


/**
 * Created by Alex on 07.03.2022.
 */
class SimpleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.cocName)
    val category: TextView = itemView.findViewById(R.id.cocCategory)
    val image: ImageView = itemView.findViewById(R.id.cocImage)

/*
    fun bind(drinks: Drinks) {
        name.text = drinks.strDrink
        category.text = drinks.strCategory
        val url = drinks.strDrinkThumb
        Glide.with(image)
            .load(url)
            .circleCrop()
            .into(image)

    }
*/
    fun bind(drinks: Ingredients) {
        name.text = drinks.idIngredient
        category.text = drinks.strABV

    }
}