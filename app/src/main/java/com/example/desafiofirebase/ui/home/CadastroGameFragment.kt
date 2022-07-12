package com.example.desafiofirebase.ui.home

import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.example.desafiofirebase.R
import com.example.desafiofirebase.databinding.FragmentCadastroGameBinding
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CadastroGameFragment : Fragment() {

   private var _binding: FragmentCadastroGameBinding? = null
    private val binding get() = _binding!!
    private var imageUri: Uri? = null
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()){
        uri -> imageUri = uri
        binding.botaoFlutuanteAddGame.setImageURI(uri)
    }
    private val viewModel: CadastroGameViewModel by  viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastroGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeOsEventosViewModel()
        setListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeOsEventosViewModel(){
        viewModel.nameGameErroResID.observe(viewLifecycleOwner){
            stringResID -> binding.nameAddGameLayout.setError(stringResID)
        }
        viewModel.dataGameErroResId.observe(viewLifecycleOwner){
            stringResID -> binding.dataAddGameLayout.setError(stringResID)
        }
        viewModel.descriptionResId.observe(viewLifecycleOwner){
            stringResID -> binding.descriptionAddGameLayout.setError(stringResID)
        }
        viewModel.imageUriErroResId.observe(viewLifecycleOwner){
            recursoResId -> binding.botaoFlutuanteAddGame.setBackgroundResource(recursoResId)
        }
    }

    private fun TextInputLayout.setError(stringResID:Int?){
        error = if (stringResID != null){
            getString(stringResID)
        }else null
    }

    private fun setListeners(){
        binding.botaoFlutuanteAddGame.setOnClickListener {
            troqueImagem()
        }

        binding.buttonSavedGame.setOnClickListener {
            val nomeGame = binding.nameCreateEditText.text.toString()
            val dataGame = binding.dataAddGameEditText.text.toString()
            val descriptionGame = binding.descriptionAddGameEditText.text.toString()

            viewModel.createGame(nomeGame,dataGame,descriptionGame,imageUri)
        }

    }

    private fun troqueImagem(){
        getContent.launch("imageUri/*")
    }

}

// linha 21 - o segundo parâmetro do ActivityResultcontracts e um callback, que é passado no {} fora do contexto do ().
//callback passado como último parâmetro não precisa ser chamado dentro dos parenteses.