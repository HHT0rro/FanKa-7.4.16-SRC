package java.util.zip;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ZipInputStream extends InflaterInputStream implements ZipConstants {
    private static final int DEFLATED = 8;
    private static final int STORED = 0;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f50538b;
    private boolean closed;
    private CRC32 crc;
    private ZipEntry entry;
    private boolean entryEOF;
    private int flag;
    private long remaining;
    private byte[] tmpbuf;

    /* renamed from: zc, reason: collision with root package name */
    private ZipCoder f50539zc;

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    public ZipInputStream(InputStream in) {
        this(in, StandardCharsets.UTF_8);
    }

    public ZipInputStream(InputStream in, Charset charset) {
        super(new PushbackInputStream(in, 512), new Inflater(true), 512);
        this.crc = new CRC32();
        this.tmpbuf = new byte[512];
        this.closed = false;
        this.entryEOF = false;
        this.f50538b = new byte[256];
        if (in == null) {
            throw new NullPointerException("in is null");
        }
        if (charset == null) {
            throw new NullPointerException("charset is null");
        }
        this.f50539zc = ZipCoder.get(charset);
    }

    public ZipEntry getNextEntry() throws IOException {
        ensureOpen();
        if (this.entry != null) {
            closeEntry();
        }
        this.crc.reset();
        this.inf.reset();
        ZipEntry readLOC = readLOC();
        this.entry = readLOC;
        if (readLOC == null) {
            return null;
        }
        if (readLOC.method == 0 || this.entry.method == 8) {
            this.remaining = this.entry.size;
        }
        this.entryEOF = false;
        return this.entry;
    }

    public void closeEntry() throws IOException {
        byte[] bArr;
        ensureOpen();
        do {
            bArr = this.tmpbuf;
        } while (read(bArr, 0, bArr.length) != -1);
        this.entryEOF = true;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        ensureOpen();
        if (this.entryEOF) {
            return 0;
        }
        if (this.entry != null && this.remaining == 0) {
            return 0;
        }
        return 1;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b4, int off, int len) throws IOException {
        ensureOpen();
        if (off < 0 || len < 0 || off > b4.length - len) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return 0;
        }
        ZipEntry zipEntry = this.entry;
        if (zipEntry == null) {
            return -1;
        }
        switch (zipEntry.method) {
            case 0:
                long j10 = this.remaining;
                if (j10 <= 0) {
                    this.entryEOF = true;
                    this.entry = null;
                    return -1;
                }
                if (len > j10) {
                    len = (int) j10;
                }
                int len2 = this.in.read(b4, off, len);
                if (len2 == -1) {
                    throw new ZipException("unexpected EOF");
                }
                this.crc.update(b4, off, len2);
                long j11 = this.remaining - len2;
                this.remaining = j11;
                if (j11 == 0 && this.entry.crc != this.crc.getValue()) {
                    throw new ZipException("invalid entry CRC (expected 0x" + Long.toHexString(this.entry.crc) + " but got 0x" + Long.toHexString(this.crc.getValue()) + ")");
                }
                return len2;
            case 8:
                int len3 = super.read(b4, off, len);
                if (len3 == -1) {
                    readEnd(this.entry);
                    this.entryEOF = true;
                    this.entry = null;
                } else {
                    this.crc.update(b4, off, len3);
                    this.remaining -= len3;
                }
                return len3;
            default:
                throw new ZipException("invalid compression method");
        }
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
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
            byte[] bArr = this.tmpbuf;
            if (len > bArr.length) {
                len = bArr.length;
            }
            int len2 = read(bArr, 0, len);
            if (len2 == -1) {
                this.entryEOF = true;
                break;
            }
            total += len2;
        }
        return total;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            super.close();
            this.closed = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        r1 = r1 * 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        if (r0 > r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r10.f50538b = new byte[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        readFully(r10.f50538b, 0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        if ((r10.flag & 2048) == 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        r2 = r10.f50539zc.toStringUTF8(r10.f50538b, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        r2 = createZipEntry(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        if ((r10.flag & 1) == 1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        dalvik.system.ZipPathValidator.getInstance().onZipEntryAccess(r2.name);
        r2.method = java.util.zip.ZipUtils.get16(r10.tmpbuf, 8);
        r2.xdostime = java.util.zip.ZipUtils.get32(r10.tmpbuf, 10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
    
        if ((r10.flag & 8) != 8) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007f, code lost:
    
        r2.crc = java.util.zip.ZipUtils.get32(r10.tmpbuf, 14);
        r2.csize = java.util.zip.ZipUtils.get32(r10.tmpbuf, 18);
        r2.size = java.util.zip.ZipUtils.get32(r10.tmpbuf, 22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009d, code lost:
    
        r0 = java.util.zip.ZipUtils.get16(r10.tmpbuf, 28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a5, code lost:
    
        if (r0 <= 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a7, code lost:
    
        r4 = new byte[r0];
        readFully(r4, 0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b5, code lost:
    
        if (r2.csize == 4294967295L) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bb, code lost:
    
        if (r2.size != 4294967295L) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00be, code lost:
    
        r2.setExtra0(r4, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bd, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c1, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c9, code lost:
    
        throw new java.util.zip.ZipException("encrypted ZIP entry not supported");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        r2 = r10.f50539zc.toString(r10.f50538b, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
    
        if (r0 > r1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.zip.ZipEntry readLOC() throws java.io.IOException {
        /*
            r10 = this;
            r0 = 0
            byte[] r1 = r10.tmpbuf     // Catch: java.io.EOFException -> Lca
            r2 = 30
            r3 = 0
            r10.readFully(r1, r3, r2)     // Catch: java.io.EOFException -> Lca
            byte[] r1 = r10.tmpbuf
            long r1 = java.util.zip.ZipUtils.get32(r1, r3)
            r4 = 67324752(0x4034b50, double:3.3262847E-316)
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L18
            return r0
        L18:
            byte[] r0 = r10.tmpbuf
            r1 = 6
            int r0 = java.util.zip.ZipUtils.get16(r0, r1)
            r10.flag = r0
            byte[] r0 = r10.tmpbuf
            r1 = 26
            int r0 = java.util.zip.ZipUtils.get16(r0, r1)
            byte[] r1 = r10.f50538b
            int r1 = r1.length
            if (r0 <= r1) goto L36
        L2e:
            int r1 = r1 * 2
            if (r0 > r1) goto L2e
            byte[] r2 = new byte[r1]
            r10.f50538b = r2
        L36:
            byte[] r2 = r10.f50538b
            r10.readFully(r2, r3, r0)
            int r2 = r10.flag
            r2 = r2 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L4a
            java.util.zip.ZipCoder r2 = r10.f50539zc
            byte[] r4 = r10.f50538b
            java.lang.String r2 = r2.toStringUTF8(r4, r0)
            goto L52
        L4a:
            java.util.zip.ZipCoder r2 = r10.f50539zc
            byte[] r4 = r10.f50538b
            java.lang.String r2 = r2.toString(r4, r0)
        L52:
            java.util.zip.ZipEntry r2 = r10.createZipEntry(r2)
            int r4 = r10.flag
            r5 = 1
            r4 = r4 & r5
            if (r4 == r5) goto Lc2
            dalvik.system.ZipPathValidator$Callback r4 = dalvik.system.ZipPathValidator.getInstance()
            java.lang.String r6 = r2.name
            r4.onZipEntryAccess(r6)
            byte[] r4 = r10.tmpbuf
            r6 = 8
            int r4 = java.util.zip.ZipUtils.get16(r4, r6)
            r2.method = r4
            byte[] r4 = r10.tmpbuf
            r7 = 10
            long r7 = java.util.zip.ZipUtils.get32(r4, r7)
            r2.xdostime = r7
            int r4 = r10.flag
            r4 = r4 & r6
            if (r4 != r6) goto L7f
            goto L9d
        L7f:
            byte[] r4 = r10.tmpbuf
            r6 = 14
            long r6 = java.util.zip.ZipUtils.get32(r4, r6)
            r2.crc = r6
            byte[] r4 = r10.tmpbuf
            r6 = 18
            long r6 = java.util.zip.ZipUtils.get32(r4, r6)
            r2.csize = r6
            byte[] r4 = r10.tmpbuf
            r6 = 22
            long r6 = java.util.zip.ZipUtils.get32(r4, r6)
            r2.size = r6
        L9d:
            byte[] r4 = r10.tmpbuf
            r6 = 28
            int r0 = java.util.zip.ZipUtils.get16(r4, r6)
            if (r0 <= 0) goto Lc1
            byte[] r4 = new byte[r0]
            r10.readFully(r4, r3, r0)
            long r6 = r2.csize
            r8 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto Lbd
            long r6 = r2.size
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto Lbe
        Lbd:
            r3 = r5
        Lbe:
            r2.setExtra0(r4, r3)
        Lc1:
            return r2
        Lc2:
            java.util.zip.ZipException r3 = new java.util.zip.ZipException
            java.lang.String r4 = "encrypted ZIP entry not supported"
            r3.<init>(r4)
            throw r3
        Lca:
            r1 = move-exception
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.zip.ZipInputStream.readLOC():java.util.zip.ZipEntry");
    }

    protected ZipEntry createZipEntry(String name) {
        return new ZipEntry(name);
    }

    private void readEnd(ZipEntry e2) throws IOException {
        int n10 = this.inf.getRemaining();
        if (n10 > 0) {
            ((PushbackInputStream) this.in).unread(this.buf, this.len - n10, n10);
        }
        if ((this.flag & 8) == 8) {
            if (this.inf.getBytesWritten() > 4294967295L || this.inf.getBytesRead() > 4294967295L) {
                readFully(this.tmpbuf, 0, 24);
                long sig = ZipUtils.get32(this.tmpbuf, 0);
                if (sig != ZipConstants.EXTSIG) {
                    e2.crc = sig;
                    e2.csize = ZipUtils.get64(this.tmpbuf, 4);
                    e2.size = ZipUtils.get64(this.tmpbuf, 12);
                    ((PushbackInputStream) this.in).unread(this.tmpbuf, 20, 4);
                } else {
                    e2.crc = ZipUtils.get32(this.tmpbuf, 4);
                    e2.csize = ZipUtils.get64(this.tmpbuf, 8);
                    e2.size = ZipUtils.get64(this.tmpbuf, 16);
                }
            } else {
                readFully(this.tmpbuf, 0, 16);
                long sig2 = ZipUtils.get32(this.tmpbuf, 0);
                if (sig2 != ZipConstants.EXTSIG) {
                    e2.crc = sig2;
                    e2.csize = ZipUtils.get32(this.tmpbuf, 4);
                    e2.size = ZipUtils.get32(this.tmpbuf, 8);
                    ((PushbackInputStream) this.in).unread(this.tmpbuf, 12, 4);
                } else {
                    e2.crc = ZipUtils.get32(this.tmpbuf, 4);
                    e2.csize = ZipUtils.get32(this.tmpbuf, 8);
                    e2.size = ZipUtils.get32(this.tmpbuf, 12);
                }
            }
        }
        if (e2.size != this.inf.getBytesWritten()) {
            throw new ZipException("invalid entry size (expected " + e2.size + " but got " + this.inf.getBytesWritten() + " bytes)");
        }
        if (e2.csize != this.inf.getBytesRead()) {
            throw new ZipException("invalid entry compressed size (expected " + e2.csize + " but got " + this.inf.getBytesRead() + " bytes)");
        }
        if (e2.crc != this.crc.getValue()) {
            throw new ZipException("invalid entry CRC (expected 0x" + Long.toHexString(e2.crc) + " but got 0x" + Long.toHexString(this.crc.getValue()) + ")");
        }
    }

    private void readFully(byte[] b4, int off, int len) throws IOException {
        while (len > 0) {
            int n10 = this.in.read(b4, off, len);
            if (n10 == -1) {
                throw new EOFException();
            }
            off += n10;
            len -= n10;
        }
    }
}
