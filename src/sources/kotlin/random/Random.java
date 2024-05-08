package kotlin.random;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Random.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class Random {

    @NotNull
    public static final Default Default = new Default(null);

    @NotNull
    private static final Random defaultRandom = ud.b.f54017a.b();

    /* compiled from: Random.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Default extends Random implements Serializable {

        /* compiled from: Random.kt */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Serialized implements Serializable {

            @NotNull
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        private Default() {
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int i10) {
            return Random.defaultRandom.nextBits(i10);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(@NotNull byte[] array) {
            s.i(array, "array");
            return Random.defaultRandom.nextBytes(array);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(int i10) {
            return Random.defaultRandom.nextBytes(i10);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d10) {
            return Random.defaultRandom.nextDouble(d10);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i10) {
            return Random.defaultRandom.nextInt(i10);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j10) {
            return Random.defaultRandom.nextLong(j10);
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(@NotNull byte[] array, int i10, int i11) {
            s.i(array, "array");
            return Random.defaultRandom.nextBytes(array, i10, i11);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d10, double d11) {
            return Random.defaultRandom.nextDouble(d10, d11);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i10, int i11) {
            return Random.defaultRandom.nextInt(i10, i11);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j10, long j11) {
            return Random.defaultRandom.nextLong(j10, j11);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return random.nextBytes(bArr, i10, i11);
    }

    public abstract int nextBits(int i10);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] array, int i10, int i11) {
        s.i(array, "array");
        if (!(new IntRange(0, array.length).i(i10) && new IntRange(0, array.length).i(i11))) {
            throw new IllegalArgumentException(("fromIndex (" + i10 + ") or toIndex (" + i11 + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (i10 <= i11) {
            int i12 = (i11 - i10) / 4;
            for (int i13 = 0; i13 < i12; i13++) {
                int nextInt = nextInt();
                array[i10] = (byte) nextInt;
                array[i10 + 1] = (byte) (nextInt >>> 8);
                array[i10 + 2] = (byte) (nextInt >>> 16);
                array[i10 + 3] = (byte) (nextInt >>> 24);
                i10 += 4;
            }
            int i14 = i11 - i10;
            int nextBits = nextBits(i14 * 8);
            for (int i15 = 0; i15 < i14; i15++) {
                array[i10 + i15] = (byte) (nextBits >>> (i15 * 8));
            }
            return array;
        }
        throw new IllegalArgumentException(("fromIndex (" + i10 + ") must be not greater than toIndex (" + i11 + ").").toString());
    }

    public double nextDouble() {
        return c.a(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    public double nextDouble(double d10) {
        return nextDouble(ShadowDrawableWrapper.COS_45, d10);
    }

    public int nextInt(int i10) {
        return nextInt(0, i10);
    }

    public long nextLong(long j10) {
        return nextLong(0L, j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double nextDouble(double r7, double r9) {
        /*
            r6 = this;
            kotlin.random.d.b(r7, r9)
            double r0 = r9 - r7
            boolean r2 = java.lang.Double.isInfinite(r0)
            if (r2 == 0) goto L3e
            boolean r2 = java.lang.Double.isInfinite(r7)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L1b
            boolean r2 = java.lang.Double.isNaN(r7)
            if (r2 != 0) goto L1b
            r2 = 1
            goto L1c
        L1b:
            r2 = 0
        L1c:
            if (r2 == 0) goto L3e
            boolean r2 = java.lang.Double.isInfinite(r9)
            if (r2 != 0) goto L2b
            boolean r2 = java.lang.Double.isNaN(r9)
            if (r2 != 0) goto L2b
            goto L2c
        L2b:
            r3 = 0
        L2c:
            if (r3 == 0) goto L3e
            double r0 = r6.nextDouble()
            r2 = 2
            double r2 = (double) r2
            double r4 = r9 / r2
            double r2 = r7 / r2
            double r4 = r4 - r2
            double r0 = r0 * r4
            double r7 = r7 + r0
            double r7 = r7 + r0
            goto L45
        L3e:
            double r2 = r6.nextDouble()
            double r2 = r2 * r0
            double r7 = r7 + r2
        L45:
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L4f
            r7 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            double r7 = java.lang.Math.nextAfter(r9, r7)
        L4f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.nextDouble(double, double):double");
    }

    public int nextInt(int i10, int i11) {
        int nextInt;
        int i12;
        int i13;
        int nextInt2;
        boolean z10;
        d.c(i10, i11);
        int i14 = i11 - i10;
        if (i14 > 0 || i14 == Integer.MIN_VALUE) {
            if (((-i14) & i14) == i14) {
                i13 = nextBits(d.e(i14));
                return i10 + i13;
            }
            do {
                nextInt = nextInt() >>> 1;
                i12 = nextInt % i14;
            } while ((nextInt - i12) + (i14 - 1) < 0);
            i13 = i12;
            return i10 + i13;
        }
        do {
            nextInt2 = nextInt();
            z10 = false;
            if (i10 <= nextInt2 && nextInt2 < i11) {
                z10 = true;
            }
        } while (!z10);
        return nextInt2;
    }

    public long nextLong(long j10, long j11) {
        long nextLong;
        boolean z10;
        long nextLong2;
        long j12;
        long j13;
        int nextInt;
        d.d(j10, j11);
        long j14 = j11 - j10;
        if (j14 > 0) {
            if (((-j14) & j14) == j14) {
                int i10 = (int) j14;
                int i11 = (int) (j14 >>> 32);
                if (i10 != 0) {
                    nextInt = nextBits(d.e(i10));
                } else if (i11 == 1) {
                    nextInt = nextInt();
                } else {
                    j13 = (nextBits(d.e(i11)) << 32) + (nextInt() & 4294967295L);
                    return j10 + j13;
                }
                j13 = nextInt & 4294967295L;
                return j10 + j13;
            }
            do {
                nextLong2 = nextLong() >>> 1;
                j12 = nextLong2 % j14;
            } while ((nextLong2 - j12) + (j14 - 1) < 0);
            j13 = j12;
            return j10 + j13;
        }
        do {
            nextLong = nextLong();
            z10 = false;
            if (j10 <= nextLong && nextLong < j11) {
                z10 = true;
            }
        } while (!z10);
        return nextLong;
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] array) {
        s.i(array, "array");
        return nextBytes(array, 0, array.length);
    }

    @NotNull
    public byte[] nextBytes(int i10) {
        return nextBytes(new byte[i10]);
    }
}
