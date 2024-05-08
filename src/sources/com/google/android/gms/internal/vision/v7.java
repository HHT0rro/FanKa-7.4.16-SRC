package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v7 extends t7 {
    @Override // com.google.android.gms.internal.vision.t7
    public final int a(int i10, byte[] bArr, int i11, int i12) {
        int m10;
        int m11;
        while (i11 < i12 && bArr[i11] >= 0) {
            i11++;
        }
        if (i11 >= i12) {
            return 0;
        }
        while (i11 < i12) {
            int i13 = i11 + 1;
            byte b4 = bArr[i11];
            if (b4 < 0) {
                if (b4 < -32) {
                    if (i13 >= i12) {
                        return b4;
                    }
                    if (b4 >= -62) {
                        i11 = i13 + 1;
                        if (bArr[i13] > -65) {
                        }
                    }
                    return -1;
                }
                if (b4 >= -16) {
                    if (i13 >= i12 - 2) {
                        m11 = s7.m(bArr, i13, i12);
                        return m11;
                    }
                    int i14 = i13 + 1;
                    byte b10 = bArr[i13];
                    if (b10 <= -65 && (((b4 << 28) + (b10 + 112)) >> 30) == 0) {
                        int i15 = i14 + 1;
                        if (bArr[i14] <= -65) {
                            i13 = i15 + 1;
                            if (bArr[i15] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i13 >= i12 - 1) {
                    m10 = s7.m(bArr, i13, i12);
                    return m10;
                }
                int i16 = i13 + 1;
                byte b11 = bArr[i13];
                if (b11 <= -65 && ((b4 != -32 || b11 >= -96) && (b4 != -19 || b11 < -96))) {
                    i11 = i16 + 1;
                    if (bArr[i16] > -65) {
                    }
                }
                return -1;
            }
            i11 = i13;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.vision.t7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.v7.b(java.lang.CharSequence, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.vision.t7
    public final String d(byte[] bArr, int i10, int i11) throws zzjk {
        boolean l10;
        boolean l11;
        boolean m10;
        boolean n10;
        boolean l12;
        if ((i10 | i11 | ((bArr.length - i10) - i11)) >= 0) {
            int i12 = i10 + i11;
            char[] cArr = new char[i11];
            int i13 = 0;
            while (i10 < i12) {
                byte b4 = bArr[i10];
                l12 = u7.l(b4);
                if (!l12) {
                    break;
                }
                i10++;
                u7.i(b4, cArr, i13);
                i13++;
            }
            int i14 = i13;
            while (i10 < i12) {
                int i15 = i10 + 1;
                byte b10 = bArr[i10];
                l10 = u7.l(b10);
                if (l10) {
                    int i16 = i14 + 1;
                    u7.i(b10, cArr, i14);
                    while (i15 < i12) {
                        byte b11 = bArr[i15];
                        l11 = u7.l(b11);
                        if (!l11) {
                            break;
                        }
                        i15++;
                        u7.i(b11, cArr, i16);
                        i16++;
                    }
                    i10 = i15;
                    i14 = i16;
                } else {
                    m10 = u7.m(b10);
                    if (!m10) {
                        n10 = u7.n(b10);
                        if (n10) {
                            if (i15 < i12 - 1) {
                                int i17 = i15 + 1;
                                u7.g(b10, bArr[i15], bArr[i17], cArr, i14);
                                i10 = i17 + 1;
                                i14++;
                            } else {
                                throw zzjk.zzh();
                            }
                        } else if (i15 < i12 - 2) {
                            int i18 = i15 + 1;
                            byte b12 = bArr[i15];
                            int i19 = i18 + 1;
                            u7.f(b10, b12, bArr[i18], bArr[i19], cArr, i14);
                            i10 = i19 + 1;
                            i14 = i14 + 1 + 1;
                        } else {
                            throw zzjk.zzh();
                        }
                    } else if (i15 < i12) {
                        u7.h(b10, bArr[i15], cArr, i14);
                        i10 = i15 + 1;
                        i14++;
                    } else {
                        throw zzjk.zzh();
                    }
                }
            }
            return new String(cArr, 0, i14);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
    }
}
