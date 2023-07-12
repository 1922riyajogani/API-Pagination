package com.example.apipagination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apipagination.API.ApiClient
import com.example.apipagination.API.ApiInterface
import com.example.apipagination.Models.UpcomingMovieModel
import com.example.apipagination.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var adapter = UpcomingAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        callApi()

    }

    private fun callApi() {

        var api = ApiClient.getApiClient().create(ApiInterface::class.java)
        api.getUpcoming().enqueue(object : Callback<UpcomingMovieModel> {
            override fun onResponse(
                call: Call<UpcomingMovieModel>,
                response: Response<UpcomingMovieModel>,
            ) {

                if (response.isSuccessful) {
                    var list = response.body()?.results
                    adapter.setMovies(list)
                    binding.rcvUpcoming.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rcvUpcoming.adapter = adapter
                }
            }

            override fun onFailure(call: Call<UpcomingMovieModel>, t: Throwable) {
            }

        })

    }
}