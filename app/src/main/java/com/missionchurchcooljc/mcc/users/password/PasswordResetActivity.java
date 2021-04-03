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

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.missionchurchcooljc.mcc.data.models.User;

import javax.inject.Inject;

import io.fmc.databinding.ActivityResetPasswordBinding;
import io.fmc.ui.base.BaseActivity;

public class PasswordResetActivity extends BaseActivity implements PasswordResetMVP.View {

    //    @BindView(R2.id.email) EditText email;
    private ActivityResetPasswordBinding binding;

    @Inject
    PasswordResetMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_reset_password);
        binding = ActivityResetPasswordBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//        ButterKnife.bind(this);

//        ((AppController)getApplication()).getComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.setView(this);
    }

    //    @OnClick(R2.id.btn_back)
    public void goBack(){
        finish();
    }

    //    @OnClick(R2.id.btn_reset_password)
    public void createAccount(){
        presenter.resetClicked();
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
    public void showResponse(String message) {
        showMessage(message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
    }

    @Override
    public boolean requiredDetailsFilled() {
        if (TextUtils.isEmpty(binding.email.getText().toString())) {
            showMessage("Email required", null);
            return false;
        }
        return true;
    }

    @Override
    public User getUser() {
        User user = new User();
        user.setEmail(binding.email.getText().toString());
        return user;
    }
}
