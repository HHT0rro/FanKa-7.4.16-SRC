package java.util.zip;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class GZIPInputStream extends InflaterInputStream {
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    private static final int FTEXT = 1;
    public static final int GZIP_MAGIC = 35615;
    private boolean closed;
    protected CRC32 crc;
    protected boolean eos;
    private byte[] tmpbuf;

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    public GZIPInputStream(InputStream in, int size) throws IOException {
        super(in, new Inflater(true), size);
        this.crc = new CRC32();
        this.closed = false;
        this.tmpbuf = new byte[128];
        try {
            readHeader(in);
        } catch (Exception e2) {
            this.inf.end();
            throw e2;
        }
    }

    public GZIPInputStream(InputStream in) throws IOException {
        this(in, 512);
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] buf, int off, int len) throws IOException {
        ensureOpen();
        if (this.eos) {
            return -1;
        }
        int n10 = super.read(buf, off, len);
        if (n10 == -1) {
            if (readTrailer()) {
                this.eos = true;
            } else {
                return read(buf, off, len);
            }
        } else {
            this.crc.update(buf, off, n10);
        }
        return n10;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            super.close();
            this.eos = true;
            this.closed = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        if (readUByte(r0) != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
    
        if ((r1 & 16) != 16) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        if (readUByte(r0) != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        if ((r1 & 2) != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        r2 = ((int) r6.crc.getValue()) & 65535;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        if (readUShort(r0) != r2) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
    
        r3 = r3 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        throw new java.util.zip.ZipException("Corrupt GZIP header");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        r6.crc.reset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if ((r1 & 8) == 8) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int readHeader(java.io.InputStream r7) throws java.io.IOException {
        /*
            r6 = this;
            java.util.zip.CheckedInputStream r0 = new java.util.zip.CheckedInputStream
            java.util.zip.CRC32 r1 = r6.crc
            r0.<init>(r7, r1)
            java.util.zip.CRC32 r1 = r6.crc
            r1.reset()
            int r1 = r6.readUShort(r0)
            r2 = 35615(0x8b1f, float:4.9907E-41)
            if (r1 != r2) goto L7f
            int r1 = r6.readUByte(r0)
            r2 = 8
            if (r1 != r2) goto L77
            int r1 = r6.readUByte(r0)
            r3 = 6
            r6.skipBytes(r0, r3)
            r3 = 10
            r4 = r1 & 4
            r5 = 4
            if (r4 != r5) goto L36
            int r4 = r6.readUShort(r0)
            r6.skipBytes(r0, r4)
            int r5 = r4 + 2
            int r3 = r3 + r5
        L36:
            r4 = r1 & 8
            if (r4 != r2) goto L42
        L3a:
            int r3 = r3 + 1
            int r2 = r6.readUByte(r0)
            if (r2 != 0) goto L3a
        L42:
            r2 = r1 & 16
            r4 = 16
            if (r2 != r4) goto L50
        L48:
            int r3 = r3 + 1
            int r2 = r6.readUByte(r0)
            if (r2 != 0) goto L48
        L50:
            r2 = r1 & 2
            r4 = 2
            if (r2 != r4) goto L71
            java.util.zip.CRC32 r2 = r6.crc
            long r4 = r2.getValue()
            int r2 = (int) r4
            r4 = 65535(0xffff, float:9.1834E-41)
            r2 = r2 & r4
            int r4 = r6.readUShort(r0)
            if (r4 != r2) goto L69
            int r3 = r3 + 2
            goto L71
        L69:
            java.util.zip.ZipException r4 = new java.util.zip.ZipException
            java.lang.String r5 = "Corrupt GZIP header"
            r4.<init>(r5)
            throw r4
        L71:
            java.util.zip.CRC32 r2 = r6.crc
            r2.reset()
            return r3
        L77:
            java.util.zip.ZipException r1 = new java.util.zip.ZipException
            java.lang.String r2 = "Unsupported compression method"
            r1.<init>(r2)
            throw r1
        L7f:
            java.util.zip.ZipException r1 = new java.util.zip.ZipException
            java.lang.String r2 = "Not in GZIP format"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.zip.GZIPInputStream.readHeader(java.io.InputStream):int");
    }

    private boolean readTrailer() throws IOException {
        InputStream in = this.in;
        int n10 = this.inf.getRemaining();
        if (n10 > 0) {
            in = new SequenceInputStream(new ByteArrayInputStream(this.buf, this.len - n10, n10), new FilterInputStream(in) { // from class: java.util.zip.GZIPInputStream.1
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                }
            });
        }
        if (readUInt(in) != this.crc.getValue() || readUInt(in) != (this.inf.getBytesWritten() & 4294967295L)) {
            throw new ZipException("Corrupt GZIP trailer");
        }
        if (this.in.available() <= 0 && n10 <= 26) {
            return true;
        }
        try {
            int m10 = 8 + readHeader(in);
            this.inf.reset();
            if (n10 > m10) {
                this.inf.setInput(this.buf, (this.len - n10) + m10, n10 - m10);
                return false;
            }
            return false;
        } catch (IOException e2) {
            return true;
        }
    }

    private long readUInt(InputStream in) throws IOException {
        long s2 = readUShort(in);
        return (readUShort(in) << 16) | s2;
    }

    private int readUShort(InputStream in) throws IOException {
        int b4 = readUByte(in);
        return (readUByte(in) << 8) | b4;
    }

    private int readUByte(InputStream in) throws IOException {
        int b4 = in.read();
        if (b4 == -1) {
            throw new EOFException();
        }
        if (b4 < -1 || b4 > 255) {
            throw new IOException(this.in.getClass().getName() + ".read() returned value out of range -1..255: " + b4);
        }
        return b4;
    }

    private void skipBytes(InputStream in, int n10) throws IOException {
        while (n10 > 0) {
            byte[] bArr = this.tmpbuf;
            int len = in.read(bArr, 0, n10 < bArr.length ? n10 : bArr.length);
            if (len == -1) {
                throw new EOFException();
            }
            n10 -= len;
        }
    }
}
