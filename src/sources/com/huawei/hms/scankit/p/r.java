package com.huawei.hms.scankit.p;

import java.util.Arrays;

/* compiled from: BitArray.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class r implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int[] f31440a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f31441b;

    /* renamed from: c, reason: collision with root package name */
    private int f31442c;

    public r() {
        this.f31442c = 0;
        this.f31440a = new int[1];
    }

    private void a(int i10) {
        if (i10 > this.f31440a.length * 32) {
            int[] f10 = f(i10);
            int[] iArr = this.f31440a;
            System.arraycopy((Object) iArr, 0, (Object) f10, 0, iArr.length);
            this.f31440a = f10;
        }
    }

    private int e(int i10) {
        int i11 = 0;
        while (i10 > 0) {
            i10 &= i10 - 1;
            i11++;
        }
        return i11;
    }

    public boolean b(int i10) {
        return ((1 << (i10 & 31)) & this.f31440a[i10 / 32]) != 0;
    }

    public void c() {
        this.f31441b = this.f31440a;
    }

    public int d(int i10) {
        int i11 = this.f31442c;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        if (!w7.a(this.f31440a, i12)) {
            return -1;
        }
        int i13 = (-(1 << (i10 & 31))) & (~this.f31440a[i12]);
        while (i13 == 0) {
            i12++;
            int[] iArr = this.f31440a;
            if (i12 == iArr.length) {
                return this.f31442c;
            }
            if (w7.a(iArr, i12)) {
                i13 = ~this.f31440a[i12];
            }
        }
        int numberOfTrailingZeros = (i12 * 32) + Integer.numberOfTrailingZeros(i13);
        int i14 = this.f31442c;
        return numberOfTrailingZeros > i14 ? i14 : numberOfTrailingZeros;
    }

    public int e() {
        return this.f31442c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f31442c == rVar.f31442c && Arrays.equals(this.f31440a, rVar.f31440a);
    }

    public int f() {
        return (this.f31442c + 7) / 8;
    }

    public void g() {
        this.f31440a = this.f31441b;
    }

    public void h(int i10) {
        int[] iArr = this.f31440a;
        int i11 = i10 / 32;
        iArr[i11] = iArr[i11] - (1 << (i10 & 31));
    }

    public int hashCode() {
        return (this.f31442c * 31) + Arrays.hashCode(this.f31440a);
    }

    public void i() {
        for (int i10 = 0; i10 < this.f31442c - 1; i10++) {
            if (!b(i10) && b(i10 + 1)) {
                g(i10);
            }
        }
    }

    public void j() {
        for (int i10 = 0; i10 < this.f31442c - 1; i10++) {
            if (b(i10) && !b(i10 + 1)) {
                h(i10);
            }
        }
    }

    public String toString() {
        int i10 = this.f31442c;
        StringBuilder sb2 = new StringBuilder(i10 + (i10 / 8) + 1);
        for (int i11 = 0; i11 < this.f31442c; i11++) {
            if ((i11 & 7) == 0) {
                sb2.append(' ');
            }
            sb2.append(b(i11) ? 'X' : '.');
        }
        return sb2.toString();
    }

    private static int[] f(int i10) {
        return new int[(i10 + 31) / 32];
    }

    public void b(int i10, int i11) {
        this.f31440a[i10 / 32] = i11;
    }

    public int c(int i10) {
        int i11 = this.f31442c;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        if (!w7.a(this.f31440a, i12)) {
            return -1;
        }
        int i13 = (-(1 << (i10 & 31))) & this.f31440a[i12];
        while (i13 == 0) {
            i12++;
            int[] iArr = this.f31440a;
            if (i12 == iArr.length) {
                return this.f31442c;
            }
            if (w7.a(iArr, i12)) {
                i13 = this.f31440a[i12];
            }
        }
        int numberOfTrailingZeros = (i12 * 32) + Integer.numberOfTrailingZeros(i13);
        int i14 = this.f31442c;
        return numberOfTrailingZeros > i14 ? i14 : numberOfTrailingZeros;
    }

    public void g(int i10) {
        int[] iArr = this.f31440a;
        int i11 = i10 / 32;
        iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
    }

    public void h() {
        int[] iArr = new int[this.f31440a.length];
        int i10 = (this.f31442c - 1) / 32;
        int i11 = i10 + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            long j10 = this.f31440a[i12];
            long j11 = ((j10 & 1431655765) << 1) | ((j10 >> 1) & 1431655765);
            long j12 = ((j11 & 858993459) << 2) | ((j11 >> 2) & 858993459);
            long j13 = ((j12 & 252645135) << 4) | ((j12 >> 4) & 252645135);
            long j14 = ((j13 & 16711935) << 8) | ((j13 >> 8) & 16711935);
            iArr[i10 - i12] = (int) (((j14 & 65535) << 16) | ((j14 >> 16) & 65535));
        }
        int i13 = this.f31442c;
        int i14 = i11 * 32;
        if (i13 != i14) {
            int i15 = i14 - i13;
            int i16 = iArr[0] >>> i15;
            for (int i17 = 1; i17 < i11; i17++) {
                int i18 = iArr[i17];
                iArr[i17 - 1] = i16 | (i18 << (32 - i15));
                i16 = i18 >>> i15;
            }
            iArr[i11 - 1] = i16;
        }
        this.f31440a = iArr;
    }

    public void b(r rVar) {
        if (this.f31442c != rVar.f31442c) {
            try {
                throw new IllegalArgumentException("Sizes don't match");
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i10 = 0;
        while (true) {
            int[] iArr = this.f31440a;
            if (i10 >= iArr.length) {
                return;
            }
            iArr[i10] = iArr[i10] ^ rVar.f31440a[i10];
            i10++;
        }
    }

    public r(int i10) {
        this.f31442c = i10;
        this.f31440a = f(i10);
    }

    public void a() {
        int length = this.f31440a.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f31440a[i10] = 0;
        }
    }

    public r(int[] iArr, int i10) {
        this.f31440a = iArr;
        this.f31442c = i10;
    }

    public boolean a(int i10, int i11, boolean z10, boolean z11) {
        if (i11 < i10 || i10 < 0 || i11 > this.f31442c) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (i11 == i10) {
            return true;
        }
        int i12 = i11 - 1;
        int i13 = i10 / 32;
        int i14 = i12 / 32;
        int i15 = i13;
        int i16 = 0;
        while (i15 <= i14) {
            int i17 = (2 << (i15 < i14 ? 31 : i12 & 31)) - (1 << (i15 > i13 ? 0 : i10 & 31));
            if (!z11 && (i16 = i16 + e(this.f31440a[i15] & i17)) > (i12 - i10) / 10) {
                return false;
            }
            if (z11) {
                int i18 = this.f31440a[i15] & i17;
                if (!z10) {
                    i17 = 0;
                }
                if (i18 != i17) {
                    return false;
                }
            }
            i15++;
        }
        return true;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r clone() {
        return new r((int[]) this.f31440a.clone(), this.f31442c);
    }

    public int[] d() {
        return this.f31440a;
    }

    public void c(int i10, int i11) {
        if (i11 < i10 || i10 < 0 || i11 > this.f31442c) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (i11 == i10) {
            return;
        }
        int i12 = i11 - 1;
        int i13 = i10 / 32;
        int i14 = i12 / 32;
        int i15 = i13;
        while (i15 <= i14) {
            int i16 = 31;
            int i17 = i15 > i13 ? 0 : i10 & 31;
            if (i15 >= i14) {
                i16 = 31 & i12;
            }
            int i18 = (2 << i16) - (1 << i17);
            int[] iArr = this.f31440a;
            iArr[i15] = i18 | iArr[i15];
            i15++;
        }
    }

    public void a(boolean z10) {
        a(this.f31442c + 1);
        if (z10) {
            int[] iArr = this.f31440a;
            int i10 = this.f31442c;
            int i11 = i10 / 32;
            iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
        }
        this.f31442c++;
    }

    public void a(int i10, int i11) {
        if (i11 >= 0 && i11 <= 32) {
            a(this.f31442c + i11);
            while (i11 > 0) {
                boolean z10 = true;
                if (((i10 >> (i11 - 1)) & 1) != 1) {
                    z10 = false;
                }
                a(z10);
                i11--;
            }
            return;
        }
        try {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void a(r rVar) {
        int i10 = rVar.f31442c;
        a(this.f31442c + i10);
        for (int i11 = 0; i11 < i10; i11++) {
            a(rVar.b(i11));
        }
    }

    public void a(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < 8; i15++) {
                if (b(i10)) {
                    i14 |= 1 << (7 - i15);
                }
                i10++;
            }
            bArr[i11 + i13] = (byte) i14;
        }
    }
}
