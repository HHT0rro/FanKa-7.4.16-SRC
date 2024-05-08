package java.io;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BufferedReader extends Reader {
    private static final int INVALIDATED = -2;
    private static final int UNMARKED = -1;
    private static int defaultCharBufferSize = 8192;
    private static int defaultExpectedLineLength = 80;

    /* renamed from: cb, reason: collision with root package name */
    private char[] f50349cb;
    private Reader in;
    private int markedChar;
    private boolean markedSkipLF;
    private int nChars;
    private int nextChar;
    private int readAheadLimit;
    private boolean skipLF;

    public BufferedReader(Reader in, int sz) {
        super(in);
        this.markedChar = -1;
        this.readAheadLimit = 0;
        this.skipLF = false;
        this.markedSkipLF = false;
        if (sz <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        this.in = in;
        this.f50349cb = new char[sz];
        this.nChars = 0;
        this.nextChar = 0;
    }

    public BufferedReader(Reader in) {
        this(in, defaultCharBufferSize);
    }

    private void ensureOpen() throws IOException {
        if (this.in == null) {
            throw new IOException("Stream closed");
        }
    }

    private void fill() throws IOException {
        int dst;
        int n10;
        int i10 = this.markedChar;
        if (i10 <= -1) {
            dst = 0;
        } else {
            int delta = this.nextChar - i10;
            int i11 = this.readAheadLimit;
            if (delta >= i11) {
                this.markedChar = -2;
                this.readAheadLimit = 0;
                dst = 0;
            } else {
                char[] cArr = this.f50349cb;
                if (i11 <= cArr.length) {
                    System.arraycopy((Object) cArr, i10, (Object) cArr, 0, delta);
                    this.markedChar = 0;
                    dst = delta;
                } else {
                    int nlength = cArr.length * 2;
                    if (nlength > i11) {
                        nlength = this.readAheadLimit;
                    }
                    char[] ncb = new char[nlength];
                    System.arraycopy((Object) cArr, i10, (Object) ncb, 0, delta);
                    this.f50349cb = ncb;
                    this.markedChar = 0;
                    dst = delta;
                }
                this.nChars = delta;
                this.nextChar = delta;
            }
        }
        do {
            Reader reader = this.in;
            char[] cArr2 = this.f50349cb;
            n10 = reader.read(cArr2, dst, cArr2.length - dst);
        } while (n10 == 0);
        if (n10 > 0) {
            this.nChars = dst + n10;
            this.nextChar = dst;
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            while (true) {
                if (this.nextChar >= this.nChars) {
                    fill();
                    if (this.nextChar >= this.nChars) {
                        return -1;
                    }
                }
                if (!this.skipLF) {
                    break;
                }
                this.skipLF = false;
                char[] cArr = this.f50349cb;
                int i10 = this.nextChar;
                if (cArr[i10] != '\n') {
                    break;
                }
                this.nextChar = i10 + 1;
            }
            char[] cArr2 = this.f50349cb;
            int i11 = this.nextChar;
            this.nextChar = i11 + 1;
            return cArr2[i11];
        }
    }

    private int read1(char[] cbuf, int off, int len) throws IOException {
        if (this.nextChar >= this.nChars) {
            if (len >= this.f50349cb.length && this.markedChar <= -1 && !this.skipLF) {
                return this.in.read(cbuf, off, len);
            }
            fill();
        }
        int i10 = this.nextChar;
        int i11 = this.nChars;
        if (i10 >= i11) {
            return -1;
        }
        if (this.skipLF) {
            this.skipLF = false;
            if (this.f50349cb[i10] == '\n') {
                int i12 = i10 + 1;
                this.nextChar = i12;
                if (i12 >= i11) {
                    fill();
                }
                if (this.nextChar >= this.nChars) {
                    return -1;
                }
            }
        }
        int n10 = Math.min(len, this.nChars - this.nextChar);
        System.arraycopy((Object) this.f50349cb, this.nextChar, (Object) cbuf, off, n10);
        this.nextChar += n10;
        return n10;
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int off, int len) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (off < 0 || off > cbuf.length || len < 0 || off + len > cbuf.length || off + len < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (len == 0) {
                return 0;
            }
            int n10 = read1(cbuf, off, len);
            if (n10 <= 0) {
                return n10;
            }
            while (n10 < len && this.in.ready()) {
                int n12 = read1(cbuf, off + n10, len - n10);
                if (n12 <= 0) {
                    break;
                }
                n10 += n12;
            }
            return n10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0019 A[Catch: all -> 0x0099, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000b, B:11:0x0013, B:13:0x0019, B:14:0x001c, B:52:0x0024, B:54:0x002a, B:55:0x002e, B:57:0x0030, B:18:0x0039, B:20:0x003f, B:21:0x0043, B:22:0x0048, B:24:0x004e, B:27:0x0058, B:31:0x005d, B:40:0x0065, B:41:0x007a, B:43:0x0081, B:44:0x0083, B:47:0x006f, B:34:0x0087, B:36:0x008f), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0022 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String readLine(boolean r13) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            java.lang.Object r1 = r12.lock
            monitor-enter(r1)
            r12.ensureOpen()     // Catch: java.lang.Throwable -> L99
            r2 = 0
            r3 = 1
            if (r13 != 0) goto L12
            boolean r4 = r12.skipLF     // Catch: java.lang.Throwable -> L99
            if (r4 == 0) goto L10
            goto L12
        L10:
            r4 = r2
            goto L13
        L12:
            r4 = r3
        L13:
            int r5 = r12.nextChar     // Catch: java.lang.Throwable -> L99
            int r6 = r12.nChars     // Catch: java.lang.Throwable -> L99
            if (r5 < r6) goto L1c
            r12.fill()     // Catch: java.lang.Throwable -> L99
        L1c:
            int r5 = r12.nextChar     // Catch: java.lang.Throwable -> L99
            int r6 = r12.nChars     // Catch: java.lang.Throwable -> L99
            if (r5 < r6) goto L33
            if (r0 == 0) goto L30
            int r2 = r0.length()     // Catch: java.lang.Throwable -> L99
            if (r2 <= 0) goto L30
            java.lang.String r2 = r0.toString()     // Catch: java.lang.Throwable -> L99
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L99
            return r2
        L30:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L99
            r1 = 0
            return r1
        L33:
            r6 = 0
            r7 = 0
            r8 = 10
            if (r4 == 0) goto L43
            char[] r9 = r12.f50349cb     // Catch: java.lang.Throwable -> L99
            char r9 = r9[r5]     // Catch: java.lang.Throwable -> L99
            if (r9 != r8) goto L43
            int r5 = r5 + 1
            r12.nextChar = r5     // Catch: java.lang.Throwable -> L99
        L43:
            r12.skipLF = r2     // Catch: java.lang.Throwable -> L99
            r4 = 0
            int r5 = r12.nextChar     // Catch: java.lang.Throwable -> L99
        L48:
            int r9 = r12.nChars     // Catch: java.lang.Throwable -> L99
            r10 = 13
            if (r5 >= r9) goto L5d
            char[] r9 = r12.f50349cb     // Catch: java.lang.Throwable -> L99
            char r9 = r9[r5]     // Catch: java.lang.Throwable -> L99
            r7 = r9
            if (r7 == r8) goto L5b
            if (r7 != r10) goto L58
            goto L5b
        L58:
            int r5 = r5 + 1
            goto L48
        L5b:
            r6 = 1
        L5d:
            int r8 = r12.nextChar     // Catch: java.lang.Throwable -> L99
            r12.nextChar = r5     // Catch: java.lang.Throwable -> L99
            if (r6 == 0) goto L85
            if (r0 != 0) goto L6f
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L99
            char[] r9 = r12.f50349cb     // Catch: java.lang.Throwable -> L99
            int r11 = r5 - r8
            r2.<init>(r9, r8, r11)     // Catch: java.lang.Throwable -> L99
            goto L7a
        L6f:
            char[] r2 = r12.f50349cb     // Catch: java.lang.Throwable -> L99
            int r9 = r5 - r8
            r0.append(r2, r8, r9)     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = r0.toString()     // Catch: java.lang.Throwable -> L99
        L7a:
            int r9 = r12.nextChar     // Catch: java.lang.Throwable -> L99
            int r9 = r9 + r3
            r12.nextChar = r9     // Catch: java.lang.Throwable -> L99
            if (r7 != r10) goto L83
            r12.skipLF = r3     // Catch: java.lang.Throwable -> L99
        L83:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L99
            return r2
        L85:
            if (r0 != 0) goto L8f
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            int r10 = java.io.BufferedReader.defaultExpectedLineLength     // Catch: java.lang.Throwable -> L99
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L99
            r0 = r9
        L8f:
            char[] r9 = r12.f50349cb     // Catch: java.lang.Throwable -> L99
            int r10 = r5 - r8
            r0.append(r9, r8, r10)     // Catch: java.lang.Throwable -> L99
            goto L13
        L99:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L99
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.io.BufferedReader.readLine(boolean):java.lang.String");
    }

    public String readLine() throws IOException {
        return readLine(false);
    }

    @Override // java.io.Reader
    public long skip(long n10) throws IOException {
        long j10;
        if (n10 < 0) {
            throw new IllegalArgumentException("skip value is negative");
        }
        synchronized (this.lock) {
            ensureOpen();
            long r10 = n10;
            while (true) {
                if (r10 > 0) {
                    if (this.nextChar >= this.nChars) {
                        fill();
                    }
                    int i10 = this.nextChar;
                    int i11 = this.nChars;
                    if (i10 >= i11) {
                        break;
                    }
                    if (this.skipLF) {
                        this.skipLF = false;
                        if (this.f50349cb[i10] == '\n') {
                            this.nextChar = i10 + 1;
                        }
                    }
                    int i12 = this.nextChar;
                    long d10 = i11 - i12;
                    if (r10 <= d10) {
                        this.nextChar = (int) (i12 + r10);
                        r10 = 0;
                        break;
                    }
                    r10 -= d10;
                    this.nextChar = i11;
                } else {
                    break;
                }
            }
            j10 = n10 - r10;
        }
        return j10;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        boolean z10;
        synchronized (this.lock) {
            ensureOpen();
            if (this.skipLF) {
                if (this.nextChar >= this.nChars && this.in.ready()) {
                    fill();
                }
                int i10 = this.nextChar;
                if (i10 < this.nChars) {
                    if (this.f50349cb[i10] == '\n') {
                        this.nextChar = i10 + 1;
                    }
                    this.skipLF = false;
                }
            }
            z10 = this.nextChar < this.nChars || this.in.ready();
        }
        return z10;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public void mark(int readAheadLimit) throws IOException {
        if (readAheadLimit < 0) {
            throw new IllegalArgumentException("Read-ahead limit < 0");
        }
        synchronized (this.lock) {
            ensureOpen();
            this.readAheadLimit = readAheadLimit;
            this.markedChar = this.nextChar;
            this.markedSkipLF = this.skipLF;
        }
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        String str;
        synchronized (this.lock) {
            ensureOpen();
            int i10 = this.markedChar;
            if (i10 < 0) {
                if (i10 == -2) {
                    str = "Mark invalid";
                } else {
                    str = "Stream not marked";
                }
                throw new IOException(str);
            }
            this.nextChar = i10;
            this.skipLF = this.markedSkipLF;
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.lock) {
            Reader reader = this.in;
            if (reader == null) {
                return;
            }
            try {
                reader.close();
            } finally {
                this.in = null;
                this.f50349cb = null;
            }
        }
    }

    public Stream<String> lines() {
        Iterator<String> iter = new Iterator<String>() { // from class: java.io.BufferedReader.1
            String nextLine = null;

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextLine != null) {
                    return true;
                }
                try {
                    String readLine = BufferedReader.this.readLine();
                    this.nextLine = readLine;
                    return readLine != null;
                } catch (IOException e2) {
                    throw new UncheckedIOException(e2);
                }
            }

            @Override // java.util.Iterator
            public String next() {
                if (this.nextLine != null || hasNext()) {
                    String line = this.nextLine;
                    this.nextLine = null;
                    return line;
                }
                throw new NoSuchElementException();
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iter, 272), false);
    }
}
