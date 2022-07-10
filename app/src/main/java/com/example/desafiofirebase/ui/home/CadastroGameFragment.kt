package com.example.desafiofirebase.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafiofirebase.R

class CadastroGameFragment : Fragment() {

    companion object {
        fun newInstance() = CadastroGameFragment()
    }

    private lateinit var viewModel: CadastroGameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cadastro_game, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CadastroGameViewModel::class.java)
        // TODO: Use the ViewModel
    }

}