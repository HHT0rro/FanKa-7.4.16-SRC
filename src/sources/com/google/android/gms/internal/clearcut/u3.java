package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u3 extends s3 {
    public static int f(byte[] bArr, int i10, long j10, int i11) {
        int d10;
        int l10;
        int f10;
        if (i11 == 0) {
            d10 = r3.d(i10);
            return d10;
        }
        if (i11 == 1) {
            l10 = r3.l(i10, p3.a(bArr, j10));
            return l10;
        }
        if (i11 != 2) {
            throw new AssertionError();
        }
        f10 = r3.f(i10, p3.a(bArr, j10), p3.a(bArr, j10 + 1));
        return f10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b6, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0061, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.clearcut.s3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.u3.a(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.clearcut.s3
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
            p3.k(bArr, j13, (byte) charAt);
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
                    p3.k(bArr, j13, (byte) ((charAt3 >>> 6) | 960));
                    p3.k(bArr, j15, (byte) ((charAt3 & '?') | 128));
                    j11 = j15 + j10;
                    j12 = j10;
                } else {
                    if ((charAt3 >= 55296 && 57343 >= charAt3) || j13 > j14 - 3) {
                        if (j13 > j14 - 4) {
                            if (55296 <= charAt3 && charAt3 <= 57343 && ((i12 = i13 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i12)))) {
                                throw new zzfi(i13, length);
                            }
                            StringBuilder sb3 = new StringBuilder(46);
                            sb3.append("Failed writing ");
                            sb3.append(charAt3);
                            sb3.append(" at index ");
                            sb3.append(j13);
                            throw new ArrayIndexOutOfBoundsException(sb3.toString());
                        }
                        int i14 = i13 + 1;
                        if (i14 != length) {
                            char charAt4 = charSequence.charAt(i14);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j16 = j13 + 1;
                                p3.k(bArr, j13, (byte) ((codePoint >>> 18) | 240));
                                long j17 = j16 + 1;
                                p3.k(bArr, j16, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j18 = j17 + 1;
                                p3.k(bArr, j17, (byte) (((codePoint >>> 6) & 63) | 128));
                                j12 = 1;
                                j11 = j18 + 1;
                                p3.k(bArr, j18, (byte) ((codePoint & 63) | 128));
                                i13 = i14;
                            } else {
                                i13 = i14;
                            }
                        }
                        throw new zzfi(i13 - 1, length);
                    }
                    long j19 = j13 + j10;
                    p3.k(bArr, j13, (byte) ((charAt3 >>> '\f') | 480));
                    long j20 = j19 + j10;
                    p3.k(bArr, j19, (byte) (((charAt3 >>> 6) & 63) | 128));
                    p3.k(bArr, j20, (byte) ((charAt3 & '?') | 128));
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
                p3.k(bArr, j13, (byte) charAt3);
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

    @Override // com.google.android.gms.internal.clearcut.s3
    public final void c(CharSequence charSequence, ByteBuffer byteBuffer) {
        char c4;
        int i10;
        long j10;
        int i11;
        char charAt;
        ByteBuffer byteBuffer2 = byteBuffer;
        long o10 = p3.o(byteBuffer);
        long position = byteBuffer.position() + o10;
        long limit = byteBuffer.limit() + o10;
        int length = charSequence.length();
        if (length > limit - position) {
            char charAt2 = charSequence.charAt(length - 1);
            int limit2 = byteBuffer.limit();
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("Failed writing ");
            sb2.append(charAt2);
            sb2.append(" at index ");
            sb2.append(limit2);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        int i12 = 0;
        while (true) {
            c4 = 128;
            if (i12 >= length || (charAt = charSequence.charAt(i12)) >= 128) {
                break;
            }
            p3.c(position, (byte) charAt);
            i12++;
            position++;
        }
        if (i12 == length) {
            i10 = (int) (position - o10);
        } else {
            while (i12 < length) {
                char charAt3 = charSequence.charAt(i12);
                if (charAt3 < c4 && position < limit) {
                    p3.c(position, (byte) charAt3);
                    position++;
                    j10 = o10;
                } else if (charAt3 >= 2048 || position > limit - 2) {
                    j10 = o10;
                    if ((charAt3 >= 55296 && 57343 >= charAt3) || position > limit - 3) {
                        if (position > limit - 4) {
                            if (55296 <= charAt3 && charAt3 <= 57343 && ((i11 = i12 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i11)))) {
                                throw new zzfi(i12, length);
                            }
                            StringBuilder sb3 = new StringBuilder(46);
                            sb3.append("Failed writing ");
                            sb3.append(charAt3);
                            sb3.append(" at index ");
                            sb3.append(position);
                            throw new ArrayIndexOutOfBoundsException(sb3.toString());
                        }
                        int i13 = i12 + 1;
                        if (i13 != length) {
                            char charAt4 = charSequence.charAt(i13);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j11 = position + 1;
                                p3.c(position, (byte) ((codePoint >>> 18) | 240));
                                long j12 = j11 + 1;
                                p3.c(j11, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j13 = j12 + 1;
                                p3.c(j12, (byte) (((codePoint >>> 6) & 63) | 128));
                                long j14 = j13 + 1;
                                p3.c(j13, (byte) ((codePoint & 63) | 128));
                                i12 = i13;
                                position = j14;
                            } else {
                                i12 = i13;
                            }
                        }
                        throw new zzfi(i12 - 1, length);
                    }
                    long j15 = position + 1;
                    p3.c(position, (byte) ((charAt3 >>> '\f') | 480));
                    long j16 = j15 + 1;
                    p3.c(j15, (byte) (((charAt3 >>> 6) & 63) | 128));
                    p3.c(j16, (byte) ((charAt3 & '?') | 128));
                    position = j16 + 1;
                } else {
                    j10 = o10;
                    long j17 = position + 1;
                    p3.c(position, (byte) ((charAt3 >>> 6) | 960));
                    p3.c(j17, (byte) ((charAt3 & '?') | 128));
                    position = j17 + 1;
                }
                i12++;
                o10 = j10;
                c4 = 128;
            }
            i10 = (int) (position - o10);
            byteBuffer2 = byteBuffer;
        }
        byteBuffer2.position(i10);
    }
}
