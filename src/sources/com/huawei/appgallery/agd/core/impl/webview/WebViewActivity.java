package com.huawei.appgallery.agd.core.impl.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.huawei.appgallery.agd.common.FlavorApi;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.core.R$color;
import com.huawei.appgallery.agd.core.R$drawable;
import com.huawei.appgallery.agd.core.R$id;
import com.huawei.appgallery.agd.core.R$layout;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.MaintData;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.huawei.appgallery.agd.core.impl.webview.WebViewActivity;
import com.huawei.appgallery.agd.core.internalapi.IntentKey;
import com.huawei.appgallery.agd.core.internalapi.WebJsObject;
import com.huawei.secure.android.common.intent.SafeIntent;
import m9.j;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class WebViewActivity extends FragmentActivity implements View.OnClickListener {
    public String adid;

    /* renamed from: c, reason: collision with root package name */
    public ScrollView f27459c;
    public Context context;
    public ImageView imgBack;
    public String mInstallType;
    public String mPackageName;
    public String mUniqueId;
    public String mUrl;
    public CustomWebView mWebview;
    public ProgressBar progressBar;

    /* renamed from: b, reason: collision with root package name */
    public boolean f27458b = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f27460d = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            WebViewActivity webViewActivity = WebViewActivity.this;
            if (webViewActivity.progressBar != null) {
                webViewActivity.m0(i10);
            } else {
                n9.a.f52175d.i("WebViewActivity", "processBar is null");
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c extends WebViewClient {
        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            WebViewActivity.this.f27459c.fullScroll(33);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            n9.a.f52175d.i("WebViewActivity", "bindView # onPageFinished");
            if (!WebViewActivity.this.f27458b && !WebViewActivity.this.f27460d) {
                webView.reload();
                WebViewActivity.this.f27458b = true;
            }
            WebViewActivity.this.f27459c.post(new Runnable() { // from class: t9.a
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewActivity.c.this.b();
                }
            });
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            n9.a.f52175d.i("WebViewActivity", "bindView # onPageStarted");
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            n9.a.f52175d.w("WebViewActivity", "bindView # onReceivedError");
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            n9.a.f52175d.w("WebViewActivity", "bindView # onReceivedHttpError");
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            n9.a.f52175d.w("WebViewActivity", "bindView # onReceivedSslError errorCode : " + sslError.getPrimaryError());
            if (FlavorApi.getConfig().shouldCancelWhenWebSslError()) {
                sslErrorHandler.cancel();
            } else {
                sslErrorHandler.proceed();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!j.d(str)) {
                j.b(WebViewActivity.this, str);
                MaintBi.report(new MaintData.Builder(MaintKey.EVENT_WAP_PAGE_START_ERROR).setUniqueId(WebViewActivity.this.mUniqueId).setInstallType(WebViewActivity.this.mInstallType).setAdId(WebViewActivity.this.adid).setTaskPackageName(WebViewActivity.this.mPackageName).setReason("redirect: invalid url").setUri(str).build());
                return true;
            }
            WebViewActivity.this.mWebview.loadUrl(str);
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    private void a() {
        if (getIntent().getExtras() != null) {
            this.mWebview.c(getJsObject(), getJsObjectName());
            return;
        }
        String str = this.mUrl;
        if (str == null) {
            str = "null url";
        }
        MaintBi.reportNativeAdWapError("agdAd is null ", str);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(int i10) {
        if (i10 == 100) {
            this.progressBar.setVisibility(8);
        } else {
            this.progressBar.setVisibility(0);
            this.progressBar.setProgress(i10);
        }
    }

    private void z0() {
        SafeIntent intent = getIntent();
        this.mInstallType = intent.getStringExtra(IntentKey.INTENT_KEY_INSTALL_TYPE);
        this.mUniqueId = intent.getStringExtra(IntentKey.INTENT_KEY_AD_UNIQUE_ID);
        this.mPackageName = intent.getExtras().getString(IntentKey.INTENT_KEY_PACKAGE_NAME);
        this.adid = intent.getExtras().getString(IntentKey.INTENT_KEY_AD_ID);
    }

    public void bindView(View view) {
        ImageView imageView = (ImageView) findViewById(R$id.imv_back);
        this.imgBack = imageView;
        imageView.setOnClickListener(this);
        this.f27459c = (ScrollView) findViewById(R$id.activity_area_scrollview);
        this.mWebview = (CustomWebView) findViewById(R$id.activity_area_webview);
        ProgressBar progressBar = (ProgressBar) findViewById(R$id.area_webview_progress_bar);
        this.progressBar = progressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
        a();
        this.mWebview.setWebChromeClient(new b());
        this.mWebview.setWebViewClient(new c());
        this.mWebview.loadUrl(this.mUrl);
    }

    public void checkDarkTheme() {
        boolean isDarkTheme = isDarkTheme();
        n9.a.f52175d.i("WebViewActivity", "WebPageActivity#checkDarkTheme isDarkTheme=" + isDarkTheme);
        if (isDarkTheme) {
            this.imgBack.setImageResource(R$drawable.ic_appbar_back_white);
        } else {
            this.imgBack.setImageResource(R$drawable.ic_appbar_back_black);
        }
    }

    public Context getContext() {
        Context context = this.context;
        return context == null ? ApplicationWrapper.getInstance().getContext() : context;
    }

    public Object getJsObject() {
        return new WebJsObject(this, this.mUrl, this.mWebview);
    }

    public String getJsObjectName() {
        return "HiSpaceObject";
    }

    public boolean isDarkTheme() {
        return getResources().getColor(R$color.agd_dark_theme_color) == -16777216;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void onClick(View view) {
        if (view.getId() == R$id.imv_back) {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        checkDarkTheme();
        if (isDarkTheme()) {
            getWindow().setBackgroundDrawableResource(R$color.agd_black);
        } else {
            getWindow().setBackgroundDrawableResource(R$color.agd_white);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (ApplicationWrapper.getInstance() != null && ApplicationWrapper.getInstance().getContext() != null) {
            z0();
            if (bundle != null) {
                this.mUrl = bundle.getString(IntentKey.INTENT_KEY_WEB_URL);
            } else {
                SafeIntent intent = getIntent();
                if (intent.getExtras() != null) {
                    this.mUrl = intent.getExtras().getString(IntentKey.INTENT_KEY_WEB_URL);
                }
            }
            if (!TextUtils.isEmpty(this.mUrl) && (j.d(this.mUrl) || !FlavorApi.getConfig().shouldRestrictUrlScheme())) {
                if (!setWebViewContent()) {
                    n9.a.f52175d.e("WebViewActivity", "set contentView fail");
                    finish();
                } else {
                    n9.a.f52175d.i("WebViewActivity", "set contentView success");
                }
                checkDarkTheme();
                return;
            }
            n9.a.f52175d.e("WebViewActivity", "invalid url : " + this.mUrl);
            MaintBi.report(new MaintData.Builder(MaintKey.EVENT_WAP_PAGE_START_ERROR).setUniqueId(this.mUniqueId).setInstallType(this.mInstallType).setAdId(this.adid).setTaskPackageName(this.mPackageName).setReason("invalid url").setUri(this.mUrl).build());
            finish();
            return;
        }
        finish();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            finish();
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null) {
            this.mUrl = bundle.getString(IntentKey.INTENT_KEY_WEB_URL);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(IntentKey.INTENT_KEY_WEB_URL, this.mUrl);
    }

    public void setNativePPS(boolean z10) {
        this.f27460d = z10;
    }

    public boolean setWebViewContent() {
        try {
            View inflate = getLayoutInflater().inflate(R$layout.activity_web_view, (ViewGroup) null);
            setContentView(inflate);
            bindView(inflate);
            return true;
        } catch (InflateException e2) {
            n9.a.f52175d.e("WebViewActivity", "WebViewActivity#setWebViewContent appends InflateException!" + e2.getMessage());
            return false;
        }
    }

    @Override // android.app.Activity
    public SafeIntent getIntent() {
        return new SafeIntent(super.getIntent());
    }
}
