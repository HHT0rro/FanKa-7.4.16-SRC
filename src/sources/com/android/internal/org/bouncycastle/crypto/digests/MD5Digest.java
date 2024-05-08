package com.android.internal.org.bouncycastle.crypto.digests;

import com.android.internal.org.bouncycastle.util.Memoable;
import com.android.internal.org.bouncycastle.util.Pack;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class MD5Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 16;
    private static final int S11 = 7;
    private static final int S12 = 12;
    private static final int S13 = 17;
    private static final int S14 = 22;
    private static final int S21 = 5;
    private static final int S22 = 9;
    private static final int S23 = 14;
    private static final int S24 = 20;
    private static final int S31 = 4;
    private static final int S32 = 11;
    private static final int S33 = 16;
    private static final int S34 = 23;
    private static final int S41 = 6;
    private static final int S42 = 10;
    private static final int S43 = 15;
    private static final int S44 = 21;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int[] X;
    private int xOff;

    public MD5Digest() {
        this.X = new int[16];
        reset();
    }

    public MD5Digest(byte[] encodedState) {
        super(encodedState);
        this.X = new int[16];
        this.H1 = Pack.bigEndianToInt(encodedState, 16);
        this.H2 = Pack.bigEndianToInt(encodedState, 20);
        this.H3 = Pack.bigEndianToInt(encodedState, 24);
        this.H4 = Pack.bigEndianToInt(encodedState, 28);
        this.xOff = Pack.bigEndianToInt(encodedState, 32);
        for (int i10 = 0; i10 != this.xOff; i10++) {
            this.X[i10] = Pack.bigEndianToInt(encodedState, (i10 * 4) + 36);
        }
    }

    public MD5Digest(MD5Digest t2) {
        super(t2);
        this.X = new int[16];
        copyIn(t2);
    }

    private void copyIn(MD5Digest t2) {
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
        return "MD5";
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
        return (u10 & w3) | ((~w3) & v2);
    }

    private int H(int u10, int v2, int w3) {
        return (u10 ^ v2) ^ w3;
    }

    private int K(int u10, int v2, int w3) {
        return ((~w3) | u10) ^ v2;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.GeneralDigest
    protected void processBlock() {
        int a10 = this.H1;
        int b4 = this.H2;
        int c4 = this.H3;
        int d10 = this.H4;
        int a11 = rotateLeft(((F(b4, c4, d10) + a10) + this.X[0]) - 680876936, 7) + b4;
        int d11 = rotateLeft(((F(a11, b4, c4) + d10) + this.X[1]) - 389564586, 12) + a11;
        int c10 = rotateLeft(F(d11, a11, b4) + c4 + this.X[2] + 606105819, 17) + d11;
        int b10 = rotateLeft(((F(c10, d11, a11) + b4) + this.X[3]) - 1044525330, 22) + c10;
        int a12 = rotateLeft(((F(b10, c10, d11) + a11) + this.X[4]) - 176418897, 7) + b10;
        int d12 = rotateLeft(F(a12, b10, c10) + d11 + this.X[5] + 1200080426, 12) + a12;
        int c11 = rotateLeft(((F(d12, a12, b10) + c10) + this.X[6]) - 1473231341, 17) + d12;
        int b11 = rotateLeft(((F(c11, d12, a12) + b10) + this.X[7]) - 45705983, 22) + c11;
        int a13 = rotateLeft(F(b11, c11, d12) + a12 + this.X[8] + 1770035416, 7) + b11;
        int d13 = rotateLeft(((F(a13, b11, c11) + d12) + this.X[9]) - 1958414417, 12) + a13;
        int c12 = rotateLeft(((F(d13, a13, b11) + c11) + this.X[10]) - 42063, 17) + d13;
        int b12 = rotateLeft(((F(c12, d13, a13) + b11) + this.X[11]) - 1990404162, 22) + c12;
        int a14 = rotateLeft(F(b12, c12, d13) + a13 + this.X[12] + 1804603682, 7) + b12;
        int d14 = rotateLeft(((F(a14, b12, c12) + d13) + this.X[13]) - 40341101, 12) + a14;
        int c13 = rotateLeft(((F(d14, a14, b12) + c12) + this.X[14]) - 1502002290, 17) + d14;
        int b13 = rotateLeft(F(c13, d14, a14) + b12 + this.X[15] + 1236535329, 22) + c13;
        int a15 = rotateLeft(((G(b13, c13, d14) + a14) + this.X[1]) - 165796510, 5) + b13;
        int d15 = rotateLeft(((G(a15, b13, c13) + d14) + this.X[6]) - 1069501632, 9) + a15;
        int c14 = rotateLeft(G(d15, a15, b13) + c13 + this.X[11] + 643717713, 14) + d15;
        int b14 = rotateLeft(((G(c14, d15, a15) + b13) + this.X[0]) - 373897302, 20) + c14;
        int a16 = rotateLeft(((G(b14, c14, d15) + a15) + this.X[5]) - 701558691, 5) + b14;
        int d16 = rotateLeft(G(a16, b14, c14) + d15 + this.X[10] + 38016083, 9) + a16;
        int c15 = rotateLeft(((G(d16, a16, b14) + c14) + this.X[15]) - 660478335, 14) + d16;
        int b15 = rotateLeft(((G(c15, d16, a16) + b14) + this.X[4]) - 405537848, 20) + c15;
        int a17 = rotateLeft(G(b15, c15, d16) + a16 + this.X[9] + 568446438, 5) + b15;
        int d17 = rotateLeft(((G(a17, b15, c15) + d16) + this.X[14]) - 1019803690, 9) + a17;
        int c16 = rotateLeft(((G(d17, a17, b15) + c15) + this.X[3]) - 187363961, 14) + d17;
        int b16 = rotateLeft(G(c16, d17, a17) + b15 + this.X[8] + 1163531501, 20) + c16;
        int a18 = rotateLeft(((G(b16, c16, d17) + a17) + this.X[13]) - 1444681467, 5) + b16;
        int d18 = rotateLeft(((G(a18, b16, c16) + d17) + this.X[2]) - 51403784, 9) + a18;
        int c17 = rotateLeft(G(d18, a18, b16) + c16 + this.X[7] + 1735328473, 14) + d18;
        int b17 = rotateLeft(((G(c17, d18, a18) + b16) + this.X[12]) - 1926607734, 20) + c17;
        int a19 = rotateLeft(((H(b17, c17, d18) + a18) + this.X[5]) - 378558, 4) + b17;
        int d19 = rotateLeft(((H(a19, b17, c17) + d18) + this.X[8]) - 2022574463, 11) + a19;
        int c18 = rotateLeft(H(d19, a19, b17) + c17 + this.X[11] + 1839030562, 16) + d19;
        int b18 = rotateLeft(((H(c18, d19, a19) + b17) + this.X[14]) - 35309556, 23) + c18;
        int a20 = rotateLeft(((H(b18, c18, d19) + a19) + this.X[1]) - 1530992060, 4) + b18;
        int d20 = rotateLeft(H(a20, b18, c18) + d19 + this.X[4] + 1272893353, 11) + a20;
        int c19 = rotateLeft(((H(d20, a20, b18) + c18) + this.X[7]) - 155497632, 16) + d20;
        int b19 = rotateLeft(((H(c19, d20, a20) + b18) + this.X[10]) - 1094730640, 23) + c19;
        int a21 = rotateLeft(H(b19, c19, d20) + a20 + this.X[13] + 681279174, 4) + b19;
        int d21 = rotateLeft(((H(a21, b19, c19) + d20) + this.X[0]) - 358537222, 11) + a21;
        int c20 = rotateLeft(((H(d21, a21, b19) + c19) + this.X[3]) - 722521979, 16) + d21;
        int b20 = rotateLeft(H(c20, d21, a21) + b19 + this.X[6] + 76029189, 23) + c20;
        int a22 = rotateLeft(((H(b20, c20, d21) + a21) + this.X[9]) - 640364487, 4) + b20;
        int d22 = rotateLeft(((H(a22, b20, c20) + d21) + this.X[12]) - 421815835, 11) + a22;
        int c21 = rotateLeft(H(d22, a22, b20) + c20 + this.X[15] + 530742520, 16) + d22;
        int b21 = rotateLeft(((H(c21, d22, a22) + b20) + this.X[2]) - 995338651, 23) + c21;
        int a23 = rotateLeft(((K(b21, c21, d22) + a22) + this.X[0]) - 198630844, 6) + b21;
        int d23 = rotateLeft(K(a23, b21, c21) + d22 + this.X[7] + 1126891415, 10) + a23;
        int c22 = rotateLeft(((K(d23, a23, b21) + c21) + this.X[14]) - 1416354905, 15) + d23;
        int b22 = rotateLeft(((K(c22, d23, a23) + b21) + this.X[5]) - 57434055, 21) + c22;
        int a24 = rotateLeft(K(b22, c22, d23) + a23 + this.X[12] + 1700485571, 6) + b22;
        int d24 = rotateLeft(((K(a24, b22, c22) + d23) + this.X[3]) - 1894986606, 10) + a24;
        int c23 = rotateLeft(((K(d24, a24, b22) + c22) + this.X[10]) - 1051523, 15) + d24;
        int b23 = rotateLeft(((K(c23, d24, a24) + b22) + this.X[1]) - 2054922799, 21) + c23;
        int a25 = rotateLeft(K(b23, c23, d24) + a24 + this.X[8] + 1873313359, 6) + b23;
        int d25 = rotateLeft(((K(a25, b23, c23) + d24) + this.X[15]) - 30611744, 10) + a25;
        int c24 = rotateLeft(((K(d25, a25, b23) + c23) + this.X[6]) - 1560198380, 15) + d25;
        int b24 = rotateLeft(K(c24, d25, a25) + b23 + this.X[13] + 1309151649, 21) + c24;
        int a26 = rotateLeft(((K(b24, c24, d25) + a25) + this.X[4]) - 145523070, 6) + b24;
        int d26 = rotateLeft(((K(a26, b24, c24) + d25) + this.X[11]) - 1120210379, 10) + a26;
        int c25 = rotateLeft(K(d26, a26, b24) + c24 + this.X[2] + 718787259, 15) + d26;
        int b25 = rotateLeft(((K(c25, d26, a26) + b24) + this.X[9]) - 343485551, 21) + c25;
        this.H1 += a26;
        this.H2 += b25;
        this.H3 += c25;
        this.H4 += d26;
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
        return new MD5Digest(this);
    }

    @Override // com.android.internal.org.bouncycastle.util.Memoable
    public void reset(Memoable other) {
        MD5Digest d10 = (MD5Digest) other;
        copyIn(d10);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        byte[] state = new byte[(this.xOff * 4) + 36];
        super.populateState(state);
        Pack.intToBigEndian(this.H1, state, 16);
        Pack.intToBigEndian(this.H2, state, 20);
        Pack.intToBigEndian(this.H3, state, 24);
        Pack.intToBigEndian(this.H4, state, 28);
        Pack.intToBigEndian(this.xOff, state, 32);
        for (int i10 = 0; i10 != this.xOff; i10++) {
            Pack.intToBigEndian(this.X[i10], state, (i10 * 4) + 36);
        }
        return state;
    }
}
