package com.welbo.app.data.images.api

import com.welbo.app.data.images.model.RemoteImageItem
import okhttp3.MultipartBody
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Part
import java.util.List

interface ImagesApi {

    @POST("/api/images/upload")
    suspend fun upload(@Part imageFile: MultipartBody.Part)

    @GET("/api/images/")
    suspend fun getAll(): List<RemoteImageItem>
}