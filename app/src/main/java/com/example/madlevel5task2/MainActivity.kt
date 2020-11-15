package com.example.madlevel5task2

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var gameBacklogRepository: GameBacklogRepository
    private lateinit var navController: NavController
    private final val BACK_BUTTON_ID = 16908332

    private val viewModel: GameBacklogViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setSupportActionBar(toolbar)
        navController = findNavController(R.id.nav_host_fragment)

        findViewById<FloatingActionButton>(R.id.fabAdd).setOnClickListener { view ->
            navController.navigate(R.id.action_gameBacklogFragment_to_addGameFragment)
        }

        println("THIS IS THE ID: " + R.id.home)

        fabToggler()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        navController.addOnDestinationChangedListener { _, destination, _ ->
        if (destination.id in arrayOf(R.id.gameBacklogFragment)){
            toolbar.title = "Game Backlog"
            supportActionBar?.setDisplayShowHomeEnabled(false)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            toolbar.menu.findItem(R.id.action_delete).isVisible = true

        }else if (destination.id in arrayOf(R.id.addGameFragment)){
            toolbar.title = "Add Game"
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            toolbar.menu.findItem(R.id.action_delete).isVisible = false
        }

        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_delete -> {
                viewModel.deleteAllGameacklogs()

                return true
            }
            BACK_BUTTON_ID -> {
                super.onBackPressed()
                //navController.popBackStack()
                return true
            }

            else -> super.onOptionsItemSelected(item)

        }
        invalidateOptionsMenu()
        return true
    }



    private fun fabToggler() {
        navController.addOnDestinationChangedListener { _,       destination, _ ->
            if (destination.id in arrayOf(R.id.addGameFragment)) {
                fabAdd.hide()
            } else if (destination.id in arrayOf(R.id.gameBacklogFragment)){
                fabAdd.show()
            }
        }
    }
}