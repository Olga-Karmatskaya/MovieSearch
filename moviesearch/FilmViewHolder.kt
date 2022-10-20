package com.example.moviesearch

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FilmViewHolder(itemView: FilmItemBinding) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.title
    private val poster = itemView.poster
    private val description = itemView.description

    fun bind(film: Film) {
        title.text = film.title
        poster.setImageResource(film.poster)
        description.text = film.description
    }
}