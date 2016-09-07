package com.gyw.ganhuo.http;


import com.gyw.ganhuo.model.GrilData;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2016/4/15.
 */
public interface GanApi {

    //http://gank.io/api/data/Android/10/1
    @GET("{type}/{pageSize}/{pageIndex}")
    Observable<GrilData> getGanData(@Path("type") String type, @Path("pageSize") int pageSize, @Path("pageIndex") int pageIndex);

}
