package com.huawei.hms.scankit.p;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

/* compiled from: TwoDimDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class k7 {
    public static byte[] a(p pVar, Map<l1, Object> map, s6 s6Var, int[] iArr, double[] dArr) throws a {
        if (pVar == null) {
            return null;
        }
        Collection collection = map != null ? (Collection) map.get(l1.POSSIBLE_FORMATS) : null;
        if ((collection == null || collection.contains(BarcodeFormat.QR_CODE) || collection.contains(BarcodeFormat.PDF_417)) && s6Var != null && s6Var.k() == null) {
            if (collection != null) {
                collection.clear();
                l1 l1Var = l1.POSSIBLE_FORMATS;
                map.remove(l1Var);
                collection.add(s6Var.c());
                map.put(l1Var, collection);
            } else if (map != null) {
                l1 l1Var2 = l1.POSSIBLE_FORMATS;
                map.remove(l1Var2);
                Vector vector = new Vector();
                vector.add(s6Var.c());
                map.put(l1Var2, vector);
            }
            float f10 = 3.0f / r3.f31454i;
            if (f10 < 1.0f) {
                f10 = 1.0f;
            }
            dArr[5] = f10;
            return a(pVar, s6Var.j(), dArr, iArr);
        }
        iArr[0] = pVar.e();
        iArr[1] = pVar.c();
        return pVar.d();
    }

    private static byte[] a(p pVar, u6[] u6VarArr, double[] dArr, int[] iArr) throws a {
        if (u6VarArr == null) {
            iArr[0] = pVar.e();
            iArr[1] = pVar.c();
            return pVar.d();
        }
        int e2 = pVar.e();
        int i10 = e2;
        int c4 = pVar.c();
        int i11 = 0;
        int i12 = 0;
        for (u6 u6Var : u6VarArr) {
            if (u6Var != null) {
                if (((int) u6Var.b()) < i10) {
                    i10 = (int) u6Var.b();
                }
                if (((int) u6Var.c()) < c4) {
                    c4 = (int) u6Var.c();
                }
                if (((int) u6Var.b()) > i11) {
                    i11 = (int) u6Var.b();
                }
                if (((int) u6Var.c()) > i12) {
                    i12 = (int) u6Var.c();
                }
            }
        }
        return a(u6VarArr, pVar, iArr, Math.max(i11 - i10, i12 - c4), dArr);
    }

    private static byte[] a(u6[] u6VarArr, p pVar, int[] iArr, float f10, double[] dArr) throws a {
        float b4 = u6VarArr[0].b();
        float b10 = u6VarArr[1].b();
        float b11 = u6VarArr[2].b();
        float c4 = u6VarArr[0].c();
        float c10 = u6VarArr[1].c();
        float c11 = u6VarArr[2].c();
        if (b4 >= 0.0f && b10 >= 0.0f && b11 >= 0.0f && c4 >= 0.0f && c10 >= 0.0f && c11 >= 0.0f && b4 <= pVar.e() && b10 <= pVar.e() && b11 <= pVar.e() && c4 <= pVar.c() && c10 <= pVar.c() && c11 <= pVar.c()) {
            int i10 = ((int) (c4 + c11)) / 2;
            int i11 = (int) ((((int) (b4 + b11)) / 2) - f10);
            if (i11 < 0) {
                i11 = 0;
            }
            int i12 = (int) (i10 - f10);
            if (i12 < 0) {
                i12 = 0;
            }
            int i13 = ((int) f10) * 2;
            int e2 = i11 + i13 <= pVar.e() ? i13 : pVar.e() - i11;
            if (i12 + i13 > pVar.c()) {
                i13 = pVar.c() - i12;
            }
            p a10 = pVar.a(i11, i12, e2, i13);
            dArr[0] = dArr[0] + Math.toDegrees(a(u6VarArr[0], u6VarArr[1])) + 90.0d;
            dArr[1] = i11;
            dArr[2] = i12;
            double d10 = e2;
            dArr[3] = d10;
            double d11 = i13;
            dArr[4] = d11;
            double radians = Math.toRadians(dArr[0]);
            int abs = (int) (((Math.abs(Math.sin(radians)) * d10) + (Math.abs(Math.cos(radians)) * d11)) * dArr[5]);
            int abs2 = (int) (((d11 * Math.abs(Math.sin(radians))) + (d10 * Math.abs(Math.cos(radians)))) * dArr[5]);
            iArr[0] = abs2;
            iArr[1] = abs;
            byte[] imageRotate = LoadOpencvJNIUtil.imageRotate(a10.d(), a10.c(), a10.e(), abs, abs2, (float) dArr[0], dArr[5]);
            if (imageRotate != null) {
                return imageRotate;
            }
            iArr[0] = pVar.e();
            iArr[1] = pVar.c();
            return pVar.d();
        }
        iArr[0] = pVar.e();
        iArr[1] = pVar.c();
        throw a.a();
    }

    public static double a(u6 u6Var, u6 u6Var2) {
        return Math.atan2(u6Var2.c() - u6Var.c(), u6Var2.b() - u6Var.b());
    }

    public static u6[] a(u6[] u6VarArr, int i10, int i11, double[] dArr) {
        u6 u6Var;
        u6[] u6VarArr2;
        double d10;
        u6[] u6VarArr3 = u6VarArr;
        u6 u6Var2 = null;
        if (u6VarArr3 == null) {
            return null;
        }
        int i12 = dArr[3] != ShadowDrawableWrapper.COS_45 ? (int) dArr[3] : i10;
        int i13 = dArr[4] != ShadowDrawableWrapper.COS_45 ? (int) dArr[4] : i11;
        double d11 = dArr[5];
        u6[] u6VarArr4 = new u6[u6VarArr3.length];
        int i14 = 0;
        double radians = Math.toRadians(dArr[0]);
        double cos = Math.cos(radians) * d11;
        double sin = Math.sin(radians) * d11;
        double d12 = i13;
        double d13 = i12;
        double abs = (((Math.abs(sin) - sin) * d12) + ((Math.abs(cos) - cos) * d13)) / 2.0d;
        double d14 = -sin;
        double abs2 = ((d12 * (Math.abs(cos) - cos)) + (d13 * (Math.abs(sin) + sin))) / 2.0d;
        while (i14 < u6VarArr3.length) {
            if (u6VarArr3[i14] != null) {
                u6VarArr2 = u6VarArr4;
                double b4 = (((r2.b() - abs) * cos) + ((abs2 - r2.c()) * sin)) / ((cos * cos) - (sin * d14));
                d10 = d14;
                u6VarArr2[i14] = new u6((float) (Math.round(b4) + ((int) dArr[1])), (float) (Math.round(sin == ShadowDrawableWrapper.COS_45 ? (r2.c() - abs2) / cos : ((r2.b() - abs) - (cos * b4)) / sin) + ((int) dArr[2])));
                u6Var = null;
            } else {
                u6Var = u6Var2;
                u6VarArr2 = u6VarArr4;
                d10 = d14;
                u6VarArr2[i14] = u6Var;
            }
            i14++;
            d14 = d10;
            u6Var2 = u6Var;
            u6VarArr4 = u6VarArr2;
            u6VarArr3 = u6VarArr;
        }
        return u6VarArr4;
    }
}
