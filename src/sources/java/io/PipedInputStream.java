package java.io;

import libcore.io.IoUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PipedInputStream extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_PIPE_SIZE = 1024;
    protected static final int PIPE_SIZE = 1024;
    protected byte[] buffer;
    volatile boolean closedByReader;
    boolean closedByWriter;
    boolean connected;
    protected int in;
    protected int out;
    Thread readSide;
    Thread writeSide;

    public PipedInputStream(PipedOutputStream src) throws IOException {
        this(src, 1024);
    }

    public PipedInputStream(PipedOutputStream src, int pipeSize) throws IOException {
        this.in = -1;
        this.out = 0;
        initPipe(pipeSize);
        connect(src);
    }

    public PipedInputStream() {
        this.in = -1;
        this.out = 0;
        initPipe(1024);
    }

    public PipedInputStream(int pipeSize) {
        this.in = -1;
        this.out = 0;
        initPipe(pipeSize);
    }

    private void initPipe(int pipeSize) {
        if (pipeSize <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[pipeSize];
    }

    public void connect(PipedOutputStream src) throws IOException {
        src.connect(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void receive(int b4) throws IOException {
        checkStateForReceive();
        this.writeSide = Thread.currentThread();
        if (this.in == this.out) {
            awaitSpace();
        }
        if (this.in < 0) {
            this.in = 0;
            this.out = 0;
        }
        byte[] bArr = this.buffer;
        int i10 = this.in;
        int i11 = i10 + 1;
        this.in = i11;
        bArr[i10] = (byte) (b4 & 255);
        if (i11 >= bArr.length) {
            this.in = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void receive(byte[] b4, int off, int len) throws IOException {
        checkStateForReceive();
        this.writeSide = Thread.currentThread();
        int bytesToTransfer = len;
        while (bytesToTransfer > 0) {
            if (this.in == this.out) {
                awaitSpace();
            }
            int nextTransferAmount = 0;
            int i10 = this.out;
            int i11 = this.in;
            if (i10 < i11) {
                nextTransferAmount = this.buffer.length - i11;
            } else if (i11 < i10) {
                if (i11 == -1) {
                    this.out = 0;
                    this.in = 0;
                    nextTransferAmount = this.buffer.length + 0;
                } else {
                    nextTransferAmount = i10 - i11;
                }
            }
            if (nextTransferAmount > bytesToTransfer) {
                nextTransferAmount = bytesToTransfer;
            }
            System.arraycopy((Object) b4, off, (Object) this.buffer, this.in, nextTransferAmount);
            bytesToTransfer -= nextTransferAmount;
            off += nextTransferAmount;
            int i12 = this.in + nextTransferAmount;
            this.in = i12;
            if (i12 >= this.buffer.length) {
                this.in = 0;
            }
        }
    }

    private void checkStateForReceive() throws IOException {
        if (!this.connected) {
            throw new IOException("Pipe not connected");
        }
        if (this.closedByWriter || this.closedByReader) {
            throw new IOException("Pipe closed");
        }
        Thread thread = this.readSide;
        if (thread != null && !thread.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void awaitSpace() throws IOException {
        while (this.in == this.out) {
            checkStateForReceive();
            notifyAll();
            try {
                wait(1000L);
            } catch (InterruptedException e2) {
                IoUtils.throwInterruptedIoException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void receivedLast() {
        this.closedByWriter = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (!this.connected) {
            throw new IOException("Pipe not connected");
        }
        if (this.closedByReader) {
            throw new IOException("Pipe closed");
        }
        Thread thread = this.writeSide;
        if (thread != null && !thread.isAlive() && !this.closedByWriter && this.in < 0) {
            throw new IOException("Write end dead");
        }
        this.readSide = Thread.currentThread();
        int trials = 2;
        while (true) {
            int i10 = this.in;
            if (i10 < 0) {
                if (this.closedByWriter) {
                    return -1;
                }
                Thread thread2 = this.writeSide;
                if (thread2 != null && !thread2.isAlive() && trials - 1 < 0) {
                    throw new IOException("Pipe broken");
                }
                notifyAll();
                try {
                    wait(1000L);
                } catch (InterruptedException e2) {
                    IoUtils.throwInterruptedIoException();
                }
            } else {
                byte[] bArr = this.buffer;
                int i11 = this.out;
                int i12 = i11 + 1;
                this.out = i12;
                int ret = bArr[i11] & 255;
                if (i12 >= bArr.length) {
                    this.out = 0;
                }
                if (i10 == this.out) {
                    this.in = -1;
                }
                return ret;
            }
        }
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] b4, int off, int len) throws IOException {
        int available;
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || len > b4.length - off) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return 0;
        }
        int c4 = read();
        if (c4 < 0) {
            return -1;
        }
        b4[off] = (byte) c4;
        int rlen = 1;
        while (true) {
            int i10 = this.in;
            if (i10 < 0 || len <= 1) {
                break;
            }
            int i11 = this.out;
            if (i10 > i11) {
                available = Math.min(this.buffer.length - i11, i10 - i11);
            } else {
                available = this.buffer.length - i11;
            }
            if (available > len - 1) {
                available = len - 1;
            }
            System.arraycopy((Object) this.buffer, this.out, (Object) b4, off + rlen, available);
            int i12 = this.out + available;
            this.out = i12;
            rlen += available;
            len -= available;
            if (i12 >= this.buffer.length) {
                this.out = 0;
            }
            if (this.in == this.out) {
                this.in = -1;
            }
        }
        return rlen;
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        int i10 = this.in;
        if (i10 < 0) {
            return 0;
        }
        int i11 = this.out;
        if (i10 == i11) {
            return this.buffer.length;
        }
        if (i10 > i11) {
            return i10 - i11;
        }
        return (i10 + this.buffer.length) - i11;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closedByReader = true;
        synchronized (this) {
            this.in = -1;
        }
    }
}
