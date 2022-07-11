package com.example.desafiofirebase.data

import android.net.Uri
import com.example.desafiofirebase.domain.model.Game

interface GameDataSource {
    suspend fun getGame(): List<Game>
    suspend fun uploadImageGame(imageUri: Uri):String
    suspend fun createGame(game: Game):Game
}