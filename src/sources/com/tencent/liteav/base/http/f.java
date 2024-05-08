package com.tencent.liteav.base.http;

import com.tencent.liteav.base.http.HttpClientAndroid;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final HttpClientAndroid f42832a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpClientAndroid.f f42833b;

    /* renamed from: c, reason: collision with root package name */
    private final long f42834c;

    private f(HttpClientAndroid httpClientAndroid, HttpClientAndroid.f fVar, long j10) {
        this.f42832a = httpClientAndroid;
        this.f42833b = fVar;
        this.f42834c = j10;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.f fVar, long j10) {
        return new f(httpClientAndroid, fVar, j10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$doReadData$5(this.f42832a, this.f42833b, this.f42834c);
    }
}
