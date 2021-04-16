/*
 * Copyright (c) 2021 Kevin Phillips, Mission Church of Our Lord Jesus Christ
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.missionchurchcooljc.mcc

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.missionchurchcooljc.mcc.di.AppController

//import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//    TODO: multi-module app
//    Firebase integration & login
//    User posts; saved to Firebase
//    Fix launcher icon
//    Hide top app bar toolbar and bottom navigation bar upon RV scrolling

    private var currentNavController: LiveData<NavController>? = null
//    private val applicationComponent get() = (application as AppController).component

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }

        val applicationComponent = (application as AppController).component

//        val dummyDependencyComponent = applicationComponent
//            .
//            .dummyDependencyBuilder()
//            .context(this)
//            .build()
//
//        dummyDependencyComponent.inject(this)
//        val component = DaggerApplicationComponent.builder()
//            .userModule(UserModule())
//            .postModule(PostModule())
//            .aboutUsModule(AboutUsModule())
//            .build();

        //        (application as MainApplication).appComponent.inject(this)
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