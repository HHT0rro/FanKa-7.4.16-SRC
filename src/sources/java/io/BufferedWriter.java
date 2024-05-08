package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BufferedWriter extends Writer {
    private static int defaultCharBufferSize = 8192;

    /* renamed from: cb, reason: collision with root package name */
    private char[] f50350cb;
    private int nChars;
    private int nextChar;
    private Writer out;

    public BufferedWriter(Writer out) {
        this(out, defaultCharBufferSize);
    }

    public BufferedWriter(Writer out, int sz) {
        super(out);
        if (sz <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        this.out = out;
        this.f50350cb = new char[sz];
        this.nChars = sz;
        this.nextChar = 0;
    }

    private void ensureOpen() throws IOException {
        if (this.out == null) {
            throw new IOException("Stream closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void flushBuffer() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            int i10 = this.nextChar;
            if (i10 == 0) {
                return;
            }
            this.out.write(this.f50350cb, 0, i10);
            this.nextChar = 0;
        }
    }

    @Override // java.io.Writer
    public void write(int c4) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (this.nextChar >= this.nChars) {
                flushBuffer();
            }
            char[] cArr = this.f50350cb;
            int i10 = this.nextChar;
            this.nextChar = i10 + 1;
            cArr[i10] = (char) c4;
        }
    }

    private int min(int a10, int b4) {
        return a10 < b4 ? a10 : b4;
    }

    @Override // java.io.Writer
    public void write(char[] cbuf, int off, int len) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (off < 0 || off > cbuf.length || len < 0 || off + len > cbuf.length || off + len < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (len == 0) {
                return;
            }
            if (len >= this.nChars) {
                flushBuffer();
                this.out.write(cbuf, off, len);
                return;
            }
            int b4 = off;
            int t2 = off + len;
            while (b4 < t2) {
                int d10 = min(this.nChars - this.nextChar, t2 - b4);
                System.arraycopy((Object) cbuf, b4, (Object) this.f50350cb, this.nextChar, d10);
                b4 += d10;
                int i10 = this.nextChar + d10;
                this.nextChar = i10;
                if (i10 >= this.nChars) {
                    flushBuffer();
                }
            }
        }
    }

    @Override // java.io.Writer
    public void write(String s2, int off, int len) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            int b4 = off;
            int t2 = off + len;
            while (b4 < t2) {
                int d10 = min(this.nChars - this.nextChar, t2 - b4);
                s2.getChars(b4, b4 + d10, this.f50350cb, this.nextChar);
                b4 += d10;
                int i10 = this.nextChar + d10;
                this.nextChar = i10;
                if (i10 >= this.nChars) {
                    flushBuffer();
                }
            }
        }
    }

    public void newLine() throws IOException {
        write(System.lineSeparator());
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        synchronized (this.lock) {
            flushBuffer();
            this.out.flush();
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.lock) {
            Writer writer = this.out;
            if (writer == null) {
                return;
            }
            try {
                try {
                    flushBuffer();
                    if (writer != null) {
                        writer.close();
                    }
                } finally {
                }
            } finally {
                this.out = null;
                this.f50350cb = null;
            }
        }
    }
}
