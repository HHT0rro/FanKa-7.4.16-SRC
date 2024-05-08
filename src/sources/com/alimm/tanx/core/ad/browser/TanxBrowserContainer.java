package com.alimm.tanx.core.ad.browser;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.interaction.tanxc_if;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.AndroidUtils;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxBrowserContainer extends FrameLayout implements DownloadListener {
    public boolean tanxc_byte;
    public ProgressBar tanxc_case;
    public boolean tanxc_char;
    public Context tanxc_do;
    public final boolean tanxc_else;
    public String tanxc_for;
    public IAdWebViewCallback tanxc_goto;
    public WebView tanxc_if;
    public BidInfo tanxc_int;
    public LandingPageUtHelper tanxc_long;
    public ViewGroup tanxc_new;
    public long tanxc_try;

    public TanxBrowserContainer(Context context) {
        this(context, null);
    }

    private void tanxc_case() {
        WebSettings settings = this.tanxc_if.getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e2) {
            LogUtils.e("AdSystemWebViewContainer", "initWebView: failed with exception.", e2);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "AdSystemWebViewContainer", "initWebView: failed with exception." + LogUtils.getStackTraceMessage(e2), "");
        }
        settings.setUserAgentString(settings.getUserAgentString() + AndroidUtils.getUserAgentSuffix() + AndroidUtils.mediaNameStr());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("initWebSettings: userAgent = ");
        sb2.append(settings.getUserAgentString());
        LogUtils.d("AdSystemWebViewContainer", sb2.toString());
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(false);
        settings.setNeedInitialFocus(true);
        settings.setMixedContentMode(0);
        this.tanxc_if.setWebViewClient(new WebViewClient() { // from class: com.alimm.tanx.core.ad.browser.TanxBrowserContainer.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                LogUtils.d("AdSystemWebViewContainer", "onPageFinished: time = " + (System.currentTimeMillis() - TanxBrowserContainer.this.tanxc_try) + "; url = " + str);
                if (TanxBrowserContainer.this.tanxc_case != null) {
                    TanxBrowserContainer.this.tanxc_case.setVisibility(8);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                LogUtils.d("AdSystemWebViewContainer", "onPageStarted: url = " + str);
                if (TanxBrowserContainer.this.tanxc_case != null) {
                    TanxBrowserContainer.this.tanxc_case.setVisibility(0);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i10, String str, String str2) {
                super.onReceivedError(webView, i10, str, str2);
                LogUtils.d("AdSystemWebViewContainer", "onReceivedError: errorCode = " + i10 + ", url = " + str2 + ", description = " + str);
                TanxBrowserContainer.this.tanxc_char();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    LogUtils.d("AdSystemWebViewContainer", "onReceivedHttpError: code = " + webResourceResponse.getStatusCode());
                    TanxBrowserContainer tanxBrowserContainer = TanxBrowserContainer.this;
                    webResourceResponse.getStatusCode();
                    tanxBrowserContainer.tanxc_char();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                LogUtils.d("AdSystemWebViewContainer", "onReceivedSslError: handler = " + ((Object) sslErrorHandler) + ", error = " + ((Object) sslError));
                sslErrorHandler.proceed();
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView.getHitTestResult() != null) {
                    tanxc_if.tanxc_do(webView.getHitTestResult().getType(), TanxBrowserContainer.this.tanxc_try);
                }
                return tanxc_if.tanxc_do(webView.getContext(), str, TanxBrowserContainer.this.tanxc_int) || super.shouldOverrideUrlLoading(webView, str);
            }
        });
        this.tanxc_if.setWebChromeClient(new WebChromeClient() { // from class: com.alimm.tanx.core.ad.browser.TanxBrowserContainer.2
            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                TanxBrowserContainer.this.tanxc_else();
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i10) {
                super.onProgressChanged(webView, i10);
                LogUtils.d("AdSystemWebViewContainer", "onProgressChanged: newProgress = " + i10);
                if (TanxBrowserContainer.this.tanxc_case != null) {
                    TanxBrowserContainer.this.tanxc_case.setProgress(i10);
                    if (i10 == 100) {
                        TanxBrowserContainer.this.tanxc_case.setVisibility(8);
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                TanxBrowserContainer.this.tanxc_goto.onTitleLoaded(str);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                TanxBrowserContainer.this.tanxc_do(view, customViewCallback);
            }
        });
        this.tanxc_if.setDownloadListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_char() {
        LandingPageUtHelper landingPageUtHelper;
        ProgressBar progressBar = this.tanxc_case;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (this.tanxc_char || (landingPageUtHelper = this.tanxc_long) == null) {
            return;
        }
        landingPageUtHelper.setLoadFinishTime(System.currentTimeMillis(), -1);
        this.tanxc_long.recordLandingFinish(this.tanxc_int, "2");
        this.tanxc_char = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_else() {
        LogUtils.d("AdSystemWebViewContainer", "showCustomView: mDefaultWebView = " + ((Object) this.tanxc_if) + ", mPlayerContainer = " + ((Object) this.tanxc_new));
        WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.setVisibility(0);
        }
        ViewGroup viewGroup = this.tanxc_new;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.tanxc_new.setVisibility(8);
        }
        IAdWebViewCallback iAdWebViewCallback = this.tanxc_goto;
        if (iAdWebViewCallback != null) {
            iAdWebViewCallback.onHideCustomView();
        }
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
        LogUtils.d("AdSystemWebViewContainer", "onDownloadStart: url = " + str + ", mimeType = " + str4 + ", contentLength = " + j10);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        this.tanxc_do.startActivity(intent);
    }

    public boolean tanxc_byte() {
        ViewGroup viewGroup = this.tanxc_new;
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            tanxc_else();
            return true;
        }
        WebView webView = this.tanxc_if;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        this.tanxc_if.goBack();
        return true;
    }

    public void tanxc_new() {
        WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.onResume();
        }
    }

    public void tanxc_try() {
        WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.setVisibility(8);
            this.tanxc_if.removeAllViews();
            this.tanxc_if = null;
        }
    }

    public TanxBrowserContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void tanxc_for() {
        WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.reload();
        }
    }

    public String tanxc_if() {
        WebView webView = this.tanxc_if;
        return webView != null ? webView.getUrl() : "";
    }

    public void tanxc_int() {
        WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.onPause();
        }
    }

    public TanxBrowserContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.tanxc_byte = false;
        this.tanxc_char = false;
        this.tanxc_else = false;
        try {
            this.tanxc_do = context;
            LogUtils.d("AdSystemWebViewContainer", "AdClickWebViewContainer: mContext = " + ((Object) this.tanxc_do));
            tanxc_do(this.tanxc_do);
        } catch (Exception e2) {
            LogUtils.e("AdSystemWebViewContainer", e2);
        }
    }

    public boolean tanxc_do(String str, LandingPageUtHelper landingPageUtHelper) {
        if (!TextUtils.isEmpty(str) && this.tanxc_if != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.tanxc_try = currentTimeMillis;
            this.tanxc_long = landingPageUtHelper;
            landingPageUtHelper.setLoadUrlTime(currentTimeMillis);
            this.tanxc_for = str;
            LogUtils.d("AdSystemWebViewContainer", "loadUrl  mUrl == " + this.tanxc_for);
            this.tanxc_if.loadUrl(str);
            return true;
        }
        LogUtils.d("AdSystemWebViewContainer", "loadUrl: skip because url is empty.");
        return false;
    }

    public TanxBrowserContainer(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.tanxc_byte = false;
        this.tanxc_char = false;
        this.tanxc_else = false;
        try {
            this.tanxc_do = context;
            LogUtils.d("AdSystemWebViewContainer", "AdClickWebViewContainer: mContext = " + ((Object) this.tanxc_do));
            tanxc_do(this.tanxc_do);
        } catch (Exception e2) {
            LogUtils.e("AdSystemWebViewContainer", e2);
        }
    }

    public boolean tanxc_do() {
        return this.tanxc_byte;
    }

    public void tanxc_do(BidInfo bidInfo) {
        LogUtils.d("AdSystemWebViewContainer", "setBidInfo: bidInfo = " + ((Object) bidInfo));
        this.tanxc_int = bidInfo;
    }

    public void tanxc_do(ProgressBar progressBar) {
        this.tanxc_case = progressBar;
    }

    public void tanxc_do(IAdWebViewCallback iAdWebViewCallback) {
        this.tanxc_goto = iAdWebViewCallback;
    }

    private void tanxc_do(Context context) {
        try {
            WebView webView = new WebView(context);
            this.tanxc_if = webView;
            webView.setBackgroundColor(0);
            this.tanxc_byte = true;
            addView(this.tanxc_if, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout = new FrameLayout(context);
            this.tanxc_new = frameLayout;
            frameLayout.setVisibility(8);
            addView(this.tanxc_new, -1, -1);
            tanxc_case();
        } catch (Throwable th) {
            LogUtils.e("AdSystemWebViewContainer", "Create new Webview exception.", th);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "AdSystemWebViewContainer", "Create new Webview exception." + LogUtils.getStackTraceMessage(th), "");
            this.tanxc_if = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_do(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        LogUtils.d("AdSystemWebViewContainer", "showCustomView: view = " + ((Object) view) + ", callback = " + ((Object) customViewCallback) + ", mPlayerContainer = " + ((Object) this.tanxc_new));
        WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.setVisibility(8);
        }
        if (this.tanxc_new != null) {
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.tanxc_new.setVisibility(0);
            this.tanxc_new.addView(view);
        }
        IAdWebViewCallback iAdWebViewCallback = this.tanxc_goto;
        if (iAdWebViewCallback != null) {
            iAdWebViewCallback.onShowCustomView(view);
        }
    }
}
