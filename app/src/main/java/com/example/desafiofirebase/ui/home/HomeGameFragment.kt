package com.example.desafiofirebase.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.desafiofirebase.R
import com.example.desafiofirebase.databinding.FragmentHomeGameBinding

class HomeGameFragment : Fragment() {

    private var _binding: FragmentHomeGameBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeGameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botaoFlutuante.setOnClickListener {
            findNavController().navigate(R.id.action_homeGameFragment2_to_cadastroGameFragment3)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}