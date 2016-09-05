package com.gyw.ganhuo.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.http.GanApi;
import com.gyw.ganhuo.http.MainFactory;
import com.gyw.ganhuo.utils.StatusBarUtil;

/**
 * Created by Administrator on 2016/4/25.
 */
public abstract class BaseActivity extends FragmentActivity {

    GanApi mGanApi = MainFactory.getGanApiInstance();

    public static BaseActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setStatusBar();
        initView();
        initData();
    }

    public void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
    }

    public static BaseActivity getBaseActivity() {
        return mActivity;
    }

    protected abstract void initData();
    protected abstract void initView();

}
