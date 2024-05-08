package com.alipay.sdk.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.util.n;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private Activity f4394a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4395b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f4396c;

    /* renamed from: d, reason: collision with root package name */
    private com.alipay.sdk.widget.a f4397d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4398e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<b> f4399a;

        public a(b bVar) {
            this.f4399a = new WeakReference<>(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.f4399a.get();
            if (bVar != null) {
                bVar.d();
            }
        }
    }

    public b(@NonNull Activity activity) {
        this.f4394a = activity;
        this.f4396c = new Handler(this.f4394a.getMainLooper());
    }

    private void c() {
        Activity activity = this.f4394a;
        if (activity == null) {
            return;
        }
        if (this.f4397d == null) {
            com.alipay.sdk.widget.a aVar = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f4775a);
            this.f4397d = aVar;
            aVar.a(true);
        }
        this.f4397d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.alipay.sdk.widget.a aVar = this.f4397d;
        if (aVar != null) {
            aVar.c();
        }
        this.f4397d = null;
    }

    public boolean b() {
        return this.f4398e;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Activity activity = this.f4394a;
        if (this.f4396c == null || activity == null || activity.isFinishing()) {
            return;
        }
        d();
        this.f4396c.removeCallbacksAndMessages(null);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Activity activity = this.f4394a;
        if (this.f4396c != null && activity != null && !activity.isFinishing()) {
            c();
            this.f4396c.postDelayed(new a(this), 30000L);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        this.f4398e = true;
        super.onReceivedError(webView, i10, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.f4394a;
        if (activity == null) {
            return;
        }
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.f4448r, "证书错误");
        if (this.f4395b) {
            sslErrorHandler.proceed();
            this.f4395b = false;
        } else {
            activity.runOnUiThread(new c(this, activity, sslErrorHandler));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return n.a(webView, str, this.f4394a);
    }

    public void a() {
        this.f4396c = null;
        this.f4394a = null;
    }
}
