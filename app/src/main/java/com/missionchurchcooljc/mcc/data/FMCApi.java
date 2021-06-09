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

package com.missionchurchcooljc.mcc.data;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.missionchurchcooljc.mcc.data.models.AnnouncementPost;
import com.missionchurchcooljc.mcc.data.models.User;
import com.missionchurchcooljc.mcc.posts.PostModel;
import com.missionchurchcooljc.mcc.users.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by  Kevin Phillips and Sunday Akinsete on 17/05/2018.
 */

public class FMCApi {


//    public FMCApi() {
//        AppController.getAppComponent().inject(this);
//    }


    public static void authenticateUserWithEmailAndPassword(final User user, final UserModel.OnLoginListener onLoginListener) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(user.getEmail(),user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    onLoginListener.onComplete(user);
                }else{
                    onLoginListener.onError(task.getException().getMessage().toString());
                }
            }
        });
    }

    public static void createUserAccountWithEmailAndPassword(final User user, final UserModel.OnCreateAccountListener onCreateAccountListener) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(user.getEmail(),user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    onCreateAccountListener.onComplete(user);
                }else{
                    onCreateAccountListener.onError(task.getException().getMessage().toString());
                }
            }
        });
    }

    public static void recoverUserPassword(String email, final UserModel.OnPasswordRecoverListener onPasswordRecoverListener) {
        FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    onPasswordRecoverListener.onComplete("Password reset link has been sent to your email address.");
                }else{
                    onPasswordRecoverListener.onError(task.getException().toString());
                }
            }
        });
    }

    public static void listenToPostChanges(final PostModel.OnPostsFetched onPostsFetched) {
//        FirebaseDatabase.getInstance().getReference().addValueEventListener(new ValueEventListener() {
        FirebaseDatabase.getInstance().getReference("Church Events").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Log.e("databaseError", String.valueOf(dataSnapshot));
//                String value = dataSnapshot.getValue(String.class);
//                //Log.d(TAG, "Value is: " + value);

                List<AnnouncementPost> announcementPosts = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //Log.d("Firebase obj key ", Objects.requireNonNull(snapshot.getKey()));
                    announcementPosts.add(snapshot.getValue(AnnouncementPost.class));
                }
//                2020-06-14 Reverse sort Announcement array list; or sort by created date
//                announcements.sort(Collections.reverseOrder());
                onPostsFetched.onPostItemsFetched(announcementPosts);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("databaseError", String.valueOf(databaseError));
            }
        });
    }

}

//gcloud ai-platform local predict --model-dir output/export/census/1576341050 --json-instances ../test.json
// sudo rm -rf /google/google-cloud-sdk/lib/googlecloudsdk/command_lib/ml_engine/*.pyc
// curl -s -X POST -H "Content-Type: application/json" --data-binary @request.json  https://vision.googleapis.com/v1/images:annotate?key=${AIzaSyC9C8ufoc74Tj49W45k9vTX3T-86oApZ1E}