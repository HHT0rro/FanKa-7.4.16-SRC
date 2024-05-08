package java.util.zip;

import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.FileTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ZipEntry implements ZipConstants, Cloneable {
    public static final int DEFLATED = 8;
    static final long DOSTIME_BEFORE_1980 = 2162688;
    public static final int STORED = 0;
    public static final long UPPER_DOSTIME_BOUND = 4036608000000L;
    FileTime atime;
    String comment;
    long crc;
    long csize;
    FileTime ctime;
    long dataOffset;
    byte[] extra;
    int flag;
    int method;
    FileTime mtime;
    String name;
    long size;
    long xdostime;

    public ZipEntry(String name, String comment, long crc, long compressedSize, long size, int compressionMethod, int xdostime, byte[] extra, long dataOffset) {
        this.xdostime = -1L;
        this.crc = -1L;
        this.size = -1L;
        this.csize = -1L;
        this.method = -1;
        this.flag = 0;
        this.name = name;
        this.comment = comment;
        this.crc = crc;
        this.csize = compressedSize;
        this.size = size;
        this.method = compressionMethod;
        this.xdostime = xdostime;
        this.dataOffset = dataOffset;
        setExtra0(extra, false);
    }

    public ZipEntry(String name) {
        this.xdostime = -1L;
        this.crc = -1L;
        this.size = -1L;
        this.csize = -1L;
        this.method = -1;
        this.flag = 0;
        Objects.requireNonNull(name, "name");
        if (name.getBytes(StandardCharsets.UTF_8).length > 65535) {
            throw new IllegalArgumentException(name + " too long: " + name.getBytes(StandardCharsets.UTF_8).length);
        }
        this.name = name;
    }

    public ZipEntry(ZipEntry e2) {
        this.xdostime = -1L;
        this.crc = -1L;
        this.size = -1L;
        this.csize = -1L;
        this.method = -1;
        this.flag = 0;
        Objects.requireNonNull(e2, "entry");
        this.name = e2.name;
        this.xdostime = e2.xdostime;
        this.mtime = e2.mtime;
        this.atime = e2.atime;
        this.ctime = e2.ctime;
        this.crc = e2.crc;
        this.size = e2.size;
        this.csize = e2.csize;
        this.method = e2.method;
        this.flag = e2.flag;
        this.extra = e2.extra;
        this.comment = e2.comment;
        this.dataOffset = e2.dataOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZipEntry() {
        this.xdostime = -1L;
        this.crc = -1L;
        this.size = -1L;
        this.csize = -1L;
        this.method = -1;
        this.flag = 0;
    }

    public long getDataOffset() {
        return this.dataOffset;
    }

    public String getName() {
        return this.name;
    }

    public void setTime(long time) {
        long javaToExtendedDosTime = ZipUtils.javaToExtendedDosTime(time);
        this.xdostime = javaToExtendedDosTime;
        if (javaToExtendedDosTime != DOSTIME_BEFORE_1980 && time <= UPPER_DOSTIME_BOUND) {
            this.mtime = null;
        } else {
            this.mtime = FileTime.from(time, TimeUnit.MILLISECONDS);
        }
    }

    public long getTime() {
        FileTime fileTime = this.mtime;
        if (fileTime != null) {
            return fileTime.toMillis();
        }
        long j10 = this.xdostime;
        if (j10 != -1) {
            return ZipUtils.extendedDosToJavaTime(j10);
        }
        return -1L;
    }

    public ZipEntry setLastModifiedTime(FileTime time) {
        this.mtime = (FileTime) Objects.requireNonNull(time, "lastModifiedTime");
        this.xdostime = ZipUtils.javaToExtendedDosTime(time.to(TimeUnit.MILLISECONDS));
        return this;
    }

    public FileTime getLastModifiedTime() {
        FileTime fileTime = this.mtime;
        if (fileTime != null) {
            return fileTime;
        }
        if (this.xdostime == -1) {
            return null;
        }
        return FileTime.from(getTime(), TimeUnit.MILLISECONDS);
    }

    public ZipEntry setLastAccessTime(FileTime time) {
        this.atime = (FileTime) Objects.requireNonNull(time, "lastAccessTime");
        return this;
    }

    public FileTime getLastAccessTime() {
        return this.atime;
    }

    public ZipEntry setCreationTime(FileTime time) {
        this.ctime = (FileTime) Objects.requireNonNull(time, "creationTime");
        return this;
    }

    public FileTime getCreationTime() {
        return this.ctime;
    }

    public void setSize(long size) {
        if (size < 0) {
            throw new IllegalArgumentException("invalid entry size");
        }
        this.size = size;
    }

    public long getSize() {
        return this.size;
    }

    public long getCompressedSize() {
        return this.csize;
    }

    public void setCompressedSize(long csize) {
        this.csize = csize;
    }

    public void setCrc(long crc) {
        if (crc < 0 || crc > 4294967295L) {
            throw new IllegalArgumentException("invalid entry crc-32");
        }
        this.crc = crc;
    }

    public long getCrc() {
        return this.crc;
    }

    public void setMethod(int method) {
        if (method != 0 && method != 8) {
            throw new IllegalArgumentException("invalid compression method");
        }
        this.method = method;
    }

    public int getMethod() {
        return this.method;
    }

    public void setExtra(byte[] extra) {
        setExtra0(extra, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExtra0(byte[] extra, boolean doZIP64) {
        if (extra != null) {
            if (extra.length > 65535) {
                throw new IllegalArgumentException("invalid extra field length");
            }
            int off = 0;
            int len = extra.length;
            while (off + 4 < len) {
                int tag = ZipUtils.get16(extra, off);
                int sz = ZipUtils.get16(extra, off + 2);
                int off2 = off + 4;
                if (off2 + sz <= len) {
                    switch (tag) {
                        case 1:
                            if (doZIP64 && sz >= 16) {
                                this.size = ZipUtils.get64(extra, off2);
                                this.csize = ZipUtils.get64(extra, off2 + 8);
                                break;
                            }
                            break;
                        case 10:
                            if (sz >= 32) {
                                int pos = off2 + 4;
                                if (ZipUtils.get16(extra, pos) == 1 && ZipUtils.get16(extra, pos + 2) == 24) {
                                    this.mtime = ZipUtils.winTimeToFileTime(ZipUtils.get64(extra, pos + 4));
                                    this.atime = ZipUtils.winTimeToFileTime(ZipUtils.get64(extra, pos + 12));
                                    this.ctime = ZipUtils.winTimeToFileTime(ZipUtils.get64(extra, pos + 20));
                                    break;
                                }
                            } else {
                                break;
                            }
                            break;
                        case 21589:
                            int flag = Byte.toUnsignedInt(extra[off2]);
                            int sz0 = 1;
                            if ((flag & 1) != 0 && 1 + 4 <= sz) {
                                this.mtime = ZipUtils.unixTimeToFileTime(ZipUtils.get32(extra, off2 + 1));
                                sz0 = 1 + 4;
                            }
                            if ((flag & 2) != 0 && sz0 + 4 <= sz) {
                                this.atime = ZipUtils.unixTimeToFileTime(ZipUtils.get32(extra, off2 + sz0));
                                sz0 += 4;
                            }
                            if ((flag & 4) != 0 && sz0 + 4 <= sz) {
                                this.ctime = ZipUtils.unixTimeToFileTime(ZipUtils.get32(extra, off2 + sz0));
                                int i10 = sz0 + 4;
                                break;
                            }
                            break;
                    }
                    off = off2 + sz;
                }
            }
        }
        this.extra = extra;
    }

    public byte[] getExtra() {
        return this.extra;
    }

    public void setComment(String comment) {
        if (comment != null && comment.getBytes(StandardCharsets.UTF_8).length > 65535) {
            throw new IllegalArgumentException(comment + " too long: " + comment.getBytes(StandardCharsets.UTF_8).length);
        }
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }

    public boolean isDirectory() {
        return this.name.endsWith("/");
    }

    public String toString() {
        return getName();
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public Object clone() {
        try {
            ZipEntry e2 = (ZipEntry) super.clone();
            byte[] bArr = this.extra;
            e2.extra = bArr == null ? null : (byte[]) bArr.clone();
            return e2;
        } catch (CloneNotSupportedException e10) {
            throw new InternalError(e10);
        }
    }
}
