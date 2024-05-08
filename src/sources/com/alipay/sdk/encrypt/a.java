package com.alipay.sdk.encrypt;

import okio.Utf8;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f4602a = 128;

    /* renamed from: b, reason: collision with root package name */
    private static final int f4603b = 64;

    /* renamed from: c, reason: collision with root package name */
    private static final int f4604c = 24;

    /* renamed from: d, reason: collision with root package name */
    private static final int f4605d = 8;

    /* renamed from: e, reason: collision with root package name */
    private static final int f4606e = 16;

    /* renamed from: f, reason: collision with root package name */
    private static final int f4607f = 4;

    /* renamed from: g, reason: collision with root package name */
    private static final int f4608g = -128;

    /* renamed from: h, reason: collision with root package name */
    private static final char f4609h = '=';

    /* renamed from: i, reason: collision with root package name */
    private static final byte[] f4610i = new byte[128];

    /* renamed from: j, reason: collision with root package name */
    private static final char[] f4611j = new char[64];

    static {
        int i10;
        int i11;
        int i12 = 0;
        for (int i13 = 0; i13 < 128; i13++) {
            f4610i[i13] = -1;
        }
        for (int i14 = 90; i14 >= 65; i14--) {
            f4610i[i14] = (byte) (i14 - 65);
        }
        int i15 = 122;
        while (true) {
            i10 = 26;
            if (i15 < 97) {
                break;
            }
            f4610i[i15] = (byte) ((i15 - 97) + 26);
            i15--;
        }
        int i16 = 57;
        while (true) {
            i11 = 52;
            if (i16 < 48) {
                break;
            }
            f4610i[i16] = (byte) ((i16 - 48) + 52);
            i16--;
        }
        byte[] bArr = f4610i;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i17 = 0; i17 <= 25; i17++) {
            f4611j[i17] = (char) (i17 + 65);
        }
        int i18 = 0;
        while (i10 <= 51) {
            f4611j[i10] = (char) (i18 + 97);
            i10++;
            i18++;
        }
        while (i11 <= 61) {
            f4611j[i11] = (char) (i12 + 48);
            i11++;
            i12++;
        }
        char[] cArr = f4611j;
        cArr[62] = '+';
        cArr[63] = IOUtils.DIR_SEPARATOR_UNIX;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i10 = length % 24;
        int i11 = length / 24;
        char[] cArr = new char[(i10 != 0 ? i11 + 1 : i11) * 4];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i11) {
            int i15 = i13 + 1;
            byte b4 = bArr[i13];
            int i16 = i15 + 1;
            byte b10 = bArr[i15];
            int i17 = i16 + 1;
            byte b11 = bArr[i16];
            byte b12 = (byte) (b10 & 15);
            byte b13 = (byte) (b4 & 3);
            int i18 = b4 & Byte.MIN_VALUE;
            int i19 = b4 >> 2;
            if (i18 != 0) {
                i19 ^= 192;
            }
            byte b14 = (byte) i19;
            int i20 = b10 & Byte.MIN_VALUE;
            int i21 = b10 >> 4;
            if (i20 != 0) {
                i21 ^= 240;
            }
            byte b15 = (byte) i21;
            int i22 = (b11 & Byte.MIN_VALUE) == 0 ? b11 >> 6 : (b11 >> 6) ^ 252;
            int i23 = i14 + 1;
            char[] cArr2 = f4611j;
            cArr[i14] = cArr2[b14];
            int i24 = i23 + 1;
            cArr[i23] = cArr2[(b13 << 4) | b15];
            int i25 = i24 + 1;
            cArr[i24] = cArr2[(b12 << 2) | ((byte) i22)];
            cArr[i25] = cArr2[b11 & Utf8.REPLACEMENT_BYTE];
            i12++;
            i14 = i25 + 1;
            i13 = i17;
        }
        if (i10 == 8) {
            byte b16 = bArr[i13];
            byte b17 = (byte) (b16 & 3);
            int i26 = b16 & Byte.MIN_VALUE;
            int i27 = b16 >> 2;
            if (i26 != 0) {
                i27 ^= 192;
            }
            int i28 = i14 + 1;
            char[] cArr3 = f4611j;
            cArr[i14] = cArr3[(byte) i27];
            int i29 = i28 + 1;
            cArr[i28] = cArr3[b17 << 4];
            cArr[i29] = f4609h;
            cArr[i29 + 1] = f4609h;
        } else if (i10 == 16) {
            byte b18 = bArr[i13];
            byte b19 = bArr[i13 + 1];
            byte b20 = (byte) (b19 & 15);
            byte b21 = (byte) (b18 & 3);
            int i30 = b18 & Byte.MIN_VALUE;
            int i31 = b18 >> 2;
            if (i30 != 0) {
                i31 ^= 192;
            }
            byte b22 = (byte) i31;
            int i32 = b19 & Byte.MIN_VALUE;
            int i33 = b19 >> 4;
            if (i32 != 0) {
                i33 ^= 240;
            }
            int i34 = i14 + 1;
            char[] cArr4 = f4611j;
            cArr[i14] = cArr4[b22];
            int i35 = i34 + 1;
            cArr[i34] = cArr4[((byte) i33) | (b21 << 4)];
            cArr[i35] = cArr4[b20 << 2];
            cArr[i35 + 1] = f4609h;
        }
        return new String(cArr);
    }

    private static boolean a(char c4) {
        return c4 == ' ' || c4 == '\r' || c4 == '\n' || c4 == '\t';
    }

    private static boolean b(char c4) {
        return c4 == '=';
    }

    private static boolean c(char c4) {
        return c4 < 128 && f4610i[c4] != -1;
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int a10 = a(charArray);
        if (a10 % 4 != 0) {
            return null;
        }
        int i10 = a10 / 4;
        if (i10 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10 * 3];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < i10 - 1) {
            int i14 = i12 + 1;
            char c4 = charArray[i12];
            if (c(c4)) {
                int i15 = i14 + 1;
                char c10 = charArray[i14];
                if (c(c10)) {
                    int i16 = i15 + 1;
                    char c11 = charArray[i15];
                    if (c(c11)) {
                        int i17 = i16 + 1;
                        char c12 = charArray[i16];
                        if (c(c12)) {
                            byte[] bArr2 = f4610i;
                            byte b4 = bArr2[c4];
                            byte b10 = bArr2[c10];
                            byte b11 = bArr2[c11];
                            byte b12 = bArr2[c12];
                            int i18 = i13 + 1;
                            bArr[i13] = (byte) ((b4 << 2) | (b10 >> 4));
                            int i19 = i18 + 1;
                            bArr[i18] = (byte) (((b10 & 15) << 4) | ((b11 >> 2) & 15));
                            i13 = i19 + 1;
                            bArr[i19] = (byte) ((b11 << 6) | b12);
                            i11++;
                            i12 = i17;
                        }
                    }
                }
            }
            return null;
        }
        int i20 = i12 + 1;
        char c13 = charArray[i12];
        if (!c(c13)) {
            return null;
        }
        int i21 = i20 + 1;
        char c14 = charArray[i20];
        if (!c(c14)) {
            return null;
        }
        byte[] bArr3 = f4610i;
        byte b13 = bArr3[c13];
        byte b14 = bArr3[c14];
        int i22 = i21 + 1;
        char c15 = charArray[i21];
        char c16 = charArray[i22];
        if (c(c15) && c(c16)) {
            byte b15 = bArr3[c15];
            byte b16 = bArr3[c16];
            int i23 = i13 + 1;
            bArr[i13] = (byte) ((b13 << 2) | (b14 >> 4));
            bArr[i23] = (byte) (((b14 & 15) << 4) | ((b15 >> 2) & 15));
            bArr[i23 + 1] = (byte) (b16 | (b15 << 6));
            return bArr;
        }
        if (b(c15) && b(c16)) {
            if ((b14 & 15) != 0) {
                return null;
            }
            int i24 = i11 * 3;
            byte[] bArr4 = new byte[i24 + 1];
            System.arraycopy((Object) bArr, 0, (Object) bArr4, 0, i24);
            bArr4[i13] = (byte) ((b13 << 2) | (b14 >> 4));
            return bArr4;
        }
        if (b(c15) || !b(c16)) {
            return null;
        }
        byte b17 = bArr3[c15];
        if ((b17 & 3) != 0) {
            return null;
        }
        int i25 = i11 * 3;
        byte[] bArr5 = new byte[i25 + 2];
        System.arraycopy((Object) bArr, 0, (Object) bArr5, 0, i25);
        bArr5[i13] = (byte) ((b13 << 2) | (b14 >> 4));
        bArr5[i13 + 1] = (byte) (((b17 >> 2) & 15) | ((b14 & 15) << 4));
        return bArr5;
    }

    private static int a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (!a(cArr[i11])) {
                cArr[i10] = cArr[i11];
                i10++;
            }
        }
        return i10;
    }
}
