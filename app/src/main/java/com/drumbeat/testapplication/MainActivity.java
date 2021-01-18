package com.drumbeat.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ServiceUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final Intent service = new Intent();
//        service.setClass(this, MyService.class);
//        startService(service);

        ServiceUtils.startService(MyService.class);

        findViewById(R.id.tv_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                stopService(service);
                ServiceUtils.stopService(MyService.class);
                finish();
            }
        });
    }

    /**
     * home键按下
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}