package com.gyw.ganhuo.fragments;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gyw.ganhuo.R;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.model.GanData;
import com.gyw.ganhuo.model.GrilData;
import com.gyw.ganhuo.presenter.GrilPresenter;
import com.gyw.ganhuo.presenter.view.GrilView;
import com.gyw.ganhuo.utils.UiUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainGrilFragment extends BaseFragment<GrilPresenter> implements GrilView{

    @Bind(R.id.rv_main_gril)
    RecyclerView mRv;

    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_main_gril, container, false);
        return view;
    }

    @Override
    protected void initView() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRv.setLayoutManager(layoutManager);

    }

    @Override
    protected void initData() {
        p = new GrilPresenter(mContext, this);
        p.getDataFromServer();
    }

    @Override
    protected void initListener() {

    }


    @Override
    public void handleData(List<GanData> list) {


        mRv.setAdapter(new GrilAdapter(list));
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

            String url = list.get(position).url;

            Glide.with(UiUtil.getContext())
                    .load(url).into(holder.mIv);
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class GrilViewHolder extends RecyclerView.ViewHolder {

            @Bind(R.id.iv_gril_adapter)
            ImageView mIv;

            public GrilViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }


}
