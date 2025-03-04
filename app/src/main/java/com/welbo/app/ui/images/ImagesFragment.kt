package com.welbo.app.ui.images

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.welbo.app.databinding.FragmentImagesBinding
import com.welbo.app.ui.images.crop.ImagesCropFragment
import com.welbo.app.ui.images.upload.ImagesUploadFragment

class ImagesFragment : Fragment() {

    private var _binding: FragmentImagesBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentImagesBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: bang operator needs removing eventually
        _binding!!.floatingActionButton.setOnClickListener { _ ->
            displayImagePicker()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun displayImagePicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "image/*"
            putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/jpeg", "image/png"))
        }

        // NOTE about technical choice here: going for deprecated solution because this one allows you to filter out images
        // with unsupported file extensions before they are picked. Also, robots run on older versions of Android, and newest
        // way of picking images on Android is from Android 13 and above.
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK) {
            val selectedImageUri: Uri? = data?.data

            ImagesUploadFragment().show(childFragmentManager, ImagesUploadFragment.TAG)
        }
    }


    companion object {
        private const val REQUEST_CODE_PICK_IMAGE = 1
    }
}