package com.gyw.ganhuo.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.gyw.ganhuo.utils.CustomCrashHandler;


public class MyApplication extends Application {

	private static Context mContext;
	private static Handler mHandler;

	@Override
	public void onCreate() {
		super.onCreate();

		CustomCrashHandler mCustomCrashHandler = CustomCrashHandler.getInstance();
		mCustomCrashHandler.setCustomCrashHanler(getApplicationContext());

		mContext = this;
		mHandler = new Handler();

		FeedbackAPI.initAnnoy(this, Constant.ALI_APPKEY);

	}


	public static Context getContext() {
		return mContext;
	}

	public static Handler getHandler() {
		return mHandler;
	}


}
