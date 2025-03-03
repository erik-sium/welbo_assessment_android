package com.welbo.app.ui.images.crop

import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.canhub.cropper.CropImageView
import com.welbo.app.databinding.DialogImagesCropBinding

class ImagesCropFragment(
    private val uri: Uri,
    private val onCropCompleted: (Rect) -> Unit
) : DialogFragment() {

    private var _binding: DialogImagesCropBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogImagesCropBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cropImageView.apply {
            setImageUriAsync(uri)
            setAspectRatio(16, 9)
            setFixedAspectRatio(true)
            guidelines = CropImageView.Guidelines.ON
            setMinCropResultSize(1920, 1080)
        }

        binding.submitButton.setOnClickListener {
            val cropRect = binding.cropImageView.cropRect
            if (cropRect != null) {
                onCropCompleted(cropRect)
                dismiss()
            }
        }

        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        val TAG = ImagesCropFragment::class.java.simpleName
    }
}
