package com.gyw.ganhuo.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author: gyw
 * date: 2016/9/8.
 * fun: 转换的方法
 */
public class TransfUtil {

    public static String formatPublishedAt(String str) {
//        yyyy-MM-dd'T'HH:mm:ss.SSSZ
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date date = format.parse(str);

            DateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");
            return format2.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

}
