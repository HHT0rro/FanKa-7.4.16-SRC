package com.xiaomi.push;

import java.io.InputStream;
import java.util.Vector;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f47303a;

    /* renamed from: b, reason: collision with root package name */
    public int f47304b;

    /* renamed from: c, reason: collision with root package name */
    public int f47305c;

    /* renamed from: d, reason: collision with root package name */
    public int f47306d;

    /* renamed from: e, reason: collision with root package name */
    public final InputStream f47307e;

    /* renamed from: f, reason: collision with root package name */
    public int f47308f;

    /* renamed from: g, reason: collision with root package name */
    public int f47309g;

    /* renamed from: h, reason: collision with root package name */
    public int f47310h;

    /* renamed from: i, reason: collision with root package name */
    public int f47311i;

    /* renamed from: j, reason: collision with root package name */
    public int f47312j;

    /* renamed from: k, reason: collision with root package name */
    public int f47313k;

    public g0(InputStream inputStream) {
        this.f47310h = Integer.MAX_VALUE;
        this.f47312j = 64;
        this.f47313k = 67108864;
        this.f47303a = new byte[4096];
        this.f47304b = 0;
        this.f47306d = 0;
        this.f47307e = inputStream;
    }

    public g0(byte[] bArr, int i10, int i11) {
        this.f47310h = Integer.MAX_VALUE;
        this.f47312j = 64;
        this.f47313k = 67108864;
        this.f47303a = bArr;
        this.f47304b = i11 + i10;
        this.f47306d = i10;
        this.f47307e = null;
    }

    public static g0 f(InputStream inputStream) {
        return new g0(inputStream);
    }

    public static g0 g(byte[] bArr, int i10, int i11) {
        return new g0(bArr, i10, i11);
    }

    public byte a() {
        if (this.f47306d == this.f47304b) {
            n(true);
        }
        byte[] bArr = this.f47303a;
        int i10 = this.f47306d;
        this.f47306d = i10 + 1;
        return bArr[i10];
    }

    public int b() {
        if (t()) {
            this.f47308f = 0;
            return 0;
        }
        int x10 = x();
        this.f47308f = x10;
        if (x10 != 0) {
            return x10;
        }
        throw d.d();
    }

    public int c(int i10) {
        if (i10 < 0) {
            throw d.b();
        }
        int i11 = i10 + this.f47309g + this.f47306d;
        int i12 = this.f47310h;
        if (i11 > i12) {
            throw d.a();
        }
        this.f47310h = i11;
        r();
        return i12;
    }

    public long d() {
        return v();
    }

    public a e() {
        int x10 = x();
        int i10 = this.f47304b;
        int i11 = this.f47306d;
        if (x10 > i10 - i11 || x10 <= 0) {
            return a.b(o(x10));
        }
        a c4 = a.c(this.f47303a, i11, x10);
        this.f47306d += x10;
        return c4;
    }

    public String h() {
        int x10 = x();
        int i10 = this.f47304b;
        int i11 = this.f47306d;
        if (x10 > i10 - i11 || x10 <= 0) {
            return new String(o(x10), "UTF-8");
        }
        String str = new String(this.f47303a, i11, x10, "UTF-8");
        this.f47306d += x10;
        return str;
    }

    public void i() {
        int b4;
        do {
            b4 = b();
            if (b4 == 0) {
                return;
            }
        } while (m(b4));
    }

    public void j(int i10) {
        if (this.f47308f != i10) {
            throw d.e();
        }
    }

    public void k(t2 t2Var) {
        int x10 = x();
        if (this.f47311i >= this.f47312j) {
            throw d.g();
        }
        int c4 = c(x10);
        this.f47311i++;
        t2Var.b(this);
        j(0);
        this.f47311i--;
        s(c4);
    }

    public boolean l() {
        return x() != 0;
    }

    public boolean m(int i10) {
        int a10 = c4.a(i10);
        if (a10 == 0) {
            p();
            return true;
        }
        if (a10 == 1) {
            y();
            return true;
        }
        if (a10 == 2) {
            w(x());
            return true;
        }
        if (a10 == 3) {
            i();
            j(c4.b(c4.c(i10), 4));
            return true;
        }
        if (a10 == 4) {
            return false;
        }
        if (a10 != 5) {
            throw d.f();
        }
        z();
        return true;
    }

    public final boolean n(boolean z10) {
        int i10 = this.f47306d;
        int i11 = this.f47304b;
        if (i10 < i11) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        int i12 = this.f47309g;
        if (i12 + i11 == this.f47310h) {
            if (z10) {
                throw d.a();
            }
            return false;
        }
        this.f47309g = i12 + i11;
        this.f47306d = 0;
        InputStream inputStream = this.f47307e;
        int read = inputStream == null ? -1 : inputStream.read(this.f47303a);
        this.f47304b = read;
        if (read == 0 || read < -1) {
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f47304b + "\nThe InputStream implementation is buggy.");
        }
        if (read == -1) {
            this.f47304b = 0;
            if (z10) {
                throw d.a();
            }
            return false;
        }
        r();
        int i13 = this.f47309g + this.f47304b + this.f47305c;
        if (i13 > this.f47313k || i13 < 0) {
            throw d.h();
        }
        return true;
    }

    public byte[] o(int i10) {
        if (i10 < 0) {
            throw d.b();
        }
        int i11 = this.f47309g;
        int i12 = this.f47306d;
        int i13 = i11 + i12 + i10;
        int i14 = this.f47310h;
        if (i13 > i14) {
            w((i14 - i11) - i12);
            throw d.a();
        }
        int i15 = this.f47304b;
        if (i10 <= i15 - i12) {
            byte[] bArr = new byte[i10];
            System.arraycopy((Object) this.f47303a, i12, (Object) bArr, 0, i10);
            this.f47306d += i10;
            return bArr;
        }
        if (i10 >= 4096) {
            this.f47309g = i11 + i15;
            this.f47306d = 0;
            this.f47304b = 0;
            int i16 = i15 - i12;
            int i17 = i10 - i16;
            Vector vector = new Vector();
            while (i17 > 0) {
                int min = Math.min(i17, 4096);
                byte[] bArr2 = new byte[min];
                int i18 = 0;
                while (i18 < min) {
                    InputStream inputStream = this.f47307e;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i18, min - i18);
                    if (read == -1) {
                        throw d.a();
                    }
                    this.f47309g += read;
                    i18 += read;
                }
                i17 -= min;
                vector.addElement(bArr2);
            }
            byte[] bArr3 = new byte[i10];
            System.arraycopy((Object) this.f47303a, i12, (Object) bArr3, 0, i16);
            for (int i19 = 0; i19 < vector.size(); i19++) {
                byte[] bArr4 = (byte[]) vector.elementAt(i19);
                System.arraycopy((Object) bArr4, 0, (Object) bArr3, i16, bArr4.length);
                i16 += bArr4.length;
            }
            return bArr3;
        }
        byte[] bArr5 = new byte[i10];
        int i20 = i15 - i12;
        System.arraycopy((Object) this.f47303a, i12, (Object) bArr5, 0, i20);
        this.f47306d = this.f47304b;
        while (true) {
            n(true);
            int i21 = i10 - i20;
            int i22 = this.f47304b;
            if (i21 <= i22) {
                System.arraycopy((Object) this.f47303a, 0, (Object) bArr5, i20, i21);
                this.f47306d = i21;
                return bArr5;
            }
            System.arraycopy((Object) this.f47303a, 0, (Object) bArr5, i20, i22);
            int i23 = this.f47304b;
            i20 += i23;
            this.f47306d = i23;
        }
    }

    public int p() {
        return x();
    }

    public long q() {
        return v();
    }

    public final void r() {
        int i10 = this.f47304b + this.f47305c;
        this.f47304b = i10;
        int i11 = this.f47309g + i10;
        int i12 = this.f47310h;
        if (i11 <= i12) {
            this.f47305c = 0;
            return;
        }
        int i13 = i11 - i12;
        this.f47305c = i13;
        this.f47304b = i10 - i13;
    }

    public void s(int i10) {
        this.f47310h = i10;
        r();
    }

    public boolean t() {
        return this.f47306d == this.f47304b && !n(false);
    }

    public int u() {
        return x();
    }

    public long v() {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            j10 |= (r3 & Byte.MAX_VALUE) << i10;
            if ((a() & 128) == 0) {
                return j10;
            }
        }
        throw d.c();
    }

    public void w(int i10) {
        if (i10 < 0) {
            throw d.b();
        }
        int i11 = this.f47309g;
        int i12 = this.f47306d;
        int i13 = i11 + i12 + i10;
        int i14 = this.f47310h;
        if (i13 > i14) {
            w((i14 - i11) - i12);
            throw d.a();
        }
        int i15 = this.f47304b;
        if (i10 <= i15 - i12) {
            this.f47306d = i12 + i10;
            return;
        }
        int i16 = i15 - i12;
        this.f47309g = i11 + i15;
        this.f47306d = 0;
        this.f47304b = 0;
        while (i16 < i10) {
            InputStream inputStream = this.f47307e;
            int skip = inputStream == null ? -1 : (int) inputStream.skip(i10 - i16);
            if (skip <= 0) {
                throw d.a();
            }
            i16 += skip;
            this.f47309g += skip;
        }
    }

    public int x() {
        int i10;
        byte a10 = a();
        if (a10 >= 0) {
            return a10;
        }
        int i11 = a10 & Byte.MAX_VALUE;
        byte a11 = a();
        if (a11 >= 0) {
            i10 = a11 << 7;
        } else {
            i11 |= (a11 & Byte.MAX_VALUE) << 7;
            byte a12 = a();
            if (a12 >= 0) {
                i10 = a12 << 14;
            } else {
                i11 |= (a12 & Byte.MAX_VALUE) << 14;
                byte a13 = a();
                if (a13 < 0) {
                    int i12 = i11 | ((a13 & Byte.MAX_VALUE) << 21);
                    byte a14 = a();
                    int i13 = i12 | (a14 << 28);
                    if (a14 >= 0) {
                        return i13;
                    }
                    for (int i14 = 0; i14 < 5; i14++) {
                        if (a() >= 0) {
                            return i13;
                        }
                    }
                    throw d.c();
                }
                i10 = a13 << 21;
            }
        }
        return i11 | i10;
    }

    public long y() {
        return ((a() & 255) << 8) | (a() & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    public int z() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
    }
}
