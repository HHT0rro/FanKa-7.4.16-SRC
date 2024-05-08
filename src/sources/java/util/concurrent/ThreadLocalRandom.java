package java.util.concurrent;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.AccessControlContext;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;
import jdk.internal.misc.Unsafe;
import jdk.internal.misc.VM;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ThreadLocalRandom extends Random {
    static final String BAD_BOUND = "bound must be positive";
    static final String BAD_RANGE = "bound must be greater than origin";
    static final String BAD_SIZE = "size must be non-negative";
    private static final double DOUBLE_UNIT = 1.1102230246251565E-16d;
    private static final float FLOAT_UNIT = 5.9604645E-8f;
    private static final long GOLDEN_GAMMA = -7046029254386353131L;
    private static final long INHERITABLETHREADLOCALS;
    private static final long INHERITEDACCESSCONTROLCONTEXT;
    private static final long PROBE;
    private static final int PROBE_INCREMENT = -1640531527;
    private static final long SECONDARY;
    private static final long SEED;
    private static final long SEEDER_INCREMENT = -4942790177534073029L;
    private static final long THREADLOCALS;
    private static final Unsafe U;
    private static final ThreadLocalRandom instance;
    private static final ThreadLocal<Double> nextLocalGaussian;
    private static final AtomicInteger probeGenerator;
    private static final AtomicLong seeder;
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("rnd", Long.TYPE), new ObjectStreamField("initialized", Boolean.TYPE)};
    private static final long serialVersionUID = -5851777807851030925L;
    boolean initialized = true;

    private static long mix64(long z10) {
        long z11 = ((z10 >>> 33) ^ z10) * (-49064778989728563L);
        long z12 = ((z11 >>> 33) ^ z11) * (-4265267296055464877L);
        return (z12 >>> 33) ^ z12;
    }

    private static int mix32(long z10) {
        long z11 = ((z10 >>> 33) ^ z10) * (-49064778989728563L);
        return (int) ((((z11 >>> 33) ^ z11) * (-4265267296055464877L)) >>> 32);
    }

    private ThreadLocalRandom() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void localInit() {
        int p10 = probeGenerator.addAndGet(PROBE_INCREMENT);
        int probe = p10 == 0 ? 1 : p10;
        long seed = mix64(seeder.getAndAdd(SEEDER_INCREMENT));
        Thread t2 = Thread.currentThread();
        Unsafe unsafe = U;
        unsafe.putLong(t2, SEED, seed);
        unsafe.putInt(t2, PROBE, probe);
    }

    public static ThreadLocalRandom current() {
        if (U.getInt(Thread.currentThread(), PROBE) == 0) {
            localInit();
        }
        return instance;
    }

    @Override // java.util.Random
    public void setSeed(long seed) {
        if (this.initialized) {
            throw new UnsupportedOperationException();
        }
    }

    final long nextSeed() {
        Unsafe unsafe = U;
        Thread t2 = Thread.currentThread();
        long j10 = SEED;
        long r10 = unsafe.getLong(t2, j10) + (t2.getId() << 1) + GOLDEN_GAMMA;
        unsafe.putLong(t2, j10, r10);
        return r10;
    }

    @Override // java.util.Random
    protected int next(int bits) {
        return nextInt() >>> (32 - bits);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int getProbe() {
        return U.getInt(Thread.currentThread(), PROBE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int advanceProbe(int probe) {
        int probe2 = probe ^ (probe << 13);
        int probe3 = probe2 ^ (probe2 >>> 17);
        int probe4 = probe3 ^ (probe3 << 5);
        U.putInt(Thread.currentThread(), PROBE, probe4);
        return probe4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int nextSecondarySeed() {
        int r10;
        Thread t2 = Thread.currentThread();
        Unsafe unsafe = U;
        long j10 = SECONDARY;
        int r11 = unsafe.getInt(t2, j10);
        if (r11 != 0) {
            int r12 = (r11 << 13) ^ r11;
            int r13 = r12 ^ (r12 >>> 17);
            r10 = r13 ^ (r13 << 5);
        } else {
            int r14 = mix32(seeder.getAndAdd(SEEDER_INCREMENT));
            if (r14 != 0) {
                r10 = r14;
            } else {
                r10 = 1;
            }
        }
        unsafe.putInt(t2, j10, r10);
        return r10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void eraseThreadLocals(Thread thread) {
        Unsafe unsafe = U;
        unsafe.putReference(thread, THREADLOCALS, null);
        unsafe.putReference(thread, INHERITABLETHREADLOCALS, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setInheritedAccessControlContext(Thread thread, AccessControlContext acc) {
        U.putReferenceRelease(thread, INHERITEDACCESSCONTROLCONTEXT, acc);
    }

    static {
        Unsafe unsafe = Unsafe.getUnsafe();
        U = unsafe;
        SEED = unsafe.objectFieldOffset(Thread.class, "threadLocalRandomSeed");
        PROBE = unsafe.objectFieldOffset(Thread.class, "threadLocalRandomProbe");
        SECONDARY = unsafe.objectFieldOffset(Thread.class, "threadLocalRandomSecondarySeed");
        THREADLOCALS = unsafe.objectFieldOffset(Thread.class, "threadLocals");
        INHERITABLETHREADLOCALS = unsafe.objectFieldOffset(Thread.class, "inheritableThreadLocals");
        INHERITEDACCESSCONTROLCONTEXT = unsafe.objectFieldOffset(Thread.class, "inheritedAccessControlContext");
        nextLocalGaussian = new ThreadLocal<>();
        probeGenerator = new AtomicInteger();
        instance = new ThreadLocalRandom();
        seeder = new AtomicLong(mix64(System.currentTimeMillis()) ^ mix64(System.nanoTime()));
        String sec = VM.getSavedProperty("java.util.secureRandomSeed");
        if (Boolean.parseBoolean(sec)) {
            byte[] seedBytes = SecureRandom.getSeed(8);
            long s2 = seedBytes[0] & 255;
            for (int i10 = 1; i10 < 8; i10++) {
                s2 = (s2 << 8) | (seedBytes[i10] & 255);
            }
            seeder.set(s2);
        }
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        ObjectOutputStream.PutField fields = s2.putFields();
        fields.put("rnd", U.getLong(Thread.currentThread(), SEED));
        fields.put("initialized", true);
        s2.writeFields();
    }

    private Object readResolve() {
        return current();
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

    @Override // java.util.Random
    public int nextInt() {
        return mix32(nextSeed());
    }

    @Override // java.util.Random
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

    @Override // java.util.Random
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

    @Override // java.util.Random
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

    @Override // java.util.Random
    public boolean nextBoolean() {
        return mix32(nextSeed()) < 0;
    }

    @Override // java.util.Random
    public float nextFloat() {
        return (mix32(nextSeed()) >>> 8) * FLOAT_UNIT;
    }

    @Override // java.util.Random
    public double nextGaussian() {
        ThreadLocal<Double> threadLocal = nextLocalGaussian;
        Double d10 = threadLocal.get();
        if (d10 != null) {
            threadLocal.set(null);
            return d10.doubleValue();
        }
        while (true) {
            double v12 = (nextDouble() * 2.0d) - 1.0d;
            double v2 = (nextDouble() * 2.0d) - 1.0d;
            double s2 = (v12 * v12) + (v2 * v2);
            if (s2 < 1.0d && s2 != ShadowDrawableWrapper.COS_45) {
                double multiplier = StrictMath.sqrt((StrictMath.log(s2) * (-2.0d)) / s2);
                nextLocalGaussian.set(Double.valueOf(v2 * multiplier));
                return v12 * multiplier;
            }
        }
    }

    @Override // java.util.Random
    public IntStream ints(long streamSize) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        return StreamSupport.intStream(new RandomIntsSpliterator(0L, streamSize, Integer.MAX_VALUE, 0), false);
    }

    @Override // java.util.Random
    public IntStream ints() {
        return StreamSupport.intStream(new RandomIntsSpliterator(0L, Long.MAX_VALUE, Integer.MAX_VALUE, 0), false);
    }

    @Override // java.util.Random
    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return StreamSupport.intStream(new RandomIntsSpliterator(0L, streamSize, randomNumberOrigin, randomNumberBound), false);
    }

    @Override // java.util.Random
    public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return StreamSupport.intStream(new RandomIntsSpliterator(0L, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound), false);
    }

    @Override // java.util.Random
    public LongStream longs(long streamSize) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        return StreamSupport.longStream(new RandomLongsSpliterator(0L, streamSize, Long.MAX_VALUE, 0L), false);
    }

    @Override // java.util.Random
    public LongStream longs() {
        return StreamSupport.longStream(new RandomLongsSpliterator(0L, Long.MAX_VALUE, Long.MAX_VALUE, 0L), false);
    }

    @Override // java.util.Random
    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return StreamSupport.longStream(new RandomLongsSpliterator(0L, streamSize, randomNumberOrigin, randomNumberBound), false);
    }

    @Override // java.util.Random
    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return StreamSupport.longStream(new RandomLongsSpliterator(0L, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound), false);
    }

    @Override // java.util.Random
    public DoubleStream doubles(long streamSize) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(0L, streamSize, Double.MAX_VALUE, ShadowDrawableWrapper.COS_45), false);
    }

    @Override // java.util.Random
    public DoubleStream doubles() {
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(0L, Long.MAX_VALUE, Double.MAX_VALUE, ShadowDrawableWrapper.COS_45), false);
    }

    @Override // java.util.Random
    public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        if (streamSize < 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(0L, streamSize, randomNumberOrigin, randomNumberBound), false);
    }

    @Override // java.util.Random
    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        if (randomNumberOrigin >= randomNumberBound) {
            throw new IllegalArgumentException(BAD_RANGE);
        }
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(0L, Long.MAX_VALUE, randomNumberOrigin, randomNumberBound), false);
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

        RandomIntsSpliterator(long index, long fence, int origin, int bound) {
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
            this.index = m10;
            return new RandomIntsSpliterator(i10, m10, this.origin, this.bound);
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
                consumer.accept(ThreadLocalRandom.current().internalNextInt(this.origin, this.bound));
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
                int o10 = this.origin;
                int b4 = this.bound;
                ThreadLocalRandom rng = ThreadLocalRandom.current();
                do {
                    consumer.accept(rng.internalNextInt(o10, b4));
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

        RandomLongsSpliterator(long index, long fence, long origin, long bound) {
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
            this.index = m10;
            return new RandomLongsSpliterator(i10, m10, this.origin, this.bound);
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
                consumer.accept(ThreadLocalRandom.current().internalNextLong(this.origin, this.bound));
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
                long o10 = this.origin;
                long b4 = this.bound;
                ThreadLocalRandom rng = ThreadLocalRandom.current();
                do {
                    consumer.accept(rng.internalNextLong(o10, b4));
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

        RandomDoublesSpliterator(long index, long fence, double origin, double bound) {
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
            this.index = m10;
            return new RandomDoublesSpliterator(i10, m10, this.origin, this.bound);
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
                consumer.accept(ThreadLocalRandom.current().internalNextDouble(this.origin, this.bound));
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
                double o10 = this.origin;
                double b4 = this.bound;
                ThreadLocalRandom rng = ThreadLocalRandom.current();
                do {
                    consumer.accept(rng.internalNextDouble(o10, b4));
                    j10 = 1 + i10;
                    i10 = j10;
                } while (j10 < f10);
            }
        }
    }
}
