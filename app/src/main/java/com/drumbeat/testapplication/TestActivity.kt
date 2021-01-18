package com.drumbeat.testapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * @author ZhangYuhang
 * @describe
 * @date 2021/1/18
 * @updatelog
 */
class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        findViewById<View>(R.id.tv_enter).setOnClickListener {
            startActivity(Intent(this@TestActivity, RoomActivity::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this@TestActivity, MainActivity::class.java))
        super.onBackPressed()
    }


}