package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class bv implements ch.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bu f9968a;

    public bv(bu buVar) {
        this.f9968a = buVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ch.a
    public void a(bw bwVar) {
        this.f9968a.a(by.f9988k, bwVar, "download apk successfully, downloader exit");
        bu unused = bu.f9958h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.ch.a
    public void b(bw bwVar) {
        this.f9968a.a(by.f9989l, bwVar, "downloadApk failed");
    }
}
