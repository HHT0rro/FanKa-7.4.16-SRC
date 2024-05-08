package com.android.internal.org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class HexEncoder implements Encoder {
    protected final byte[] encodingTable = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
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
                byte[] bArr3 = this.decodingTable;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
        }
    }

    public HexEncoder() {
        initialiseDecodingTable();
    }

    public int encode(byte[] inBuf, int inOff, int inLen, byte[] outBuf, int outOff) throws IOException {
        int b4 = inOff;
        int inEnd = inOff + inLen;
        int outPos = outOff;
        while (b4 < inEnd) {
            int inPos = b4 + 1;
            int inPos2 = inBuf[b4];
            int b10 = inPos2 & 255;
            int outPos2 = outPos + 1;
            byte[] bArr = this.encodingTable;
            outBuf[outPos] = bArr[b10 >>> 4];
            outPos = outPos2 + 1;
            outBuf[outPos2] = bArr[b10 & 15];
            b4 = inPos;
        }
        int inPos3 = outPos - outOff;
        return inPos3;
    }

    @Override // com.android.internal.org.bouncycastle.util.encoders.Encoder
    public int encode(byte[] buf, int off, int len, OutputStream out) throws IOException {
        byte[] tmp = new byte[72];
        while (len > 0) {
            int inLen = Math.min(36, len);
            int outLen = encode(buf, off, inLen, tmp, 0);
            out.write(tmp, 0, outLen);
            off += inLen;
            len -= inLen;
        }
        return len * 2;
    }

    private static boolean ignore(char c4) {
        return c4 == '\n' || c4 == '\r' || c4 == '\t' || c4 == ' ';
    }

    @Override // com.android.internal.org.bouncycastle.util.encoders.Encoder
    public int decode(byte[] data, int off, int length, OutputStream out) throws IOException {
        int outLen = 0;
        byte[] buf = new byte[36];
        int bufOff = 0;
        int end = off + length;
        while (end > off && ignore((char) data[end - 1])) {
            end--;
        }
        int i10 = off;
        while (i10 < end) {
            while (i10 < end && ignore((char) data[i10])) {
                i10++;
            }
            int i11 = i10 + 1;
            byte b12 = this.decodingTable[data[i10]];
            while (i11 < end && ignore((char) data[i11])) {
                i11++;
            }
            int i12 = i11 + 1;
            byte b22 = this.decodingTable[data[i11]];
            if ((b12 | b22) < 0) {
                throw new IOException("invalid characters encountered in Hex data");
            }
            int bufOff2 = bufOff + 1;
            buf[bufOff] = (byte) ((b12 << 4) | b22);
            if (bufOff2 != buf.length) {
                bufOff = bufOff2;
            } else {
                out.write(buf);
                bufOff = 0;
            }
            outLen++;
            i10 = i12;
        }
        if (bufOff > 0) {
            out.write(buf, 0, bufOff);
        }
        return outLen;
    }

    @Override // com.android.internal.org.bouncycastle.util.encoders.Encoder
    public int decode(String data, OutputStream out) throws IOException {
        int length = 0;
        byte[] buf = new byte[36];
        int bufOff = 0;
        int end = data.length();
        while (end > 0 && ignore(data.charAt(end - 1))) {
            end--;
        }
        int i10 = 0;
        while (i10 < end) {
            while (i10 < end && ignore(data.charAt(i10))) {
                i10++;
            }
            int i11 = i10 + 1;
            byte b12 = this.decodingTable[data.charAt(i10)];
            while (i11 < end && ignore(data.charAt(i11))) {
                i11++;
            }
            int i12 = i11 + 1;
            byte b22 = this.decodingTable[data.charAt(i11)];
            if ((b12 | b22) < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }
            int bufOff2 = bufOff + 1;
            buf[bufOff] = (byte) ((b12 << 4) | b22);
            if (bufOff2 != buf.length) {
                bufOff = bufOff2;
            } else {
                out.write(buf);
                bufOff = 0;
            }
            length++;
            i10 = i12;
        }
        if (bufOff > 0) {
            out.write(buf, 0, bufOff);
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] decodeStrict(String str, int off, int len) throws IOException {
        if (str == null) {
            throw new NullPointerException("'str' cannot be null");
        }
        if (off < 0 || len < 0 || off > str.length() - len) {
            throw new IndexOutOfBoundsException("invalid offset and/or length specified");
        }
        if ((len & 1) != 0) {
            throw new IOException("a hexadecimal encoding must have an even number of characters");
        }
        int resultLen = len >>> 1;
        byte[] result = new byte[resultLen];
        int strPos = off;
        int i10 = 0;
        while (i10 < resultLen) {
            int strPos2 = strPos + 1;
            byte b12 = this.decodingTable[str.charAt(strPos)];
            int strPos3 = strPos2 + 1;
            byte b22 = this.decodingTable[str.charAt(strPos2)];
            int n10 = (b12 << 4) | b22;
            if (n10 < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }
            result[i10] = (byte) n10;
            i10++;
            strPos = strPos3;
        }
        return result;
    }
}
