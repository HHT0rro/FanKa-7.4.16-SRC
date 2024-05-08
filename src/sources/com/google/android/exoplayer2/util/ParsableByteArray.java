package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ParsableByteArray {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f22929a;

    /* renamed from: b, reason: collision with root package name */
    public int f22930b;

    /* renamed from: c, reason: collision with root package name */
    public int f22931c;

    public ParsableByteArray() {
        this.f22929a = j0.f22995f;
    }

    public String A(int i10) {
        return B(i10, com.google.common.base.c.f25961c);
    }

    public String B(int i10, Charset charset) {
        String str = new String(this.f22929a, this.f22930b, i10, charset);
        this.f22930b += i10;
        return str;
    }

    public int C() {
        return (D() << 21) | (D() << 14) | (D() << 7) | D();
    }

    public int D() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b;
        this.f22930b = i10 + 1;
        return bArr[i10] & 255;
    }

    public int E() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = (bArr[i10] & 255) << 8;
        int i13 = i11 + 1;
        this.f22930b = i13;
        int i14 = (bArr[i11] & 255) | i12;
        this.f22930b = i13 + 2;
        return i14;
    }

    public long F() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b + 1;
        this.f22930b = i10;
        long j10 = (bArr[r1] & 255) << 24;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = i11 + 1;
        this.f22930b = i12;
        long j11 = j10 | ((bArr[i10] & 255) << 16) | ((bArr[i11] & 255) << 8);
        this.f22930b = i12 + 1;
        return j11 | (bArr[i12] & 255);
    }

    public int G() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = (bArr[i10] & 255) << 16;
        int i13 = i11 + 1;
        this.f22930b = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 8);
        this.f22930b = i13 + 1;
        return (bArr[i13] & 255) | i14;
    }

    public int H() {
        int n10 = n();
        if (n10 >= 0) {
            return n10;
        }
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("Top bit not zero: ");
        sb2.append(n10);
        throw new IllegalStateException(sb2.toString());
    }

    public long I() {
        long w3 = w();
        if (w3 >= 0) {
            return w3;
        }
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("Top bit not zero: ");
        sb2.append(w3);
        throw new IllegalStateException(sb2.toString());
    }

    public int J() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.f22930b = i11 + 1;
        return (bArr[i11] & 255) | i12;
    }

    public long K() {
        int i10;
        int i11;
        long j10 = this.f22929a[this.f22930b];
        int i12 = 7;
        while (true) {
            if (i12 < 0) {
                break;
            }
            if (((1 << i12) & j10) != 0) {
                i12--;
            } else if (i12 < 6) {
                j10 &= r6 - 1;
                i11 = 7 - i12;
            } else if (i12 == 7) {
                i11 = 1;
            }
        }
        i11 = 0;
        if (i11 != 0) {
            for (i10 = 1; i10 < i11; i10++) {
                if ((this.f22929a[this.f22930b + i10] & 192) != 128) {
                    StringBuilder sb2 = new StringBuilder(62);
                    sb2.append("Invalid UTF-8 sequence continuation byte: ");
                    sb2.append(j10);
                    throw new NumberFormatException(sb2.toString());
                }
                j10 = (j10 << 6) | (r3 & Utf8.REPLACEMENT_BYTE);
            }
            this.f22930b += i11;
            return j10;
        }
        StringBuilder sb3 = new StringBuilder(55);
        sb3.append("Invalid UTF-8 sequence first byte: ");
        sb3.append(j10);
        throw new NumberFormatException(sb3.toString());
    }

    public void L(int i10) {
        N(b() < i10 ? new byte[i10] : this.f22929a, i10);
    }

    public void M(byte[] bArr) {
        N(bArr, bArr.length);
    }

    public void N(byte[] bArr, int i10) {
        this.f22929a = bArr;
        this.f22931c = i10;
        this.f22930b = 0;
    }

    public void O(int i10) {
        a.a(i10 >= 0 && i10 <= this.f22929a.length);
        this.f22931c = i10;
    }

    public void P(int i10) {
        a.a(i10 >= 0 && i10 <= this.f22931c);
        this.f22930b = i10;
    }

    public void Q(int i10) {
        P(this.f22930b + i10);
    }

    public int a() {
        return this.f22931c - this.f22930b;
    }

    public int b() {
        return this.f22929a.length;
    }

    public void c(int i10) {
        if (i10 > b()) {
            this.f22929a = Arrays.copyOf(this.f22929a, i10);
        }
    }

    public byte[] d() {
        return this.f22929a;
    }

    public int e() {
        return this.f22930b;
    }

    public int f() {
        return this.f22931c;
    }

    public char g() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b;
        return (char) ((bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8));
    }

    public int h() {
        return this.f22929a[this.f22930b] & 255;
    }

    public void i(u uVar, int i10) {
        j(uVar.f23029a, 0, i10);
        uVar.p(0);
    }

    public void j(byte[] bArr, int i10, int i11) {
        System.arraycopy((Object) this.f22929a, this.f22930b, (Object) bArr, i10, i11);
        this.f22930b += i11;
    }

    @Nullable
    public String k(char c4) {
        if (a() == 0) {
            return null;
        }
        int i10 = this.f22930b;
        while (i10 < this.f22931c && this.f22929a[i10] != c4) {
            i10++;
        }
        byte[] bArr = this.f22929a;
        int i11 = this.f22930b;
        String F = j0.F(bArr, i11, i10 - i11);
        this.f22930b = i10;
        if (i10 < this.f22931c) {
            this.f22930b = i10 + 1;
        }
        return F;
    }

    public double l() {
        return Double.longBitsToDouble(w());
    }

    public float m() {
        return Float.intBitsToFloat(n());
    }

    public int n() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = (bArr[i10] & 255) << 24;
        int i13 = i11 + 1;
        this.f22930b = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 16);
        int i15 = i13 + 1;
        this.f22930b = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        this.f22930b = i15 + 1;
        return (bArr[i15] & 255) | i16;
    }

    public int o() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = ((bArr[i10] & 255) << 24) >> 8;
        int i13 = i11 + 1;
        this.f22930b = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 8);
        this.f22930b = i13 + 1;
        return (bArr[i13] & 255) | i14;
    }

    @Nullable
    public String p() {
        if (a() == 0) {
            return null;
        }
        int i10 = this.f22930b;
        while (i10 < this.f22931c && !j0.p0(this.f22929a[i10])) {
            i10++;
        }
        int i11 = this.f22930b;
        if (i10 - i11 >= 3) {
            byte[] bArr = this.f22929a;
            if (bArr[i11] == -17 && bArr[i11 + 1] == -69 && bArr[i11 + 2] == -65) {
                this.f22930b = i11 + 3;
            }
        }
        byte[] bArr2 = this.f22929a;
        int i12 = this.f22930b;
        String F = j0.F(bArr2, i12, i10 - i12);
        this.f22930b = i10;
        int i13 = this.f22931c;
        if (i10 == i13) {
            return F;
        }
        byte[] bArr3 = this.f22929a;
        if (bArr3[i10] == 13) {
            int i14 = i10 + 1;
            this.f22930b = i14;
            if (i14 == i13) {
                return F;
            }
        }
        int i15 = this.f22930b;
        if (bArr3[i15] == 10) {
            this.f22930b = i15 + 1;
        }
        return F;
    }

    public int q() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i11 + 1;
        this.f22930b = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 8);
        int i15 = i13 + 1;
        this.f22930b = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 16);
        this.f22930b = i15 + 1;
        return ((bArr[i15] & 255) << 24) | i16;
    }

    public long r() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b + 1;
        this.f22930b = i10;
        long j10 = bArr[r1] & 255;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = i11 + 1;
        this.f22930b = i12;
        long j11 = j10 | ((bArr[i10] & 255) << 8) | ((bArr[i11] & 255) << 16);
        int i13 = i12 + 1;
        this.f22930b = i13;
        long j12 = j11 | ((bArr[i12] & 255) << 24);
        int i14 = i13 + 1;
        this.f22930b = i14;
        long j13 = j12 | ((bArr[i13] & 255) << 32);
        int i15 = i14 + 1;
        this.f22930b = i15;
        long j14 = j13 | ((bArr[i14] & 255) << 40);
        int i16 = i15 + 1;
        this.f22930b = i16;
        long j15 = j14 | ((bArr[i15] & 255) << 48);
        this.f22930b = i16 + 1;
        return j15 | ((bArr[i16] & 255) << 56);
    }

    public short s() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = bArr[i10] & 255;
        this.f22930b = i11 + 1;
        return (short) (((bArr[i11] & 255) << 8) | i12);
    }

    public long t() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b + 1;
        this.f22930b = i10;
        long j10 = bArr[r1] & 255;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = i11 + 1;
        this.f22930b = i12;
        long j11 = j10 | ((bArr[i10] & 255) << 8) | ((bArr[i11] & 255) << 16);
        this.f22930b = i12 + 1;
        return j11 | ((bArr[i12] & 255) << 24);
    }

    public int u() {
        int q10 = q();
        if (q10 >= 0) {
            return q10;
        }
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("Top bit not zero: ");
        sb2.append(q10);
        throw new IllegalStateException(sb2.toString());
    }

    public int v() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = bArr[i10] & 255;
        this.f22930b = i11 + 1;
        return ((bArr[i11] & 255) << 8) | i12;
    }

    public long w() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b + 1;
        this.f22930b = i10;
        long j10 = (bArr[r1] & 255) << 56;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = i11 + 1;
        this.f22930b = i12;
        long j11 = j10 | ((bArr[i10] & 255) << 48) | ((bArr[i11] & 255) << 40);
        int i13 = i12 + 1;
        this.f22930b = i13;
        long j12 = j11 | ((bArr[i12] & 255) << 32);
        int i14 = i13 + 1;
        this.f22930b = i14;
        long j13 = j12 | ((bArr[i13] & 255) << 24);
        int i15 = i14 + 1;
        this.f22930b = i15;
        long j14 = j13 | ((bArr[i14] & 255) << 16);
        int i16 = i15 + 1;
        this.f22930b = i16;
        long j15 = j14 | ((bArr[i15] & 255) << 8);
        this.f22930b = i16 + 1;
        return j15 | (bArr[i16] & 255);
    }

    @Nullable
    public String x() {
        return k((char) 0);
    }

    public String y(int i10) {
        if (i10 == 0) {
            return "";
        }
        int i11 = this.f22930b;
        int i12 = (i11 + i10) - 1;
        String F = j0.F(this.f22929a, i11, (i12 >= this.f22931c || this.f22929a[i12] != 0) ? i10 : i10 - 1);
        this.f22930b += i10;
        return F;
    }

    public short z() {
        byte[] bArr = this.f22929a;
        int i10 = this.f22930b;
        int i11 = i10 + 1;
        this.f22930b = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.f22930b = i11 + 1;
        return (short) ((bArr[i11] & 255) | i12);
    }

    public ParsableByteArray(int i10) {
        this.f22929a = new byte[i10];
        this.f22931c = i10;
    }

    public ParsableByteArray(byte[] bArr) {
        this.f22929a = bArr;
        this.f22931c = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i10) {
        this.f22929a = bArr;
        this.f22931c = i10;
    }
}
