package com.gyw.ganhuo.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.activitys.ContainerActivity;
import com.gyw.ganhuo.adapters.DiscoBaseAdapter;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.model.GanData;
import com.gyw.ganhuo.presenter.DiscoPresenter;
import com.gyw.ganhuo.presenter.view.GrilView;
import com.gyw.ganhuo.utils.LogUtil;
import com.gyw.ganhuo.utils.UiUtil;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class DiscoClassifyFragment extends BaseRefeshFragment<DiscoPresenter> implements GrilView, DiscoBaseAdapter.OnItemClickListener {

    private static final String ARG_PARAM1 = "param1";

    private String mTitle;

    private int mCurrentPage = 1;

    private LinearLayoutManager layoutManager;

    private boolean isRefresh = true;   //是否是刷新,默认是刷新

    private DiscoBaseAdapter adapter;

    @Bind(R.id.rv_disco_classify)
    RecyclerView mRecyclerView;


    public static DiscoClassifyFragment newInstance(String param1) {
        DiscoClassifyFragment fragment = new DiscoClassifyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_diso_classify, container, false);
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initRecyclerView() {
        //设置RecyclerView
        layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void initData() {
        p = new DiscoPresenter(mContext, this);
        p.getDataFromServer(mTitle, mCurrentPage);
    }

    @Override
    protected void initListener() {

        //TODO 后期提出去 需优化
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                isRefresh = true;

                mCurrentPage = 1;

                p.getDataFromServer(mTitle, mCurrentPage);


            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

//                mRefreshLayout.isRefreshing()
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                LogUtil.d("visibleItemCount : " + visibleItemCount + " totalItemCount : " + totalItemCount + " pastVisibleItems :  " + pastVisibleItems);

                if (!mRefreshLayout.isRefreshing() && (visibleItemCount + pastVisibleItems) >= totalItemCount) {

                    isRefresh = false;

                    mCurrentPage = mCurrentPage + 1;

                    loadMoreData();
                }
            }
        });
    }

    @Override
    protected void onRefreshStart() {
        isRefresh = true;

        mCurrentPage = 1;

        p.getDataFromServer(mTitle, mCurrentPage);

    }

    @Override
    protected void onloadMoreData() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

//                mRefreshLayout.isRefreshing()
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                LogUtil.d("visibleItemCount : " + visibleItemCount + " totalItemCount : " + totalItemCount + " pastVisibleItems :  " + pastVisibleItems);

                if (!mRefreshLayout.isRefreshing() && (visibleItemCount + pastVisibleItems) >= totalItemCount) {

                    isRefresh = false;

                    mCurrentPage = mCurrentPage + 1;

                    loadMoreData();
                }
            }
        });
    }


    private void loadMoreData() {

        LogUtil.d("mCurrentPage : " + mCurrentPage);

        p.getDataFromServer(mTitle, mCurrentPage);
    }

    @Override
    public void getDataFinished() {
        //数据加载完成
        getBaseDataFinished();
    }

    @Override
    public void showErrorView() {
        Snackbar.make(mRefreshLayout, R.string.error_desc, Snackbar.LENGTH_LONG)
                .setAction(UiUtil.getString(R.string.error_desc_action), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        mRefreshLayout.setRefreshing(true);
                        p.getDataFromServer(mTitle, mCurrentPage);
                    }
                }).show();
    }

    private List<GanData> ganDataList = new ArrayList<>();

    @Override
    public void handleData(List<GanData> list) {

        LogUtil.d("isRefresh : " + isRefresh + " list : " + list.toString());

        //刷新,先清除数据
        if (isRefresh) {
            ganDataList.clear();
        }

        //加载数据,直接添加
        ganDataList.addAll(list);

        if (adapter == null) {
            adapter = new DiscoBaseAdapter(ganDataList);
            adapter.setOnItemClickListener(this);
            mRecyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    //点击进入详情
    @Override
    public void itemClickListener(String url) {
        Bundle bundle = new Bundle();
        bundle.putString(BaseFragment.ARG_PARAM1, url);
        ContainerActivity.startA(bundle, ContainerActivity.PageType.DISCO_DETAIL_FRAGMENT);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(this.getClass().getSimpleName());
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageStart(this.getClass().getSimpleName());
    }
}
