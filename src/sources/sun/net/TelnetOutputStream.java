package sun.net;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class TelnetOutputStream extends BufferedOutputStream {
    public boolean binaryMode;
    boolean seenCR;
    boolean stickyCRLF;

    public TelnetOutputStream(OutputStream fd2, boolean binary) {
        super(fd2);
        this.stickyCRLF = false;
        this.seenCR = false;
        this.binaryMode = false;
        this.binaryMode = binary;
    }

    public void setStickyCRLF(boolean on) {
        this.stickyCRLF = on;
    }

    @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int c4) throws IOException {
        if (this.binaryMode) {
            super.write(c4);
            return;
        }
        if (this.seenCR) {
            if (c4 != 10) {
                super.write(0);
            }
            super.write(c4);
            if (c4 != 13) {
                this.seenCR = false;
                return;
            }
            return;
        }
        if (c4 == 10) {
            super.write(13);
            super.write(10);
            return;
        }
        if (c4 == 13) {
            if (this.stickyCRLF) {
                this.seenCR = true;
            } else {
                super.write(13);
                c4 = 0;
            }
        }
        super.write(c4);
    }

    @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bytes, int off, int length) throws IOException {
        if (this.binaryMode) {
            super.write(bytes, off, length);
            return;
        }
        while (true) {
            length--;
            if (length >= 0) {
                write(bytes[off]);
                off++;
            } else {
                return;
            }
        }
    }
}
