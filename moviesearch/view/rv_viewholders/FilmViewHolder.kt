package com.example.moviesearch.view.rv_viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.databinding.FilmItemBinding
import com.example.moviesearch.domain.Film

class FilmViewHolder(itemView: FilmItemBinding) : RecyclerView.ViewHolder(itemView.root) {

    private val title = itemView.title
    private val poster = itemView.poster
    private val description = itemView.description

    fun bind(film: Film) {
        title.text = film.title
        poster.setImageResource(film.poster)
        description.text = film.description
    }
}