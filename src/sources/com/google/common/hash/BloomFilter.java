package com.google.common.hash;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.common.base.l;
import com.google.common.base.o;
import com.google.common.base.p;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.math.LongMath;
import com.google.common.primitives.SignedBytes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class BloomFilter<T> implements p<T>, Serializable {
    private final BloomFilterStrategies.a bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        public final long[] data;
        public final Funnel<? super T> funnel;
        public final int numHashFunctions;
        public final Strategy strategy;

        public SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.a.h(((BloomFilter) bloomFilter).bits.f26622a);
            this.numHashFunctions = ((BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter) bloomFilter).funnel;
            this.strategy = ((BloomFilter) bloomFilter).strategy;
        }

        public Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.a(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Strategy extends Serializable {
        <T> boolean mightContain(T t2, Funnel<? super T> funnel, int i10, BloomFilterStrategies.a aVar);

        int ordinal();

        <T> boolean put(T t2, Funnel<? super T> funnel, int i10, BloomFilterStrategies.a aVar);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i10, double d10) {
        return create(funnel, i10, d10);
    }

    public static long optimalNumOfBits(long j10, double d10) {
        if (d10 == ShadowDrawableWrapper.COS_45) {
            d10 = Double.MIN_VALUE;
        }
        return (long) (((-j10) * Math.log(d10)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    public static int optimalNumOfHashFunctions(long j10, long j11) {
        return Math.max(1, (int) Math.round((j11 / j10) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        int i10;
        int i11;
        DataInputStream dataInputStream;
        byte readByte;
        int readInt;
        o.s(inputStream, "InputStream");
        o.s(funnel, "Funnel");
        byte b4 = -1;
        try {
            dataInputStream = new DataInputStream(inputStream);
            readByte = dataInputStream.readByte();
            try {
                i11 = com.google.common.primitives.f.c(dataInputStream.readByte());
            } catch (RuntimeException e2) {
                e = e2;
                i11 = -1;
            }
            try {
                readInt = dataInputStream.readInt();
            } catch (RuntimeException e10) {
                e = e10;
                b4 = readByte;
                i10 = -1;
                StringBuilder sb2 = new StringBuilder(134);
                sb2.append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
                sb2.append((int) b4);
                sb2.append(" numHashFunctions: ");
                sb2.append(i11);
                sb2.append(" dataLength: ");
                sb2.append(i10);
                throw new IOException(sb2.toString(), e);
            }
        } catch (RuntimeException e11) {
            e = e11;
            i10 = -1;
            i11 = -1;
        }
        try {
            BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
            BloomFilterStrategies.a aVar = new BloomFilterStrategies.a(LongMath.b(readInt, 64L));
            for (int i12 = 0; i12 < readInt; i12++) {
                aVar.f(i12, dataInputStream.readLong());
            }
            return new BloomFilter<>(aVar, i11, funnel, bloomFilterStrategies);
        } catch (RuntimeException e12) {
            e = e12;
            b4 = readByte;
            i10 = readInt;
            StringBuilder sb22 = new StringBuilder(134);
            sb22.append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
            sb22.append((int) b4);
            sb22.append(" numHashFunctions: ");
            sb22.append(i11);
            sb22.append(" dataLength: ");
            sb22.append(i10);
            throw new IOException(sb22.toString(), e);
        }
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.common.base.p
    @Deprecated
    public boolean apply(T t2) {
        return mightContain(t2);
    }

    public long approximateElementCount() {
        double b4 = this.bits.b();
        return com.google.common.math.b.c(((-Math.log1p(-(this.bits.a() / b4))) * b4) / this.numHashFunctions, RoundingMode.HALF_UP);
    }

    public long bitSize() {
        return this.bits.b();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.p
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.a() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return l.b(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        o.r(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(T t2) {
        return this.strategy.mightContain(t2, this.funnel, this.numHashFunctions, this.bits);
    }

    public boolean put(T t2) {
        return this.strategy.put(t2, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        o.r(bloomFilter);
        o.e(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i10 = this.numHashFunctions;
        int i11 = bloomFilter.numHashFunctions;
        o.i(i10 == i11, "BloomFilters must have the same number of hash functions (%s != %s)", i10, i11);
        o.k(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        o.n(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        o.n(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.e(bloomFilter.bits);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.a(this.strategy.ordinal()));
        dataOutputStream.writeByte(com.google.common.primitives.f.a(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.f26622a.length());
        for (int i10 = 0; i10 < this.bits.f26622a.length(); i10++) {
            dataOutputStream.writeLong(this.bits.f26622a.get(i10));
        }
    }

    private BloomFilter(BloomFilterStrategies.a aVar, int i10, Funnel<? super T> funnel, Strategy strategy) {
        o.h(i10 > 0, "numHashFunctions (%s) must be > 0", i10);
        o.h(i10 <= 255, "numHashFunctions (%s) must be <= 255", i10);
        this.bits = (BloomFilterStrategies.a) o.r(aVar);
        this.numHashFunctions = i10;
        this.funnel = (Funnel) o.r(funnel);
        this.strategy = (Strategy) o.r(strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10, double d10) {
        return create(funnel, j10, d10, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10, double d10, Strategy strategy) {
        o.r(funnel);
        o.j(j10 >= 0, "Expected insertions (%s) must be >= 0", j10);
        o.m(d10 > ShadowDrawableWrapper.COS_45, "False positive probability (%s) must be > 0.0", Double.valueOf(d10));
        o.m(d10 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d10));
        o.r(strategy);
        if (j10 == 0) {
            j10 = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j10, d10);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.a(optimalNumOfBits), optimalNumOfHashFunctions(j10, optimalNumOfBits), funnel, strategy);
        } catch (IllegalArgumentException e2) {
            StringBuilder sb2 = new StringBuilder(57);
            sb2.append("Could not create BloomFilter of ");
            sb2.append(optimalNumOfBits);
            sb2.append(" bits");
            throw new IllegalArgumentException(sb2.toString(), e2);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i10) {
        return create(funnel, i10);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10) {
        return create(funnel, j10, 0.03d);
    }
}
