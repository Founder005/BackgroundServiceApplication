package com.drumbeat.testapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PushReceiver extends BroadcastReceiver {


	@Override
	public void onReceive(Context context, Intent intent) {
		if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
			System.out.println("手机开机了...bootComplete!");
		}else
		if(Intent.ACTION_PACKAGE_ADDED.equals(intent.getAction())){
			System.out.println("新安装了应用程序....pakageAdded!");
		}else
		if(Intent.ACTION_PACKAGE_REMOVED.equals(intent.getAction())){
			System.out.println("应用程序被卸载了....pakageRemoved!");
		}else
		if(Intent.ACTION_USER_PRESENT.equals(intent.getAction())){
			System.out.println("手机被唤醒了.....userPresent");
			Intent service = new Intent();
			service.setAction("com.drumbeat.testapplication.PushService");
			service.setClass(context, MyService.class);
			context.startService(service);
		}
		
	}


}