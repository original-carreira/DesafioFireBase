package com.example.desafiofirebase.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.desafiofirebase.databinding.ItemGameBinding
import com.example.desafiofirebase.domain.model.Game

class AdapterHomeGame {

    class HomeGameViewHolder(
        private val itemGameBinding: ItemGameBinding
    ): RecyclerView.ViewHolder(itemGameBinding.root){

        fun bind(game: Game){
            itemGameBinding.run {
                
            }
        }
    }
}