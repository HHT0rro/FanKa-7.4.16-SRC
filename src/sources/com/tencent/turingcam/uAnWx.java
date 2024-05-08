package com.tencent.turingcam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class uAnWx {
    private static void a(byte[] bArr, int[] iArr) {
        int length = bArr.length >> 2;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i11 + 1;
            iArr[i10] = bArr[i11] & 255;
            int i13 = i12 + 1;
            iArr[i10] = iArr[i10] | ((bArr[i12] & 255) << 8);
            int i14 = i13 + 1;
            iArr[i10] = iArr[i10] | ((bArr[i13] & 255) << 16);
            iArr[i10] = iArr[i10] | ((bArr[i14] & 255) << 24);
            i10++;
            i11 = i14 + 1;
        }
        if (i11 < bArr.length) {
            int i15 = i11 + 1;
            iArr[i10] = bArr[i11] & 255;
            int i16 = 8;
            while (i15 < bArr.length) {
                iArr[i10] = iArr[i10] | ((bArr[i15] & 255) << i16);
                i15++;
                i16 += 8;
            }
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr2;
        if (bArr3 != null && bArr3.length > 16) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr3);
                bArr3 = messageDigest.digest();
            } catch (NoSuchAlgorithmException unused) {
                bArr3 = null;
            }
        }
        if (bArr == null || bArr3 == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr.length % 4 == 0) {
            int i10 = 8;
            if (bArr.length >= 8) {
                int length = bArr.length >>> 2;
                int[] iArr = new int[length];
                a(bArr, iArr);
                int length2 = bArr3.length % 4 == 0 ? bArr3.length >>> 2 : (bArr3.length >>> 2) + 1;
                int i11 = length2 >= 4 ? length2 : 4;
                int[] iArr2 = new int[i11];
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    iArr2[i13] = 0;
                }
                a(bArr3, iArr2);
                int i14 = length - 1;
                int i15 = iArr[i14];
                int i16 = iArr[0];
                for (int i17 = ((52 / (i14 + 1)) + 6) * (-1640531527); i17 != 0; i17 -= -1640531527) {
                    int i18 = (i17 >>> 2) & 3;
                    int i19 = i14;
                    while (i19 > 0) {
                        int i20 = iArr[i19 - 1];
                        i16 = iArr[i19] - (((i16 ^ i17) + (i20 ^ iArr2[(i19 & 3) ^ i18])) ^ (((i20 >>> 5) ^ (i16 << 2)) + ((i16 >>> 3) ^ (i20 << 4))));
                        iArr[i19] = i16;
                        i19--;
                    }
                    int i21 = iArr[i14];
                    i16 = iArr[0] - (((i16 ^ i17) + (iArr2[i18 ^ (i19 & 3)] ^ i21)) ^ (((i21 >>> 5) ^ (i16 << 2)) + ((i16 >>> 3) ^ (i21 << 4))));
                    iArr[0] = i16;
                }
                int i22 = iArr[i14];
                if (i22 >= 0 && i22 <= (i14 << 2)) {
                    byte[] bArr4 = new byte[i22];
                    int i23 = i22 >> 2;
                    if (i23 > i14) {
                        i23 = i14;
                    }
                    int i24 = 0;
                    while (i12 < i23) {
                        int i25 = i24 + 1;
                        bArr4[i24] = (byte) (iArr[i12] & 255);
                        int i26 = i25 + 1;
                        bArr4[i25] = (byte) ((iArr[i12] >>> 8) & 255);
                        int i27 = i26 + 1;
                        bArr4[i26] = (byte) ((iArr[i12] >>> 16) & 255);
                        i24 = i27 + 1;
                        bArr4[i27] = (byte) ((iArr[i12] >>> 24) & 255);
                        i12++;
                    }
                    if (i14 > i23 && i24 < i22) {
                        bArr4[i24] = (byte) (iArr[i12] & 255);
                        for (int i28 = i24 + 1; i10 <= 24 && i28 < i22; i28++) {
                            bArr4[i28] = (byte) ((iArr[i12] >>> i10) & 255);
                            i10 += 8;
                        }
                    }
                    return bArr4;
                }
            }
        }
        return null;
    }
}
