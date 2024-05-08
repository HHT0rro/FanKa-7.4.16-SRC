package com.google.common.hash;

import com.google.common.base.o;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class SipHashFunction extends b implements Serializable {
    public static final e SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c, reason: collision with root package name */
    private final int f26639c;

    /* renamed from: d, reason: collision with root package name */
    private final int f26640d;

    /* renamed from: k0, reason: collision with root package name */
    private final long f26641k0;

    /* renamed from: k1, reason: collision with root package name */
    private final long f26642k1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a extends d {

        /* renamed from: d, reason: collision with root package name */
        public final int f26643d;

        /* renamed from: e, reason: collision with root package name */
        public final int f26644e;

        /* renamed from: f, reason: collision with root package name */
        public long f26645f;

        /* renamed from: g, reason: collision with root package name */
        public long f26646g;

        /* renamed from: h, reason: collision with root package name */
        public long f26647h;

        /* renamed from: i, reason: collision with root package name */
        public long f26648i;

        /* renamed from: j, reason: collision with root package name */
        public long f26649j;

        /* renamed from: k, reason: collision with root package name */
        public long f26650k;

        public a(int i10, int i11, long j10, long j11) {
            super(8);
            this.f26649j = 0L;
            this.f26650k = 0L;
            this.f26643d = i10;
            this.f26644e = i11;
            this.f26645f = 8317987319222330741L ^ j10;
            this.f26646g = 7237128888997146477L ^ j11;
            this.f26647h = 7816392313619706465L ^ j10;
            this.f26648i = 8387220255154660723L ^ j11;
        }

        @Override // com.google.common.hash.d
        public HashCode k() {
            long j10 = this.f26650k ^ (this.f26649j << 56);
            this.f26650k = j10;
            q(j10);
            this.f26647h ^= 255;
            r(this.f26644e);
            return HashCode.fromLong(((this.f26645f ^ this.f26646g) ^ this.f26647h) ^ this.f26648i);
        }

        @Override // com.google.common.hash.d
        public void n(ByteBuffer byteBuffer) {
            this.f26649j += 8;
            q(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.d
        public void o(ByteBuffer byteBuffer) {
            this.f26649j += byteBuffer.remaining();
            int i10 = 0;
            while (byteBuffer.hasRemaining()) {
                this.f26650k ^= (byteBuffer.get() & 255) << i10;
                i10 += 8;
            }
        }

        public final void q(long j10) {
            this.f26648i ^= j10;
            r(this.f26643d);
            this.f26645f = j10 ^ this.f26645f;
        }

        public final void r(int i10) {
            for (int i11 = 0; i11 < i10; i11++) {
                long j10 = this.f26645f;
                long j11 = this.f26646g;
                this.f26645f = j10 + j11;
                this.f26647h += this.f26648i;
                this.f26646g = Long.rotateLeft(j11, 13);
                long rotateLeft = Long.rotateLeft(this.f26648i, 16);
                long j12 = this.f26646g;
                long j13 = this.f26645f;
                this.f26646g = j12 ^ j13;
                this.f26648i = rotateLeft ^ this.f26647h;
                long rotateLeft2 = Long.rotateLeft(j13, 32);
                long j14 = this.f26647h;
                long j15 = this.f26646g;
                this.f26647h = j14 + j15;
                this.f26645f = rotateLeft2 + this.f26648i;
                this.f26646g = Long.rotateLeft(j15, 17);
                long rotateLeft3 = Long.rotateLeft(this.f26648i, 21);
                long j16 = this.f26646g;
                long j17 = this.f26647h;
                this.f26646g = j16 ^ j17;
                this.f26648i = rotateLeft3 ^ this.f26645f;
                this.f26647h = Long.rotateLeft(j17, 32);
            }
        }
    }

    public SipHashFunction(int i10, int i11, long j10, long j11) {
        o.h(i10 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i10);
        o.h(i11 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i11);
        this.f26639c = i10;
        this.f26640d = i11;
        this.f26641k0 = j10;
        this.f26642k1 = j11;
    }

    public int bits() {
        return 64;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        return this.f26639c == sipHashFunction.f26639c && this.f26640d == sipHashFunction.f26640d && this.f26641k0 == sipHashFunction.f26641k0 && this.f26642k1 == sipHashFunction.f26642k1;
    }

    public int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ this.f26639c) ^ this.f26640d) ^ this.f26641k0) ^ this.f26642k1);
    }

    @Override // com.google.common.hash.e
    public f newHasher() {
        return new a(this.f26639c, this.f26640d, this.f26641k0, this.f26642k1);
    }

    public String toString() {
        int i10 = this.f26639c;
        int i11 = this.f26640d;
        long j10 = this.f26641k0;
        long j11 = this.f26642k1;
        StringBuilder sb2 = new StringBuilder(81);
        sb2.append("Hashing.sipHash");
        sb2.append(i10);
        sb2.append(i11);
        sb2.append("(");
        sb2.append(j10);
        sb2.append(", ");
        sb2.append(j11);
        sb2.append(")");
        return sb2.toString();
    }
}
