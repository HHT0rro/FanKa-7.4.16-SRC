package com.google.common.primitives;

import com.google.common.base.o;
import java.math.BigInteger;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class UnsignedLongs {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                if (jArr[i10] != jArr2[i10]) {
                    return UnsignedLongs.a(jArr[i10], jArr2[i10]);
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final long[] f26715a = new long[37];

        /* renamed from: b, reason: collision with root package name */
        public static final int[] f26716b = new int[37];

        /* renamed from: c, reason: collision with root package name */
        public static final int[] f26717c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i10 = 2; i10 <= 36; i10++) {
                long j10 = i10;
                f26715a[i10] = UnsignedLongs.b(-1L, j10);
                f26716b[i10] = (int) UnsignedLongs.e(-1L, j10);
                f26717c[i10] = bigInteger.toString(i10).length() - 1;
            }
        }

        public static boolean a(long j10, int i10, int i11) {
            if (j10 < 0) {
                return true;
            }
            long[] jArr = f26715a;
            if (j10 < jArr[i11]) {
                return false;
            }
            return j10 > jArr[i11] || i10 > f26716b[i11];
        }
    }

    public static int a(long j10, long j11) {
        return Longs.c(c(j10), c(j11));
    }

    public static long b(long j10, long j11) {
        if (j11 < 0) {
            return a(j10, j11) < 0 ? 0L : 1L;
        }
        if (j10 >= 0) {
            return j10 / j11;
        }
        long j12 = ((j10 >>> 1) / j11) << 1;
        return j12 + (a(j10 - (j12 * j11), j11) < 0 ? 0 : 1);
    }

    public static long c(long j10) {
        return j10 ^ Long.MIN_VALUE;
    }

    public static long d(String str, int i10) {
        o.r(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i10 >= 2 && i10 <= 36) {
            int i11 = a.f26717c[i10] - 1;
            long j10 = 0;
            for (int i12 = 0; i12 < str.length(); i12++) {
                int digit = Character.digit(str.charAt(i12), i10);
                if (digit != -1) {
                    if (i12 > i11 && a.a(j10, digit, i10)) {
                        throw new NumberFormatException(str.length() != 0 ? "Too large for unsigned long: ".concat(str) : new String("Too large for unsigned long: "));
                    }
                    j10 = (j10 * i10) + digit;
                } else {
                    throw new NumberFormatException(str);
                }
            }
            return j10;
        }
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("illegal radix: ");
        sb2.append(i10);
        throw new NumberFormatException(sb2.toString());
    }

    public static long e(long j10, long j11) {
        if (j11 < 0) {
            return a(j10, j11) < 0 ? j10 : j10 - j11;
        }
        if (j10 >= 0) {
            return j10 % j11;
        }
        long j12 = j10 - ((((j10 >>> 1) / j11) << 1) * j11);
        if (a(j12, j11) < 0) {
            j11 = 0;
        }
        return j12 - j11;
    }

    public static String f(long j10) {
        return g(j10, 10);
    }

    public static String g(long j10, int i10) {
        long b4;
        o.h(i10 >= 2 && i10 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i10);
        if (j10 == 0) {
            return "0";
        }
        if (j10 > 0) {
            return Long.toString(j10, i10);
        }
        int i11 = 64;
        char[] cArr = new char[64];
        int i12 = i10 - 1;
        if ((i10 & i12) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i10);
            do {
                i11--;
                cArr[i11] = Character.forDigit(((int) j10) & i12, i10);
                j10 >>>= numberOfTrailingZeros;
            } while (j10 != 0);
        } else {
            if ((i10 & 1) == 0) {
                b4 = (j10 >>> 1) / (i10 >>> 1);
            } else {
                b4 = b(j10, i10);
            }
            long j11 = i10;
            cArr[63] = Character.forDigit((int) (j10 - (b4 * j11)), i10);
            i11 = 63;
            while (b4 > 0) {
                i11--;
                cArr[i11] = Character.forDigit((int) (b4 % j11), i10);
                b4 /= j11;
            }
        }
        return new String(cArr, i11, 64 - i11);
    }
}
