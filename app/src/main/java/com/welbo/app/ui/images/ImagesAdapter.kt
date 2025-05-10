package com.welbo.app.ui.images

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.welbo.app.R
import com.welbo.app.data.images.model.RemoteImageItem

class ImagesAdapter(private val images: List<RemoteImageItem>) : RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImagesAdapter.ImageViewHolder, position: Int) {
        val image = images[position]
        holder.imageFilename.text = image.filename
        holder.imageCroppedStatus.text = if (image.isCropped) "Cropped" else "Not Cropped"

        // TODO: Load image
    }

    override fun getItemCount(): Int = images.size

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageThumbnail: ImageView = view.findViewById(R.id.imageThumbnail)
        val imageFilename: TextView = view.findViewById(R.id.imageFilename)
        val imageCroppedStatus: TextView = view.findViewById(R.id.imageCroppedStatus)
    }
}