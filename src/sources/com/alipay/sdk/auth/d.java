package com.alipay.sdk.auth;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.auth.AuthActivity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SslErrorHandler f4481a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AuthActivity.c f4482b;

    public d(AuthActivity.c cVar, SslErrorHandler sslErrorHandler) {
        this.f4482b = cVar;
        this.f4481a = sslErrorHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alipay.sdk.widget.e.a(AuthActivity.this, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new e(this), "退出", new f(this));
    }
}
