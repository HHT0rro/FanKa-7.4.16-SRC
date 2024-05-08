package com.alipay.sdk.auth;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class a implements DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthActivity f4477a;

    public a(AuthActivity authActivity) {
        this.f4477a = authActivity;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
        try {
            this.f4477a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Throwable unused) {
        }
    }
}
