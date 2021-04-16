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

package io.fmc;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.fmc.ui.dashboard.DashboardActivity;

public class MainActivity extends AppCompatActivity {

//    private LegacyAppComponent legacyAppComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//                DaggerLegacyAppComponent.builder()
////                .postModule(new PostModule())
//                .application(getApplication())
//                .build();

        //SessionManager sessionManager = new SessionManager(this);

        //if (sessionManager.isLoggedIn()) {
        startActivity(new Intent(this, DashboardActivity.class));
        /*} else {
//            startActivity(new Intent(this, LoginActivity.class));
            startActivity(new Intent(this, DashboardActivity.class));

        }*/
        finish();

//        String COMPLETE_SERVER_URL = "https://api.scripture.api.bible/v1/bibles";
//        BibleDownloader.run(COMPLETE_SERVER_URL);


    }

//    public LegacyAppComponent getLegacyAppComponent() {
//        return legacyAppComponent;
//    }
}


