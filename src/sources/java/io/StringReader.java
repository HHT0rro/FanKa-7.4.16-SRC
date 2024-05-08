package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StringReader extends Reader {
    private int length;
    private String str;
    private int next = 0;
    private int mark = 0;

    public StringReader(String s2) {
        this.str = s2;
        this.length = s2.length();
    }

    private void ensureOpen() throws IOException {
        if (this.str == null) {
            throw new IOException("Stream closed");
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            int i10 = this.next;
            if (i10 >= this.length) {
                return -1;
            }
            String str = this.str;
            this.next = i10 + 1;
            return str.charAt(i10);
        }
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int off, int len) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (off < 0 || off > cbuf.length || len < 0 || off + len > cbuf.length || off + len < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (len == 0) {
                return 0;
            }
            int i10 = this.next;
            int i11 = this.length;
            if (i10 >= i11) {
                return -1;
            }
            int n10 = Math.min(i11 - i10, len);
            String str = this.str;
            int i12 = this.next;
            str.getChars(i12, i12 + n10, cbuf, off);
            this.next += n10;
            return n10;
        }
    }

    @Override // java.io.Reader
    public long skip(long ns) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (this.next >= this.length) {
                return 0L;
            }
            long n10 = Math.max(-this.next, Math.min(r2 - r1, ns));
            this.next = (int) (this.next + n10);
            return n10;
        }
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
        }
        return true;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public void mark(int readAheadLimit) throws IOException {
        if (readAheadLimit < 0) {
            throw new IllegalArgumentException("Read-ahead limit < 0");
        }
        synchronized (this.lock) {
            ensureOpen();
            this.mark = this.next;
        }
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            this.next = this.mark;
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            this.str = null;
        }
    }
}
