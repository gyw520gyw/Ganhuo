package com.gyw.ganhuo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.utils.UiUtil;
import com.gyw.ganhuo.weiget.CustomWebView;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoDetailFragment extends BaseFragment {

    @Bind(R.id.fl_detail_container)
    FrameLayout mContainerFl;

    //获取的url
    private String mUrl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUrl = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_disco_detail, container, false);
        return view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        CustomWebView mCustomWebView= new CustomWebView(UiUtil.getContext());
        mContainerFl.addView(mCustomWebView);
        mCustomWebView.loadUrl(mUrl);
    }

    @Override
    protected void initListener() {

    }

    public static DiscoDetailFragment newInstance(Bundle bundle) {
        DiscoDetailFragment fragment = new DiscoDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
