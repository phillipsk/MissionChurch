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

package com.missionchurchcooljc.mcc.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "AUDIO_MESSAGE".
 */
@Entity
public class AudioMessage {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String name;
    private String path;
    private Boolean is_playing;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

//    @Generated
//    public AudioMessage() {
//    }
//
//    public AudioMessage(Long id) {
//        this.id = id;
//    }

    @Generated
    public AudioMessage(Long id, String name, String path, Boolean is_playing) {
        this.id = id;
        this.name = name;
//        TODO: edit entity prior to construction, avoid formatting on each getName call
//        this.name = name.replace("_","/");
        this.path = path;
        this.is_playing = is_playing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
//        return name;
        return name.replace("_","/");
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(@NotNull String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getIs_playing() {
        return is_playing;
    }

    public void setIs_playing(Boolean is_playing) {
        this.is_playing = is_playing;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
