package com.example.madlevel5task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_game.view.*
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat

class GameBacklogAdapter (private val backlogs: List<GameBacklog>) : RecyclerView.Adapter<GameBacklogAdapter.ViewHolder>(){

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun databind(gameBacklog: GameBacklog){

            itemView.tvGameName.text = gameBacklog.title
            itemView.tvPlatform.text = gameBacklog.platform
            itemView.tvReleaseDate.text = String.format("Release: " + gameBacklog.releaseDate.date + " " +
                    DateFormatSymbols.getInstance().months[gameBacklog.releaseDate.month-1] + " " +
                    gameBacklog.releaseDate.year)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(backlogs[position])
    }

    override fun getItemCount(): Int {
        return backlogs.size
    }
}