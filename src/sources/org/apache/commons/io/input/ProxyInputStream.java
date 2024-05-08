package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ProxyInputStream extends FilterInputStream {
    public ProxyInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public void afterRead(int i10) throws IOException {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        try {
            return super.available();
        } catch (IOException e2) {
            handleIOException(e2);
            return 0;
        }
    }

    public void beforeRead(int i10) throws IOException {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.in.close();
        } catch (IOException e2) {
            handleIOException(e2);
        }
    }

    public void handleIOException(IOException iOException) throws IOException {
        throw iOException;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        this.in.mark(i10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i10 = 1;
        try {
            beforeRead(1);
            int read = this.in.read();
            if (read == -1) {
                i10 = -1;
            }
            afterRead(i10);
            return read;
        } catch (IOException e2) {
            handleIOException(e2);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            this.in.reset();
        } catch (IOException e2) {
            handleIOException(e2);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        try {
            return this.in.skip(j10);
        } catch (IOException e2) {
            handleIOException(e2);
            return 0L;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int length;
        if (bArr != null) {
            try {
                length = bArr.length;
            } catch (IOException e2) {
                handleIOException(e2);
                return -1;
            }
        } else {
            length = 0;
        }
        beforeRead(length);
        int read = this.in.read(bArr);
        afterRead(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        try {
            beforeRead(i11);
            int read = this.in.read(bArr, i10, i11);
            afterRead(read);
            return read;
        } catch (IOException e2) {
            handleIOException(e2);
            return -1;
        }
    }
}
