package sun.net;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class TelnetInputStream extends FilterInputStream {
    public boolean binaryMode;
    boolean seenCR;
    boolean stickyCRLF;

    public TelnetInputStream(InputStream fd2, boolean binary) {
        super(fd2);
        this.stickyCRLF = false;
        this.seenCR = false;
        this.binaryMode = false;
        this.binaryMode = binary;
    }

    public void setStickyCRLF(boolean on) {
        this.stickyCRLF = on;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.binaryMode) {
            return super.read();
        }
        if (this.seenCR) {
            this.seenCR = false;
            return 10;
        }
        int c4 = super.read();
        if (c4 != 13) {
            return c4;
        }
        switch (super.read()) {
            case 0:
                return 13;
            case 10:
                if (!this.stickyCRLF) {
                    return 10;
                }
                this.seenCR = true;
                return 13;
            default:
                throw new TelnetProtocolException("misplaced CR in input");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bytes) throws IOException {
        return read(bytes, 0, bytes.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bytes, int off, int length) throws IOException {
        int c4;
        if (this.binaryMode) {
            return super.read(bytes, off, length);
        }
        while (true) {
            length--;
            if (length < 0 || (c4 = read()) == -1) {
                break;
            }
            bytes[off] = (byte) c4;
            off++;
        }
        if (off > off) {
            return off - off;
        }
        return -1;
    }
}
