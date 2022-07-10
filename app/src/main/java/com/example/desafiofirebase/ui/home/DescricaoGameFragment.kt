package com.example.desafiofirebase.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafiofirebase.R

class DescricaoGameFragment : Fragment() {

    companion object {
        fun newInstance() = DescricaoGameFragment()
    }

    private lateinit var viewModel: DescricaoGameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_descricao_game, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DescricaoGameViewModel::class.java)
        // TODO: Use the ViewModel
    }

}