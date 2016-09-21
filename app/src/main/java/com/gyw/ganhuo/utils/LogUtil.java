package com.gyw.ganhuo.utils;

import android.util.Log;

/**
 * 统一日志管理
 *
 * @author gyw
 * @version 1.0
 * @time: 2015-8-19 下午4:14:33
 * @fun:
 */
public class LogUtil {
    // 打开log
    private static final boolean IS_DEBUG = true;
    // 关闭log
//	private static final boolean IS_DEBUG = false;

    private static final String TAG = "gtest";

    public static void v(String msg) {
        if (IS_DEBUG) {
            Log.v(TAG, "-->" + msg);
        }
    }

    public static void d(String msg) {
        if (IS_DEBUG) {
            Log.d(TAG, "-->" + msg);
        }
    }

    public static void i(String msg) {
        if (IS_DEBUG) {
            Log.i(TAG, "-->" + msg);
        }
    }

    public static void w(String msg) {
        if (IS_DEBUG) {
            Log.v(TAG, "-->" + msg);
        }
    }

    public static void e(String msg) {
        if (IS_DEBUG) {
            Log.e(TAG, "-->" + msg);
        }
    }

    public static void e(String msg, Throwable tr) {
        if (IS_DEBUG) {
            Log.e(TAG, "-->" + msg);
        }
    }


    public static void v(String tag, String msg) {
        if (IS_DEBUG) {
            Log.v(tag, "-->" + msg);
        }
    }

    public static void d(String tag, String msg) {
        if (IS_DEBUG) {
            Log.d(tag, "-->" + msg);
        }
    }

    public static void i(String tag, String msg) {
        if (IS_DEBUG) {
            Log.i(tag, "-->" + msg);
        }
    }

    public static void w(String tag, String msg) {
        if (IS_DEBUG) {
            Log.v(tag, "-->" + msg);
        }
    }

    public static void e(String tag, String msg) {
        if (IS_DEBUG) {
            Log.e(tag, "-->" + msg);
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (IS_DEBUG) {
            Log.e(tag, "-->" + msg);
        }
    }
}
