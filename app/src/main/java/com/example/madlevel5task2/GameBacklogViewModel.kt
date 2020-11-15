package com.example.madlevel5task2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class GameBacklogViewModel  (application: Application) : AndroidViewModel(application) {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val gameBacklogRepository = GameBacklogRepository(application.applicationContext)

    val backlogs: LiveData<List<GameBacklog>> = gameBacklogRepository.getGameBacklog()

    fun insertGameBacklog(backlog: GameBacklog) {
        ioScope.launch { gameBacklogRepository.insertGameBacklog(backlog) }
    }

    fun deleteGameBacklog(backlog: GameBacklog) {
        ioScope.launch {
            gameBacklogRepository.deleteGameBacklog(backlog)
        }
    }

    fun updateGameBacklog(backlog: GameBacklog) {
        ioScope.launch {
            gameBacklogRepository.updateGameBacklog(backlog)
        }
    }

    fun deleteAllGameacklogs(){
        ioScope.launch {
            gameBacklogRepository.deleteAllGameBacklogs()
        }
    }
}