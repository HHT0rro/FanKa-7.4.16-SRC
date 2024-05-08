package com.tencent.liteav.base.http;

import com.tencent.liteav.base.http.HttpClientAndroid;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final HttpClientAndroid f42824a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpClientAndroid.e f42825b;

    private a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.e eVar) {
        this.f42824a = httpClientAndroid;
        this.f42825b = eVar;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.e eVar) {
        return new a(httpClientAndroid, eVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f42824a.doRequest(this.f42825b);
    }
}
