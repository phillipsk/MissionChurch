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

package com.missionchurchcooljc.mcc.data.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class ChurchEvent {

    String imageURL;
    String eventDate;
    String eventLocation;
    String eventTitle;
    long date;
    long postdate;


    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public static String getTimeDate(long timestamp) {
        try {
            Date netDate = (new Date(timestamp));
            SimpleDateFormat sfd = new SimpleDateFormat("E MMM d yyyy", Locale.getDefault());
            return sfd.format(netDate);
        } catch (Exception e) {
            return "date error";
        }
    }

    public HashMap<String, Object> getLiked() {
        return liked;
    }

    public void setLiked(HashMap<String, Object> liked) {
        this.liked = liked;
    }

    HashMap<String,Object> liked = new HashMap<>();
}