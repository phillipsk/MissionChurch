///*
// * Copyright (c) 2021 Kevin Phillips, Mission Church of Our Lord Jesus Christ
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// * http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.missionchurchcooljc.mcc.di.modules;
//
//import android.app.Application;
//import android.content.Context;
//
//import com.missionchurchcooljc.mcc.users.SessionManager;
//
//import javax.inject.Singleton;
//
//import dagger.Module;
//import dagger.Provides;
//
///**
// * Created by  Kevin Phillips and Sunday Akinsete on 21/02/2018.
// */
//
////@InstallIn(SingletonComponent.class)
//@Module
//public class ApplicationModule {
//
//    private final Application application;
//
//
//    public ApplicationModule(Application application) {
//        this.application = application;
//    }
//
//
//    @Provides
//    @Singleton
//    public Context provideContext() {
//        return application;
//    }
//
//
//    @Provides
//    public SessionManager provideSessionManager(Context context) {
//        return new SessionManager(context);
//    }
//
//    //    public WebsiteRepository provideWebsiteRepository
//}
