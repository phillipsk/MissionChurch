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

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.fmc.ui.users.UserMVP;
import io.fmc.ui.users.UserModel;
import io.fmc.ui.users.createaccount.CreateAccountActivityPresenter;
import io.fmc.ui.users.createaccount.CreateAccountMVP;
import io.fmc.ui.users.login.LoginActivityPresenter;
import io.fmc.ui.users.login.LoginMVP;
import io.fmc.ui.users.password.PasswordResetActivityPresenter;
import io.fmc.ui.users.password.PasswordResetMVP;
import io.fmc.utils.socialauth.SocialAuthentication;

/**
 * Created by  Kevin Phillips and Sunday Akinsete on 18/05/2018.
 */

//@InstallIn(ActivityComponent.class)
@Module
public class UserModule {

    @Provides
    public LoginMVP.Presenter provideLoginActivityPresenter(){
        return new LoginActivityPresenter(new UserModel());
    }

    @Provides
    public PasswordResetMVP.Presenter providePasswordResetActivityPresenter(){
        return new PasswordResetActivityPresenter(new UserModel());
    }


    @Provides
    public CreateAccountMVP.Presenter provideCreateAccountPresenter(){
        return new CreateAccountActivityPresenter(new UserModel());
    }

    @Provides
    public UserMVP.Model provideLoginModel(){
        return new UserModel();
    }


    @Provides
    public SocialAuthentication provideSocialAuthentication(Context context){
        return new SocialAuthentication(context);
    }
}
