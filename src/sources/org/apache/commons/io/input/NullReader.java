package org.apache.commons.io.input;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class NullReader extends Reader {
    private boolean eof;
    private long mark;
    private final boolean markSupported;
    private long position;
    private long readlimit;
    private final long size;
    private final boolean throwEofException;

    public NullReader(long j10) {
        this(j10, true, false);
    }

    private int doEndOfFile() throws EOFException {
        this.eof = true;
        if (this.throwEofException) {
            throw new EOFException();
        }
        return -1;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.eof = false;
        this.position = 0L;
        this.mark = -1L;
    }

    public long getPosition() {
        return this.position;
    }

    public long getSize() {
        return this.size;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i10) {
        if (this.markSupported) {
            this.mark = this.position;
            this.readlimit = i10;
        } else {
            throw new UnsupportedOperationException("Mark not supported");
        }
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return this.markSupported;
    }

    public int processChar() {
        return 0;
    }

    public void processChars(char[] cArr, int i10, int i11) {
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (!this.eof) {
            long j10 = this.position;
            if (j10 == this.size) {
                return doEndOfFile();
            }
            this.position = j10 + 1;
            return processChar();
        }
        throw new IOException("Read after end of file");
    }

    @Override // java.io.Reader
    public synchronized void reset() throws IOException {
        if (this.markSupported) {
            long j10 = this.mark;
            if (j10 < 0) {
                throw new IOException("No position has been marked");
            }
            if (this.position <= this.readlimit + j10) {
                this.position = j10;
                this.eof = false;
            } else {
                throw new IOException("Marked position [" + this.mark + "] is no longer valid - passed the read limit [" + this.readlimit + "]");
            }
        } else {
            throw new UnsupportedOperationException("Mark not supported");
        }
    }

    @Override // java.io.Reader
    public long skip(long j10) throws IOException {
        if (!this.eof) {
            long j11 = this.position;
            long j12 = this.size;
            if (j11 == j12) {
                return doEndOfFile();
            }
            long j13 = j11 + j10;
            this.position = j13;
            if (j13 <= j12) {
                return j10;
            }
            long j14 = j10 - (j13 - j12);
            this.position = j12;
            return j14;
        }
        throw new IOException("Skip after end of file");
    }

    public NullReader(long j10, boolean z10, boolean z11) {
        this.mark = -1L;
        this.size = j10;
        this.markSupported = z10;
        this.throwEofException = z11;
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws IOException {
        return read(cArr, 0, cArr.length);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i10, int i11) throws IOException {
        if (!this.eof) {
            long j10 = this.position;
            long j11 = this.size;
            if (j10 == j11) {
                return doEndOfFile();
            }
            long j12 = j10 + i11;
            this.position = j12;
            if (j12 > j11) {
                i11 -= (int) (j12 - j11);
                this.position = j11;
            }
            processChars(cArr, i10, i11);
            return i11;
        }
        throw new IOException("Read after end of file");
    }
}
