package com.gyw.ganhuo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.utils.UiUtil;
import com.gyw.ganhuo.weiget.CustomWebView;
import com.gyw.ganhuo.weiget.TopBar;
import com.umeng.analytics.MobclickAgent;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoDetailFragment extends BaseFragment {

    @Bind(R.id.top_bar_disco_detail)
    TopBar mTopbar;


    @Bind(R.id.fl_detail_container)
    FrameLayout mContainerFl;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            arg_param1 = getArguments().getString(ARG_PARAM1);
            arg_param2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_disco_detail, container, false);
        return view;
    }

    @Override
    protected void initView() {
        if(!TextUtils.isEmpty(arg_param2)) {
            mTopbar.setCenterText(arg_param2);
        }
    }

    @Override
    protected void initData() {
        CustomWebView mCustomWebView= new CustomWebView(UiUtil.getContext());
        mContainerFl.addView(mCustomWebView);
        mCustomWebView.loadUrl(arg_param1);
    }

    @Override
    protected void initListener() {

    }

    public static DiscoDetailFragment newInstance(Bundle bundle) {
        DiscoDetailFragment fragment = new DiscoDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
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
