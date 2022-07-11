package com.example.desafiofirebase.domain.usecase.injection

import com.example.desafiofirebase.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface ModuloDominio {

    @Binds
    fun bindCreateGameUseCase(useCase: CreateGameImplementation): CreateGameUseCase

    @Binds
    fun bindGetUseCase(useCase: GetGameImplementation): GetGameUseCase

    @Binds
    fun bindUploadImageGameUseCase(useCase: UploadGameImageImplementation): UploadImageGameUseCase
}