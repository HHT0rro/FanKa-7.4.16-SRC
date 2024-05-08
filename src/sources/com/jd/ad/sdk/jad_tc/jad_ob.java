package com.jd.ad.sdk.jad_tc;

import android.graphics.Color;
import android.graphics.PointF;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_ob implements jad_mx<com.jd.ad.sdk.jad_qz.jad_dq> {
    public int jad_an;

    public jad_ob(int i10) {
        this.jad_an = i10;
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_mx
    public com.jd.ad.sdk.jad_qz.jad_dq jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, float f10) {
        int i10;
        double d10;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        boolean z10 = jad_cpVar.jad_mz() == 1;
        if (z10) {
            jad_cpVar.jad_bo();
        }
        while (jad_cpVar.jad_jt()) {
            arrayList.add(Float.valueOf((float) jad_cpVar.jad_iv()));
        }
        if (z10) {
            jad_cpVar.jad_dq();
        }
        if (this.jad_an == -1) {
            this.jad_an = arrayList.size() / 4;
        }
        int i12 = this.jad_an;
        float[] fArr = new float[i12];
        int[] iArr = new int[i12];
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            i10 = this.jad_an * 4;
            if (i13 >= i10) {
                break;
            }
            int i16 = i13 / 4;
            double floatValue = ((Float) arrayList.get(i13)).floatValue();
            int i17 = i13 % 4;
            if (i17 == 0) {
                if (i16 > 0) {
                    float f11 = (float) floatValue;
                    if (fArr[i16 - 1] >= f11) {
                        fArr[i16] = f11 + 0.01f;
                    }
                }
                fArr[i16] = (float) floatValue;
            } else if (i17 == 1) {
                i14 = (int) (floatValue * 255.0d);
            } else if (i17 == 2) {
                i15 = (int) (floatValue * 255.0d);
            } else if (i17 == 3) {
                iArr[i16] = Color.argb(255, i14, i15, (int) (floatValue * 255.0d));
            }
            i13++;
        }
        com.jd.ad.sdk.jad_qz.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_qz.jad_dq(fArr, iArr);
        if (arrayList.size() > i10) {
            int size = (arrayList.size() - i10) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i18 = 0;
            while (i10 < arrayList.size()) {
                if (i10 % 2 == 0) {
                    dArr[i18] = ((Float) arrayList.get(i10)).floatValue();
                } else {
                    dArr2[i18] = ((Float) arrayList.get(i10)).floatValue();
                    i18++;
                }
                i10++;
            }
            while (true) {
                int[] iArr2 = jad_dqVar.jad_bo;
                if (i11 >= iArr2.length) {
                    break;
                }
                int i19 = iArr2[i11];
                double d11 = jad_dqVar.jad_an[i11];
                int i20 = 1;
                while (true) {
                    if (i20 >= size) {
                        d10 = dArr2[size - 1] * 255.0d;
                        break;
                    }
                    int i21 = i20 - 1;
                    double d12 = dArr[i21];
                    double d13 = dArr[i20];
                    if (dArr[i20] >= d11) {
                        double d14 = (d11 - d12) / (d13 - d12);
                        PointF pointF = com.jd.ad.sdk.jad_ve.jad_jt.jad_an;
                        double max = Math.max(ShadowDrawableWrapper.COS_45, Math.min(1.0d, d14));
                        double d15 = dArr2[i21];
                        d10 = (((dArr2[i20] - d15) * max) + d15) * 255.0d;
                        break;
                    }
                    i20++;
                }
                jad_dqVar.jad_bo[i11] = Color.argb((int) d10, Color.red(i19), Color.green(i19), Color.blue(i19));
                i11++;
            }
        }
        return jad_dqVar;
    }
}
