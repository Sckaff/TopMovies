package com.example.topmovies

import com.google.gson.annotations.SerializedName

class TopMovie {

    @JvmField
    @SerializedName("title")
    var title: String? = null

    @SerializedName("poster_path")
    var bookImageUrl: String? = null
    // Must add "https://image.tmdb.org/t/p/w500/" beforehand

    @SerializedName("overview")
    var summary: String? = null

}