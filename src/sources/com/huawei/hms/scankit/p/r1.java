package com.huawei.hms.scankit.p;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class r1 {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f31444a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31445a;

        static {
            int[] iArr = new int[u4.values().length];
            f31445a = iArr;
            try {
                iArr[u4.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31445a[u4.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31445a[u4.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31445a[u4.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31445a[u4.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31445a[u4.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31445a[u4.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f31445a[u4.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f31445a[u4.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f31445a[u4.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static w1 a(byte[] bArr, b8 b8Var, b3 b3Var, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        u4 a10;
        int i10;
        int i11;
        w wVar = new w(bArr);
        StringBuilder sb2 = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int i12 = -1;
        int i13 = -1;
        int i14 = 0;
        while (true) {
            try {
                if (wVar.a() < 4) {
                    a10 = u4.TERMINATOR;
                } else {
                    a10 = u4.a(wVar.a(4));
                }
                u4 u4Var = a10;
                int[] iArr = {i14, i12, i13};
                a(u4Var, wVar, sb2, b8Var, iArr, null, arrayList, map);
                i14 = iArr[0] == 1 ? 1 : 0;
                i10 = iArr[1];
                i11 = iArr[2];
                if (u4Var == u4.TERMINATOR) {
                    break;
                }
                i12 = i10;
                i13 = i11;
            } catch (IllegalArgumentException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        return new w1(bArr, sb2.toString(), arrayList.isEmpty() ? null : arrayList, b3Var == null ? null : b3Var.toString(), i10, i11);
    }

    private static void b(w wVar, StringBuilder sb2, int i10) throws com.huawei.hms.scankit.p.a {
        if (i10 * 13 <= wVar.a()) {
            byte[] bArr = new byte[i10 * 2];
            int i11 = 0;
            while (i10 > 0) {
                int a10 = wVar.a(13);
                int i12 = (a10 % 192) | ((a10 / 192) << 8);
                int i13 = i12 + (i12 < 7936 ? 33088 : 49472);
                try {
                    if (w7.a(bArr, i11)) {
                        int i14 = i11 + 1;
                        if (w7.a(bArr, i14)) {
                            bArr[i11] = (byte) (i13 >> 8);
                            bArr[i14] = (byte) i13;
                            i11 += 2;
                            i10--;
                        }
                    }
                    throw new ArrayIndexOutOfBoundsException();
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw e2;
                }
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

    private static void a(u4 u4Var, w wVar, StringBuilder sb2, b8 b8Var, int[] iArr, o0 o0Var, List<byte[]> list, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        int[] iArr2 = a.f31445a;
        switch (iArr2[u4Var.ordinal()]) {
            case 5:
                return;
            case 6:
            case 7:
                iArr[0] = 1;
                return;
            case 8:
                if (wVar.a() >= 16) {
                    iArr[1] = wVar.a(8);
                    iArr[2] = wVar.a(8);
                    return;
                }
                throw com.huawei.hms.scankit.p.a.a();
            case 9:
                if (o0.a(a(wVar)) == null) {
                    throw com.huawei.hms.scankit.p.a.a();
                }
                return;
            case 10:
                int a10 = wVar.a(4);
                int a11 = wVar.a(u4Var.a(b8Var));
                if (a10 == 1) {
                    a(wVar, sb2, a11);
                    return;
                }
                return;
            default:
                int a12 = wVar.a(u4Var.a(b8Var));
                int i10 = iArr2[u4Var.ordinal()];
                if (i10 == 1) {
                    c(wVar, sb2, a12);
                    return;
                }
                if (i10 == 2) {
                    a(wVar, sb2, a12, iArr[0] == 1);
                    return;
                } else if (i10 == 3) {
                    a(wVar, sb2, a12, o0Var, list, map);
                    return;
                } else {
                    if (i10 == 4) {
                        b(wVar, sb2, a12);
                        return;
                    }
                    throw com.huawei.hms.scankit.p.a.a();
                }
        }
    }

    private static void a(w wVar, StringBuilder sb2, int i10) throws com.huawei.hms.scankit.p.a {
        if (i10 * 13 <= wVar.a()) {
            byte[] bArr = new byte[i10 * 2];
            int i11 = 0;
            while (i10 > 0) {
                int a10 = wVar.a(13);
                int i12 = (a10 % 96) | ((a10 / 96) << 8);
                int i13 = i12 + (i12 < 959 ? 41377 : 42657);
                try {
                    if (w7.a(bArr, i11)) {
                        int i14 = i11 + 1;
                        if (w7.a(bArr, i14)) {
                            bArr[i11] = (byte) ((i13 >> 8) & 255);
                            bArr[i14] = (byte) (i13 & 255);
                            i11 += 2;
                            i10--;
                        }
                    }
                    throw new ArrayIndexOutOfBoundsException();
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw e2;
                }
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

    private static void a(w wVar, StringBuilder sb2, int i10, o0 o0Var, Collection<byte[]> collection, Map<l1, ?> map) throws com.huawei.hms.scankit.p.a {
        String name;
        if (i10 * 8 <= wVar.a()) {
            byte[] bArr = new byte[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                bArr[i11] = (byte) wVar.a(8);
            }
            if (o0Var == null) {
                name = c7.a(bArr, map);
            } else {
                name = o0Var.name();
            }
            try {
                sb2.append(new String(bArr, name));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private static char a(int i10) throws com.huawei.hms.scankit.p.a {
        char[] cArr = f31444a;
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

    private static int a(w wVar) throws com.huawei.hms.scankit.p.a {
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
}
