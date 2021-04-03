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

package com.missionchurchcooljc.mcc.users;


import com.missionchurchcooljc.mcc.data.FMCApi;
import com.missionchurchcooljc.mcc.data.models.User;

/**
 * Created by  Kevin Phillips and Sunday Akinsete on 18/05/2018.
 */

public class UserModel implements UserMVP.Model {

    public interface OnLoginListener {
        void onComplete(User user);

        void onError(String message);
    }

    public interface OnCreateAccountListener {
        void onComplete(User user);

        void onError(String message);
    }

    public interface OnPasswordRecoverListener {void onComplete(String message);void onError(String message);}



    @Override
    public void userLogin(User user, OnLoginListener onLoginListener) {
        FMCApi.authenticateUserWithEmailAndPassword(user,onLoginListener);
    }

    @Override
    public void createAccount(User user, OnCreateAccountListener onCreateAccountListener) {
        FMCApi.createUserAccountWithEmailAndPassword(user,onCreateAccountListener);
    }

    @Override
    public void recoverPassword(String email, OnPasswordRecoverListener onPasswordRecoverListener) {
        FMCApi.recoverUserPassword(email,onPasswordRecoverListener);
    }


}
