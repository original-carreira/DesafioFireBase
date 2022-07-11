package com.example.desafiofirebase.domain.usecase

import android.net.Uri
import com.example.desafiofirebase.data.GameRepository
import javax.inject.Inject

class UploadGameImageImplementation@Inject constructor(
    private val gameRepository: GameRepository
): UploadImageGameUseCase {

    override suspend fun invoke(imageUri: Uri): String {
        return gameRepository.uploadImageGame(imageUri)
    }
}