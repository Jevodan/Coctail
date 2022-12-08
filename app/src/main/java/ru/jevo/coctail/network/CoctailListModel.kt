package ru.jevo.coctail.network

import com.google.gson.annotations.SerializedName


data class CoctailListModel(@SerializedName("drinks") val coctails: ArrayList<Drinks> = arrayListOf())


data class Drinks(

    @SerializedName("idDrink") val idDrink: String? = null,
    @SerializedName("strDrink") val strDrink: String? = null,
    @SerializedName("strCategory") val strCategory: String? = null,
    @SerializedName("strDrinkThumb") val strDrinkThumb: String? = null,

    )
