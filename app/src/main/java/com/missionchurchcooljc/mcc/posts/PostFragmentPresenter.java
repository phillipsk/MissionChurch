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

package com.missionchurchcooljc.mcc.posts;

import com.missionchurchcooljc.mcc.data.models.AnnouncementPost;

import java.util.Collections;
import java.util.List;

/**
 * Created by  Kevin Phillips and Sunday Akinsete on 17/05/2018.
 */

public class PostFragmentPresenter implements PostMVP.Presenter {


    PostMVP.View view;
    PostMVP.Model postModel;

//    @Inject
    public PostFragmentPresenter(PostModel postModel) {
        this.postModel = postModel;
    }

    @Override
    public void setView(PostMVP.View view) {
        this.view = view;
    }

    @Override
    public void fetchPosts() {
        postModel.fetchPosts(new PostModel.OnPostsFetched() {
            @Override
            public void onPostItemsFetched(List<AnnouncementPost> posts) {
                if(view != null){
                    Collections.reverse(posts);
                    view.displayPosts(posts);
                }
            }

            @Override
            public void onPostItemFetched(AnnouncementPost post) {

            }

            @Override
            public void onError(String message) {
                //Log.e("databaseError", String.valueOf(message));

            }
        });
    }
}
