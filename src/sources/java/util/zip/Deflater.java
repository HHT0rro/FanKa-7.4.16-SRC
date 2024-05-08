package java.util.zip;

import dalvik.annotation.optimization.ReachabilitySensitive;
import dalvik.system.CloseGuard;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Deflater {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BEST_COMPRESSION = 9;
    public static final int BEST_SPEED = 1;
    public static final int DEFAULT_COMPRESSION = -1;
    public static final int DEFAULT_STRATEGY = 0;
    public static final int DEFLATED = 8;
    public static final int FILTERED = 1;
    public static final int FULL_FLUSH = 3;
    public static final int HUFFMAN_ONLY = 2;
    public static final int NO_COMPRESSION = 0;
    public static final int NO_FLUSH = 0;
    public static final int SYNC_FLUSH = 2;
    private byte[] buf;
    private long bytesRead;
    private long bytesWritten;
    private boolean finish;
    private boolean finished;

    @ReachabilitySensitive
    private final CloseGuard guard;
    private int len;
    private int level;
    private int off;
    private boolean setParams;
    private int strategy;

    @ReachabilitySensitive
    private final ZStreamRef zsRef;

    private native int deflateBytes(long j10, byte[] bArr, int i10, int i11, int i12);

    private static native void end(long j10);

    private static native int getAdler(long j10);

    private static native long init(int i10, int i11, boolean z10);

    private static native void reset(long j10);

    private static native void setDictionary(long j10, byte[] bArr, int i10, int i11);

    public Deflater(int level, boolean nowrap) {
        this.buf = new byte[0];
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.level = level;
        this.strategy = 0;
        this.zsRef = new ZStreamRef(init(level, 0, nowrap));
        closeGuard.open("end");
    }

    public Deflater(int level) {
        this(level, false);
    }

    public Deflater() {
        this(-1, false);
    }

    public void setInput(byte[] b4, int off, int len) {
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || off > b4.length - len) {
            throw new ArrayIndexOutOfBoundsException();
        }
        synchronized (this.zsRef) {
            this.buf = b4;
            this.off = off;
            this.len = len;
        }
    }

    public void setInput(byte[] b4) {
        setInput(b4, 0, b4.length);
    }

    public void setDictionary(byte[] b4, int off, int len) {
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || off > b4.length - len) {
            throw new ArrayIndexOutOfBoundsException();
        }
        synchronized (this.zsRef) {
            ensureOpen();
            setDictionary(this.zsRef.address(), b4, off, len);
        }
    }

    public void setDictionary(byte[] b4) {
        setDictionary(b4, 0, b4.length);
    }

    public void setStrategy(int strategy) {
        switch (strategy) {
            case 0:
            case 1:
            case 2:
                synchronized (this.zsRef) {
                    if (this.strategy != strategy) {
                        this.strategy = strategy;
                        this.setParams = true;
                    }
                }
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void setLevel(int level) {
        if ((level < 0 || level > 9) && level != -1) {
            throw new IllegalArgumentException("invalid compression level");
        }
        synchronized (this.zsRef) {
            if (this.level != level) {
                this.level = level;
                this.setParams = true;
            }
        }
    }

    public boolean needsInput() {
        boolean z10;
        synchronized (this.zsRef) {
            z10 = this.len <= 0;
        }
        return z10;
    }

    public void finish() {
        synchronized (this.zsRef) {
            this.finish = true;
        }
    }

    public boolean finished() {
        boolean z10;
        synchronized (this.zsRef) {
            z10 = this.finished;
        }
        return z10;
    }

    public int deflate(byte[] b4, int off, int len) {
        return deflate(b4, off, len, 0);
    }

    public int deflate(byte[] b4) {
        return deflate(b4, 0, b4.length, 0);
    }

    public int deflate(byte[] b4, int off, int len, int flush) {
        int n10;
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || off > b4.length - len) {
            throw new ArrayIndexOutOfBoundsException();
        }
        synchronized (this.zsRef) {
            ensureOpen();
            if (flush != 0 && flush != 2 && flush != 3) {
                throw new IllegalArgumentException();
            }
            int thisLen = this.len;
            n10 = deflateBytes(this.zsRef.address(), b4, off, len, flush);
            this.bytesWritten += n10;
            this.bytesRead += thisLen - this.len;
        }
        return n10;
    }

    public int getAdler() {
        int adler;
        synchronized (this.zsRef) {
            ensureOpen();
            adler = getAdler(this.zsRef.address());
        }
        return adler;
    }

    public int getTotalIn() {
        return (int) getBytesRead();
    }

    public long getBytesRead() {
        long j10;
        synchronized (this.zsRef) {
            ensureOpen();
            j10 = this.bytesRead;
        }
        return j10;
    }

    public int getTotalOut() {
        return (int) getBytesWritten();
    }

    public long getBytesWritten() {
        long j10;
        synchronized (this.zsRef) {
            ensureOpen();
            j10 = this.bytesWritten;
        }
        return j10;
    }

    public void reset() {
        synchronized (this.zsRef) {
            ensureOpen();
            reset(this.zsRef.address());
            this.finish = false;
            this.finished = false;
            this.len = 0;
            this.off = 0;
            this.bytesWritten = 0L;
            this.bytesRead = 0L;
        }
    }

    public void end() {
        synchronized (this.zsRef) {
            this.guard.close();
            long addr = this.zsRef.address();
            this.zsRef.clear();
            if (addr != 0) {
                end(addr);
                this.buf = null;
            }
        }
    }

    protected void finalize() {
        CloseGuard closeGuard = this.guard;
        if (closeGuard != null) {
            closeGuard.warnIfOpen();
        }
        end();
    }

    private void ensureOpen() {
        if (this.zsRef.address() == 0) {
            throw new NullPointerException("Deflater has been closed");
        }
    }
}
