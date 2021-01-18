package com.drumbeat.testapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.Log;

import com.blankj.utilcode.util.ServiceUtils;
import com.blankj.utilcode.util.ToastUtils;

/**
 * @author ZhangYuhang
 * @describe
 * @date 2021/1/15
 * @updatelog
 */
public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: "+intent.getAction());
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            ToastUtils.showShort("网络发生变化");

            Intent intent1 = new Intent();
            intent1.setClass(context, DialogActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);

        }
        else if (intent.getAction().equals("startService")){

            ServiceUtils.startService(MyService.class);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                Intent service = new Intent();
//                service.setClass(context, MyService.class);
//                context.startForegroundService(service);
//
//            } else {
//                Intent service = new Intent();
//                service.setClass(context, MyService.class);
//                context.startService(service);
//
//            }
        }

    }
}
