package com.example.moviesearch.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesearch.R
import com.example.moviesearch.databinding.ActivityMainBinding
import com.example.moviesearch.domain.Film
import com.example.moviesearch.view.fragments.DetailsFragment
import com.example.moviesearch.view.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
     private lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            val  view = binding.root
            setContentView(view)

            initNavigation()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_placeholder, HomeFragment())
                .addToBackStack(null)
                .commit()
        }
        fun launchDetailsFragment(film: Film) {
            val bundle = Bundle()
            bundle.putParcelable("film", film)
            val fragment = DetailsFragment()
            fragment.arguments = bundle

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_placeholder, fragment)
                .addToBackStack(null)
                .commit()
        }

        private fun initNavigation() {

            binding.bottomNavigation.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.favorites -> {
                        Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.watch_later -> {
                        Toast.makeText(this, "Посмотреть похже", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.selections -> {
                        Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }
    }
