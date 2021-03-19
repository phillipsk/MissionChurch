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

package com.missionchurchcooljc.mcc.feature_highlights.mvvm.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.missionchurchcooljc.mcc.feature_highlights.mvvm.AboutUsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(UserViewModel::class)
//    abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(SearchViewModel::class)
//    abstract fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AboutUsViewModel::class)
    abstract fun bindAboutUsViewModel(aboutUsViewModel: AboutUsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
