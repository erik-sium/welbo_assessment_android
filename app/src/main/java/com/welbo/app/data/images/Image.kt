package com.welbo.app.data.images

data class Image(
    val filename: String,
    val thumbnailUrl: String?,
    val isCropped: Boolean
)
