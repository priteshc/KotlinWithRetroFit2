package com.ideal.retrofitdemo.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by Dilavar on 11/29/2017.
 */
class CategoryResponse {


    @SerializedName("status")
    var status: String? = null

    @SerializedName("count")
    var count: Int = 0

    @SerializedName("categories")
    var categories: ArrayList<Category>? = null


}