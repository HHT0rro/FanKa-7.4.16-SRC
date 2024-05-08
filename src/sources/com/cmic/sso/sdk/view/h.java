package com.cmic.sso.sdk.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class h extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private WebView f11568a;

    /* renamed from: b, reason: collision with root package name */
    private String f11569b;

    /* renamed from: c, reason: collision with root package name */
    private String f11570c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f11571d;

    public h(Context context, int i10, String str, String str2) {
        super(context, i10);
        try {
            this.f11570c = str;
            this.f11569b = str2;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private ViewGroup c() {
        View findViewById;
        try {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f11571d = linearLayout;
            linearLayout.setOrientation(1);
            this.f11571d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            a a10 = com.mobile.auth.g.a.a(getContext()).a();
            int e2 = a10.e();
            String str = TextUtils.isEmpty(this.f11570c) ? com.cmic.sso.sdk.c.f11425d[a10.ap()] : this.f11570c;
            if (e2 != -1) {
                RelativeLayout a11 = i.a(getContext(), getLayoutInflater().inflate(e2, (ViewGroup) this.f11571d, false), 1118481, 0, str, (View.OnClickListener) null);
                String f10 = a10.f();
                if (!TextUtils.isEmpty(f10) && (findViewById = a11.findViewById(g.a(getContext(), f10))) != null) {
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.cmic.sso.sdk.view.h.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            h.this.f11568a.stopLoading();
                            h.this.b();
                        }
                    });
                }
                this.f11571d.addView(a11);
            } else {
                this.f11571d.addView(i.a(getContext(), (View) null, 1118481, 2236962, str, new View.OnClickListener() { // from class: com.cmic.sso.sdk.view.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        h.this.f11568a.stopLoading();
                        h.this.b();
                    }
                }));
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return this.f11571d;
    }

    private void d() {
        WebView webView = new WebView(getContext());
        this.f11568a = webView;
        WebSettings settings = webView.getSettings();
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setSavePassword(false);
        settings.setJavaScriptEnabled(true);
        this.f11571d.addView(this.f11568a, new LinearLayout.LayoutParams(-1, -1));
        this.f11568a.setWebViewClient(new WebViewClient() { // from class: com.cmic.sso.sdk.view.h.3
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                h.this.f11568a.loadUrl(str);
                return true;
            }
        });
        this.f11568a.loadUrl(this.f11569b);
    }

    public void a() {
        View decorView;
        requestWindowFeature(1);
        int i10 = 0;
        getWindow().setFeatureDrawableAlpha(0, 0);
        a a10 = com.mobile.auth.g.a.a(getContext()).a();
        int i11 = Build.VERSION.SDK_INT;
        if (a10.a() != 0) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().clearFlags(67108864);
            getWindow().setStatusBarColor(a10.a());
            getWindow().setNavigationBarColor(a10.a());
        }
        if (i11 >= 23) {
            if (a10.b()) {
                decorView = getWindow().getDecorView();
                i10 = 8192;
            } else {
                decorView = getWindow().getDecorView();
            }
            decorView.setSystemUiVisibility(i10);
        }
        setContentView(c());
    }

    public void b() {
        if (this.f11568a.canGoBack()) {
            this.f11568a.goBack();
        } else {
            dismiss();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        WebView webView = this.f11568a;
        if (webView != null) {
            webView.stopLoading();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.f11571d == null) {
            a();
        }
        if (this.f11568a == null) {
            d();
        }
        super.show();
    }
}
