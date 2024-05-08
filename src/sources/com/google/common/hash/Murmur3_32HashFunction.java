package com.google.common.hash;

import com.google.common.base.o;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Murmur3_32HashFunction extends b implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    private static final long serialVersionUID = 0;
    private final int seed;
    private final boolean supplementaryPlaneFix;
    public static final e MURMUR3_32 = new Murmur3_32HashFunction(0, false);
    public static final e MURMUR3_32_FIXED = new Murmur3_32HashFunction(0, true);
    public static final e GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.f26626a, true);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public int f26634a;

        /* renamed from: b, reason: collision with root package name */
        public long f26635b;

        /* renamed from: c, reason: collision with root package name */
        public int f26636c;

        /* renamed from: d, reason: collision with root package name */
        public int f26637d = 0;

        /* renamed from: e, reason: collision with root package name */
        public boolean f26638e = false;

        public a(int i10) {
            this.f26634a = i10;
        }

        @Override // com.google.common.hash.c, com.google.common.hash.f
        public f g(byte[] bArr, int i10, int i11) {
            o.w(i10, i10 + i11, bArr.length);
            int i12 = 0;
            while (true) {
                int i13 = i12 + 4;
                if (i13 > i11) {
                    break;
                }
                l(4, Murmur3_32HashFunction.getIntLittleEndian(bArr, i12 + i10));
                i12 = i13;
            }
            while (i12 < i11) {
                k(bArr[i10 + i12]);
                i12++;
            }
            return this;
        }

        @Override // com.google.common.hash.f
        public f h(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                a(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                k(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }

        @Override // com.google.common.hash.f
        public HashCode hash() {
            o.x(!this.f26638e);
            this.f26638e = true;
            int mixK1 = this.f26634a ^ Murmur3_32HashFunction.mixK1((int) this.f26635b);
            this.f26634a = mixK1;
            return Murmur3_32HashFunction.fmix(mixK1, this.f26637d);
        }

        @Override // com.google.common.hash.c
        public f j(char c4) {
            l(2, c4);
            return this;
        }

        public f k(byte b4) {
            l(1, b4 & 255);
            return this;
        }

        public final void l(int i10, long j10) {
            long j11 = this.f26635b;
            int i11 = this.f26636c;
            long j12 = ((j10 & 4294967295L) << i11) | j11;
            this.f26635b = j12;
            int i12 = i11 + (i10 * 8);
            this.f26636c = i12;
            this.f26637d += i10;
            if (i12 >= 32) {
                this.f26634a = Murmur3_32HashFunction.mixH1(this.f26634a, Murmur3_32HashFunction.mixK1((int) j12));
                this.f26635b >>>= 32;
                this.f26636c -= 32;
            }
        }

        @Override // com.google.common.hash.k
        public f a(int i10) {
            l(4, i10);
            return this;
        }

        @Override // com.google.common.hash.k
        public f b(long j10) {
            l(4, (int) j10);
            l(4, j10 >>> 32);
            return this;
        }

        @Override // com.google.common.hash.c, com.google.common.hash.k
        public f d(CharSequence charSequence, Charset charset) {
            if (com.google.common.base.c.f25961c.equals(charset)) {
                int length = charSequence.length();
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 4;
                    if (i11 > length) {
                        break;
                    }
                    char charAt = charSequence.charAt(i10);
                    char charAt2 = charSequence.charAt(i10 + 1);
                    char charAt3 = charSequence.charAt(i10 + 2);
                    char charAt4 = charSequence.charAt(i10 + 3);
                    if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                        break;
                    }
                    l(4, (charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24));
                    i10 = i11;
                }
                while (i10 < length) {
                    char charAt5 = charSequence.charAt(i10);
                    if (charAt5 < 128) {
                        l(1, charAt5);
                    } else if (charAt5 < 2048) {
                        l(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(charAt5));
                    } else if (charAt5 >= 55296 && charAt5 <= 57343) {
                        int codePointAt = Character.codePointAt(charSequence, i10);
                        if (codePointAt == charAt5) {
                            e(charSequence.subSequence(i10, length).toString().getBytes(charset));
                            return this;
                        }
                        i10++;
                        l(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePointAt));
                    } else {
                        l(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(charAt5));
                    }
                    i10++;
                }
                return this;
            }
            return super.d(charSequence, charset);
        }
    }

    public Murmur3_32HashFunction(int i10, boolean z10) {
        this.seed = i10;
        this.supplementaryPlaneFix = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToThreeUtf8Bytes(char c4) {
        return (c4 >>> '\f') | 224 | ((((c4 >>> 6) & 63) | 128) << 8) | (((c4 & '?') | 128) << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToTwoUtf8Bytes(char c4) {
        return (c4 >>> 6) | 192 | (((c4 & '?') | 128) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long codePointToFourUtf8Bytes(int i10) {
        return (i10 >>> 18) | 240 | ((((i10 >>> 12) & 63) | 128) << 8) | ((((i10 >>> 6) & 63) | 128) << 16) | (((i10 & 63) | 128) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashCode fmix(int i10, int i11) {
        int i12 = i10 ^ i11;
        int i13 = (i12 ^ (i12 >>> 16)) * (-2048144789);
        int i14 = (i13 ^ (i13 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i14 ^ (i14 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getIntLittleEndian(byte[] bArr, int i10) {
        return Ints.f(bArr[i10 + 3], bArr[i10 + 2], bArr[i10 + 1], bArr[i10]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixH1(int i10, int i11) {
        return (Integer.rotateLeft(i10 ^ i11, 13) * 5) - 430675100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixK1(int i10) {
        return Integer.rotateLeft(i10 * C1, 15) * C2;
    }

    public int bits() {
        return 32;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Murmur3_32HashFunction)) {
            return false;
        }
        Murmur3_32HashFunction murmur3_32HashFunction = (Murmur3_32HashFunction) obj;
        return this.seed == murmur3_32HashFunction.seed && this.supplementaryPlaneFix == murmur3_32HashFunction.supplementaryPlaneFix;
    }

    @Override // com.google.common.hash.b
    public HashCode hashBytes(byte[] bArr, int i10, int i11) {
        o.w(i10, i10 + i11, bArr.length);
        int i12 = this.seed;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = i14 + 4;
            if (i15 > i11) {
                break;
            }
            i12 = mixH1(i12, mixK1(getIntLittleEndian(bArr, i14 + i10)));
            i14 = i15;
        }
        int i16 = i14;
        int i17 = 0;
        while (i16 < i11) {
            i13 ^= com.google.common.primitives.f.c(bArr[i10 + i16]) << i17;
            i16++;
            i17 += 8;
        }
        return fmix(mixK1(i13) ^ i12, i11);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.b
    public HashCode hashInt(int i10) {
        return fmix(mixH1(this.seed, mixK1(i10)), 4);
    }

    @Override // com.google.common.hash.b
    public HashCode hashLong(long j10) {
        int i10 = (int) (j10 >>> 32);
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j10)), mixK1(i10)), 8);
    }

    @Override // com.google.common.hash.b
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        if (com.google.common.base.c.f25961c.equals(charset)) {
            int length = charSequence.length();
            int i10 = this.seed;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                int i14 = i12 + 4;
                if (i14 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i12);
                char charAt2 = charSequence.charAt(i12 + 1);
                char charAt3 = charSequence.charAt(i12 + 2);
                char charAt4 = charSequence.charAt(i12 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                i10 = mixH1(i10, mixK1((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i13 += 4;
                i12 = i14;
            }
            long j10 = 0;
            while (i12 < length) {
                char charAt5 = charSequence.charAt(i12);
                if (charAt5 < 128) {
                    j10 |= charAt5 << i11;
                    i11 += 8;
                    i13++;
                } else if (charAt5 < 2048) {
                    j10 |= charToTwoUtf8Bytes(charAt5) << i11;
                    i11 += 16;
                    i13 += 2;
                } else if (charAt5 >= 55296 && charAt5 <= 57343) {
                    int codePointAt = Character.codePointAt(charSequence, i12);
                    if (codePointAt == charAt5) {
                        return hashBytes(charSequence.toString().getBytes(charset));
                    }
                    i12++;
                    j10 |= codePointToFourUtf8Bytes(codePointAt) << i11;
                    if (this.supplementaryPlaneFix) {
                        i11 += 32;
                    }
                    i13 += 4;
                } else {
                    j10 |= charToThreeUtf8Bytes(charAt5) << i11;
                    i11 += 24;
                    i13 += 3;
                }
                if (i11 >= 32) {
                    i10 = mixH1(i10, mixK1((int) j10));
                    j10 >>>= 32;
                    i11 -= 32;
                }
                i12++;
            }
            return fmix(mixK1((int) j10) ^ i10, i13);
        }
        return hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.b
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i10 = this.seed;
        for (int i11 = 1; i11 < charSequence.length(); i11 += 2) {
            i10 = mixH1(i10, mixK1(charSequence.charAt(i11 - 1) | (charSequence.charAt(i11) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i10 ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(i10, charSequence.length() * 2);
    }

    @Override // com.google.common.hash.e
    public f newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        int i10 = this.seed;
        StringBuilder sb2 = new StringBuilder(31);
        sb2.append("Hashing.murmur3_32(");
        sb2.append(i10);
        sb2.append(")");
        return sb2.toString();
    }
}
