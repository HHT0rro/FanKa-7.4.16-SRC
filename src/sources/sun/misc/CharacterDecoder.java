package sun.misc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CharacterDecoder {
    protected abstract int bytesPerAtom();

    protected abstract int bytesPerLine();

    protected void decodeBufferPrefix(PushbackInputStream aStream, OutputStream bStream) throws IOException {
    }

    protected void decodeBufferSuffix(PushbackInputStream aStream, OutputStream bStream) throws IOException {
    }

    protected int decodeLinePrefix(PushbackInputStream aStream, OutputStream bStream) throws IOException {
        return bytesPerLine();
    }

    protected void decodeLineSuffix(PushbackInputStream aStream, OutputStream bStream) throws IOException {
    }

    protected void decodeAtom(PushbackInputStream aStream, OutputStream bStream, int l10) throws IOException {
        throw new CEStreamExhausted();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int readFully(InputStream in, byte[] buffer, int offset, int len) throws IOException {
        for (int i10 = 0; i10 < len; i10++) {
            int q10 = in.read();
            if (q10 == -1) {
                if (i10 == 0) {
                    return -1;
                }
                return i10;
            }
            buffer[i10 + offset] = (byte) q10;
        }
        return len;
    }

    public void decodeBuffer(InputStream aStream, OutputStream bStream) throws IOException {
        int totalBytes = 0;
        PushbackInputStream ps = new PushbackInputStream(aStream);
        decodeBufferPrefix(ps, bStream);
        while (true) {
            try {
                int length = decodeLinePrefix(ps, bStream);
                int i10 = 0;
                while (bytesPerAtom() + i10 < length) {
                    decodeAtom(ps, bStream, bytesPerAtom());
                    totalBytes += bytesPerAtom();
                    i10 += bytesPerAtom();
                }
                if (bytesPerAtom() + i10 == length) {
                    decodeAtom(ps, bStream, bytesPerAtom());
                    totalBytes += bytesPerAtom();
                } else {
                    decodeAtom(ps, bStream, length - i10);
                    totalBytes += length - i10;
                }
                decodeLineSuffix(ps, bStream);
            } catch (CEStreamExhausted e2) {
                decodeBufferSuffix(ps, bStream);
                return;
            }
        }
    }

    public byte[] decodeBuffer(String inputString) throws IOException {
        byte[] inputBuffer = new byte[inputString.length()];
        inputString.getBytes(0, inputString.length(), inputBuffer, 0);
        InputStream inStream = new ByteArrayInputStream(inputBuffer);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        decodeBuffer(inStream, outStream);
        return outStream.toByteArray();
    }

    public byte[] decodeBuffer(InputStream in) throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        decodeBuffer(in, outStream);
        return outStream.toByteArray();
    }

    public ByteBuffer decodeBufferToByteBuffer(String inputString) throws IOException {
        return ByteBuffer.wrap(decodeBuffer(inputString));
    }

    public ByteBuffer decodeBufferToByteBuffer(InputStream in) throws IOException {
        return ByteBuffer.wrap(decodeBuffer(in));
    }
}
