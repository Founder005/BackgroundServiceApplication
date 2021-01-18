package com.drumbeat.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author ZhangYuhang
 * @describe
 * @date 2021/1/15
 * @updatelog
 */
public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.tv_enter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DialogActivity.this,RoomActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(DialogActivity.this,MainActivity.class));        super.onBackPressed();
    }
}
