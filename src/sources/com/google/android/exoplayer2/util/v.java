package com.google.android.exoplayer2.util;

/* compiled from: ParsableNalUnitBitArray.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f23033a;

    /* renamed from: b, reason: collision with root package name */
    public int f23034b;

    /* renamed from: c, reason: collision with root package name */
    public int f23035c;

    /* renamed from: d, reason: collision with root package name */
    public int f23036d;

    public v(byte[] bArr, int i10, int i11) {
        i(bArr, i10, i11);
    }

    public final void a() {
        int i10;
        int i11 = this.f23035c;
        a.g(i11 >= 0 && (i11 < (i10 = this.f23034b) || (i11 == i10 && this.f23036d == 0)));
    }

    public boolean b(int i10) {
        int i11 = this.f23035c;
        int i12 = i10 / 8;
        int i13 = i11 + i12;
        int i14 = (this.f23036d + i10) - (i12 * 8);
        if (i14 > 7) {
            i13++;
            i14 -= 8;
        }
        while (true) {
            i11++;
            if (i11 > i13 || i13 >= this.f23034b) {
                break;
            }
            if (j(i11)) {
                i13++;
                i11 += 2;
            }
        }
        int i15 = this.f23034b;
        if (i13 >= i15) {
            return i13 == i15 && i14 == 0;
        }
        return true;
    }

    public boolean c() {
        int i10 = this.f23035c;
        int i11 = this.f23036d;
        int i12 = 0;
        while (this.f23035c < this.f23034b && !d()) {
            i12++;
        }
        boolean z10 = this.f23035c == this.f23034b;
        this.f23035c = i10;
        this.f23036d = i11;
        return !z10 && b((i12 * 2) + 1);
    }

    public boolean d() {
        boolean z10 = (this.f23033a[this.f23035c] & (128 >> this.f23036d)) != 0;
        k();
        return z10;
    }

    public int e(int i10) {
        int i11;
        this.f23036d += i10;
        int i12 = 0;
        while (true) {
            i11 = this.f23036d;
            if (i11 <= 8) {
                break;
            }
            int i13 = i11 - 8;
            this.f23036d = i13;
            byte[] bArr = this.f23033a;
            int i14 = this.f23035c;
            i12 |= (bArr[i14] & 255) << i13;
            if (!j(i14 + 1)) {
                r3 = 1;
            }
            this.f23035c = i14 + r3;
        }
        byte[] bArr2 = this.f23033a;
        int i15 = this.f23035c;
        int i16 = ((-1) >>> (32 - i10)) & (i12 | ((bArr2[i15] & 255) >> (8 - i11)));
        if (i11 == 8) {
            this.f23036d = 0;
            this.f23035c = i15 + (j(i15 + 1) ? 2 : 1);
        }
        a();
        return i16;
    }

    public final int f() {
        int i10 = 0;
        while (!d()) {
            i10++;
        }
        return ((1 << i10) - 1) + (i10 > 0 ? e(i10) : 0);
    }

    public int g() {
        int f10 = f();
        return (f10 % 2 == 0 ? -1 : 1) * ((f10 + 1) / 2);
    }

    public int h() {
        return f();
    }

    public void i(byte[] bArr, int i10, int i11) {
        this.f23033a = bArr;
        this.f23035c = i10;
        this.f23034b = i11;
        this.f23036d = 0;
        a();
    }

    public final boolean j(int i10) {
        if (2 <= i10 && i10 < this.f23034b) {
            byte[] bArr = this.f23033a;
            if (bArr[i10] == 3 && bArr[i10 - 2] == 0 && bArr[i10 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public void k() {
        int i10 = this.f23036d + 1;
        this.f23036d = i10;
        if (i10 == 8) {
            this.f23036d = 0;
            int i11 = this.f23035c;
            this.f23035c = i11 + (j(i11 + 1) ? 2 : 1);
        }
        a();
    }

    public void l(int i10) {
        int i11 = this.f23035c;
        int i12 = i10 / 8;
        int i13 = i11 + i12;
        this.f23035c = i13;
        int i14 = this.f23036d + (i10 - (i12 * 8));
        this.f23036d = i14;
        if (i14 > 7) {
            this.f23035c = i13 + 1;
            this.f23036d = i14 - 8;
        }
        while (true) {
            i11++;
            if (i11 <= this.f23035c) {
                if (j(i11)) {
                    this.f23035c++;
                    i11 += 2;
                }
            } else {
                a();
                return;
            }
        }
    }
}
