package com.gyw.ganhuo.activitys;

import android.content.Intent;
import android.os.Bundle;

import com.gyw.ganhuo.R;
import com.gyw.ganhuo.base.BaseActivity;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.fragments.DiscoDetailFragment;
import com.gyw.ganhuo.utils.UiUtil;

import butterknife.ButterKnife;

public class ContainerActivity extends BaseActivity {

    private static final String PAGE_TYPE = "page_type";
    private static final String TAG = "ContainerActivity";

    private PageType mPageType;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_container);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        mPageType = (PageType) getIntent().getSerializableExtra(PAGE_TYPE);
        bundle = getIntent().getBundleExtra(BaseFragment.ARG_PARAM1);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        super.initFragment(savedInstanceState);


        if (savedInstanceState == null) {
            BaseFragment fragment = null;

            switch (mPageType) {

                case DISCO_DETAIL_FRAGMENT:

                    fragment = DiscoDetailFragment.newInstance(bundle);

                    break;

//                case GRIL_DETIAL_FRAGMENT:
//
//                    fragment = DiscoDetailFragment.newInstance(bundle);
//
//                    break;

            }

            getSupportFragmentManager().beginTransaction().add(R.id.container, fragment, TAG).commit();

        }

    }

    public enum PageType {
        DISCO_DETAIL_FRAGMENT,  GRIL_DETIAL_FRAGMENT;
    }




    public static void startA(Bundle bundle, PageType pageType) {
        Intent intent = new Intent(UiUtil.getContext(), ContainerActivity.class);
        intent.putExtra(BaseFragment.ARG_PARAM1, bundle);
        intent.putExtra(PAGE_TYPE, pageType);
        UiUtil.startActivity(intent);
    }
}
