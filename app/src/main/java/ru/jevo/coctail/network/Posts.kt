package ru.jevo.coctail.network

import com.google.gson.annotations.SerializedName

/**
 * Created by Alex on 10.03.2022.
 */
data class Posts (

    @SerializedName("userId" ) var userId : Int?    = null,
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("title"  ) var title  : String? = null,
    @SerializedName("body"   ) var body   : String? = null

)