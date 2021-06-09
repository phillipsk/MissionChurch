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

package io.fmc.ui.bible;

import javax.inject.Inject;

import io.fmc.network.BibleApi;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class BiblePresenter {

    private BibleApi bibleApi;
    private BibleScreen bibleScreen;
    private CompositeDisposable compositeDisposable;

    @Inject
    public BiblePresenter(BibleApi bibleApi) {
        this.bibleApi = bibleApi;
        this.compositeDisposable = new CompositeDisposable();
    }

    public void bind(BibleScreen bibleScreen) {
        this.bibleScreen = bibleScreen;
    }

    public void fetchBibleBooks(String bibleId) {
        compositeDisposable.add(bibleApi.getBibleBooks(bibleId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(booksResponse -> bibleScreen.onNewBibleBooks(booksResponse.data)));
//        compositeDisposable.add(bibleApi.getBibleBooks(bibleId).subscribeOn(Scheduler.))
    }

    public void unbind() {
        compositeDisposable.clear();
    }
}
