package com.gyw.ganhuo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.activitys.ContainerActivity;
import com.gyw.ganhuo.base.BaseFragment;

import butterknife.OnClick;

public class MainMineFragment extends BaseFragment {

    @OnClick({R.id.iv_mine_head_pic, R.id.rl_mine_about_us, R.id.rl_mine_collection, R.id.rl_mine_feedback})
    void openA(View v) {

        Bundle bundle = new Bundle();

        switch (v.getId()) {

            case R.id.rl_mine_about_us:

//                Toast.makeText(mContext, "关于我们", Toast.LENGTH_SHORT).show();

                bundle.putString(BaseFragment.ARG_PARAM1, "关于我们");

                break;

            case R.id.rl_mine_collection:

//                Toast.makeText(mContext, "我的收藏", Toast.LENGTH_SHORT).show();

                bundle.putString(BaseFragment.ARG_PARAM1, "我的收藏");

                break;

            case R.id.rl_mine_feedback:

//                Toast.makeText(mContext, "意见反馈", Toast.LENGTH_SHORT).show();

                bundle.putString(BaseFragment.ARG_PARAM1, "意见反馈");

                break;

        }

        ContainerActivity.startA(bundle, ContainerActivity.PageType.MINE_ABOUT_US_FRAGMENT);
    }

    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_main_mine, container, false);
        return view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
