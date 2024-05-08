package com.amap.api.col.s;

/* compiled from: XXTEA.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dp {

    /* renamed from: a, reason: collision with root package name */
    private static int f7692a = 4;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i10 = f7692a;
        int i11 = i10 - (length % i10);
        int i12 = ((length / i10) + 1) * i10;
        byte[] bArr3 = new byte[i12];
        System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, bArr.length);
        while (length < i12) {
            bArr3[length] = (byte) i11;
            length++;
        }
        int[] a10 = a(bArr3);
        int[] a11 = a(bArr2);
        int length2 = a10.length - 1;
        if (length2 > 0) {
            if (a11.length < 4) {
                int[] iArr = new int[4];
                System.arraycopy((Object) a11, 0, (Object) iArr, 0, a11.length);
                a11 = iArr;
            }
            int i13 = a10[length2];
            int i14 = (52 / (length2 + 1)) + 6;
            int i15 = 0;
            while (true) {
                int i16 = i14 - 1;
                if (i14 <= 0) {
                    break;
                }
                i15 -= 1640531527;
                int i17 = (i15 >>> 2) & 3;
                int i18 = 0;
                while (i18 < length2) {
                    int i19 = i18 + 1;
                    int i20 = a10[i19];
                    i13 = ((((i13 >>> 5) ^ (i20 << 2)) + ((i20 >>> 3) ^ (i13 << 4))) ^ ((i20 ^ i15) + (i13 ^ a11[(i18 & 3) ^ i17]))) + a10[i18];
                    a10[i18] = i13;
                    i18 = i19;
                }
                int i21 = a10[0];
                i13 = ((((i13 >>> 5) ^ (i21 << 2)) + ((i21 >>> 3) ^ (i13 << 4))) ^ ((i21 ^ i15) + (i13 ^ a11[i17 ^ (i18 & 3)]))) + a10[length2];
                a10[length2] = i13;
                i14 = i16;
            }
        }
        int length3 = a10.length << 2;
        byte[] bArr4 = new byte[length3];
        for (int i22 = 0; i22 < length3; i22++) {
            bArr4[i22] = (byte) ((a10[i22 >>> 2] >>> ((i22 & 3) << 3)) & 255);
        }
        return bArr4;
    }

    private static int[] a(byte[] bArr) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 >>> 2;
            iArr[i11] = iArr[i11] | ((bArr[i10] & 255) << ((i10 & 3) << 3));
        }
        return iArr;
    }
}
