package com.example.desafiofirebase.ui.home

import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.example.desafiofirebase.R
import com.example.desafiofirebase.databinding.FragmentCadastroGameBinding

class CadastroGameFragment : Fragment() {

   private var _binding: FragmentCadastroGameBinding? = null
    private val binding get() = _binding!!
    private var imageUri: Uri? = null
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()){
        uri -> imageUri = uri
    }
    private lateinit var viewModel: CadastroGameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastroGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun setListeners(){
        binding.botaoFlutuanteAddGame.setOnClickListener {

        }

        binding.buttonSavedGame.setOnClickListener {
            val nomeGame = binding.nameCreateEditText.text.toString()
            val dataGame = binding.dataAddGameEditText.text.toString()
            val descriptionGame = binding.descriptionAddGameEditText.text.toString()
        }

    }

}