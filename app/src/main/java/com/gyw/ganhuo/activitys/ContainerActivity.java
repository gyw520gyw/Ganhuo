package com.gyw.ganhuo.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.gyw.ganhuo.R;
import com.gyw.ganhuo.base.BaseActivity;
import com.gyw.ganhuo.base.BaseFragment;
import com.gyw.ganhuo.fragments.AboutUsFragment;
import com.gyw.ganhuo.fragments.DiscoDetailFragment;
import com.gyw.ganhuo.fragments.MyCollectionFragment;
import com.gyw.ganhuo.utils.UiUtil;
import com.gyw.ganhuo.weiget.TopBar;
import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContainerActivity extends BaseActivity {

    private static final String PAGE_TYPE = "page_type";
    private static final String TAG = "ContainerActivity";

    private PageType mPageType;
    private Bundle bundle;

    @Bind(R.id.topbar_container)
    TopBar mTopbar;


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

                case DISCO_DETAIL_FRAGMENT: //发现详情

                    fragment = DiscoDetailFragment.newInstance(bundle);

                    break;

                case GRIL_DETAIL_FRAGMENT:  // 福利详情

                    fragment = DiscoDetailFragment.newInstance(bundle);

                    break;

                case MINE_ABOUT_US_FRAGMENT:    //关于我们

                    fragment = AboutUsFragment.newInstance(bundle);

                    break;

                case MINE_MY_COLLECTION_FRAGMENT:   //我的收藏

                    fragment = MyCollectionFragment.newInstance(bundle);

                    break;

                case MINE_FEEDBACK_FRAGMENT:    //意见反馈

//                    fragment = DiscoDetailFragment.newInstance(bundle);

                    Map<String, String> uiCustomInfoMap = new HashMap<String, String>();
                    uiCustomInfoMap.put("themeColor", "#3F51B5");
                    uiCustomInfoMap.put("pageTitle", "意见反馈");
                    uiCustomInfoMap.put("hideLoginSuccess", "true");

                    FeedbackAPI.setUICustomInfo(uiCustomInfoMap);

                    FeedbackAPI.setCustomContact("test", false);

                    Fragment feedbackFragment = FeedbackAPI.getFeedbackFragment();

                    getSupportFragmentManager().beginTransaction().add(R.id.container, feedbackFragment, TAG).commit();

                    break;
            }

            if(mPageType != PageType.MINE_FEEDBACK_FRAGMENT) {
                getSupportFragmentManager().beginTransaction().add(R.id.container, fragment, TAG).commit();
            }

        }

    }

    public enum PageType {
        DISCO_DETAIL_FRAGMENT, GRIL_DETAIL_FRAGMENT,
        MINE_ABOUT_US_FRAGMENT, MINE_MY_COLLECTION_FRAGMENT, MINE_FEEDBACK_FRAGMENT;
    }


    public static void startA(Bundle bundle, PageType pageType) {
        Intent intent = new Intent(UiUtil.getContext(), ContainerActivity.class);
        intent.putExtra(BaseFragment.ARG_PARAM1, bundle);
        intent.putExtra(PAGE_TYPE, pageType);
        UiUtil.startActivity(intent);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);       //统计时长
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
