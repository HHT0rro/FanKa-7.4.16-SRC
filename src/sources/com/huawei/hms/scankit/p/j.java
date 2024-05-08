package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* compiled from: BarcodeMatrix.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final l[] f31129a;

    /* renamed from: b, reason: collision with root package name */
    private int f31130b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31131c;

    /* renamed from: d, reason: collision with root package name */
    private final int f31132d;

    public j(int i10, int i11) {
        this.f31129a = new l[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            this.f31129a[i12] = new l(((i11 + 4) * 17) + 1);
        }
        this.f31132d = i11 * 17;
        this.f31131c = i10;
        this.f31130b = -1;
    }

    public l a() {
        try {
            int i10 = this.f31130b;
            if (i10 >= 0) {
                l[] lVarArr = this.f31129a;
                if (i10 < lVarArr.length) {
                    return lVarArr[i10];
                }
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        }
    }

    public void b() {
        this.f31130b++;
    }

    public byte[][] a(int i10, int i11) {
        int i12 = this.f31131c * i11;
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, i12, this.f31132d * i10);
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[(i12 - i13) - 1] = this.f31129a[i13 / i11].a(i10);
        }
        return bArr;
    }
}
