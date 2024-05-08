package com.tencent.cloud.huiyansdkface.facelight.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.c.b.e;
import com.tencent.cloud.huiyansdkface.facelight.c.f;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.c;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.net.URLEncoder;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FaceProtocalActivity extends com.tencent.cloud.huiyansdkface.facelight.ui.a.a {

    /* renamed from: a, reason: collision with root package name */
    private static int f40939a;

    /* renamed from: b, reason: collision with root package name */
    private d f40940b;

    /* renamed from: c, reason: collision with root package name */
    private e f40941c = new e(AutofillManager.MAX_TEMP_AUGMENTED_SERVICE_DURATION_MS);

    /* renamed from: d, reason: collision with root package name */
    private c f40942d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f40943e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f40944f;

    /* renamed from: g, reason: collision with root package name */
    private WebView f40945g;

    /* renamed from: h, reason: collision with root package name */
    private String f40946h;

    /* renamed from: i, reason: collision with root package name */
    private String f40947i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f40948j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f40949k;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements c.b {

        /* renamed from: a, reason: collision with root package name */
        private d f40957a;

        /* renamed from: b, reason: collision with root package name */
        private Activity f40958b;

        public a(d dVar, Activity activity) {
            this.f40957a = dVar;
            this.f40958b = activity;
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.c.b
        public void a() {
            WLogger.d("FaceProtocalActivity", "onHomePressed");
            KycWaSDK.getInstance().trackCustomKVEvent(this.f40958b, "authpage_detailpage_exit_self", "点击home键返回", null);
            this.f40957a.e(true);
            if (this.f40957a.y() != null) {
                WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
                wbFaceVerifyResult.setIsSuccess(false);
                wbFaceVerifyResult.setOrderNo(this.f40957a.w());
                wbFaceVerifyResult.setSign(null);
                WbFaceError wbFaceError = new WbFaceError();
                wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
                wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
                wbFaceError.setDesc("用户取消");
                wbFaceError.setReason("home键：用户授权详情中取消");
                wbFaceVerifyResult.setError(wbFaceError);
                Properties properties = new Properties();
                properties.setProperty("errorDesc", wbFaceError.toString());
                this.f40957a.a(this.f40958b, WbFaceError.WBFaceErrorCodeUserCancle, properties);
                this.f40957a.y().onFinish(wbFaceVerifyResult);
            }
            this.f40958b.finish();
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.c.b
        public void b() {
            WLogger.d("FaceProtocalActivity", "onHomeLongPressed");
        }
    }

    private void b() {
        int i10;
        WLogger.i("FaceProtocalActivity", "setThemeAndTitleBar");
        String J = this.f40940b.x().J();
        this.f40947i = J;
        if (WbCloudFaceContant.BLACK.equals(J)) {
            i10 = R.style.wbcfFaceProtocolThemeBlack;
        } else if ("custom".equals(this.f40947i)) {
            i10 = R.style.wbcfFaceProtocolThemeCustom;
        } else {
            WLogger.e("FaceProtocalActivity", "set default WHITE");
            this.f40947i = WbCloudFaceContant.WHITE;
            i10 = R.style.wbcfFaceProtocolThemeWhite;
        }
        setTheme(i10);
        a(this.f40947i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.f40945g.loadUrl(str);
    }

    private void c() {
        Drawable mutate;
        Resources resources;
        int i10;
        c cVar = new c(this);
        this.f40942d = cVar;
        cVar.a(new a(this.f40940b, this));
        String U = this.f40940b.x().U();
        WLogger.d("FaceProtocalActivity", "protocolCorpName=" + U);
        String replace = U.replace("$$$", "|");
        WLogger.d("FaceProtocalActivity", "after protocolCorpName=" + replace);
        String[] split = replace.split("\\|");
        String str = "";
        String str2 = null;
        for (int i11 = 0; i11 < split.length; i11++) {
            WLogger.d("FaceProtocalActivity", "tmp[" + i11 + "]=" + split[i11]);
            if (i11 == 0) {
                str2 = split[0];
            } else if (i11 == 1) {
                str = split[1];
            }
        }
        WLogger.d("FaceProtocalActivity", "corpName=" + str2 + ",channel=" + str);
        String appId = Param.getAppId();
        String V = this.f40940b.x().V();
        this.f40946h = com.tencent.cloud.huiyansdkface.facelight.c.c.a(this.f40940b.x().X(), this.f40940b.x().P(), false) + "/s/h5/protocolCDN.html?appId=" + appId + "&protocolNo=" + V + "&name=" + URLEncoder.encode(str2) + "&channel=" + str + "&lang=" + f.a(this.f40940b.x().H());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("url=");
        sb2.append(this.f40946h);
        WLogger.d("FaceProtocalActivity", sb2.toString());
        KycWaSDK.getInstance().trackCustomKVEvent(getApplicationContext(), "authpage_detailpage_enter", this.f40946h, null);
        this.f40944f = (ImageView) findViewById(R.id.wbcf_protocol_back);
        if (!this.f40947i.equals(WbCloudFaceContant.WHITE)) {
            if (this.f40947i.equals("custom")) {
                mutate = DrawableCompat.wrap(ContextCompat.getDrawable(this, R.mipmap.wbcf_back)).mutate();
                resources = getResources();
                i10 = R.color.wbcf_custom_auth_back_tint;
            }
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.wbcf_protocol_left_button);
            this.f40943e = linearLayout;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceProtocalActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (FaceProtocalActivity.this.f40945g.canGoBack()) {
                        WLogger.d("FaceProtocalActivity", "左上角返回键，回到上一页");
                        FaceProtocalActivity.this.f40945g.goBack();
                    } else {
                        WLogger.d("FaceProtocalActivity", "左上角返回键，无上一页，退出授权sdk");
                        KycWaSDK.getInstance().trackCustomKVEvent(FaceProtocalActivity.this.getApplicationContext(), "authpage_detailpage_exit_self", "左上角返回", null);
                        FaceProtocalActivity.this.d();
                        FaceProtocalActivity.this.finish();
                    }
                }
            });
            WebView webView = (WebView) findViewById(R.id.wbcf_protocol_webview);
            this.f40945g = webView;
            webView.setBackgroundColor(0);
            a();
        }
        mutate = DrawableCompat.wrap(ContextCompat.getDrawable(this, R.mipmap.wbcf_back)).mutate();
        resources = getResources();
        i10 = R.color.wbcf_guide_black_bg;
        DrawableCompat.setTint(mutate, resources.getColor(i10));
        this.f40944f.setImageDrawable(mutate);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.wbcf_protocol_left_button);
        this.f40943e = linearLayout2;
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceProtocalActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FaceProtocalActivity.this.f40945g.canGoBack()) {
                    WLogger.d("FaceProtocalActivity", "左上角返回键，回到上一页");
                    FaceProtocalActivity.this.f40945g.goBack();
                } else {
                    WLogger.d("FaceProtocalActivity", "左上角返回键，无上一页，退出授权sdk");
                    KycWaSDK.getInstance().trackCustomKVEvent(FaceProtocalActivity.this.getApplicationContext(), "authpage_detailpage_exit_self", "左上角返回", null);
                    FaceProtocalActivity.this.d();
                    FaceProtocalActivity.this.finish();
                }
            }
        });
        WebView webView2 = (WebView) findViewById(R.id.wbcf_protocol_webview);
        this.f40945g = webView2;
        webView2.setBackgroundColor(0);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        WLogger.d("FaceProtocalActivity", "backToGuideActivity");
        this.f40948j = true;
        Intent intent = new Intent();
        intent.putExtra("isChecked", this.f40949k);
        intent.setClass(this, FaceGuideActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void a() {
        int i10 = Build.VERSION.SDK_INT;
        this.f40945g.setImportantForAccessibility(4);
        this.f40945g.setWebViewClient(new WebViewClient() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceProtocalActivity.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                WLogger.d("FaceProtocalActivity", "onPageFinished:" + System.currentTimeMillis());
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                WLogger.d("FaceProtocalActivity", "onPageStarted:" + System.currentTimeMillis());
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
                WLogger.e("FaceProtocalActivity", "webview访问网址ssl证书无效！询问客户");
                AlertDialog.Builder builder = new AlertDialog.Builder(FaceProtocalActivity.this);
                builder.setMessage("当前页面证书不可信，是否继续访问?");
                builder.setPositiveButton("继续", new DialogInterface.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceProtocalActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        sslErrorHandler.proceed();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceProtocalActivity.2.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i11) {
                        sslErrorHandler.cancel();
                    }
                });
                builder.create().show();
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                WLogger.d("FaceProtocalActivity", str);
                if (!str.startsWith("https://")) {
                    return false;
                }
                FaceProtocalActivity.this.b(str);
                return true;
            }
        });
        WebSettings settings = this.f40945g.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(false);
        settings.setLoadWithOverviewMode(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setDatabasePath(getDir("databases", 0).getPath());
        settings.setGeolocationDatabasePath(getDir("geolocation", 0).getPath());
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (i10 < 33) {
            settings.setAppCacheEnabled(false);
            settings.setAppCacheMaxSize(0L);
            settings.setAppCachePath(getDir("appcache", 0).getPath());
        }
        settings.setAllowUniversalAccessFromFileURLs(false);
        this.f40945g.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f40945g.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceProtocalActivity.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        b(this.f40946h);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f40945g.canGoBack()) {
            WLogger.d("FaceProtocalActivity", "返回键，回到上一页");
            this.f40945g.goBack();
            return;
        }
        WLogger.d("FaceProtocalActivity", "返回键，无上一页可回，退出授权页面");
        super.onBackPressed();
        KycWaSDK.getInstance().trackCustomKVEvent(getApplicationContext(), "authpage_detailpage_exit_self", "返回键", null);
        d();
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        WLogger.d("FaceProtocalActivity", "onCreate：" + getRequestedOrientation());
        WLogger.d("FaceProtocalActivity", "setActivityOrientation:" + getWindowManager().getDefaultDisplay().getRotation());
        d z10 = d.z();
        this.f40940b = z10;
        z10.e(false);
        f40939a++;
        b();
        super.onCreate(bundle);
        setContentView(R.layout.wbcf_face_protocol_layout);
        if (getIntent() != null) {
            this.f40949k = getIntent().getBooleanExtra("isChecked", false);
        }
        c();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WLogger.i("FaceProtocalActivity", "onDestroy");
    }

    @Override // android.app.Activity
    public void onPause() {
        WLogger.d("FaceProtocalActivity", "onPause");
        super.onPause();
        c cVar = this.f40942d;
        if (cVar != null) {
            cVar.b();
        }
        this.f40941c.a();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        WLogger.d("FaceProtocalActivity", "onResume");
        c cVar = this.f40942d;
        if (cVar != null) {
            cVar.a();
        }
        this.f40941c.a(getApplicationContext());
    }

    @Override // android.app.Activity
    public void onStart() {
        WLogger.d("FaceProtocalActivity", "onStart");
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        WLogger.i("FaceProtocalActivity", "onStop");
        super.onStop();
        int i10 = f40939a - 1;
        f40939a = i10;
        if (i10 != 0) {
            WLogger.e("FaceProtocalActivity", "not same activity ");
            return;
        }
        if (this.f40948j) {
            WLogger.d("FaceProtocalActivity", "backToGuide,no return");
            return;
        }
        WLogger.d("FaceProtocalActivity", "same activity ");
        if (this.f40940b.t()) {
            return;
        }
        WLogger.i("FaceProtocalActivity", "onStop quit authDetailpage");
        KycWaSDK.getInstance().trackCustomKVEvent(getApplicationContext(), "authpage_detailpage_exit_forced", "onStop, 应用被动离开前台", null);
        if (this.f40940b.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.f40940b.w());
            wbFaceVerifyResult.setSign(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
            wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
            wbFaceError.setDesc("用户取消");
            wbFaceError.setReason("用户取消，授权详情中回到后台activity onStop");
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.f40940b.a(this, WbFaceError.WBFaceErrorCodeUserCancle, properties);
            this.f40940b.y().onFinish(wbFaceVerifyResult);
        }
        finish();
    }
}
