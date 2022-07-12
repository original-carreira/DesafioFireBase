package com.example.desafiofirebase.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.enableSavedStateHandles
import androidx.navigation.fragment.findNavController
import com.example.desafiofirebase.R
import com.example.desafiofirebase.databinding.FragmentHomeGameBinding
import com.example.desafiofirebase.domain.model.Game
import com.example.desafiofirebase.ui.home.adapter.AdapterHomeGame
import com.example.desafiofirebase.util.GAME_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeGameFragment : Fragment() {

    private var _binding: FragmentHomeGameBinding? = null
    private val binding get() = _binding!!
    private val adapterHomeGame = AdapterHomeGame()

    private val viewModel: HomeGameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecycler()
        observerNavBackStack()
        observaEventosViewModel()
        viewModel.getGames()

        binding.botaoFlutuante.setOnClickListener {
            findNavController().navigate(R.id.action_homeGameFragment2_to_cadastroGameFragment3)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setRecycler(){
        binding.recyclerViewHome.run {
            setHasFixedSize(true)
            adapter = adapterHomeGame
        }
    }

    private fun observaEventosViewModel(){
        viewModel.gamesData.observe(viewLifecycleOwner){
            gamess -> adapterHomeGame.submitList(gamess)
        }
    }
    private fun observerNavBackStack(){
        findNavController().run {
            val navBackStackIN = getBackStackEntry(R.id.homeGameFragment2)
            val salvoEstadoHandle = navBackStackIN.savedStateHandle
            val observar = LifecycleEventObserver{ sorce, evento ->
                if(evento == Lifecycle.Event.ON_RESUME && salvoEstadoHandle.contains(GAME_KEY)){
                    val game = salvoEstadoHandle.get<Game>(GAME_KEY)
                    val oldList = adapterHomeGame.currentList
                    val newList = oldList.toMutableList().apply {
                        add(game)
                    }
                    adapterHomeGame.submitList(newList)
                    binding.recyclerViewHome.smoothScrollToPosition(newList.size - 1)
                    salvoEstadoHandle.remove<Game>(GAME_KEY)
                }
            }
            navBackStackIN.lifecycle.addObserver(observar)
            viewLifecycleOwner.lifecycle.addObserver(LifecycleEventObserver { source, event ->
                navBackStackIN.lifecycle.removeObserver(observar)
            })

        }
    }

}