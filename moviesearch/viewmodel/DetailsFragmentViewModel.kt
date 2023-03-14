package com.example.moviesearch.viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModel
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import java.net.URL

class DetailsFragmentViewModel :ViewModel() {
    suspend fun loadWallpaper(url:String): Bitmap{
        return suspendCoroutine {
            val url = URL(url)
            val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            it.resume(bitmap)
        }
    }
}