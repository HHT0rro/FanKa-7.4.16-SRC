package com.mobile.auth.gatewayauth.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobile.auth.gatewayauth.AuthUIConfig;
import com.mobile.auth.gatewayauth.Constant;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.d;
import com.mobile.auth.gatewayauth.utils.k;
import com.mobile.auth.gatewayauth.utils.l;
import com.mobile.auth.q.a;
import com.nirvana.tools.core.AppUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AuthWebVeiwActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private WebView f37048a;

    /* renamed from: b, reason: collision with root package name */
    private String f37049b;

    /* renamed from: c, reason: collision with root package name */
    private String f37050c;

    /* renamed from: d, reason: collision with root package name */
    private ProgressBar f37051d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f37052e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f37053f;

    /* renamed from: g, reason: collision with root package name */
    private AuthUIConfig f37054g;

    /* renamed from: h, reason: collision with root package name */
    private ImageButton f37055h;

    private int a(Context context) {
        try {
            return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1;
        }
    }

    public static /* synthetic */ ProgressBar a(AuthWebVeiwActivity authWebVeiwActivity) {
        try {
            return authWebVeiwActivity.f37051d;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ TextView b(AuthWebVeiwActivity authWebVeiwActivity) {
        try {
            return authWebVeiwActivity.f37052e;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ String c(AuthWebVeiwActivity authWebVeiwActivity) {
        try {
            return authWebVeiwActivity.f37050c;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public static /* synthetic */ AuthUIConfig d(AuthWebVeiwActivity authWebVeiwActivity) {
        try {
            return authWebVeiwActivity.f37054g;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        AuthUIConfig q10;
        AuthUIConfig authUIConfig;
        TextView textView;
        int navTextSize;
        try {
            this.f37049b = getIntent().getStringExtra("url");
            this.f37050c = getIntent().getStringExtra("name");
            int intExtra = getIntent().getIntExtra(Constant.LOGIN_ACTIVITY_UI_MANAGER_ID, 0);
            setRequestedOrientation(getIntent().getIntExtra("orientation", 1));
            super.onCreate(bundle);
            d a10 = d.a(intExtra);
            if (a10 == null) {
                a.a(getApplicationContext()).e("UIManager is null!|ID:", String.valueOf(intExtra));
                q10 = d.f37066a;
            } else {
                q10 = a10.q();
            }
            this.f37054g = q10;
            if (a10.f() && Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
            setContentView(AppUtils.getResID(this, "authsdk_dialog_layout", "layout"));
            int webViewStatusBarColor = this.f37054g.getWebViewStatusBarColor();
            if (AuthUIConfig.DEFAULT_WEB_STATUS_BAR_COLOR == webViewStatusBarColor) {
                webViewStatusBarColor = this.f37054g.getWebNavColor();
            }
            d.a(this.f37054g, webViewStatusBarColor, this);
            this.f37052e = (TextView) findViewById(AppUtils.getResID(this, "authsdk_title_tv", "id"));
            this.f37053f = (RelativeLayout) findViewById(AppUtils.getResID(this, "authsdk_title_rl", "id"));
            if (l.a(this.f37054g.getBottomNavBarColor())) {
                this.f37053f.setY(a((Context) this));
            }
            this.f37055h = (ImageButton) findViewById(AppUtils.getResID(this, "authsdk_back_btn", "id"));
            this.f37053f.setBackgroundColor(this.f37054g.getWebNavColor());
            this.f37052e.setTextColor(this.f37054g.getWebNavTextColor());
            if (this.f37054g.getWebNavTextSize() != -1) {
                authUIConfig = this.f37054g;
                textView = this.f37052e;
                navTextSize = authUIConfig.getWebNavTextSize();
            } else {
                authUIConfig = this.f37054g;
                textView = this.f37052e;
                navTextSize = authUIConfig.getNavTextSize();
            }
            authUIConfig.setTextSize(textView, navTextSize);
            this.f37055h.setBackgroundColor(0);
            this.f37055h.setScaleType(this.f37054g.getNavReturnScaleType());
            this.f37055h.setPadding(0, 0, 0, 0);
            Drawable webNavReturnImgDrawable = this.f37054g.getWebNavReturnImgDrawable();
            if (webNavReturnImgDrawable == null) {
                webNavReturnImgDrawable = k.c(this, this.f37054g.getWebNavReturnImgPath());
            }
            if (webNavReturnImgDrawable == null) {
                webNavReturnImgDrawable = this.f37054g.getNavReturnImgDrawable();
            }
            if (webNavReturnImgDrawable == null) {
                webNavReturnImgDrawable = k.a(this, this.f37054g.getNavReturnImgPath(), "authsdk_return_bg");
            }
            this.f37055h.setImageDrawable(webNavReturnImgDrawable);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37055h.getLayoutParams();
            layoutParams.width = AppUtils.dp2px(this, this.f37054g.getNavReturnImgWidth());
            layoutParams.height = AppUtils.dp2px(this, this.f37054g.getNavReturnImgHeight());
            this.f37055h.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.auth.gatewayauth.activity.AuthWebVeiwActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        AuthWebVeiwActivity.this.finish();
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
            if (a10.b()) {
                getWindow().getDecorView().setSystemUiVisibility(3074);
                if (!this.f37054g.isStatusBarHidden()) {
                    this.f37053f.setY(a((Context) this));
                }
            }
            this.f37051d = (ProgressBar) findViewById(AppUtils.getResID(this, "authsdk_progressBar", "id"));
            if (this.f37054g.isWebHiddeProgress()) {
                this.f37051d.setVisibility(8);
            } else {
                this.f37051d.setVisibility(0);
            }
            this.f37048a = (WebView) findViewById(AppUtils.getResID(this, "authsdk_webview", "id"));
            if (l.a(this.f37054g.getBottomNavBarColor())) {
                this.f37048a.setY(this.f37053f.getHeight() + this.f37053f.getY());
            }
            if (a10.b() && !this.f37054g.isStatusBarHidden()) {
                this.f37048a.setY(this.f37053f.getHeight() + a((Context) this));
            }
            this.f37048a.setWebChromeClient(new WebChromeClient() { // from class: com.mobile.auth.gatewayauth.activity.AuthWebVeiwActivity.2
                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i10) {
                    TextView b4;
                    String str;
                    try {
                        if (i10 != 100) {
                            if (AuthWebVeiwActivity.d(AuthWebVeiwActivity.this).isWebHiddeProgress()) {
                                AuthWebVeiwActivity.a(AuthWebVeiwActivity.this).setVisibility(8);
                                return;
                            } else {
                                AuthWebVeiwActivity.a(AuthWebVeiwActivity.this).setVisibility(0);
                                AuthWebVeiwActivity.a(AuthWebVeiwActivity.this).setProgress(i10);
                                return;
                            }
                        }
                        AuthWebVeiwActivity.a(AuthWebVeiwActivity.this).setVisibility(8);
                        String title = webView.getTitle();
                        if (!TextUtils.isEmpty(title)) {
                            AuthWebVeiwActivity.b(AuthWebVeiwActivity.this).setText(title);
                            return;
                        }
                        if (TextUtils.isEmpty(AuthWebVeiwActivity.c(AuthWebVeiwActivity.this))) {
                            b4 = AuthWebVeiwActivity.b(AuthWebVeiwActivity.this);
                            str = "服务协议";
                        } else {
                            b4 = AuthWebVeiwActivity.b(AuthWebVeiwActivity.this);
                            str = AuthWebVeiwActivity.c(AuthWebVeiwActivity.this);
                        }
                        b4.setText(str);
                    } catch (Throwable th) {
                        ExceptionProcessor.processException(th);
                    }
                }
            });
            this.f37048a.setWebViewClient(new WebViewClient() { // from class: com.mobile.auth.gatewayauth.activity.AuthWebVeiwActivity.3
                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    return false;
                }
            });
            this.f37048a.setVerticalScrollBarEnabled(false);
            this.f37048a.setHorizontalScrollBarEnabled(false);
            WebSettings settings = this.f37048a.getSettings();
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setDomStorageEnabled(true);
            settings.setSavePassword(false);
            settings.setAllowFileAccess(false);
            settings.setJavaScriptEnabled(this.f37054g.isWebSupportedJavascript());
            this.f37048a.setVerticalScrollbarOverlay(false);
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setSupportZoom(true);
            settings.setCacheMode(this.f37054g.getWebCacheMode());
            this.f37048a.loadUrl(this.f37049b);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            WebView webView = this.f37048a;
            if (webView != null) {
                webView.removeAllViews();
                this.f37048a.destroy();
                this.f37048a = null;
            }
            super.onDestroy();
            this.f37054g = null;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }
}
