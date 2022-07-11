package com.example.desafiofirebase.domain.usecase


/*
*Esta interface faz o upload da imagem para o Firebase
 */

import android.net.Uri

interface UploadImageGameUseCase {

    suspend operator fun invoke(imageUri: Uri):String
}