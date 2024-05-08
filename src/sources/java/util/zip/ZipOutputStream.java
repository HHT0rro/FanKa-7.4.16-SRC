package java.util.zip;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ZipOutputStream extends DeflaterOutputStream implements ZipConstants {
    public static final int DEFLATED = 8;
    public static final int STORED = 0;
    private static final boolean inhibitZip64 = false;
    private boolean closed;
    private byte[] comment;
    private CRC32 crc;
    private XEntry current;
    private boolean finished;
    private long locoff;
    private int method;
    private HashSet<String> names;
    private long written;
    private Vector<XEntry> xentries;

    /* renamed from: zc, reason: collision with root package name */
    private final ZipCoder f50540zc;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class XEntry {
        final ZipEntry entry;
        final long offset;

        public XEntry(ZipEntry entry, long offset) {
            this.entry = entry;
            this.offset = offset;
        }
    }

    private static int version(ZipEntry e2) throws ZipException {
        switch (e2.method) {
            case 0:
                return 10;
            case 8:
                return 20;
            default:
                throw new ZipException("unsupported compression method");
        }
    }

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    public ZipOutputStream(OutputStream out) {
        this(out, StandardCharsets.UTF_8);
    }

    public ZipOutputStream(OutputStream out, Charset charset) {
        super(out, new Deflater(-1, true));
        this.xentries = new Vector<>();
        this.names = new HashSet<>();
        this.crc = new CRC32();
        this.written = 0L;
        this.locoff = 0L;
        this.method = 8;
        this.closed = false;
        if (charset == null) {
            throw new NullPointerException("charset is null");
        }
        this.f50540zc = ZipCoder.get(charset);
        this.usesDefaultDeflater = true;
    }

    public void setComment(String comment) {
        if (comment != null) {
            byte[] bytes = this.f50540zc.getBytes(comment);
            this.comment = bytes;
            if (bytes.length > 65535) {
                throw new IllegalArgumentException("ZIP file comment too long.");
            }
        }
    }

    public void setMethod(int method) {
        if (method != 8 && method != 0) {
            throw new IllegalArgumentException("invalid compression method");
        }
        this.method = method;
    }

    public void setLevel(int level) {
        this.def.setLevel(level);
    }

    public void putNextEntry(ZipEntry e2) throws IOException {
        ensureOpen();
        if (this.current != null) {
            closeEntry();
        }
        if (e2.xdostime == -1) {
            e2.setTime(System.currentTimeMillis());
        }
        if (e2.method == -1) {
            e2.method = this.method;
        }
        e2.flag = 0;
        switch (e2.method) {
            case 0:
                if (e2.size == -1) {
                    e2.size = e2.csize;
                } else if (e2.csize == -1) {
                    e2.csize = e2.size;
                } else if (e2.size != e2.csize) {
                    throw new ZipException("STORED entry where compressed != uncompressed size");
                }
                if (e2.size == -1 || e2.crc == -1) {
                    throw new ZipException("STORED entry missing size, compressed size, or crc-32");
                }
                break;
            case 8:
                if (e2.size == -1 || e2.csize == -1 || e2.crc == -1) {
                    e2.flag = 8;
                    break;
                }
                break;
            default:
                throw new ZipException("unsupported compression method");
        }
        if (!this.names.add(e2.name)) {
            throw new ZipException("duplicate entry: " + e2.name);
        }
        if (this.f50540zc.isUTF8()) {
            e2.flag |= 2048;
        }
        XEntry xEntry = new XEntry(e2, this.written);
        this.current = xEntry;
        this.xentries.add(xEntry);
        writeLOC(this.current);
    }

    public void closeEntry() throws IOException {
        ensureOpen();
        XEntry xEntry = this.current;
        if (xEntry != null) {
            ZipEntry e2 = xEntry.entry;
            switch (e2.method) {
                case 0:
                    if (e2.size != this.written - this.locoff) {
                        throw new ZipException("invalid entry size (expected " + e2.size + " but got " + (this.written - this.locoff) + " bytes)");
                    }
                    if (e2.crc != this.crc.getValue()) {
                        throw new ZipException("invalid entry crc-32 (expected 0x" + Long.toHexString(e2.crc) + " but got 0x" + Long.toHexString(this.crc.getValue()) + ")");
                    }
                    break;
                case 8:
                    this.def.finish();
                    while (!this.def.finished()) {
                        deflate();
                    }
                    if ((e2.flag & 8) != 0) {
                        e2.size = this.def.getBytesRead();
                        e2.csize = this.def.getBytesWritten();
                        e2.crc = this.crc.getValue();
                        writeEXT(e2);
                    } else {
                        if (e2.size != this.def.getBytesRead()) {
                            throw new ZipException("invalid entry size (expected " + e2.size + " but got " + this.def.getBytesRead() + " bytes)");
                        }
                        if (e2.csize != this.def.getBytesWritten()) {
                            throw new ZipException("invalid entry compressed size (expected " + e2.csize + " but got " + this.def.getBytesWritten() + " bytes)");
                        }
                        if (e2.crc != this.crc.getValue()) {
                            throw new ZipException("invalid entry CRC-32 (expected 0x" + Long.toHexString(e2.crc) + " but got 0x" + Long.toHexString(this.crc.getValue()) + ")");
                        }
                    }
                    this.def.reset();
                    this.written += e2.csize;
                    break;
                default:
                    throw new ZipException("invalid compression method");
            }
            this.crc.reset();
            this.current = null;
        }
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] b4, int off, int len) throws IOException {
        ensureOpen();
        if (off < 0 || len < 0 || off > b4.length - len) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        XEntry xEntry = this.current;
        if (xEntry == null) {
            throw new ZipException("no current ZIP entry");
        }
        ZipEntry entry = xEntry.entry;
        switch (entry.method) {
            case 0:
                long j10 = this.written + len;
                this.written = j10;
                if (j10 - this.locoff > entry.size) {
                    throw new ZipException("attempt to write past end of STORED entry");
                }
                this.out.write(b4, off, len);
                break;
            case 8:
                super.write(b4, off, len);
                break;
            default:
                throw new ZipException("invalid compression method");
        }
        this.crc.update(b4, off, len);
    }

    @Override // java.util.zip.DeflaterOutputStream
    public void finish() throws IOException {
        ensureOpen();
        if (this.finished) {
            return;
        }
        if (this.current != null) {
            closeEntry();
        }
        long off = this.written;
        Iterator<XEntry> iterator2 = this.xentries.iterator2();
        while (iterator2.hasNext()) {
            XEntry xentry = iterator2.next();
            writeCEN(xentry);
        }
        writeEND(off, this.written - off);
        this.finished = true;
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            super.close();
            this.closed = true;
        }
    }

    private void writeLOC(XEntry xentry) throws IOException {
        ZipEntry e2 = xentry.entry;
        int flag = e2.flag;
        boolean hasZip64 = false;
        int elen = getExtraLen(e2.extra);
        writeInt(ZipConstants.LOCSIG);
        if ((flag & 8) == 8) {
            writeShort(version(e2));
            writeShort(flag);
            writeShort(e2.method);
            writeInt(e2.xdostime);
            writeInt(0L);
            writeInt(0L);
            writeInt(0L);
        } else {
            if (e2.csize >= 4294967295L || e2.size >= 4294967295L) {
                hasZip64 = true;
                writeShort(45);
            } else {
                writeShort(version(e2));
            }
            writeShort(flag);
            writeShort(e2.method);
            writeInt(e2.xdostime);
            writeInt(e2.crc);
            if (hasZip64) {
                writeInt(4294967295L);
                writeInt(4294967295L);
                elen += 20;
            } else {
                writeInt(e2.csize);
                writeInt(e2.size);
            }
        }
        byte[] nameBytes = this.f50540zc.getBytes(e2.name);
        writeShort(nameBytes.length);
        int elenEXTT = 0;
        int flagEXTT = 0;
        if (e2.mtime != null) {
            elenEXTT = 0 + 4;
            flagEXTT = 0 | 1;
        }
        if (e2.atime != null) {
            elenEXTT += 4;
            flagEXTT |= 2;
        }
        if (e2.ctime != null) {
            elenEXTT += 4;
            flagEXTT |= 4;
        }
        if (flagEXTT != 0) {
            elen += elenEXTT + 5;
        }
        writeShort(elen);
        writeBytes(nameBytes, 0, nameBytes.length);
        if (hasZip64) {
            writeShort(1);
            writeShort(16);
            writeLong(e2.size);
            writeLong(e2.csize);
        }
        if (flagEXTT != 0) {
            writeShort(21589);
            writeShort(elenEXTT + 1);
            writeByte(flagEXTT);
            if (e2.mtime != null) {
                writeInt(ZipUtils.fileTimeToUnixTime(e2.mtime));
            }
            if (e2.atime != null) {
                writeInt(ZipUtils.fileTimeToUnixTime(e2.atime));
            }
            if (e2.ctime != null) {
                writeInt(ZipUtils.fileTimeToUnixTime(e2.ctime));
            }
        }
        writeExtra(e2.extra);
        this.locoff = this.written;
    }

    private void writeEXT(ZipEntry e2) throws IOException {
        writeInt(ZipConstants.EXTSIG);
        writeInt(e2.crc);
        if (e2.csize >= 4294967295L || e2.size >= 4294967295L) {
            writeLong(e2.csize);
            writeLong(e2.size);
        } else {
            writeInt(e2.csize);
            writeInt(e2.size);
        }
    }

    private void writeCEN(XEntry xentry) throws IOException {
        int flagEXTT;
        byte[] commentBytes;
        int i10;
        ZipEntry e2 = xentry.entry;
        int flag = e2.flag;
        int version = version(e2);
        long csize = e2.csize;
        long size = e2.size;
        long offset = xentry.offset;
        int elenZIP64 = 0;
        boolean hasZip64 = false;
        if (e2.csize >= 4294967295L) {
            csize = 4294967295L;
            elenZIP64 = 0 + 8;
            hasZip64 = true;
        }
        if (e2.size >= 4294967295L) {
            size = 4294967295L;
            elenZIP64 += 8;
            hasZip64 = true;
        }
        if (xentry.offset >= 4294967295L) {
            offset = 4294967295L;
            elenZIP64 += 8;
            hasZip64 = true;
        }
        writeInt(ZipConstants.CENSIG);
        if (hasZip64) {
            writeShort(45);
            writeShort(45);
        } else {
            writeShort(version);
            writeShort(version);
        }
        writeShort(flag);
        writeShort(e2.method);
        writeInt(e2.xdostime);
        writeInt(e2.crc);
        writeInt(csize);
        writeInt(size);
        byte[] nameBytes = this.f50540zc.getBytes(e2.name);
        writeShort(nameBytes.length);
        int elen = getExtraLen(e2.extra);
        if (hasZip64) {
            elen += elenZIP64 + 4;
        }
        int flagEXTT2 = 0;
        if (e2.mtime != null) {
            elen += 4;
            flagEXTT2 = 0 | 1;
        }
        if (e2.atime != null) {
            flagEXTT2 |= 2;
        }
        if (e2.ctime == null) {
            flagEXTT = flagEXTT2;
        } else {
            flagEXTT = flagEXTT2 | 4;
        }
        if (flagEXTT != 0) {
            elen += 5;
        }
        writeShort(elen);
        if (e2.comment != null) {
            byte[] commentBytes2 = this.f50540zc.getBytes(e2.comment);
            writeShort(Math.min(commentBytes2.length, 65535));
            commentBytes = commentBytes2;
            i10 = 0;
        } else {
            commentBytes = null;
            i10 = 0;
            writeShort(0);
        }
        writeShort(i10);
        writeShort(i10);
        long csize2 = csize;
        writeInt(0L);
        writeInt(offset);
        writeBytes(nameBytes, 0, nameBytes.length);
        if (hasZip64) {
            writeShort(1);
            writeShort(elenZIP64);
            if (size == 4294967295L) {
                writeLong(e2.size);
            }
            if (csize2 == 4294967295L) {
                writeLong(e2.csize);
            }
            if (offset == 4294967295L) {
                writeLong(xentry.offset);
            }
        }
        if (flagEXTT != 0) {
            writeShort(21589);
            if (e2.mtime != null) {
                writeShort(5);
                writeByte(flagEXTT);
                writeInt(ZipUtils.fileTimeToUnixTime(e2.mtime));
            } else {
                writeShort(1);
                writeByte(flagEXTT);
            }
        }
        writeExtra(e2.extra);
        if (commentBytes != null) {
            writeBytes(commentBytes, 0, Math.min(commentBytes.length, 65535));
        }
    }

    private void writeEND(long off, long len) throws IOException {
        boolean hasZip64 = false;
        long xlen = len;
        long xoff = off;
        if (xlen >= 4294967295L) {
            xlen = 4294967295L;
            hasZip64 = true;
        }
        if (xoff >= 4294967295L) {
            xoff = 4294967295L;
            hasZip64 = true;
        }
        int count = this.xentries.size();
        if (count >= 65535 && ((hasZip64 = hasZip64 | true))) {
            count = 65535;
        }
        if (hasZip64) {
            long off64 = this.written;
            writeInt(101075792L);
            writeLong(44L);
            writeShort(45);
            writeShort(45);
            writeInt(0L);
            writeInt(0L);
            writeLong(this.xentries.size());
            writeLong(this.xentries.size());
            writeLong(len);
            writeLong(off);
            writeInt(117853008L);
            writeInt(0L);
            writeLong(off64);
            writeInt(1L);
        }
        writeInt(ZipConstants.ENDSIG);
        writeShort(0);
        writeShort(0);
        writeShort(count);
        writeShort(count);
        writeInt(xlen);
        writeInt(xoff);
        byte[] bArr = this.comment;
        if (bArr != null) {
            writeShort(bArr.length);
            byte[] bArr2 = this.comment;
            writeBytes(bArr2, 0, bArr2.length);
            return;
        }
        writeShort(0);
    }

    private int getExtraLen(byte[] extra) {
        if (extra == null) {
            return 0;
        }
        int skipped = 0;
        int len = extra.length;
        int off = 0;
        while (off + 4 <= len) {
            int tag = ZipUtils.get16(extra, off);
            int sz = ZipUtils.get16(extra, off + 2);
            if (sz < 0 || off + 4 + sz > len) {
                break;
            }
            if (tag == 21589 || tag == 1) {
                skipped += sz + 4;
            }
            off += sz + 4;
        }
        return len - skipped;
    }

    private void writeExtra(byte[] extra) throws IOException {
        if (extra != null) {
            int len = extra.length;
            int off = 0;
            while (off + 4 <= len) {
                int tag = ZipUtils.get16(extra, off);
                int sz = ZipUtils.get16(extra, off + 2);
                if (sz < 0 || off + 4 + sz > len) {
                    writeBytes(extra, off, len - off);
                    return;
                }
                if (tag != 21589 && tag != 1) {
                    writeBytes(extra, off, sz + 4);
                }
                off += sz + 4;
            }
            if (off < len) {
                writeBytes(extra, off, len - off);
            }
        }
    }

    private void writeByte(int v2) throws IOException {
        OutputStream out = this.out;
        out.write(v2 & 255);
        this.written++;
    }

    private void writeShort(int v2) throws IOException {
        OutputStream out = this.out;
        out.write((v2 >>> 0) & 255);
        out.write((v2 >>> 8) & 255);
        this.written += 2;
    }

    private void writeInt(long v2) throws IOException {
        OutputStream out = this.out;
        out.write((int) ((v2 >>> 0) & 255));
        out.write((int) ((v2 >>> 8) & 255));
        out.write((int) ((v2 >>> 16) & 255));
        out.write((int) ((v2 >>> 24) & 255));
        this.written += 4;
    }

    private void writeLong(long v2) throws IOException {
        OutputStream out = this.out;
        out.write((int) ((v2 >>> 0) & 255));
        out.write((int) ((v2 >>> 8) & 255));
        out.write((int) ((v2 >>> 16) & 255));
        out.write((int) ((v2 >>> 24) & 255));
        out.write((int) ((v2 >>> 32) & 255));
        out.write((int) ((v2 >>> 40) & 255));
        out.write((int) ((v2 >>> 48) & 255));
        out.write((int) ((v2 >>> 56) & 255));
        this.written += 8;
    }

    private void writeBytes(byte[] b4, int off, int len) throws IOException {
        this.out.write(b4, off, len);
        this.written += len;
    }
}
