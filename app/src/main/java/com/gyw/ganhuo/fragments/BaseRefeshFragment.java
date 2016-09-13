package com.gyw.ganhuo.fragments;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.adapters.MainGrilAdapter;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.presenter.GrilPresenter;
import com.gyw.ganhuo.presenter.view.GrilView;

import butterknife.Bind;


public abstract class BaseRefeshFragment extends BaseFragment<GrilPresenter> implements GrilView {

//    @Bind(R.id.rv_main_gril)
//    RecyclerView mRecyclerView;


    @Bind(R.id.srl_main_gril)
    SwipeRefreshLayout mRefreshLayout;


    private int mCurrentPage = 1;

    private MainGrilAdapter adapter;

    private StaggeredGridLayoutManager layoutManager;


    private boolean isRefresh = true;   //是否是刷新,默认是刷新


    @Override
    protected abstract View initContentView(LayoutInflater inflater, ViewGroup container);

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
    protected abstract void initData();


    @Override
    protected void initListener() {

        //TODO 后期提出去 需优化
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                onRefreshStart();
            }
        });

        loadMoreData();
    }

    protected abstract void onRefreshStart();

    protected abstract void loadMoreData();


    //TODO 后期提出去 需优化
    @Override
    public void getDataFinished() {

        //数据加载完成
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        }, 1000);

    }
}
