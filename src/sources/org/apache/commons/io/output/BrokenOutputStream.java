package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class BrokenOutputStream extends OutputStream {
    private final IOException exception;

    public BrokenOutputStream(IOException iOException) {
        this.exception = iOException;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw this.exception;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        throw this.exception;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        throw this.exception;
    }

    public BrokenOutputStream() {
        this(new IOException("Broken output stream"));
    }
}
