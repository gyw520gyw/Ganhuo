package com.gyw.ganhuo.presenter;

import android.content.Context;

import com.gyw.ganhuo.base.BasePresenter;
import com.gyw.ganhuo.model.GanData;
import com.gyw.ganhuo.model.GrilData;
import com.gyw.ganhuo.presenter.view.GrilView;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * author: gyw
 * date: 2016/9/6.
 */
public class GrilPresenter extends BasePresenter<GrilView> {

    private static final int PAGE_SIZE = 10;

    public GrilPresenter(Context context, GrilView view) {
        super(context, view);
    }

    public void getDataFromServer(String type, String type2, int currentPage) {

        //将福利和视频数据结合起来
        Observable.zip(mGanApi.getGanData(type, PAGE_SIZE, currentPage),
                mGanApi.getGanData(type2, PAGE_SIZE, currentPage),
                new Func2<GrilData, GrilData, GrilData>() {
                    @Override
                    public GrilData call(GrilData grilData, GrilData grilData2) {
                        return createType2ToType(grilData, grilData2);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<GrilData, List<GanData>>() {
                    public List<GanData> call(GrilData data) {
                        //获取数据
                        return data.results;
                    }
                })
                .flatMap(new Func1<List<GanData>, Observable<GanData>>() {
                    @Override
                    public Observable<GanData> call(List<GanData> ganDatas) {
                        return Observable.from(ganDatas);
                    }
                })
                .toSortedList(new Func2<GanData, GanData, Integer>() {
                    @Override
                    public Integer call(GanData ganData, GanData ganData2) {
                        //按照上传时间排序
                        return ganData2.publishedAt.compareTo(ganData.publishedAt);
                    }
                })
                .subscribe(new Subscriber<List<GanData>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showErrorView();
                        mView.getDataFinished();
                    }

                    @Override
                    public void onNext(List<GanData> ganDatas) {
                        //处理数据
                        mView.handleData(ganDatas);
                        mView.getDataFinished();
                    }
                });



//        mGanApi.getGanData(type, PAGE_SIZE, currentPage)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(new Func1<GrilData, List<GanData>>() {
//                    public List<GanData> call(GrilData data) {
//                        //获取数据
//                        return data.results;
//                    }
//                })
//                .flatMap(new Func1<List<GanData>, Observable<GanData>>() {
//                    @Override
//                    public Observable<GanData> call(List<GanData> ganDatas) {
//                        return Observable.from(ganDatas);
//                    }
//                })
//                .toSortedList(new Func2<GanData, GanData, Integer>() {
//                    @Override
//                    public Integer call(GanData ganData, GanData ganData2) {
//                        //按照上传时间排序
//                        return ganData2.publishedAt.compareTo(ganData.publishedAt);
//                    }
//                })
//                .subscribe(new Subscriber<List<GanData>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mView.showErrorView();
//                        mView.getDataFinished();
//                    }
//
//                    @Override
//                    public void onNext(List<GanData> ganDatas) {
//                        //处理数据
//                        mView.handleData(ganDatas);
//                        mView.getDataFinished();
//                    }
//                });
    }

    private GrilData createType2ToType(GrilData grilData, GrilData grilData2) {

        int restSize = grilData2.results.size();

        for (int i = 0; i < grilData.results.size(); i++) {
            if (i <= restSize - 1) {
                GanData girl = grilData.results.get(i);
                girl.desc = grilData2.results.get(i).desc + "#####" + grilData2.results.get(i).url;
            } else {
                break;
            }
        }

        return grilData;
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
