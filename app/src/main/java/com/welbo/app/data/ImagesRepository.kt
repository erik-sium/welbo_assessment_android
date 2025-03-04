package com.welbo.app.data

import android.graphics.Rect
import com.welbo.app.data.images.api.ImagesApi
import com.welbo.app.data.images.model.RemoteImageItem
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.List
import javax.inject.Inject

interface ImagesRepository {
    suspend fun upload(imageFile: File)
    suspend fun crop(filename: String, coordinates: Rect): List<RemoteImageItem>
    suspend fun getAll(): List<RemoteImageItem>
}

class ImagesRepositoryImplementation @Inject constructor(
    private val api: ImagesApi
): ImagesRepository {

    override suspend fun upload(imageFile: File) {
        val requestFile: RequestBody = RequestBody.create(MediaType.parse("image/*"), imageFile);
        val body: MultipartBody.Part = MultipartBody.Part.createFormData("file", imageFile.getName(), requestFile);

        api.upload(body)
    }

//    override fun crop(filename: String, coordinates: Rect): List<ImageItem> {
//        return listOf<ImageItem>()
//    }

    override suspend fun getAll(): List<RemoteImageItem> = api.getAll()

}