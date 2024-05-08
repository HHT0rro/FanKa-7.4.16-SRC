package com.google.android.exoplayer2.util;

import java.nio.charset.Charset;

/* compiled from: ParsableBitArray.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f23029a;

    /* renamed from: b, reason: collision with root package name */
    public int f23030b;

    /* renamed from: c, reason: collision with root package name */
    public int f23031c;

    /* renamed from: d, reason: collision with root package name */
    public int f23032d;

    public u() {
        this.f23029a = j0.f22995f;
    }

    public final void a() {
        int i10;
        int i11 = this.f23030b;
        a.g(i11 >= 0 && (i11 < (i10 = this.f23032d) || (i11 == i10 && this.f23031c == 0)));
    }

    public int b() {
        return ((this.f23032d - this.f23030b) * 8) - this.f23031c;
    }

    public void c() {
        if (this.f23031c == 0) {
            return;
        }
        this.f23031c = 0;
        this.f23030b++;
        a();
    }

    public int d() {
        a.g(this.f23031c == 0);
        return this.f23030b;
    }

    public int e() {
        return (this.f23030b * 8) + this.f23031c;
    }

    public void f(int i10, int i11) {
        if (i11 < 32) {
            i10 &= (1 << i11) - 1;
        }
        int min = Math.min(8 - this.f23031c, i11);
        int i12 = this.f23031c;
        int i13 = (8 - i12) - min;
        byte[] bArr = this.f23029a;
        int i14 = this.f23030b;
        bArr[i14] = (byte) (((65280 >> i12) | ((1 << i13) - 1)) & bArr[i14]);
        int i15 = i11 - min;
        bArr[i14] = (byte) (((i10 >>> i15) << i13) | bArr[i14]);
        int i16 = i14 + 1;
        while (i15 > 8) {
            this.f23029a[i16] = (byte) (i10 >>> (i15 - 8));
            i15 -= 8;
            i16++;
        }
        int i17 = 8 - i15;
        byte[] bArr2 = this.f23029a;
        bArr2[i16] = (byte) (bArr2[i16] & ((1 << i17) - 1));
        bArr2[i16] = (byte) (((i10 & ((1 << i15) - 1)) << i17) | bArr2[i16]);
        r(i11);
        a();
    }

    public boolean g() {
        boolean z10 = (this.f23029a[this.f23030b] & (128 >> this.f23031c)) != 0;
        q();
        return z10;
    }

    public int h(int i10) {
        int i11;
        if (i10 == 0) {
            return 0;
        }
        this.f23031c += i10;
        int i12 = 0;
        while (true) {
            i11 = this.f23031c;
            if (i11 <= 8) {
                break;
            }
            int i13 = i11 - 8;
            this.f23031c = i13;
            byte[] bArr = this.f23029a;
            int i14 = this.f23030b;
            this.f23030b = i14 + 1;
            i12 |= (bArr[i14] & 255) << i13;
        }
        byte[] bArr2 = this.f23029a;
        int i15 = this.f23030b;
        int i16 = ((-1) >>> (32 - i10)) & (i12 | ((bArr2[i15] & 255) >> (8 - i11)));
        if (i11 == 8) {
            this.f23031c = 0;
            this.f23030b = i15 + 1;
        }
        a();
        return i16;
    }

    public void i(byte[] bArr, int i10, int i11) {
        int i12 = (i11 >> 3) + i10;
        while (i10 < i12) {
            byte[] bArr2 = this.f23029a;
            int i13 = this.f23030b;
            int i14 = i13 + 1;
            this.f23030b = i14;
            byte b4 = bArr2[i13];
            int i15 = this.f23031c;
            bArr[i10] = (byte) (b4 << i15);
            bArr[i10] = (byte) (((255 & bArr2[i14]) >> (8 - i15)) | bArr[i10]);
            i10++;
        }
        int i16 = i11 & 7;
        if (i16 == 0) {
            return;
        }
        bArr[i12] = (byte) (bArr[i12] & (255 >> i16));
        int i17 = this.f23031c;
        if (i17 + i16 > 8) {
            int i18 = bArr[i12];
            byte[] bArr3 = this.f23029a;
            int i19 = this.f23030b;
            this.f23030b = i19 + 1;
            bArr[i12] = (byte) (i18 | ((bArr3[i19] & 255) << i17));
            this.f23031c = i17 - 8;
        }
        int i20 = this.f23031c + i16;
        this.f23031c = i20;
        byte[] bArr4 = this.f23029a;
        int i21 = this.f23030b;
        bArr[i12] = (byte) (((byte) (((255 & bArr4[i21]) >> (8 - i20)) << (8 - i16))) | bArr[i12]);
        if (i20 == 8) {
            this.f23031c = 0;
            this.f23030b = i21 + 1;
        }
        a();
    }

    public long j(int i10) {
        if (i10 <= 32) {
            return j0.V0(h(i10));
        }
        return j0.U0(h(i10 - 32), h(32));
    }

    public void k(byte[] bArr, int i10, int i11) {
        a.g(this.f23031c == 0);
        System.arraycopy((Object) this.f23029a, this.f23030b, (Object) bArr, i10, i11);
        this.f23030b += i11;
        a();
    }

    public String l(int i10, Charset charset) {
        byte[] bArr = new byte[i10];
        k(bArr, 0, i10);
        return new String(bArr, charset);
    }

    public void m(ParsableByteArray parsableByteArray) {
        o(parsableByteArray.d(), parsableByteArray.f());
        p(parsableByteArray.e() * 8);
    }

    public void n(byte[] bArr) {
        o(bArr, bArr.length);
    }

    public void o(byte[] bArr, int i10) {
        this.f23029a = bArr;
        this.f23030b = 0;
        this.f23031c = 0;
        this.f23032d = i10;
    }

    public void p(int i10) {
        int i11 = i10 / 8;
        this.f23030b = i11;
        this.f23031c = i10 - (i11 * 8);
        a();
    }

    public void q() {
        int i10 = this.f23031c + 1;
        this.f23031c = i10;
        if (i10 == 8) {
            this.f23031c = 0;
            this.f23030b++;
        }
        a();
    }

    public void r(int i10) {
        int i11 = i10 / 8;
        int i12 = this.f23030b + i11;
        this.f23030b = i12;
        int i13 = this.f23031c + (i10 - (i11 * 8));
        this.f23031c = i13;
        if (i13 > 7) {
            this.f23030b = i12 + 1;
            this.f23031c = i13 - 8;
        }
        a();
    }

    public void s(int i10) {
        a.g(this.f23031c == 0);
        this.f23030b += i10;
        a();
    }

    public u(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public u(byte[] bArr, int i10) {
        this.f23029a = bArr;
        this.f23032d = i10;
    }
}
