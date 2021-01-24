package com.missionchurchcooljc.mcc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.home_bottom_navigation)

        val navGraphIds = listOf(
            R.navigation.aboutus,
            R.navigation.connect,
            R.navigation.listen,
            R.navigation.pray,
            R.navigation.info
        )
//        val navGraphIds = listOf(R.navigation.nav_graph_main)
//        val navGraphIds = listOf(R.navigation.nav_graph_main, R.navigation.list, R.navigation.form)

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.mainNavHostFragment,
            intent = intent
        )

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(this, Observer { navController ->
            setupActionBarWithNavController(navController)
        })
        currentNavController = controller
    }

//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.mainNavHostFragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        val action = AboutUsFragmentDirections
//        navController.navigate(ac)
//        findNavController().navigate(AboutUsFragmentDirections)
//            .navigate(TitleFragmentDirections.actionTitleToGame())

//    private fun handleNavLabels(){
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.mainNavHostFragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            if(destination.id == R.id.aboutus_nav) {
//                toolbar.visibility = View.GONE
//                bottomNavigationView.visibility = View.GONE
//            } else {
//                toolbar.visibility = View.VISIBLE
//                bottomNavigationView.visibility = View.VISIBLE
//            }
//        }
//    }

    init {
        Log.d("LIFECYCLE", "{${this.javaClass.simpleName}} Class Created")
    }
}