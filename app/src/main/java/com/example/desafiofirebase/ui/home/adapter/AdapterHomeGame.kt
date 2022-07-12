package com.example.desafiofirebase.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafiofirebase.databinding.ItemGameBinding
import com.example.desafiofirebase.domain.model.Game

class AdapterHomeGame:ListAdapter<Game, AdapterHomeGame.HomeGameViewHolder>(DiffUtilCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeGameViewHolder {
        return HomeGameViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: HomeGameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomeGameViewHolder(
        private val itemGameBinding: ItemGameBinding
    ): RecyclerView.ViewHolder(itemGameBinding.root){

        fun bind(game: Game){
            itemGameBinding.run {
                Glide.with(itemView).load(game.imageUrlGame).fitCenter().into(campoImagemDogame)

                campoTextoNomeGame.text = game.nameGame
                campoTextoDataGame.text = game.dataGame
            }
        }

        companion object{
            fun create(parent: ViewGroup): HomeGameViewHolder{
                val itemGameBinding = ItemGameBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return HomeGameViewHolder(itemGameBinding)
            }
        }
    }

    companion object{
        private val DiffUtilCallBack = object: DiffUtil.ItemCallback<Game>(){
            override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
                return oldItem == newItem
            }
        }
    }
}