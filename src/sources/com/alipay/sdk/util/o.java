package com.alipay.sdk.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class o implements DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f4762a;

    public o(Context context) {
        this.f4762a = context;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            this.f4762a.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}
