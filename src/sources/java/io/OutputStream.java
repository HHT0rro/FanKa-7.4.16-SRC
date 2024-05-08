package java.io;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class OutputStream implements Closeable, Flushable {
    public abstract void write(int i10) throws IOException;

    public static OutputStream nullOutputStream() {
        return new OutputStream() { // from class: java.io.OutputStream.1
            private volatile boolean closed;

            private void ensureOpen() throws IOException {
                if (this.closed) {
                    throw new IOException("Stream closed");
                }
            }

            @Override // java.io.OutputStream
            public void write(int b4) throws IOException {
                ensureOpen();
            }

            @Override // java.io.OutputStream
            public void write(byte[] b4, int off, int len) throws IOException {
                Objects.checkFromIndexSize(off, len, b4.length);
                ensureOpen();
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.closed = true;
            }
        };
    }

    public void write(byte[] b4) throws IOException {
        write(b4, 0, b4.length);
    }

    public void write(byte[] b4, int off, int len) throws IOException {
        Objects.checkFromIndexSize(off, len, b4.length);
        for (int i10 = 0; i10 < len; i10++) {
            write(b4[off + i10]);
        }
    }

    public void flush() throws IOException {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }
}
