package io.techministry.android.missionchurch.repository

import androidx.lifecycle.LiveData
import io.techministry.android.missionchurch.adapters.AboutUsAdapter
import io.techministry.android.missionchurch.data.WebsiteHighlight
import io.techministry.android.missionchurch.data.WebsiteHighlightDAO
import io.techministry.android.missionchurch.ui.ConnectFragment
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WebsiteRepository @Inject constructor(private val websiteHighlightDAO: WebsiteHighlightDAO) {

    fun getHighlights() = websiteHighlightDAO.getHighlights()
    fun getHighlight(websiteHighlightId: String) =
        websiteHighlightDAO.getHighlight(websiteHighlightId)


}
