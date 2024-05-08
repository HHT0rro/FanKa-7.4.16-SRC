package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: ByteMatrix.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[][] f30777a;

    /* renamed from: b, reason: collision with root package name */
    private final int f30778b;

    /* renamed from: c, reason: collision with root package name */
    private final int f30779c;

    public c0(int i10, int i11) {
        this.f30777a = (byte[][]) Array.newInstance((Class<?>) byte.class, i11, i10);
        this.f30778b = i10;
        this.f30779c = i11;
    }

    public byte a(int i10, int i11) {
        try {
            if (w7.a(this.f30777a, i11) && w7.a(this.f30777a[i11], i10)) {
                return this.f30777a[i11][i10];
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        }
    }

    public int b() {
        return this.f30779c;
    }

    public int c() {
        return this.f30778b;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((this.f30778b * 2 * this.f30779c) + 2);
        for (int i10 = 0; i10 < this.f30779c; i10++) {
            byte[] bArr = this.f30777a[i10];
            for (int i11 = 0; i11 < this.f30778b; i11++) {
                byte b4 = bArr[i11];
                if (b4 == 0) {
                    sb2.append(" 0");
                } else if (b4 != 1) {
                    sb2.append("  ");
                } else {
                    sb2.append(" 1");
                }
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }

    public byte[][] a() {
        return this.f30777a;
    }

    public void a(int i10, int i11, int i12) {
        try {
            if (w7.a(this.f30777a, i11) && w7.a(this.f30777a[i11], i10)) {
                this.f30777a[i11][i10] = (byte) i12;
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        }
    }

    public void a(int i10, int i11, boolean z10) {
        try {
            if (w7.a(this.f30777a, i11) && w7.a(this.f30777a[i11], i10)) {
                this.f30777a[i11][i10] = z10 ? (byte) 1 : (byte) 0;
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        }
    }

    public void a(byte b4) {
        for (byte[] bArr : this.f30777a) {
            Arrays.fill(bArr, b4);
        }
    }
}
