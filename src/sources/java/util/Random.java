package java.util;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;
import jdk.internal.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Random implements Serializable {
    static final String BadBound = "bound must be positive";
    static final String BadRange = "bound must be greater than origin";
    static final String BadSize = "size must be non-negative";
    private static final double DOUBLE_UNIT = 1.1102230246251565E-16d;
    private static final long addend = 11;
    private static final long mask = 281474976710655L;
    private static final long multiplier = 25214903917L;
    private static final long seedOffset;
    private static final AtomicLong seedUniquifier = new AtomicLong(8682522807148012L);
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("seed", Long.TYPE), new ObjectStreamField("nextNextGaussian", Double.TYPE), new ObjectStreamField("haveNextNextGaussian", Boolean.TYPE)};
    static final long serialVersionUID = 3905348978240129619L;
    private static final Unsafe unsafe;
    private boolean haveNextNextGaussian;
    private double nextNextGaussian;
    private final AtomicLong seed;

    public Random() {
        this(seedUniquifier() ^ System.nanoTime());
    }

    private static long seedUniquifier() {
        AtomicLong atomicLong;
        long current;
        long next;
        do {
            atomicLong = seedUniquifier;
            current = atomicLong.get();
            next = 1181783497276652981L * current;
        } while (!atomicLong.compareAndSet(current, next));
        return next;
    }

    static {
        Unsafe unsafe2 = Unsafe.getUnsafe();
        unsafe = unsafe2;
        try {
            seedOffset = unsafe2.objectFieldOffset(Random.class.getDeclaredField("seed"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public Random(long seed) {
        this.haveNextNextGaussian = false;
        if (getClass() == Random.class) {
            this.seed = new AtomicLong(initialScramble(seed));
        } else {
            this.seed = new AtomicLong();
            setSeed(seed);
        }
    }

    private static long initialScramble(long seed) {
        return (multiplier ^ seed) & mask;
    }

    public synchronized void setSeed(long seed) {
        this.seed.set(initialScramble(seed));
        this.haveNextNextGaussian = false;
    }

    protected int next(int bits) {
        long oldseed;
        long nextseed;
        AtomicLong seed = this.seed;
        do {
            oldseed = seed.get();
            nextseed = ((multiplier * oldseed) + addend) & mask;
        } while (!seed.compareAndSet(oldseed, nextseed));
        return (int) (nextseed >>> (48 - bits));
    }

    public void nextBytes(byte[] bytes) {
        int i10 = 0;
        int len = bytes.length;
        while (i10 < len) {
            int rnd = nextInt();
            int i11 = Math.min(len - i10, 4);
            while (true) {
                int n10 = i11 - 1;
                if (i11 > 0) {
                    bytes[i10] = (byte) rnd;
                    rnd >>= 8;
                    i10++;
                    i11 = n10;
                }
            }
        }
    }

    final long internalNextLong(long origin, long bound) {
        long r10 = nextLong();
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
                        u10 = nextLong() >>> 1;
                    } else {
                        return r11 + origin;
                    }
                }
            } else {
                while (true) {
                    if (r10 < origin || r10 >= bound) {
                        r10 = nextLong();
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
        if (origin < bound) {
            int n10 = bound - origin;
            if (n10 > 0) {
                return nextInt(n10) + origin;
            }
            while (true) {
                int r10 = nextInt();
                if (r10 >= origin && r10 < bound) {
                    return r10;
                }
            }
        } else {
            return nextInt();
        }
    }

    final double internalNextDouble(double origin, double bound) {
        double r10 = nextDouble();
        if (origin < bound) {
            double r11 = ((bound - origin) * r10) + origin;
            if (r11 >= bound) {
                return Double.longBitsToDouble(Double.doubleToLongBits(bound) - 1);
            }
            return r11;
        }
        return r10;
    }

    public int nextInt() {
        return next(32);
    }

    public int nextInt(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException(BadBound);
        }
        int r10 = next(31);
        int m10 = bound - 1;
        if ((bound & m10) == 0) {
            return (int) ((bound * r10) >> 31);
        }
        int u10 = r10;
        while (true) {
            int r11 = u10 % bound;
            if ((u10 - r11) + m10 >= 0) {
                return r11;
            }
            u10 = next(31);
        }
    }

    public long nextLong() {
        return (next(32) << 32) + next(32);
    }

    public boolean nextBoolean() {
        return next(1) != 0;
    }

    public float nextFloat() {
        return next(24) / 1.6777216E7f;
    }

    public double nextDouble() {
        return ((next(26) << 27) + next(27)) * DOUBLE_UNIT;
    }

    public synchronized double nextGaussian() {
        if (this.haveNextNextGaussian) {
            this.haveNextNextGaussian = false;
            return this.nextNextGaussian;
        }
        while (true) {
            double v12 = (nextDouble() * 2.0d) - 1.0d;
            double v2 = (nextDouble() * 2.0d) - 1.0d;
            double s2 = (v12 * v12) + (v2 * v2);
            if (s2 < 1.0d && s2 != ShadowDrawableWrapper.COS_45) {
                double multiplier2 = StrictMath.sqrt((StrictMath.log(s2) * (-2.0d)) / s2);
                this.nextNextGaussian = v2 * multiplier2;
                this.haveNextNextGaussian = true;
                return v12 * multiplier2;
            }
        }
    }

    public IntStream ints(long streamSize) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BadSize);
        }
        return StreamSupport.intStream(new RandomIntsSpliterator(this, 0L, streamSize, Integer.MAX_VALUE, 0), false);
    }

    public IntStream ints() {
        return StreamSupport.intStream(new RandomIntsSpliterator(this, 0L, Long.MAX_VALUE, Integer.MAX_VALUE, 0), false);
    }

    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BadSize);
        }
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BadRange);
        }
        return StreamSupport.intStream(new RandomIntsSpliterator(this, 0L, streamSize, randomNumberOrigin, randomNumberBound), false);
    }

    public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BadRange);
        }
        return StreamSupport.intStream(new RandomIntsSpliterator(this, 0L, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound), false);
    }

    public LongStream longs(long streamSize) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BadSize);
        }
        return StreamSupport.longStream(new RandomLongsSpliterator(this, 0L, streamSize, Long.MAX_VALUE, 0L), false);
    }

    public LongStream longs() {
        return StreamSupport.longStream(new RandomLongsSpliterator(this, 0L, Long.MAX_VALUE, Long.MAX_VALUE, 0L), false);
    }

    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BadSize);
        }
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BadRange);
        }
        return StreamSupport.longStream(new RandomLongsSpliterator(this, 0L, streamSize, randomNumberOrigin, randomNumberBound), false);
    }

    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BadRange);
        }
        return StreamSupport.longStream(new RandomLongsSpliterator(this, 0L, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound), false);
    }

    public DoubleStream doubles(long streamSize) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BadSize);
        }
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(this, 0L, streamSize, Double.MAX_VALUE, ShadowDrawableWrapper.COS_45), false);
    }

    public DoubleStream doubles() {
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(this, 0L, Long.MAX_VALUE, Double.MAX_VALUE, ShadowDrawableWrapper.COS_45), false);
    }

    public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BadSize);
        }
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BadRange);
        }
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(this, 0L, streamSize, randomNumberOrigin, randomNumberBound), false);
    }

    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BadRange);
        }
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(this, 0L, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound), false);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class RandomIntsSpliterator implements Spliterator.OfInt {
        final int bound;
        final long fence;
        long index;
        final int origin;
        final Random rng;

        RandomIntsSpliterator(Random rng, long index, long fence, int origin, int bound) {
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
            Random random = this.rng;
            this.index = m10;
            return new RandomIntsSpliterator(random, i10, m10, this.origin, this.bound);
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
                Random r10 = this.rng;
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
    static final class RandomLongsSpliterator implements Spliterator.OfLong {
        final long bound;
        final long fence;
        long index;
        final long origin;
        final Random rng;

        RandomLongsSpliterator(Random rng, long index, long fence, long origin, long bound) {
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
            Random random = this.rng;
            this.index = m10;
            return new RandomLongsSpliterator(random, i10, m10, this.origin, this.bound);
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
                Random r10 = this.rng;
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
    static final class RandomDoublesSpliterator implements Spliterator.OfDouble {
        final double bound;
        final long fence;
        long index;
        final double origin;
        final Random rng;

        RandomDoublesSpliterator(Random rng, long index, long fence, double origin, double bound) {
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
            Random random = this.rng;
            this.index = m10;
            return new RandomDoublesSpliterator(random, i10, m10, this.origin, this.bound);
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
                Random r10 = this.rng;
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

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s2.readFields();
        long seedVal = fields.get("seed", -1L);
        if (seedVal < 0) {
            throw new StreamCorruptedException("Random: invalid seed");
        }
        resetSeed(seedVal);
        this.nextNextGaussian = fields.get("nextNextGaussian", ShadowDrawableWrapper.COS_45);
        this.haveNextNextGaussian = fields.get("haveNextNextGaussian", false);
    }

    private synchronized void writeObject(ObjectOutputStream s2) throws IOException {
        ObjectOutputStream.PutField fields = s2.putFields();
        fields.put("seed", this.seed.get());
        fields.put("nextNextGaussian", this.nextNextGaussian);
        fields.put("haveNextNextGaussian", this.haveNextNextGaussian);
        s2.writeFields();
    }

    private void resetSeed(long seedVal) {
        unsafe.putReferenceVolatile(this, seedOffset, new AtomicLong(seedVal));
    }
}
