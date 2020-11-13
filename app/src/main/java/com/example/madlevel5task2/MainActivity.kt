package com.example.madlevel5task2

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var gameBacklogRepository: GameBacklogRepository
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setSupportActionBar(toolbar)
        navController = findNavController(R.id.nav_host_fragment)

        findViewById<FloatingActionButton>(R.id.fabAdd).setOnClickListener { view ->

        }

        fabToggler()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_delete -> {
                deleteGameBacklogs()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun deleteGameBacklogs() {

    }

    private fun fabToggler() {
        navController.addOnDestinationChangedListener { _,       destination, _ ->
            if (destination.id in arrayOf(R.id.addGameFragment)) {
                fabAdd.hide()
                fabSave.show()
            } else if (destination.id in arrayOf(R.id.gameBacklogFragment)){
                fabAdd.show()
                fabSave.show()
            }
        }
    }
}