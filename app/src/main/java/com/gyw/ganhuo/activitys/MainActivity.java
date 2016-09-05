package com.gyw.ganhuo.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.base.BaseActivity;
import com.gyw.ganhuo.fragments.MainDisoFragment;
import com.gyw.ganhuo.fragments.MainGrilFragment;
import com.gyw.ganhuo.fragments.MainMineFragment;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

//    @Bind(R.id.tv)
//    TextView mTv;
//
//    @Bind(R.id.content)
//    TextView mContent;


    //定义FragmentTabHost对象
    private FragmentTabHost mTabHost;

    //定义一个布局
    private LayoutInflater layoutInflater;

    //定义数组来存放Fragment界面
    private Class fragmentArray[] = {MainGrilFragment.class, MainDisoFragment.class, MainMineFragment.class};

    //定义数组来存放按钮图片
    private int mImageViewArray[] = {R.drawable.main_01_01_gril_selector, R.drawable.main_01_02_diso_selector, R.drawable.main_01_03_mine_selector};

    //Tab选项卡的文字
    private String mTextviewArray[] = {"福利", "发现", "我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initData() {

    }

    /**
     * 初始化组件
     */
    @Override
    protected void initView() {
        //实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        //实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.fl_container_root);
        mTabHost.getTabWidget().setDividerDrawable(null);

        //得到fragment的个数
        int count = fragmentArray.length;

        for (int i = 0; i < count; i++) {
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            //设置Tab按钮的背景
//            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
        }
    }

    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.view_tab_item, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);

        return view;
    }



  /*  @Override
    protected void initData() {
        mGanApi.getGanData(GanUri.TYPE_ANDROID, 10, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<GanData, List<GanData.ResultsEntity>>() {
                    public List<GanData.ResultsEntity> call(GanData data) {
                        return data.getResults();
                    }
                }).subscribe(new Subscriber<List<GanData.ResultsEntity>>() {
            @Override
            public void onCompleted() {
                mTv.setText("加载完成");
            }

            @Override
            public void onError(Throwable e) {
                mTv.setText("加载失败" + e.toString());
            }

            @Override
            public void onNext(List<GanData.ResultsEntity> resultsEntities) {
                mContent.setText(resultsEntities.toString());
            }
        });
    }*/

}
