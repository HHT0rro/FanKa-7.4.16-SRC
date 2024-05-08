package java.util.zip;

import com.android.internal.logging.nano.MetricsProto;
import dalvik.system.CloseGuard;
import dalvik.system.ZipPathValidator;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Spliterators;
import java.util.WeakHashMap;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ZipFile implements ZipConstants, Closeable {
    private static final int DEFLATED = 8;
    private static final int JZENTRY_COMMENT = 2;
    private static final int JZENTRY_EXTRA = 1;
    private static final int JZENTRY_NAME = 0;
    public static final int OPEN_DELETE = 4;
    public static final int OPEN_READ = 1;
    private static final int STORED = 0;
    private static final boolean usemmap = true;
    private volatile boolean closeRequested;
    private final File fileToRemoveOnClose;
    private final CloseGuard guard;
    private Deque<Inflater> inflaterCache;
    private final boolean isZipPathValidatorEnabled;
    private long jzfile;
    private final boolean locsig;
    private final String name;
    private final Map<InputStream, Inflater> streams;
    private final int total;

    /* renamed from: zc, reason: collision with root package name */
    private ZipCoder f50536zc;

    private static native void close(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void freeEntry(long j10, long j11);

    private static native byte[] getCommentBytes(long j10);

    private static native long getEntry(long j10, byte[] bArr, boolean z10);

    private static native byte[] getEntryBytes(long j10, int i10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long getEntryCSize(long j10);

    private static native long getEntryCrc(long j10);

    private static native int getEntryFlag(long j10);

    private static native int getEntryMethod(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long getEntrySize(long j10);

    private static native long getEntryTime(long j10);

    private static native int getFileDescriptor(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long getNextEntry(long j10, int i10);

    private static native int getTotal(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String getZipMessage(long j10);

    private native long open(String str, int i10, long j10, boolean z10) throws IOException;

    /* JADX INFO: Access modifiers changed from: private */
    public static native int read(long j10, long j11, long j12, byte[] bArr, int i10, int i11);

    private static native boolean startsWithLOC(long j10);

    public ZipFile(String name) throws IOException {
        this(new File(name), 1);
    }

    public ZipFile(File file, int mode) throws IOException {
        this(file, mode, StandardCharsets.UTF_8);
    }

    public ZipFile(File file) throws ZipException, IOException {
        this(file, 1);
    }

    public ZipFile(File file, int mode, Charset charset) throws IOException {
        this(file, mode, charset, true);
    }

    public ZipFile(File file, int mode, boolean enableZipPathValidator) throws IOException {
        this(file, mode, StandardCharsets.UTF_8, enableZipPathValidator);
    }

    public ZipFile(File file, int mode, Charset charset, boolean enableZipPathValidator) throws IOException {
        boolean z10 = false;
        this.closeRequested = false;
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.streams = new WeakHashMap();
        this.inflaterCache = new ArrayDeque();
        if (enableZipPathValidator && !ZipPathValidator.isClear()) {
            z10 = true;
        }
        this.isZipPathValidatorEnabled = z10;
        if ((mode & 1) == 0 || (mode & (-6)) != 0) {
            throw new IllegalArgumentException("Illegal mode: 0x" + Integer.toHexString(mode));
        }
        String name = file.getPath();
        this.fileToRemoveOnClose = (mode & 4) != 0 ? file : null;
        if (charset == null) {
            throw new NullPointerException("charset is null");
        }
        this.f50536zc = ZipCoder.get(charset);
        long open = open(name, mode, file.lastModified(), usemmap);
        this.jzfile = open;
        this.name = name;
        this.total = getTotal(open);
        this.locsig = startsWithLOC(this.jzfile);
        closeGuard.open("close");
    }

    public ZipFile(String name, Charset charset) throws IOException {
        this(new File(name), 1, charset);
    }

    public ZipFile(File file, Charset charset) throws IOException {
        this(file, 1, charset);
    }

    public String getComment() {
        synchronized (this) {
            ensureOpen();
            byte[] bcomm = getCommentBytes(this.jzfile);
            if (bcomm == null) {
                return null;
            }
            return this.f50536zc.toString(bcomm, bcomm.length);
        }
    }

    public ZipEntry getEntry(String name) {
        if (name == null) {
            throw new NullPointerException("name");
        }
        synchronized (this) {
            ensureOpen();
            long jzentry = getEntry(this.jzfile, this.f50536zc.getBytes(name), true);
            if (jzentry != 0) {
                ZipEntry ze = getZipEntry(name, jzentry);
                freeEntry(this.jzfile, jzentry);
                return ze;
            }
            return null;
        }
    }

    public InputStream getInputStream(ZipEntry entry) throws IOException {
        long jzentry;
        if (entry == null) {
            throw new NullPointerException("entry");
        }
        synchronized (this) {
            ensureOpen();
            if (!this.f50536zc.isUTF8() && (entry.flag & 2048) != 0) {
                jzentry = getEntry(this.jzfile, this.f50536zc.getBytesUTF8(entry.name), true);
            } else {
                jzentry = getEntry(this.jzfile, this.f50536zc.getBytes(entry.name), true);
            }
            if (jzentry == 0) {
                return null;
            }
            ZipFileInputStream in = new ZipFileInputStream(jzentry);
            switch (getEntryMethod(jzentry)) {
                case 0:
                    synchronized (this.streams) {
                        this.streams.put(in, null);
                    }
                    return in;
                case 8:
                    long size = getEntrySize(jzentry) + 2;
                    if (size > 65536) {
                        size = 65536;
                    }
                    if (size <= 0) {
                        size = 4096;
                    }
                    Inflater inf = getInflater();
                    InputStream is = new ZipFileInflaterInputStream(in, inf, (int) size);
                    synchronized (this.streams) {
                        this.streams.put(is, inf);
                    }
                    return is;
                default:
                    throw new ZipException("invalid compression method");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class ZipFileInflaterInputStream extends InflaterInputStream {
        private volatile boolean closeRequested;
        private boolean eof;
        private final ZipFileInputStream zfin;

        ZipFileInflaterInputStream(ZipFileInputStream zfin, Inflater inf, int size) {
            super(zfin, inf, size);
            this.closeRequested = false;
            this.eof = false;
            this.zfin = zfin;
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Inflater inf;
            if (this.closeRequested) {
                return;
            }
            this.closeRequested = true;
            super.close();
            synchronized (ZipFile.this.streams) {
                inf = (Inflater) ZipFile.this.streams.remove(this);
            }
            if (inf != null) {
                ZipFile.this.releaseInflater(inf);
            }
        }

        @Override // java.util.zip.InflaterInputStream
        protected void fill() throws IOException {
            if (this.eof) {
                throw new EOFException("Unexpected end of ZLIB input stream");
            }
            this.len = this.in.read(this.buf, 0, this.buf.length);
            if (this.len == -1) {
                this.buf[0] = 0;
                this.len = 1;
                this.eof = true;
            }
            this.inf.setInput(this.buf, 0, this.len);
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            if (this.closeRequested) {
                return 0;
            }
            long avail = this.zfin.size() - this.inf.getBytesWritten();
            if (avail > ZipUtils.UPPER_UNIXTIME_BOUND) {
                return Integer.MAX_VALUE;
            }
            return (int) avail;
        }

        protected void finalize() throws Throwable {
            close();
        }
    }

    private Inflater getInflater() {
        Inflater inf;
        synchronized (this.inflaterCache) {
            do {
                inf = this.inflaterCache.poll();
                if (inf == null) {
                    return new Inflater(true);
                }
            } while (inf.ended());
            return inf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseInflater(Inflater inf) {
        if (!inf.ended()) {
            inf.reset();
            synchronized (this.inflaterCache) {
                this.inflaterCache.add(inf);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class ZipEntryIterator implements Enumeration<ZipEntry>, Iterator<ZipEntry> {

        /* renamed from: i, reason: collision with root package name */
        private int f50537i = 0;

        public ZipEntryIterator() {
            ZipFile.this.ensureOpen();
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return hasNext();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            boolean z10;
            synchronized (ZipFile.this) {
                ZipFile.this.ensureOpen();
                z10 = this.f50537i < ZipFile.this.total;
            }
            return z10;
        }

        @Override // java.util.Enumeration
        public ZipEntry nextElement() {
            return next();
        }

        @Override // java.util.Iterator
        public ZipEntry next() {
            ZipEntry ze;
            String message;
            synchronized (ZipFile.this) {
                ZipFile.this.ensureOpen();
                if (this.f50537i >= ZipFile.this.total) {
                    throw new NoSuchElementException();
                }
                long j10 = ZipFile.this.jzfile;
                int i10 = this.f50537i;
                this.f50537i = i10 + 1;
                long jzentry = ZipFile.getNextEntry(j10, i10);
                if (jzentry == 0) {
                    if (ZipFile.this.closeRequested) {
                        message = "ZipFile concurrently closed";
                    } else {
                        message = ZipFile.getZipMessage(ZipFile.this.jzfile);
                    }
                    throw new ZipError("jzentry == 0,\n jzfile = " + ZipFile.this.jzfile + ",\n total = " + ZipFile.this.total + ",\n name = " + ZipFile.this.name + ",\n i = " + this.f50537i + ",\n message = " + message);
                }
                ze = ZipFile.this.getZipEntry(null, jzentry);
                ZipFile.freeEntry(ZipFile.this.jzfile, jzentry);
            }
            return ze;
        }
    }

    public Enumeration<? extends ZipEntry> entries() {
        return new ZipEntryIterator();
    }

    public Stream<? extends ZipEntry> stream() {
        return StreamSupport.stream(Spliterators.spliterator(new ZipEntryIterator(), size(), MetricsProto.MetricsEvent.ACTION_OUTPUT_CHOOSER_DISCONNECT), false);
    }

    private void onZipEntryAccess(byte[] bname, int flag) throws ZipException {
        String name;
        if (!this.f50536zc.isUTF8() && (flag & 2048) != 0) {
            name = this.f50536zc.toStringUTF8(bname, bname.length);
        } else {
            name = this.f50536zc.toString(bname, bname.length);
        }
        ZipPathValidator.getInstance().onZipEntryAccess(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ZipEntry getZipEntry(String name, long jzentry) {
        ZipEntry e2 = new ZipEntry();
        e2.flag = getEntryFlag(jzentry);
        if (name != null) {
            e2.name = name;
        } else {
            byte[] bname = getEntryBytes(jzentry, 0);
            if (!this.f50536zc.isUTF8() && (e2.flag & 2048) != 0) {
                e2.name = this.f50536zc.toStringUTF8(bname, bname.length);
            } else {
                e2.name = this.f50536zc.toString(bname, bname.length);
            }
        }
        e2.xdostime = getEntryTime(jzentry);
        e2.crc = getEntryCrc(jzentry);
        e2.size = getEntrySize(jzentry);
        e2.csize = getEntryCSize(jzentry);
        e2.method = getEntryMethod(jzentry);
        e2.setExtra0(getEntryBytes(jzentry, 1), false);
        byte[] bcomm = getEntryBytes(jzentry, 2);
        if (bcomm == null) {
            e2.comment = null;
        } else if (!this.f50536zc.isUTF8() && (e2.flag & 2048) != 0) {
            e2.comment = this.f50536zc.toStringUTF8(bcomm, bcomm.length);
        } else {
            e2.comment = this.f50536zc.toString(bcomm, bcomm.length);
        }
        return e2;
    }

    public int size() {
        ensureOpen();
        return this.total;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closeRequested) {
            return;
        }
        CloseGuard closeGuard = this.guard;
        if (closeGuard != null) {
            closeGuard.close();
        }
        this.closeRequested = true;
        synchronized (this) {
            Map<InputStream, Inflater> map = this.streams;
            if (map != null) {
                synchronized (map) {
                    if (!this.streams.isEmpty()) {
                        Map<InputStream, Inflater> copy = new HashMap<>(this.streams);
                        this.streams.clear();
                        for (Map.Entry<InputStream, Inflater> e2 : copy.entrySet()) {
                            e2.getKey().close();
                            Inflater inf = e2.getValue();
                            if (inf != null) {
                                inf.end();
                            }
                        }
                    }
                }
            }
            Deque<Inflater> deque = this.inflaterCache;
            if (deque != null) {
                synchronized (deque) {
                    while (true) {
                        Inflater inf2 = this.inflaterCache.poll();
                        if (inf2 == null) {
                            break;
                        } else {
                            inf2.end();
                        }
                    }
                }
            }
            long zf = this.jzfile;
            if (zf != 0) {
                this.jzfile = 0L;
                close(zf);
            }
            File file = this.fileToRemoveOnClose;
            if (file != null) {
                file.delete();
            }
        }
    }

    protected void finalize() throws IOException {
        CloseGuard closeGuard = this.guard;
        if (closeGuard != null) {
            closeGuard.warnIfOpen();
        }
        close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureOpen() {
        if (this.closeRequested) {
            throw new IllegalStateException("zip file closed");
        }
        if (this.jzfile == 0) {
            throw new IllegalStateException("The object is not initialized.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureOpenOrZipException() throws IOException {
        if (this.closeRequested) {
            throw new ZipException("ZipFile closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class ZipFileInputStream extends InputStream {
        protected long jzentry;
        protected long rem;
        protected long size;
        private volatile boolean zfisCloseRequested = false;
        private long pos = 0;

        ZipFileInputStream(long jzentry) {
            this.rem = ZipFile.getEntryCSize(jzentry);
            this.size = ZipFile.getEntrySize(jzentry);
            this.jzentry = jzentry;
        }

        @Override // java.io.InputStream
        public int read(byte[] b4, int off, int len) throws IOException {
            int len2 = len;
            ZipFile.this.ensureOpenOrZipException();
            synchronized (ZipFile.this) {
                try {
                    try {
                        long rem = this.rem;
                        long pos = this.pos;
                        if (rem == 0) {
                            return -1;
                        }
                        if (len2 <= 0) {
                            return 0;
                        }
                        if (len2 > rem) {
                            len2 = (int) rem;
                        }
                        int len3 = ZipFile.read(ZipFile.this.jzfile, this.jzentry, pos, b4, off, len2);
                        if (len3 > 0) {
                            this.pos = len3 + pos;
                            this.rem = rem - len3;
                        }
                        if (this.rem == 0) {
                            close();
                        }
                        return len3;
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            byte[] b4 = new byte[1];
            if (read(b4, 0, 1) == 1) {
                return b4[0] & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public long skip(long n10) {
            long j10 = this.rem;
            if (n10 > j10) {
                n10 = this.rem;
            }
            this.pos += n10;
            long j11 = j10 - n10;
            this.rem = j11;
            if (j11 == 0) {
                close();
            }
            return n10;
        }

        @Override // java.io.InputStream
        public int available() {
            long j10 = this.rem;
            if (j10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
                return Integer.MAX_VALUE;
            }
            return (int) j10;
        }

        public long size() {
            return this.size;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.zfisCloseRequested) {
                return;
            }
            this.zfisCloseRequested = true;
            this.rem = 0L;
            synchronized (ZipFile.this) {
                if (this.jzentry != 0 && ZipFile.this.jzfile != 0) {
                    ZipFile.freeEntry(ZipFile.this.jzfile, this.jzentry);
                    this.jzentry = 0L;
                }
            }
            synchronized (ZipFile.this.streams) {
                ZipFile.this.streams.remove(this);
            }
        }

        protected void finalize() {
            close();
        }
    }

    public boolean startsWithLocHeader() {
        return this.locsig;
    }

    public int getFileDescriptor() {
        return getFileDescriptor(this.jzfile);
    }
}
