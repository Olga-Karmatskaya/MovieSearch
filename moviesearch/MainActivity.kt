package com.example.moviesearch

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesearch.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment


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
                    R.id.home -> {
                        val tag = "home"
                        val fragment = checkFragmentExistence(tag)
                        changeFragment( fragment?: HomeFragment(), tag)
                        true
                    }
                    R.id.favorites -> {
                        val tag = "favorites"
                        val fragment = checkFragmentExistence(tag)
                        changeFragment( fragment?: FavoritesFragment(), tag)
                        true
                    }
                    R.id.watch_later -> {
                        val tag = "watch_later"
                        val fragment = checkFragmentExistence(tag)
                        changeFragment( fragment?: WatchLaterFragment(), tag)
                        true
                    }
                    R.id.selections -> {
                        val tag = "selections"
                        val fragment = checkFragmentExistence(tag)
                        changeFragment( fragment?: SelectionsFragment(), tag)
                        true
                    }
                    else -> false
                }
            }
        }

    private fun checkFragmentExistence(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment, tag)
            .addToBackStack(null)
            .commit()
    }
}
