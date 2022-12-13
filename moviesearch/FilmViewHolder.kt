package com.example.moviesearch

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.databinding.FilmItemBinding
import com.bumptech.glide.Glide

class FilmViewHolder(itemView: FilmItemBinding) : RecyclerView.ViewHolder(itemView.root) {

    private val title = itemView.title
    private val poster = itemView.poster
    private val description = itemView.description

    private val ratingDonut = itemView.ratingDonut

    fun bind(film: Film) {
        title.text = film.title
        Glide.with(itemView)
            .load(film.poster)
            .centerCrop()
            .into(poster)
        description.text = film.description
        ratingDonut.setProgress((film.rating * 10).toInt())
    }
}