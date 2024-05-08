package com.alibaba.security.realidentity.build;

/* compiled from: Range.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gh {

    /* renamed from: a, reason: collision with root package name */
    public static final long f3734a = -1;

    /* renamed from: b, reason: collision with root package name */
    private long f3735b;

    /* renamed from: c, reason: collision with root package name */
    private long f3736c;

    private gh(long j10, long j11) {
        this.f3735b = j10;
        this.f3736c = j11;
    }

    private long a() {
        return this.f3736c;
    }

    private long b() {
        return this.f3735b;
    }

    private boolean c() {
        long j10 = this.f3735b;
        if (j10 >= -1) {
            long j11 = this.f3736c;
            if (j11 >= -1) {
                return j10 < 0 || j11 < 0 || j10 <= j11;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("bytes=");
        long j10 = this.f3735b;
        sb2.append(j10 == -1 ? "" : String.valueOf(j10));
        sb2.append("-");
        long j11 = this.f3736c;
        sb2.append(j11 != -1 ? String.valueOf(j11) : "");
        return sb2.toString();
    }

    private void a(long j10) {
        this.f3736c = j10;
    }

    private void b(long j10) {
        this.f3735b = j10;
    }
}
