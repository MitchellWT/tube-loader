package com.mitchelltsutsulis.tube_loader.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mitchelltsutsulis.tube_loader.R
import com.mitchelltsutsulis.tube_loader.model.Video
import com.squareup.picasso.Picasso

class VideoDownloadedAdapter(private val data: MutableList<Video>,
                             // Old Code
                             // private val context: Context?,
                             private val listener: (Video) -> Unit): RecyclerView.Adapter<VideoDownloadedAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.video_downloaded_layout, parent, false) as View

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    fun getItemIndex(item: Video) = data.indexOf(item)
    fun removeItem(index: Int) = data.removeAt(index)

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        // Getting component from the view
        private val delete: Button       = view.findViewById(R.id.delete_button)
        private val title: TextView      = view.findViewById(R.id.title)
        private val thumbnail: ImageView = view.findViewById(R.id.thumbnail)

        // Sets component data from passed in video
        fun bind(item: Video) {
            title.text = item.title
            // Old code
            // (context as App).loadBitmap(item.videoId, thumbnail)
            Picasso.get().load(item.thumbnail.source)
                .placeholder(R.drawable.ic_black)
                .error(R.drawable.thumbnail_not_found)
                .into(thumbnail)
            // Sets on click listener, function provided during instantiation
            delete.setOnClickListener {
                listener(item)
            }
        }
    }
}
