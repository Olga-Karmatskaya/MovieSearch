package com.example.moviesearch.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.moviesearch.R
import com.example.moviesearch.data.ApiConstants
import com.example.moviesearch.databinding.FragmentDetailsBinding
import com.example.moviesearch.domain.Film

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private  val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFilmsDetails()
    }
    private fun setFilmsDetails() {
        val film = arguments?.get("film") as Film

        binding.detailsToolbar.title = film.title
    Glide.with(this)
        .load(ApiConstants.IMAGES_URL + "w780" + film.poster)
        .centerCrop()
        .into(binding.detailsPoster)

        binding.detailsDescription.text = film.description
        binding.detailsFabFavorites.setImageResource(
            if (film.isInFavorites) R.drawable.ic_baseline_favorite_24
            else R.drawable.ic_baseline_favorite_border_24
        )
    }
}