package com.example.madlevel5task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_game.view.*

class GameBacklogAdapter (private val backlogs: List<GameBacklog>) : RecyclerView.Adapter<GameBacklogAdapter.ViewHolder>(){

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun databind(gameBacklog: GameBacklog){
            itemView.tvGameName.text = gameBacklog.title
            itemView.tvPlatform.text = gameBacklog.title
            itemView.tvPlatform.text = String.format("Release: " + gameBacklog.releaseDate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_game_backlog,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(backlogs[position])
    }

    override fun getItemCount(): Int {
        return backlogs.size
    }
}