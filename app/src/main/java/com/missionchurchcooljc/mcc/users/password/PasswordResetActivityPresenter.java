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

package com.missionchurchcooljc.mcc.users.password;

import com.missionchurchcooljc.mcc.data.models.User;
import com.missionchurchcooljc.mcc.users.UserModel;

/**
 * Created by  Kevin Phillips and Sunday Akinsete on 18/05/2018.
 */

public class PasswordResetActivityPresenter implements PasswordResetMVP.Presenter {


    UserModel userModel;
    PasswordResetMVP.View view;

    public PasswordResetActivityPresenter(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public void setView(PasswordResetMVP.View view) {
        this.view = view;
    }

    @Override
    public void resetClicked() {
        if(view.requiredDetailsFilled()){
            User user = view.getUser();
            view.showViewLoading("Please wait");
            userModel.recoverPassword(user.getEmail(), new UserModel.OnPasswordRecoverListener() {
                @Override
                public void onComplete(String message) {
                    view.hideLoadingView();
                    view.showResponse(message);
                }

                @Override
                public void onError(String message) {
                    view.hideLoadingView();
                    view.showError(message);
                }
            });
        }
    }
}
