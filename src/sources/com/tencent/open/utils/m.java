package com.tencent.open.utils;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private long f45330a;

    public m(long j10) {
        this.f45330a = j10;
    }

    public byte[] a() {
        long j10 = this.f45330a;
        return new byte[]{(byte) (255 & j10), (byte) ((65280 & j10) >> 8), (byte) ((16711680 & j10) >> 16), (byte) ((j10 & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f45330a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof m) && this.f45330a == ((m) obj).b();
    }

    public int hashCode() {
        return (int) this.f45330a;
    }
}
