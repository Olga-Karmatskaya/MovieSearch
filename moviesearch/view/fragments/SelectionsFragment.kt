package com.example.moviesearch.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviesearch.databinding.FragmentSelectionsBinding
import com.example.moviesearch.utils.AnimationHelper

class SelectionsFragment : Fragment() {
    private var _binding: FragmentSelectionsBinding? = null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectionsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(binding.selectionsFragmentRoot, requireActivity(), 4)
    }
}