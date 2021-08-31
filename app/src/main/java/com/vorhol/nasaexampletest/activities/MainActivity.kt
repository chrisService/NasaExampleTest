package com.vorhol.nasaexampletest.activities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.vorhol.nasaexampletest.Constants
import com.vorhol.nasaexampletest.viewModels.MainViewModel
import com.vorhol.nasaexampletest.adapters.TitlesRVAdapter
import com.vorhol.nasaexampletest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TitlesRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setAdapter()

        val viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(
            MainViewModel::class.java)


        Glide.with(binding.ivBackground).load(Constants.BACKGROUNG_URL).into(binding.ivBackground)

        binding.btnDowload.setOnClickListener {
            try {
                viewModel.buttonClick(this, binding.progressBar, adapter)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    private fun setAdapter(){

        adapter = TitlesRVAdapter(mutableListOf())
        binding.rvTitleList.layoutManager = LinearLayoutManager(this)
        binding.rvTitleList.adapter = adapter
    }

}