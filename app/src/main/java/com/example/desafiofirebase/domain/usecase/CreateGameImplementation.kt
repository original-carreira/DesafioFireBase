package com.example.desafiofirebase.domain.usecase

import android.net.Uri
import com.example.desafiofirebase.data.GameRepository
import com.example.desafiofirebase.domain.model.Game
import java.lang.Exception
import java.util.*

class CreateGameImplementation(
    private val uploadImageGameUseCase: UploadImageGameUseCase,
    private val gameRepository: GameRepository
): CreateGameUseCase {

    override suspend fun invoke(
        name: String,
        data: String,
        description: String,
        imageUrl: Uri
    ): Game {
        return try {
            val imageUrl = uploadImageGameUseCase.invoke(imageUrl)
            val game = Game(UUID.randomUUID().toString(),name, data,description,imageUrl)
            gameRepository.createGame(game)
        }catch (e: Exception){
            throw e
        }
    }
}