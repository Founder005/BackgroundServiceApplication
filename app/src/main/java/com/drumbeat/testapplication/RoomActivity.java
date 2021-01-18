package com.drumbeat.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author ZhangYuhang
 * @describe
 * @date 2021/1/15
 * @updatelog
 */
public class RoomActivity extends AppCompatActivity {

    private static final String TAG = "RoomActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
//        Intent service = new Intent();
//        service.setClass(this, MyService.class);
//        startService(service);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(RoomActivity.this,MainActivity.class));
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
