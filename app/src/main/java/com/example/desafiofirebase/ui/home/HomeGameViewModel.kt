package com.example.desafiofirebase.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiofirebase.domain.model.Game
import com.example.desafiofirebase.domain.usecase.GetGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeGameViewModel @Inject constructor(private val getGameUseCase: GetGameUseCase) : ViewModel() {

    private val _gamesData = MutableLiveData<List<Game>>()
    val gamesData: LiveData<List<Game>> = _gamesData

    fun getGames() = viewModelScope.launch {
        try {
            val games = getGameUseCase()
            _gamesData.value = games
        } catch (e: Exception){
            Log.d("GamesViewModel",e.toString())
        }
    }
}