package com.gyw.ganhuo.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.utils.StatusBarUtil;

/**
 * Created by Administrator on 2016/4/25.
 */
public abstract class BaseActivity extends FragmentActivity {

    public static BaseActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setStatusBar();
        initView();
        initData();
        initFragment(savedInstanceState);
    }



    public void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
    }

    public static BaseActivity getBaseActivity() {
        return mActivity;
    }

    protected abstract void initData();
    protected abstract void initView();

    protected void initFragment(Bundle savedInstanceState) {

    }

}
