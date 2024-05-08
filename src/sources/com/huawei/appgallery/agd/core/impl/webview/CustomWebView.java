package com.huawei.appgallery.agd.core.impl.webview;

import ab.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ScrollView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CustomWebView extends WebView {

    /* renamed from: b, reason: collision with root package name */
    public static final String f27457b = CustomWebView.class.getSimpleName();

    public CustomWebView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ViewParent a(View view) {
        ViewParent parent = view.getParent();
        if (parent == 0) {
            return null;
        }
        return (!(parent instanceof ScrollView) && (parent instanceof View)) ? a((View) parent) : parent;
    }

    public final void b() {
        a.f(this);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        requestFocus();
        settings.setDisplayZoomControls(false);
    }

    public void c(Object obj, String str) {
        addJavascriptInterface(obj, str);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        n9.a.f52175d.d(f27457b, "onOverScrolled scrollX=" + i10 + ", scrollY=" + i11 + ", clampedX" + z10 + ", clampedY=" + z11);
        if (z11 && a(this) != null) {
            requestDisallowInterceptTouchEvent(false);
        }
        super.onOverScrolled(i10, i11, z10, z11);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        n9.a.f52175d.d(f27457b, "onTouchEvent event: " + motionEvent.getAction());
        if (motionEvent.getAction() == 0 && a(this) != null) {
            requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }
}
