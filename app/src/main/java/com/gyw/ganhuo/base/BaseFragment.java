package com.gyw.ganhuo.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import butterknife.ButterKnife;

/**
 * 
 * @author gyw
 * @version 1.0
 * @time: 2015-8-19 上午11:43:49
 * @fun:
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

	public static final String ARG_PARAM1 = "arg_param1";
	public static final String ARG_PARAM2 = "arg_param2";

	public String arg_param1;

	protected BaseActivity mActivity;
	protected View view = null;
	protected Context mContext = null;
	
	protected P p;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		mActivity = (BaseActivity) context;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (view == null) {
			view = initContentView(inflater, container);
			ButterKnife.bind(this, view);
			initView();
			initData();
			initListener();
		} else {
			ViewParent parent = view.getParent();
			if (parent != null && parent instanceof ViewGroup) {
				ViewGroup group = (ViewGroup) parent;
				group.removeView(view);
			}
		}

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
//		initData();
//		initListener();
	}

	
	/**
	 * 设置布局文件
	 */
	protected abstract View initContentView(LayoutInflater inflater, ViewGroup container);

	/**
	 * 初始化布局文件中的控件
	 */
	protected abstract void initView();
	
	
	/**
	 * 初始化数据
	 */
	protected abstract void initData();


	/**
	 * 设置控件的监听
	 */
	protected abstract void initListener();


	
}
