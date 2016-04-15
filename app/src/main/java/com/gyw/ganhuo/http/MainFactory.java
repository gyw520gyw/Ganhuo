package com.gyw.ganhuo.http;

/**
 * Created by Administrator on 2016/4/15.
 */
public class MainFactory {

    private volatile static GanApi mGanApi;

    public static GanApi getGanApiInstance() {
        if (mGanApi == null) {
            synchronized (MainFactory.class) {
                if (mGanApi == null) {
                    mGanApi = new MainRetrofit().getServer();
                }
            }
        }
        return mGanApi;
    }
}
