package com.tencent.liteav.base.http;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final HttpClientAndroid f42829a;

    /* renamed from: b, reason: collision with root package name */
    private final long f42830b;

    private d(HttpClientAndroid httpClientAndroid, long j10) {
        this.f42829a = httpClientAndroid;
        this.f42830b = j10;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, long j10) {
        return new d(httpClientAndroid, j10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$resumeRepeatDownload$3(this.f42829a, this.f42830b);
    }
}
