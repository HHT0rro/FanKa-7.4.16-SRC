package com.huawei.hms.scankit.p;

/* compiled from: DefaultGridSampler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class x1 extends s3 {
    @Override // com.huawei.hms.scankit.p.s3
    public s a(s sVar, int i10, int i11, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) throws a {
        return a(sVar, i10, i11, d6.a(f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f25), false);
    }

    public s b(s sVar, int i10, int i11, d6 d6Var) throws a {
        if (i10 > 0 && i11 > 0) {
            s sVar2 = new s(i10, i11);
            int i12 = i10 * 2;
            float[] fArr = new float[i12];
            for (int i13 = 0; i13 < i11; i13++) {
                float f10 = i13 + 0.5f;
                for (int i14 = 0; i14 < i12; i14 += 2) {
                    fArr[i14] = (i14 / 2) + 0.5f;
                    fArr[i14 + 1] = f10;
                }
                if (r3.f31461p && r3.f31458m) {
                    d6Var.b(fArr);
                } else {
                    d6Var.a(fArr);
                }
                int e2 = sVar.e();
                int c4 = sVar.c();
                for (int i15 = 0; i15 < i12; i15 += 2) {
                    try {
                        int i16 = (int) fArr[i15];
                        int i17 = (int) fArr[i15 + 1];
                        if (i16 >= -1 && i16 <= e2 && i17 >= -1 && i17 <= c4) {
                            if (sVar.b(i16, i17)) {
                                sVar2.c(i15 / 2, i13);
                            }
                        }
                        sVar2.c(i15 / 2, i13);
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw a.a();
                    }
                }
            }
            return sVar2;
        }
        throw a.a();
    }

    @Override // com.huawei.hms.scankit.p.s3
    public s a(s sVar, int i10, int i11, d6 d6Var, boolean z10) throws a {
        boolean z11 = r3.f31459n;
        if ((z11 && z10) || !(z11 || z10) || r3.f31466u) {
            return b(sVar, i10, i11, d6Var);
        }
        return a(sVar, i10, i11, d6Var);
    }

    public s a(s sVar, int i10, int i11, d6 d6Var) throws a {
        if (i10 > 0 && i11 > 0) {
            s sVar2 = new s(i10, i11);
            float[] fArr = new float[10];
            float f10 = 0.5f;
            char c4 = 0;
            int i12 = 0;
            while (i12 < i11) {
                int i13 = 0;
                while (i13 < i10) {
                    float f11 = i13;
                    fArr[c4] = (f11 - 0.2f) + f10;
                    float f12 = i12;
                    float f13 = f12 + f10;
                    fArr[1] = f13;
                    fArr[2] = f11 + 0.2f + f10;
                    fArr[3] = f13;
                    float f14 = f11 + f10;
                    fArr[4] = f14;
                    fArr[5] = (f12 - 0.2f) + f10;
                    fArr[6] = f14;
                    fArr[7] = f12 + 0.2f + f10;
                    fArr[8] = f14;
                    fArr[9] = f13;
                    if (r3.f31461p && r3.f31458m) {
                        d6Var.b(fArr);
                    } else {
                        d6Var.a(fArr);
                    }
                    int e2 = sVar.e();
                    int c10 = sVar.c();
                    int i14 = 0;
                    for (int i15 = 0; i15 < 5; i15++) {
                        int i16 = i15 * 2;
                        try {
                            int i17 = (int) fArr[i16];
                            int i18 = (int) fArr[i16 + 1];
                            if (i17 >= -1 && i17 <= e2 && i18 >= -1 && i18 <= c10) {
                                if (sVar.b(i17, i18)) {
                                    i14++;
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException unused) {
                            throw a.a();
                        }
                    }
                    if (i14 >= 3) {
                        sVar2.c(i13, i12);
                    }
                    i13++;
                    f10 = 0.5f;
                    c4 = 0;
                }
                i12++;
                f10 = 0.5f;
                c4 = 0;
            }
            return sVar2;
        }
        throw a.a();
    }
}
