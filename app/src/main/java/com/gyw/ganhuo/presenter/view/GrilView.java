package com.gyw.ganhuo.presenter.view;

import com.gyw.ganhuo.base.IBaseView;
import com.gyw.ganhuo.model.GanData;
import com.gyw.ganhuo.model.GrilData;

import java.util.List;

/**
 * author: gyw
 * date: 2016/9/6.
 */
public interface GrilView extends IBaseView<List<GanData>> {

    //数据请求完成
    void getDataFinished();

    //显示错误页
    void showErrorView();
}
