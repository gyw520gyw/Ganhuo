package com.gyw.ganhuo.weiget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;


import com.gyw.ganhuo.R;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author gyw
 * @version 1.0
 * @time: 2015-12-25 下午1:08:25
 * @fun:
 */
public class CustomWebView extends LinearLayout {

	@Bind(R.id.web_view)
	WebView mWebView;

	@Bind(R.id.progress_bar)
	ProgressBar mProgressBar;

	private String mUrl;
	private Context mContext;

	private static final String INJECTION_TOKEN = "**injection**";

	private String errorHtml = "<html><head><meta charset='UTF-8'></head><body><br><br><br><br><br><br><br><div align='center' style='font-size: smaller'>暂无数据 <br> 很抱歉给你带来了不便, 请谅解！</div></body></html>";

	// @JavascriptInterface
	// public void refresh() {
	// Toast.makeText(mContext, "12345 "+url, 1).show();
	// mWebView.loadUrl("javascript:show("+url+")");
	// FrameLayout mContainerFl = ((FrameLayout)this.getParent());
	// mContainerFl.removeAllViews();
	// mContainerFl.addView(this);
	// loadUrl(url);
	// }

	public CustomWebView(Context context) {
		this(context, null);
	}

	public CustomWebView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.mContext = context;
		initView(context);
	}

	private void initView(Context context) {
		View.inflate(context, R.layout.view_web_custom, this);
		ButterKnife.bind(this);
	}

	public String getUrl() {
		return mUrl;
	}

	/*
	 * public void setUrl(String url) { this.url = url; }
	 */

	public void loadUrl(String url) {
		this.mUrl = url;
		initWebview(url);
	}

	private void initWebview(final String url) {
		// mWebView.addJavascriptInterface(this, "android");
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		// 设置可以访问文件
		webSettings.setAllowFileAccess(true);
		// 设置可以支持缩放
		webSettings.setSupportZoom(true);
		// 设置默认缩放方式尺寸是far
		webSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
		// 设置出现缩放工具
		webSettings.setBuiltInZoomControls(false);
		webSettings.setDefaultFontSize(16);

		if (url.startsWith("http:") || url.startsWith("https:")) {
			mWebView.loadUrl(url);
		} else {
			mWebView.loadData(errorHtml, "text/html; charset=UTF-8", null);
		}

		// 设置WebViewClient
		mWebView.setWebViewClient(new WebViewClient() {

			// url拦截
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// 使用自己的WebView组件来响应Url加载事件，而不是使用默认浏览器器加载页面
				 view.loadUrl(url);
				// // 相应完成返回true
				 return true;
				// return super.shouldOverrideUrlLoading(view, url);

//				if (url.startsWith("http:") || url.startsWith("https:")) {
//					return false;
//				}
//				
//				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//				UiUtil.startActivity(intent);
//				
//				return true;

			}

			// 页面开始加载
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				mProgressBar.setVisibility(View.VISIBLE);
				super.onPageStarted(view, url, favicon);
			}

			// 页面加载完成
			@Override
			public void onPageFinished(WebView view, String url) {
				mProgressBar.setVisibility(View.GONE);

				// if(!TextUtils.isEmpty(errorHtml)) {
				// mWebView.clearHistory();
				// }

				super.onPageFinished(view, url);
			}

			// WebView加载的所有资源url
			@Override
			public void onLoadResource(WebView view, String url) {
				super.onLoadResource(view, url);
			}

			@Override
			public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
				// errorHtml =
				// "<html><head><meta charset='UTF-8'></head><body><br><br><br><br><br><br><br><div align='center' ><a href='"+mUrl+"' style='text-decoration: none'>暂无数据 <br> 网络连接后点击刷新！</a></div></body></html>";
				// view.loadData(errorHtml, "text/html; charset=UTF-8", null);
				super.onReceivedError(view, errorCode, description, failingUrl);
			}

			/**
			 * 淘宝页面加载
			 */
			@Override
			public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
				WebResourceResponse response = super.shouldInterceptRequest(view, url);
				if (url != null && url.contains(INJECTION_TOKEN)) {
					String assetPath = url.substring(url.indexOf(INJECTION_TOKEN) + INJECTION_TOKEN.length(),
							url.length());
					try {
						response = new WebResourceResponse("application/javascript", "UTF8", getContext().getAssets()
								.open(assetPath));
					} catch (IOException e) {
						e.printStackTrace(); // Failed to load asset file
					}
				}
				return response;
			}
		});

		// 设置WebChromeClient
		mWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			// 处理javascript中的alert
			public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
				return super.onJsAlert(view, url, message, result);
			};

			@Override
			// 处理javascript中的confirm
			public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
				return super.onJsConfirm(view, url, message, result);
			};

			@Override
			// 处理javascript中的prompt
			public boolean onJsPrompt(WebView view, String url, String message, String defaultValue,
					final JsPromptResult result) {
				return super.onJsPrompt(view, url, message, defaultValue, result);
			};

			// 设置网页加载的进度条
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				mProgressBar.setProgress(newProgress);
				super.onProgressChanged(view, newProgress);
			}

			// 设置程序的Title
			@Override
			public void onReceivedTitle(WebView view, String title) {
				super.onReceivedTitle(view, title);
			}
		});

		mWebView.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) { // 表示按返回键

						mWebView.goBack(); // 后退
						// webview.goForward();//前进

						return true; // 已处理
					}
				}
				return false;
			}
		});
	}

	public boolean canBack() {
		if (mWebView.canGoBack()) {
			mWebView.goBack();
			return false;
		}
		return true;
	}

	public void pauseVideo() {
		mWebView.onPause();
	}
	
	public void onDestroyView() {
		if (mWebView != null) {
			mWebView.destroy();
			mWebView = null;
		}
	}
}
