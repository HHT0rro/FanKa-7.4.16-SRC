package sun.net.www;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.net.ProgressSource;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MeteredStream extends FilterInputStream {
    protected boolean closed;
    protected long count;
    protected long expected;
    protected int markLimit;
    protected long markedCount;
    protected ProgressSource pi;

    public MeteredStream(InputStream is, ProgressSource pi, long expected) {
        super(is);
        this.closed = false;
        this.count = 0L;
        this.markedCount = 0L;
        this.markLimit = -1;
        this.pi = pi;
        this.expected = expected;
        if (pi != null) {
            pi.updateProgress(0L, expected);
        }
    }

    private final void justRead(long n10) throws IOException {
        if (n10 == -1) {
            if (!isMarked()) {
                close();
                return;
            }
            return;
        }
        long j10 = this.count + n10;
        this.count = j10;
        if (j10 - this.markedCount > this.markLimit) {
            this.markLimit = -1;
        }
        ProgressSource progressSource = this.pi;
        if (progressSource != null) {
            progressSource.updateProgress(j10, this.expected);
        }
        if (isMarked()) {
            return;
        }
        long j11 = this.expected;
        if (j11 > 0 && this.count >= j11) {
            close();
        }
    }

    private boolean isMarked() {
        int i10 = this.markLimit;
        return i10 >= 0 && this.count - this.markedCount <= ((long) i10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.closed) {
            return -1;
        }
        int c4 = this.in.read();
        if (c4 != -1) {
            justRead(1L);
        } else {
            justRead(c4);
        }
        return c4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] b4, int off, int len) throws IOException {
        if (this.closed) {
            return -1;
        }
        int n10 = this.in.read(b4, off, len);
        justRead(n10);
        return n10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long n10) throws IOException {
        if (this.closed) {
            return 0L;
        }
        long j10 = this.expected;
        long j11 = this.count;
        long min = n10 > j10 - j11 ? j10 - j11 : n10;
        long n11 = this.in.skip(min);
        justRead(n11);
        return n11;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.closed) {
            return;
        }
        ProgressSource progressSource = this.pi;
        if (progressSource != null) {
            progressSource.finishTracking();
        }
        this.closed = true;
        this.in.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return this.closed ? 0 : this.in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int readLimit) {
        if (this.closed) {
            return;
        }
        super.mark(readLimit);
        this.markedCount = this.count;
        this.markLimit = readLimit;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.closed) {
            return;
        }
        if (!isMarked()) {
            throw new IOException("Resetting to an invalid mark");
        }
        this.count = this.markedCount;
        super.reset();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        if (this.closed) {
            return false;
        }
        return super.markSupported();
    }

    protected void finalize() throws Throwable {
        try {
            close();
            ProgressSource progressSource = this.pi;
            if (progressSource != null) {
                progressSource.close();
            }
        } finally {
            super.finalize();
        }
    }
}
