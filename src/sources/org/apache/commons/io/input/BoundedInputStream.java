package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class BoundedInputStream extends InputStream {
    private final InputStream in;
    private long mark;
    private final long max;
    private long pos;
    private boolean propagateClose;

    public BoundedInputStream(InputStream inputStream, long j10) {
        this.pos = 0L;
        this.mark = -1L;
        this.propagateClose = true;
        this.max = j10;
        this.in = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long j10 = this.max;
        if (j10 < 0 || this.pos < j10) {
            return this.in.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.propagateClose) {
            this.in.close();
        }
    }

    public boolean isPropagateClose() {
        return this.propagateClose;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i10) {
        this.in.mark(i10);
        this.mark = this.pos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        long j10 = this.max;
        if (j10 >= 0 && this.pos >= j10) {
            return -1;
        }
        int read = this.in.read();
        this.pos++;
        return read;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.in.reset();
        this.pos = this.mark;
    }

    public void setPropagateClose(boolean z10) {
        this.propagateClose = z10;
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        long j11 = this.max;
        if (j11 >= 0) {
            j10 = Math.min(j10, j11 - this.pos);
        }
        long skip = this.in.skip(j10);
        this.pos += skip;
        return skip;
    }

    public String toString() {
        return this.in.toString();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        long j10 = this.max;
        if (j10 >= 0 && this.pos >= j10) {
            return -1;
        }
        int read = this.in.read(bArr, i10, (int) (j10 >= 0 ? Math.min(i11, j10 - this.pos) : i11));
        if (read == -1) {
            return -1;
        }
        this.pos += read;
        return read;
    }

    public BoundedInputStream(InputStream inputStream) {
        this(inputStream, -1L);
    }
}
