package com.alipay.sdk.app;

import android.app.Activity;
import android.webkit.SslErrorHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f4400a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SslErrorHandler f4401b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f4402c;

    public c(b bVar, Activity activity, SslErrorHandler sslErrorHandler) {
        this.f4402c = bVar;
        this.f4400a = activity;
        this.f4401b = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alipay.sdk.widget.e.a(this.f4400a, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，可能存在风险，请选择是否继续？", "继续", new d(this), "退出", new e(this));
    }
}
