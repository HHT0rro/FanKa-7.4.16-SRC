package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CharArrayReader extends Reader {
    protected char[] buf;
    protected int count;
    protected int markedPos;
    protected int pos;

    public CharArrayReader(char[] buf) {
        this.markedPos = 0;
        this.buf = buf;
        this.pos = 0;
        this.count = buf.length;
    }

    public CharArrayReader(char[] buf, int offset, int length) {
        this.markedPos = 0;
        if (offset < 0 || offset > buf.length || length < 0 || offset + length < 0) {
            throw new IllegalArgumentException();
        }
        this.buf = buf;
        this.pos = offset;
        this.count = Math.min(offset + length, buf.length);
        this.markedPos = offset;
    }

    private void ensureOpen() throws IOException {
        if (this.buf == null) {
            throw new IOException("Stream closed");
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            int i10 = this.pos;
            if (i10 >= this.count) {
                return -1;
            }
            char[] cArr = this.buf;
            this.pos = i10 + 1;
            return cArr[i10];
        }
    }

    @Override // java.io.Reader
    public int read(char[] b4, int off, int len) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (off < 0 || off > b4.length || len < 0 || off + len > b4.length || off + len < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (len == 0) {
                return 0;
            }
            int i10 = this.pos;
            int i11 = this.count;
            if (i10 >= i11) {
                return -1;
            }
            int avail = i11 - i10;
            if (len > avail) {
                len = avail;
            }
            if (len <= 0) {
                return 0;
            }
            System.arraycopy((Object) this.buf, i10, (Object) b4, off, len);
            this.pos += len;
            return len;
        }
    }

    @Override // java.io.Reader
    public long skip(long n10) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            int i10 = this.count;
            int i11 = this.pos;
            long avail = i10 - i11;
            if (n10 > avail) {
                n10 = avail;
            }
            if (n10 < 0) {
                return 0L;
            }
            this.pos = (int) (i11 + n10);
            return n10;
        }
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        boolean z10;
        synchronized (this.lock) {
            ensureOpen();
            z10 = this.count - this.pos > 0;
        }
        return z10;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public void mark(int readAheadLimit) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            this.markedPos = this.pos;
        }
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            this.pos = this.markedPos;
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            this.buf = null;
        }
    }
}
