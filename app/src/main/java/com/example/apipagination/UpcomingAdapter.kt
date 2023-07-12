package com.example.apipagination

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.apipagination.API.ApiClient
import com.example.apipagination.Models.ResultsItem
import com.example.apipagination.databinding.MovieItemBinding

class UpcomingAdapter : Adapter<UpcomingAdapter.UpcomingHolder>() {

    lateinit var list: List<ResultsItem>
    lateinit var context: Context
    class UpcomingHolder(itemView: MovieItemBinding) : ViewHolder(itemView.root) {
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingHolder {
        context= parent.context
        var binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UpcomingHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UpcomingHolder, position: Int) {
        holder.binding.apply {
            list.get(position).apply {
                txtTitle.text = originalTitle
                txtOver.text = overview
                Glide.with(context).load(ApiClient.IMAGE_BASE_URL+posterPath).into(imgPoster)
            }

        }
    }

    fun setMovies(list: List<ResultsItem?>?) {
        this.list= list as List<ResultsItem>
    }

}