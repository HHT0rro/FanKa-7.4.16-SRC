package com.tencent.liteav.base.http;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final HttpClientAndroid f42827a;

    /* renamed from: b, reason: collision with root package name */
    private final Long f42828b;

    private c(HttpClientAndroid httpClientAndroid, Long l10) {
        this.f42827a = httpClientAndroid;
        this.f42828b = l10;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, Long l10) {
        return new c(httpClientAndroid, l10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$resumeRepeatDownload$2(this.f42827a, this.f42828b);
    }
}
