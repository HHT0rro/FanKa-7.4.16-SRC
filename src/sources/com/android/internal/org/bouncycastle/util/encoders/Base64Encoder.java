package com.android.internal.org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.ObjectStreamConstants;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Base64Encoder implements Encoder {
    protected final byte[] encodingTable = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, ObjectStreamConstants.TC_REFERENCE, ObjectStreamConstants.TC_CLASSDESC, ObjectStreamConstants.TC_OBJECT, ObjectStreamConstants.TC_STRING, ObjectStreamConstants.TC_ARRAY, ObjectStreamConstants.TC_CLASS, ObjectStreamConstants.TC_BLOCKDATA, ObjectStreamConstants.TC_ENDBLOCKDATA, ObjectStreamConstants.TC_RESET, ObjectStreamConstants.TC_BLOCKDATALONG, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    protected byte padding = 61;
    protected final byte[] decodingTable = new byte[128];

    protected void initialiseDecodingTable() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.decodingTable;
            if (i10 >= bArr.length) {
                break;
            }
            bArr[i10] = -1;
            i10++;
        }
        int i11 = 0;
        while (true) {
            byte[] bArr2 = this.encodingTable;
            if (i11 < bArr2.length) {
                this.decodingTable[bArr2[i11]] = (byte) i11;
                i11++;
            } else {
                return;
            }
        }
    }

    public Base64Encoder() {
        initialiseDecodingTable();
    }

    public int encode(byte[] inBuf, int inOff, int inLen, byte[] outBuf, int outOff) throws IOException {
        int a12 = inOff;
        int inEnd = (inOff + inLen) - 2;
        int outPos = outOff;
        while (a12 < inEnd) {
            int inPos = a12 + 1;
            int a13 = inBuf[a12];
            int inPos2 = inPos + 1;
            int a22 = inBuf[inPos] & 255;
            int inPos3 = inPos2 + 1;
            int a32 = inBuf[inPos2] & 255;
            int outPos2 = outPos + 1;
            byte[] bArr = this.encodingTable;
            outBuf[outPos] = bArr[(a13 >>> 2) & 63];
            int outPos3 = outPos2 + 1;
            outBuf[outPos2] = bArr[((a13 << 4) | (a22 >>> 4)) & 63];
            int outPos4 = outPos3 + 1;
            outBuf[outPos3] = bArr[((a22 << 2) | (a32 >>> 6)) & 63];
            outPos = outPos4 + 1;
            outBuf[outPos4] = bArr[a32 & 63];
            a12 = inPos3;
        }
        switch (inLen - (a12 - inOff)) {
            case 1:
                int a23 = a12 + 1;
                int inPos4 = inBuf[a12];
                int a14 = inPos4 & 255;
                int outPos5 = outPos + 1;
                byte[] bArr2 = this.encodingTable;
                outBuf[outPos] = bArr2[(a14 >>> 2) & 63];
                int outPos6 = outPos5 + 1;
                outBuf[outPos5] = bArr2[(a14 << 4) & 63];
                int outPos7 = outPos6 + 1;
                byte b4 = this.padding;
                outBuf[outPos6] = b4;
                outPos = outPos7 + 1;
                outBuf[outPos7] = b4;
                break;
            case 2:
                int inPos5 = a12 + 1;
                int inPos6 = inBuf[a12];
                int a15 = inPos6 & 255;
                int i10 = inPos5 + 1;
                int a24 = inBuf[inPos5] & 255;
                int outPos8 = outPos + 1;
                byte[] bArr3 = this.encodingTable;
                outBuf[outPos] = bArr3[(a15 >>> 2) & 63];
                int outPos9 = outPos8 + 1;
                outBuf[outPos8] = bArr3[((a15 << 4) | (a24 >>> 4)) & 63];
                int outPos10 = outPos9 + 1;
                outBuf[outPos9] = bArr3[(a24 << 2) & 63];
                outPos = outPos10 + 1;
                outBuf[outPos10] = this.padding;
                break;
        }
        int inPos7 = outPos - outOff;
        return inPos7;
    }

    @Override // com.android.internal.org.bouncycastle.util.encoders.Encoder
    public int encode(byte[] buf, int off, int len, OutputStream out) throws IOException {
        byte[] tmp = new byte[72];
        while (len > 0) {
            int inLen = Math.min(54, len);
            int outLen = encode(buf, off, inLen, tmp, 0);
            out.write(tmp, 0, outLen);
            off += inLen;
            len -= inLen;
        }
        return ((len + 2) / 3) * 4;
    }

    private boolean ignore(char c4) {
        return c4 == '\n' || c4 == '\r' || c4 == '\t' || c4 == ' ';
    }

    @Override // com.android.internal.org.bouncycastle.util.encoders.Encoder
    public int decode(byte[] data, int off, int length, OutputStream out) throws IOException {
        byte[] outBuffer = new byte[54];
        int end = off + length;
        while (end > off && ignore((char) data[end - 1])) {
            end--;
        }
        if (end == 0) {
            return 0;
        }
        int i10 = 0;
        int finish = end;
        while (finish > off && i10 != 4) {
            if (!ignore((char) data[finish - 1])) {
                i10++;
            }
            finish--;
        }
        int i11 = nextI(data, off, finish);
        int bufOff = 0;
        int outLen = 0;
        int i12 = i11;
        while (i12 < finish) {
            byte b12 = this.decodingTable[data[i12]];
            int i13 = nextI(data, i12 + 1, finish);
            int i14 = i13 + 1;
            byte b22 = this.decodingTable[data[i13]];
            int i15 = nextI(data, i14, finish);
            int i16 = i15 + 1;
            byte b32 = this.decodingTable[data[i15]];
            int i17 = nextI(data, i16, finish);
            int i18 = i17 + 1;
            byte b4 = this.decodingTable[data[i17]];
            if ((b12 | b22 | b32 | b4) < 0) {
                throw new IOException("invalid characters encountered in base64 data");
            }
            int bufOff2 = bufOff + 1;
            outBuffer[bufOff] = (byte) ((b12 << 2) | (b22 >> 4));
            int bufOff3 = bufOff2 + 1;
            outBuffer[bufOff2] = (byte) ((b22 << 4) | (b32 >> 2));
            int bufOff4 = bufOff3 + 1;
            outBuffer[bufOff3] = (byte) ((b32 << 6) | b4);
            if (bufOff4 != outBuffer.length) {
                bufOff = bufOff4;
            } else {
                out.write(outBuffer);
                bufOff = 0;
            }
            outLen += 3;
            i12 = nextI(data, i18, finish);
        }
        if (bufOff > 0) {
            out.write(outBuffer, 0, bufOff);
        }
        int e02 = nextI(data, i12, end);
        int e12 = nextI(data, e02 + 1, end);
        int e2 = nextI(data, e12 + 1, end);
        int e32 = nextI(data, e2 + 1, end);
        return outLen + decodeLastBlock(out, (char) data[e02], (char) data[e12], (char) data[e2], (char) data[e32]);
    }

    private int nextI(byte[] data, int i10, int finish) {
        while (i10 < finish && ignore((char) data[i10])) {
            i10++;
        }
        return i10;
    }

    @Override // com.android.internal.org.bouncycastle.util.encoders.Encoder
    public int decode(String data, OutputStream out) throws IOException {
        byte[] outBuffer = new byte[54];
        int end = data.length();
        while (end > 0 && ignore(data.charAt(end - 1))) {
            end--;
        }
        if (end == 0) {
            return 0;
        }
        int i10 = 0;
        int finish = end;
        while (finish > 0 && i10 != 4) {
            if (!ignore(data.charAt(finish - 1))) {
                i10++;
            }
            finish--;
        }
        int i11 = nextI(data, 0, finish);
        int bufOff = 0;
        int length = 0;
        int i12 = i11;
        while (i12 < finish) {
            byte b12 = this.decodingTable[data.charAt(i12)];
            int i13 = nextI(data, i12 + 1, finish);
            int i14 = i13 + 1;
            byte b22 = this.decodingTable[data.charAt(i13)];
            int i15 = nextI(data, i14, finish);
            int i16 = i15 + 1;
            byte b32 = this.decodingTable[data.charAt(i15)];
            int i17 = nextI(data, i16, finish);
            int i18 = i17 + 1;
            byte b4 = this.decodingTable[data.charAt(i17)];
            if ((b12 | b22 | b32 | b4) < 0) {
                throw new IOException("invalid characters encountered in base64 data");
            }
            int bufOff2 = bufOff + 1;
            outBuffer[bufOff] = (byte) ((b12 << 2) | (b22 >> 4));
            int bufOff3 = bufOff2 + 1;
            outBuffer[bufOff2] = (byte) ((b22 << 4) | (b32 >> 2));
            int bufOff4 = bufOff3 + 1;
            outBuffer[bufOff3] = (byte) ((b32 << 6) | b4);
            length += 3;
            if (bufOff4 == outBuffer.length) {
                out.write(outBuffer);
                bufOff4 = 0;
            }
            bufOff = bufOff4;
            i12 = nextI(data, i18, finish);
        }
        if (bufOff > 0) {
            out.write(outBuffer, 0, bufOff);
        }
        int e02 = nextI(data, i12, end);
        int e12 = nextI(data, e02 + 1, end);
        int e2 = nextI(data, e12 + 1, end);
        int e32 = nextI(data, e2 + 1, end);
        return length + decodeLastBlock(out, data.charAt(e02), data.charAt(e12), data.charAt(e2), data.charAt(e32));
    }

    private int decodeLastBlock(OutputStream out, char c12, char c22, char c32, char c4) throws IOException {
        byte b4 = this.padding;
        if (c32 == b4) {
            if (c4 != b4) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            byte[] bArr = this.decodingTable;
            byte b12 = bArr[c12];
            byte b22 = bArr[c22];
            if ((b12 | b22) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            out.write((b12 << 2) | (b22 >> 4));
            return 1;
        }
        if (c4 == b4) {
            byte[] bArr2 = this.decodingTable;
            byte b13 = bArr2[c12];
            byte b23 = bArr2[c22];
            byte b32 = bArr2[c32];
            if ((b13 | b23 | b32) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            out.write((b13 << 2) | (b23 >> 4));
            out.write((b23 << 4) | (b32 >> 2));
            return 2;
        }
        byte[] bArr3 = this.decodingTable;
        byte b14 = bArr3[c12];
        byte b24 = bArr3[c22];
        byte b33 = bArr3[c32];
        byte b42 = bArr3[c4];
        if ((b14 | b24 | b33 | b42) < 0) {
            throw new IOException("invalid characters encountered at end of base64 data");
        }
        out.write((b14 << 2) | (b24 >> 4));
        out.write((b24 << 4) | (b33 >> 2));
        out.write((b33 << 6) | b42);
        return 3;
    }

    private int nextI(String data, int i10, int finish) {
        while (i10 < finish && ignore(data.charAt(i10))) {
            i10++;
        }
        return i10;
    }
}
