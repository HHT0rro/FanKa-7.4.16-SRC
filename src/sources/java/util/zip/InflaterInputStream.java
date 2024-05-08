package java.util.zip;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class InflaterInputStream extends FilterInputStream {

    /* renamed from: b, reason: collision with root package name */
    private byte[] f50535b;
    protected byte[] buf;

    @Deprecated
    protected boolean closed;
    protected Inflater inf;
    protected int len;
    private boolean reachEOF;
    private byte[] singleByteBuf;

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    public InflaterInputStream(InputStream in, Inflater inf, int size) {
        super(in);
        this.closed = false;
        this.reachEOF = false;
        this.singleByteBuf = new byte[1];
        this.f50535b = new byte[512];
        if (in == null || inf == null) {
            throw new NullPointerException();
        }
        if (size <= 0) {
            throw new IllegalArgumentException("buffer size <= 0");
        }
        this.inf = inf;
        this.buf = new byte[size];
    }

    public InflaterInputStream(InputStream in, Inflater inf) {
        this(in, inf, 512);
    }

    public InflaterInputStream(InputStream in) {
        this(in, new Inflater());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        ensureOpen();
        if (read(this.singleByteBuf, 0, 1) == -1) {
            return -1;
        }
        return Byte.toUnsignedInt(this.singleByteBuf[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
    
        r4.reachEOF = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003a, code lost:
    
        return -1;
     */
    @Override // java.io.FilterInputStream, java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r5, int r6, int r7) throws java.io.IOException {
        /*
            r4 = this;
            r4.ensureOpen()
            if (r5 == 0) goto L54
            if (r6 < 0) goto L4e
            if (r7 < 0) goto L4e
            int r0 = r5.length
            int r0 = r0 - r6
            if (r7 > r0) goto L4e
            if (r7 != 0) goto L11
            r0 = 0
            return r0
        L11:
            java.util.zip.Inflater r0 = r4.inf     // Catch: java.util.zip.DataFormatException -> L3d
            int r0 = r0.inflate(r5, r6, r7)     // Catch: java.util.zip.DataFormatException -> L3d
            r1 = r0
            if (r0 != 0) goto L3c
            java.util.zip.Inflater r0 = r4.inf     // Catch: java.util.zip.DataFormatException -> L3d
            boolean r0 = r0.finished()     // Catch: java.util.zip.DataFormatException -> L3d
            if (r0 != 0) goto L37
            java.util.zip.Inflater r0 = r4.inf     // Catch: java.util.zip.DataFormatException -> L3d
            boolean r0 = r0.needsDictionary()     // Catch: java.util.zip.DataFormatException -> L3d
            if (r0 == 0) goto L2b
            goto L37
        L2b:
            java.util.zip.Inflater r0 = r4.inf     // Catch: java.util.zip.DataFormatException -> L3d
            boolean r0 = r0.needsInput()     // Catch: java.util.zip.DataFormatException -> L3d
            if (r0 == 0) goto L11
            r4.fill()     // Catch: java.util.zip.DataFormatException -> L3d
            goto L11
        L37:
            r0 = 1
            r4.reachEOF = r0     // Catch: java.util.zip.DataFormatException -> L3d
            r0 = -1
            return r0
        L3c:
            return r1
        L3d:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            java.util.zip.ZipException r2 = new java.util.zip.ZipException
            if (r1 == 0) goto L48
            r3 = r1
            goto L4a
        L48:
            java.lang.String r3 = "Invalid ZLIB data format"
        L4a:
            r2.<init>(r3)
            throw r2
        L4e:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r0.<init>()
            throw r0
        L54:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.zip.InflaterInputStream.read(byte[], int, int):int");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        ensureOpen();
        if (this.reachEOF) {
            return 0;
        }
        if (!this.inf.finished()) {
            return 1;
        }
        this.reachEOF = true;
        return 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long n10) throws IOException {
        if (n10 < 0) {
            throw new IllegalArgumentException("negative skip length");
        }
        ensureOpen();
        int max = (int) Math.min(n10, ZipUtils.UPPER_UNIXTIME_BOUND);
        int total = 0;
        while (true) {
            if (total >= max) {
                break;
            }
            int len = max - total;
            byte[] bArr = this.f50535b;
            if (len > bArr.length) {
                len = bArr.length;
            }
            int len2 = read(bArr, 0, len);
            if (len2 == -1) {
                this.reachEOF = true;
                break;
            }
            total += len2;
        }
        return total;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.inf.end();
            this.in.close();
            this.closed = true;
        }
    }

    protected void fill() throws IOException {
        ensureOpen();
        InputStream inputStream = this.in;
        byte[] bArr = this.buf;
        int read = inputStream.read(bArr, 0, bArr.length);
        this.len = read;
        if (read == -1) {
            throw new EOFException("Unexpected end of ZLIB input stream");
        }
        this.inf.setInput(this.buf, 0, read);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int readlimit) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }
}
