2016.04.14<br>
创建项目Ganhuo

2016.04.15<br>
实现网络请求

参考：   
http://gank.io/api<br>
http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/1109/3662.html
http://jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/1016/3588.html

问题:
String BASE_API = "http://gank.io/api/data"
和
@GET("/{type}/{pageSize}/{pageIndex}")
这样的写法,页面找不到404

解决: 在第二个链接中找到的解决办法
如果有前缀 / 就代表着是一个绝对路径。删除了那个前缀的 /， 你将会得到正确路径的全 URL。


2016.04.25<br/>
实现沉浸式状态栏

参考：
https://github.com/laobie/StatusBarUtil