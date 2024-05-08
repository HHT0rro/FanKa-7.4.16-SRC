package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class Murmur3_128HashFunction extends b implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    public static final e MURMUR3_128 = new Murmur3_128HashFunction(0);
    public static final e GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.f26626a);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a extends d {

        /* renamed from: d, reason: collision with root package name */
        public long f26631d;

        /* renamed from: e, reason: collision with root package name */
        public long f26632e;

        /* renamed from: f, reason: collision with root package name */
        public int f26633f;

        public a(int i10) {
            super(16);
            long j10 = i10;
            this.f26631d = j10;
            this.f26632e = j10;
            this.f26633f = 0;
        }

        public static long r(long j10) {
            long j11 = (j10 ^ (j10 >>> 33)) * (-49064778989728563L);
            long j12 = (j11 ^ (j11 >>> 33)) * (-4265267296055464877L);
            return j12 ^ (j12 >>> 33);
        }

        public static long s(long j10) {
            return Long.rotateLeft(j10 * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        public static long t(long j10) {
            return Long.rotateLeft(j10 * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // com.google.common.hash.d
        public HashCode k() {
            long j10 = this.f26631d;
            int i10 = this.f26633f;
            long j11 = j10 ^ i10;
            long j12 = this.f26632e ^ i10;
            long j13 = j11 + j12;
            this.f26631d = j13;
            this.f26632e = j12 + j13;
            this.f26631d = r(j13);
            long r10 = r(this.f26632e);
            long j14 = this.f26631d + r10;
            this.f26631d = j14;
            this.f26632e = r10 + j14;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f26631d).putLong(this.f26632e).array());
        }

        @Override // com.google.common.hash.d
        public void n(ByteBuffer byteBuffer) {
            q(byteBuffer.getLong(), byteBuffer.getLong());
            this.f26633f += 16;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x001b. Please report as an issue. */
        @Override // com.google.common.hash.d
        public void o(ByteBuffer byteBuffer) {
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            long j15;
            long c4;
            long j16;
            long j17;
            long j18;
            long j19;
            long j20;
            long j21;
            long j22;
            this.f26633f += byteBuffer.remaining();
            long j23 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j10 = 0;
                    c4 = com.google.common.primitives.f.c(byteBuffer.get(0)) ^ j10;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 2:
                    j11 = 0;
                    j10 = j11 ^ (com.google.common.primitives.f.c(byteBuffer.get(1)) << 8);
                    c4 = com.google.common.primitives.f.c(byteBuffer.get(0)) ^ j10;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 3:
                    j12 = 0;
                    j11 = j12 ^ (com.google.common.primitives.f.c(byteBuffer.get(2)) << 16);
                    j10 = j11 ^ (com.google.common.primitives.f.c(byteBuffer.get(1)) << 8);
                    c4 = com.google.common.primitives.f.c(byteBuffer.get(0)) ^ j10;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 4:
                    j13 = 0;
                    j12 = j13 ^ (com.google.common.primitives.f.c(byteBuffer.get(3)) << 24);
                    j11 = j12 ^ (com.google.common.primitives.f.c(byteBuffer.get(2)) << 16);
                    j10 = j11 ^ (com.google.common.primitives.f.c(byteBuffer.get(1)) << 8);
                    c4 = com.google.common.primitives.f.c(byteBuffer.get(0)) ^ j10;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 5:
                    j14 = 0;
                    j13 = j14 ^ (com.google.common.primitives.f.c(byteBuffer.get(4)) << 32);
                    j12 = j13 ^ (com.google.common.primitives.f.c(byteBuffer.get(3)) << 24);
                    j11 = j12 ^ (com.google.common.primitives.f.c(byteBuffer.get(2)) << 16);
                    j10 = j11 ^ (com.google.common.primitives.f.c(byteBuffer.get(1)) << 8);
                    c4 = com.google.common.primitives.f.c(byteBuffer.get(0)) ^ j10;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 6:
                    j15 = 0;
                    j14 = j15 ^ (com.google.common.primitives.f.c(byteBuffer.get(5)) << 40);
                    j13 = j14 ^ (com.google.common.primitives.f.c(byteBuffer.get(4)) << 32);
                    j12 = j13 ^ (com.google.common.primitives.f.c(byteBuffer.get(3)) << 24);
                    j11 = j12 ^ (com.google.common.primitives.f.c(byteBuffer.get(2)) << 16);
                    j10 = j11 ^ (com.google.common.primitives.f.c(byteBuffer.get(1)) << 8);
                    c4 = com.google.common.primitives.f.c(byteBuffer.get(0)) ^ j10;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 7:
                    j15 = (com.google.common.primitives.f.c(byteBuffer.get(6)) << 48) ^ 0;
                    j14 = j15 ^ (com.google.common.primitives.f.c(byteBuffer.get(5)) << 40);
                    j13 = j14 ^ (com.google.common.primitives.f.c(byteBuffer.get(4)) << 32);
                    j12 = j13 ^ (com.google.common.primitives.f.c(byteBuffer.get(3)) << 24);
                    j11 = j12 ^ (com.google.common.primitives.f.c(byteBuffer.get(2)) << 16);
                    j10 = j11 ^ (com.google.common.primitives.f.c(byteBuffer.get(1)) << 8);
                    c4 = com.google.common.primitives.f.c(byteBuffer.get(0)) ^ j10;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 8:
                    j16 = 0;
                    c4 = byteBuffer.getLong() ^ 0;
                    j23 = j16;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 9:
                    j17 = 0;
                    j16 = j17 ^ com.google.common.primitives.f.c(byteBuffer.get(8));
                    c4 = byteBuffer.getLong() ^ 0;
                    j23 = j16;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 10:
                    j18 = 0;
                    j17 = j18 ^ (com.google.common.primitives.f.c(byteBuffer.get(9)) << 8);
                    j16 = j17 ^ com.google.common.primitives.f.c(byteBuffer.get(8));
                    c4 = byteBuffer.getLong() ^ 0;
                    j23 = j16;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 11:
                    j19 = 0;
                    j18 = j19 ^ (com.google.common.primitives.f.c(byteBuffer.get(10)) << 16);
                    j17 = j18 ^ (com.google.common.primitives.f.c(byteBuffer.get(9)) << 8);
                    j16 = j17 ^ com.google.common.primitives.f.c(byteBuffer.get(8));
                    c4 = byteBuffer.getLong() ^ 0;
                    j23 = j16;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 12:
                    j20 = 0;
                    j19 = j20 ^ (com.google.common.primitives.f.c(byteBuffer.get(11)) << 24);
                    j18 = j19 ^ (com.google.common.primitives.f.c(byteBuffer.get(10)) << 16);
                    j17 = j18 ^ (com.google.common.primitives.f.c(byteBuffer.get(9)) << 8);
                    j16 = j17 ^ com.google.common.primitives.f.c(byteBuffer.get(8));
                    c4 = byteBuffer.getLong() ^ 0;
                    j23 = j16;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 13:
                    j21 = 0;
                    j20 = j21 ^ (com.google.common.primitives.f.c(byteBuffer.get(12)) << 32);
                    j19 = j20 ^ (com.google.common.primitives.f.c(byteBuffer.get(11)) << 24);
                    j18 = j19 ^ (com.google.common.primitives.f.c(byteBuffer.get(10)) << 16);
                    j17 = j18 ^ (com.google.common.primitives.f.c(byteBuffer.get(9)) << 8);
                    j16 = j17 ^ com.google.common.primitives.f.c(byteBuffer.get(8));
                    c4 = byteBuffer.getLong() ^ 0;
                    j23 = j16;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 14:
                    j22 = 0;
                    j21 = j22 ^ (com.google.common.primitives.f.c(byteBuffer.get(13)) << 40);
                    j20 = j21 ^ (com.google.common.primitives.f.c(byteBuffer.get(12)) << 32);
                    j19 = j20 ^ (com.google.common.primitives.f.c(byteBuffer.get(11)) << 24);
                    j18 = j19 ^ (com.google.common.primitives.f.c(byteBuffer.get(10)) << 16);
                    j17 = j18 ^ (com.google.common.primitives.f.c(byteBuffer.get(9)) << 8);
                    j16 = j17 ^ com.google.common.primitives.f.c(byteBuffer.get(8));
                    c4 = byteBuffer.getLong() ^ 0;
                    j23 = j16;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                case 15:
                    j22 = (com.google.common.primitives.f.c(byteBuffer.get(14)) << 48) ^ 0;
                    j21 = j22 ^ (com.google.common.primitives.f.c(byteBuffer.get(13)) << 40);
                    j20 = j21 ^ (com.google.common.primitives.f.c(byteBuffer.get(12)) << 32);
                    j19 = j20 ^ (com.google.common.primitives.f.c(byteBuffer.get(11)) << 24);
                    j18 = j19 ^ (com.google.common.primitives.f.c(byteBuffer.get(10)) << 16);
                    j17 = j18 ^ (com.google.common.primitives.f.c(byteBuffer.get(9)) << 8);
                    j16 = j17 ^ com.google.common.primitives.f.c(byteBuffer.get(8));
                    c4 = byteBuffer.getLong() ^ 0;
                    j23 = j16;
                    this.f26631d ^= s(c4);
                    this.f26632e ^= t(j23);
                    return;
                default:
                    throw new AssertionError((Object) "Should never get here.");
            }
        }

        public final void q(long j10, long j11) {
            long s2 = s(j10) ^ this.f26631d;
            this.f26631d = s2;
            long rotateLeft = Long.rotateLeft(s2, 27);
            long j12 = this.f26632e;
            this.f26631d = ((rotateLeft + j12) * 5) + 1390208809;
            long t2 = t(j11) ^ j12;
            this.f26632e = t2;
            this.f26632e = ((Long.rotateLeft(t2, 31) + this.f26631d) * 5) + 944331445;
        }
    }

    public Murmur3_128HashFunction(int i10) {
        this.seed = i10;
    }

    public int bits() {
        return 128;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.e
    public f newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        int i10 = this.seed;
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Hashing.murmur3_128(");
        sb2.append(i10);
        sb2.append(")");
        return sb2.toString();
    }
}
