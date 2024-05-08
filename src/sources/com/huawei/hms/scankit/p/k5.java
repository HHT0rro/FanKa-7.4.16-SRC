package com.huawei.hms.scankit.p;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* compiled from: OtsuBinarizer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class k5 extends q3 {

    /* renamed from: e, reason: collision with root package name */
    private s f31213e;

    /* renamed from: f, reason: collision with root package name */
    private p4 f31214f;

    public k5(p4 p4Var) {
        super(p4Var);
        this.f31214f = p4Var;
    }

    @Override // com.huawei.hms.scankit.p.q3, com.huawei.hms.scankit.p.o
    public s a() {
        s sVar = this.f31213e;
        if (sVar != null) {
            return sVar;
        }
        p4 c4 = c();
        int c10 = c4.c();
        int a10 = c4.a();
        byte[] b4 = c4.b();
        s sVar2 = new s(c10, a10);
        byte[] b10 = this.f31214f.b();
        int c11 = this.f31214f.c();
        int a11 = this.f31214f.a();
        int[] iArr = new int[256];
        for (int i10 = 0; i10 < a11; i10++) {
            int i11 = i10 * c11;
            for (int i12 = 0; i12 < c11; i12++) {
                int i13 = b10[i11 + i12] & 255;
                iArr[i13] = iArr[i13] + 1;
            }
        }
        int i14 = 0;
        int i15 = 0;
        double d10 = ShadowDrawableWrapper.COS_45;
        for (int i16 = 256; i14 < i16; i16 = 256) {
            int i17 = 0;
            int i18 = 0;
            double d11 = ShadowDrawableWrapper.COS_45;
            while (i17 < i14) {
                i18 += iArr[i17];
                d11 += iArr[i17] * i17;
                i17++;
                iArr = iArr;
            }
            int[] iArr2 = iArr;
            int i19 = i14;
            int i20 = 0;
            double d12 = ShadowDrawableWrapper.COS_45;
            for (int i21 = 256; i19 < i21; i21 = 256) {
                i20 += iArr2[i19];
                d12 += iArr2[i19] * i19;
                i19++;
                i18 = i18;
            }
            int i22 = i18;
            double d13 = i22;
            int i23 = c11;
            int i24 = a11;
            double d14 = c11 * a11;
            double d15 = d13 / d14;
            byte[] bArr = b4;
            double d16 = i20;
            double d17 = d16 / d14;
            double d18 = i22 > 0 ? d11 / d13 : ShadowDrawableWrapper.COS_45;
            double d19 = i20 > 0 ? d12 / d16 : ShadowDrawableWrapper.COS_45;
            double d20 = (d15 * d18) + (d17 * d19);
            double d21 = d18 - d20;
            double d22 = d19 - d20;
            double d23 = (d15 * d21 * d21) + (d17 * d22 * d22);
            if (d23 > d10) {
                i15 = i14;
                d10 = d23;
            }
            i14++;
            b4 = bArr;
            c11 = i23;
            iArr = iArr2;
            a11 = i24;
        }
        byte[] bArr2 = b4;
        for (int i25 = 0; i25 < a10; i25++) {
            int i26 = i25 * c10;
            for (int i27 = 0; i27 < c10; i27++) {
                if ((bArr2[i26 + i27] & 255) <= i15) {
                    sVar2.c(i27, i25);
                }
            }
        }
        this.f31213e = sVar2;
        return sVar2;
    }
}
