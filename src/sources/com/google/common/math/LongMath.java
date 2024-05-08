package com.google.common.math;

import com.android.internal.logging.nano.MetricsProto;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;
import okhttp3.internal.connection.RealConnection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class LongMath {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f26675a = {19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f26676b = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* renamed from: c, reason: collision with root package name */
    public static final long[] f26677c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f26678d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f26679e = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, MetricsProto.MetricsEvent.FIELD_EMERGENCY_DIALER_IS_DEVICE_LOCKED, 887, MetricsProto.MetricsEvent.DIALOG_REMOVE_USER, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f26680f = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, MetricsProto.MetricsEvent.TEXT_CLASSIFIER_GENERATE_LINKS, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_WRITE_CALL_LOG, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};

    /* renamed from: g, reason: collision with root package name */
    public static final long[][] f26681g = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum MillerRabinTester {
        SMALL { // from class: com.google.common.math.LongMath.MillerRabinTester.1
            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j10, long j11, long j12) {
                return (j10 * j11) % j12;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j10, long j11) {
                return (j10 * j10) % j11;
            }
        },
        LARGE { // from class: com.google.common.math.LongMath.MillerRabinTester.2
            private long plusMod(long j10, long j11, long j12) {
                long j13 = j10 + j11;
                return j10 >= j12 - j11 ? j13 - j12 : j13;
            }

            private long times2ToThe32Mod(long j10, long j11) {
                int i10 = 32;
                do {
                    int min = Math.min(i10, Long.numberOfLeadingZeros(j10));
                    j10 = UnsignedLongs.e(j10 << min, j11);
                    i10 -= min;
                } while (i10 > 0);
                return j10;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j10, long j11, long j12) {
                long j13 = j10 >>> 32;
                long j14 = j11 >>> 32;
                long j15 = j10 & 4294967295L;
                long j16 = j11 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j13 * j14, j12) + (j13 * j16);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.e(times2ToThe32Mod, j12);
                }
                Long.signum(j15);
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j14 * j15), j12), UnsignedLongs.e(j15 * j16, j12), j12);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j10, long j11) {
                long j12 = j10 >>> 32;
                long j13 = j10 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j12 * j12, j11);
                long j14 = j12 * j13 * 2;
                if (j14 < 0) {
                    j14 = UnsignedLongs.e(j14, j11);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j14, j11), UnsignedLongs.e(j13 * j13, j11), j11);
            }
        };

        private long powMod(long j10, long j11, long j12) {
            long j13 = 1;
            while (j11 != 0) {
                if ((j11 & 1) != 0) {
                    j13 = mulMod(j13, j10, j12);
                }
                j10 = squareMod(j10, j12);
                j11 >>= 1;
            }
            return j13;
        }

        public static boolean test(long j10, long j11) {
            return (j11 <= 3037000499L ? SMALL : LARGE).testWitness(j10, j11);
        }

        private boolean testWitness(long j10, long j11) {
            long j12 = j11 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j12);
            long j13 = j12 >> numberOfTrailingZeros;
            long j14 = j10 % j11;
            if (j14 == 0) {
                return true;
            }
            long powMod = powMod(j14, j13, j11);
            if (powMod == 1) {
                return true;
            }
            int i10 = 0;
            while (powMod != j12) {
                i10++;
                if (i10 == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j11);
            }
            return true;
        }

        public abstract long mulMod(long j10, long j11, long j12);

        public abstract long squareMod(long j10, long j11);

        /* synthetic */ MillerRabinTester(a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26682a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f26682a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26682a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26682a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26682a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26682a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26682a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26682a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f26682a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static long a(long j10, long j11) {
        long j12 = j10 + j11;
        f.c(((j10 ^ j11) < 0) | ((j10 ^ j12) >= 0), "checkedAdd", j10, j11);
        return j12;
    }

    public static long b(long j10, long j11) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j10) + Long.numberOfLeadingZeros(~j10) + Long.numberOfLeadingZeros(j11) + Long.numberOfLeadingZeros(~j11);
        if (numberOfLeadingZeros > 65) {
            return j10 * j11;
        }
        f.c(numberOfLeadingZeros >= 64, "checkedMultiply", j10, j11);
        f.c((j10 >= 0) | (j11 != Long.MIN_VALUE), "checkedMultiply", j10, j11);
        long j12 = j10 * j11;
        f.c(j10 == 0 || j12 / j10 == j11, "checkedMultiply", j10, j11);
        return j12;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
    
        if (r10 > 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
    
        if (r10 < 0) goto L29;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0020. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long c(long r9, long r11, java.math.RoundingMode r13) {
        /*
            com.google.common.base.o.r(r13)
            long r0 = r9 / r11
            long r2 = r11 * r0
            long r2 = r9 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L10
            return r0
        L10:
            long r9 = r9 ^ r11
            r7 = 63
            long r9 = r9 >> r7
            int r10 = (int) r9
            r9 = 1
            r10 = r10 | r9
            int[] r7 = com.google.common.math.LongMath.a.f26682a
            int r8 = r13.ordinal()
            r7 = r7[r8]
            r8 = 0
            switch(r7) {
                case 1: goto L50;
                case 2: goto L57;
                case 3: goto L4d;
                case 4: goto L58;
                case 5: goto L4a;
                case 6: goto L29;
                case 7: goto L29;
                case 8: goto L29;
                default: goto L23;
            }
        L23:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L29:
            long r2 = java.lang.Math.abs(r2)
            long r11 = java.lang.Math.abs(r11)
            long r11 = r11 - r2
            long r2 = r2 - r11
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 != 0) goto L47
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_UP
            if (r13 == r11) goto L58
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_EVEN
            if (r13 != r11) goto L57
            r11 = 1
            long r11 = r11 & r0
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L57
            goto L58
        L47:
            if (r11 <= 0) goto L57
            goto L58
        L4a:
            if (r10 <= 0) goto L57
            goto L58
        L4d:
            if (r10 >= 0) goto L57
            goto L58
        L50:
            if (r6 != 0) goto L53
            goto L54
        L53:
            r9 = 0
        L54:
            com.google.common.math.f.e(r9)
        L57:
            r9 = 0
        L58:
            if (r9 == 0) goto L5c
            long r9 = (long) r10
            long r0 = r0 + r9
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.c(long, long, java.math.RoundingMode):long");
    }
}
