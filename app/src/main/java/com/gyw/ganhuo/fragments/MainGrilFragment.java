package com.gyw.ganhuo.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.activitys.ContainerActivity;
import com.gyw.ganhuo.adapters.MainGrilAdapter;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.http.GanUri;
import com.gyw.ganhuo.model.GanData;
import com.gyw.ganhuo.presenter.GrilPresenter;
import com.gyw.ganhuo.presenter.view.GrilView;
import com.gyw.ganhuo.utils.LogUtil;
import com.gyw.ganhuo.utils.UiUtil;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * 首页福利模块
 */
public class MainGrilFragment extends BaseRefeshFragment<GrilPresenter> implements GrilView, MainGrilAdapter.OnItemClickListener {

    @Bind(R.id.rv_main_gril)
    RecyclerView mRecyclerView;

    private int mCurrentPage = 1;

    private MainGrilAdapter adapter;

    private StaggeredGridLayoutManager layoutManager;

    private boolean isRefresh = true;   //是否是刷新,默认是刷新


    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_main_gril, container, false);
        return view;
    }

    @Override
    protected void initView() {

        super.initView();
    }

    @Override
    protected void initRecyclerView() {
        //设置RecyclerView
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void initData() {
        p = new GrilPresenter(mContext, this);
        p.getDataFromServer(GanUri.TYPE_FULI, GanUri.TYPE_VEDIO, mCurrentPage);
    }


    @Override
    protected void initListener() {

        super.initListener();

    }

    @Override
    protected void onRefreshStart() {

        isRefresh = true;

        mCurrentPage = 1;

        p.getDataFromServer(GanUri.TYPE_FULI, GanUri.TYPE_VEDIO, mCurrentPage);

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
                int pastVisibleItems = layoutManager.findFirstVisibleItemPositions(new int[2])[1];

                LogUtil.d("visibleItemCount : " + visibleItemCount + " totalItemCount : " + totalItemCount + " pastVisibleItems :  " + pastVisibleItems);

                if (!mRefreshLayout.isRefreshing() && (visibleItemCount + pastVisibleItems) > totalItemCount) {

                    isRefresh = false;

                    mCurrentPage = mCurrentPage + 1;

                    mRefreshLayout.setRefreshing(true);

                    loadMoreData();
                }
            }
        });
    }

    //加载更多数据
    private void loadMoreData() {

        LogUtil.d("mCurrentPage : " + mCurrentPage);

        p.getDataFromServer(GanUri.TYPE_FULI, GanUri.TYPE_VEDIO, mCurrentPage);
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
            adapter = new MainGrilAdapter(ganDataList);
            adapter.setOnItemClickListener(this);
            mRecyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }

    }

    //TODO 后期提出去 需优化
    @Override
    public void getDataFinished() {


        getBaseDataFinished();
    }

    @Override
    public void showErrorView() {
        Snackbar.make(mRefreshLayout, R.string.error_desc, Snackbar.LENGTH_LONG)
                .setAction(UiUtil.getString(R.string.error_desc_action), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        mRefreshLayout.setRefreshing(true);
                        p.getDataFromServer(GanUri.TYPE_FULI, GanUri.TYPE_VEDIO, mCurrentPage);
                    }
                }).show();
    }

    //点击item的事件
    @Override
    public void itemClickListener(String str, View view) {

//        Toast.makeText(UiUtil.getContext(), "进入应用", Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        bundle.putString(BaseFragment.ARG_PARAM1, str);
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
