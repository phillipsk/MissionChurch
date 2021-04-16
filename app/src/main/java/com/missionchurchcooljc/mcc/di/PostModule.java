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

import com.missionchurchcooljc.mcc.posts.PostFragmentPresenter;
import com.missionchurchcooljc.mcc.posts.PostMVP;
import com.missionchurchcooljc.mcc.posts.PostModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kevin Phillips and Sunday Akinsete on 18/05/2018.
 */

//@InstallIn(FragmentComponent.class)
@Module
public class PostModule {


//    @Provides
//    public PostMVP.Presenter bindPostMVP(
//            PostFragmentPresenter postFragmentPresenter){
//        return new PostFragmentPresenter(new PostModel());
//    }

//    @Provides
//    public PostMVP.Presenter bindPostMVP(PostMVPImpl postMVPImpl){
//        return new PostFragmentPresenter(new PostModel());
//    }

    @Provides
    public PostMVP.Presenter providePostFragmentPresenter() {
        return new PostFragmentPresenter(new PostModel());
    }

    @Provides
    public PostMVP.Model providePostModel(){
        return new PostModel();
    }

}