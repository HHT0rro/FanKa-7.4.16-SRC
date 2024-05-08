package com.alipay.sdk.widget;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class i implements DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f4795a;

    public i(h hVar) {
        this.f4795a = hVar;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            this.f4795a.f4792a.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}
