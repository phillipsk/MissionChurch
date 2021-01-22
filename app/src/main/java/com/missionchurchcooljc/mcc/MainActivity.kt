package com.missionchurchcooljc.mcc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//    TODO: multi-module app
//    Firebase integration & login
//    User posts; saved to Firebase
//    Fix launcher icon
//    Hide top app bar toolbar and bottom navigation bar upon RV scrolling

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }

//        TODO: to properly implement an icon on the appbar / tab icon / actionbar
//          review these links, as of now the toolbar is under the Fragment navigation
//          component label, creating a duplicate toolbar view, review these links and
//          further to handle hiding the Androidx Nav component fragment label upon
//          switching fragments with AndroixX navController and directions
//        https://developer.android.com/guide/navigation/navigation-ui#create_a_toolbar
//        https://stackoverflow.com/questions/64394283/collapsing-toolbar-with-navigation-ui-android
//        https://github.com/android/sunflower/search?q=findNavController
//        https://github.com/android/sunflower/blob/46c0db57a4a7bae070c66fd390b920de4c3cf27f/app/src/main/res/layout/fragment_gallery.xml
//        https://stackoverflow.com/questions/56974395/how-to-fix-collapsingtoolbarlayout-not-collapsing-with-recyclerview-using-the-je
//        https://stackoverflow.com/questions/53372539/navigation-graph-with-multiple-top-level-destinations
//        https://stackoverflow.com/questions/59827803/how-to-set-navigationview-with-appbarconfiguration
        val layout = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.mainNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
//        val appBarConfiguration = AppBarConfiguration(navController.graph)
        layout.setupWithNavController(toolbar, navController)
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