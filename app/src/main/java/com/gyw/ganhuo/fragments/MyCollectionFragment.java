package com.gyw.ganhuo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.weiget.TopBar;
import com.umeng.analytics.MobclickAgent;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCollectionFragment extends BaseFragment {

    @Bind(R.id.topbar_about_us)
    TopBar mTopBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            arg_param1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_my_collection, container, false);
        return view;
    }

    @Override
    protected void initView() {
        mTopBar.setCenterText(arg_param1);
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initListener() {

    }

    public static MyCollectionFragment newInstance(Bundle bundle) {
        MyCollectionFragment fragment = new MyCollectionFragment();
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
