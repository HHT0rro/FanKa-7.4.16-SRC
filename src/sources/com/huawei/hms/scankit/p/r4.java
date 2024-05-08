package com.huawei.hms.scankit.p;

/* compiled from: MaskUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class r4 {
    public static int a(c0 c0Var) {
        return a(c0Var, true) + a(c0Var, false);
    }

    public static int b(c0 c0Var) {
        byte[][] a10 = c0Var.a();
        int c4 = c0Var.c();
        int b4 = c0Var.b();
        int i10 = 0;
        for (int i11 = 0; i11 < b4 - 1; i11++) {
            byte[] bArr = a10[i11];
            int i12 = 0;
            while (i12 < c4 - 1) {
                byte b10 = bArr[i12];
                int i13 = i12 + 1;
                if (b10 == bArr[i13]) {
                    int i14 = i11 + 1;
                    if (b10 == a10[i14][i12] && b10 == a10[i14][i13]) {
                        i10++;
                    }
                }
                i12 = i13;
            }
        }
        return i10 * 3;
    }

    public static int c(c0 c0Var) {
        byte[][] a10 = c0Var.a();
        int c4 = c0Var.c();
        int b4 = c0Var.b();
        int i10 = 0;
        for (int i11 = 0; i11 < b4; i11++) {
            for (int i12 = 0; i12 < c4; i12++) {
                byte[] bArr = a10[i11];
                int i13 = i12 + 6;
                if (i13 < c4 && bArr[i12] == 1 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 1 && bArr[i12 + 3] == 1 && bArr[i12 + 4] == 1 && bArr[i12 + 5] == 0 && bArr[i13] == 1 && (a(bArr, i12 - 4, i12) || a(bArr, i12 + 7, i12 + 11))) {
                    i10++;
                }
                int i14 = i11 + 6;
                if (i14 < b4 && a10[i11][i12] == 1 && a10[i11 + 1][i12] == 0 && a10[i11 + 2][i12] == 1 && a10[i11 + 3][i12] == 1 && a10[i11 + 4][i12] == 1 && a10[i11 + 5][i12] == 0 && a10[i14][i12] == 1 && (a(a10, i12, i11 - 4, i11) || a(a10, i12, i11 + 7, i11 + 11))) {
                    i10++;
                }
            }
        }
        return i10 * 40;
    }

    public static int d(c0 c0Var) {
        byte[][] a10 = c0Var.a();
        int c4 = c0Var.c();
        int b4 = c0Var.b();
        int i10 = 0;
        for (int i11 = 0; i11 < b4; i11++) {
            byte[] bArr = a10[i11];
            for (int i12 = 0; i12 < c4; i12++) {
                if (bArr[i12] == 1) {
                    i10++;
                }
            }
        }
        int b10 = c0Var.b() * c0Var.c();
        return ((Math.abs((i10 * 2) - b10) * 10) / b10) * 10;
    }

    private static boolean a(byte[] bArr, int i10, int i11) {
        int min = Math.min(i11, bArr.length);
        for (int max = Math.max(i10, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i10, int i11, int i12) {
        int min = Math.min(i12, bArr.length);
        for (int max = Math.max(i11, 0); max < min; max++) {
            if (max < bArr.length && i10 < bArr[0].length && bArr[max][i10] == 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0001. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0033 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L2d;
                case 1: goto L2e;
                case 2: goto L2a;
                case 3: goto L26;
                case 4: goto L21;
                case 5: goto L19;
                case 6: goto L10;
                case 7: goto L7;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch: java.lang.Exception -> L4a
            goto L35
        L7:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L17
        L10:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L17:
            r1 = r1 & r0
            goto L30
        L19:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L30
        L21:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L2d
        L26:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L30
        L2a:
            int r1 = r2 % 3
            goto L30
        L2d:
            int r3 = r3 + r2
        L2e:
            r1 = r3 & 1
        L30:
            if (r1 != 0) goto L33
            goto L34
        L33:
            r0 = 0
        L34:
            return r0
        L35:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L4a
            r3.<init>()     // Catch: java.lang.Exception -> L4a
            java.lang.String r0 = "Invalid mask pattern: "
            r3.append(r0)     // Catch: java.lang.Exception -> L4a
            r3.append(r1)     // Catch: java.lang.Exception -> L4a
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Exception -> L4a
            r2.<init>(r1)     // Catch: java.lang.Exception -> L4a
            throw r2     // Catch: java.lang.Exception -> L4a
        L4a:
            r1 = move-exception
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.r4.a(int, int, int):boolean");
    }

    private static int a(c0 c0Var, boolean z10) {
        int b4 = z10 ? c0Var.b() : c0Var.c();
        int c4 = z10 ? c0Var.c() : c0Var.b();
        byte[][] a10 = c0Var.a();
        int i10 = 0;
        for (int i11 = 0; i11 < b4; i11++) {
            byte b10 = -1;
            int i12 = 0;
            for (int i13 = 0; i13 < c4; i13++) {
                byte b11 = z10 ? a10[i11][i13] : a10[i13][i11];
                if (b11 == b10) {
                    i12++;
                } else {
                    if (i12 >= 5) {
                        i10 += (i12 - 5) + 3;
                    }
                    b10 = b11;
                    i12 = 1;
                }
            }
            if (i12 >= 5) {
                i10 += (i12 - 5) + 3;
            }
        }
        return i10;
    }
}
