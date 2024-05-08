package com.huawei.hms.scankit.p;

/* compiled from: LuminanceSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class p4 {

    /* renamed from: a, reason: collision with root package name */
    private final int f31396a;

    /* renamed from: b, reason: collision with root package name */
    private final int f31397b;

    public p4(int i10, int i11) {
        this.f31396a = i10;
        this.f31397b = i11;
    }

    public final int a() {
        return this.f31397b;
    }

    public abstract p4 a(int i10, int i11, int i12, int i13);

    public abstract byte[] a(int i10, byte[] bArr);

    public abstract byte[] b();

    public final int c() {
        return this.f31396a;
    }

    public final String toString() {
        int i10 = this.f31396a;
        byte[] bArr = new byte[i10];
        StringBuilder sb2 = new StringBuilder(this.f31397b * (i10 + 1));
        for (int i11 = 0; i11 < this.f31397b; i11++) {
            bArr = a(i11, bArr);
            for (int i12 = 0; i12 < this.f31396a; i12++) {
                int i13 = bArr[i12] & 255;
                sb2.append(i13 < 64 ? '#' : i13 < 128 ? '+' : i13 < 192 ? '.' : ' ');
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
