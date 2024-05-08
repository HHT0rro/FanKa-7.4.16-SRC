package org.apache.commons.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ProxyReader extends FilterReader {
    public ProxyReader(Reader reader) {
        super(reader);
    }

    public void afterRead(int i10) throws IOException {
    }

    public void beforeRead(int i10) throws IOException {
    }

    @Override // java.io.FilterReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
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

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized void mark(int i10) throws IOException {
        try {
            this.in.mark(i10);
        } catch (IOException e2) {
            handleIOException(e2);
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.FilterReader, java.io.Reader
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

    @Override // java.io.FilterReader, java.io.Reader
    public boolean ready() throws IOException {
        try {
            return this.in.ready();
        } catch (IOException e2) {
            handleIOException(e2);
            return false;
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public synchronized void reset() throws IOException {
        try {
            this.in.reset();
        } catch (IOException e2) {
            handleIOException(e2);
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public long skip(long j10) throws IOException {
        try {
            return this.in.skip(j10);
        } catch (IOException e2) {
            handleIOException(e2);
            return 0L;
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws IOException {
        int length;
        if (cArr != null) {
            try {
                length = cArr.length;
            } catch (IOException e2) {
                handleIOException(e2);
                return -1;
            }
        } else {
            length = 0;
        }
        beforeRead(length);
        int read = this.in.read(cArr);
        afterRead(read);
        return read;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i10, int i11) throws IOException {
        try {
            beforeRead(i11);
            int read = this.in.read(cArr, i10, i11);
            afterRead(read);
            return read;
        } catch (IOException e2) {
            handleIOException(e2);
            return -1;
        }
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) throws IOException {
        int length;
        if (charBuffer != null) {
            try {
                length = charBuffer.length();
            } catch (IOException e2) {
                handleIOException(e2);
                return -1;
            }
        } else {
            length = 0;
        }
        beforeRead(length);
        int read = this.in.read(charBuffer);
        afterRead(read);
        return read;
    }
}
