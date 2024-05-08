package com.tencent.turingcam;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class WOMZP {
    private static int a(int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        return ((i10 ^ i11) + (iArr[(i13 & 3) ^ i14] ^ i12)) ^ (((i12 >>> 5) ^ (i11 << 2)) + ((i11 >>> 3) ^ (i12 << 4)));
    }

    public static final String b(String str) {
        try {
            byte[] a10 = a(str);
            byte[] bytes = "DFG#$%^#%(&*M<><".getBytes("UTF-8");
            if (a10.length != 0) {
                int[] a11 = a(a10, false);
                if (bytes.length != 16) {
                    byte[] bArr = new byte[16];
                    if (bytes.length < 16) {
                        System.arraycopy((Object) bytes, 0, (Object) bArr, 0, bytes.length);
                    } else {
                        System.arraycopy((Object) bytes, 0, (Object) bArr, 0, 16);
                    }
                    bytes = bArr;
                }
                int[] a12 = a(bytes, false);
                int length = a11.length - 1;
                if (length >= 1) {
                    int i10 = a11[0];
                    for (int i11 = ((52 / (length + 1)) + 6) * (-1640531527); i11 != 0; i11 += 1640531527) {
                        int i12 = (i11 >>> 2) & 3;
                        int i13 = i10;
                        int i14 = length;
                        while (i14 > 0) {
                            i13 = a11[i14] - a(i11, i13, a11[i14 - 1], i14, i12, a12);
                            a11[i14] = i13;
                            i14--;
                        }
                        i10 = a11[0] - a(i11, i13, a11[length], i14, i12, a12);
                        a11[0] = i10;
                    }
                }
                int length2 = a11.length << 2;
                int i15 = a11[a11.length - 1];
                int i16 = length2 - 4;
                if (i15 < i16 - 3 || i15 > i16) {
                    a10 = null;
                } else {
                    byte[] bArr2 = new byte[i15];
                    for (int i17 = 0; i17 < i15; i17++) {
                        bArr2[i17] = (byte) (a11[i17 >>> 2] >>> ((i17 & 3) << 3));
                    }
                    a10 = bArr2;
                }
            }
            if (a10 != null) {
                return new String(a10);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static int[] a(byte[] bArr, boolean z10) {
        int[] iArr;
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
        if (z10) {
            iArr = new int[length + 1];
            iArr[length] = bArr.length;
        } else {
            iArr = new int[length];
        }
        int length2 = bArr.length;
        for (int i10 = 0; i10 < length2; i10++) {
            int i11 = i10 >>> 2;
            iArr[i11] = iArr[i11] | ((bArr[i10] & 255) << ((i10 & 3) << 3));
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0079, code lost:
    
        if (r3 != (-1)) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        r2.write(r3 | ((r6 & 3) << 6));
        r3 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final byte[] a(java.lang.String r9) {
        /*
            r0 = 128(0x80, float:1.794E-43)
            byte[] r0 = new byte[r0]
            r0 = {x008c: FILL_ARRAY_DATA , data: [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1} // fill-array
            byte[] r9 = r9.getBytes()
            int r1 = r9.length
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>(r1)
            r3 = 0
        L12:
            if (r3 >= r1) goto L86
        L14:
            int r4 = r3 + 1
            r3 = r9[r3]
            r3 = r0[r3]
            r5 = -1
            if (r4 >= r1) goto L22
            if (r3 == r5) goto L20
            goto L22
        L20:
            r3 = r4
            goto L14
        L22:
            if (r3 != r5) goto L26
            goto L86
        L26:
            int r6 = r4 + 1
            r4 = r9[r4]
            r4 = r0[r4]
            if (r6 >= r1) goto L33
            if (r4 == r5) goto L31
            goto L33
        L31:
            r4 = r6
            goto L26
        L33:
            if (r4 != r5) goto L36
            goto L86
        L36:
            int r3 = r3 << 2
            r7 = r4 & 48
            int r7 = r7 >>> 4
            r3 = r3 | r7
            r2.write(r3)
        L40:
            int r3 = r6 + 1
            r6 = r9[r6]
            r7 = 61
            if (r6 != r7) goto L4d
            byte[] r9 = r2.toByteArray()
            return r9
        L4d:
            r6 = r0[r6]
            if (r3 >= r1) goto L56
            if (r6 == r5) goto L54
            goto L56
        L54:
            r6 = r3
            goto L40
        L56:
            if (r6 != r5) goto L59
            goto L86
        L59:
            r4 = r4 & 15
            int r4 = r4 << 4
            r8 = r6 & 60
            int r8 = r8 >>> 2
            r4 = r4 | r8
            r2.write(r4)
        L65:
            int r4 = r3 + 1
            r3 = r9[r3]
            if (r3 != r7) goto L70
            byte[] r9 = r2.toByteArray()
            return r9
        L70:
            r3 = r0[r3]
            if (r4 >= r1) goto L79
            if (r3 == r5) goto L77
            goto L79
        L77:
            r3 = r4
            goto L65
        L79:
            if (r3 != r5) goto L7c
            goto L86
        L7c:
            r5 = r6 & 3
            int r5 = r5 << 6
            r3 = r3 | r5
            r2.write(r3)
            r3 = r4
            goto L12
        L86:
            byte[] r9 = r2.toByteArray()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.WOMZP.a(java.lang.String):byte[]");
    }
}
