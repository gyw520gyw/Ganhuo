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
	public static Drawable getDrawable(int resId) {
		return getResources().getDrawable(resId);
	}

	/** 获取颜色 */
	public static int getColor(int resId) {
		return getResources().getColor(resId);
	}
	
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

	/**
	 * 色块效果
	 * @param context
	 * @param color		内部填充色
	 * @return
	 */
	public static GradientDrawable MAIN_RADIO_NOBORD(Context context,int color){
		GradientDrawable gd=new GradientDrawable();
		gd.setColor(color);
		int radio=dip2px(4);
		gd.setCornerRadii(new float[] { radio, radio, radio, radio,radio, radio, radio, radio });
		gd.setShape(GradientDrawable.RECTANGLE);//设置形状为矩形
		return gd;
	}
	/**
	 * 边框效果
	 * @param context
	 * @param color			内部填充色
	 * @param stokecolor	边框色
	 * @param stokeWidth	边框宽度
	 * @return
	 */
	public static GradientDrawable MAIN_RADIO_BORD(Context context,int color,int stokecolor,int stokeWidth){
		GradientDrawable gd=new GradientDrawable();
		gd.setStroke(stokeWidth, stokecolor);
		gd.setColor(color);
		int radio=dip2px(4);
		gd.setCornerRadii(new float[] { radio, radio, radio, radio,radio, radio, radio, radio });
		gd.setShape(GradientDrawable.RECTANGLE);//设置形状为矩形
		return gd;
	}
	
	/**
	 * 边框圆角效果
	 * @param context
	 * @param color			内部填充色
	 * @param stokecolor	边框色
	 * @param stokeWidth	边框宽度
	 * @param radio			圆角度
	 * @return
	 */
	public static GradientDrawable MAIN_RADIO_BORD(Context context,int color,int stokecolor,int stokeWidth, int radio){
		GradientDrawable gd=new GradientDrawable();
		gd.setStroke(stokeWidth, stokecolor);
		gd.setColor(color);
		gd.setCornerRadii(new float[] { radio, radio, radio, radio,radio, radio, radio, radio });
		gd.setShape(GradientDrawable.RECTANGLE);//设置形状为矩形
		return gd;
	}
	
	/**
	 * 右侧边框圆角效果
	 * @param context
	 * @param color			内部填充色
	 * @param stokecolor	边框色
	 * @param stokeWidth	边框宽度
	 * @param radio         圆角
	 * @return
	 */
	public static GradientDrawable MAIN_RADIO_BORD_RIGHT(Context context,int color,int stokecolor,int stokeWidth, int radio){
		GradientDrawable gd=new GradientDrawable();
		gd.setStroke(stokeWidth, stokecolor);
		gd.setColor(color);
		gd.setCornerRadii(new float[] { 0, 0, radio, radio,radio, radio, 0, 0 });
		gd.setShape(GradientDrawable.RECTANGLE);//设置形状为矩形
		return gd;
	}
	
	/**
	 * 左侧边框圆角效果
	 * @param context
	 * @param color			内部填充色
	 * @param stokecolor	边框色
	 * @param stokeWidth	边框宽度
	 * @param radio         圆角
	 * @return
	 */
	public static GradientDrawable MAIN_RADIO_BORD_LEFT(Context context,int color,int stokecolor,int stokeWidth, int radio){
		GradientDrawable gd=new GradientDrawable();
		gd.setStroke(stokeWidth, stokecolor);
		gd.setColor(color);
		gd.setCornerRadii(new float[] { radio, radio, 0, 0,0, 0, radio, radio });
		gd.setShape(GradientDrawable.RECTANGLE);//设置形状为矩形
		return gd;
	}
}
