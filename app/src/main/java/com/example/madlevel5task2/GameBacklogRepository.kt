package com.example.madlevel5task2

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GameBacklogRepository(context: Context) {

    private val gameBacklogDao: GameBacklogDao

    init {
        val database = GameBacklogRoomDatabase.getDatabase(context)
        gameBacklogDao = database!!.gameBacklogDao()
    }

    fun getGameBacklog(): LiveData<List<GameBacklog>> {
        return gameBacklogDao?.getGameBacklogs() ?:
                MutableLiveData(emptyList())
    }

    suspend fun insertGameBacklog(gameBacklog: GameBacklog) {
        gameBacklogDao.insertGame(gameBacklog)
    }

    suspend fun deleteGameBacklog(gameBacklog: GameBacklog) {
        gameBacklogDao.deleteGameBacklog(gameBacklog)
    }

    suspend fun updateGameBacklog(gameBacklog: GameBacklog) {
        gameBacklogDao.updateGameBacklog(gameBacklog)
    }

}