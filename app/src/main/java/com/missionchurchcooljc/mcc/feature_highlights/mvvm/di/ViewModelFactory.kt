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
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

//class ViewModelFactory @Inject constructor(
//    private val providersMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
//    savedStateRegistryOwner: SavedStateRegistryOwner
//): AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {
//
//    override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
//        val provider = providersMap[modelClass]
//        val viewModel = provider?.get() ?: throw RuntimeException("unsupported viewmodel type: $modelClass")
//        if (viewModel is SavedStateViewModel) {
//            viewModel.init(handle)
//        }
//        return viewModel as T
//    }
//
//}
@Singleton
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        @Suppress("UNCHECKED_CAST")
        return creator.get() as T
    }
}
