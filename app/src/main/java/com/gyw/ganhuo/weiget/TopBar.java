package com.gyw.ganhuo.weiget;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.gyw.ganhuo.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class TopBar extends RelativeLayout implements View.OnClickListener {

	// 左边的图片
	@Bind(R.id.iv_top_bar_left)
	ImageView mLeftIv;

	// 标题
	@Bind(R.id.tv_top_bar_title)
	TextView mTitleTv;

	// 最右边的图片
	@Bind(R.id.iv_top_bar_right)
	ImageView mRightIv;


	private Context mContext;

	private int leftSrc;
	private String centerText;
	private int rightSrc;
	private boolean isShowLeft;
	private boolean isShowRight;

	private int barBg;

	private View mView;

	private OnTopBarClickListener listener;

	public TopBar(Context context) {
		this(context, null);
	}

	public TopBar(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public TopBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		this.mContext = context;

		TypedArray ta  = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TopBar, defStyle, 0);
//		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RsTopBar);

		leftSrc = ta.getResourceId(R.styleable.TopBar_leftSrc, R.mipmap.main_01_01_gril_default);
		centerText = ta.getString(R.styleable.TopBar_centerText);
		rightSrc = ta.getResourceId(R.styleable.TopBar_rightSrc, R.mipmap.main_01_01_gril_default);
		isShowLeft = ta.getBoolean(R.styleable.TopBar_isShowLeft, true);
		isShowRight = ta.getBoolean(R.styleable.TopBar_isShowRight, true);
		barBg = ta.getResourceId(R.styleable.TopBar_barBg, R.color.main_01_font_color_selector);

		ta.recycle();

		initContentView();
		initView();
		initListener();
	}

	private void initContentView() {
		mView = View.inflate(mContext, R.layout.top_bar_view_rs, this);
		ButterKnife.bind(this);
	}

	private void initView() {

		// 设置背景
		mView.setBackgroundColor(barBg);

//		mTitleTv.setTextSize(centerTextSize);
		mTitleTv.setText(centerText);

		if (isShowLeft) {
			mLeftIv.setVisibility(View.VISIBLE);
			mLeftIv.setImageResource(leftSrc);
		} else {
			mLeftIv.setVisibility(View.GONE);
		}

		if (isShowRight) {
			mRightIv.setVisibility(View.VISIBLE);
			mRightIv.setImageResource(rightSrc);
		} else {
			mRightIv.setVisibility(View.GONE);
		}
	}



	private void initListener() {
		mLeftIv.setOnClickListener(this);
		mRightIv.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_top_bar_left:
			if (listener != null) {
				listener.onTopBarLeftClick(v);
			}
			break;

		case R.id.iv_top_bar_right:
			if (listener != null) {
				listener.onTopBarRightClick(v);
			}
			break;
		}
	}

	public void setOnTopBarClickListener(OnTopBarClickListener listener) {
		this.listener = listener;
	}

	public interface OnTopBarClickListener {
		void onTopBarRightClick(View v);
		void onTopBarLeftClick(View v);
	}


	public void setCenterText(String centerText) {
		this.centerText = centerText;
		mTitleTv.setText(centerText);
	}


	public void setShowLeft(boolean isShowLeft) {
		this.isShowLeft = isShowLeft;
		
		if (isShowLeft) {
			mLeftIv.setVisibility(View.VISIBLE);
			mLeftIv.setImageResource(leftSrc);
		} else {
			mLeftIv.setVisibility(View.GONE);
		}
	}


	public void setShowRight(boolean isShowRight) {
		this.isShowRight = isShowRight;
		
		if (isShowRight) {
			mRightIv.setVisibility(View.VISIBLE);
			mRightIv.setImageResource(rightSrc);
		} else {
			mRightIv.setVisibility(View.GONE);
		}

	}
}
