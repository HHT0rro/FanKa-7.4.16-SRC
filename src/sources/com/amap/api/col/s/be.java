package com.amap.api.col.s;

/* compiled from: XXTEA.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class be {

    /* renamed from: a, reason: collision with root package name */
    private static int f7144a = 4;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i10 = f7144a;
        int i11 = i10 - (length % i10);
        int i12 = ((length / i10) + 1) * i10;
        byte[] bArr3 = new byte[i12];
        System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, bArr.length);
        while (length < i12) {
            bArr3[length] = (byte) i11;
            length++;
        }
        return a(a(a(bArr3), a(bArr2)));
    }

    private static int[] a(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length <= 0) {
            return iArr;
        }
        if (iArr2.length < 4) {
            int[] iArr3 = new int[4];
            System.arraycopy((Object) iArr2, 0, (Object) iArr3, 0, iArr2.length);
            iArr2 = iArr3;
        }
        int i10 = iArr[length];
        int i11 = (52 / (length + 1)) + 6;
        int i12 = 0;
        while (true) {
            int i13 = i11 - 1;
            if (i11 <= 0) {
                return iArr;
            }
            i12 -= 1640531527;
            int i14 = (i12 >>> 2) & 3;
            int i15 = 0;
            while (i15 < length) {
                int i16 = i15 + 1;
                int i17 = iArr[i16];
                i10 = ((((i10 >>> 5) ^ (i17 << 2)) + ((i17 >>> 3) ^ (i10 << 4))) ^ ((i17 ^ i12) + (i10 ^ iArr2[(i15 & 3) ^ i14]))) + iArr[i15];
                iArr[i15] = i10;
                i15 = i16;
            }
            int i18 = iArr[0];
            i10 = ((((i10 >>> 5) ^ (i18 << 2)) + ((i18 >>> 3) ^ (i10 << 4))) ^ ((i18 ^ i12) + (i10 ^ iArr2[i14 ^ (i15 & 3)]))) + iArr[length];
            iArr[length] = i10;
            i11 = i13;
        }
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

    private static byte[] a(int[] iArr) {
        int length = iArr.length << 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = (byte) ((iArr[i10 >>> 2] >>> ((i10 & 3) << 3)) & 255);
        }
        return bArr;
    }
}
