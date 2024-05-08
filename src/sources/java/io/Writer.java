package java.io;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Writer implements Appendable, Closeable, Flushable {
    private static final int WRITE_BUFFER_SIZE = 1024;
    protected Object lock;
    private char[] writeBuffer;

    public abstract void close() throws IOException;

    public abstract void flush() throws IOException;

    public abstract void write(char[] cArr, int i10, int i11) throws IOException;

    public static Writer nullWriter() {
        return new Writer() { // from class: java.io.Writer.1
            private volatile boolean closed;

            private void ensureOpen() throws IOException {
                if (this.closed) {
                    throw new IOException("Stream closed");
                }
            }

            @Override // java.io.Writer, java.lang.Appendable
            public Writer append(char c4) throws IOException {
                ensureOpen();
                return this;
            }

            @Override // java.io.Writer, java.lang.Appendable
            public Writer append(CharSequence csq) throws IOException {
                ensureOpen();
                return this;
            }

            @Override // java.io.Writer, java.lang.Appendable
            public Writer append(CharSequence csq, int start, int end) throws IOException {
                ensureOpen();
                if (csq != null) {
                    Objects.checkFromToIndex(start, end, csq.length());
                }
                return this;
            }

            @Override // java.io.Writer
            public void write(int c4) throws IOException {
                ensureOpen();
            }

            @Override // java.io.Writer
            public void write(char[] cbuf, int off, int len) throws IOException {
                Objects.checkFromIndexSize(off, len, cbuf.length);
                ensureOpen();
            }

            @Override // java.io.Writer
            public void write(String str) throws IOException {
                Objects.requireNonNull(str);
                ensureOpen();
            }

            @Override // java.io.Writer
            public void write(String str, int off, int len) throws IOException {
                Objects.checkFromIndexSize(off, len, str.length());
                ensureOpen();
            }

            @Override // java.io.Writer, java.io.Flushable
            public void flush() throws IOException {
                ensureOpen();
            }

            @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.closed = true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Writer() {
        this.lock = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Writer(Object lock) {
        if (lock == null) {
            throw new NullPointerException();
        }
        this.lock = lock;
    }

    public void write(int c4) throws IOException {
        synchronized (this.lock) {
            if (this.writeBuffer == null) {
                this.writeBuffer = new char[1024];
            }
            char[] cArr = this.writeBuffer;
            cArr[0] = (char) c4;
            write(cArr, 0, 1);
        }
    }

    public void write(char[] cbuf) throws IOException {
        write(cbuf, 0, cbuf.length);
    }

    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    public void write(String str, int off, int len) throws IOException {
        char[] cbuf;
        synchronized (this.lock) {
            if (len <= 1024) {
                if (this.writeBuffer == null) {
                    this.writeBuffer = new char[1024];
                }
                cbuf = this.writeBuffer;
            } else {
                cbuf = new char[len];
            }
            str.getChars(off, off + len, cbuf, 0);
            write(cbuf, 0, len);
        }
    }

    @Override // java.lang.Appendable
    public Writer append(CharSequence csq) throws IOException {
        write(String.valueOf(csq));
        return this;
    }

    @Override // java.lang.Appendable
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        if (csq == null) {
            csq = "null";
        }
        return append(csq.subSequence(start, end));
    }

    @Override // java.lang.Appendable
    public Writer append(char c4) throws IOException {
        write(c4);
        return this;
    }
}
