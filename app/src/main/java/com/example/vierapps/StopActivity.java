package com.example.vierapps;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.concurrent.TimeUnit;

public class StopActivity extends AppCompatActivity {
    public CountDownTimer meinCountDownTimer;
    // Notification System
    // Constants for the notification actions buttons.
    private static final String ACTION_UPDATE_NOTIFICATION =
            "com.android.example.notifyme.ACTION_UPDATE_NOTIFICATION";
    // Notification channel ID.
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";
    // Notification ID.
    private static final int NOTIFICATION_ID = 0;

    private NotificationManager mNotifyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_activity);

        // Create the notification channel.
        createNotificationChannel();

    }

    public void countDownTimerFun(boolean decide) {
        EditText count_down_value = findViewById(R.id.count_down_value);
        String count_down_in_minutes = count_down_value.getText().toString();
        int final_count_down_in_minutes = Integer.parseInt(count_down_in_minutes);
        TextView show_count_down = findViewById(R.id.show_count_down);

        int milliseconds;
        if (decide){
            milliseconds = final_count_down_in_minutes * 60 * 1000;
        }else{
            milliseconds = 0;
        }

        meinCountDownTimer = new CountDownTimer(milliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                show_count_down.setText(String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            @Override
            public void onFinish() {
                sendNotification();
                show_count_down.setText(R.string.time_up);
            }
        };
    }
    public void start_countDown(View view) {
        if(view.getId() == R.id.start_count_down) {
            countDownTimerFun(true);
            meinCountDownTimer.start();
        }
    }

    public void stop_countDown(View view) {
        if(view.getId() == R.id.stop_count_down) {
            TextView show_count_down = findViewById(R.id.show_count_down);
            meinCountDownTimer.cancel();
            countDownTimerFun(false);
            show_count_down.setText("00:00");
        }
    }

    // Notification Stuff
    /**
     * Creates a Notification channel, for OREO and higher.
     */
    public void createNotificationChannel() {

        // Create a notification manager object.
        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel (PRIMARY_CHANNEL_ID, "Kol haga hna", NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Kol el-hagat btegy hna, ya doctor");

            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }
    /**
     * Creates and delivers a simple notification.
     */
    public void sendNotification() {

        // Build the notification with all of the parameters using helper
        // method.
        NotificationCompat.Builder el_basha_notifer = getNotificationBuilder();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // Deliver the notification.
        notificationManager.notify(NOTIFICATION_ID, el_basha_notifer.build());

    }

    /**
     * Helper method that builds the notification.
     *
     * @return NotificationCompat.Builder: notification build with all the
     * parameters.
     */
    private NotificationCompat.Builder getNotificationBuilder() {

        // Set up the pending intent that is delivered when the notification
        // is clicked.
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity (this, NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_IMMUTABLE);

        // Build the notification with all of the parameters.
        NotificationCompat.Builder el_basha_notifer = new NotificationCompat
                .Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("Mabrook.")
                .setContentText("Times Up, ya basha!")
                .setSmallIcon(R.drawable.icon_launcher)
                .setAutoCancel(true).setContentIntent(notificationPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        return el_basha_notifer;
    }
}