package com.example.madlevel5task2

import android.content.Context

class GameBacklogRepository(context: Context) {

    private val gameBacklogDao: GameBacklogDao

    init {
        val database = GameBacklogRoomDatabase.getDatabase(context)
        gameBacklogDao = database!!.gameBacklogDao()
    }



}