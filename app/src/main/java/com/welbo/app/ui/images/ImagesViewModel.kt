package com.welbo.app.ui.images

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.welbo.app.data.ImagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(
    @ApplicationContext private val applicationContext: Context,
    private val imagesRepository: ImagesRepository
) : ViewModel() {

     fun uploadImage(imageFileUri: Uri) = viewModelScope.launch(Dispatchers.IO) {
        try {
            imagesRepository.upload(File(imageFileUri!!.path))
        } catch (exception: Exception) {} finally {}
        }
    }
}
