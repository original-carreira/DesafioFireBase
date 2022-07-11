package com.example.desafiofirebase.domain.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.google.firebase.firestore.PropertyName
import kotlinx.parcelize.Parcelize

@Parcelize

data class Game(
    val id: String = "",
    val nameGame: String = "",
    val dataGame: String = "",
    val descriptionGame: String = "",
    @get:PropertyName("image_url")
    @set:PropertyName("image_url")
    var imageUrlGame: String = ""
):Parcelable
