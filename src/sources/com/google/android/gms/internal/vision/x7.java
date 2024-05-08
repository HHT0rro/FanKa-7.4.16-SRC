package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x7 extends t7 {
    public static int e(byte[] bArr, int i10, long j10, int i11) {
        int h10;
        int i12;
        int j11;
        if (i11 == 0) {
            h10 = s7.h(i10);
            return h10;
        }
        if (i11 == 1) {
            i12 = s7.i(i10, p7.a(bArr, j10));
            return i12;
        }
        if (i11 == 2) {
            j11 = s7.j(i10, p7.a(bArr, j10), p7.a(bArr, j10 + 1));
            return j11;
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b6, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0061, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.vision.t7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.x7.a(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.vision.t7
    public final int b(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        char c4;
        long j10;
        long j11;
        long j12;
        int i12;
        char charAt;
        long j13 = i10;
        long j14 = i11 + j13;
        int length = charSequence.length();
        if (length > i11 || bArr.length - i11 < i10) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("Failed writing ");
            sb2.append(charAt2);
            sb2.append(" at index ");
            sb2.append(i10 + i11);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        int i13 = 0;
        while (true) {
            c4 = 128;
            j10 = 1;
            if (i13 >= length || (charAt = charSequence.charAt(i13)) >= 128) {
                break;
            }
            p7.l(bArr, j13, (byte) charAt);
            i13++;
            j13 = 1 + j13;
        }
        if (i13 == length) {
            return (int) j13;
        }
        while (i13 < length) {
            char charAt3 = charSequence.charAt(i13);
            if (charAt3 >= c4 || j13 >= j14) {
                if (charAt3 < 2048 && j13 <= j14 - 2) {
                    long j15 = j13 + j10;
                    p7.l(bArr, j13, (byte) ((charAt3 >>> 6) | 960));
                    p7.l(bArr, j15, (byte) ((charAt3 & '?') | 128));
                    j11 = j15 + j10;
                    j12 = j10;
                } else {
                    if ((charAt3 >= 55296 && 57343 >= charAt3) || j13 > j14 - 3) {
                        if (j13 <= j14 - 4) {
                            int i14 = i13 + 1;
                            if (i14 != length) {
                                char charAt4 = charSequence.charAt(i14);
                                if (Character.isSurrogatePair(charAt3, charAt4)) {
                                    int codePoint = Character.toCodePoint(charAt3, charAt4);
                                    long j16 = j13 + 1;
                                    p7.l(bArr, j13, (byte) ((codePoint >>> 18) | 240));
                                    long j17 = j16 + 1;
                                    p7.l(bArr, j16, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j18 = j17 + 1;
                                    p7.l(bArr, j17, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j12 = 1;
                                    j11 = j18 + 1;
                                    p7.l(bArr, j18, (byte) ((codePoint & 63) | 128));
                                    i13 = i14;
                                } else {
                                    i13 = i14;
                                }
                            }
                            throw new zzmg(i13 - 1, length);
                        }
                        if (55296 <= charAt3 && charAt3 <= 57343 && ((i12 = i13 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i12)))) {
                            throw new zzmg(i13, length);
                        }
                        StringBuilder sb3 = new StringBuilder(46);
                        sb3.append("Failed writing ");
                        sb3.append(charAt3);
                        sb3.append(" at index ");
                        sb3.append(j13);
                        throw new ArrayIndexOutOfBoundsException(sb3.toString());
                    }
                    long j19 = j13 + j10;
                    p7.l(bArr, j13, (byte) ((charAt3 >>> '\f') | 480));
                    long j20 = j19 + j10;
                    p7.l(bArr, j19, (byte) (((charAt3 >>> 6) & 63) | 128));
                    p7.l(bArr, j20, (byte) ((charAt3 & '?') | 128));
                    j11 = j20 + 1;
                    j12 = 1;
                }
                i13++;
                c4 = 128;
                long j21 = j12;
                j13 = j11;
                j10 = j21;
            } else {
                long j22 = j13 + j10;
                p7.l(bArr, j13, (byte) charAt3);
                j12 = j10;
                j11 = j22;
            }
            i13++;
            c4 = 128;
            long j212 = j12;
            j13 = j11;
            j10 = j212;
        }
        return (int) j13;
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
                byte a10 = p7.a(bArr, i10);
                l12 = u7.l(a10);
                if (!l12) {
                    break;
                }
                i10++;
                u7.i(a10, cArr, i13);
                i13++;
            }
            int i14 = i13;
            while (i10 < i12) {
                int i15 = i10 + 1;
                byte a11 = p7.a(bArr, i10);
                l10 = u7.l(a11);
                if (l10) {
                    int i16 = i14 + 1;
                    u7.i(a11, cArr, i14);
                    while (i15 < i12) {
                        byte a12 = p7.a(bArr, i15);
                        l11 = u7.l(a12);
                        if (!l11) {
                            break;
                        }
                        i15++;
                        u7.i(a12, cArr, i16);
                        i16++;
                    }
                    i10 = i15;
                    i14 = i16;
                } else {
                    m10 = u7.m(a11);
                    if (!m10) {
                        n10 = u7.n(a11);
                        if (n10) {
                            if (i15 < i12 - 1) {
                                int i17 = i15 + 1;
                                u7.g(a11, p7.a(bArr, i15), p7.a(bArr, i17), cArr, i14);
                                i10 = i17 + 1;
                                i14++;
                            } else {
                                throw zzjk.zzh();
                            }
                        } else if (i15 < i12 - 2) {
                            int i18 = i15 + 1;
                            byte a13 = p7.a(bArr, i15);
                            int i19 = i18 + 1;
                            u7.f(a11, a13, p7.a(bArr, i18), p7.a(bArr, i19), cArr, i14);
                            i10 = i19 + 1;
                            i14 = i14 + 1 + 1;
                        } else {
                            throw zzjk.zzh();
                        }
                    } else if (i15 < i12) {
                        u7.h(a11, p7.a(bArr, i15), cArr, i14);
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
