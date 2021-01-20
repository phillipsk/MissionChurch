package io.techministry.android.missionchurch.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.missionchurchcooljc.data_android.WebsiteHighlight
import io.techministry.android.missionchurch.repository.WebsiteRepository

class AboutUsViewModel @ViewModelInject internal constructor(
    websiteRepository: WebsiteRepository
//    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    val highlights: LiveData<List<WebsiteHighlight>> = websiteRepository.getHighlights()

    init {
        Log.d("LIFECYCLE", "{${this.javaClass.simpleName}} Class Created")
    }
}
