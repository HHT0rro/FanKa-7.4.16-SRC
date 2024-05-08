package com.android.internal.org.bouncycastle.cert.selector;

import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.android.internal.org.bouncycastle.util.Pack;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class MSOutlookKeyIdCalculator {
    MSOutlookKeyIdCalculator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] calculateKeyId(SubjectPublicKeyInfo info) {
        SHA1Digest dig = new SHA1Digest();
        byte[] hash = new byte[dig.getDigestSize()];
        byte[] bArr = new byte[0];
        try {
            byte[] spkiEnc = info.getEncoded(ASN1Encoding.DER);
            dig.update(spkiEnc, 0, spkiEnc.length);
            dig.doFinal(hash, 0);
            return hash;
        } catch (IOException e2) {
            return new byte[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class GeneralDigest {
        private static final int BYTE_LENGTH = 64;
        private long byteCount;
        private byte[] xBuf;
        private int xBufOff;

        protected abstract void processBlock();

        protected abstract void processLength(long j10);

        protected abstract void processWord(byte[] bArr, int i10);

        protected GeneralDigest() {
            this.xBuf = new byte[4];
            this.xBufOff = 0;
        }

        protected GeneralDigest(GeneralDigest t2) {
            this.xBuf = new byte[t2.xBuf.length];
            copyIn(t2);
        }

        protected void copyIn(GeneralDigest t2) {
            byte[] bArr = t2.xBuf;
            System.arraycopy((Object) bArr, 0, (Object) this.xBuf, 0, bArr.length);
            this.xBufOff = t2.xBufOff;
            this.byteCount = t2.byteCount;
        }

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
            this.byteCount++;
        }

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
                this.byteCount += bArr.length;
            }
            while (len > 0) {
                update(in[inOff]);
                inOff++;
                len--;
            }
        }

        public void finish() {
            long bitLength = this.byteCount << 3;
            update(Byte.MIN_VALUE);
            while (this.xBufOff != 0) {
                update((byte) 0);
            }
            processLength(bitLength);
            processBlock();
        }

        public void reset() {
            this.byteCount = 0L;
            this.xBufOff = 0;
            int i10 = 0;
            while (true) {
                byte[] bArr = this.xBuf;
                if (i10 < bArr.length) {
                    bArr[i10] = 0;
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class SHA1Digest extends GeneralDigest {
        private static final int DIGEST_LENGTH = 20;
        private static final int Y1 = 1518500249;
        private static final int Y2 = 1859775393;
        private static final int Y3 = -1894007588;
        private static final int Y4 = -899497514;
        private int H1;
        private int H2;
        private int H3;
        private int H4;
        private int H5;
        private int[] X = new int[80];
        private int xOff;

        public SHA1Digest() {
            reset();
        }

        public String getAlgorithmName() {
            return "SHA-1";
        }

        public int getDigestSize() {
            return 20;
        }

        @Override // com.android.internal.org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
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

        @Override // com.android.internal.org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        protected void processLength(long bitLength) {
            if (this.xOff > 14) {
                processBlock();
            }
            int[] iArr = this.X;
            iArr[14] = (int) (bitLength >>> 32);
            iArr[15] = (int) ((-1) & bitLength);
        }

        public int doFinal(byte[] out, int outOff) {
            finish();
            Pack.intToBigEndian(this.H1, out, outOff);
            Pack.intToBigEndian(this.H2, out, outOff + 4);
            Pack.intToBigEndian(this.H3, out, outOff + 8);
            Pack.intToBigEndian(this.H4, out, outOff + 12);
            Pack.intToBigEndian(this.H5, out, outOff + 16);
            reset();
            return 20;
        }

        @Override // com.android.internal.org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        public void reset() {
            super.reset();
            this.H1 = 1732584193;
            this.H2 = -271733879;
            this.H3 = -1732584194;
            this.H4 = 271733878;
            this.H5 = -1009589776;
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

        private int f(int u10, int v2, int w3) {
            return (u10 & v2) | ((~u10) & w3);
        }

        private int h(int u10, int v2, int w3) {
            return (u10 ^ v2) ^ w3;
        }

        private int g(int u10, int v2, int w3) {
            return (u10 & v2) | (u10 & w3) | (v2 & w3);
        }

        @Override // com.android.internal.org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        protected void processBlock() {
            for (int i10 = 16; i10 < 80; i10++) {
                int[] iArr = this.X;
                int t2 = ((iArr[i10 - 3] ^ iArr[i10 - 8]) ^ iArr[i10 - 14]) ^ iArr[i10 - 16];
                iArr[i10] = (t2 << 1) | (t2 >>> 31);
            }
            int A = this.H1;
            int B = this.H2;
            int C = this.H3;
            int D = this.H4;
            int E = this.H5;
            int idx = 0;
            int j10 = 0;
            while (j10 < 4) {
                int idx2 = idx + 1;
                int E2 = E + ((A << 5) | (A >>> 27)) + f(B, C, D) + this.X[idx] + Y1;
                int B2 = (B << 30) | (B >>> 2);
                int idx3 = idx2 + 1;
                int D2 = D + ((E2 << 5) | (E2 >>> 27)) + f(A, B2, C) + this.X[idx2] + Y1;
                int A2 = (A << 30) | (A >>> 2);
                int idx4 = idx3 + 1;
                int C2 = C + ((D2 << 5) | (D2 >>> 27)) + f(E2, A2, B2) + this.X[idx3] + Y1;
                E = (E2 << 30) | (E2 >>> 2);
                int idx5 = idx4 + 1;
                B = B2 + ((C2 << 5) | (C2 >>> 27)) + f(D2, E, A2) + this.X[idx4] + Y1;
                D = (D2 << 30) | (D2 >>> 2);
                A = A2 + ((B << 5) | (B >>> 27)) + f(C2, D, E) + this.X[idx5] + Y1;
                C = (C2 << 30) | (C2 >>> 2);
                j10++;
                idx = idx5 + 1;
            }
            int j11 = 0;
            while (j11 < 4) {
                int idx6 = idx + 1;
                int E3 = E + ((A << 5) | (A >>> 27)) + h(B, C, D) + this.X[idx] + Y2;
                int B3 = (B << 30) | (B >>> 2);
                int idx7 = idx6 + 1;
                int D3 = D + ((E3 << 5) | (E3 >>> 27)) + h(A, B3, C) + this.X[idx6] + Y2;
                int A3 = (A << 30) | (A >>> 2);
                int idx8 = idx7 + 1;
                int C3 = C + ((D3 << 5) | (D3 >>> 27)) + h(E3, A3, B3) + this.X[idx7] + Y2;
                E = (E3 << 30) | (E3 >>> 2);
                int idx9 = idx8 + 1;
                B = B3 + ((C3 << 5) | (C3 >>> 27)) + h(D3, E, A3) + this.X[idx8] + Y2;
                D = (D3 << 30) | (D3 >>> 2);
                A = A3 + ((B << 5) | (B >>> 27)) + h(C3, D, E) + this.X[idx9] + Y2;
                C = (C3 << 30) | (C3 >>> 2);
                j11++;
                idx = idx9 + 1;
            }
            int j12 = 0;
            while (j12 < 4) {
                int idx10 = idx + 1;
                int E4 = E + ((A << 5) | (A >>> 27)) + g(B, C, D) + this.X[idx] + Y3;
                int B4 = (B << 30) | (B >>> 2);
                int idx11 = idx10 + 1;
                int D4 = D + ((E4 << 5) | (E4 >>> 27)) + g(A, B4, C) + this.X[idx10] + Y3;
                int A4 = (A << 30) | (A >>> 2);
                int idx12 = idx11 + 1;
                int C4 = C + ((D4 << 5) | (D4 >>> 27)) + g(E4, A4, B4) + this.X[idx11] + Y3;
                E = (E4 << 30) | (E4 >>> 2);
                int idx13 = idx12 + 1;
                B = B4 + ((C4 << 5) | (C4 >>> 27)) + g(D4, E, A4) + this.X[idx12] + Y3;
                D = (D4 << 30) | (D4 >>> 2);
                A = A4 + ((B << 5) | (B >>> 27)) + g(C4, D, E) + this.X[idx13] + Y3;
                C = (C4 << 30) | (C4 >>> 2);
                j12++;
                idx = idx13 + 1;
            }
            int j13 = 0;
            while (j13 <= 3) {
                int idx14 = idx + 1;
                int E5 = E + ((A << 5) | (A >>> 27)) + h(B, C, D) + this.X[idx] + Y4;
                int B5 = (B << 30) | (B >>> 2);
                int idx15 = idx14 + 1;
                int D5 = D + ((E5 << 5) | (E5 >>> 27)) + h(A, B5, C) + this.X[idx14] + Y4;
                int A5 = (A << 30) | (A >>> 2);
                int idx16 = idx15 + 1;
                int C5 = C + ((D5 << 5) | (D5 >>> 27)) + h(E5, A5, B5) + this.X[idx15] + Y4;
                E = (E5 << 30) | (E5 >>> 2);
                int idx17 = idx16 + 1;
                B = B5 + ((C5 << 5) | (C5 >>> 27)) + h(D5, E, A5) + this.X[idx16] + Y4;
                D = (D5 << 30) | (D5 >>> 2);
                A = A5 + ((B << 5) | (B >>> 27)) + h(C5, D, E) + this.X[idx17] + Y4;
                C = (C5 << 30) | (C5 >>> 2);
                j13++;
                idx = idx17 + 1;
            }
            int j14 = this.H1;
            this.H1 = j14 + A;
            this.H2 += B;
            this.H3 += C;
            this.H4 += D;
            this.H5 += E;
            this.xOff = 0;
            for (int i11 = 0; i11 < 16; i11++) {
                this.X[i11] = 0;
            }
        }
    }
}