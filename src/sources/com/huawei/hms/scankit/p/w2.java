package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Encoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class w2 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f31647a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* compiled from: Encoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31648a;

        static {
            int[] iArr = new int[u4.values().length];
            f31648a = iArr;
            try {
                iArr[u4.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31648a[u4.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31648a[u4.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31648a[u4.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static int a(c0 c0Var) {
        return r4.a(c0Var) + r4.b(c0Var) + r4.c(c0Var) + r4.d(c0Var);
    }

    public static void b(CharSequence charSequence, r rVar) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int charAt = charSequence.charAt(i10) - '0';
            int i11 = i10 + 2;
            if (i11 < length) {
                rVar.a((charAt * 100) + ((charSequence.charAt(i10 + 1) - '0') * 10) + (charSequence.charAt(i11) - '0'), 10);
                i10 += 3;
            } else {
                i10++;
                if (i10 < length) {
                    rVar.a((charAt * 10) + (charSequence.charAt(i10) - '0'), 7);
                    i10 = i11;
                } else {
                    rVar.a(charAt, 4);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.scankit.p.h6 a(java.lang.String r7, com.huawei.hms.scankit.p.b3 r8, java.util.Map<com.huawei.hms.scankit.p.u2, ?> r9) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            r0 = 1
            r1 = 0
            if (r9 == 0) goto Le
            com.huawei.hms.scankit.p.u2 r2 = com.huawei.hms.scankit.p.u2.CHARACTER_SET
            boolean r2 = r9.containsKey(r2)
            if (r2 == 0) goto Le
            r2 = 1
            goto Lf
        Le:
            r2 = 0
        Lf:
            if (r2 == 0) goto L1c
            com.huawei.hms.scankit.p.u2 r3 = com.huawei.hms.scankit.p.u2.CHARACTER_SET
            java.lang.Object r3 = r9.get(r3)
            java.lang.String r3 = r3.toString()
            goto L1e
        L1c:
            java.lang.String r3 = "ISO-8859-1"
        L1e:
            com.huawei.hms.scankit.p.u4 r4 = a(r7, r3)
            com.huawei.hms.scankit.p.r r5 = new com.huawei.hms.scankit.p.r
            r5.<init>()
            com.huawei.hms.scankit.p.u4 r6 = com.huawei.hms.scankit.p.u4.BYTE
            if (r4 != r6) goto L36
            if (r2 == 0) goto L36
            com.huawei.hms.scankit.p.o0 r2 = com.huawei.hms.scankit.p.o0.a(r3)
            if (r2 == 0) goto L36
            a(r2, r5)
        L36:
            if (r9 == 0) goto L41
            com.huawei.hms.scankit.p.u2 r2 = com.huawei.hms.scankit.p.u2.GS1_FORMAT
            boolean r2 = r9.containsKey(r2)
            if (r2 == 0) goto L41
            goto L42
        L41:
            r0 = 0
        L42:
            if (r0 == 0) goto L5d
            com.huawei.hms.scankit.p.u2 r0 = com.huawei.hms.scankit.p.u2.GS1_FORMAT
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L5d
            com.huawei.hms.scankit.p.u4 r0 = com.huawei.hms.scankit.p.u4.FNC1_FIRST_POSITION
            a(r0, r5)
        L5d:
            a(r4, r5)
            com.huawei.hms.scankit.p.r r0 = new com.huawei.hms.scankit.p.r
            r0.<init>()
            a(r7, r4, r0, r3)
            if (r9 == 0) goto L97
            com.huawei.hms.scankit.p.u2 r1 = com.huawei.hms.scankit.p.u2.QR_VERSION
            boolean r2 = r9.containsKey(r1)
            if (r2 == 0) goto L97
            java.lang.Object r9 = r9.get(r1)     // Catch: java.lang.Exception -> L95
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> L95
            int r9 = java.lang.Integer.parseInt(r9)     // Catch: java.lang.Exception -> L95
            com.huawei.hms.scankit.p.b8 r9 = com.huawei.hms.scankit.p.b8.c(r9)     // Catch: java.lang.Exception -> L95
            int r1 = a(r4, r5, r0, r9)
            boolean r1 = a(r1, r9, r8)
            if (r1 == 0) goto L8d
            goto L9b
        L8d:
            com.huawei.hms.hmsscankit.WriterException r7 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r8 = "Data too big for requested version"
            r7.<init>(r8)
            throw r7
        L95:
            r7 = move-exception
            throw r7
        L97:
            com.huawei.hms.scankit.p.b8 r9 = a(r8, r4, r5, r0)
        L9b:
            com.huawei.hms.scankit.p.r r1 = new com.huawei.hms.scankit.p.r
            r1.<init>()
            r1.a(r5)
            if (r4 != r6) goto Laa
            int r7 = r0.f()
            goto Lae
        Laa:
            int r7 = r7.length()
        Lae:
            a(r7, r9, r4, r1)
            r1.a(r0)
            com.huawei.hms.scankit.p.b8$b r7 = r9.a(r8)
            int r0 = r9.e()
            int r2 = r7.d()
            int r0 = r0 - r2
            a(r0, r1)
            int r2 = r9.e()
            int r7 = r7.c()
            com.huawei.hms.scankit.p.r r7 = a(r1, r2, r0, r7)
            com.huawei.hms.scankit.p.h6 r0 = new com.huawei.hms.scankit.p.h6
            r0.<init>()
            r0.a(r8)
            r0.a(r4)
            r0.a(r9)
            int r1 = r9.d()
            com.huawei.hms.scankit.p.c0 r2 = new com.huawei.hms.scankit.p.c0
            r2.<init>(r1, r1)
            int r1 = a(r7, r8, r9, r2)
            r0.b(r1)
            com.huawei.hms.scankit.p.t4.a(r7, r8, r9, r1, r2)
            r0.a(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w2.a(java.lang.String, com.huawei.hms.scankit.p.b3, java.util.Map):com.huawei.hms.scankit.p.h6");
    }

    private static b8 a(b3 b3Var, u4 u4Var, r rVar, r rVar2) throws WriterException {
        return a(a(u4Var, rVar, rVar2, a(a(u4Var, rVar, rVar2, b8.c(1)), b3Var)), b3Var);
    }

    private static int a(u4 u4Var, r rVar, r rVar2, b8 b8Var) {
        return rVar.e() + u4Var.a(b8Var) + rVar2.e();
    }

    public static int a(int i10) {
        int[] iArr = f31647a;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    private static u4 a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && a(str)) {
            return u4.KANJI;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt >= '0' && charAt <= '9') {
                z11 = true;
            } else {
                if (a(charAt) == -1) {
                    return u4.BYTE;
                }
                z10 = true;
            }
        }
        if (z10) {
            return u4.ALPHANUMERIC;
        }
        if (z11) {
            return u4.NUMERIC;
        }
        return u4.BYTE;
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i10 = 0; i10 < length; i10 += 2) {
                int i11 = bytes[i10] & 255;
                if ((i11 < 129 || i11 > 159) && (i11 < 224 || i11 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(r rVar, b3 b3Var, b8 b8Var, c0 c0Var) throws WriterException {
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12++) {
            t4.a(rVar, b3Var, b8Var, i12, c0Var);
            int a10 = a(c0Var);
            if (a10 < i10) {
                i11 = i12;
                i10 = a10;
            }
        }
        return i11;
    }

    private static b8 a(int i10, b3 b3Var) throws WriterException {
        for (int i11 = 1; i11 <= 40; i11++) {
            b8 c4 = b8.c(i11);
            if (a(i10, c4, b3Var)) {
                return c4;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean a(int i10, b8 b8Var, b3 b3Var) {
        return b8Var.e() - b8Var.a(b3Var).d() >= (i10 + 7) / 8;
    }

    public static void a(int i10, r rVar) throws WriterException {
        int i11 = i10 * 8;
        if (rVar.e() <= i11) {
            for (int i12 = 0; i12 < 4 && rVar.e() < i11; i12++) {
                rVar.a(false);
            }
            int e2 = rVar.e() & 7;
            if (e2 > 0) {
                while (e2 < 8) {
                    rVar.a(false);
                    e2++;
                }
            }
            int f10 = i10 - rVar.f();
            for (int i13 = 0; i13 < f10; i13++) {
                rVar.a((i13 & 1) == 0 ? 236 : 17, 8);
            }
            if (rVar.e() != i11) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + rVar.e() + " > " + i11);
    }

    public static void a(int i10, int i11, int i12, int i13, int[] iArr, int[] iArr2) throws WriterException {
        if (i13 < i12) {
            int i14 = i10 % i12;
            int i15 = i12 - i14;
            int i16 = i10 / i12;
            int i17 = i16 + 1;
            int i18 = i11 / i12;
            int i19 = i18 + 1;
            int i20 = i16 - i18;
            int i21 = i17 - i19;
            if (i20 != i21) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i12 != i15 + i14) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i10 != ((i18 + i20) * i15) + ((i19 + i21) * i14)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i13 < i15) {
                iArr[0] = i18;
                iArr2[0] = i20;
                return;
            } else {
                iArr[0] = i19;
                iArr2[0] = i21;
                return;
            }
        }
        throw new WriterException("Block ID too large");
    }

    public static r a(r rVar, int i10, int i11, int i12) throws WriterException {
        if (rVar.f() == i11) {
            ArrayList arrayList = new ArrayList(i12);
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < i12; i16++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                a(i10, i11, i12, i16, iArr, iArr2);
                int i17 = iArr[0];
                byte[] bArr = new byte[i17];
                rVar.a(i13 * 8, bArr, 0, i17);
                byte[] a10 = a(bArr, iArr2[0]);
                arrayList.add(new y(bArr, a10));
                i15 = Math.max(i15, i17);
                i14 = Math.max(i14, a10.length);
                i13 += iArr[0];
            }
            if (i11 == i13) {
                r rVar2 = new r();
                for (int i18 = 0; i18 < i15; i18++) {
                    Iterator<E> iterator2 = arrayList.iterator2();
                    while (iterator2.hasNext()) {
                        byte[] a11 = ((y) iterator2.next()).a();
                        if (i18 < a11.length) {
                            rVar2.a(a11[i18], 8);
                        }
                    }
                }
                for (int i19 = 0; i19 < i14; i19++) {
                    Iterator<E> iterator22 = arrayList.iterator2();
                    while (iterator22.hasNext()) {
                        byte[] b4 = ((y) iterator22.next()).b();
                        if (i19 < b4.length) {
                            rVar2.a(b4[i19], 8);
                        }
                    }
                }
                if (i10 == rVar2.f()) {
                    return rVar2;
                }
                throw new WriterException("Interleaving error: " + i10 + " and " + rVar2.f() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    public static byte[] a(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length + i10];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        new q6(o3.f31365l).a(iArr, i10);
        byte[] bArr2 = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = (byte) iArr[length + i12];
        }
        return bArr2;
    }

    public static void a(u4 u4Var, r rVar) {
        rVar.a(u4Var.a(), 4);
    }

    public static void a(int i10, b8 b8Var, u4 u4Var, r rVar) throws WriterException {
        int a10 = u4Var.a(b8Var);
        int i11 = 1 << a10;
        if (i10 < i11) {
            rVar.a(i10, a10);
            return;
        }
        throw new WriterException(i10 + " is bigger than " + (i11 - 1));
    }

    public static void a(String str, u4 u4Var, r rVar, String str2) throws WriterException {
        int i10 = a.f31648a[u4Var.ordinal()];
        if (i10 == 1) {
            b(str, rVar);
            return;
        }
        if (i10 == 2) {
            a((CharSequence) str, rVar);
            return;
        }
        if (i10 == 3) {
            a(str, rVar, str2);
        } else {
            if (i10 == 4) {
                a(str, rVar);
                return;
            }
            throw new WriterException("Invalid mode: " + ((Object) u4Var));
        }
    }

    public static void a(CharSequence charSequence, r rVar) throws WriterException {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int a10 = a(charSequence.charAt(i10));
            if (a10 == -1) {
                throw new WriterException();
            }
            int i11 = i10 + 1;
            if (i11 < length) {
                int a11 = a(charSequence.charAt(i11));
                if (a11 != -1) {
                    rVar.a((a10 * 45) + a11, 11);
                    i10 += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                rVar.a(a10, 6);
                i10 = i11;
            }
        }
    }

    public static void a(String str, r rVar, String str2) throws WriterException {
        try {
            for (byte b4 : str.getBytes(str2)) {
                rVar.a(b4, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[LOOP:0: B:4:0x0008->B:11:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r6, com.huawei.hms.scankit.p.r r7) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L4d
            int r0 = r6.length
            r1 = 0
        L8:
            if (r1 >= r0) goto L4c
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L24
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L24
        L22:
            int r2 = r2 - r3
            goto L33
        L24:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L32
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L32
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L22
        L32:
            r2 = -1
        L33:
            if (r2 == r4) goto L44
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.a(r3, r2)
            int r1 = r1 + 2
            goto L8
        L44:
            com.huawei.hms.hmsscankit.WriterException r6 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L4c:
            return
        L4d:
            r6 = move-exception
            com.huawei.hms.hmsscankit.WriterException r7 = new com.huawei.hms.hmsscankit.WriterException
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w2.a(java.lang.String, com.huawei.hms.scankit.p.r):void");
    }

    private static void a(o0 o0Var, r rVar) {
        rVar.a(u4.ECI.a(), 4);
        rVar.a(o0Var.a(), 8);
    }
}
