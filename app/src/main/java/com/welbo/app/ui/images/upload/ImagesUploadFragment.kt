package com.welbo.app.ui.images.upload

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Point
import android.os.Bundle
import android.view.Display
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.welbo.app.R

class ImagesUploadFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;

            builder.setView(inflater.inflate(R.layout.dialog_image_upload, null))
                .setNegativeButton("Cancel upload",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }


    companion object {
        val TAG = ImagesUploadFragment::class.java.simpleName
    }
}
