package java.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jdk.internal.util.ArraysSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BufferedInputStream extends FilterInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 16384;
    private static final AtomicReferenceFieldUpdater<BufferedInputStream, byte[]> bufUpdater = AtomicReferenceFieldUpdater.newUpdater(BufferedInputStream.class, byte[].class, "buf");
    protected volatile byte[] buf;
    protected int count;
    protected int marklimit;
    protected int markpos;
    protected int pos;

    private InputStream getInIfOpen() throws IOException {
        InputStream input = this.in;
        if (input == null) {
            throw new IOException("Stream closed");
        }
        return input;
    }

    private byte[] getBufIfOpen() throws IOException {
        byte[] buffer = this.buf;
        if (buffer == null) {
            throw new IOException("Stream closed");
        }
        return buffer;
    }

    public BufferedInputStream(InputStream in) {
        this(in, 16384);
    }

    public BufferedInputStream(InputStream in, int size) {
        super(in);
        this.markpos = -1;
        if (size <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        this.buf = new byte[size];
    }

    private void fill() throws IOException {
        byte[] buffer = getBufIfOpen();
        int i10 = this.markpos;
        if (i10 < 0) {
            this.pos = 0;
        } else {
            int i11 = this.pos;
            if (i11 >= buffer.length) {
                if (i10 > 0) {
                    int sz = i11 - i10;
                    System.arraycopy((Object) buffer, i10, (Object) buffer, 0, sz);
                    this.pos = sz;
                    this.markpos = 0;
                } else if (buffer.length >= this.marklimit) {
                    this.markpos = -1;
                    this.pos = 0;
                } else {
                    int nsz = ArraysSupport.newLength(i11, 1, i11);
                    if (nsz > this.marklimit) {
                        nsz = this.marklimit;
                    }
                    byte[] nbuf = new byte[nsz];
                    System.arraycopy((Object) buffer, 0, (Object) nbuf, 0, this.pos);
                    if (!bufUpdater.compareAndSet(this, buffer, nbuf)) {
                        throw new IOException("Stream closed");
                    }
                    buffer = nbuf;
                }
            }
        }
        this.count = this.pos;
        InputStream inIfOpen = getInIfOpen();
        int i12 = this.pos;
        int n10 = inIfOpen.read(buffer, i12, buffer.length - i12);
        if (n10 > 0) {
            this.count = this.pos + n10;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.pos >= this.count) {
            fill();
            if (this.pos >= this.count) {
                return -1;
            }
        }
        byte[] bufIfOpen = getBufIfOpen();
        int i10 = this.pos;
        this.pos = i10 + 1;
        return bufIfOpen[i10] & 255;
    }

    private int read1(byte[] b4, int off, int len) throws IOException {
        int avail = this.count - this.pos;
        if (avail <= 0) {
            if (len >= getBufIfOpen().length && this.markpos < 0) {
                return getInIfOpen().read(b4, off, len);
            }
            fill();
            avail = this.count - this.pos;
            if (avail <= 0) {
                return -1;
            }
        }
        int cnt = avail < len ? avail : len;
        System.arraycopy((Object) getBufIfOpen(), this.pos, (Object) b4, off, cnt);
        this.pos += cnt;
        return cnt;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] b4, int off, int len) throws IOException {
        getBufIfOpen();
        if ((off | len | (off + len) | (b4.length - (off + len))) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return 0;
        }
        int n10 = 0;
        while (true) {
            int nread = read1(b4, off + n10, len - n10);
            if (nread <= 0) {
                return n10 == 0 ? nread : n10;
            }
            n10 += nread;
            if (n10 >= len) {
                return n10;
            }
            InputStream input = this.in;
            if (input != null && input.available() <= 0) {
                return n10;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long n10) throws IOException {
        getBufIfOpen();
        if (n10 <= 0) {
            return 0L;
        }
        long avail = this.count - this.pos;
        if (avail <= 0) {
            if (this.markpos < 0) {
                return getInIfOpen().skip(n10);
            }
            fill();
            avail = this.count - this.pos;
            if (avail <= 0) {
                return 0L;
            }
        }
        long skipped = avail < n10 ? avail : n10;
        this.pos = (int) (this.pos + skipped);
        return skipped;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        int i10;
        int n10 = this.count - this.pos;
        int avail = getInIfOpen().available();
        i10 = Integer.MAX_VALUE;
        if (n10 <= Integer.MAX_VALUE - avail) {
            i10 = n10 + avail;
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int readlimit) {
        this.marklimit = readlimit;
        this.markpos = this.pos;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        getBufIfOpen();
        int i10 = this.markpos;
        if (i10 < 0) {
            throw new IOException("Resetting to invalid mark");
        }
        this.pos = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        byte[] buffer;
        do {
            buffer = this.buf;
            if (buffer == null) {
                return;
            }
        } while (!bufUpdater.compareAndSet(this, buffer, null));
        InputStream input = this.in;
        this.in = null;
        if (input != null) {
            input.close();
        }
    }
}
