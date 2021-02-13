//package io.techministry.android.fellowshipmissionchurch.service;
//
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.media.RingtoneManager;
//import android.net.Uri;
//import android.util.Log;
//
//import androidx.core.app.NotificationCompat;
//
//import com.google.firebase.messaging.FirebaseMessagingService;
//import com.google.firebase.messaging.RemoteMessage;
//
//import io.fmc.R;
//import io.techministry.android.fellowshipmissionchurch.MainActivity;
//
//import static androidx.core.content.ContextCompat.getSystemService;
//
///**
// * Created by Akinsete on 6/4/17.
// */
//
//
//public class MyFirebaseMessagingService extends FirebaseMessagingService {
//
//    private static final String TAG = "FirebaseMessagingServce";
//
//    @Override
//    public void onMessageReceived(RemoteMessage remoteMessage) {
//
//        String notificationTitle = null, notificationBody = null;
//
//        // Check if message contains a notification payload.
//        if (remoteMessage.getNotification() != null) {
//            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
//            notificationTitle = remoteMessage.getNotification().getTitle();
//            notificationBody = remoteMessage.getNotification().getBody();
//        }
//
//        // Also if you intend on generating your own notifications as a result of a received FCM
//        // message, here is where that should be initiated. See sendNotification method below.
//        sendNotification(notificationTitle, notificationBody);
//    }
//
//
//    private void sendNotification(String notificationTitle, String notificationBody) {
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
//                PendingIntent.FLAG_ONE_SHOT);
//
//        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
//                .setAutoCancel(true)   //Automatically delete the notification
//                .setSmallIcon(R.mipmap.ic_launcher) //Notification icon
//                .setContentIntent(pendingIntent)
//                .setContentTitle(notificationTitle)
//                .setContentText(notificationBody)
//                .setSound(defaultSoundUri);
//
//// IMPORTED getStemService library from androidX
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        notificationManager.notify(0, notificationBuilder.build());
//    }
//
//   // FirebaseMessaging.getInstance().subscribeToTopic("pushNotifications");
//}