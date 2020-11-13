package com.example.madlevel5task2

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GameBacklogDao {

    @Insert
    suspend fun insertGame(game: Game)

    @Query("SELECT * FROM gameTable")
    fun getGames(): LiveData<List<Game?>>

    @Update
    suspend fun updateGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)
}