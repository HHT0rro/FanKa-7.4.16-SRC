package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PushbackReader extends FilterReader {
    private char[] buf;
    private int pos;

    public PushbackReader(Reader in, int size) {
        super(in);
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.buf = new char[size];
        this.pos = size;
    }

    public PushbackReader(Reader in) {
        this(in, 1);
    }

    private void ensureOpen() throws IOException {
        if (this.buf == null) {
            throw new IOException("Stream closed");
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            int i10 = this.pos;
            char[] cArr = this.buf;
            if (i10 < cArr.length) {
                this.pos = i10 + 1;
                return cArr[i10];
            }
            return super.read();
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] cbuf, int off, int len) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            try {
                if (len <= 0) {
                    if (len < 0) {
                        throw new IndexOutOfBoundsException();
                    }
                    if (off < 0 || off > cbuf.length) {
                        throw new IndexOutOfBoundsException();
                    }
                    return 0;
                }
                char[] cArr = this.buf;
                int length = cArr.length;
                int i10 = this.pos;
                int avail = length - i10;
                if (avail > 0) {
                    if (len < avail) {
                        avail = len;
                    }
                    System.arraycopy((Object) cArr, i10, (Object) cbuf, off, avail);
                    this.pos += avail;
                    off += avail;
                    len -= avail;
                }
                if (len <= 0) {
                    return avail;
                }
                int len2 = super.read(cbuf, off, len);
                if (len2 == -1) {
                    return avail != 0 ? avail : -1;
                }
                return avail + len2;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public void unread(int c4) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            int i10 = this.pos;
            if (i10 == 0) {
                throw new IOException("Pushback buffer overflow");
            }
            char[] cArr = this.buf;
            int i11 = i10 - 1;
            this.pos = i11;
            cArr[i11] = (char) c4;
        }
    }

    public void unread(char[] cbuf, int off, int len) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            int i10 = this.pos;
            if (len > i10) {
                throw new IOException("Pushback buffer overflow");
            }
            int i11 = i10 - len;
            this.pos = i11;
            System.arraycopy((Object) cbuf, off, (Object) this.buf, i11, len);
        }
    }

    public void unread(char[] cbuf) throws IOException {
        unread(cbuf, 0, cbuf.length);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean ready() throws IOException {
        boolean z10;
        synchronized (this.lock) {
            ensureOpen();
            z10 = this.pos < this.buf.length || super.ready();
        }
        return z10;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public void mark(int readAheadLimit) throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterReader, java.io.Reader
    public void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.lock) {
            super.close();
            this.buf = null;
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public long skip(long n10) throws IOException {
        if (n10 < 0) {
            throw new IllegalArgumentException("skip value is negative");
        }
        synchronized (this.lock) {
            ensureOpen();
            char[] cArr = this.buf;
            int length = cArr.length;
            int i10 = this.pos;
            int avail = length - i10;
            if (avail > 0) {
                if (n10 <= avail) {
                    this.pos = (int) (i10 + n10);
                    return n10;
                }
                this.pos = cArr.length;
                n10 -= avail;
            }
            return avail + super.skip(n10);
        }
    }
}
