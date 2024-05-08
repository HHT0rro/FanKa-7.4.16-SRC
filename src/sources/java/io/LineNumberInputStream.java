package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LineNumberInputStream extends FilterInputStream {
    int lineNumber;
    int markLineNumber;
    int markPushBack;
    int pushBack;

    public LineNumberInputStream(InputStream in) {
        super(in);
        this.pushBack = -1;
        this.markPushBack = -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int c4 = this.pushBack;
        if (c4 != -1) {
            this.pushBack = -1;
        } else {
            c4 = this.in.read();
        }
        switch (c4) {
            case 10:
                break;
            case 13:
                int read = this.in.read();
                this.pushBack = read;
                if (read == 10) {
                    this.pushBack = -1;
                    break;
                }
                break;
            default:
                return c4;
        }
        this.lineNumber++;
        return 10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b4, int off, int len) throws IOException {
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || off > b4.length || len < 0 || off + len > b4.length || off + len < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return 0;
        }
        int c4 = read();
        if (c4 == -1) {
            return -1;
        }
        b4[off] = (byte) c4;
        int i10 = 1;
        while (i10 < len) {
            try {
                int c10 = read();
                if (c10 == -1) {
                    break;
                }
                if (b4 != null) {
                    b4[off + i10] = (byte) c10;
                }
                i10++;
            } catch (IOException e2) {
            }
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long n10) throws IOException {
        int nr;
        long remaining = n10;
        if (n10 <= 0) {
            return 0L;
        }
        byte[] data = new byte[2048];
        while (remaining > 0 && (nr = read(data, 0, (int) Math.min(2048, remaining))) >= 0) {
            remaining -= nr;
        }
        return n10 - remaining;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.pushBack == -1 ? super.available() / 2 : (super.available() / 2) + 1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int readlimit) {
        this.markLineNumber = this.lineNumber;
        this.markPushBack = this.pushBack;
        this.in.mark(readlimit);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        this.lineNumber = this.markLineNumber;
        this.pushBack = this.markPushBack;
        this.in.reset();
    }
}
