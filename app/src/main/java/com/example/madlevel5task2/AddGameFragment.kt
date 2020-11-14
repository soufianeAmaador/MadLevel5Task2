package com.example.madlevel5task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_game.*
import java.time.LocalDate
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGameFragment : Fragment() {

    private val viewModel: GameBacklogViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<Button>(R.id.fabSave).setOnClickListener {
//            saveGame()
//        }
    }

    //creer nieuwe date object en voeg dag maan jaar er aan toe
    private fun saveGame() {
        val gameTitle = tiTitle.text.toString()
        val platform = tiPlatform.text.toString()
        val date = GregorianCalendar(Integer.parseInt(tiYear.text.toString()),Integer.parseInt(tiMonth.toString()),Integer.parseInt(tiDay.text.toString()))
    }


}