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

package io.techministry.android.fellowshipmissionchurch.utils;

import android.content.Context;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Akinsete on 6/12/16.
 */

public class FirebaseUtilities {


    public static void likePost(DatabaseReference databaseReference){
        databaseReference.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData currentData) {
                if (currentData.getValue() == null) {
                    currentData.setValue(1);
                } else {
                    int initialLike = Integer.parseInt(currentData.getValue().toString()) + 1;
                    currentData.setValue(initialLike);
                }
                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                if (databaseError != null) {

                } else {

                }
            }
        });
    }


    public static void disLikePost(DatabaseReference databaseReference){
        databaseReference.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData currentData) {

                if (currentData.getValue() == null) {
                    currentData.setValue(1);
                } else {
                    int initialLike = Integer.parseInt(currentData.getValue().toString()) - 1;
                    if(initialLike >= 0)
                    currentData.setValue(initialLike);
                }
                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {
                if (databaseError != null) {

                } else {

                }
            }
        });
    }

    public static boolean isLiked(Context context, String userID, HashMap<String, Object> liked) {
        boolean exist = false;

       // //Log.e("Firebase",liked.toString());

       // Utilities.showToast(context,liked);
        try {
            for (Map.Entry<String, Object> entry : liked.entrySet()) {
                String k = entry.getKey();
//                boolean v = Boolean.parseBoolean((String) entry.getValue());
                if (k == userID) {
                    exist = true;
                }
            }
        }catch (Exception s){
            Utilities.showToast(context,s.toString());

            //Log.e("Firebase",s.toString());
        }

        return exist;
    }

}
