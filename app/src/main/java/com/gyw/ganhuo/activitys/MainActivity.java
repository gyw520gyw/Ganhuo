package com.gyw.ganhuo.activitys;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.http.GanApi;
import com.gyw.ganhuo.http.GanUri;
import com.gyw.ganhuo.http.MainFactory;
import com.gyw.ganhuo.model.GanData;
import com.gyw.ganhuo.utils.StatusBarUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseAcitivty {

    @Bind(R.id.tv)
    TextView mTv;

    @Bind(R.id.content)
    TextView mContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        mGanApi.getGanData(GanUri.TYPE_ANDROID, 10, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<GanData, List<GanData.ResultsEntity>>() {
                    public List<GanData.ResultsEntity> call(GanData data) {
                        return data.getResults();
                    }
                }).subscribe(new Subscriber<List<GanData.ResultsEntity>>() {
            @Override
            public void onCompleted() {
                mTv.setText("加载完成");
            }

            @Override
            public void onError(Throwable e) {
                mTv.setText("加载失败" + e.toString());
            }

            @Override
            public void onNext(List<GanData.ResultsEntity> resultsEntities) {
                mContent.setText(resultsEntities.toString());
            }
        });
    }

}
