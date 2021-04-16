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

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.missionchurchcooljc.mcc.MainActivity;
import com.missionchurchcooljc.mcc.data.models.User;
import com.missionchurchcooljc.mcc.databinding.ActivityLoginBinding;
import com.missionchurchcooljc.mcc.di.AppController;
import com.missionchurchcooljc.mcc.users.SessionManager;
import com.missionchurchcooljc.mcc.users.SocialAuthentication;
import com.missionchurchcooljc.mcc.users.createaccount.CreateAccountActivity;
import com.missionchurchcooljc.mcc.users.password.PasswordResetActivity;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;

import javax.inject.Inject;

import io.fmc.ui.base.BaseActivity;
import io.fmc.ui.dashboard.DashboardActivity;

//@AndroidEntryPoint
public class LoginActivity extends BaseActivity implements LoginMVP.View, SocialAuthentication.SocialAuthenticationListener {

    private ActivityLoginBinding binding;
    //    @BindView(R2.id.email) EditText email;
    EditText email;
    //    @BindView(R2.id.password) EditText password;
    EditText password;

    @Inject
    LoginMVP.Presenter presenter;
    @Inject
    SessionManager sessionManager;

    @Inject
    public SocialAuthentication socialAuthentication;
    public CallbackManager mCallbackManager;
    public TwitterAuthClient twitterAuthClient;
    public SocialAuthentication.Type socialLoginType;


//    TODO: use sessionManager? to skip LoginActivity screen each session load?
//      insert, fetch, clear WebsiteHighlightDAO while app loads here
//      mindful of point #1, where else to load data if this screen is skipped

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
//        email = binding.email;
//        password = binding.password;
        setContentView(view);
//        setContentView(R.layout.activity_login);

//        ButterKnife.bind(this);

        ((AppController) getApplication()).getComponent().inject(this);
//        ((AppController) getApplication()).getComponent();

        presenter.setView(this);

        socialAuthentication.init(this);

        binding.btnFacebookSign.setOnClickListener(v -> facebookBtnClicked());
        binding.btnGoogle.setOnClickListener(v -> googleBtnClicked());
//        binding.labelCreateAccount.setOnClickListener(v -> createAccount());
//        binding.labelForgetPassword.setOnClickListener(v -> resetPassword());
//        binding.btnSignIn.setOnClickListener(v -> loginClicked());
        binding.skipLogin.setOnClickListener(v -> skipLogin());

    }

    private void skipLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    //    @OnClick(R2.id.btn_facebook_sign)
    public void facebookBtnClicked() {
        socialLoginType = SocialAuthentication.Type.FACEBOOK;
        mCallbackManager = socialAuthentication.initFacebookRegistration(this, this);
    }

    //    @OnClick(R2.id.btn_google)
    public void googleBtnClicked(){
        socialLoginType = SocialAuthentication.Type.GOOGLE;
        socialAuthentication.initLoginWithGoogle(this);
    }

    //    @OnClick(R2.id.label_create_account)
    public void createAccount(){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    //    @OnClick(R2.id.label_forget_password)
    public void resetPassword(){
        Intent intent = new Intent(this, PasswordResetActivity.class);
        startActivity(intent);
    }

    //    @OnClick(R2.id.btn_sign_in)
    public void loginClicked(){
        presenter.signInClicked();
    }


    @Override
    public void showError(String message) {
        showMessage(message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    }

//    @Nullable
//    @org.jetbrains.annotations.Nullable
//    @Override
//    public View onCreateView(@NonNull @NotNull String name, @NonNull @NotNull Context context,
//                             @NonNull @NotNull AttributeSet attrs) {
//        return super.onCreateView(name, context, attrs);
//    }
//
//    @Nullable
//    @org.jetbrains.annotations.Nullable
//    @Override
//    public View onCreateView(@Nullable @org.jetbrains.annotations.Nullable View parent,
//                             @NonNull @NotNull String name, @NonNull @NotNull Context context,
//                             @NonNull @NotNull AttributeSet attrs) {
//        return super.onCreateView(parent, name, context, attrs);
//    }

    @Override
    public void gotoMainView(User user) {
//        sessionManager.setLoginUser(user);
//        sessionManager.setUserLogin();
        Intent intent = new Intent(this, DashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean isLoginDetailValid() {
        if(TextUtils.isEmpty(email.getText().toString())){
            showMessage("Email required",null);
            return false;
        }else if(TextUtils.isEmpty(password.getText().toString())){
            showMessage("Password required",null);
            return false;
        }
        return true;
    }

    @Override
    public User getLoginUser() {
        User user = new User();
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        return user;
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (socialLoginType){
            case FACEBOOK:
                mCallbackManager.onActivityResult(requestCode, resultCode, data);
                break;
            case GOOGLE:
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                socialAuthentication.handleSignInResult(result,this);
                break;
            case TWITTER:
                twitterAuthClient.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }




    @Override
    public void onAuthenticationComplete(User user) {
        startActivity(new Intent(this, DashboardActivity.class));
        try {
            useGraphAPI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAuthenticationError(String error) {

    }

    public void useGraphAPI() throws Exception {
        FacebookSdk.addLoggingBehavior(LoggingBehavior.REQUESTS);

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

//        accessToken = "EAAEamWgsjN4BALXr7dq1MDjywGvYYBhyKQ6qp1xiCy4XTmPoPXWuOuqIJmx05OJYeZCGjkJ2sACqNFJ3ZApwZATfzopowUIsOg6ulTFywxCnkDOX2UZCSLYfRZBKNzFOV8mcQKMZAtk8u91sfcQwBTNIh4fi6IHTsraVZADnBZB7gUf4LLxcxVZBnfdHZAPeVzZCJgwxZCBS04dkvQZDZD"
//        EAAEamWgsjN4BALmlv4ZCnl08DTMzyW1EHw4iGO5lZB6K8tyFXRrTqKHj2dGmK2DLmoMXLGROsPWGLi4JoPNyJ8ZCa4bBcC9ZBApoSURMvMesGBsHWBeYpFoTfTGy4b44yRRDZCZCgQi2RmZBNo7zntUnp92UnOSSYy9FxNZA5GZAd8UyUFFMVyh9GlZAgcATBdwp5wekb6ZCaefFgZDZD
        GraphRequest request = GraphRequest.newGraphPathRequest(
                accessToken,
                "/120085814675079/published_posts",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        // Insert your code here
                        Log.d("GraphAPI FB debug", String.valueOf(response));
                        Log.d("GraphAPI FB debug", response.toString());
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "picture,created_time,story,id,icon,full_picture,attachments{media,media_type},call_to_action,message");
        parameters.putString("limit", "10");
        request.setParameters(parameters);
        request.executeAsync();

    }
}
