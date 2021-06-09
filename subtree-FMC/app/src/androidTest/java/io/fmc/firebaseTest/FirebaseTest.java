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

package io.fmc.firebaseTest;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.fmc.data.models.AnnouncementPost;

public class FirebaseTest {
    @Test
    public void debugTimestamp() {
        long timeStamp = 1592020956691L;
        String r = getTimeDate(timeStamp);
        System.out.println(r);

        Instant instant = Instant.ofEpochSecond(timeStamp);
        Date date = Date.from(instant);
        SimpleDateFormat sfd = new SimpleDateFormat("E MMM d yyyy", Locale.getDefault());

        System.out.println(sfd.format(date));

    }

    @Test
    public void setUp() throws Exception {

        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference("Church Events");

        mDatabase.getDatabase();

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
                System.out.println(announcementPosts);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.e("databaseError", String.valueOf(databaseError));
            }
        });

    }

    public static String getTimeDate(long timestamp) {
        try {
            Date netDate = (new Date(timestamp));
            SimpleDateFormat sfd = new SimpleDateFormat("E MMM d yyyy", Locale.getDefault());
            return sfd.format(netDate);
        } catch (Exception e) {
            return "date error";
        }
    }


}
