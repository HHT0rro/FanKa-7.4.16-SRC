package com.huawei.hms.scankit.p;

/* compiled from: BitMatrixParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class t {

    /* renamed from: a, reason: collision with root package name */
    private final s f31530a;

    /* renamed from: b, reason: collision with root package name */
    private a8 f31531b;

    /* renamed from: c, reason: collision with root package name */
    private m3 f31532c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f31533d;

    public t(s sVar) throws a {
        int c4 = sVar.c();
        if (c4 >= 21 && (c4 & 3) == 1) {
            this.f31530a = sVar;
            return;
        }
        throw a.a();
    }

    private int a(int i10, int i11, int i12) {
        return this.f31533d ? this.f31530a.b(i11, i10) : this.f31530a.b(i10, i11) ? (i12 << 1) | 1 : i12 << 1;
    }

    public byte[] b() throws a {
        m3 c4 = c();
        a8 d10 = d();
        f1 f1Var = f1.values()[c4.b()];
        int c10 = this.f31530a.c();
        f1Var.a(this.f31530a, c10);
        s a10 = d10.a();
        byte[] bArr = new byte[d10.l()];
        int i10 = c10 - 1;
        boolean z10 = true;
        int i11 = i10;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 > 0) {
            if (i11 == 6) {
                i11--;
            }
            for (int i15 = 0; i15 < c10; i15++) {
                int i16 = z10 ? i10 - i15 : i15;
                for (int i17 = 0; i17 < 2; i17++) {
                    int i18 = i11 - i17;
                    if (!a10.b(i18, i16)) {
                        i14++;
                        i13 <<= 1;
                        if (this.f31530a.b(i18, i16)) {
                            i13 |= 1;
                        }
                        if (i14 == 8) {
                            bArr[i12] = (byte) i13;
                            i12++;
                            i13 = 0;
                            i14 = 0;
                        }
                    }
                }
            }
            z10 = !z10;
            i11 -= 2;
        }
        if (i12 == d10.l()) {
            return bArr;
        }
        throw a.a();
    }

    public m3 c() throws a {
        m3 m3Var = this.f31532c;
        if (m3Var != null) {
            return m3Var;
        }
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < 6; i12++) {
            i11 = a(i12, 8, i11);
        }
        int a10 = a(8, 7, a(8, 8, a(7, 8, i11)));
        for (int i13 = 5; i13 >= 0; i13--) {
            a10 = a(8, i13, a10);
        }
        int c4 = this.f31530a.c();
        int i14 = c4 - 7;
        for (int i15 = c4 - 1; i15 >= i14; i15--) {
            i10 = a(8, i15, i10);
        }
        for (int i16 = c4 - 8; i16 < c4; i16++) {
            i10 = a(i16, 8, i10);
        }
        m3 a11 = m3.a(a10, i10);
        this.f31532c = a11;
        if (a11 != null) {
            return a11;
        }
        throw a.a();
    }

    public a8 d() throws a {
        a8 a8Var = this.f31531b;
        if (a8Var != null) {
            return a8Var;
        }
        int c4 = this.f31530a.c();
        int i10 = (c4 - 17) / 4;
        if (i10 <= 6) {
            return a8.b(i10);
        }
        int i11 = c4 - 11;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = c4 - 9; i15 >= i11; i15--) {
                i13 = a(i15, i14, i13);
            }
        }
        a8 a10 = a8.a(i13);
        if (a10 != null && a10.k() == c4) {
            this.f31531b = a10;
            return a10;
        }
        for (int i16 = 5; i16 >= 0; i16--) {
            for (int i17 = c4 - 9; i17 >= i11; i17--) {
                i12 = a(i16, i17, i12);
            }
        }
        a8 a11 = a8.a(i12);
        if (a11 != null && a11.k() == c4) {
            this.f31531b = a11;
            return a11;
        }
        throw a.a();
    }

    public void e() {
        if (this.f31532c == null) {
            return;
        }
        f1.values()[this.f31532c.b()].a(this.f31530a, this.f31530a.c());
    }

    public void a(boolean z10) {
        this.f31531b = null;
        this.f31532c = null;
        this.f31533d = z10;
    }

    public void a() throws a {
        if (this.f31530a != null) {
            int i10 = 0;
            while (i10 < this.f31530a.e()) {
                int i11 = i10 + 1;
                for (int i12 = i11; i12 < this.f31530a.c(); i12++) {
                    if (this.f31530a.b(i10, i12) != this.f31530a.b(i12, i10)) {
                        this.f31530a.a(i12, i10);
                        this.f31530a.a(i10, i12);
                    }
                }
                i10 = i11;
            }
            return;
        }
        throw a.a();
    }
}
