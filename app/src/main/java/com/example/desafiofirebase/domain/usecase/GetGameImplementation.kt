package com.example.desafiofirebase.domain.usecase

import com.example.desafiofirebase.data.GameRepository
import com.example.desafiofirebase.domain.model.Game
import javax.inject.Inject

class GetGameImplementation @Inject constructor(
    private val gameRepository: GameRepository
): GetGameUseCase{

    override suspend fun invoke(): List<Game> {
        return gameRepository.getGame()
    }
}