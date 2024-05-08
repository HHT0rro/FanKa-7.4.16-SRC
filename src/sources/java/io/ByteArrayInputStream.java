package java.io;

import java.util.Arrays;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ByteArrayInputStream extends InputStream {
    protected byte[] buf;
    protected int count;
    protected int mark;
    protected int pos;

    public ByteArrayInputStream(byte[] buf) {
        this.mark = 0;
        this.buf = buf;
        this.pos = 0;
        this.count = buf.length;
    }

    public ByteArrayInputStream(byte[] buf, int offset, int length) {
        this.mark = 0;
        this.buf = buf;
        this.pos = offset;
        this.count = Math.min(offset + length, buf.length);
        this.mark = offset;
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        int i10;
        int i11 = this.pos;
        if (i11 < this.count) {
            byte[] bArr = this.buf;
            this.pos = i11 + 1;
            i10 = bArr[i11] & 255;
        } else {
            i10 = -1;
        }
        return i10;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] b4, int off, int len) {
        Objects.checkFromIndexSize(off, len, b4.length);
        int i10 = this.pos;
        int i11 = this.count;
        if (i10 >= i11) {
            return -1;
        }
        int avail = i11 - i10;
        if (len > avail) {
            len = avail;
        }
        if (len <= 0) {
            return 0;
        }
        System.arraycopy((Object) this.buf, i10, (Object) b4, off, len);
        this.pos += len;
        return len;
    }

    @Override // java.io.InputStream
    public synchronized byte[] readAllBytes() {
        byte[] result;
        result = Arrays.copyOfRange(this.buf, this.pos, this.count);
        this.pos = this.count;
        return result;
    }

    @Override // java.io.InputStream
    public int readNBytes(byte[] b4, int off, int len) {
        int n10 = read(b4, off, len);
        if (n10 == -1) {
            return 0;
        }
        return n10;
    }

    @Override // java.io.InputStream
    public synchronized long transferTo(OutputStream out) throws IOException {
        int len;
        int i10 = this.count;
        int i11 = this.pos;
        len = i10 - i11;
        out.write(this.buf, i11, len);
        this.pos = this.count;
        return len;
    }

    @Override // java.io.InputStream
    public synchronized long skip(long n10) {
        long k10;
        int i10 = this.count;
        int i11 = this.pos;
        k10 = i10 - i11;
        if (n10 < k10) {
            long j10 = 0;
            if (n10 >= 0) {
                j10 = n10;
            }
            k10 = j10;
        }
        this.pos = (int) (i11 + k10);
        return k10;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return this.count - this.pos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public void mark(int readAheadLimit) {
        this.mark = this.pos;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.pos = this.mark;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }
}
