package com.android.internal.org.bouncycastle.crypto.digests;

import com.android.internal.org.bouncycastle.util.Memoable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class MD4Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 16;
    private static final int S11 = 3;
    private static final int S12 = 7;
    private static final int S13 = 11;
    private static final int S14 = 19;
    private static final int S21 = 3;
    private static final int S22 = 5;
    private static final int S23 = 9;
    private static final int S24 = 13;
    private static final int S31 = 3;
    private static final int S32 = 9;
    private static final int S33 = 11;
    private static final int S34 = 15;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int[] X;
    private int xOff;

    public MD4Digest() {
        this.X = new int[16];
        reset();
    }

    public MD4Digest(MD4Digest t2) {
        super(t2);
        this.X = new int[16];
        copyIn(t2);
    }

    private void copyIn(MD4Digest t2) {
        super.copyIn((GeneralDigest) t2);
        this.H1 = t2.H1;
        this.H2 = t2.H2;
        this.H3 = t2.H3;
        this.H4 = t2.H4;
        int[] iArr = t2.X;
        System.arraycopy((Object) iArr, 0, (Object) this.X, 0, iArr.length);
        this.xOff = t2.xOff;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "MD4";
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 16;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.GeneralDigest
    protected void processWord(byte[] in, int inOff) {
        int[] iArr = this.X;
        int i10 = this.xOff;
        int i11 = i10 + 1;
        this.xOff = i11;
        iArr[i10] = (in[inOff] & 255) | ((in[inOff + 1] & 255) << 8) | ((in[inOff + 2] & 255) << 16) | ((in[inOff + 3] & 255) << 24);
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
        iArr[14] = (int) ((-1) & bitLength);
        iArr[15] = (int) (bitLength >>> 32);
    }

    private void unpackWord(int word, byte[] out, int outOff) {
        out[outOff] = (byte) word;
        out[outOff + 1] = (byte) (word >>> 8);
        out[outOff + 2] = (byte) (word >>> 16);
        out[outOff + 3] = (byte) (word >>> 24);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.Digest
    public int doFinal(byte[] out, int outOff) {
        finish();
        unpackWord(this.H1, out, outOff);
        unpackWord(this.H2, out, outOff + 4);
        unpackWord(this.H3, out, outOff + 8);
        unpackWord(this.H4, out, outOff + 12);
        reset();
        return 16;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.GeneralDigest, com.android.internal.org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
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

    private int rotateLeft(int x10, int n10) {
        return (x10 << n10) | (x10 >>> (32 - n10));
    }

    private int F(int u10, int v2, int w3) {
        return (u10 & v2) | ((~u10) & w3);
    }

    private int G(int u10, int v2, int w3) {
        return (u10 & v2) | (u10 & w3) | (v2 & w3);
    }

    private int H(int u10, int v2, int w3) {
        return (u10 ^ v2) ^ w3;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.GeneralDigest
    protected void processBlock() {
        int a10 = this.H1;
        int b4 = this.H2;
        int c4 = this.H3;
        int d10 = this.H4;
        int a11 = rotateLeft(F(b4, c4, d10) + a10 + this.X[0], 3);
        int d11 = rotateLeft(F(a11, b4, c4) + d10 + this.X[1], 7);
        int c10 = rotateLeft(F(d11, a11, b4) + c4 + this.X[2], 11);
        int b10 = rotateLeft(F(c10, d11, a11) + b4 + this.X[3], 19);
        int a12 = rotateLeft(F(b10, c10, d11) + a11 + this.X[4], 3);
        int d12 = rotateLeft(F(a12, b10, c10) + d11 + this.X[5], 7);
        int c11 = rotateLeft(F(d12, a12, b10) + c10 + this.X[6], 11);
        int b11 = rotateLeft(F(c11, d12, a12) + b10 + this.X[7], 19);
        int a13 = rotateLeft(F(b11, c11, d12) + a12 + this.X[8], 3);
        int d13 = rotateLeft(F(a13, b11, c11) + d12 + this.X[9], 7);
        int c12 = rotateLeft(F(d13, a13, b11) + c11 + this.X[10], 11);
        int b12 = rotateLeft(F(c12, d13, a13) + b11 + this.X[11], 19);
        int a14 = rotateLeft(F(b12, c12, d13) + a13 + this.X[12], 3);
        int d14 = rotateLeft(F(a14, b12, c12) + d13 + this.X[13], 7);
        int c13 = rotateLeft(F(d14, a14, b12) + c12 + this.X[14], 11);
        int b13 = rotateLeft(F(c13, d14, a14) + b12 + this.X[15], 19);
        int a15 = rotateLeft(G(b13, c13, d14) + a14 + this.X[0] + 1518500249, 3);
        int d15 = rotateLeft(G(a15, b13, c13) + d14 + this.X[4] + 1518500249, 5);
        int c14 = rotateLeft(G(d15, a15, b13) + c13 + this.X[8] + 1518500249, 9);
        int b14 = rotateLeft(G(c14, d15, a15) + b13 + this.X[12] + 1518500249, 13);
        int a16 = rotateLeft(G(b14, c14, d15) + a15 + this.X[1] + 1518500249, 3);
        int d16 = rotateLeft(G(a16, b14, c14) + d15 + this.X[5] + 1518500249, 5);
        int c15 = rotateLeft(G(d16, a16, b14) + c14 + this.X[9] + 1518500249, 9);
        int b15 = rotateLeft(G(c15, d16, a16) + b14 + this.X[13] + 1518500249, 13);
        int a17 = rotateLeft(G(b15, c15, d16) + a16 + this.X[2] + 1518500249, 3);
        int d17 = rotateLeft(G(a17, b15, c15) + d16 + this.X[6] + 1518500249, 5);
        int c16 = rotateLeft(G(d17, a17, b15) + c15 + this.X[10] + 1518500249, 9);
        int b16 = rotateLeft(G(c16, d17, a17) + b15 + this.X[14] + 1518500249, 13);
        int a18 = rotateLeft(G(b16, c16, d17) + a17 + this.X[3] + 1518500249, 3);
        int d18 = rotateLeft(G(a18, b16, c16) + d17 + this.X[7] + 1518500249, 5);
        int c17 = rotateLeft(G(d18, a18, b16) + c16 + this.X[11] + 1518500249, 9);
        int b17 = rotateLeft(G(c17, d18, a18) + b16 + this.X[15] + 1518500249, 13);
        int a19 = rotateLeft(H(b17, c17, d18) + a18 + this.X[0] + 1859775393, 3);
        int d19 = rotateLeft(H(a19, b17, c17) + d18 + this.X[8] + 1859775393, 9);
        int c18 = rotateLeft(H(d19, a19, b17) + c17 + this.X[4] + 1859775393, 11);
        int b18 = rotateLeft(H(c18, d19, a19) + b17 + this.X[12] + 1859775393, 15);
        int a20 = rotateLeft(H(b18, c18, d19) + a19 + this.X[2] + 1859775393, 3);
        int d20 = rotateLeft(H(a20, b18, c18) + d19 + this.X[10] + 1859775393, 9);
        int c19 = rotateLeft(H(d20, a20, b18) + c18 + this.X[6] + 1859775393, 11);
        int b19 = rotateLeft(H(c19, d20, a20) + b18 + this.X[14] + 1859775393, 15);
        int a21 = rotateLeft(H(b19, c19, d20) + a20 + this.X[1] + 1859775393, 3);
        int d21 = rotateLeft(H(a21, b19, c19) + d20 + this.X[9] + 1859775393, 9);
        int c20 = rotateLeft(H(d21, a21, b19) + c19 + this.X[5] + 1859775393, 11);
        int b20 = rotateLeft(H(c20, d21, a21) + b19 + this.X[13] + 1859775393, 15);
        int a22 = rotateLeft(H(b20, c20, d21) + a21 + this.X[3] + 1859775393, 3);
        int d22 = rotateLeft(H(a22, b20, c20) + d21 + this.X[11] + 1859775393, 9);
        int c21 = rotateLeft(H(d22, a22, b20) + c20 + this.X[7] + 1859775393, 11);
        int b21 = rotateLeft(H(c21, d22, a22) + b20 + this.X[15] + 1859775393, 15);
        this.H1 += a22;
        this.H2 += b21;
        this.H3 += c21;
        this.H4 += d22;
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

    @Override // com.android.internal.org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new MD4Digest(this);
    }

    @Override // com.android.internal.org.bouncycastle.util.Memoable
    public void reset(Memoable other) {
        MD4Digest d10 = (MD4Digest) other;
        copyIn(d10);
    }
}
