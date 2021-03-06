package com.mitchelltsutsulis.tube_loader.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video(val videoId: String, var title: String,
                 val thumbnail: Thumbnail,
                 var queued: Boolean = false,
                 val downloaded: Boolean = false,
                 val backendId: Int = -1): Parcelable
