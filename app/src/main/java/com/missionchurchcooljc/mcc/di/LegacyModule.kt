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

package com.missionchurchcooljc.mcc.di

import androidx.fragment.app.Fragment
import com.missionchurchcooljc.mcc.MainActivity
import com.missionchurchcooljc.mcc.ui.ConnectFragment
import com.missionchurchcooljc.mcc.ui.PostMVPkt
import com.missionchurchcooljc.mcc.ui.PostModelKt
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class LegacyModule {

//    @Binds
//    abstract fun bindActivity(activity: MainActivity): PostMVPkt.View
//
    @Binds
    abstract fun bindFragment(fragment: ConnectFragment): PostMVPkt.View

    @Binds
    abstract fun bindPresenter(impl: PostMVPktImpl): PostMVPkt.Presenter

//    @Binds
//    abstract fun bindView(impl: PostMVPktImpl.View): PostMVPkt.View

    @Binds
    abstract fun bindModel(impl: PostModelKt): PostMVPkt.Model
}

@InstallIn(FragmentComponent::class)
@Module
object ConnectFragmentModule {

    @Provides
    fun bindFragment(fragment: Fragment): ConnectFragment {
        return fragment as ConnectFragment
    }

//    @Provides
//    fun bindActivity(activity: MainActivity): MainActivity {
//        return activity as MainActivity
//    }
}

//    @Singleton
//    @Provides
//    fun provideMapFragment(): SupportMapFragment {
//        return SupportMapFragment.newInstance()
//    }
//
//    @Provides
//    fun bindActivity(activity: Activity): MainActivity {
//        return activity as MainActivity
//    }

//    @Binds
//    abstract fun bindActivity(activity: MainActivity): MainContract.View

//    @Binds
//    abstract fun bindPostMVP(impl: PostMVP): PostMVP
//    abstract fun bindPresenter(view: PostMVP.Presenter): PostMVP.Presenter

//@Module
//class FragmentModule {
//    @Provides
//    fun providePostMvpPresenter(): PostMVP.Presenter {
//        return PostMVP.Presenter
//    }
//
//}
//
//@Module
//class ActivityModule(private var activity: Activity) {
//    @Provides
//    fun provideActivity(): Activity {
//        return activity
//    }
//
//    @Provides
//    fun providePresenter(): PostMVP.Presenter {
//        return PostMVP.Presenter()
//    }
//}

//    @Singleton
//    @Provides
//    fun provideDAOSession(): DaoSession {
//        val helper =
//            DaoMaster.DevOpenHelper(
//                @ApplicationContext,
//                "fmcdb"
//            ) //The users-db here is the name of our database.
//
//        val db = helper.writableDb
//        return DaoMaster(db).newSession()
//    }


//    @Singleton
//    @Provides
//    fun provideHighlightsService(): ChurchWebsiteService {
//        return Retrofit.Builder()
//            .baseUrl("https://god.works/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ChurchWebsiteService::class.java)
//    }

