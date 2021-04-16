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

package com.missionchurchcooljc.mcc.users.createaccount;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.missionchurchcooljc.mcc.data.models.User;
import com.missionchurchcooljc.mcc.users.SessionManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.fmc.R;
import io.fmc.R2;
import io.fmc.ui.base.BaseActivity;
import io.fmc.ui.dashboard.DashboardActivity;

public class CreateAccountActivity extends BaseActivity implements CreateAccountMVP.View {

    @BindView(R2.id.email) EditText email;
    @BindView(R2.id.password) EditText password;
    @BindView(R2.id.re_password) EditText re_password;

    @Inject
    CreateAccountMVP.Presenter presenter;

    @Inject
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        ButterKnife.bind(this);

//        ((AppController)getApplication()).getComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.setView(this);
    }

    @OnClick(R2.id.btn_back)
    public void goBack(){
        finish();
    }

    @OnClick(R2.id.btn_create_account)
    public void createAccount(){
        presenter.signUpClicked();
    }

    @Override
    public void showError(String message) {
        showMessage(message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    }

    @Override
    public void showViewLoading(String message) {
        showLoading(message);
    }

    @Override
    public void hideLoadingView() {
        hideLaoding();
    }

    @Override
    public void gotoMainView(User user) {
        sessionManager.setLoginUser(user);
        sessionManager.setUserLogin();
        Intent intent = new Intent(this, DashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean requiredDetailsFilled() {
        if(TextUtils.isEmpty(email.getText().toString())){
            showMessage("Email required",null);
            return false;
        }else if(TextUtils.isEmpty(password.getText().toString())){
            showMessage("Password required",null);
            return false;
        }else if(TextUtils.isEmpty(re_password.getText().toString())){
            showMessage("Re-enter password",null);
            return false;
        }else if(!re_password.getText().toString().equals(password.getText().toString())){
            showMessage("Password doesn't match",null);
            return false;
        }
        return true;
    }

    @Override
    public User getUser() {
        User user = new User();
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        return user;
    }
}
