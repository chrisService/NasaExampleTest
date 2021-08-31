package com.vorhol.nasaexampletest.models


import com.google.gson.annotations.SerializedName

data class GetNasaResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("feed")
    val feed: Feed?,
    @SerializedName("items")
    val items: List<Item>?
)