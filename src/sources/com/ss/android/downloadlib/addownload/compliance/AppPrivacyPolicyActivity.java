package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.hc.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AppPrivacyPolicyActivity extends Activity {
    private WebView dk;
    private long ej;

    /* renamed from: l, reason: collision with root package name */
    private long f38501l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f38502m;
    private String np;

    private void dk() {
        this.f38502m = (ImageView) findViewById(R.id.iv_privacy_back);
        this.dk = (WebView) findViewById(R.id.privacy_webview);
        this.f38502m.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hc.m("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.f38501l);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.dk.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.dk.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            private boolean m(Uri uri) {
                String scheme = uri.getScheme();
                return ("http".equals(scheme) || "https".equals(scheme)) ? false : true;
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                if (!renderProcessGoneDetail.didCrash()) {
                    c.m("System killed the WebView rendering process to reclaim memory. Recreating...");
                    if (webView != null) {
                        ((ViewGroup) webView.getParent()).removeView(webView);
                        webView.destroy();
                    }
                    return true;
                }
                c.m("The WebView rendering process crashed!");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return m(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return m(Uri.parse(str));
            }
        });
        m(this.dk);
        this.dk.setScrollBarStyle(0);
        this.dk.loadUrl(this.np);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        hc.m("lp_app_privacy_click_close", this.f38501l);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_privacy_policy);
        if (m()) {
            dk();
        } else {
            com.ss.android.socialbase.appdownloader.ej.m((Activity) this);
        }
    }

    public static void m(Activity activity, long j10) {
        Intent intent = new Intent(activity, (Class<?>) AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j10);
        activity.startActivity(intent);
    }

    private boolean m() {
        this.ej = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.dk.dk m10 = ej.m().m(this.ej);
        if (m10 == null) {
            return false;
        }
        this.f38501l = m10.dk;
        String str = m10.f38563w;
        this.np = str;
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        this.np = com.ss.android.downloadlib.addownload.c.w().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        return true;
    }

    private void m(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }
}
