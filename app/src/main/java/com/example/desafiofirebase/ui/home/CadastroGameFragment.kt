package com.example.desafiofirebase.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafiofirebase.R
import com.example.desafiofirebase.databinding.FragmentCadastroGameBinding

class CadastroGameFragment : Fragment() {

   private var _binding: FragmentCadastroGameBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CadastroGameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCadastroGameBinding.inflate(inflater,container,false)
        return binding.root
    }

}