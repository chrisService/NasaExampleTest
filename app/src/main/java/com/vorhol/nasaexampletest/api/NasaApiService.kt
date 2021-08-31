package com.vorhol.nasaexampletest.api

import com.vorhol.nasaexampletest.models.GetNasaResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NasaApiService {

    @GET("/v1/api.json")
    suspend fun getNasaApiResponse(
        @QueryMap queryParams: Map<String, String>
    ): GetNasaResponse

}