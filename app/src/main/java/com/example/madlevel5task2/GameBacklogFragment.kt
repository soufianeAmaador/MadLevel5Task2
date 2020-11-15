package com.example.madlevel5task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_game_backlog.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GameBacklogFragment : Fragment() {

    private val gameBackLogs = arrayListOf<GameBacklog>()
    private val gameBacklogAdapter = GameBacklogAdapter(gameBackLogs)

    private val viewModel: GameBacklogViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_backlog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        observeAddGameBacklogResult()
    }

    private fun initViews(){
        rvGames.layoutManager =
            LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        rvGames.adapter = gameBacklogAdapter

        createItemTouchHelper().attachToRecyclerView(rvGames)
    }

    private fun observeAddGameBacklogResult() {
        viewModel.backlogs.observe(viewLifecycleOwner, Observer {
            gameBackLogs ->
            this@GameBacklogFragment.gameBackLogs.clear()
            this@GameBacklogFragment.gameBackLogs.addAll(gameBackLogs)
            gameBacklogAdapter.notifyDataSetChanged()
        })
    }


    private fun createItemTouchHelper(): ItemTouchHelper {
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val backlogToDelete = gameBackLogs[position]

                viewModel.deleteGameBacklog(backlogToDelete)
            }
        }
        return ItemTouchHelper(callback)
    }


}