package com.alipay.sdk.widget;

import android.webkit.SslErrorHandler;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SslErrorHandler f4827a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f4828b;

    public n(j jVar, SslErrorHandler sslErrorHandler) {
        this.f4828b = jVar;
        this.f4827a = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        e.a(this.f4828b.f4792a, "安全警告", "安全連接證書校驗無效，將無法保證訪問資料的安全性，可能存在風險，請選擇是否繼續？", "繼續", new o(this), "退出", new p(this));
    }
}
