package com.gyw.ganhuo.presenter;

import android.content.Context;

import com.gyw.ganhuo.base.BasePresenter;
import com.gyw.ganhuo.base.IBaseView;
import com.gyw.ganhuo.http.GanUri;
import com.gyw.ganhuo.model.GanData;
import com.gyw.ganhuo.model.GrilData;
import com.gyw.ganhuo.presenter.view.GrilView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * author: gyw
 * date: 2016/9/6.
 */
public class GrilPresenter extends BasePresenter<GrilView> {


    public GrilPresenter(Context context, GrilView view) {
        super(context, view);
    }


    public void getDataFromServer() {
        mGanApi.getGanData(GanUri.TYPE_FULI, 10, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<GrilData, List<GrilData.ResultsEntity>>() {
                    public List<GrilData.ResultsEntity> call(GrilData data) {
                        return data.getResults();
                    }
                }).subscribe(new Subscriber<List<GrilData.ResultsEntity>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(List<GrilData.ResultsEntity> resultsEntities) {
//                mContent.setText(resultsEntities.toString());

                mView.handleData(resultsEntities);
            }
        });
    }


  /*  @Override
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
    }*/

}
