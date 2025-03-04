package com.welbo.app.data.images.model

import androidx.annotation.Keep

data class ImageItem(
    @Keep val filename: String,
    @Keep val thumbnailUrl: String?,
    @Keep val isCropped: Boolean
)
