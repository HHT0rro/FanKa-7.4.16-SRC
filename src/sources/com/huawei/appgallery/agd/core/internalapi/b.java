package com.huawei.appgallery.agd.core.internalapi;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.huawei.appgallery.agd.common.utils.ThreadUtil;
import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public WebView f27499a;

    /* renamed from: b, reason: collision with root package name */
    public String f27500b;

    public b(WebView webView) {
        this.f27499a = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(CountDownLatch countDownLatch) {
        c(this.f27499a.getUrl());
        countDownLatch.countDown();
    }

    public String b() {
        if (this.f27499a == null) {
            return "";
        }
        if (ThreadUtil.isMainThread()) {
            return this.f27499a.getUrl();
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.huawei.appgallery.agd.core.internalapi.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.d(countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            n9.a.f52175d.e("SafeGetWebViewUrl", "getUrlMethod: InterruptedException " + e2.getMessage(), e2);
        }
        return this.f27500b;
    }

    public final void c(String str) {
        this.f27500b = str;
    }
}
