package com.gyw.ganhuo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.model.GanData;
import com.gyw.ganhuo.utils.LogUtil;
import com.gyw.ganhuo.utils.TransfUtil;
import com.gyw.ganhuo.utils.UiUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: gyw
 * date: 2016/9/9.
 */
public class DiscoBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<GanData> list;

    private static final int TYPE_LOADING_MORE = -1;
    private static final int NOMAL_ITEM = 1;

    public DiscoBaseAdapter(List<GanData> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case NOMAL_ITEM:
                view = LayoutInflater.from(UiUtil.getContext()).inflate(R.layout.item_disco_classify, parent, false);
                return new DiscoViewHolder(view);

            case TYPE_LOADING_MORE:
                view = LayoutInflater.from(UiUtil.getContext()).inflate(R.layout.item_footer, parent, false);
                return new LoadingMoreViewHolder(view);
        }

        return new DiscoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);

        switch(type) {
            case NOMAL_ITEM:
                bindViewHolderNomal((DiscoViewHolder)holder, position);
                break;
            case TYPE_LOADING_MORE:
                bindViewHolderLoading((LoadingMoreViewHolder) holder, position);
                break;
        }
    }


    //加载更多
    private void bindViewHolderLoading(LoadingMoreViewHolder holder, int position) {
        holder.mProgressbar.setVisibility(View.VISIBLE);
    }

    //正常加载
    private void bindViewHolderNomal(DiscoViewHolder holder, int position) {

        GanData data = list.get(position);
        String url = data.url;
        String time = data.publishedAt;


        holder.mDescTv.setText(data.desc);
        holder.mAuthorTv.setText(data.who);
        holder.mDateTv.setText(TransfUtil.formatPublishedAt(time));

    }


    @Override
    public int getItemViewType(int position) {
        LogUtil.d(" position : " + position +  "  getItemCount() : "  + getItemCount());
        if (position + 1 == getItemCount()) {
            return TYPE_LOADING_MORE;       //加载更多
        }
        return NOMAL_ITEM;
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    public class DiscoViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_disco_classify_desc)
        TextView mDescTv;

        @Bind(R.id.tv_disco_classify_author)
        TextView mAuthorTv;

        @Bind(R.id.tv_disco_classify_date)
        TextView mDateTv;

        public DiscoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class LoadingMoreViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.pb_footer)
        ProgressBar mProgressbar;

        public LoadingMoreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
