/*
 * Copyright (c) 2021  Kevin Phillips, Mission Church of Our Lord Jesus Christ
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

package com.missionchurchcooljc.common.network.api


import com.google.gson.annotations.SerializedName
import com.missionchurchcooljc.data_android.WebsiteHighlight

//data class ChurchWebsiteResponse(val items: List<TopLevel>)
data class ChurchWebsiteResponse(
    @SerializedName("data")
    var items: List<WebsiteHighlight>
)

//data class TopLevel(
//    @SerializedName("data")
//    val data: List<Item>
//)
//data class Item(
//    val highlightId: String,
//    val imageUrl: String?,
//    val title: String?,
//    val followUrl: String?,
//    val caption: String?,
//    @SerializedName("width")
//    val imageWidth: String?,
//    @SerializedName("height")
//    val imageHeight: String?
//)

//data class EmployeeApiResponse(
//    @SerializedName("data")
//    var data: List<Employee>
//)