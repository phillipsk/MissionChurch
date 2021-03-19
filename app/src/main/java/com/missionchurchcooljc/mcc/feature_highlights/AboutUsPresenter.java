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

import androidx.lifecycle.LiveData;

import com.missionchurchcooljc.data_android.WebsiteHighlight;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AboutUsPresenter implements AboutUsMVP.Presenter {
    AboutUsMVP.View view;
    AboutUsMVP.Model model;

    //    @Inject
    public AboutUsPresenter(AboutUsModel aboutUsModel) {
        this.model = aboutUsModel;
    }

    @Override
    public void setView(AboutUsMVP.View view) {
        this.view = view;
    }

    @Override
    public void fetchPosts(WebsiteRepository websiteRepository) {
//        websiteRepository.getHighlightsAsList();
        List<WebsiteHighlight> highlights =
                websiteRepository.getHighlightsAsList();
        view.displayPosts(highlights);

//        TODO: review DAO class with Dagger
        model.fetchPosts(new AboutUsModel.OnPostsFetched() {
            @NotNull
            @Override
            public List<WebsiteHighlight> listHighlights() {
                return null;
            }

            @Override
            public void insertAll(@NotNull List<WebsiteHighlight> highlightList) {

            }

            @NotNull
            @Override
            public LiveData<WebsiteHighlight> getHighlight(@NotNull String websiteHighlightId) {
                return null;
            }

            @NotNull
            @Override
            public List<WebsiteHighlight> getHighlightsAsList() {
                return null;
            }

            @NotNull
            @Override
            public LiveData<List<WebsiteHighlight>> getHighlights() {
                return null;
            }
        });

    }
}
