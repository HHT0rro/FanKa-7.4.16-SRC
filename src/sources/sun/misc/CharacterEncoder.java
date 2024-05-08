package sun.misc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CharacterEncoder {
    protected PrintStream pStream;

    protected abstract int bytesPerAtom();

    protected abstract int bytesPerLine();

    protected abstract void encodeAtom(OutputStream outputStream, byte[] bArr, int i10, int i11) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void encodeBufferPrefix(OutputStream aStream) throws IOException {
        this.pStream = new PrintStream(aStream);
    }

    protected void encodeBufferSuffix(OutputStream aStream) throws IOException {
    }

    protected void encodeLinePrefix(OutputStream aStream, int aLength) throws IOException {
    }

    protected void encodeLineSuffix(OutputStream aStream) throws IOException {
        this.pStream.println();
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
            if (numBytes == 0) {
                break;
            }
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
            if (numBytes < bytesPerLine()) {
                break;
            } else {
                encodeLineSuffix(outStream);
            }
        }
        encodeBufferSuffix(outStream);
    }

    public void encode(byte[] aBuffer, OutputStream aStream) throws IOException {
        ByteArrayInputStream inStream = new ByteArrayInputStream(aBuffer);
        encode(inStream, aStream);
    }

    public String encode(byte[] aBuffer) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        InputStream inStream = new ByteArrayInputStream(aBuffer);
        try {
            encode(inStream, outStream);
            String retVal = outStream.toString("8859_1");
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

    public void encode(ByteBuffer aBuffer, OutputStream aStream) throws IOException {
        byte[] buf = getBytes(aBuffer);
        encode(buf, aStream);
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
            if (numBytes == 0) {
                break;
            }
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
        } while (numBytes >= bytesPerLine());
        encodeBufferSuffix(outStream);
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

    public String encodeBuffer(ByteBuffer aBuffer) {
        byte[] buf = getBytes(aBuffer);
        return encodeBuffer(buf);
    }
}
