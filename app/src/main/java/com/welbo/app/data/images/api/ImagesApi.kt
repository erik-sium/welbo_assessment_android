package com.welbo.app.data.images.api

import okhttp3.ResponseBody
import retrofit2.http.GET

interface ImagesApi {

    @GET("/api/images/")
    suspend fun getAll(): ResponseBody
}