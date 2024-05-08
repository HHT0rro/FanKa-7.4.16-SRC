package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FilterOutputStream extends OutputStream {
    private final Object closeLock = new Object();
    private volatile boolean closed;
    protected OutputStream out;

    public FilterOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override // java.io.OutputStream
    public void write(int b4) throws IOException {
        this.out.write(b4);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b4) throws IOException {
        write(b4, 0, b4.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b4, int off, int len) throws IOException {
        if ((off | len | (b4.length - (len + off)) | (off + len)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i10 = 0; i10 < len; i10++) {
            write(b4[off + i10]);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        synchronized (this.closeLock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Throwable flushException = null;
            try {
                flush();
                if (0 == 0) {
                    this.out.close();
                    return;
                }
                try {
                    this.out.close();
                } catch (Throwable closeException) {
                    if ((flushException instanceof ThreadDeath) && !(closeException instanceof ThreadDeath)) {
                        flushException.addSuppressed(closeException);
                        throw ((ThreadDeath) null);
                    }
                    if (null != closeException) {
                        closeException.addSuppressed(null);
                    }
                    throw closeException;
                }
            } catch (Throwable e2) {
                try {
                    throw e2;
                } catch (Throwable e10) {
                    try {
                        this.out.close();
                        throw e10;
                    } catch (Throwable closeException2) {
                        if ((e2 instanceof ThreadDeath) && !(closeException2 instanceof ThreadDeath)) {
                            e2.addSuppressed(closeException2);
                            throw ((ThreadDeath) e2);
                        }
                        if (e2 != closeException2) {
                            closeException2.addSuppressed(e2);
                        }
                        throw closeException2;
                    }
                }
            }
        }
    }
}
