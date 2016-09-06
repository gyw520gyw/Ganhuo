package com.gyw.ganhuo.base;

import android.content.Context;

import com.gyw.ganhuo.http.GanApi;
import com.gyw.ganhuo.http.MainFactory;

public class BasePresenter<T extends IBaseView> {

	protected T mView;
	
    protected Context mContext;

    protected GanApi mGanApi = MainFactory.getGanApiInstance();

    public BasePresenter(Context context, T view) {
        mContext = context;
        mView = view;
    }
}
