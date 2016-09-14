package com.gyw.ganhuo.adapters;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
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
public class MainGrilAdapter extends RecyclerView.Adapter<MainGrilAdapter.GrilViewHolder> {

    private List<GanData> list;

    public MainGrilAdapter(List<GanData> list) {
        this.list = list;
    }

    @Override
    public GrilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(UiUtil.getContext()).inflate(R.layout.item_gril_main, parent, false);
        GrilViewHolder holder = new GrilViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(GrilViewHolder holder, int position) {

        GanData data = list.get(position);
        String url = data.url;
        String time = data.publishedAt;

        Glide.with(UiUtil.getContext())
                .load(url)
                .placeholder(R.mipmap.loading_icon)
                .error(R.mipmap.loading_icon)
                //重新设置Target的宽高值（单位为pixel）,不然加载出来的图片会和默认图片一样大
                //TODO 这里的两个值需要研究一下
                .override(600, 600)
                .fitCenter()
                .into(holder.mItemIv);

        holder.mItemTv.setText(TransfUtil.formatPublishedAt(time));
    }

    @Override
    public int getItemCount() {
        return list.size();
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

