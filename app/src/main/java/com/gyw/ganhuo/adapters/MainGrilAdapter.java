package com.gyw.ganhuo.adapters;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gyw.ganhuo.R;
import com.gyw.ganhuo.model.GanData;
import com.gyw.ganhuo.utils.DisplayUtil;
import com.gyw.ganhuo.utils.TransfUtil;
import com.gyw.ganhuo.utils.UiUtil;
import com.gyw.ganhuo.weiget.RatioImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: gyw
 * date: 2016/9/9.
 */
public class MainGrilAdapter extends RecyclerView.Adapter<MainGrilAdapter.GrilViewHolder> {

    private List<GanData> list;

    private OnItemClickListener listener;

    public MainGrilAdapter(List<GanData> list) {
        this.list = list;
    }

    @Override
    public GrilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(UiUtil.getContext()).inflate(R.layout.item_gril_main, parent, false);
        GrilViewHolder holder = new GrilViewHolder(view);
        return holder;
    }

    float y = 0;

    @Override
    public void onBindViewHolder(final GrilViewHolder holder, int position) {

        GanData data = list.get(position);
        String url = data.url;
        String time = data.publishedAt;

        //保证视觉上左右中的间隔相等
        int padding = DisplayUtil.dip2px(UiUtil.getContext(), 3);

        if (position % 2 == 0) {
            holder.mRootRl.setPadding(padding, 0, 0, 0);

        } else {
            holder.mRootRl.setPadding(0, 0, padding, 0);
        }

        Glide.with(UiUtil.getContext())
                .load(url)
                .placeholder(R.mipmap.loading_icon)
                .error(R.mipmap.loading_icon)
//                //重新设置Target的宽高值（单位为pixel）,不然加载出来的图片会和默认图片一样大
//                //TODO 这里的两个值需要研究一下
                .override(600, 600)
                .centerCrop()
                .into(holder.mItemIv);

        final String[] dataArr = data.desc.split("#####");

        holder.mItemTv.setText(TransfUtil.formatPublishedAt(time)/* + "  " + dataArr[0]*/);


        final float scale = 0.95f;

        holder.mRootRl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        y = event.getY();
                        ObjectAnimator ax = ObjectAnimator.ofFloat(v, "scaleX", new float[]{1.0f, scale});
                        ObjectAnimator ay = ObjectAnimator.ofFloat(v, "scaleY", new float[]{1.0f, scale});
                        AnimatorSet all = new AnimatorSet();
                        all.play(ax).with(ay);
                        all.setDuration(200);
                        all.start();
                    case MotionEvent.ACTION_MOVE:
                        float dy = Math.abs(event.getY() - y);
                        if (dy < 20) {
                            break;
                        }
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        ax = ObjectAnimator.ofFloat(v, "scaleX", new float[]{scale, 1.0f});
                        ay = ObjectAnimator.ofFloat(v, "scaleY", new float[]{scale, 1.0f});
                        all = new AnimatorSet();
                        all.play(ax).with(ay);
                        all.setDuration(200);
                        all.start();

                        //是抬起手指才进入
                        if(event.getAction() == MotionEvent.ACTION_UP) {

                            if (listener != null) {
                                listener.itemClickListener(dataArr[1], holder.mRootRl);
                            }
                        }


                        break;
                }

                return true;
            }
        });
    }

    public interface OnItemClickListener {
        void itemClickListener(String str, View view);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GrilViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_gril_item)
        RatioImageView mItemIv;

        @Bind(R.id.tv_gril_item)
        TextView mItemTv;

        @Bind(R.id.rl_gril_item_root)
        RelativeLayout mRootRl;

        public GrilViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            mItemIv.setOriginalSize(3, 4);

        }
    }
}

