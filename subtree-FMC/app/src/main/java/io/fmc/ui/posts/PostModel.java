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

package io.fmc.ui.posts;

import java.util.List;

import io.fmc.data.FMCApi;
import io.fmc.data.models.AnnouncementPost;

/**
 * Created by  Kevin Phillips and Sunday Akinsete on 18/05/2018.
 */
public class PostModel implements PostMVP.Model {


    public interface OnPostsFetched {

        void onPostItemsFetched(List<AnnouncementPost> posts);

        void onPostItemFetched(AnnouncementPost post);

        void onError(String message);
    }



    @Override
    public void fetchPosts(OnPostsFetched onPostsFetched) {
        FMCApi.listenToPostChanges(onPostsFetched);
    }

}
