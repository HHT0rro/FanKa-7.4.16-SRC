package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FilterInputStream extends InputStream {
    protected volatile InputStream in;

    /* JADX INFO: Access modifiers changed from: protected */
    public FilterInputStream(InputStream in) {
        this.in = in;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.in.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] b4) throws IOException {
        return read(b4, 0, b4.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b4, int off, int len) throws IOException {
        return this.in.read(b4, off, len);
    }

    @Override // java.io.InputStream
    public long skip(long n10) throws IOException {
        return this.in.skip(n10);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int readlimit) {
        this.in.mark(readlimit);
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.in.reset();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }
}
