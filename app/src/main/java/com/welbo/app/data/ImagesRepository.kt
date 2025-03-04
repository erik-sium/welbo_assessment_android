package com.welbo.app.data

import com.welbo.app.data.images.api.ImagesApi
import com.welbo.app.data.images.model.ImageItem
import java.util.List
import javax.inject.Inject

interface ImagesRepository {
    suspend fun getAll(): List<ImageItem>
}

class ImagesRepositoryImplementation @Inject constructor(
    private val api: ImagesApi
): ImagesRepository {

    override suspend fun getAll(): List<ImageItem> = api.getAll()
}