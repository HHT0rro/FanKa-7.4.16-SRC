package javax.crypto;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CipherInputStream extends FilterInputStream {
    private Cipher cipher;
    private boolean closed;
    private boolean done;
    private byte[] ibuffer;
    private InputStream input;
    private byte[] obuffer;
    private int ofinish;
    private int ostart;

    private int getMoreData() throws IOException {
        if (this.done) {
            return -1;
        }
        this.ofinish = 0;
        this.ostart = 0;
        int expectedOutputSize = this.cipher.getOutputSize(this.ibuffer.length);
        byte[] bArr = this.obuffer;
        if (bArr == null || expectedOutputSize > bArr.length) {
            this.obuffer = new byte[expectedOutputSize];
        }
        int readin = this.input.read(this.ibuffer);
        if (readin == -1) {
            this.done = true;
            try {
                this.ofinish = this.cipher.doFinal(this.obuffer, 0);
            } catch (BadPaddingException | IllegalBlockSizeException e2) {
                this.obuffer = null;
                throw new IOException(e2);
            } catch (ShortBufferException e10) {
                this.obuffer = null;
                throw new IllegalStateException("ShortBufferException is not expected", e10);
            }
        } else {
            try {
                this.ofinish = this.cipher.update(this.ibuffer, 0, readin, this.obuffer, 0);
            } catch (IllegalStateException e11) {
                this.obuffer = null;
                throw e11;
            } catch (ShortBufferException e12) {
                this.obuffer = null;
                throw new IllegalStateException("ShortBufferException is not expected", e12);
            }
        }
        return this.ofinish;
    }

    public CipherInputStream(InputStream is, Cipher c4) {
        super(is);
        this.ibuffer = new byte[512];
        this.done = false;
        this.ostart = 0;
        this.ofinish = 0;
        this.closed = false;
        this.input = is;
        this.cipher = c4;
    }

    protected CipherInputStream(InputStream is) {
        super(is);
        this.ibuffer = new byte[512];
        this.done = false;
        this.ostart = 0;
        this.ofinish = 0;
        this.closed = false;
        this.input = is;
        this.cipher = new NullCipher();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.ostart >= this.ofinish) {
            int i10 = 0;
            while (i10 == 0) {
                i10 = getMoreData();
            }
            if (i10 == -1) {
                return -1;
            }
        }
        byte[] bArr = this.obuffer;
        int i11 = this.ostart;
        this.ostart = i11 + 1;
        return bArr[i11] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b4) throws IOException {
        return read(b4, 0, b4.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b4, int off, int len) throws IOException {
        if (this.ostart >= this.ofinish) {
            int i10 = 0;
            while (i10 == 0) {
                i10 = getMoreData();
            }
            if (i10 == -1) {
                return -1;
            }
        }
        if (len <= 0) {
            return 0;
        }
        int i11 = this.ofinish;
        int i12 = this.ostart;
        int available = i11 - i12;
        if (len < available) {
            available = len;
        }
        if (b4 != null) {
            System.arraycopy((Object) this.obuffer, i12, (Object) b4, off, available);
        }
        this.ostart += available;
        return available;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long n10) throws IOException {
        int i10 = this.ofinish;
        int i11 = this.ostart;
        int available = i10 - i11;
        if (n10 > available) {
            n10 = available;
        }
        if (n10 < 0) {
            return 0L;
        }
        this.ostart = (int) (i11 + n10);
        return n10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.ofinish - this.ostart;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.input.close();
        if (!this.done) {
            try {
                this.cipher.doFinal();
            } catch (BadPaddingException | IllegalBlockSizeException ex) {
                if (ex instanceof AEADBadTagException) {
                    throw new IOException(ex);
                }
            }
        }
        this.ostart = 0;
        this.ofinish = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }
}
