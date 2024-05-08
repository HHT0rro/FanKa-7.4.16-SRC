package com.tencent.liteav.base.http;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final HttpClientAndroid f42831a;

    private e(HttpClientAndroid httpClientAndroid) {
        this.f42831a = httpClientAndroid;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid) {
        return new e(httpClientAndroid);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$destroy$4(this.f42831a);
    }
}
