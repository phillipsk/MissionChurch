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
import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;
import io.fmc.data.FMCApi;
import io.fmc.ui.listen.AudiosFragment;
import io.fmc.ui.posts.PostsFragment;

@Singleton
//@Component(modules = {UserModule.class, PostModule.class})
@Component(modules = {UserModule.class, PostModule.class, AudiosModule.class,
        LegacyAppModule.class})
public interface LegacyAppComponent {

    @Component.Builder
    interface Builder {

        LegacyAppComponent build();

        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder context(Context context);

        @BindsInstance
        Builder databaseInfo(DatabaseInfo databaseInfo);
    }

//    void inject(LoginActivity target);
//
//    void inject(LoginActivityPresenter target);
//
//    void inject(CreateAccountActivity target);
//
//    void inject(PasswordResetActivity target);

    void inject(PostsFragment target);

    void inject(FMCApi fmcApi);

    void inject(AudiosFragment audiosFragment);
}

@Module
abstract class LegacyAppModule {

//    @Binds
//    public Application bindContext(Application application){
//        return application;
//    };

}
