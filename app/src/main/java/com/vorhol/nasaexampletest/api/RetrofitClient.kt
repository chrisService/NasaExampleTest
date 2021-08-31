package com.vorhol.nasaexampletest.api

import com.vorhol.nasaexampletest.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private var service: NasaApiService? = null

    fun getService(): NasaApiService?{
        if (service == null){
            createService()
        }
        return service
    }

    private fun createService(){

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(NasaApiService::class.java)
    }
}