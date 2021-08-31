package com.vorhol.nasaexampletest.viewModels

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vorhol.nasaexampletest.adapters.TitlesRVAdapter
import com.vorhol.nasaexampletest.api.RetrofitClient
import com.vorhol.nasaexampletest.listeners.ViewModelListener
import com.vorhol.nasaexampletest.models.GetNasaResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel: ViewModel(){

    private val client = RetrofitClient()
    private var response: GetNasaResponse? = null
    var titleList = mutableListOf<String>()

    fun buttonClick(context: Context, progressBar: ProgressBar, adapter: TitlesRVAdapter){

        getTitles(object: ViewModelListener {
            override fun onStarted(message: String?) {
                progressBar.visibility = View.VISIBLE
            }

            override fun onSuccess(message: String?) {
                adapter.updateList(titleList)
                progressBar.visibility = View.GONE
            }

            override fun onFailure(message: String?) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getTitles(viewModelListener: ViewModelListener){

        viewModelListener.onStarted()

        val queryParams = mutableMapOf<String, String>()
        queryParams["rss_url"] = "https://mars.nasa.gov/rss/blogs.cfm"

        viewModelScope.launch {
            try {
               response = client.getService()?.getNasaApiResponse(queryParams)
                for (item in response?.items!!){
                    titleList.add(item.title!!)
                }
                viewModelListener.onSuccess()
            }catch (e:Exception){
                e.printStackTrace()
                viewModelListener.onFailure(e.message)
            }
        }
    }

}