package com.example.desafiofirebase.ui.login

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.desafiofirebase.R
import com.example.desafiofirebase.databinding.FragmentTelaLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class TelaLoginFragment : Fragment() {

    private var _binding: FragmentTelaLoginBinding? = null
    private val binding get() = _binding!!
    private val auth = FirebaseAuth.getInstance()

    private val viewModel: TelaLoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTelaLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setListeners() {
        binding.buttonLogin.setOnClickListener {view ->
            val email =binding.emailLoginEditText.text.toString()
            val senha = binding.senhaUserLoginEditText.text.toString()

            if (email.isEmpty() || senha.isEmpty()){
                val snackbar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }else {
                auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener { resultadoCadstro ->
                    if (resultadoCadstro.isSuccessful){
                        val snackbar =Snackbar.make(view,"Sucesso no cadastro do usuário!",Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.BLUE)
                        snackbar.show()
                        binding.emailLoginEditText.setText("")
                        binding.senhaUserLoginEditText.setText("")
                    }
                }.addOnFailureListener { exception ->
                    val messagemError =  when(exception){
                        is FirebaseAuthWeakPasswordException -> "Senha inferior a 6 caracteres"
                        is FirebaseAuthInvalidCredentialsException -> "Digite um e-mail válido!"
                        is FirebaseAuthUserCollisionException -> "Conta já existente!"
                        is FirebaseNetworkException -> "SEm conexão com a internet"
                        else -> "Erro ao cadastrar usuario!"
                    }
                    val snackbar = Snackbar.make(view, messagemError, Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }
            }
        }
    }

}