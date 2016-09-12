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

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainDisoFragment extends BaseFragment {

    @Bind(R.id.tl_main_diso)
    TabLayout mTabLayout;

    @Bind(R.id.vp_main_diso)
    ViewPager mViewPager;


    private List<BaseFragment> fragmentList = null;

    private String[] titleArr = null;


    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_main_diso, container, false);
        return view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        titleArr = UiUtil.getStringArray(R.array.main_diso_title_arr);
        fragmentList =  new ArrayList<BaseFragment>();

        fragmentList.add(DisoAndroidFragment.newInstance());
        fragmentList.add(DisoIosFragment.newInstance());

        mViewPager.setAdapter(new MainDisoAdapter(getChildFragmentManager(), titleArr, fragmentList));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initListener() {

    }
}
