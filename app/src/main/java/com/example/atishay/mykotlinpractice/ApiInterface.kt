package com.ideal.retrofitdemo

import com.ideal.retrofitdemo.model.CategoryResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Dilavar on 11/29/2017.
 */
public interface ApiInterface {

    @GET("?json=get_category_index")
    abstract fun getCategoryDetails(): Call<CategoryResponse>



    companion object Factory {

        val BASE_URL = "https://androidteachers.com/"
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(ApiInterface::class.java);
        }
    }

}