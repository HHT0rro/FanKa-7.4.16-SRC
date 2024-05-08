package com.huawei.hms.scankit.p;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.reflect.Array;

/* compiled from: OneTagCommon.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i5 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f31124a = {new int[]{1, 1, 1, 1, 1, 1, 1, 0}, new int[]{1, 0, 0, 0, 0, 0, 1, 0}, new int[]{1, 0, 1, 1, 1, 0, 1, 0}, new int[]{1, 0, 1, 1, 1, 0, 1, 0}, new int[]{1, 0, 1, 1, 1, 0, 1, 0}, new int[]{1, 0, 0, 0, 0, 0, 1, 0}, new int[]{1, 1, 1, 1, 1, 1, 1, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 0}};

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f31125b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    public static s a(s sVar, s sVar2, int i10, double[][] dArr) {
        int i11;
        if (i10 == 21) {
            int i12 = 0;
            for (int i13 = 0; i13 < i10; i13++) {
                for (int i14 = 0; i14 < i10; i14++) {
                    if (i14 >= 8 || i13 >= 8) {
                        int i15 = i10 - 8;
                        if (i14 < i15 || i13 >= 8) {
                            if (i14 < 8 && i13 >= i15) {
                                if (f31124a[i14][(i10 - 1) - i13] == 1) {
                                    sVar.c(i14, i13);
                                }
                            } else {
                                double[] a10 = a((float) dArr[0][i12], (float) dArr[1][i12]);
                                if (sVar2.b(Math.round((float) a10[0]) + 0, Math.round((float) a10[1]) + 0)) {
                                    sVar.c(i14, i13);
                                }
                                i12++;
                            }
                        } else if (f31124a[i13][(i10 - 1) - i14] == 1) {
                            sVar.c(i14, i13);
                        }
                    } else if (f31124a[i13][i14] == 1) {
                        sVar.c(i14, i13);
                    }
                }
            }
        } else {
            int i16 = 0;
            for (int i17 = 0; i17 < i10; i17++) {
                for (int i18 = 0; i18 < i10; i18++) {
                    if (i18 >= 8 || i17 >= 8) {
                        int i19 = i10 - 8;
                        if (i18 < i19 || i17 >= 8) {
                            if (i18 >= 8 || i17 < i19) {
                                int i20 = i10 - 9;
                                if (i18 >= i20 && i18 < i10 - 4 && i17 >= i20 && i17 < i11) {
                                    int i21 = -i20;
                                    if (f31125b[i21 + i17][i21 + i18] == 1) {
                                        sVar.c(i18, i17);
                                    }
                                } else {
                                    double[] a11 = a((float) dArr[0][i16], (float) dArr[1][i16]);
                                    if (sVar2.b(Math.round((float) a11[0]) + 0, Math.round((float) a11[1]) + 0)) {
                                        sVar.c(i18, i17);
                                    }
                                    i16++;
                                }
                            } else if (f31124a[i18][(i10 - 1) - i17] == 1) {
                                sVar.c(i18, i17);
                            }
                        } else if (f31124a[i17][(i10 - 1) - i18] == 1) {
                            sVar.c(i18, i17);
                        }
                    } else if (f31124a[i17][i18] == 1) {
                        sVar.c(i18, i17);
                    }
                }
            }
        }
        return sVar;
    }

    public static double[][] a(double d10, double[] dArr, String str) {
        int a10 = a(str);
        String[] split = str.split(";");
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, 2, a10);
        int i10 = 0;
        for (int i11 = 0; i11 < split.length; i11++) {
            double[] a11 = a(split[i11].split(","));
            for (int i12 = 0; i12 < a11.length; i12++) {
                int i13 = i11 / 2;
                dArr2[0][i10] = d10 - (dArr[i13] * Math.cos(a11[i12]));
                dArr2[1][i10] = d10 - (dArr[i13] * Math.sin(a11[i12]));
                i10++;
            }
        }
        return dArr2;
    }

    private static double[] a(float f10, float f11) {
        double[] dArr = {ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45};
        dArr[0] = f10;
        dArr[1] = f11;
        return dArr;
    }

    public static StringBuffer a(double[] dArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (double d10 : dArr) {
            stringBuffer.append(d10);
            stringBuffer.append(",");
        }
        stringBuffer.append(";");
        return stringBuffer;
    }

    private static double[] a(String[] strArr) {
        int length = strArr.length;
        double[] dArr = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr[i10] = Double.valueOf(strArr[i10]).doubleValue();
        }
        return dArr;
    }

    private static int a(String str) {
        int i10 = 0;
        for (String str2 : str.split(";")) {
            i10 += str2.split(",").length;
        }
        return i10;
    }
}
