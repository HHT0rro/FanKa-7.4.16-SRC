package com.android.internal.org.bouncycastle.crypto.digests;

import com.android.internal.org.bouncycastle.crypto.ExtendedDigest;
import com.android.internal.org.bouncycastle.util.Memoable;
import com.android.internal.org.bouncycastle.util.Pack;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class LongDigest implements ExtendedDigest, Memoable, EncodableDigest {
    private static final int BYTE_LENGTH = 128;
    static final long[] K = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    protected long H1;
    protected long H2;
    protected long H3;
    protected long H4;
    protected long H5;
    protected long H6;
    protected long H7;
    protected long H8;
    private long[] W;
    private long byteCount1;
    private long byteCount2;
    private int wOff;
    private byte[] xBuf;
    private int xBufOff;

    /* JADX INFO: Access modifiers changed from: protected */
    public LongDigest() {
        this.xBuf = new byte[8];
        this.W = new long[80];
        this.xBufOff = 0;
        reset();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LongDigest(LongDigest t2) {
        this.xBuf = new byte[8];
        this.W = new long[80];
        copyIn(t2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void copyIn(LongDigest t2) {
        byte[] bArr = t2.xBuf;
        System.arraycopy((Object) bArr, 0, (Object) this.xBuf, 0, bArr.length);
        this.xBufOff = t2.xBufOff;
        this.byteCount1 = t2.byteCount1;
        this.byteCount2 = t2.byteCount2;
        this.H1 = t2.H1;
        this.H2 = t2.H2;
        this.H3 = t2.H3;
        this.H4 = t2.H4;
        this.H5 = t2.H5;
        this.H6 = t2.H6;
        this.H7 = t2.H7;
        this.H8 = t2.H8;
        long[] jArr = t2.W;
        System.arraycopy((Object) jArr, 0, (Object) this.W, 0, jArr.length);
        this.wOff = t2.wOff;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void populateState(byte[] state) {
        System.arraycopy((Object) this.xBuf, 0, (Object) state, 0, this.xBufOff);
        Pack.intToBigEndian(this.xBufOff, state, 8);
        Pack.longToBigEndian(this.byteCount1, state, 12);
        Pack.longToBigEndian(this.byteCount2, state, 20);
        Pack.longToBigEndian(this.H1, state, 28);
        Pack.longToBigEndian(this.H2, state, 36);
        Pack.longToBigEndian(this.H3, state, 44);
        Pack.longToBigEndian(this.H4, state, 52);
        Pack.longToBigEndian(this.H5, state, 60);
        Pack.longToBigEndian(this.H6, state, 68);
        Pack.longToBigEndian(this.H7, state, 76);
        Pack.longToBigEndian(this.H8, state, 84);
        Pack.intToBigEndian(this.wOff, state, 92);
        for (int i10 = 0; i10 < this.wOff; i10++) {
            Pack.longToBigEndian(this.W[i10], state, (i10 * 8) + 96);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void restoreState(byte[] encodedState) {
        int bigEndianToInt = Pack.bigEndianToInt(encodedState, 8);
        this.xBufOff = bigEndianToInt;
        System.arraycopy((Object) encodedState, 0, (Object) this.xBuf, 0, bigEndianToInt);
        this.byteCount1 = Pack.bigEndianToLong(encodedState, 12);
        this.byteCount2 = Pack.bigEndianToLong(encodedState, 20);
        this.H1 = Pack.bigEndianToLong(encodedState, 28);
        this.H2 = Pack.bigEndianToLong(encodedState, 36);
        this.H3 = Pack.bigEndianToLong(encodedState, 44);
        this.H4 = Pack.bigEndianToLong(encodedState, 52);
        this.H5 = Pack.bigEndianToLong(encodedState, 60);
        this.H6 = Pack.bigEndianToLong(encodedState, 68);
        this.H7 = Pack.bigEndianToLong(encodedState, 76);
        this.H8 = Pack.bigEndianToLong(encodedState, 84);
        this.wOff = Pack.bigEndianToInt(encodedState, 92);
        for (int i10 = 0; i10 < this.wOff; i10++) {
            this.W[i10] = Pack.bigEndianToLong(encodedState, (i10 * 8) + 96);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getEncodedStateSize() {
        return (this.wOff * 8) + 96;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Digest
    public void update(byte in) {
        byte[] bArr = this.xBuf;
        int i10 = this.xBufOff;
        int i11 = i10 + 1;
        this.xBufOff = i11;
        bArr[i10] = in;
        if (i11 == bArr.length) {
            processWord(bArr, 0);
            this.xBufOff = 0;
        }
        this.byteCount1++;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Digest
    public void update(byte[] in, int inOff, int len) {
        while (this.xBufOff != 0 && len > 0) {
            update(in[inOff]);
            inOff++;
            len--;
        }
        while (len > this.xBuf.length) {
            processWord(in, inOff);
            byte[] bArr = this.xBuf;
            inOff += bArr.length;
            len -= bArr.length;
            this.byteCount1 += bArr.length;
        }
        while (len > 0) {
            update(in[inOff]);
            inOff++;
            len--;
        }
    }

    public void finish() {
        adjustByteCounts();
        long lowBitLength = this.byteCount1 << 3;
        long hiBitLength = this.byteCount2;
        update(Byte.MIN_VALUE);
        while (this.xBufOff != 0) {
            update((byte) 0);
        }
        processLength(lowBitLength, hiBitLength);
        processBlock();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Digest
    public void reset() {
        this.byteCount1 = 0L;
        this.byteCount2 = 0L;
        this.xBufOff = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.xBuf;
            if (i10 >= bArr.length) {
                break;
            }
            bArr[i10] = 0;
            i10++;
        }
        this.wOff = 0;
        int i11 = 0;
        while (true) {
            long[] jArr = this.W;
            if (i11 != jArr.length) {
                jArr[i11] = 0;
                i11++;
            } else {
                return;
            }
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 128;
    }

    protected void processWord(byte[] in, int inOff) {
        this.W[this.wOff] = Pack.bigEndianToLong(in, inOff);
        int i10 = this.wOff + 1;
        this.wOff = i10;
        if (i10 == 16) {
            processBlock();
        }
    }

    private void adjustByteCounts() {
        long j10 = this.byteCount1;
        if (j10 > 2305843009213693951L) {
            this.byteCount2 += j10 >>> 61;
            this.byteCount1 = j10 & 2305843009213693951L;
        }
    }

    protected void processLength(long lowW, long hiW) {
        if (this.wOff > 14) {
            processBlock();
        }
        long[] jArr = this.W;
        jArr[14] = hiW;
        jArr[15] = lowW;
    }

    protected void processBlock() {
        adjustByteCounts();
        for (int t2 = 16; t2 <= 79; t2++) {
            long[] jArr = this.W;
            long Sigma1 = Sigma1(jArr[t2 - 2]);
            long[] jArr2 = this.W;
            jArr[t2] = Sigma1 + jArr2[t2 - 7] + Sigma0(jArr2[t2 - 15]) + this.W[t2 - 16];
        }
        long a10 = this.H1;
        long b4 = this.H2;
        long c4 = this.H3;
        long d10 = this.H4;
        long e2 = this.H5;
        long f10 = this.H6;
        long g3 = this.H7;
        long a11 = this.H8;
        long f11 = f10;
        long g10 = g3;
        long g11 = b4;
        long h10 = c4;
        int i10 = 0;
        int t10 = 0;
        long d11 = d10;
        long e10 = e2;
        long b10 = a10;
        long e11 = a11;
        while (i10 < 10) {
            long Sum1 = Sum1(e10);
            long e12 = e10;
            long e13 = g10;
            long Ch = Sum1 + Ch(e10, f11, e13);
            long[] jArr3 = K;
            int t11 = t10 + 1;
            long h11 = e11 + Ch + jArr3[t10] + this.W[t10];
            long d12 = d11 + h11;
            long b11 = g11;
            long d13 = h10;
            long h12 = h11 + Sum0(b10) + Maj(b10, g11, d13);
            int t12 = t11 + 1;
            long g12 = g10 + Sum1(d12) + Ch(d12, e12, f11) + jArr3[t11] + this.W[t11];
            long c10 = h10 + g12;
            long g13 = g12 + Sum0(h12) + Maj(h12, b10, b11);
            int t13 = t12 + 1;
            long f12 = f11 + Sum1(c10) + Ch(c10, d12, e12) + jArr3[t12] + this.W[t12];
            long b12 = b11 + f12;
            long f13 = f12 + Sum0(g13) + Maj(g13, h12, b10);
            int t14 = t13 + 1;
            long e14 = e12 + Sum1(b12) + Ch(b12, c10, d12) + jArr3[t13] + this.W[t13];
            long a12 = b10 + e14;
            long e15 = e14 + Sum0(f13) + Maj(f13, g13, h12);
            long e16 = Sum1(a12);
            int t15 = t14 + 1;
            long d14 = d12 + e16 + Ch(a12, b12, c10) + jArr3[t14] + this.W[t14];
            long h13 = h12 + d14;
            long d15 = d14 + Sum0(e15) + Maj(e15, f13, g13);
            long d16 = Sum1(h13);
            int t16 = t15 + 1;
            long c11 = c10 + d16 + Ch(h13, a12, b12) + jArr3[t15] + this.W[t15];
            long g14 = g13 + c11;
            long c12 = c11 + Sum0(d15) + Maj(d15, e15, f13);
            long c13 = Sum1(g14);
            h10 = c12;
            int t17 = t16 + 1;
            long b13 = b12 + c13 + Ch(g14, h13, a12) + jArr3[t16] + this.W[t16];
            long f14 = f13 + b13;
            long b14 = b13 + Sum0(h10) + Maj(h10, d15, e15);
            long b15 = Sum1(f14);
            int t18 = t17 + 1;
            long a13 = a12 + b15 + Ch(f14, g14, h13) + jArr3[t17] + this.W[t17];
            long a14 = a13 + Sum0(b14) + Maj(b14, h10, d15);
            i10++;
            e10 = e15 + a13;
            g10 = g14;
            t10 = t18;
            e11 = h13;
            g11 = b14;
            f11 = f14;
            d11 = d15;
            b10 = a14;
        }
        long b16 = g11;
        this.H1 += b10;
        this.H2 += b16;
        this.H3 += h10;
        this.H4 += d11;
        this.H5 += e10;
        this.H6 += f11;
        this.H7 += g10;
        this.H8 += e11;
        this.wOff = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            this.W[i11] = 0;
        }
    }

    private long Ch(long x10, long y10, long z10) {
        return (x10 & y10) ^ ((~x10) & z10);
    }

    private long Maj(long x10, long y10, long z10) {
        return ((x10 & y10) ^ (x10 & z10)) ^ (y10 & z10);
    }

    private long Sum0(long x10) {
        return (((x10 << 36) | (x10 >>> 28)) ^ ((x10 << 30) | (x10 >>> 34))) ^ ((x10 << 25) | (x10 >>> 39));
    }

    private long Sum1(long x10) {
        return (((x10 << 50) | (x10 >>> 14)) ^ ((x10 << 46) | (x10 >>> 18))) ^ ((x10 << 23) | (x10 >>> 41));
    }

    private long Sigma0(long x10) {
        return (((x10 << 63) | (x10 >>> 1)) ^ ((x10 << 56) | (x10 >>> 8))) ^ (x10 >>> 7);
    }

    private long Sigma1(long x10) {
        return (((x10 << 45) | (x10 >>> 19)) ^ ((x10 << 3) | (x10 >>> 61))) ^ (x10 >>> 6);
    }
}
