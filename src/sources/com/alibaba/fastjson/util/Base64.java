package com.alibaba.fastjson.util;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Base64 {
    public static final char[] CA;
    public static final int[] IA;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i10 = 0; i10 < length; i10++) {
            IA[CA[i10]] = i10;
        }
        IA[61] = 0;
    }

    public static byte[] decodeFast(char[] cArr, int i10, int i11) {
        int i12;
        int i13 = 0;
        if (i11 == 0) {
            return new byte[0];
        }
        int i14 = (i10 + i11) - 1;
        while (i10 < i14 && IA[cArr[i10]] < 0) {
            i10++;
        }
        while (i14 > 0 && IA[cArr[i14]] < 0) {
            i14--;
        }
        int i15 = cArr[i14] == '=' ? cArr[i14 + (-1)] == '=' ? 2 : 1 : 0;
        int i16 = (i14 - i10) + 1;
        if (i11 > 76) {
            i12 = (cArr[76] == '\r' ? i16 / 78 : 0) << 1;
        } else {
            i12 = 0;
        }
        int i17 = (((i16 - i12) * 6) >> 3) - i15;
        byte[] bArr = new byte[i17];
        int i18 = (i17 / 3) * 3;
        int i19 = 0;
        int i20 = 0;
        while (i19 < i18) {
            int[] iArr = IA;
            int i21 = i10 + 1;
            int i22 = i21 + 1;
            int i23 = (iArr[cArr[i10]] << 18) | (iArr[cArr[i21]] << 12);
            int i24 = i22 + 1;
            int i25 = i23 | (iArr[cArr[i22]] << 6);
            int i26 = i24 + 1;
            int i27 = i25 | iArr[cArr[i24]];
            int i28 = i19 + 1;
            bArr[i19] = (byte) (i27 >> 16);
            int i29 = i28 + 1;
            bArr[i28] = (byte) (i27 >> 8);
            int i30 = i29 + 1;
            bArr[i29] = (byte) i27;
            if (i12 <= 0 || (i20 = i20 + 1) != 19) {
                i10 = i26;
            } else {
                i10 = i26 + 2;
                i20 = 0;
            }
            i19 = i30;
        }
        if (i19 < i17) {
            int i31 = 0;
            while (i10 <= i14 - i15) {
                i13 |= IA[cArr[i10]] << (18 - (i31 * 6));
                i31++;
                i10++;
            }
            int i32 = 16;
            while (i19 < i17) {
                bArr[i19] = (byte) (i13 >> i32);
                i32 -= 8;
                i19++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str, int i10, int i11) {
        int i12;
        int i13 = 0;
        if (i11 == 0) {
            return new byte[0];
        }
        int i14 = (i10 + i11) - 1;
        while (i10 < i14 && IA[str.charAt(i10)] < 0) {
            i10++;
        }
        while (i14 > 0 && IA[str.charAt(i14)] < 0) {
            i14--;
        }
        int i15 = str.charAt(i14) == '=' ? str.charAt(i14 + (-1)) == '=' ? 2 : 1 : 0;
        int i16 = (i14 - i10) + 1;
        if (i11 > 76) {
            i12 = (str.charAt(76) == '\r' ? i16 / 78 : 0) << 1;
        } else {
            i12 = 0;
        }
        int i17 = (((i16 - i12) * 6) >> 3) - i15;
        byte[] bArr = new byte[i17];
        int i18 = (i17 / 3) * 3;
        int i19 = 0;
        int i20 = 0;
        while (i19 < i18) {
            int[] iArr = IA;
            int i21 = i10 + 1;
            int i22 = i21 + 1;
            int i23 = (iArr[str.charAt(i10)] << 18) | (iArr[str.charAt(i21)] << 12);
            int i24 = i22 + 1;
            int i25 = i23 | (iArr[str.charAt(i22)] << 6);
            int i26 = i24 + 1;
            int i27 = i25 | iArr[str.charAt(i24)];
            int i28 = i19 + 1;
            bArr[i19] = (byte) (i27 >> 16);
            int i29 = i28 + 1;
            bArr[i28] = (byte) (i27 >> 8);
            int i30 = i29 + 1;
            bArr[i29] = (byte) i27;
            if (i12 <= 0 || (i20 = i20 + 1) != 19) {
                i10 = i26;
            } else {
                i10 = i26 + 2;
                i20 = 0;
            }
            i19 = i30;
        }
        if (i19 < i17) {
            int i31 = 0;
            while (i10 <= i14 - i15) {
                i13 |= IA[str.charAt(i10)] << (18 - (i31 * 6));
                i31++;
                i10++;
            }
            int i32 = 16;
            while (i19 < i17) {
                bArr[i19] = (byte) (i13 >> i32);
                i32 -= 8;
                i19++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str) {
        int i10;
        int length = str.length();
        int i11 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i12 = length - 1;
        int i13 = 0;
        while (i13 < i12 && IA[str.charAt(i13) & 255] < 0) {
            i13++;
        }
        while (i12 > 0 && IA[str.charAt(i12) & 255] < 0) {
            i12--;
        }
        int i14 = str.charAt(i12) == '=' ? str.charAt(i12 + (-1)) == '=' ? 2 : 1 : 0;
        int i15 = (i12 - i13) + 1;
        if (length > 76) {
            i10 = (str.charAt(76) == '\r' ? i15 / 78 : 0) << 1;
        } else {
            i10 = 0;
        }
        int i16 = (((i15 - i10) * 6) >> 3) - i14;
        byte[] bArr = new byte[i16];
        int i17 = (i16 / 3) * 3;
        int i18 = 0;
        int i19 = 0;
        while (i18 < i17) {
            int[] iArr = IA;
            int i20 = i13 + 1;
            int i21 = i20 + 1;
            int i22 = (iArr[str.charAt(i13)] << 18) | (iArr[str.charAt(i20)] << 12);
            int i23 = i21 + 1;
            int i24 = i22 | (iArr[str.charAt(i21)] << 6);
            int i25 = i23 + 1;
            int i26 = i24 | iArr[str.charAt(i23)];
            int i27 = i18 + 1;
            bArr[i18] = (byte) (i26 >> 16);
            int i28 = i27 + 1;
            bArr[i27] = (byte) (i26 >> 8);
            int i29 = i28 + 1;
            bArr[i28] = (byte) i26;
            if (i10 <= 0 || (i19 = i19 + 1) != 19) {
                i13 = i25;
            } else {
                i13 = i25 + 2;
                i19 = 0;
            }
            i18 = i29;
        }
        if (i18 < i16) {
            int i30 = 0;
            while (i13 <= i12 - i14) {
                i11 |= IA[str.charAt(i13)] << (18 - (i30 * 6));
                i30++;
                i13++;
            }
            int i31 = 16;
            while (i18 < i16) {
                bArr[i18] = (byte) (i11 >> i31);
                i31 -= 8;
                i18++;
            }
        }
        return bArr;
    }
}
