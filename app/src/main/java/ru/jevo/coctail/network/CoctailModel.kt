package ru.jevo.coctail.network

import com.google.gson.annotations.SerializedName

/**
 * Created by Alex on 10.03.2022.
 */
//data class CoctailModel(@SerializedName("ingredients") var ingredients: ArrayList<Ingredients> = arrayListOf())

data class Ingredients(

    @SerializedName("idIngredient") var idIngredient: String? = null,
    @SerializedName("strIngredient") var strIngredient: String? = null,
    @SerializedName("strDescription") var strDescription: String? = null,
    @SerializedName("strType") var strType: String? = null,
    @SerializedName("strAlcohol") var strAlcohol: String? = null,
    @SerializedName("strABV") var strABV: String? = null

)
