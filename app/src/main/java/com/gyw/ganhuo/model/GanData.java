package com.gyw.ganhuo.model;

/**
 * Created by Administrator on 2016/4/15.
 */
public class GanData {


    /**
     * _id : 57c2e9f1421aa91265f4a3ee
     * createdAt : 2016-08-28T21:41:05.165Z
     * desc : 8-29
     * publishedAt : 2016-08-29T11:32:28.388Z
     * source : chrome
     * type : 福利
     * url : http://ww1.sinaimg.cn/large/610dc034jw1f79sjqjn11j20u011hmzv.jpg
     * used : true
     * who : daimajia
     */

    public String _id;
    public String createdAt;
    public String desc;
    public String publishedAt;
    public String source;
    public String type;
    public String url;
    public boolean used;
    public String who;

    @Override
    public String toString() {
        return "GanData{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }
}
