package com.android.internal.org.bouncycastle.crypto.digests;

import com.android.internal.org.bouncycastle.util.Memoable;
import com.android.internal.org.bouncycastle.util.Pack;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SHA224Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 28;
    static final int[] K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int H6;
    private int H7;
    private int H8;
    private int[] X;
    private int xOff;

    public SHA224Digest() {
        this.X = new int[64];
        reset();
    }

    public SHA224Digest(SHA224Digest t2) {
        super(t2);
        this.X = new int[64];
        doCopy(t2);
    }

    private void doCopy(SHA224Digest t2) {
        super.copyIn(t2);
        this.H1 = t2.H1;
        this.H2 = t2.H2;
        this.H3 = t2.H3;
        this.H4 = t2.H4;
        this.H5 = t2.H5;
        this.H6 = t2.H6;
        this.H7 = t2.H7;
        this.H8 = t2.H8;
        int[] iArr = t2.X;
        System.arraycopy((Object) iArr, 0, (Object) this.X, 0, iArr.length);
        this.xOff = t2.xOff;
    }

    public SHA224Digest(byte[] encodedState) {
        super(encodedState);
        this.X = new int[64];
        this.H1 = Pack.bigEndianToInt(encodedState, 16);
        this.H2 = Pack.bigEndianToInt(encodedState, 20);
        this.H3 = Pack.bigEndianToInt(encodedState, 24);
        this.H4 = Pack.bigEndianToInt(encodedState, 28);
        this.H5 = Pack.bigEndianToInt(encodedState, 32);
        this.H6 = Pack.bigEndianToInt(encodedState, 36);
        this.H7 = Pack.bigEndianToInt(encodedState, 40);
        this.H8 = Pack.bigEndianToInt(encodedState, 44);
        this.xOff = Pack.bigEndianToInt(encodedState, 48);
        for (int i10 = 0; i10 != this.xOff; i10++) {
            this.X[i10] = Pack.bigEndianToInt(encodedState, (i10 * 4) + 52);
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-224";
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 28;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.GeneralDigest
    protected void processWord(byte[] in, int inOff) {
        int n10 = in[inOff] << 24;
        int inOff2 = inOff + 1;
        int n11 = n10 | ((in[inOff2] & 255) << 16);
        int inOff3 = inOff2 + 1;
        int n12 = n11 | ((in[inOff3] & 255) << 8) | (in[inOff3 + 1] & 255);
        int[] iArr = this.X;
        int i10 = this.xOff;
        iArr[i10] = n12;
        int i11 = i10 + 1;
        this.xOff = i11;
        if (i11 == 16) {
            processBlock();
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.GeneralDigest
    protected void processLength(long bitLength) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (bitLength >>> 32);
        iArr[15] = (int) ((-1) & bitLength);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Digest
    public int doFinal(byte[] out, int outOff) {
        finish();
        Pack.intToBigEndian(this.H1, out, outOff);
        Pack.intToBigEndian(this.H2, out, outOff + 4);
        Pack.intToBigEndian(this.H3, out, outOff + 8);
        Pack.intToBigEndian(this.H4, out, outOff + 12);
        Pack.intToBigEndian(this.H5, out, outOff + 16);
        Pack.intToBigEndian(this.H6, out, outOff + 20);
        Pack.intToBigEndian(this.H7, out, outOff + 24);
        reset();
        return 28;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.GeneralDigest, com.android.internal.org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H1 = -1056596264;
        this.H2 = 914150663;
        this.H3 = 812702999;
        this.H4 = -150054599;
        this.H5 = -4191439;
        this.H6 = 1750603025;
        this.H7 = 1694076839;
        this.H8 = -1090891868;
        this.xOff = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.X;
            if (i10 != iArr.length) {
                iArr[i10] = 0;
                i10++;
            } else {
                return;
            }
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.GeneralDigest
    protected void processBlock() {
        for (int t2 = 16; t2 <= 63; t2++) {
            int[] iArr = this.X;
            int Theta1 = Theta1(iArr[t2 - 2]);
            int[] iArr2 = this.X;
            iArr[t2] = Theta1 + iArr2[t2 - 7] + Theta0(iArr2[t2 - 15]) + this.X[t2 - 16];
        }
        int a10 = this.H1;
        int b4 = this.H2;
        int c4 = this.H3;
        int d10 = this.H4;
        int e2 = this.H5;
        int f10 = this.H6;
        int g3 = this.H7;
        int h10 = this.H8;
        int t10 = 0;
        for (int i10 = 0; i10 < 8; i10++) {
            int Sum1 = Sum1(e2) + Ch(e2, f10, g3);
            int[] iArr3 = K;
            int h11 = h10 + Sum1 + iArr3[t10] + this.X[t10];
            int d11 = d10 + h11;
            int h12 = h11 + Sum0(a10) + Maj(a10, b4, c4);
            int t11 = t10 + 1;
            int g10 = g3 + Sum1(d11) + Ch(d11, e2, f10) + iArr3[t11] + this.X[t11];
            int c10 = c4 + g10;
            int g11 = g10 + Sum0(h12) + Maj(h12, a10, b4);
            int t12 = t11 + 1;
            int f11 = f10 + Sum1(c10) + Ch(c10, d11, e2) + iArr3[t12] + this.X[t12];
            int b10 = b4 + f11;
            int f12 = f11 + Sum0(g11) + Maj(g11, h12, a10);
            int t13 = t12 + 1;
            int e10 = e2 + Sum1(b10) + Ch(b10, c10, d11) + iArr3[t13] + this.X[t13];
            int a11 = a10 + e10;
            int e11 = e10 + Sum0(f12) + Maj(f12, g11, h12);
            int t14 = t13 + 1;
            int d12 = d11 + Sum1(a11) + Ch(a11, b10, c10) + iArr3[t14] + this.X[t14];
            h10 = h12 + d12;
            d10 = d12 + Sum0(e11) + Maj(e11, f12, g11);
            int t15 = t14 + 1;
            int c11 = c10 + Sum1(h10) + Ch(h10, a11, b10) + iArr3[t15] + this.X[t15];
            g3 = g11 + c11;
            c4 = c11 + Sum0(d10) + Maj(d10, e11, f12);
            int t16 = t15 + 1;
            int b11 = b10 + Sum1(g3) + Ch(g3, h10, a11) + iArr3[t16] + this.X[t16];
            f10 = f12 + b11;
            b4 = b11 + Sum0(c4) + Maj(c4, d10, e11);
            int t17 = t16 + 1;
            int a12 = a11 + Sum1(f10) + Ch(f10, g3, h10) + iArr3[t17] + this.X[t17];
            e2 = e11 + a12;
            a10 = a12 + Sum0(b4) + Maj(b4, c4, d10);
            t10 = t17 + 1;
        }
        int i11 = this.H1;
        this.H1 = i11 + a10;
        this.H2 += b4;
        this.H3 += c4;
        this.H4 += d10;
        this.H5 += e2;
        this.H6 += f10;
        this.H7 += g3;
        this.H8 += h10;
        this.xOff = 0;
        for (int i12 = 0; i12 < 16; i12++) {
            this.X[i12] = 0;
        }
    }

    private int Ch(int x10, int y10, int z10) {
        return (x10 & y10) ^ ((~x10) & z10);
    }

    private int Maj(int x10, int y10, int z10) {
        return ((x10 & y10) ^ (x10 & z10)) ^ (y10 & z10);
    }

    private int Sum0(int x10) {
        return (((x10 >>> 2) | (x10 << 30)) ^ ((x10 >>> 13) | (x10 << 19))) ^ ((x10 >>> 22) | (x10 << 10));
    }

    private int Sum1(int x10) {
        return (((x10 >>> 6) | (x10 << 26)) ^ ((x10 >>> 11) | (x10 << 21))) ^ ((x10 >>> 25) | (x10 << 7));
    }

    private int Theta0(int x10) {
        return (((x10 >>> 7) | (x10 << 25)) ^ ((x10 >>> 18) | (x10 << 14))) ^ (x10 >>> 3);
    }

    private int Theta1(int x10) {
        return (((x10 >>> 17) | (x10 << 15)) ^ ((x10 >>> 19) | (x10 << 13))) ^ (x10 >>> 10);
    }

    @Override // com.android.internal.org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SHA224Digest(this);
    }

    @Override // com.android.internal.org.bouncycastle.util.Memoable
    public void reset(Memoable other) {
        SHA224Digest d10 = (SHA224Digest) other;
        doCopy(d10);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        byte[] state = new byte[(this.xOff * 4) + 52];
        super.populateState(state);
        Pack.intToBigEndian(this.H1, state, 16);
        Pack.intToBigEndian(this.H2, state, 20);
        Pack.intToBigEndian(this.H3, state, 24);
        Pack.intToBigEndian(this.H4, state, 28);
        Pack.intToBigEndian(this.H5, state, 32);
        Pack.intToBigEndian(this.H6, state, 36);
        Pack.intToBigEndian(this.H7, state, 40);
        Pack.intToBigEndian(this.H8, state, 44);
        Pack.intToBigEndian(this.xOff, state, 48);
        for (int i10 = 0; i10 != this.xOff; i10++) {
            Pack.intToBigEndian(this.X[i10], state, (i10 * 4) + 52);
        }
        return state;
    }
}
