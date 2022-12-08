package ru.jevo.coctail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.jevo.coctail.network.Drinks
import ru.jevo.coctail.network.Ingredients


/**
 * Created by Alex on 07.03.2022.
 */
class SimpleAdapter() : RecyclerView.Adapter<SimpleHolder>() {

    var drinks = ArrayList<Ingredients>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return SimpleHolder(itemView)
    }

    override fun onBindViewHolder(holder: SimpleHolder, position: Int) {
        holder.bind(drinks[position])
    }

    override fun getItemCount(): Int = drinks.size


}