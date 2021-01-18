package com.drumbeat.testapplication;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

/**
 * @author ZhangYuhang
 * @describe
 * @date 2021/1/15
 * @updatelog
 */
public class MyService extends Service {
    private static final String TAG = "MyService";
    MyReceiver myReceiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        myReceiver = new MyReceiver();
        Log.d(TAG, "onCreate: " + myReceiver.toString());
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(myReceiver, filter);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {

            startMyOwnForeground();

        }else{

            startForeground(1, new Notification());}
    }

    @RequiresApi(Build.VERSION_CODES.O)

    private void startMyOwnForeground()

    {

        String NOTIFICATION_CHANNEL_ID = "example.permanence";

        String channelName = "Background Service";

        NotificationChannel chan = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_NONE);

        chan.setLightColor(Color.BLUE);

        chan.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);



        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        assert manager != null;

        manager.createNotificationChannel(chan);



        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        Notification notification = notificationBuilder.setOngoing(true)

                .setContentTitle("App is running in background")

                .setPriority(NotificationManager.IMPORTANCE_MIN)

                .setCategory(Notification.CATEGORY_SERVICE)

                .build();

        startForeground(2, notification);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + "MyService");
        unregisterReceiver(myReceiver);
    }

    @Override

    public void onTaskRemoved(Intent rootIntent){

        Intent restartServiceIntent = new Intent(getApplicationContext(), this.getClass());

        restartServiceIntent.setPackage(getPackageName());



        PendingIntent restartServicePendingIntent;
        restartServicePendingIntent = PendingIntent.getService(getApplicationContext(), 1, restartServiceIntent, PendingIntent.FLAG_ONE_SHOT);

        AlarmManager alarmService = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);

        alarmService.set(

                AlarmManager.ELAPSED_REALTIME,

                SystemClock.elapsedRealtime() + 1000,

                restartServicePendingIntent);


        Intent intent = new Intent("startService");

        sendBroadcast(intent);
        super.onTaskRemoved(rootIntent);

    }
}