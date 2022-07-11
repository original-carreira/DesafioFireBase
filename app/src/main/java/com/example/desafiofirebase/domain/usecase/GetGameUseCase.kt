package com.example.desafiofirebase.domain.usecase

/*
*Esta interface faz a busca da lista de imagens do Firebase (retorna o URI)
 */

import android.net.Uri
import com.example.desafiofirebase.domain.model.Game

interface GetGameUseCase {

    suspend operator fun invoke():List<Game>
}