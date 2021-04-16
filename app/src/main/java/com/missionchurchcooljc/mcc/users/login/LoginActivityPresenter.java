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

package com.missionchurchcooljc.mcc.users.login;

import com.missionchurchcooljc.mcc.data.models.User;
import com.missionchurchcooljc.mcc.users.SessionManager;
import com.missionchurchcooljc.mcc.users.UserModel;

import javax.inject.Inject;

/**
 * Created by  Kevin Phillips and Sunday Akinsete on 14/04/2018.
 */

public class LoginActivityPresenter implements LoginMVP.Presenter {

    @Inject
    SessionManager sessionManager;

    UserModel userModel;
    LoginMVP.View view;

    public LoginActivityPresenter(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public void setView(LoginMVP.View view) {

        this.view = view;
    }

    @Override
    public void signInClicked() {
        if(view.isLoginDetailValid()){
            view.showViewLoading("Please wait");
            User user = view.getLoginUser();
            userModel.userLogin(user, new UserModel.OnLoginListener() {
                @Override
                public void onComplete(User user) {
                    view.hideLoadingView();
                    view.gotoMainView(user);
                }

                @Override
                public void onError(String message) {
                    view.hideLoadingView();
                    view.showError(message);
                }
            });
        }
    }

    @Override
    public void googleSignInClicked() {

    }

    @Override
    public void facebookSignInClicked() {

    }

    @Override
    public void forgetPasswordClicked() {

    }
}
