package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ThresholdingOutputStream extends OutputStream {
    private final int threshold;
    private boolean thresholdExceeded;
    private long written;

    public ThresholdingOutputStream(int i10) {
        this.threshold = i10;
    }

    public void checkThreshold(int i10) throws IOException {
        if (this.thresholdExceeded || this.written + i10 <= this.threshold) {
            return;
        }
        this.thresholdExceeded = true;
        thresholdReached();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
        } catch (IOException unused) {
        }
        getStream().close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        getStream().flush();
    }

    public long getByteCount() {
        return this.written;
    }

    public abstract OutputStream getStream() throws IOException;

    public int getThreshold() {
        return this.threshold;
    }

    public boolean isThresholdExceeded() {
        return this.written > ((long) this.threshold);
    }

    public void resetByteCount() {
        this.thresholdExceeded = false;
        this.written = 0L;
    }

    public abstract void thresholdReached() throws IOException;

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        checkThreshold(1);
        getStream().write(i10);
        this.written++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        checkThreshold(bArr.length);
        getStream().write(bArr);
        this.written += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        checkThreshold(i11);
        getStream().write(bArr, i10, i11);
        this.written += i11;
    }
}
