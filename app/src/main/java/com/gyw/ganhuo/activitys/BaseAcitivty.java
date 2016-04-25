package com.gyw.ganhuo.activitys;

import android.os.Bundle;
import android.os.PersistableBundle;
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
public abstract class BaseAcitivty extends AppCompatActivity {

    GanApi mGanApi = MainFactory.getGanApiInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        initData();

        Toast.makeText(this, "baseActivity", Toast.LENGTH_SHORT).show();
    }

    public void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
    }


    protected abstract void initData();

}
