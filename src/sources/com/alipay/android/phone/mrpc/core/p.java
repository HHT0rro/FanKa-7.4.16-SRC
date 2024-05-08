package com.alipay.android.phone.mrpc.core;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class p extends u {

    /* renamed from: c, reason: collision with root package name */
    private int f4259c;

    /* renamed from: d, reason: collision with root package name */
    private String f4260d;

    /* renamed from: e, reason: collision with root package name */
    private long f4261e;

    /* renamed from: f, reason: collision with root package name */
    private long f4262f;

    /* renamed from: g, reason: collision with root package name */
    private String f4263g;

    /* renamed from: h, reason: collision with root package name */
    private HttpUrlHeader f4264h;

    public p(HttpUrlHeader httpUrlHeader, int i10, String str, byte[] bArr) {
        this.f4264h = httpUrlHeader;
        this.f4259c = i10;
        this.f4260d = str;
        this.f4285a = bArr;
    }

    public final HttpUrlHeader a() {
        return this.f4264h;
    }

    public final void a(long j10) {
        this.f4261e = j10;
    }

    public final void a(String str) {
        this.f4263g = str;
    }

    public final void b(long j10) {
        this.f4262f = j10;
    }
}
