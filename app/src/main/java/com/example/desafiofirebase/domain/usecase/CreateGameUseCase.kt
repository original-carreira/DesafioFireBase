package com.example.desafiofirebase.domain.usecase

/*
*Esta interface faz o upload da imagem para o Firebasecadastra o game
*/

import android.net.Uri
import com.example.desafiofirebase.domain.model.Game

interface CreateGameUseCase {
    suspend operator fun invoke(name:String, data:String, description: String, imageUri: Uri):Game
}