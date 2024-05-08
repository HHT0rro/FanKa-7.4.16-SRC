package com.xiaomi.push;

import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f47963a = System.getProperty("line.separator");

    /* renamed from: b, reason: collision with root package name */
    public static char[] f47964b = new char[64];

    /* renamed from: c, reason: collision with root package name */
    public static byte[] f47965c;

    static {
        char c4 = 'A';
        int i10 = 0;
        while (c4 <= 'Z') {
            f47964b[i10] = c4;
            c4 = (char) (c4 + 1);
            i10++;
        }
        char c10 = 'a';
        while (c10 <= 'z') {
            f47964b[i10] = c10;
            c10 = (char) (c10 + 1);
            i10++;
        }
        char c11 = '0';
        while (c11 <= '9') {
            f47964b[i10] = c11;
            c11 = (char) (c11 + 1);
            i10++;
        }
        char[] cArr = f47964b;
        cArr[i10] = '+';
        cArr[i10 + 1] = IOUtils.DIR_SEPARATOR_UNIX;
        f47965c = new byte[128];
        int i11 = 0;
        while (true) {
            byte[] bArr = f47965c;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = -1;
            i11++;
        }
        for (int i12 = 0; i12 < 64; i12++) {
            f47965c[f47964b[i12]] = (byte) i12;
        }
    }

    public static String a(String str) {
        return new String(e(str.getBytes()));
    }

    public static byte[] b(String str) {
        return c(str.toCharArray());
    }

    public static byte[] c(char[] cArr) {
        return d(cArr, 0, cArr.length);
    }

    public static byte[] d(char[] cArr, int i10, int i11) {
        int i12;
        char c4;
        int i13;
        char c10;
        if (i11 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (i11 > 0 && cArr[(i10 + i11) - 1] == '=') {
            i11--;
        }
        int i14 = (i11 * 3) / 4;
        byte[] bArr = new byte[i14];
        int i15 = i11 + i10;
        int i16 = 0;
        while (i10 < i15) {
            int i17 = i10 + 1;
            char c11 = cArr[i10];
            int i18 = i17 + 1;
            char c12 = cArr[i17];
            if (i18 < i15) {
                i12 = i18 + 1;
                c4 = cArr[i18];
            } else {
                i12 = i18;
                c4 = 'A';
            }
            if (i12 < i15) {
                i13 = i12 + 1;
                c10 = cArr[i12];
            } else {
                i13 = i12;
                c10 = 'A';
            }
            if (c11 > 127 || c12 > 127 || c4 > 127 || c10 > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte[] bArr2 = f47965c;
            byte b4 = bArr2[c11];
            byte b10 = bArr2[c12];
            byte b11 = bArr2[c4];
            byte b12 = bArr2[c10];
            if (b4 < 0 || b10 < 0 || b11 < 0 || b12 < 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int i19 = (b4 << 2) | (b10 >>> 4);
            int i20 = ((b10 & 15) << 4) | (b11 >>> 2);
            int i21 = ((b11 & 3) << 6) | b12;
            int i22 = i16 + 1;
            bArr[i16] = (byte) i19;
            if (i22 < i14) {
                bArr[i22] = (byte) i20;
                i22++;
            }
            if (i22 < i14) {
                bArr[i22] = (byte) i21;
                i16 = i22 + 1;
            } else {
                i16 = i22;
            }
            i10 = i13;
        }
        return bArr;
    }

    public static char[] e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public static char[] f(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15 = ((i11 * 4) + 2) / 3;
        char[] cArr = new char[((i11 + 2) / 3) * 4];
        int i16 = i11 + i10;
        int i17 = 0;
        while (i10 < i16) {
            int i18 = i10 + 1;
            int i19 = bArr[i10] & 255;
            if (i18 < i16) {
                i12 = i18 + 1;
                i13 = bArr[i18] & 255;
            } else {
                i12 = i18;
                i13 = 0;
            }
            if (i12 < i16) {
                i14 = bArr[i12] & 255;
                i12++;
            } else {
                i14 = 0;
            }
            int i20 = i19 >>> 2;
            int i21 = ((i19 & 3) << 4) | (i13 >>> 4);
            int i22 = ((i13 & 15) << 2) | (i14 >>> 6);
            int i23 = i14 & 63;
            int i24 = i17 + 1;
            char[] cArr2 = f47964b;
            cArr[i17] = cArr2[i20];
            int i25 = i24 + 1;
            cArr[i24] = cArr2[i21];
            char c4 = '=';
            cArr[i25] = i25 < i15 ? cArr2[i22] : '=';
            int i26 = i25 + 1;
            if (i26 < i15) {
                c4 = cArr2[i23];
            }
            cArr[i26] = c4;
            i17 = i26 + 1;
            i10 = i12;
        }
        return cArr;
    }

    public static String g(String str) {
        return new String(b(str));
    }
}
