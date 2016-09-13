package com.gyw.ganhuo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gyw.ganhuo.R;
import com.gyw.ganhuo.model.GanData;
import com.gyw.ganhuo.utils.TransfUtil;
import com.gyw.ganhuo.utils.UiUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: gyw
 * date: 2016/9/9.
 */
public class DiscoBaseAdapter extends RecyclerView.Adapter<DiscoBaseAdapter.DiscoViewHolder> {

    private List<GanData> list;

    public DiscoBaseAdapter(List<GanData> list) {
        this.list = list;
    }

    @Override
    public DiscoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(UiUtil.getContext()).inflate(R.layout.item_disco_classify, parent, false);
        DiscoViewHolder holder = new DiscoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DiscoViewHolder holder, int position) {

        GanData data = list.get(position);
        String url = data.url;
        String time = data.publishedAt;


        holder.mDescTv.setText(data.desc);
        holder.mAuthorTv.setText(data.who);
        holder.mDateTv.setText(TransfUtil.formatPublishedAt(time));
    }

    @Override
    public int getItemCount() {
        return list.size();
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
}
