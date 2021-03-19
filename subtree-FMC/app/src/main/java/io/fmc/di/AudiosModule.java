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

package io.fmc.di;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.fmc.db.DaoMaster;
import io.fmc.db.DaoSession;

@Module
public class AudiosModule extends Application {

//    public DaoSession daoSession;
//    DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"fmcdb"); //The users-db here is the name of our database.
//    Database db = helper.getWritableDb();
//    daoSession = new DaoMaster(db).newSession();

    @Provides
    @Singleton
    public DaoSession providesDaoSession(DaoMaster.DevOpenHelper helper,
                                         Database db) {
        helper = new DaoMaster.DevOpenHelper(this, "fmcdb");
        db = helper.getWritableDb();
        return new DaoMaster(db).newSession();
    }
}
