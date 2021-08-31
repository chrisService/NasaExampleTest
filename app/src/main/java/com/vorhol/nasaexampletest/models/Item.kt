package com.vorhol.nasaexampletest.models


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("title")
    val title: String?,
    @SerializedName("pubDate")
    val pubDate: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("guid")
    val guid: String?,
    @SerializedName("author")
    val author: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("categories")
    val categories: List<String>?
)