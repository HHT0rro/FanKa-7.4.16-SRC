package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class FilterReader extends Reader {
    protected Reader in;

    /* JADX INFO: Access modifiers changed from: protected */
    public FilterReader(Reader in) {
        super(in);
        this.in = in;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        return this.in.read();
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int off, int len) throws IOException {
        return this.in.read(cbuf, off, len);
    }

    @Override // java.io.Reader
    public long skip(long n10) throws IOException {
        return this.in.skip(n10);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        return this.in.ready();
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.Reader
    public void mark(int readAheadLimit) throws IOException {
        this.in.mark(readAheadLimit);
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        this.in.reset();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }
}
