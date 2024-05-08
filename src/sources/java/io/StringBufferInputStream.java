package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StringBufferInputStream extends InputStream {
    protected String buffer;
    protected int count;
    protected int pos;

    public StringBufferInputStream(String s2) {
        this.buffer = s2;
        this.count = s2.length();
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        int i10;
        int i11 = this.pos;
        if (i11 < this.count) {
            String str = this.buffer;
            this.pos = i11 + 1;
            i10 = str.charAt(i11) & 255;
        } else {
            i10 = -1;
        }
        return i10;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] b4, int off, int len) {
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || off > b4.length || len < 0 || off + len > b4.length || off + len < 0) {
            throw new IndexOutOfBoundsException();
        }
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
        this.buffer.getBytes(i10, i10 + len, b4, off);
        this.pos += len;
        return len;
    }

    @Override // java.io.InputStream
    public synchronized long skip(long n10) {
        if (n10 < 0) {
            return 0L;
        }
        int i10 = this.count;
        int i11 = this.pos;
        if (n10 > i10 - i11) {
            n10 = i10 - i11;
        }
        this.pos = (int) (i11 + n10);
        return n10;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return this.count - this.pos;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.pos = 0;
    }
}
