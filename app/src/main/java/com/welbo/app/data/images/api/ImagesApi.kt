package com.welbo.app.data.images.api

import com.welbo.app.data.images.model.ImageItem
import retrofit2.http.GET
import java.util.List

interface ImagesApi {

    @GET("/api/images/")
    suspend fun getAll(): List<ImageItem>
}