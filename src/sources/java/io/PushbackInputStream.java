package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PushbackInputStream extends FilterInputStream {
    protected byte[] buf;
    protected int pos;

    private void ensureOpen() throws IOException {
        if (this.in == null) {
            throw new IOException("Stream closed");
        }
    }

    public PushbackInputStream(InputStream in, int size) {
        super(in);
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.buf = new byte[size];
        this.pos = size;
    }

    public PushbackInputStream(InputStream in) {
        this(in, 1);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        ensureOpen();
        int i10 = this.pos;
        byte[] bArr = this.buf;
        if (i10 < bArr.length) {
            this.pos = i10 + 1;
            return bArr[i10] & 255;
        }
        return super.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b4, int off, int len) throws IOException {
        ensureOpen();
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || len > b4.length - off) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return 0;
        }
        byte[] bArr = this.buf;
        int length = bArr.length;
        int i10 = this.pos;
        int avail = length - i10;
        if (avail > 0) {
            if (len < avail) {
                avail = len;
            }
            System.arraycopy((Object) bArr, i10, (Object) b4, off, avail);
            this.pos += avail;
            off += avail;
            len -= avail;
        }
        if (len > 0) {
            int len2 = super.read(b4, off, len);
            if (len2 == -1) {
                if (avail == 0) {
                    return -1;
                }
                return avail;
            }
            return avail + len2;
        }
        return avail;
    }

    public void unread(int b4) throws IOException {
        ensureOpen();
        int i10 = this.pos;
        if (i10 == 0) {
            throw new IOException("Push back buffer is full");
        }
        byte[] bArr = this.buf;
        int i11 = i10 - 1;
        this.pos = i11;
        bArr[i11] = (byte) b4;
    }

    public void unread(byte[] b4, int off, int len) throws IOException {
        ensureOpen();
        int i10 = this.pos;
        if (len > i10) {
            throw new IOException("Push back buffer is full");
        }
        int i11 = i10 - len;
        this.pos = i11;
        System.arraycopy((Object) b4, off, (Object) this.buf, i11, len);
    }

    public void unread(byte[] b4) throws IOException {
        unread(b4, 0, b4.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        ensureOpen();
        int n10 = this.buf.length - this.pos;
        int avail = super.available();
        if (n10 > Integer.MAX_VALUE - avail) {
            return Integer.MAX_VALUE;
        }
        return n10 + avail;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long n10) throws IOException {
        ensureOpen();
        if (n10 <= 0) {
            return 0L;
        }
        int length = this.buf.length;
        int i10 = this.pos;
        long pskip = length - i10;
        if (pskip > 0) {
            if (n10 < pskip) {
                pskip = n10;
            }
            this.pos = (int) (i10 + pskip);
            n10 -= pskip;
        }
        if (n10 > 0) {
            return pskip + super.skip(n10);
        }
        return pskip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int readlimit) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.in == null) {
            return;
        }
        this.in.close();
        this.in = null;
        this.buf = null;
    }
}
