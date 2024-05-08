package com.huawei.hms.scankit.p;

import com.android.internal.logging.nano.MetricsProto;
import com.huawei.hms.hmsscankit.WriterException;
import org.apache.commons.io.IOUtils;

/* compiled from: MatrixUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class t4 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f31547a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f31548b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c, reason: collision with root package name */
    private static final int[][] f31549c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f31550d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static void a(c0 c0Var) {
        c0Var.a((byte) -1);
    }

    private static void b(c0 c0Var) throws WriterException {
        if (c0Var.a(8, c0Var.b() - 8) != 0) {
            c0Var.a(8, c0Var.b() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    private static boolean b(int i10) {
        return i10 == -1;
    }

    public static void c(b8 b8Var, c0 c0Var) throws WriterException {
        if (b8Var.f() < 7) {
            return;
        }
        r rVar = new r();
        a(b8Var, rVar);
        int i10 = 17;
        for (int i11 = 0; i11 < 6; i11++) {
            for (int i12 = 0; i12 < 3; i12++) {
                boolean b4 = rVar.b(i10);
                i10--;
                c0Var.a(i11, (c0Var.b() - 11) + i12, b4);
                c0Var.a((c0Var.b() - 11) + i12, i11, b4);
            }
        }
    }

    private static void d(c0 c0Var) {
        int i10 = 8;
        while (i10 < c0Var.c() - 8) {
            int i11 = i10 + 1;
            int i12 = i11 % 2;
            if (b(c0Var.a(i10, 6))) {
                c0Var.a(i10, 6, i12);
            }
            if (b(c0Var.a(6, i10))) {
                c0Var.a(6, i10, i12);
            }
            i10 = i11;
        }
    }

    public static void a(r rVar, b3 b3Var, b8 b8Var, int i10, c0 c0Var) throws WriterException {
        a(c0Var);
        a(b8Var, c0Var);
        a(b3Var, i10, c0Var);
        c(b8Var, c0Var);
        a(rVar, i10, c0Var);
    }

    private static void b(int i10, int i11, c0 c0Var) {
        for (int i12 = 0; i12 < 5; i12++) {
            int[] iArr = f31548b[i12];
            for (int i13 = 0; i13 < 5; i13++) {
                c0Var.a(i10 + i13, i11 + i12, iArr[i13]);
            }
        }
    }

    private static void b(b8 b8Var, c0 c0Var) {
        if (b8Var.f() < 2) {
            return;
        }
        int f10 = b8Var.f() - 1;
        int[][] iArr = f31549c;
        if (f10 < iArr.length) {
            int[] iArr2 = iArr[f10];
            for (int i10 : iArr2) {
                if (i10 >= 0) {
                    for (int i11 : iArr2) {
                        if (i11 >= 0 && b(c0Var.a(i11, i10))) {
                            b(i11 - 2, i10 - 2, c0Var);
                        }
                    }
                }
            }
        }
    }

    public static void a(b8 b8Var, c0 c0Var) throws WriterException {
        c(c0Var);
        b(c0Var);
        b(b8Var, c0Var);
        d(c0Var);
    }

    private static void c(int i10, int i11, c0 c0Var) {
        for (int i12 = 0; i12 < 7; i12++) {
            int[] iArr = f31547a[i12];
            for (int i13 = 0; i13 < 7; i13++) {
                c0Var.a(i10 + i13, i11 + i12, iArr[i13]);
            }
        }
    }

    private static void d(int i10, int i11, c0 c0Var) throws WriterException {
        for (int i12 = 0; i12 < 7; i12++) {
            int i13 = i11 + i12;
            if (b(c0Var.a(i10, i13))) {
                c0Var.a(i10, i13, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    private static void c(c0 c0Var) throws WriterException {
        int length = f31547a[0].length;
        c(0, 0, c0Var);
        c(c0Var.c() - length, 0, c0Var);
        c(0, c0Var.c() - length, c0Var);
        a(0, 7, c0Var);
        a(c0Var.c() - 8, 7, c0Var);
        a(0, c0Var.c() - 8, c0Var);
        d(7, 0, c0Var);
        d((c0Var.b() - 7) - 1, 0, c0Var);
        d(7, c0Var.b() - 7, c0Var);
    }

    public static void a(b3 b3Var, int i10, c0 c0Var) throws WriterException {
        r rVar = new r();
        a(b3Var, i10, rVar);
        for (int i11 = 0; i11 < rVar.e(); i11++) {
            boolean b4 = rVar.b((rVar.e() - 1) - i11);
            int[] iArr = f31550d[i11];
            c0Var.a(iArr[0], iArr[1], b4);
            if (i11 < 8) {
                c0Var.a((c0Var.c() - i11) - 1, 8, b4);
            } else {
                c0Var.a(8, (c0Var.b() - 7) + (i11 - 8), b4);
            }
        }
    }

    public static void a(r rVar, int i10, c0 c0Var) throws WriterException {
        boolean z10;
        int c4 = c0Var.c() - 1;
        int b4 = c0Var.b() - 1;
        int i11 = 0;
        int i12 = -1;
        while (c4 > 0) {
            if (c4 == 6) {
                c4--;
            }
            while (b4 >= 0 && b4 < c0Var.b()) {
                for (int i13 = 0; i13 < 2; i13++) {
                    int i14 = c4 - i13;
                    if (b(c0Var.a(i14, b4))) {
                        if (i11 < rVar.e()) {
                            z10 = rVar.b(i11);
                            i11++;
                        } else {
                            z10 = false;
                        }
                        if (i10 != -1 && r4.a(i10, i14, b4)) {
                            z10 = !z10;
                        }
                        c0Var.a(i14, b4, z10);
                    }
                }
                b4 += i12;
            }
            i12 = -i12;
            b4 += i12;
            c4 -= 2;
        }
        if (i11 == rVar.e()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i11 + IOUtils.DIR_SEPARATOR_UNIX + rVar.e());
    }

    public static int a(int i10) {
        return 32 - Integer.numberOfLeadingZeros(i10);
    }

    public static int a(int i10, int i11) {
        if (i11 != 0) {
            int a10 = a(i11);
            int i12 = i10 << (a10 - 1);
            while (a(i12) >= a10) {
                i12 ^= i11 << (a(i12) - a10);
            }
            return i12;
        }
        try {
            throw new IllegalArgumentException("0 polynomial");
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void a(b3 b3Var, int i10, r rVar) throws WriterException {
        if (h6.a(i10)) {
            int a10 = (b3Var.a() << 3) | i10;
            rVar.a(a10, 5);
            rVar.a(a(a10, MetricsProto.MetricsEvent.ACTION_ZEN_BLOCK_STATUS), 10);
            r rVar2 = new r();
            rVar2.a(21522, 15);
            rVar.b(rVar2);
            if (rVar.e() == 15) {
                return;
            }
            throw new WriterException("should not happen but we got: " + rVar.e());
        }
        throw new WriterException("Invalid mask pattern");
    }

    public static void a(b8 b8Var, r rVar) throws WriterException {
        rVar.a(b8Var.f(), 6);
        rVar.a(a(b8Var.f(), 7973), 12);
        if (rVar.e() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + rVar.e());
    }

    private static void a(int i10, int i11, c0 c0Var) throws WriterException {
        for (int i12 = 0; i12 < 8; i12++) {
            int i13 = i10 + i12;
            if (b(c0Var.a(i13, i11))) {
                c0Var.a(i13, i11, 0);
            } else {
                throw new WriterException();
            }
        }
    }
}
