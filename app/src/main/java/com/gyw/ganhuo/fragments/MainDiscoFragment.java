package com.gyw.ganhuo.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.adapters.MainDisoAdapter;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.utils.UiUtil;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainDiscoFragment extends BaseFragment {

    @Bind(R.id.tl_main_diso)
    TabLayout mTabLayout;

    @Bind(R.id.vp_main_diso)
    ViewPager mViewPager;


    private List<BaseFragment> fragmentList = null;

    private String[] titleArr = null;


    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_main_disco, container, false);
        return view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        titleArr = UiUtil.getStringArray(R.array.main_diso_title_arr);
        fragmentList =  new ArrayList<BaseFragment>();

        for(String title : titleArr) {
            fragmentList.add(DiscoClassifyFragment.newInstance(title));
        }


        mViewPager.setAdapter(new MainDisoAdapter(getChildFragmentManager(), titleArr, fragmentList));

        // setupWithViewPager必须在ViewPager.setAdapter() 之后调用
        // 小屏手机显示不下
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    protected void initListener() {

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
