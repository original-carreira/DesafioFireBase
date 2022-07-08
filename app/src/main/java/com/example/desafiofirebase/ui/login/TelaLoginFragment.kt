package com.example.desafiofirebase.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafiofirebase.R

class TelaLoginFragment : Fragment() {

    companion object {
        fun newInstance() = TelaLoginFragment()
    }

    private lateinit var viewModel: TelaLoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TelaLoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}