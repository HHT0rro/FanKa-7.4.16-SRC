package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PipedOutputStream extends OutputStream {
    private PipedInputStream sink;

    public PipedOutputStream(PipedInputStream snk) throws IOException {
        connect(snk);
    }

    public PipedOutputStream() {
    }

    public synchronized void connect(PipedInputStream snk) throws IOException {
        try {
            if (snk == null) {
                throw new NullPointerException();
            }
            if (this.sink != null || snk.connected) {
                throw new IOException("Already connected");
            }
            this.sink = snk;
            snk.in = -1;
            snk.out = 0;
            snk.connected = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public void write(int b4) throws IOException {
        PipedInputStream pipedInputStream = this.sink;
        if (pipedInputStream == null) {
            throw new IOException("Pipe not connected");
        }
        pipedInputStream.receive(b4);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b4, int off, int len) throws IOException {
        PipedInputStream pipedInputStream = this.sink;
        if (pipedInputStream == null) {
            throw new IOException("Pipe not connected");
        }
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || off > b4.length || len < 0 || off + len > b4.length || off + len < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        pipedInputStream.receive(b4, off, len);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        PipedInputStream pipedInputStream = this.sink;
        if (pipedInputStream != null) {
            synchronized (pipedInputStream) {
                try {
                    this.sink.notifyAll();
                } finally {
                    th = th;
                    while (true) {
                        try {
                            break;
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                }
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        PipedInputStream pipedInputStream = this.sink;
        if (pipedInputStream != null) {
            pipedInputStream.receivedLast();
        }
    }
}
