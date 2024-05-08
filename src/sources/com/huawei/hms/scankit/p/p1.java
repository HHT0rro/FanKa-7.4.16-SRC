package com.huawei.hms.scankit.p;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class p1 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f31391a = "0123456789abcdefghijklmnopqrstuvwxyz !-./:=?T".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f31392b = "0123456789ABCDEF".toCharArray();

    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31393a;

        static {
            int[] iArr = new int[v4.values().length];
            f31393a = iArr;
            try {
                iArr[v4.TERMINATOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31393a[v4.FNC1_FIRST_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31393a[v4.FNC1_SECOND_POSITION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31393a[v4.STRUCTURED_APPEND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31393a[v4.ECI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31393a[v4.HANZI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31393a[v4.NUMERIC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f31393a[v4.ALPHANUMERIC.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f31393a[v4.HEXADECIMAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f31393a[v4.HEXABYTE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f31393a[v4.BYTE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f31393a[v4.KANJI.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0035. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0099 A[LOOP:0: B:2:0x001b->B:13:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.scankit.p.w1 a(byte[] r15, com.huawei.hms.scankit.p.a8 r16, com.huawei.hms.scankit.p.c3 r17, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r18) throws com.huawei.hms.scankit.p.a {
        /*
            r0 = r16
            com.huawei.hms.scankit.p.w r1 = new com.huawei.hms.scankit.p.w
            r3 = r15
            r1.<init>(r15)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 50
            r2.<init>(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 1
            r4.<init>(r5)
            r6 = -1
            r7 = 0
            r8 = 0
            r10 = r7
            r8 = -1
            r9 = 0
        L1b:
            int r11 = r1.a()     // Catch: java.lang.IllegalArgumentException -> L9f
            r12 = 4
            if (r11 >= r12) goto L25
            com.huawei.hms.scankit.p.v4 r11 = com.huawei.hms.scankit.p.v4.TERMINATOR     // Catch: java.lang.IllegalArgumentException -> L9f
            goto L2d
        L25:
            int r11 = r1.a(r12)     // Catch: java.lang.IllegalArgumentException -> L9f
            com.huawei.hms.scankit.p.v4 r11 = com.huawei.hms.scankit.p.v4.a(r11)     // Catch: java.lang.IllegalArgumentException -> L9f
        L2d:
            int[] r12 = com.huawei.hms.scankit.p.p1.a.f31393a     // Catch: java.lang.IllegalArgumentException -> L9f
            int r13 = r11.ordinal()     // Catch: java.lang.IllegalArgumentException -> L9f
            r12 = r12[r13]     // Catch: java.lang.IllegalArgumentException -> L9f
            switch(r12) {
                case 1: goto L47;
                case 2: goto L67;
                case 3: goto L67;
                case 4: goto L4a;
                case 5: goto L43;
                case 6: goto L3f;
                default: goto L38;
            }     // Catch: java.lang.IllegalArgumentException -> L9f
        L38:
            r12 = r18
            com.huawei.hms.scankit.p.z0 r13 = a(r0, r12, r1, r2)     // Catch: java.lang.IllegalArgumentException -> L9f
            goto L6d
        L3f:
            a(r0, r1, r2, r11)     // Catch: java.lang.IllegalArgumentException -> L9f
            goto L47
        L43:
            com.huawei.hms.scankit.p.o0 r10 = a(r1)     // Catch: java.lang.IllegalArgumentException -> L9f
        L47:
            r12 = r18
            goto L70
        L4a:
            int r6 = r1.a()     // Catch: java.lang.IllegalArgumentException -> L9f
            r8 = 16
            if (r6 < r8) goto L62
            r6 = 8
            int r8 = r1.a(r6)     // Catch: java.lang.IllegalArgumentException -> L9f
            int r6 = r1.a(r6)     // Catch: java.lang.IllegalArgumentException -> L9f
            r12 = r18
            r14 = r9
            r9 = r6
            r6 = r14
            goto L74
        L62:
            com.huawei.hms.scankit.p.a r0 = com.huawei.hms.scankit.p.a.a()     // Catch: java.lang.IllegalArgumentException -> L9f
            throw r0     // Catch: java.lang.IllegalArgumentException -> L9f
        L67:
            r12 = r18
            r9 = r8
            r8 = r6
            r6 = 1
            goto L74
        L6d:
            a(r13, r4, r10, r9, r11)     // Catch: java.lang.IllegalArgumentException -> L9f
        L70:
            r14 = r8
            r8 = r6
            r6 = r9
            r9 = r14
        L74:
            com.huawei.hms.scankit.p.v4 r13 = com.huawei.hms.scankit.p.v4.TERMINATOR     // Catch: java.lang.IllegalArgumentException -> L9f
            if (r11 != r13) goto L99
            com.huawei.hms.scankit.p.w1 r0 = new com.huawei.hms.scankit.p.w1
            java.lang.String r1 = r2.toString()
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L86
            r5 = r7
            goto L87
        L86:
            r5 = r4
        L87:
            if (r17 != 0) goto L8b
            r6 = r7
            goto L90
        L8b:
            java.lang.String r2 = r17.toString()
            r6 = r2
        L90:
            r2 = r0
            r3 = r15
            r4 = r1
            r7 = r8
            r8 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L99:
            r14 = r9
            r9 = r6
            r6 = r8
            r8 = r14
            goto L1b
        L9f:
            com.huawei.hms.scankit.p.a r0 = com.huawei.hms.scankit.p.a.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.p1.a(byte[], com.huawei.hms.scankit.p.a8, com.huawei.hms.scankit.p.c3, java.util.Map):com.huawei.hms.scankit.p.w1");
    }

    private static void b(w wVar, StringBuilder sb2, int i10) throws com.huawei.hms.scankit.p.a {
        if (i10 * 13 <= wVar.a()) {
            byte[] bArr = new byte[i10 * 2];
            int i11 = 0;
            while (i10 > 0) {
                int a10 = wVar.a(13);
                int i12 = (a10 % 192) | ((a10 / 192) << 8);
                int i13 = i12 + (i12 < 7936 ? 33088 : 49472);
                bArr[i11] = (byte) (i13 >> 8);
                bArr[i11 + 1] = (byte) i13;
                i11 += 2;
                i10--;
            }
            try {
                sb2.append(new String(bArr, "SJIS"));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static void c(w wVar, StringBuilder sb2, int i10, boolean z10) throws com.huawei.hms.scankit.p.a {
        while (i10 > 1) {
            if (wVar.a() >= 8) {
                int a10 = wVar.a(8);
                sb2.append(b(a10 / 16));
                sb2.append(b(a10 % 16));
                i10 -= 2;
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (i10 == 1) {
            if (wVar.a() >= 4) {
                sb2.append(b(wVar.a(4)));
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (z10) {
            for (int length = sb2.length(); length < sb2.length(); length++) {
                if (sb2.charAt(length) == '%') {
                    if (length < sb2.length() - 1) {
                        int i11 = length + 1;
                        if (sb2.charAt(i11) == '%') {
                            sb2.deleteCharAt(i11);
                        }
                    }
                    sb2.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static char b(int i10) throws com.huawei.hms.scankit.p.a {
        char[] cArr = f31392b;
        if (i10 < cArr.length) {
            return cArr[i10];
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static void b(w wVar, StringBuilder sb2, int i10, boolean z10) throws com.huawei.hms.scankit.p.a {
        while (i10 > 1) {
            if (wVar.a() >= 8) {
                int a10 = wVar.a(8);
                sb2.append(b(a10 / 16));
                sb2.append(b(a10 % 16));
                i10 -= 2;
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (i10 == 1) {
            if (wVar.a() >= 4) {
                sb2.append(b(wVar.a(4)));
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (z10) {
            for (int length = sb2.length(); length < sb2.length(); length++) {
                if (sb2.charAt(length) == '%') {
                    if (length < sb2.length() - 1) {
                        int i11 = length + 1;
                        if (sb2.charAt(i11) == '%') {
                            sb2.deleteCharAt(i11);
                        }
                    }
                    sb2.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static void c(w wVar, StringBuilder sb2, int i10) throws com.huawei.hms.scankit.p.a {
        while (i10 >= 3) {
            if (wVar.a() >= 10) {
                int a10 = wVar.a(10);
                if (a10 < 1000) {
                    sb2.append(a(a10 / 100));
                    sb2.append(a((a10 / 10) % 10));
                    sb2.append(a(a10 % 10));
                    i10 -= 3;
                } else {
                    throw com.huawei.hms.scankit.p.a.a();
                }
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (i10 == 2) {
            if (wVar.a() >= 7) {
                int a11 = wVar.a(7);
                if (a11 < 100) {
                    sb2.append(a(a11 / 10));
                    sb2.append(a(a11 % 10));
                    return;
                }
                throw com.huawei.hms.scankit.p.a.a();
            }
            throw com.huawei.hms.scankit.p.a.a();
        }
        if (i10 == 1) {
            if (wVar.a() >= 4) {
                int a12 = wVar.a(4);
                if (a12 < 10) {
                    sb2.append(a(a12));
                    return;
                }
                throw com.huawei.hms.scankit.p.a.a();
            }
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static z0 a(a8 a8Var, Map<l1, ?> map, w wVar, StringBuilder sb2) {
        return new z0(a8Var, map, wVar, sb2);
    }

    private static void a(z0 z0Var, List<byte[]> list, o0 o0Var, boolean z10, v4 v4Var) throws com.huawei.hms.scankit.p.a {
        a(new h7(z0Var.f31775b, z0Var.f31776c, z0Var.f31777d, list), o0Var, z10, v4Var, z0Var.f31776c.a(v4Var.a(z0Var.f31774a)));
    }

    private static o0 a(w wVar) throws com.huawei.hms.scankit.p.a {
        o0 a10 = o0.a(b(wVar));
        a(a10);
        return a10;
    }

    private static int b(w wVar) throws com.huawei.hms.scankit.p.a {
        int a10 = wVar.a(8);
        if ((a10 & 128) == 0) {
            return a10 & 127;
        }
        if ((a10 & 192) == 128) {
            return wVar.a(8) | ((a10 & 63) << 8);
        }
        if ((a10 & 224) == 192) {
            return wVar.a(16) | ((a10 & 31) << 16);
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static void a(o0 o0Var) throws com.huawei.hms.scankit.p.a {
        if (o0Var == null) {
            throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static void a(a8 a8Var, w wVar, StringBuilder sb2, v4 v4Var) throws com.huawei.hms.scankit.p.a {
        int a10 = wVar.a(4);
        int a11 = wVar.a(v4Var.a(a8Var));
        if (a10 == 1) {
            a(wVar, sb2, a11);
        }
    }

    private static void a(h7 h7Var, o0 o0Var, boolean z10, v4 v4Var, int i10) throws com.huawei.hms.scankit.p.a {
        switch (a.f31393a[v4Var.ordinal()]) {
            case 7:
                c(h7Var.f31066b, h7Var.f31067c, i10);
                return;
            case 8:
                a(h7Var.f31066b, h7Var.f31067c, i10, z10);
                return;
            case 9:
                c(h7Var.f31066b, h7Var.f31067c, i10, z10);
                return;
            case 10:
                b(h7Var.f31066b, h7Var.f31067c, i10, z10);
                return;
            case 11:
                a(new b0(h7Var.f31066b, h7Var.f31067c), i10, o0Var, h7Var.f31068d, h7Var.f31065a);
                return;
            case 12:
                b(h7Var.f31066b, h7Var.f31067c, i10);
                return;
            default:
                throw com.huawei.hms.scankit.p.a.a();
        }
    }

    private static void a(w wVar, StringBuilder sb2, int i10) throws com.huawei.hms.scankit.p.a {
        if (i10 * 13 <= wVar.a()) {
            byte[] bArr = new byte[i10 * 2];
            int i11 = 0;
            while (i10 > 0) {
                int a10 = wVar.a(13);
                int i12 = (a10 % 96) | ((a10 / 96) << 8);
                int i13 = i12 + (i12 < 2560 ? 41377 : 42657);
                bArr[i11] = (byte) ((i13 >> 8) & 255);
                bArr[i11 + 1] = (byte) (i13 & 255);
                i11 += 2;
                i10--;
            }
            try {
                sb2.append(new String(bArr, "GB2312"));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static void a(b0 b0Var, int i10, o0 o0Var, Collection<byte[]> collection, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        String name;
        if (i10 * 8 <= b0Var.f30720a.a()) {
            byte[] bArr = new byte[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                bArr[i11] = (byte) b0Var.f30720a.a(8);
            }
            if (o0Var == null) {
                name = c7.a(bArr, map);
            } else {
                name = o0Var.name();
            }
            try {
                b0Var.f30721b.append(new String(bArr, name));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static char a(int i10) throws com.huawei.hms.scankit.p.a {
        char[] cArr = f31391a;
        if (i10 < cArr.length) {
            return cArr[i10];
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static void a(w wVar, StringBuilder sb2, int i10, boolean z10) throws com.huawei.hms.scankit.p.a {
        while (i10 > 1) {
            if (wVar.a() >= 11) {
                int a10 = wVar.a(11);
                sb2.append(a(a10 / 45));
                sb2.append(a(a10 % 45));
                i10 -= 2;
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (i10 == 1) {
            if (wVar.a() >= 6) {
                sb2.append(a(wVar.a(6)));
            } else {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (z10) {
            for (int length = sb2.length(); length < sb2.length(); length++) {
                if (sb2.charAt(length) == '%') {
                    if (length < sb2.length() - 1) {
                        int i11 = length + 1;
                        if (sb2.charAt(i11) == '%') {
                            sb2.deleteCharAt(i11);
                        }
                    }
                    sb2.setCharAt(length, (char) 29);
                }
            }
        }
    }
}
