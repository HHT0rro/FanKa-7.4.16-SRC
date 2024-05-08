package com.tencent.open.utils;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int f45331a;

    public n(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i10 = this.f45331a;
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 & 65280) >> 8)};
    }

    public int b() {
        return this.f45331a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof n) && this.f45331a == ((n) obj).b();
    }

    public int hashCode() {
        return this.f45331a;
    }

    public n(byte[] bArr, int i10) {
        int i11 = (bArr[i10 + 1] << 8) & 65280;
        this.f45331a = i11;
        this.f45331a = i11 + (bArr[i10] & 255);
    }

    public n(int i10) {
        this.f45331a = i10;
    }
}
