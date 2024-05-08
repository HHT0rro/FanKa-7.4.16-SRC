package java.util;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class SplittableRandom {
    static final String BAD_BOUND = "bound must be positive";
    static final String BAD_RANGE = "bound must be greater than origin";
    static final String BAD_SIZE = "size must be non-negative";
    private static final double DOUBLE_UNIT = 1.1102230246251565E-16d;
    private static final long GOLDEN_GAMMA = -7046029254386353131L;
    private static final AtomicLong defaultGen = new AtomicLong(mix64(System.currentTimeMillis()) ^ mix64(System.nanoTime()));
    private final long gamma;
    private long seed;

    private SplittableRandom(long seed, long gamma) {
        this.seed = seed;
        this.gamma = gamma;
    }

    private static long mix64(long z10) {
        long z11 = ((z10 >>> 30) ^ z10) * (-4658895280553007687L);
        long z12 = ((z11 >>> 27) ^ z11) * (-7723592293110705685L);
        return (z12 >>> 31) ^ z12;
    }

    private static int mix32(long z10) {
        long z11 = ((z10 >>> 33) ^ z10) * 7109453100751455733L;
        return (int) ((((z11 >>> 28) ^ z11) * (-3808689974395783757L)) >>> 32);
    }

    private static long mixGamma(long z10) {
        long z11 = ((z10 >>> 33) ^ z10) * (-49064778989728563L);
        long z12 = ((z11 >>> 33) ^ z11) * (-4265267296055464877L);
        long z13 = ((z12 >>> 33) ^ z12) | 1;
        int n10 = Long.bitCount((z13 >>> 1) ^ z13);
        return n10 < 24 ? (-6148914691236517206L) ^ z13 : z13;
    }

    private long nextSeed() {
        long j10 = this.seed + this.gamma;
        this.seed = j10;
        return j10;
    }

    static {
        if (((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: java.util.SplittableRandom.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
            }
        })).booleanValue()) {
            byte[] seedBytes = SecureRandom.getSeed(8);
            long s2 = seedBytes[0] & 255;
            for (int i10 = 1; i10 < 8; i10++) {
                s2 = (s2 << 8) | (seedBytes[i10] & 255);
            }
            defaultGen.set(s2);
        }
    }

    final long internalNextLong(long origin, long bound) {
        long r10 = mix64(nextSeed());
        if (origin < bound) {
            long n10 = bound - origin;
            long m10 = n10 - 1;
            if ((n10 & m10) == 0) {
                return (r10 & m10) + origin;
            }
            if (n10 > 0) {
                long u10 = r10 >>> 1;
                while (true) {
                    long r11 = u10 % n10;
                    if ((u10 + m10) - r11 < 0) {
                        u10 = mix64(nextSeed()) >>> 1;
                    } else {
                        return r11 + origin;
                    }
                }
            } else {
                while (true) {
                    if (r10 < origin || r10 >= bound) {
                        r10 = mix64(nextSeed());
                    } else {
                        return r10;
                    }
                }
            }
        } else {
            return r10;
        }
    }

    final int internalNextInt(int origin, int bound) {
        int r10 = mix32(nextSeed());
        if (origin < bound) {
            int n10 = bound - origin;
            int m10 = n10 - 1;
            if ((n10 & m10) == 0) {
                return (r10 & m10) + origin;
            }
            if (n10 > 0) {
                int u10 = r10 >>> 1;
                while (true) {
                    int r11 = u10 % n10;
                    if ((u10 + m10) - r11 < 0) {
                        u10 = mix32(nextSeed()) >>> 1;
                    } else {
                        return r11 + origin;
                    }
                }
            } else {
                while (true) {
                    if (r10 < origin || r10 >= bound) {
                        r10 = mix32(nextSeed());
                    } else {
                        return r10;
                    }
                }
            }
        } else {
            return r10;
        }
    }

    final double internalNextDouble(double origin, double bound) {
        double r10 = (nextLong() >>> 11) * DOUBLE_UNIT;
        if (origin < bound) {
            double r11 = ((bound - origin) * r10) + origin;
            if (r11 >= bound) {
                return Double.longBitsToDouble(Double.doubleToLongBits(bound) - 1);
            }
            return r11;
        }
        return r10;
    }

    public SplittableRandom(long seed) {
        this(seed, GOLDEN_GAMMA);
    }

    public SplittableRandom() {
        long s2 = defaultGen.getAndAdd(4354685564936845354L);
        this.seed = mix64(s2);
        this.gamma = mixGamma(GOLDEN_GAMMA + s2);
    }

    public SplittableRandom split() {
        return new SplittableRandom(nextLong(), mixGamma(nextSeed()));
    }

    public void nextBytes(byte[] bytes) {
        int i10 = 0;
        int len = bytes.length;
        int i11 = len >> 3;
        while (true) {
            int words = i11 - 1;
            if (i11 <= 0) {
                break;
            }
            long rnd = nextLong();
            int i12 = 8;
            while (true) {
                int n10 = i12 - 1;
                if (i12 > 0) {
                    bytes[i10] = (byte) rnd;
                    rnd >>>= 8;
                    i10++;
                    i12 = n10;
                }
            }
            i11 = words;
        }
        if (i10 < len) {
            long rnd2 = nextLong();
            while (i10 < len) {
                bytes[i10] = (byte) rnd2;
                rnd2 >>>= 8;
                i10++;
            }
        }
    }

    public int nextInt() {
        return mix32(nextSeed());
    }

    public int nextInt(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException(BAD_BOUND);
        }
        int r10 = mix32(nextSeed());
        int m10 = bound - 1;
        if ((bound & m10) == 0) {
            return r10 & m10;
        }
        int u10 = r10 >>> 1;
        while (true) {
            int r11 = u10 % bound;
            if ((u10 + m10) - r11 >= 0) {
                return r11;
            }
            u10 = mix32(nextSeed()) >>> 1;
        }
    }

    public int nextInt(int origin, int bound) {
        if (origin >= bound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return internalNextInt(origin, bound);
    }

    public long nextLong() {
        return mix64(nextSeed());
    }

    public long nextLong(long bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException(BAD_BOUND);
        }
        long r10 = mix64(nextSeed());
        long m10 = bound - 1;
        if ((bound & m10) == 0) {
            return r10 & m10;
        }
        long u10 = r10 >>> 1;
        while (true) {
            long r11 = u10 % bound;
            if ((u10 + m10) - r11 < 0) {
                u10 = mix64(nextSeed()) >>> 1;
            } else {
                return r11;
            }
        }
    }

    public long nextLong(long origin, long bound) {
        if (origin >= bound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return internalNextLong(origin, bound);
    }

    public double nextDouble() {
        return (mix64(nextSeed()) >>> 11) * DOUBLE_UNIT;
    }

    public double nextDouble(double bound) {
        if (bound <= ShadowDrawableWrapper.COS_45) {
            throw new IllegalArgumentException(BAD_BOUND);
        }
        double result = (mix64(nextSeed()) >>> 11) * DOUBLE_UNIT * bound;
        return result < bound ? result : Double.longBitsToDouble(Double.doubleToLongBits(bound) - 1);
    }

    public double nextDouble(double origin, double bound) {
        if (origin >= bound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return internalNextDouble(origin, bound);
    }

    public boolean nextBoolean() {
        return mix32(nextSeed()) < 0;
    }

    public IntStream ints(long streamSize) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        return StreamSupport.intStream(new RandomIntsSpliterator(this, 0L, streamSize, Integer.MAX_VALUE, 0), false);
    }

    public IntStream ints() {
        return StreamSupport.intStream(new RandomIntsSpliterator(this, 0L, Long.MAX_VALUE, Integer.MAX_VALUE, 0), false);
    }

    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return StreamSupport.intStream(new RandomIntsSpliterator(this, 0L, streamSize, randomNumberOrigin, randomNumberBound), false);
    }

    public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return StreamSupport.intStream(new RandomIntsSpliterator(this, 0L, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound), false);
    }

    public LongStream longs(long streamSize) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        return StreamSupport.longStream(new RandomLongsSpliterator(this, 0L, streamSize, Long.MAX_VALUE, 0L), false);
    }

    public LongStream longs() {
        return StreamSupport.longStream(new RandomLongsSpliterator(this, 0L, Long.MAX_VALUE, Long.MAX_VALUE, 0L), false);
    }

    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return StreamSupport.longStream(new RandomLongsSpliterator(this, 0L, streamSize, randomNumberOrigin, randomNumberBound), false);
    }

    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return StreamSupport.longStream(new RandomLongsSpliterator(this, 0L, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound), false);
    }

    public DoubleStream doubles(long streamSize) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(this, 0L, streamSize, Double.MAX_VALUE, ShadowDrawableWrapper.COS_45), false);
    }

    public DoubleStream doubles() {
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(this, 0L, Long.MAX_VALUE, Double.MAX_VALUE, ShadowDrawableWrapper.COS_45), false);
    }

    public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(this, 0L, streamSize, randomNumberOrigin, randomNumberBound), false);
    }

    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(this, 0L, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound), false);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class RandomIntsSpliterator implements Spliterator.OfInt {
        final int bound;
        final long fence;
        long index;
        final int origin;
        final SplittableRandom rng;

        RandomIntsSpliterator(SplittableRandom rng, long index, long fence, int origin, int bound) {
            this.rng = rng;
            this.index = index;
            this.fence = fence;
            this.origin = origin;
            this.bound = bound;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public RandomIntsSpliterator trySplit() {
            long i10 = this.index;
            long m10 = (this.fence + i10) >>> 1;
            if (m10 <= i10) {
                return null;
            }
            SplittableRandom split = this.rng.split();
            this.index = m10;
            return new RandomIntsSpliterator(split, i10, m10, this.origin, this.bound);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            long i10 = this.index;
            long f10 = this.fence;
            if (i10 < f10) {
                consumer.accept(this.rng.internalNextInt(this.origin, this.bound));
                this.index = 1 + i10;
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer consumer) {
            long j10;
            if (consumer == null) {
                throw new NullPointerException();
            }
            long i10 = this.index;
            long f10 = this.fence;
            if (i10 < f10) {
                this.index = f10;
                SplittableRandom r10 = this.rng;
                int o10 = this.origin;
                int b4 = this.bound;
                do {
                    consumer.accept(r10.internalNextInt(o10, b4));
                    j10 = 1 + i10;
                    i10 = j10;
                } while (j10 < f10);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class RandomLongsSpliterator implements Spliterator.OfLong {
        final long bound;
        final long fence;
        long index;
        final long origin;
        final SplittableRandom rng;

        RandomLongsSpliterator(SplittableRandom rng, long index, long fence, long origin, long bound) {
            this.rng = rng;
            this.index = index;
            this.fence = fence;
            this.origin = origin;
            this.bound = bound;
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public RandomLongsSpliterator trySplit() {
            long i10 = this.index;
            long m10 = (this.fence + i10) >>> 1;
            if (m10 <= i10) {
                return null;
            }
            SplittableRandom split = this.rng.split();
            this.index = m10;
            return new RandomLongsSpliterator(split, i10, m10, this.origin, this.bound);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(LongConsumer consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            long i10 = this.index;
            long f10 = this.fence;
            if (i10 < f10) {
                consumer.accept(this.rng.internalNextLong(this.origin, this.bound));
                this.index = 1 + i10;
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(LongConsumer consumer) {
            long j10;
            if (consumer == null) {
                throw new NullPointerException();
            }
            long i10 = this.index;
            long f10 = this.fence;
            if (i10 < f10) {
                this.index = f10;
                SplittableRandom r10 = this.rng;
                long o10 = this.origin;
                long b4 = this.bound;
                do {
                    consumer.accept(r10.internalNextLong(o10, b4));
                    j10 = 1 + i10;
                    i10 = j10;
                } while (j10 < f10);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class RandomDoublesSpliterator implements Spliterator.OfDouble {
        final double bound;
        final long fence;
        long index;
        final double origin;
        final SplittableRandom rng;

        RandomDoublesSpliterator(SplittableRandom rng, long index, long fence, double origin, double bound) {
            this.rng = rng;
            this.index = index;
            this.fence = fence;
            this.origin = origin;
            this.bound = bound;
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public RandomDoublesSpliterator trySplit() {
            long i10 = this.index;
            long m10 = (this.fence + i10) >>> 1;
            if (m10 <= i10) {
                return null;
            }
            SplittableRandom split = this.rng.split();
            this.index = m10;
            return new RandomDoublesSpliterator(split, i10, m10, this.origin, this.bound);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(DoubleConsumer consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            long i10 = this.index;
            long f10 = this.fence;
            if (i10 < f10) {
                consumer.accept(this.rng.internalNextDouble(this.origin, this.bound));
                this.index = 1 + i10;
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(DoubleConsumer consumer) {
            long j10;
            if (consumer == null) {
                throw new NullPointerException();
            }
            long i10 = this.index;
            long f10 = this.fence;
            if (i10 < f10) {
                this.index = f10;
                SplittableRandom r10 = this.rng;
                double o10 = this.origin;
                double b4 = this.bound;
                do {
                    consumer.accept(r10.internalNextDouble(o10, b4));
                    j10 = 1 + i10;
                    i10 = j10;
                } while (j10 < f10);
            }
        }
    }
}
