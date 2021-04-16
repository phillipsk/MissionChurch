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

package com.missionchurchcooljc.mcc.di.modules

import android.app.Application
import android.content.Context
import com.missionchurchcooljc.mcc.feature_highlights.AboutUsModule
import com.missionchurchcooljc.mcc.feature_highlights.mvvm.di.ViewModelModule
import com.missionchurchcooljc.mcc.persistence.DataBaseModule
import com.missionchurchcooljc.mcc.users.SessionManager
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [
    AppProviderModule::class, AboutUsModule::class,
    NetworkModule::class, ViewModelModule::class,
    DataBaseModule::class, CoroutineContextModule::class
])
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

}
@Module
object AppProviderModule {
//    @Provides
//    @Singleton
//    fun providesApplication(): Application = application
//
//    @Provides
//    @Singleton
//    fun providesApplicationContext(): Context = application

    @Provides
    fun provideSessionManager(context: Context): SessionManager {
        return SessionManager(context)
    }
}