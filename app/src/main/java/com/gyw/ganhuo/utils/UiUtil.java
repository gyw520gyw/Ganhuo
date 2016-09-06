package com.gyw.ganhuo.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import com.gyw.ganhuo.base.BaseActivity;
import com.gyw.ganhuo.global.MyApplication;



public class UiUtil {

	/** 获取Context */
	public static Context getContext() {
		return MyApplication.getContext();
	}

	/** 获取资源 */
	public static Resources getResources() {
		return getContext().getResources();
	}

	/** 获取文字 */
	public static String getString(int resId) {
		return getResources().getString(resId);
	}

	/** 获取文字数组 */
	public static String[] getStringArray(int resId) {
		return getResources().getStringArray(resId);
	}
	
	/** 获取drawable */
//	public static Drawable getDrawable(int resId) {
//		return getResources().getDrawable(resId);
//	}
//
//	/** 获取颜色 */
//	public static int getColor(int resId) {
//		return getResources().getColor(resId);
//	}
	
	/**获取长度*/
	public static float getDimension(int resId) {
		return getResources().getDimension(resId);
	}

	/**
	 * 获取handler
	 */
	public static Handler getHandler() {
		return MyApplication.getHandler();
	}
	
	public static void post(Runnable r) {
		getHandler().post(r);
	}
	
	
	
	/**转换布局*/
	public static View inflate(int resId) {
		return LayoutInflater.from(getContext()).inflate(resId, null);
	}
	
	/**转换布局*/
	public static LayoutInflater getInflate() {
		return LayoutInflater.from(getContext());
	}
	
	
	/** 通过intent跳转*/
	public static void startActivity(Intent intent) {
		BaseActivity activity = BaseActivity.getBaseActivity();
		if (activity != null) {
			activity.startActivity(intent);
		} else {
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			getContext().startActivity(intent);
		}
	}
	
	/** 通过Class跳转界面 **/
	public static void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /** 含有Bundle通过Class跳转界面 **/
    public static void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getContext(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

	/** dip转换px */
	public static int dip2px(int dip) {
		final float scale = getContext().getResources().getDisplayMetrics().density;
		return (int) (dip * scale + 0.5f);
	}

	/** pxz转换dip */
	public static int px2dip(int px) {
		final float scale = getContext().getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}
}
