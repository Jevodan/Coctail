package ru.jevo.coctail.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory



/**
 * Created by Alex on 09.03.2022.
 */
class ApiDataImpl {

    companion object {
      //  val baseUrl = "https://www.thecocktaildb.com/api/json/v1/1/"

        val baseUrl = "https://jsonplaceholder.typicode.com/"


        fun getApiData(): Retrofit {
            return Retrofit.Builder()
                .client(client(httpLoggingInterceptor()))
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            //   .create(ApiData.class)

        }


        fun gson(): Gson {
            return GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
        }


        fun client(httpLoggingInterceptor: HttpLoggingInterceptor?): OkHttpClient? {
            return httpLoggingInterceptor?.let {
                OkHttpClient.Builder()
                    .addNetworkInterceptor(it)
                    .build()
            }
        }


        fun httpLoggingInterceptor(): HttpLoggingInterceptor? {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return httpLoggingInterceptor
        }


    }
}