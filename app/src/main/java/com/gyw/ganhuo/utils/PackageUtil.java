package com.gyw.ganhuo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public class PackageUtil {

	/** 根据packageName获取packageInfo */
	public static PackageInfo getPackageInfo(Context context, String packageName) {
		if (null == context) {
			return null;
		}
		if (TextUtils.isEmpty(packageName)) {
			packageName = context.getPackageName();
		}
		PackageInfo info = null;
		PackageManager manager = context.getPackageManager();
		// 根据packageName获取packageInfo
		try {
			info = manager.getPackageInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
		} catch (PackageManager.NameNotFoundException e) {
		}
		return info;
	}

	/** 获取本应用的VersionCode */
	public static int getVersionCode(Context context) {
		PackageInfo info = getPackageInfo(context, null);
		if (info != null) {
			return info.versionCode;
		} else {
			return -1;
		}
	}

	/** 获取本应用的VersionName */
	public static String getVersionName(Context context) {
		PackageInfo info = getPackageInfo(context, null);
		if (info != null) {
			return info.versionName;
		} else {
			return null;
		}
	}

	/** 获取指定应用的VersionName */
	public static String getVersionName(Context context, String pkgName) {
		PackageInfo info = getPackageInfo(context, pkgName);
		if (info != null) {
			return info.versionName;
		} else {
			return null;
		}
	}

	/** 获取指定应用的VersionCode */
	public static int getVersionCode(Context context, String pkgName) {
		PackageInfo info = getPackageInfo(context, pkgName);
		if (info != null) {
			return info.versionCode;
		} else {
			return -1;
		}
	}

}