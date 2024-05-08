package java.io;

import libcore.io.IoUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PipedReader extends Reader {
    private static final int DEFAULT_PIPE_SIZE = 1024;
    char[] buffer;
    boolean closedByReader;
    boolean closedByWriter;
    boolean connected;
    int in;
    int out;
    Thread readSide;
    Thread writeSide;

    public PipedReader(PipedWriter src) throws IOException {
        this(src, 1024);
    }

    public PipedReader(PipedWriter src, int pipeSize) throws IOException {
        this.closedByWriter = false;
        this.closedByReader = false;
        this.connected = false;
        this.in = -1;
        this.out = 0;
        initPipe(pipeSize);
        connect(src);
    }

    public PipedReader() {
        this.closedByWriter = false;
        this.closedByReader = false;
        this.connected = false;
        this.in = -1;
        this.out = 0;
        initPipe(1024);
    }

    public PipedReader(int pipeSize) {
        this.closedByWriter = false;
        this.closedByReader = false;
        this.connected = false;
        this.in = -1;
        this.out = 0;
        initPipe(pipeSize);
    }

    private void initPipe(int pipeSize) {
        if (pipeSize <= 0) {
            throw new IllegalArgumentException("Pipe size <= 0");
        }
        this.buffer = new char[pipeSize];
    }

    public void connect(PipedWriter src) throws IOException {
        src.connect(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void receive(int c4) throws IOException {
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
        this.writeSide = Thread.currentThread();
        while (true) {
            int i10 = this.in;
            if (i10 == this.out) {
                Thread thread2 = this.readSide;
                if (thread2 != null && !thread2.isAlive()) {
                    throw new IOException("Pipe broken");
                }
                notifyAll();
                try {
                    wait(1000L);
                } catch (InterruptedException e2) {
                    IoUtils.throwInterruptedIoException();
                }
            } else {
                if (i10 < 0) {
                    this.in = 0;
                    this.out = 0;
                }
                char[] cArr = this.buffer;
                int i11 = this.in;
                int i12 = i11 + 1;
                this.in = i12;
                cArr[i11] = (char) c4;
                if (i12 >= cArr.length) {
                    this.in = 0;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void receive(char[] c4, int off, int len) throws IOException {
        while (true) {
            len--;
            if (len >= 0) {
                int off2 = off + 1;
                receive(c4[off]);
                off = off2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void receivedLast() {
        this.closedByWriter = true;
        notifyAll();
    }

    @Override // java.io.Reader
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
                char[] cArr = this.buffer;
                int i11 = this.out;
                int i12 = i11 + 1;
                this.out = i12;
                char c4 = cArr[i11];
                if (i12 >= cArr.length) {
                    this.out = 0;
                }
                if (i10 == this.out) {
                    this.in = -1;
                }
                return c4;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0027, code lost:
    
        if (r11 > r10.length) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0029, code lost:
    
        if (r12 < 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002e, code lost:
    
        if ((r11 + r12) > r10.length) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0032, code lost:
    
        if ((r11 + r12) < 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0035, code lost:
    
        if (r12 != 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0038, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0039, code lost:
    
        r1 = read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x003e, code lost:
    
        if (r1 >= 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0041, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0043, code lost:
    
        r10[r11] = (char) r1;
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0046, code lost:
    
        r4 = r9.in;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0048, code lost:
    
        if (r4 < 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x004a, code lost:
    
        r12 = r12 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x004c, code lost:
    
        if (r12 <= 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004e, code lost:
    
        r6 = r9.buffer;
        r7 = r9.out;
        r8 = r7 + 1;
        r9.out = r8;
        r10[r11 + r3] = r6[r7];
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x005f, code lost:
    
        if (r8 < r6.length) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0061, code lost:
    
        r9.out = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0065, code lost:
    
        if (r4 != r9.out) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0067, code lost:
    
        r9.in = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x006b, code lost:
    
        return r3;
     */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int read(char[] r10, int r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.connected     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto L7a
            boolean r0 = r9.closedByReader     // Catch: java.lang.Throwable -> L82
            if (r0 != 0) goto L72
            java.lang.Thread r0 = r9.writeSide     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto L24
            boolean r0 = r0.isAlive()     // Catch: java.lang.Throwable -> L82
            if (r0 != 0) goto L24
            boolean r0 = r9.closedByWriter     // Catch: java.lang.Throwable -> L82
            if (r0 != 0) goto L24
            int r0 = r9.in     // Catch: java.lang.Throwable -> L82
            if (r0 < 0) goto L1c
            goto L24
        L1c:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L82
            java.lang.String r1 = "Write end dead"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L82
            throw r0     // Catch: java.lang.Throwable -> L82
        L24:
            if (r11 < 0) goto L6c
            int r0 = r10.length     // Catch: java.lang.Throwable -> L82
            if (r11 > r0) goto L6c
            if (r12 < 0) goto L6c
            int r0 = r11 + r12
            int r1 = r10.length     // Catch: java.lang.Throwable -> L82
            if (r0 > r1) goto L6c
            int r0 = r11 + r12
            if (r0 < 0) goto L6c
            r0 = 0
            if (r12 != 0) goto L39
            monitor-exit(r9)
            return r0
        L39:
            int r1 = r9.read()     // Catch: java.lang.Throwable -> L82
            r2 = -1
            if (r1 >= 0) goto L42
            monitor-exit(r9)
            return r2
        L42:
            char r3 = (char) r1
            r10[r11] = r3     // Catch: java.lang.Throwable -> L82
            r3 = 1
        L46:
            int r4 = r9.in     // Catch: java.lang.Throwable -> L82
            if (r4 < 0) goto L6a
            int r12 = r12 + (-1)
            if (r12 <= 0) goto L6a
            int r5 = r11 + r3
            char[] r6 = r9.buffer     // Catch: java.lang.Throwable -> L82
            int r7 = r9.out     // Catch: java.lang.Throwable -> L82
            int r8 = r7 + 1
            r9.out = r8     // Catch: java.lang.Throwable -> L82
            char r7 = r6[r7]     // Catch: java.lang.Throwable -> L82
            r10[r5] = r7     // Catch: java.lang.Throwable -> L82
            int r3 = r3 + 1
            int r5 = r6.length     // Catch: java.lang.Throwable -> L82
            if (r8 < r5) goto L63
            r9.out = r0     // Catch: java.lang.Throwable -> L82
        L63:
            int r5 = r9.out     // Catch: java.lang.Throwable -> L82
            if (r4 != r5) goto L46
            r9.in = r2     // Catch: java.lang.Throwable -> L82
            goto L46
        L6a:
            monitor-exit(r9)
            return r3
        L6c:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch: java.lang.Throwable -> L82
            r0.<init>()     // Catch: java.lang.Throwable -> L82
            throw r0     // Catch: java.lang.Throwable -> L82
        L72:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L82
            java.lang.String r1 = "Pipe closed"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L82
            throw r0     // Catch: java.lang.Throwable -> L82
        L7a:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L82
            java.lang.String r1 = "Pipe not connected"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L82
            throw r0     // Catch: java.lang.Throwable -> L82
        L82:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.PipedReader.read(char[], int, int):int");
    }

    @Override // java.io.Reader
    public synchronized boolean ready() throws IOException {
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
        return this.in >= 0;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in = -1;
        this.closedByReader = true;
    }
}
