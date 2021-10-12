package com.mitchelltsutsulis.tube_loader

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideoDownloadedAdapter(private val data: List<Video>,
                             private val context: Context?,
                             private val listener: (Video) -> Unit): RecyclerView.Adapter<VideoDownloadedAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoDownloadedAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.video_downloaded_layout, parent, false) as View

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VideoDownloadedAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        private val delete: Button = view.findViewById(R.id.delete_button)
        private val title: TextView = view.findViewById(R.id.title)
        private val thumbnail: ImageView = view.findViewById(R.id.thumbnail)

        fun bind(item: Video) {
            title.text = item.title
            (context as App).loadBitmap(item.videoId, thumbnail)

            delete.setOnClickListener {
                listener(item)
            }
        }
    }
}