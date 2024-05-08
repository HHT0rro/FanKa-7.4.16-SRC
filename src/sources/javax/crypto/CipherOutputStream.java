package javax.crypto;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CipherOutputStream extends FilterOutputStream {
    private Cipher cipher;
    private boolean closed;
    private byte[] ibuffer;
    private byte[] obuffer;
    private OutputStream output;

    public CipherOutputStream(OutputStream os, Cipher c4) {
        super(os);
        this.ibuffer = new byte[1];
        this.closed = false;
        this.output = os;
        this.cipher = c4;
    }

    protected CipherOutputStream(OutputStream os) {
        super(os);
        this.ibuffer = new byte[1];
        this.closed = false;
        this.output = os;
        this.cipher = new NullCipher();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int b4) throws IOException {
        byte[] bArr = this.ibuffer;
        bArr[0] = (byte) b4;
        byte[] update = this.cipher.update(bArr, 0, 1);
        this.obuffer = update;
        if (update != null) {
            this.output.write(update);
            this.obuffer = null;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b4) throws IOException {
        write(b4, 0, b4.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b4, int off, int len) throws IOException {
        byte[] update = this.cipher.update(b4, off, len);
        this.obuffer = update;
        if (update != null) {
            this.output.write(update);
            this.obuffer = null;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        byte[] bArr = this.obuffer;
        if (bArr != null) {
            this.output.write(bArr);
            this.obuffer = null;
        }
        this.output.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        try {
            this.obuffer = this.cipher.doFinal();
            try {
                flush();
            } catch (IOException e2) {
            }
            this.out.close();
        } catch (BadPaddingException | IllegalBlockSizeException e10) {
            this.obuffer = null;
            throw new IOException(e10);
        }
    }
}
