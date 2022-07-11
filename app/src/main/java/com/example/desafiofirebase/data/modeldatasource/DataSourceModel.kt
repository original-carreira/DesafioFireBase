package com.example.desafiofirebase.data.modeldatasource

import com.example.desafiofirebase.data.FirebaseGameDataSource
import com.example.desafiofirebase.data.GameDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModel {

    @Singleton
    @Binds
    fun bindGameDataSource(dataSource: FirebaseGameDataSource): GameDataSource
}