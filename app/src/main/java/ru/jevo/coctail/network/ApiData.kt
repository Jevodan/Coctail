package ru.jevo.coctail.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Alex on 09.03.2022.
 */
interface ApiData {

    @GET("search.php")
    fun getCoctailList(@Query("f") query: String): Observable<CoctailListModel>

    @GET("search.php")
    fun getCoctail(@Query("f") query: String): Observable<List<Drinks>>

    @get:GET("posts")
    val posts: Observable<List<Post>>


}