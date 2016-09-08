package com.gyw.ganhuo.fragments;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gyw.ganhuo.R;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.model.GanData;
import com.gyw.ganhuo.presenter.GrilPresenter;
import com.gyw.ganhuo.presenter.view.GrilView;
import com.gyw.ganhuo.utils.TransfUtil;
import com.gyw.ganhuo.utils.UiUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainGrilFragment extends BaseFragment<GrilPresenter> implements GrilView {

    @Bind(R.id.rv_main_gril)
    RecyclerView mRv;


    @Bind(R.id.srl_main_gril)
    SwipeRefreshLayout mSwipeRl;


    private int mCurrentPage = 1;


    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_main_gril, container, false);
        return view;
    }

    @Override
    protected void initView() {

        //第一次进入页面的时候显示加载进度条
        mSwipeRl.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        mSwipeRl.setRefreshing(true);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRv.setLayoutManager(layoutManager);

    }

    @Override
    protected void initData() {
        p = new GrilPresenter(mContext, this);
        p.getDataFromServer(mCurrentPage);
    }

    @Override
    protected void initListener() {
        mSwipeRl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                p.getDataFromServer(mCurrentPage);

            }
        });
    }

    GrilAdapter adapter;
    @Override
    public void handleData(List<GanData> list) {
        if(adapter == null) {
            adapter = new GrilAdapter(list);
            mRv.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void getDataFinished() {

        //数据加载完成
        mSwipeRl.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRl.setRefreshing(false);
            }
        }, 1000);

    }


    public class GrilAdapter extends RecyclerView.Adapter<GrilAdapter.GrilViewHolder> {

        List<GanData> list;

        public GrilAdapter(List<GanData> list) {
            this.list = list;
        }

        @Override
        public GrilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(UiUtil.getContext()).inflate(R.layout.item_gril_adapter, parent, false);
            GrilViewHolder holder = new GrilViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(GrilViewHolder holder, int position) {

            GanData data = list.get(position);
            String url = data.url;
            String time = data.publishedAt;

            Glide.with(UiUtil.getContext())
                    .load(url).into(holder.mItemIv);

            holder.mItemTv.setText(TransfUtil.formatPublishedAt(time));
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class GrilViewHolder extends RecyclerView.ViewHolder {

            @Bind(R.id.iv_gril_item)
            ImageView mItemIv;

            @Bind(R.id.tv_gril_item)
            TextView mItemTv;

            public GrilViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
