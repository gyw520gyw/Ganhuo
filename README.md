##Discription:

Android 使用干货集中营提供的API, 该项目为练习使用, 主要为了学习使用 MVP、RxJava、Retrofit、OkHttp等知识点; <br/>
使用该接口创作的app非常多, 大多数android使用的是Material Design设计风格, 在国内这种风格使用率还不高, 国内大多数公司开发的Android应用还是比较倾向于是底部带导航条的类iOS风格...


##Screenshot: 
![sample](./screenshot/Screenshot.jpg)


##Download:
[点击去下载~](http://fir.im/gnho)


##Record:


###2016.04.14<br>
创建项目Ganhuo

###2016.04.15<br>
实现网络请求

参考： <br/>  
http://gank.io/api<br>
http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/1109/3662.html
http://jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/1016/3588.html

问题: <br/>
String BASE_API = "http://gank.io/api/data"
和
@GET("/{type}/{pageSize}/{pageIndex}")
这样的写法,页面找不到404

解决: <br/>
在第二个链接中找到的解决办法
如果有前缀 / 就代表着是一个绝对路径。删除了那个前缀的 /， 你将会得到正确路径的全 URL。


###2016.04.25<br/>
实现沉浸式状态栏


参考：<br/>
https://github.com/laobie/StatusBarUtil



###2016.08.01<br/>
实现首页基本样式,底部tab

###2016.09.05<br/>
1.使用FragmentTabHost，创建对应fragment;<br/>
2.使用自定义组合控件Topbar;<br/>


###2016.09.06<br/>
1.请求福利类型的接口成功，初步完成福利模块;<br/>
2.使用Glide加载图片;<br/>
最近电脑出了点问题，只要一翻墙，就出现资源管理器不断重启，所以没有升级AndroidStudio..<br/>

参考:<br/>
http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0327/2650.html


###2016.09.08<br/>
1.使用SwipeRefreshLayout做下拉刷新操作功能;

###2016.09.09<br/>
1.添加加载更多功能;


参考:<br/>
Glide : http://blog.csdn.net/shangmingchao/article/details/51125554 , 有很多方法的解释;



###2016.09.12<br/>
1.初步写了发现模块, 将其分成各个技术模块(android/iOS) ;

参考:<br/>
TabLayout 结合 ViewPager : http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0731/3247.html


###2016.09.13<br/>
1.初步完成发现模块,二级跳转页面还没有写;<br/>

参考:<br/>
TabLayout : http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0731/3247.html
问题:<br/>
TabLayout中的文字如果是字母,那字母都是大写,如何修改?


###2016.09.14<br/>
1. 添加发现模块的加载更多的footer;

参考:<br/>
RecyclerView加载更多添加footer:  http://blog.csdn.net/dalancon/article/details/46125667
此种方法简单, 感觉不适合配合TabLayout一起使用,TotalCount不好判断;


###2016.09.18<br/>
1. 添加发现模块详情页;

###2016.09.19<br/>
1. 优化福利首页显示和点击效果;<br/>
2. 添加福利模块详情页(使用牛逼的Rxjava+Retrofit+okHttp同时请求两个接口的数据;直接跳到视频页,效果不是很好);<br/>
3. 使用Snackbar提示加载数据错误的情况,并且点击重试;<br/>

###2016.09.20<br/>
1. 初步实现我的模块中关于我们;


###2016.09.21<br/>
1. 实现关于我们中的Html在TextView中时的页面跳转;<br/>
2. 添加umeng统计功能(umeng反馈不维护了,集成之后才知道);<br/>

参考:<br/>
TextView中带html标签 : http://stackoverflow.com/questions/12119800/android-set-link-with-a-href-in-textview<br/>
推荐阅读:<br/>
Glide : http://gold.xitu.io/post/57df609767f3560056b03672<br/>


###2016.09.22
界面初步完成... <br/>

已知问题:<br/>
1. 加载更多处理的不是很好, 需优化;<br/>
2. 数据没有做缓存;<br/>
3. 重复代码没有抽取;<br/>

###2016.09.30<br/>
1. 优化代码，将下拉刷新的代码放到基类中;


###2016.10.24<br/>
1. 修改意见反馈，使用第三方阿里百川反馈;<br/>http://baichuan.taobao.com/

使用中遇到的问题：<br/>
官方文档上写的，使用这个属性themeColor(标题栏自定义颜色 "#ffffff")，设置标题栏颜色，我设置了没有变化，不知道是什么原因;





##效果: 
![sample](./screenshot/ganhuo.gif)




