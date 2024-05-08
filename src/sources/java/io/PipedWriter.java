package java.io;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PipedWriter extends Writer {
    private boolean closed = false;
    private PipedReader sink;

    public PipedWriter(PipedReader snk) throws IOException {
        connect(snk);
    }

    public PipedWriter() {
    }

    public synchronized void connect(PipedReader snk) throws IOException {
        try {
            if (snk == null) {
                throw new NullPointerException();
            }
            if (this.sink != null || snk.connected) {
                throw new IOException("Already connected");
            }
            if (snk.closedByReader || this.closed) {
                throw new IOException("Pipe closed");
            }
            this.sink = snk;
            snk.in = -1;
            snk.out = 0;
            snk.connected = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Writer
    public void write(int c4) throws IOException {
        PipedReader pipedReader = this.sink;
        if (pipedReader == null) {
            throw new IOException("Pipe not connected");
        }
        pipedReader.receive(c4);
    }

    @Override // java.io.Writer
    public void write(char[] cbuf, int off, int len) throws IOException {
        PipedReader pipedReader = this.sink;
        if (pipedReader == null) {
            throw new IOException("Pipe not connected");
        }
        if ((off | len | (off + len) | (cbuf.length - (off + len))) < 0) {
            throw new IndexOutOfBoundsException();
        }
        pipedReader.receive(cbuf, off, len);
    }

    @Override // java.io.Writer, java.io.Flushable
    public synchronized void flush() throws IOException {
        PipedReader pipedReader = this.sink;
        if (pipedReader != null) {
            if (pipedReader.closedByReader || this.closed) {
                throw new IOException("Pipe closed");
            }
            synchronized (this.sink) {
                try {
                    this.sink.notifyAll();
                } catch (Throwable th) {
                    th = th;
                    while (true) {
                        try {
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    throw th;
                }
            }
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        PipedReader pipedReader = this.sink;
        if (pipedReader != null) {
            pipedReader.receivedLast();
        }
    }
}
