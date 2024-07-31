package com.project.imagesearchingapp.model.api

import android.content.Context
import android.graphics.BitmapFactory
import android.media.Image
import com.project.imagesearchingapp.BuildConfig
import com.project.imagesearchingapp.R
import com.project.imagesearchingapp.data.ImageData


class RetrofitController {
    private val client = RetrofitClient.getInstance().create(RetrofitService::class.java)

    suspend fun getImages(context: Context, query: String): List<ImageData>
        = client.getImages(query).documents.map {
            //TODO: get bitmap from glide
            //val bitmapImage =
            ImageData(
                //TODO: replace it property: bitmapImage after adjusting glide.
                image = BitmapFactory.decodeResource(context.resources, R.drawable.gwon),
                from = it.display_sitename,
                time = it.datetime
            )
        }


}