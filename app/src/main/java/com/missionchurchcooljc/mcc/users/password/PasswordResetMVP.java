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

import io.fmc.ui.base.BaseView;

/**
 * Created by  Kevin Phillips and Sunday Akinsete on 18/05/2018.
 */

public interface PasswordResetMVP {

    interface View extends BaseView {

        void showResponse(String message);

        boolean requiredDetailsFilled();

        User getUser();

    }

    interface Presenter {

        void setView(PasswordResetMVP.View view);

        void resetClicked();

    }

}
