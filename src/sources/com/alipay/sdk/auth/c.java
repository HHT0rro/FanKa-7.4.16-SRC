package com.alipay.sdk.auth;

import android.webkit.WebView;
import com.alibaba.security.realidentity.build.bh;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4479a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AuthActivity f4480b;

    public c(AuthActivity authActivity, String str) {
        this.f4480b = authActivity;
        this.f4479a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebView webView;
        try {
            webView = this.f4480b.f4468c;
            webView.loadUrl(bh.f3176j + this.f4479a);
        } catch (Exception unused) {
        }
    }
}
