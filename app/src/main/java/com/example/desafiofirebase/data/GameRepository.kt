package com.example.desafiofirebase.data

/*
*cada UserCase possui uma função no repository.
* permite o funcionamento dos UserCase.
*/

import android.net.Uri
import com.example.desafiofirebase.domain.model.Game

class GameRepository (private val dataSource: GameDataSource){

    suspend fun getGame(): List<Game> = dataSource.getGame()

    suspend fun uploadImageGame(imageUri: Uri):String  = dataSource.uploadImageGame(imageUri)

    suspend fun createGame(game: Game): Game = dataSource.createGame(game)
}