package com.example.madlevel5task2

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GameBacklogDao {

    @Insert
    suspend fun insertGame(game: GameBacklog)

    @Query("SELECT * FROM gameTable")
    fun getGameBacklogs(): LiveData<List<GameBacklog>>

    @Update
    suspend fun updateGameBacklog(game: GameBacklog)

    @Delete
    suspend fun deleteGameBacklog(gameBacklog: GameBacklog)

    @Query("DELETE FROM gameTable")
    suspend fun deleteAllGameBacklogs()
}