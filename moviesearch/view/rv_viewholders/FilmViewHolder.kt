package com.example.moviesearch.view.rv_viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesearch.data.ApiConstants
import com.example.moviesearch.databinding.FilmItemBinding
import com.example.moviesearch.domain.Film

class FilmViewHolder(itemView: FilmItemBinding) : RecyclerView.ViewHolder(itemView.root) {

    private val title = itemView.title
    private val poster = itemView.poster
    private val description = itemView.description
    private val ratingDonut = itemView.ratingDonut

    fun bind(film: Film) {
        title.text = film.title
        Glide.with(itemView)
            .load(ApiConstants.IMAGES_URL + "w342" + film.poster)
            .centerCrop()
            .into(poster)
        description.text=film.description
        ratingDonut.setProgress((film.rating * 10).toInt())
    }
}