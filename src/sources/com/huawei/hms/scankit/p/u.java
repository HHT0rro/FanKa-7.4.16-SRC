package com.huawei.hms.scankit.p;

/* compiled from: BitMatrixParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class u {

    /* renamed from: a, reason: collision with root package name */
    private final s f31553a;

    /* renamed from: b, reason: collision with root package name */
    private b8 f31554b;

    /* renamed from: c, reason: collision with root package name */
    private l3 f31555c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f31556d;

    public u(s sVar) throws a {
        int c4 = sVar.c();
        if (c4 >= 21 && (c4 & 3) == 1) {
            this.f31553a = sVar;
            return;
        }
        throw a.a();
    }

    private int a(int i10, int i11, int i12) {
        return this.f31556d ? this.f31553a.b(i11, i10) : this.f31553a.b(i10, i11) ? (i12 << 1) | 1 : i12 << 1;
    }

    public byte[] b() throws a {
        l3 c4 = c();
        b8 d10 = d();
        g1 g1Var = g1.values()[c4.a()];
        int c10 = this.f31553a.c();
        g1Var.a(this.f31553a, c10);
        s a10 = d10.a();
        byte[] bArr = new byte[d10.e()];
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
                        if (this.f31553a.b(i18, i16)) {
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
        if (i12 == d10.e()) {
            return bArr;
        }
        throw a.a();
    }

    public l3 c() throws a {
        l3 l3Var = this.f31555c;
        if (l3Var != null) {
            return l3Var;
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
        int c4 = this.f31553a.c();
        int i14 = c4 - 7;
        for (int i15 = c4 - 1; i15 >= i14; i15--) {
            i10 = a(8, i15, i10);
        }
        for (int i16 = c4 - 8; i16 < c4; i16++) {
            i10 = a(i16, 8, i10);
        }
        l3 a11 = l3.a(a10, i10);
        this.f31555c = a11;
        if (a11 != null) {
            return a11;
        }
        throw a.a();
    }

    public b8 d() throws a {
        b8 b8Var = this.f31554b;
        if (b8Var != null) {
            return b8Var;
        }
        int c4 = this.f31553a.c();
        int i10 = (c4 - 17) / 4;
        if (i10 <= 6) {
            return b8.c(i10);
        }
        int i11 = c4 - 11;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = c4 - 9; i15 >= i11; i15--) {
                i13 = a(i15, i14, i13);
            }
        }
        b8 a10 = b8.a(i13);
        if (a10 != null && a10.d() == c4) {
            this.f31554b = a10;
            return a10;
        }
        for (int i16 = 5; i16 >= 0; i16--) {
            for (int i17 = c4 - 9; i17 >= i11; i17--) {
                i12 = a(i16, i17, i12);
            }
        }
        b8 a11 = b8.a(i12);
        if (a11 != null && a11.d() == c4) {
            this.f31554b = a11;
            return a11;
        }
        throw a.a();
    }

    public void e() {
        if (this.f31555c == null) {
            return;
        }
        g1.values()[this.f31555c.a()].a(this.f31553a, this.f31553a.c());
    }

    public void a(boolean z10) {
        this.f31554b = null;
        this.f31555c = null;
        this.f31556d = z10;
    }

    public void a() {
        int i10 = 0;
        while (i10 < this.f31553a.e()) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < this.f31553a.c(); i12++) {
                if (this.f31553a.b(i10, i12) != this.f31553a.b(i12, i10)) {
                    this.f31553a.a(i12, i10);
                    this.f31553a.a(i10, i12);
                }
            }
            i10 = i11;
        }
    }
}
