package com.huawei.hms.scankit.p;

import java.util.HashMap;

/* compiled from: ToneMapping.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j7 {

    /* renamed from: a, reason: collision with root package name */
    private static float f31176a = 2.51f;

    /* renamed from: b, reason: collision with root package name */
    private static float f31177b = 0.03f;

    /* renamed from: c, reason: collision with root package name */
    private static float f31178c = 2.43f;

    /* renamed from: d, reason: collision with root package name */
    private static float f31179d = 0.59f;

    /* renamed from: e, reason: collision with root package name */
    private static float f31180e = 0.14f;

    /* renamed from: f, reason: collision with root package name */
    private static HashMap<Integer, Integer> f31181f = new HashMap<>(255);

    private static int a(int i10, float f10) {
        if (!f31181f.containsKey(Integer.valueOf(i10))) {
            float f11 = i10 / f10;
            int i11 = (int) ((f10 * (((f31176a * f11) + f31177b) * f11)) / ((f11 * ((f31178c * f11) + f31179d)) + f31180e));
            f31181f.put(Integer.valueOf(i10), Integer.valueOf(i11));
            return i11;
        }
        return f31181f.get(Integer.valueOf(i10)).intValue();
    }

    public static p4 b(p4 p4Var) {
        int a10 = a(p4Var);
        int c4 = p4Var.c();
        int a11 = p4Var.a();
        byte[] b4 = p4Var.b();
        byte[] bArr = new byte[a11 * c4];
        for (int i10 = 0; i10 < a11; i10++) {
            for (int i11 = 0; i11 < c4; i11++) {
                int i12 = (i10 * c4) + i11;
                bArr[i12] = (byte) (a(b4[i12] & 255, a10) & 255);
            }
        }
        f31181f = new HashMap<>(255);
        return new e6(bArr, c4, a11, 0, 0, c4, a11, false);
    }

    private static int a(p4 p4Var) {
        if (p4Var.b() == null) {
            return 1;
        }
        long j10 = 0;
        int c4 = p4Var.c();
        int a10 = p4Var.a();
        for (int i10 = a10 / 4; i10 < (a10 * 3) / 4; i10++) {
            for (int i11 = c4 / 4; i11 < (c4 * 3) / 4; i11++) {
                j10 += r0[(i10 * c4) + i11] & 255;
            }
        }
        return (int) ((j10 / r0.length) * 4);
    }
}
