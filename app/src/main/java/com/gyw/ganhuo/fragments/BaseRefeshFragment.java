package com.gyw.ganhuo.fragments;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.TypedValue;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.adapters.MainGrilAdapter;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.base.BasePresenter;

import butterknife.Bind;

/**
 * 刷新和加载更多的基类
 */
public abstract class BaseRefeshFragment<P extends BasePresenter> extends BaseFragment {


    @Bind(R.id.srl_layout)
    SwipeRefreshLayout mRefreshLayout;

    protected P p;

    private int mCurrentPage = 1;

    private MainGrilAdapter adapter;

    private StaggeredGridLayoutManager layoutManager;

    private boolean isRefresh = true;   //是否是刷新,默认是刷新

    @Override
    protected void initView() {

        //第一次进入页面的时候显示加载进度条
        mRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        mRefreshLayout.setRefreshing(true);

        initRecyclerView();

    }

    protected abstract void initRecyclerView();


    @Override
    protected void initListener() {

        //TODO 后期提出去 需优化
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                onRefreshStart();
            }
        });

        onloadMoreData();
    }

    protected abstract void onRefreshStart();

    protected abstract void onloadMoreData();


    //TODO 后期提出去 需优话
    public void getBaseDataFinished() {

        //数据加载完成
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        }, 1000);
    }
}
