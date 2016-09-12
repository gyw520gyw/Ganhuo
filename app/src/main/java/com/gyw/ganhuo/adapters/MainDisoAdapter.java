package com.gyw.ganhuo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gyw.ganhuo.base.BaseFragment;

import java.util.List;

/**
 * author: gyw
 * date: 2016/9/12.
 */
public class MainDisoAdapter extends FragmentPagerAdapter{

    private String[] titileArr;
    private List<BaseFragment> fragmentList;

    public MainDisoAdapter(FragmentManager childFragmentManager, String[] titleArr, List<BaseFragment> fragmentList) {
        super(childFragmentManager);
        this.titileArr = titleArr;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return titileArr.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titileArr[position];
    }
}
