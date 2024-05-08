package com.huawei.hms.scankit.p;

/* compiled from: BinaryBitmap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final o f31382a;

    /* renamed from: b, reason: collision with root package name */
    private s f31383b;

    public p(o oVar) {
        if (oVar != null) {
            this.f31382a = oVar;
        } else {
            try {
                throw new IllegalArgumentException("Binarizer must be non-null.");
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    public r a(int i10, int i11) throws a {
        int i12;
        int e2 = e();
        if (e2 >= 45) {
            r rVar = new r(e2);
            byte[] bArr = new byte[e2];
            a().c().a(i10, bArr);
            int[] iArr = new int[e2];
            int[] iArr2 = new int[e2];
            iArr[0] = bArr[0] & 255;
            iArr2[0] = iArr[0] * iArr[0];
            for (int i13 = 1; i13 < e2; i13++) {
                iArr[i13] = iArr[i13 - 1] + (bArr[i13] & 255);
            }
            if (i11 == 0) {
                int i14 = 23;
                while (true) {
                    i12 = e2 - 22;
                    if (i14 >= i12) {
                        break;
                    }
                    if ((bArr[i14] & 255) + 5 < (iArr[i14 + 22] - iArr[(i14 - 22) - 1]) / 45) {
                        rVar.g(i14);
                    }
                    i14++;
                }
                if (rVar.b(23)) {
                    rVar.c(0, 23);
                }
                if (rVar.b(i12 - 1)) {
                    rVar.c(i12, e2);
                }
                return rVar;
            }
            return a(45, e2, iArr, iArr2, bArr, 22);
        }
        throw a.a();
    }

    public s b() throws a {
        if (this.f31383b == null) {
            this.f31383b = this.f31382a.a();
        }
        return this.f31383b;
    }

    public int c() {
        return this.f31382a.b();
    }

    public byte[] d() {
        return this.f31382a.c().b();
    }

    public int e() {
        return this.f31382a.d();
    }

    private r a(int i10, int i11, int[] iArr, int[] iArr2, byte[] bArr, int i12) {
        int i13;
        r rVar = new r(i11);
        for (int i14 = 1; i14 < i11; i14++) {
            iArr2[i14] = iArr2[i14 - 1] + ((bArr[i14] & 255) * (bArr[i14] & 255));
        }
        int i15 = i12 + 1;
        int i16 = i15;
        while (true) {
            i13 = i11 - i12;
            if (i16 >= i13) {
                break;
            }
            double d10 = iArr[i16 + i12] - iArr[(i16 - i12) - 1];
            double d11 = i10;
            if ((bArr[i16] & 255) <= (d10 / d11) * ((0.5f * (Math.sqrt(((iArr2[r6] - iArr2[r8]) - ((d10 * d10) / d11)) / (i10 - 1)) / 127)) + 1.0d)) {
                rVar.g(i16);
            }
            i16++;
        }
        if (rVar.b(i15)) {
            rVar.c(0, i15);
        }
        if (rVar.b(i13 - 1)) {
            rVar.c(i13, i11);
        }
        return rVar;
    }

    public r a(int i10, r rVar) throws a {
        return this.f31382a.a(i10, rVar);
    }

    public void a(s sVar) {
        this.f31383b = sVar;
    }

    public p a(int i10, int i11, int i12, int i13) {
        return new p(this.f31382a.a(this.f31382a.c().a(i10, i11, i12, i13)));
    }

    public o a() {
        return this.f31382a;
    }
}
