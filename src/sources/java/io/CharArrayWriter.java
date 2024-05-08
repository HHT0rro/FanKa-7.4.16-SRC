package java.io;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CharArrayWriter extends Writer {
    protected char[] buf;
    protected int count;

    public CharArrayWriter() {
        this(32);
    }

    public CharArrayWriter(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Negative initial size: " + initialSize);
        }
        this.buf = new char[initialSize];
    }

    @Override // java.io.Writer
    public void write(int c4) {
        synchronized (this.lock) {
            int newcount = this.count + 1;
            char[] cArr = this.buf;
            if (newcount > cArr.length) {
                this.buf = Arrays.copyOf(cArr, Math.max(cArr.length << 1, newcount));
            }
            this.buf[this.count] = (char) c4;
            this.count = newcount;
        }
    }

    @Override // java.io.Writer
    public void write(char[] c4, int off, int len) {
        if (off < 0 || off > c4.length || len < 0 || off + len > c4.length || off + len < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        synchronized (this.lock) {
            int newcount = this.count + len;
            char[] cArr = this.buf;
            if (newcount > cArr.length) {
                this.buf = Arrays.copyOf(cArr, Math.max(cArr.length << 1, newcount));
            }
            System.arraycopy((Object) c4, off, (Object) this.buf, this.count, len);
            this.count = newcount;
        }
    }

    @Override // java.io.Writer
    public void write(String str, int off, int len) {
        synchronized (this.lock) {
            int newcount = this.count + len;
            char[] cArr = this.buf;
            if (newcount > cArr.length) {
                this.buf = Arrays.copyOf(cArr, Math.max(cArr.length << 1, newcount));
            }
            str.getChars(off, off + len, this.buf, this.count);
            this.count = newcount;
        }
    }

    public void writeTo(Writer out) throws IOException {
        synchronized (this.lock) {
            out.write(this.buf, 0, this.count);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public CharArrayWriter append(CharSequence csq) {
        String s2 = String.valueOf(csq);
        write(s2, 0, s2.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public CharArrayWriter append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        return append(csq.subSequence(start, end));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public CharArrayWriter append(char c4) {
        write(c4);
        return this;
    }

    public void reset() {
        this.count = 0;
    }

    public char[] toCharArray() {
        char[] copyOf;
        synchronized (this.lock) {
            copyOf = Arrays.copyOf(this.buf, this.count);
        }
        return copyOf;
    }

    public int size() {
        return this.count;
    }

    public String toString() {
        String str;
        synchronized (this.lock) {
            str = new String(this.buf, 0, this.count);
        }
        return str;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
