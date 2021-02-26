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

import android.app.Application
import android.util.Log
import com.missionchurchcooljc.mcc.di.AppComponent
import com.missionchurchcooljc.mcc.di.modules.AppModule

//import com.missionchurchcooljc.mcc.com.missionchurchcooljc.feature_highlights.di.DaggerBaseComponent
//import com.missionchurchcooljc.mcc.com.missionchurchcooljc.feature_highlights.di.modules.ContextModule

//import dagger.hilt.android.HiltAndroidApp

//@HiltAndroidApp
class MainApplication : Application() {

//    lateinit var appComponent: AppComponent


    /**
     * Initialize core dependency injection component.
     */
//    TODO: implement VMadalin dagger design
//    private fun initBaseDependencyInjection() {
//        appComponent = DaggerBaseComponent.builder()
//            .appModule(AppModule(this))
////            .contextModule(ContextModule(this))
//            .build()
//    }


    override fun onCreate() {
        super.onCreate()
//        initBaseDependencyInjection()

    }

    //    /**
//     * Initialize app dependency injection component.
//     */
//    private fun initAppDependencyInjection() {
//        DaggerAppComponent
//            .builder()
//            .coreComponent(coreComponent)
//            .build()
//            .inject(this)
//    }
    init {
        Log.d("LIFECYCLE", "{${this.javaClass.simpleName}} Class Created")
    }
}