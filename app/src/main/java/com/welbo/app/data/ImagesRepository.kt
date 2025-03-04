package com.welbo.app.data

import com.welbo.app.data.images.api.ImagesApi
import com.welbo.app.data.images.model.ImageItem

interface ImagesRepository {
    suspend fun getAll(): List<ImageItem>
}

class ImagesRepositoryImplementation @Inject constructor(
    private val api: ImagesApi
): ImagesRepository {

    override suspend fun getAll(): List<ImageItem> {
        val networkResponse: ResponseBody = api.getAll()

        networkResponse.use {
//            parsedResponse = parser.parse(it.byteStream())
        }

//        return parsedResponse
    }
}