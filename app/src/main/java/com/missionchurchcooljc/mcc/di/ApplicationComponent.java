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

package com.missionchurchcooljc.mcc.di;

import android.content.Context;

import com.missionchurchcooljc.mcc.di.modules.CoroutineContextModule;
import com.missionchurchcooljc.mcc.di.modules.NetworkModule;
import com.missionchurchcooljc.mcc.feature_highlights.AboutUsFragment;
import com.missionchurchcooljc.mcc.feature_highlights.AboutUsModule;
import com.missionchurchcooljc.mcc.feature_highlights.mvvm.HighlightsFragment;
import com.missionchurchcooljc.mcc.feature_highlights.mvvm.di.ViewModelModule;
import com.missionchurchcooljc.mcc.network.api.ChurchWebsiteRepository;
import com.missionchurchcooljc.mcc.persistence.DataBaseModule;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by  Kevin Phillips and Sunday Akinsete on 21/02/2018.
 */


//@InstallIn(SingletonComponent.class)
//@Module(includes = {ApplicationModule.class, UserModule.class, PostModule.class,
//                        LegacyModule.class})
//public interface ApplicationComponent{

@Singleton
@Component(modules = {ApplicationModule.class, AboutUsModule.class,
        NetworkModule.class, ViewModelModule.class, DataBaseModule.class, CoroutineContextModule.class})
public interface ApplicationComponent {

//    @Component.Builder
//    interface Builder {
//
//        @BindsInstance
//        Builder application(Application application);
//
//        AppComponent build();
//    }

    void inject(AboutUsFragment aboutUsFragment);

    void inject(HighlightsFragment highlightsFragment);

    void inject(ChurchWebsiteRepository churchWebsiteRepository);

    Context context();

//    void inject(UserRepoListActivity target);
//
//    void inject(RepoDetailActivity target);

//    void DummyDependencySubComponent.Builderr dummyDependencyBuilder

}


