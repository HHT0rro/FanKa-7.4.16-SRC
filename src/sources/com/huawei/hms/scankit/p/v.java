package com.huawei.hms.scankit.p;

/* compiled from: BitMatrixParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class v {

    /* renamed from: a, reason: collision with root package name */
    private final s f31598a;

    /* renamed from: b, reason: collision with root package name */
    private final s f31599b;

    /* renamed from: c, reason: collision with root package name */
    private final z7 f31600c;

    public v(s sVar) throws a {
        int c4 = sVar.c();
        if (c4 >= 8 && c4 <= 144 && (c4 & 1) == 0) {
            this.f31600c = b(sVar);
            s a10 = a(sVar);
            this.f31598a = a10;
            this.f31599b = new s(a10.e(), a10.c());
            return;
        }
        throw a.a();
    }

    private static z7 b(s sVar) throws a {
        return z7.a(sVar.c(), sVar.e());
    }

    private int c(int i10, int i11) {
        int i12 = i10 - 1;
        int i13 = (a(i12, 0, i10, i11) ? 1 : 0) << 1;
        int i14 = i11 - 1;
        if (a(i12, i14, i10, i11)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        int i16 = i11 - 3;
        if (a(0, i16, i10, i11)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        int i18 = i11 - 2;
        if (a(0, i18, i10, i11)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        if (a(0, i14, i10, i11)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        if (a(1, i16, i10, i11)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (a(1, i18, i10, i11)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        return a(1, i14, i10, i11) ? i22 | 1 : i22;
    }

    private int d(int i10, int i11) {
        int i12 = (a(i10 + (-3), 0, i10, i11) ? 1 : 0) << 1;
        if (a(i10 - 2, 0, i10, i11)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i10 - 1, 0, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(0, i11 - 2, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        int i16 = i11 - 1;
        if (a(0, i16, i10, i11)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        if (a(1, i16, i10, i11)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        if (a(2, i16, i10, i11)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        return a(3, i16, i10, i11) ? i19 | 1 : i19;
    }

    public z7 a() {
        return this.f31600c;
    }

    private int[] a(int i10, int i11, int i12, int i13, byte[] bArr, int i14) {
        do {
            if (i10 < i11 && i12 >= 0 && !this.f31599b.b(i12, i10)) {
                bArr[i14] = (byte) b(i10, i12, i11, i13);
                i14++;
            }
            i10 -= 2;
            i12 += 2;
            if (i10 < 0) {
                break;
            }
        } while (i12 < i13);
        int i15 = i10 + 1;
        int i16 = i12 + 3;
        do {
            if (i15 >= 0 && i16 < i13 && !this.f31599b.b(i16, i15)) {
                bArr[i14] = (byte) b(i15, i16, i11, i13);
                i14++;
            }
            i15 += 2;
            i16 -= 2;
            if (i15 >= i11) {
                break;
            }
        } while (i16 >= 0);
        return new int[]{i15 + 3, i16 + 1, i14};
    }

    public byte[] b() throws a {
        byte[] bArr = new byte[this.f31600c.g()];
        int c4 = this.f31598a.c();
        int e2 = this.f31598a.e();
        int i10 = 4;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        while (true) {
            if (i10 == c4 && i11 == 0 && !z10) {
                bArr[i12] = (byte) a(c4, e2);
                i10 -= 2;
                i11 += 2;
                i12++;
                z10 = true;
            } else {
                int i13 = c4 - 2;
                if (i10 == i13 && i11 == 0 && (e2 & 3) != 0 && !z11) {
                    bArr[i12] = (byte) b(c4, e2);
                    i10 -= 2;
                    i11 += 2;
                    i12++;
                    z11 = true;
                } else if (i10 == c4 + 4 && i11 == 2 && (e2 & 7) == 0 && !z12) {
                    bArr[i12] = (byte) c(c4, e2);
                    i10 -= 2;
                    i11 += 2;
                    i12++;
                    z12 = true;
                } else if (i10 == i13 && i11 == 0 && (e2 & 7) == 4 && !z13) {
                    bArr[i12] = (byte) d(c4, e2);
                    i10 -= 2;
                    i11 += 2;
                    i12++;
                    z13 = true;
                } else {
                    int[] a10 = a(i10, c4, i11, e2, bArr, i12);
                    i10 = a10[0];
                    int i14 = a10[1];
                    i12 = a10[2];
                    i11 = i14;
                }
            }
            if (i10 >= c4 && i11 >= e2) {
                break;
            }
        }
        if (i12 == this.f31600c.g()) {
            return bArr;
        }
        throw a.a();
    }

    private boolean a(int i10, int i11, int i12, int i13) {
        if (i10 < 0) {
            i10 += i12;
            i11 += 4 - ((i12 + 4) & 7);
        }
        if (i11 < 0) {
            i11 += i13;
            i10 += 4 - ((i13 + 4) & 7);
        }
        this.f31599b.c(i11, i10);
        return this.f31598a.b(i11, i10);
    }

    private int a(int i10, int i11) {
        int i12 = i10 - 1;
        int i13 = (a(i12, 0, i10, i11) ? 1 : 0) << 1;
        if (a(i12, 1, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i12, 2, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (a(0, i11 - 2, i10, i11)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        int i17 = i11 - 1;
        if (a(0, i17, i10, i11)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        if (a(1, i17, i10, i11)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        if (a(2, i17, i10, i11)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        return a(3, i17, i10, i11) ? i20 | 1 : i20;
    }

    private s a(s sVar) {
        int f10 = this.f31600c.f();
        int e2 = this.f31600c.e();
        if (sVar.c() == f10) {
            int c4 = this.f31600c.c();
            int b4 = this.f31600c.b();
            int i10 = f10 / c4;
            int i11 = e2 / b4;
            s sVar2 = new s(i11 * b4, i10 * c4);
            for (int i12 = 0; i12 < i10; i12++) {
                int i13 = i12 * c4;
                for (int i14 = 0; i14 < i11; i14++) {
                    int i15 = i14 * b4;
                    for (int i16 = 0; i16 < c4; i16++) {
                        int i17 = ((c4 + 2) * i12) + 1 + i16;
                        int i18 = i13 + i16;
                        for (int i19 = 0; i19 < b4; i19++) {
                            if (sVar.b(((b4 + 2) * i14) + 1 + i19, i17)) {
                                sVar2.c(i15 + i19, i18);
                            }
                        }
                    }
                }
            }
            return sVar2;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }

    private int b(int i10, int i11, int i12, int i13) {
        int i14 = i10 - 2;
        int i15 = i11 - 2;
        int i16 = (a(i14, i15, i12, i13) ? 1 : 0) << 1;
        int i17 = i11 - 1;
        if (a(i14, i17, i12, i13)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        int i19 = i10 - 1;
        if (a(i19, i15, i12, i13)) {
            i18 |= 1;
        }
        int i20 = i18 << 1;
        if (a(i19, i17, i12, i13)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (a(i19, i11, i12, i13)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        if (a(i10, i15, i12, i13)) {
            i22 |= 1;
        }
        int i23 = i22 << 1;
        if (a(i10, i17, i12, i13)) {
            i23 |= 1;
        }
        int i24 = i23 << 1;
        return a(i10, i11, i12, i13) ? i24 | 1 : i24;
    }

    private int b(int i10, int i11) {
        int i12 = (a(i10 + (-3), 0, i10, i11) ? 1 : 0) << 1;
        if (a(i10 - 2, 0, i10, i11)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i10 - 1, 0, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(0, i11 - 4, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (a(0, i11 - 3, i10, i11)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (a(0, i11 - 2, i10, i11)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        int i18 = i11 - 1;
        if (a(0, i18, i10, i11)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        return a(1, i18, i10, i11) ? i19 | 1 : i19;
    }
}
