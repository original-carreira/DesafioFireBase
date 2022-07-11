package com.example.desafiofirebase.domain.usecase

import android.net.Uri
import com.example.desafiofirebase.data.GameRepository

class UploadGameImageImplementation(
    private val gameRepository: GameRepository
): UploadImageGameUseCase {

    override suspend fun invoke(imageUri: Uri): String {
        return gameRepository.uploadImageGame(imageUri)
    }
}