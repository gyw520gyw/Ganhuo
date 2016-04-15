package com.gyw.ganhuo.model;

import java.util.List;

/**
 * Created by Administrator on 2016/4/15.
 */
public class GanData {


    /**
     * error : false
     * results : [{"_id":"57105e6e67765974f885bef9","createdAt":"2016-04-15T11:22:22.754Z","desc":"基于 Facebook Redex 实现 Android APK 的压缩和优化","publishedAt":"2016-04-15T13:04:43.738Z","source":"chrome","type":"Android","url":"http://mp.weixin.qq.com/s?__biz=MzAwMTYwNzE2Mg==&mid=2651036594&idx=1&sn=b276c0f76cea713e5d568ab51e3f7f13&scene=0#wechat_redirect","used":true,"who":"MVP"},{"_id":"57105c1867765974fbfcf8f3","createdAt":"2016-04-15T11:12:24.715Z","desc":"EasyFTP 一个Android Ftp客户端，可以方便的通过gradle引用","publishedAt":"2016-04-15T13:04:43.738Z","source":"web","type":"Android","url":"https://github.com/linkindrew/easyFTP","used":true,"who":"瘦纸好过夏"},{"_id":"570f92ea67765974fca82ff3","createdAt":"2016-04-14T20:54:02.958Z","desc":"Easy sidebar for Android RecyclerView","publishedAt":"2016-04-15T13:04:43.738Z","source":"web","type":"Android","url":"https://github.com/CaMnter/EasyRecyclerViewSidebar","used":true,"who":"Yuanyu Zhang"},{"_id":"570f48446776590f5a0ecbc8","createdAt":"2016-04-14T15:35:32.563Z","desc":"Pan：一个让人眼前一亮的 MV* 开发框架","publishedAt":"2016-04-15T13:04:43.738Z","source":"web","type":"Android","url":"https://github.com/campusappcn/Pan","used":true,"who":"Zhihao Deng"},{"_id":"570f40016776590f57c4e100","createdAt":"2016-04-14T15:00:17.940Z","desc":"Android UI性能优化详解","publishedAt":"2016-04-15T13:04:43.738Z","source":"chrome","type":"Android","url":"http://mrpeak.cn/android/2016/01/11/android-performance-ui","used":true,"who":"AndWang"},{"_id":"570ef1686776590f57c4e0f8","createdAt":"2016-04-14T09:24:56.679Z","desc":"狂拽酷炫叼的翻转折叠布局效果","publishedAt":"2016-04-14T11:43:31.514Z","source":"web","type":"Android","url":"https://github.com/Ramotion/folding-cell-android","used":true,"who":"liuzheng"},{"_id":"570e5c786776590f5a0ecbc1","createdAt":"2016-04-13T22:49:28.95Z","desc":"android真正的\u201c万能\u201dAdapter","publishedAt":"2016-04-14T11:43:31.514Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/d6a76fd3ea5b","used":true,"who":"cey"},{"_id":"570e1f016776590f5a0ecbbc","createdAt":"2016-04-13T18:27:13.511Z","desc":"Android自定义View之高仿QQ健康","publishedAt":"2016-04-14T11:43:31.514Z","source":"chrome","type":"Android","url":"http://www.jianshu.com/p/740c64ba15ac","used":true,"who":"蒋朋"},{"_id":"570dc0e46776590f62db7bb6","createdAt":"2016-04-13T11:45:40.954Z","desc":"史上最全WebView使用","publishedAt":"2016-04-13T12:20:44.64Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/3fcf8ba18d7f","used":true,"who":"Lazy"},{"_id":"570dbceb6776590f5a0ecbb4","createdAt":"2016-04-13T11:28:43.728Z","desc":"我眼中的Android架构","publishedAt":"2016-04-13T12:20:44.64Z","source":"chrome","type":"Android","url":"http://blog.chengdazhi.com/index.php/150","used":true,"who":"文轩"}]
     */

    private boolean error;
    /**
     * _id : 57105e6e67765974f885bef9
     * createdAt : 2016-04-15T11:22:22.754Z
     * desc : 基于 Facebook Redex 实现 Android APK 的压缩和优化
     * publishedAt : 2016-04-15T13:04:43.738Z
     * source : chrome
     * type : Android
     * url : http://mp.weixin.qq.com/s?__biz=MzAwMTYwNzE2Mg==&mid=2651036594&idx=1&sn=b276c0f76cea713e5d568ab51e3f7f13&scene=0#wechat_redirect
     * used : true
     * who : MVP
     */

    private List<ResultsEntity> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public static class ResultsEntity {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public void set_id(String _id) {
            this._id = _id;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public String get_id() {
            return _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public String getSource() {
            return source;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public boolean isUsed() {
            return used;
        }

        public String getWho() {
            return who;
        }

        @Override
        public String toString() {
            return "ResultsEntity{" +
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
}
