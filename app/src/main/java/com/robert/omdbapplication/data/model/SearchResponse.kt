package com.robert.omdbapplication.data.model


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val search: List<Search>,
    @SerializedName("totalResults")
    val totalResults: String
) {
    data class Search(
        @SerializedName("imdbID")
        val imdbID: String,
        @SerializedName("Poster")
        val poster: String,
        @SerializedName("Title")
        val title: String,
        @SerializedName("Type")
        val type: String,
        @SerializedName("Year")
        val year: String
    )
}