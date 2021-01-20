package io.techministry.android.missionchurch.repository

import com.missionchurchcooljc.data_android.WebsiteHighlightDAO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WebsiteRepository @Inject constructor(private val websiteHighlightDAO: WebsiteHighlightDAO) {

    fun getHighlights() = websiteHighlightDAO.getHighlights()
    fun getHighlight(websiteHighlightId: String) =
        websiteHighlightDAO.getHighlight(websiteHighlightId)


}
