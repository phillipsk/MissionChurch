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

package com.missionchurchcooljc.mcc.feature_highlights.mvvm

//import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.missionchurchcooljc.data_android.WebsiteHighlight
import com.missionchurchcooljc.mcc.feature_highlights.WebsiteRepository
import com.missionchurchcooljc.mcc.network.api.ChurchWebsiteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class AboutUsViewModel @Inject internal constructor(
    val websiteRepository: WebsiteRepository,
    private val churchWebsiteRepository: ChurchWebsiteRepository
//    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val job: Job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

//    lateinit var highlights: LiveData<List<WebsiteHighlight>>
    var highlights: LiveData<List<WebsiteHighlight>> = websiteRepository.getHighlights()

// TODO: an attempt to replace constant highlights above with function call
//    fun fetchHighlights(): LiveData<List<WebsiteHighlight>>{
//       return websiteRepository.getHighlights()
//    }


//    fun purgeHighlights(){
//        coroutineScope.launch(Dispatchers.IO) {
//
//            return@launch websiteRepository.purgeHighlights()
//        }
//    }

    fun retrieveHighlights() {
//        retrieve seeded highlights, then retrieve remote, compare - DONE
//        retrieve local
//        var highlights = websiteRepository.getHighlights()

//        retrieve remote
        coroutineScope.launch(Dispatchers.IO) {
            churchWebsiteRepository.updateHighlightsRemote() // remote
//            highlights = websiteRepository.getHighlights() // local
//            logCoroutine("retrieveHighlights", coroutineContext)

//            launch(Dispatchers.Main) {
////                //Log.d("highlights", highlights.joinToString())
////                recyclerView.adapter = PokeAdapter(response)
//
//            }
        }
    }

//    fun getData() {
//        coroutineScope.launch(Dispatchers.IO) {
//            logCoroutine("getData", coroutineContext)
//
////            delay(500)
//            val result = runCatching { churchWebsiteRepository.fataretrieveHighlightsAwait() }
//
//            //Log.d("TestCoroutine", "Still Alive!")
////            result.onSuccess { highlight ->
////                moviesView.showMovies(highlight)
////            }.onFailure { error ->
////                handleError(error)
////            }
//        }
//    }
//

    init {
        //Log.d("LIFECYCLE", "{${this.javaClass.simpleName}} Class Created")
    }
}
