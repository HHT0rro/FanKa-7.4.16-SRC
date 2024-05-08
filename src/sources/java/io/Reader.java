package java.io;

import android.support.v4.media.session.PlaybackStateCompat;
import java.nio.CharBuffer;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Reader implements Readable, Closeable {
    private static final int TRANSFER_BUFFER_SIZE = 8192;
    private static final int maxSkipBufferSize = 8192;
    protected Object lock;
    private char[] skipBuffer;

    public abstract void close() throws IOException;

    public abstract int read(char[] cArr, int i10, int i11) throws IOException;

    public static Reader nullReader() {
        return new Reader() { // from class: java.io.Reader.1
            private volatile boolean closed;

            private void ensureOpen() throws IOException {
                if (this.closed) {
                    throw new IOException("Stream closed");
                }
            }

            @Override // java.io.Reader
            public int read() throws IOException {
                ensureOpen();
                return -1;
            }

            @Override // java.io.Reader
            public int read(char[] cbuf, int off, int len) throws IOException {
                Objects.checkFromIndexSize(off, len, cbuf.length);
                ensureOpen();
                if (len == 0) {
                    return 0;
                }
                return -1;
            }

            @Override // java.io.Reader, java.lang.Readable
            public int read(CharBuffer target) throws IOException {
                Objects.requireNonNull(target);
                ensureOpen();
                if (target.hasRemaining()) {
                    return -1;
                }
                return 0;
            }

            @Override // java.io.Reader
            public boolean ready() throws IOException {
                ensureOpen();
                return false;
            }

            @Override // java.io.Reader
            public long skip(long n10) throws IOException {
                ensureOpen();
                return 0L;
            }

            @Override // java.io.Reader
            public long transferTo(Writer out) throws IOException {
                Objects.requireNonNull(out);
                ensureOpen();
                return 0L;
            }

            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.closed = true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Reader() {
        this.skipBuffer = null;
        this.lock = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Reader(Object lock) {
        this.skipBuffer = null;
        if (lock == null) {
            throw new NullPointerException();
        }
        this.lock = lock;
    }

    @Override // java.lang.Readable
    public int read(CharBuffer target) throws IOException {
        int len = target.remaining();
        char[] cbuf = new char[len];
        int n10 = read(cbuf, 0, len);
        if (n10 > 0) {
            target.put(cbuf, 0, n10);
        }
        return n10;
    }

    public int read() throws IOException {
        char[] cb2 = new char[1];
        if (read(cb2, 0, 1) == -1) {
            return -1;
        }
        return cb2[0];
    }

    public int read(char[] cbuf) throws IOException {
        return read(cbuf, 0, cbuf.length);
    }

    public long skip(long n10) throws IOException {
        long j10;
        int nc2;
        if (n10 < 0) {
            throw new IllegalArgumentException("skip value is negative");
        }
        int nn = (int) Math.min(n10, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        synchronized (this.lock) {
            char[] cArr = this.skipBuffer;
            if (cArr == null || cArr.length < nn) {
                this.skipBuffer = new char[nn];
            }
            long r10 = n10;
            while (r10 > 0 && (nc2 = read(this.skipBuffer, 0, (int) Math.min(r10, nn))) != -1) {
                r10 -= nc2;
            }
            j10 = n10 - r10;
        }
        return j10;
    }

    public boolean ready() throws IOException {
        return false;
    }

    public boolean markSupported() {
        return false;
    }

    public void mark(int readAheadLimit) throws IOException {
        throw new IOException("mark() not supported");
    }

    public void reset() throws IOException {
        throw new IOException("reset() not supported");
    }

    public long transferTo(Writer out) throws IOException {
        Objects.requireNonNull(out, "out");
        long transferred = 0;
        char[] buffer = new char[8192];
        while (true) {
            int nRead = read(buffer, 0, 8192);
            if (nRead >= 0) {
                out.write(buffer, 0, nRead);
                transferred += nRead;
            } else {
                return transferred;
            }
        }
    }
}
