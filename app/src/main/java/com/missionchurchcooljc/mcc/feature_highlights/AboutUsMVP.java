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

package com.missionchurchcooljc.mcc.feature_highlights;

import com.missionchurchcooljc.data_android.WebsiteHighlight;

import java.util.List;

public interface AboutUsMVP {
    interface View {

        void displayPosts(List<WebsiteHighlight> highlights);

    }

    interface Presenter {

        void setView(AboutUsMVP.View view);

        void fetchPosts(WebsiteRepository websiteRepository);

    }


    interface Model {

        void fetchPosts(AboutUsModel.OnPostsFetched onPostsFetched);

    }
}
