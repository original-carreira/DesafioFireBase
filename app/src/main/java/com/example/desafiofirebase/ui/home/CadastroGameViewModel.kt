package com.example.desafiofirebase.ui.home

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiofirebase.MainActivity
import com.example.desafiofirebase.R
import com.example.desafiofirebase.domain.model.Game
import com.example.desafiofirebase.domain.usecase.CreateGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CadastroGameViewModel @Inject constructor(
    private val createGameUseCase: CreateGameUseCase
) : ViewModel() {

    private val _nameGameErroResId = MutableLiveData<Int?>()
    val nameGameErroResID:LiveData<Int?> = _nameGameErroResId

    private val _dataGameErroResId = MutableLiveData<Int?>()
    val dataGameErroResId: LiveData<Int?> = _dataGameErroResId

    private val _descriptionErroResId = MutableLiveData<Int?>()
    val descriptionResId: LiveData<Int?> = _descriptionErroResId

    private val _imageUriErroResId = MutableLiveData<Int>()
    val imageUriErroResId: LiveData<Int> = _imageUriErroResId

    private val _gameAdd = MutableLiveData<Game>()
    val gameAdd: LiveData<Game> = _gameAdd

    private var formularioValidacao = false

    fun createGame(nameGame: String, dataGame: String, descriptionGame: String,imageUri: Uri?) = viewModelScope.launch {
        formularioValidacao = true

        _nameGameErroResId.value = getErroStringResIDVazio(nameGame)
        _dataGameErroResId.value = getErroStringResIDVazio(dataGame)
        _descriptionErroResId.value = getErroStringResIDVazio(descriptionGame)
        _imageUriErroResId.value = getRecursoResIdNull(imageUri)

        if (formularioValidacao){
            try {
                val game = createGameUseCase(nameGame, dataGame, descriptionGame, imageUri!!)
                _gameAdd.value = game
            }catch (e: Exception){
                erroToast("Erro!",MainActivity())
                //Log.d("CreateGame",e.toString())
            }
        }
    }

    private fun getErroStringResIDVazio(value:String):Int?{
        return if (value.isEmpty()){
            formularioValidacao = false
            R.string.add_game_field_error
        }else null
    }

    private fun getRecursoResIdNull(value: Uri?):Int{
        return if (value == null){
            formularioValidacao = false
            R.drawable.background_image_erro
        }else R.drawable.background_image_sucesso
    }
    private fun erroToast(msg:String,ctx:Context) = Toast.makeText(ctx,msg, Toast.LENGTH_SHORT).show()

}

/*
* createGame -> vai ser chamada pelo fragmento para passar os dados do Game, faz a validação dos campos.
* getRecursoResIdNull &  getErroStringResIDVazio -> informa ao usuario o preenchimento correto dos campos.
*/