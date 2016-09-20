package com.gyw.ganhuo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.utils.PackageUtil;
import com.gyw.ganhuo.utils.UiUtil;
import com.gyw.ganhuo.weiget.CustomWebView;
import com.gyw.ganhuo.weiget.TopBar;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends BaseFragment {

    @Bind(R.id.topbar_about_us)
    TopBar mTopBar;

    @Bind(R.id.tv_version)
    TextView mVersionTv;

    @Bind(R.id.tv_content)
    TextView mContentTv;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            arg_param1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    protected View initContentView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_about_us, container, false);
        return view;
    }

    @Override
    protected void initView() {
        mTopBar.setCenterText(arg_param1);
    }

    @Override
    protected void initData() {
        //获取版本号
        String version = PackageUtil.getVersionName(UiUtil.getContext());
        mVersionTv.setText(String.format(UiUtil.getString(R.string.abount_us_version), version));


        String content = "<html><head><title><strong>应用介绍：</strong></title></head><body>"+
                "<p>本App中所有数据均来自 <a href='http://gank.io/api'>干货集中营</a> </P>"+
                "<p><strong>项目地址：</strong></P>"+
                "<p><a href='https://github.com/gyw520gyw/Ganhuo'>https://github.com/gyw520gyw/Ganhuo</a> </P>"+
                "<p><strong>报告错误：</strong></P>"+
                "<p><a href='https://github.com/gyw520gyw/Ganhuo/issues'>https://github.com/gyw520gyw/Ganhuo/issues </a> </P>"+
                "<p><strong>感谢：</strong></P>"+
                "<p><a href='https://github.com/daimajia'>@代码家 </a> <br/> " +
                " <a href='<a href='https://github.com/drakeet/Meizhi'>@drakeet </a> <br/>" +
                " <a href='<a href='https://github.com/maoruibin/GankDaily'>@maoruibin </a> </P>"+
                "</body></html>";

        mContentTv.setText(Html.fromHtml(content));



    }

    @Override
    protected void initListener() {

    }

    public static AboutUsFragment newInstance(Bundle bundle) {
        AboutUsFragment fragment = new AboutUsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
