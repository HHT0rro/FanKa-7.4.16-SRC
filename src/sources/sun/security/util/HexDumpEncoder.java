package sun.security.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import org.apache.commons.lang3.CharEncoding;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class HexDumpEncoder {
    private int currentByte;
    private int offset;
    protected PrintStream pStream;
    private byte[] thisLine = new byte[16];
    private int thisLineLength;

    static void hexDigit(PrintStream p10, byte x10) {
        char c4;
        char c10;
        char c11 = (char) ((x10 >> 4) & 15);
        if (c11 > '\t') {
            c4 = (char) ((c11 - '\n') + 65);
        } else {
            c4 = (char) (c11 + '0');
        }
        p10.write(c4);
        char c12 = (char) (x10 & 15);
        if (c12 > '\t') {
            c10 = (char) ((c12 - '\n') + 65);
        } else {
            c10 = (char) (c12 + '0');
        }
        p10.write(c10);
    }

    protected int bytesPerAtom() {
        return 1;
    }

    protected int bytesPerLine() {
        return 16;
    }

    protected void encodeBufferPrefix(OutputStream o10) throws IOException {
        this.offset = 0;
        this.pStream = new PrintStream(o10);
    }

    protected void encodeLinePrefix(OutputStream o10, int len) throws IOException {
        hexDigit(this.pStream, (byte) ((this.offset >>> 8) & 255));
        hexDigit(this.pStream, (byte) (this.offset & 255));
        this.pStream.print(": ");
        this.currentByte = 0;
        this.thisLineLength = len;
    }

    protected void encodeAtom(OutputStream o10, byte[] buf, int off, int len) throws IOException {
        this.thisLine[this.currentByte] = buf[off];
        hexDigit(this.pStream, buf[off]);
        this.pStream.print(" ");
        int i10 = this.currentByte + 1;
        this.currentByte = i10;
        if (i10 == 8) {
            this.pStream.print("  ");
        }
    }

    protected void encodeLineSuffix(OutputStream o10) throws IOException {
        if (this.thisLineLength < 16) {
            for (int i10 = this.thisLineLength; i10 < 16; i10++) {
                this.pStream.print("   ");
                if (i10 == 7) {
                    this.pStream.print("  ");
                }
            }
        }
        this.pStream.print(" ");
        for (int i11 = 0; i11 < this.thisLineLength; i11++) {
            byte b4 = this.thisLine[i11];
            if (b4 < 32 || b4 > 122) {
                this.pStream.print(".");
            } else {
                this.pStream.write(b4);
            }
        }
        this.pStream.println();
        this.offset += this.thisLineLength;
    }

    protected int readFully(InputStream in, byte[] buffer) throws IOException {
        for (int i10 = 0; i10 < buffer.length; i10++) {
            int q10 = in.read();
            if (q10 == -1) {
                return i10;
            }
            buffer[i10] = (byte) q10;
        }
        int i11 = buffer.length;
        return i11;
    }

    public void encode(InputStream inStream, OutputStream outStream) throws IOException {
        byte[] tmpbuffer = new byte[bytesPerLine()];
        encodeBufferPrefix(outStream);
        while (true) {
            int numBytes = readFully(inStream, tmpbuffer);
            if (numBytes != 0) {
                encodeLinePrefix(outStream, numBytes);
                int j10 = 0;
                while (j10 < numBytes) {
                    if (bytesPerAtom() + j10 <= numBytes) {
                        encodeAtom(outStream, tmpbuffer, j10, bytesPerAtom());
                    } else {
                        encodeAtom(outStream, tmpbuffer, j10, numBytes - j10);
                    }
                    j10 += bytesPerAtom();
                }
                if (numBytes >= bytesPerLine()) {
                    encodeLineSuffix(outStream);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public String encode(byte[] aBuffer) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        InputStream inStream = new ByteArrayInputStream(aBuffer);
        try {
            encode(inStream, outStream);
            String retVal = outStream.toString(CharEncoding.ISO_8859_1);
            return retVal;
        } catch (Exception e2) {
            throw new Error("CharacterEncoder.encode internal error");
        }
    }

    private byte[] getBytes(ByteBuffer bb2) {
        byte[] buf = null;
        if (bb2.hasArray()) {
            byte[] tmp = bb2.array();
            if (tmp.length == bb2.capacity() && tmp.length == bb2.remaining()) {
                buf = tmp;
                bb2.position(bb2.limit());
            }
        }
        if (buf == null) {
            byte[] buf2 = new byte[bb2.remaining()];
            bb2.get(buf2);
            return buf2;
        }
        return buf;
    }

    public String encode(ByteBuffer aBuffer) {
        byte[] buf = getBytes(aBuffer);
        return encode(buf);
    }

    public void encodeBuffer(InputStream inStream, OutputStream outStream) throws IOException {
        int numBytes;
        byte[] tmpbuffer = new byte[bytesPerLine()];
        encodeBufferPrefix(outStream);
        do {
            numBytes = readFully(inStream, tmpbuffer);
            if (numBytes != 0) {
                encodeLinePrefix(outStream, numBytes);
                int j10 = 0;
                while (j10 < numBytes) {
                    if (bytesPerAtom() + j10 <= numBytes) {
                        encodeAtom(outStream, tmpbuffer, j10, bytesPerAtom());
                    } else {
                        encodeAtom(outStream, tmpbuffer, j10, numBytes - j10);
                    }
                    j10 += bytesPerAtom();
                }
                encodeLineSuffix(outStream);
            } else {
                return;
            }
        } while (numBytes >= bytesPerLine());
    }

    public void encodeBuffer(byte[] aBuffer, OutputStream aStream) throws IOException {
        ByteArrayInputStream inStream = new ByteArrayInputStream(aBuffer);
        encodeBuffer(inStream, aStream);
    }

    public String encodeBuffer(byte[] aBuffer) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        InputStream inStream = new ByteArrayInputStream(aBuffer);
        try {
            encodeBuffer(inStream, outStream);
            return outStream.toString();
        } catch (Exception e2) {
            throw new Error("CharacterEncoder.encodeBuffer internal error");
        }
    }

    public void encodeBuffer(ByteBuffer aBuffer, OutputStream aStream) throws IOException {
        byte[] buf = getBytes(aBuffer);
        encodeBuffer(buf, aStream);
    }
}
