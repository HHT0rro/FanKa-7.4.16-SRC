package com.google.common.hash;

import com.google.common.base.o;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t2, Funnel<? super T> funnel, int i10, a aVar) {
            long b4 = aVar.b();
            long asLong = Hashing.a().hashObject(t2, funnel).asLong();
            int i11 = (int) asLong;
            int i12 = (int) (asLong >>> 32);
            for (int i13 = 1; i13 <= i10; i13++) {
                int i14 = (i13 * i12) + i11;
                if (i14 < 0) {
                    i14 = ~i14;
                }
                if (!aVar.d(i14 % b4)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t2, Funnel<? super T> funnel, int i10, a aVar) {
            long b4 = aVar.b();
            long asLong = Hashing.a().hashObject(t2, funnel).asLong();
            int i11 = (int) asLong;
            int i12 = (int) (asLong >>> 32);
            boolean z10 = false;
            for (int i13 = 1; i13 <= i10; i13++) {
                int i14 = (i13 * i12) + i11;
                if (i14 < 0) {
                    i14 = ~i14;
                }
                z10 |= aVar.g(i14 % b4);
            }
            return z10;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long lowerEight(byte[] bArr) {
            return Longs.d(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.d(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t2, Funnel<? super T> funnel, int i10, a aVar) {
            long b4 = aVar.b();
            byte[] bytesInternal = Hashing.a().hashObject(t2, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i11 = 0; i11 < i10; i11++) {
                if (!aVar.d((Long.MAX_VALUE & lowerEight) % b4)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t2, Funnel<? super T> funnel, int i10, a aVar) {
            long b4 = aVar.b();
            byte[] bytesInternal = Hashing.a().hashObject(t2, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z10 = false;
            for (int i11 = 0; i11 < i10; i11++) {
                z10 |= aVar.g((Long.MAX_VALUE & lowerEight) % b4);
                lowerEight += upperEight;
            }
            return z10;
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicLongArray f26622a;

        /* renamed from: b, reason: collision with root package name */
        public final j f26623b;

        public a(long j10) {
            o.e(j10 > 0, "data length is zero!");
            this.f26622a = new AtomicLongArray(Ints.c(LongMath.c(j10, 64L, RoundingMode.CEILING)));
            this.f26623b = LongAddables.a();
        }

        public static long[] h(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i10 = 0; i10 < length; i10++) {
                jArr[i10] = atomicLongArray.get(i10);
            }
            return jArr;
        }

        public long a() {
            return this.f26623b.sum();
        }

        public long b() {
            return this.f26622a.length() * 64;
        }

        public a c() {
            return new a(h(this.f26622a));
        }

        public boolean d(long j10) {
            return ((1 << ((int) j10)) & this.f26622a.get((int) (j10 >>> 6))) != 0;
        }

        public void e(a aVar) {
            o.i(this.f26622a.length() == aVar.f26622a.length(), "BitArrays must be of equal length (%s != %s)", this.f26622a.length(), aVar.f26622a.length());
            for (int i10 = 0; i10 < this.f26622a.length(); i10++) {
                f(i10, aVar.f26622a.get(i10));
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Arrays.equals(h(this.f26622a), h(((a) obj).f26622a));
            }
            return false;
        }

        public void f(int i10, long j10) {
            long j11;
            long j12;
            boolean z10;
            while (true) {
                j11 = this.f26622a.get(i10);
                j12 = j11 | j10;
                if (j11 == j12) {
                    z10 = false;
                    break;
                } else if (this.f26622a.compareAndSet(i10, j11, j12)) {
                    z10 = true;
                    break;
                }
            }
            if (z10) {
                this.f26623b.add(Long.bitCount(j12) - Long.bitCount(j11));
            }
        }

        public boolean g(long j10) {
            long j11;
            long j12;
            if (d(j10)) {
                return false;
            }
            int i10 = (int) (j10 >>> 6);
            long j13 = 1 << ((int) j10);
            do {
                j11 = this.f26622a.get(i10);
                j12 = j11 | j13;
                if (j11 == j12) {
                    return false;
                }
            } while (!this.f26622a.compareAndSet(i10, j11, j12));
            this.f26623b.increment();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(h(this.f26622a));
        }

        public a(long[] jArr) {
            o.e(jArr.length > 0, "data length is zero!");
            this.f26622a = new AtomicLongArray(jArr);
            this.f26623b = LongAddables.a();
            long j10 = 0;
            for (long j11 : jArr) {
                j10 += Long.bitCount(j11);
            }
            this.f26623b.add(j10);
        }
    }
}
