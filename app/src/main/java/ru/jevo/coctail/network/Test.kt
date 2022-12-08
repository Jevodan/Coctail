package ru.jevo.coctail.network

import com.google.gson.annotations.SerializedName

/**
 * Created by Alex on 11.03.2022.
 */
class Test(@SerializedName("userId" ) var userId : Int?    = null,
           @SerializedName("id"     ) var id     : Int?    = null) {

    init {
        val data = mutableListOf<String>()
        (0..30).forEach { i -> data.add("$i test") }
    }

}