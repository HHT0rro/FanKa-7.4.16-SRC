package com.huawei.hms.ads.jsbridge;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.ads.jsb.IWebView;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private volatile String f29346a;

    /* renamed from: com.huawei.hms.ads.jsbridge.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class CallableC0305a implements Callable<String> {

        /* renamed from: a, reason: collision with root package name */
        private IWebView f29347a;

        /* renamed from: b, reason: collision with root package name */
        private WebView f29348b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f29349c;

        public CallableC0305a(WebView webView) {
            this.f29348b = webView;
        }

        public CallableC0305a(IWebView iWebView) {
            this.f29349c = true;
            this.f29347a = iWebView;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            if (this.f29349c) {
                IWebView iWebView = this.f29347a;
                if (iWebView != null) {
                    return iWebView.getUrl();
                }
                return null;
            }
            WebView webView = this.f29348b;
            if (webView != null) {
                return webView.getUrl();
            }
            return null;
        }
    }

    private static Future<String> a(FutureTask futureTask) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            futureTask.run();
        } else {
            new Handler(Looper.getMainLooper()).post(futureTask);
        }
        return futureTask;
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    @Nullable
    private static String b(@NonNull WebView webView) {
        try {
            return a(new FutureTask(new CallableC0305a(webView))).get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            b.b("Exception will waiting: " + e2.getMessage());
            b.b("exception or timeout while waiting for url");
            return null;
        }
    }

    @Nullable
    private static String b(@NonNull IWebView iWebView) {
        try {
            return a(new FutureTask(new CallableC0305a(iWebView))).get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            b.b("Exception will waiting: " + e2.getMessage());
            b.b("exception or timeout while waiting for url");
            return null;
        }
    }

    @Nullable
    public String a(@Nullable WebView webView) {
        if (webView == null) {
            return null;
        }
        String str = this.f29346a;
        if (str != null) {
            return str;
        }
        b.a("securityExtSetFrameUrl is null ,get url from native");
        return b(webView);
    }

    @Nullable
    public String a(@Nullable IWebView iWebView) {
        if (iWebView == null) {
            return null;
        }
        String str = this.f29346a;
        return str != null ? str : b(iWebView);
    }
}
