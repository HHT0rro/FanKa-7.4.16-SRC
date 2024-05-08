package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StringWriter extends Writer {
    private StringBuffer buf;

    public StringWriter() {
        StringBuffer stringBuffer = new StringBuffer();
        this.buf = stringBuffer;
        this.lock = stringBuffer;
    }

    public StringWriter(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Negative buffer size");
        }
        StringBuffer stringBuffer = new StringBuffer(initialSize);
        this.buf = stringBuffer;
        this.lock = stringBuffer;
    }

    @Override // java.io.Writer
    public void write(int c4) {
        this.buf.append((char) c4);
    }

    @Override // java.io.Writer
    public void write(char[] cbuf, int off, int len) {
        if (off < 0 || off > cbuf.length || len < 0 || off + len > cbuf.length || off + len < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        this.buf.append(cbuf, off, len);
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.buf.append(str);
    }

    @Override // java.io.Writer
    public void write(String str, int off, int len) {
        this.buf.append((CharSequence) str, off, off + len);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public StringWriter append(CharSequence csq) {
        write(String.valueOf(csq));
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public StringWriter append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        return append(csq.subSequence(start, end));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public StringWriter append(char c4) {
        write(c4);
        return this;
    }

    public String toString() {
        return this.buf.toString();
    }

    public StringBuffer getBuffer() {
        return this.buf;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }
}
