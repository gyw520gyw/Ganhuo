package com.gyw.ganhuo.http;


import com.gyw.ganhuo.model.GrilData;
import com.gyw.ganhuo.model.VideoData;

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


    //其他和上面的是一样的, 只是为了区分获取的值
    @GET("休息视频/{pageSize}/{pageIndex}")
    Observable<VideoData> getVideoData(/*@Path("type") String type,*/ @Path("pageSize") int pageSize, @Path("pageIndex") int pageIndex);

}
