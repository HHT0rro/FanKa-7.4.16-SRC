package java.util.zip;

import dalvik.annotation.optimization.ReachabilitySensitive;
import dalvik.system.CloseGuard;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Inflater {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] defaultBuf = new byte[0];
    private byte[] buf;
    private long bytesRead;
    private long bytesWritten;
    private boolean finished;

    @ReachabilitySensitive
    private final CloseGuard guard;
    private int len;
    private boolean needDict;
    private int off;

    @ReachabilitySensitive
    private final ZStreamRef zsRef;

    private static native void end(long j10);

    private static native int getAdler(long j10);

    private native int inflateBytes(long j10, byte[] bArr, int i10, int i11) throws DataFormatException;

    private static native long init(boolean z10);

    private static native void reset(long j10);

    private static native void setDictionary(long j10, byte[] bArr, int i10, int i11);

    public Inflater(boolean nowrap) {
        this.buf = defaultBuf;
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.zsRef = new ZStreamRef(init(nowrap));
        closeGuard.open("end");
    }

    public Inflater() {
        this(false);
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
            this.needDict = false;
        }
    }

    public void setDictionary(byte[] b4) {
        setDictionary(b4, 0, b4.length);
    }

    public int getRemaining() {
        int i10;
        synchronized (this.zsRef) {
            i10 = this.len;
        }
        return i10;
    }

    public boolean needsInput() {
        boolean z10;
        synchronized (this.zsRef) {
            z10 = this.len <= 0;
        }
        return z10;
    }

    public boolean needsDictionary() {
        boolean z10;
        synchronized (this.zsRef) {
            z10 = this.needDict;
        }
        return z10;
    }

    public boolean finished() {
        boolean z10;
        synchronized (this.zsRef) {
            z10 = this.finished;
        }
        return z10;
    }

    public int inflate(byte[] b4, int off, int len) throws DataFormatException {
        int n10;
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || off > b4.length - len) {
            throw new ArrayIndexOutOfBoundsException();
        }
        synchronized (this.zsRef) {
            ensureOpen();
            int thisLen = this.len;
            n10 = inflateBytes(this.zsRef.address(), b4, off, len);
            this.bytesWritten += n10;
            this.bytesRead += thisLen - this.len;
        }
        return n10;
    }

    public int inflate(byte[] b4) throws DataFormatException {
        return inflate(b4, 0, b4.length);
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
            this.buf = defaultBuf;
            this.finished = false;
            this.needDict = false;
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
            throw new NullPointerException("Inflater has been closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ended() {
        boolean z10;
        synchronized (this.zsRef) {
            z10 = this.zsRef.address() == 0;
        }
        return z10;
    }
}
