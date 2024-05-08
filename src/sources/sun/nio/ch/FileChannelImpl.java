package sun.nio.ch;

import android.support.v4.media.session.PlaybackStateCompat;
import dalvik.annotation.optimization.ReachabilitySensitive;
import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.NonReadableChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.OverlappingFileLockException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.WritableByteChannel;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipUtils;
import sun.misc.Cleaner;
import sun.security.action.GetPropertyAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FileChannelImpl extends FileChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long MAPPED_TRANSFER_SIZE = 8388608;
    private static final int MAP_PV = 2;
    private static final int MAP_RO = 0;
    private static final int MAP_RW = 1;
    private static final int TRANSFER_SIZE = 8192;
    private static boolean isSharedFileLockTable;
    private static volatile boolean propertyChecked;
    private final boolean append;

    /* renamed from: fd, reason: collision with root package name */
    @ReachabilitySensitive
    public final FileDescriptor f53720fd;
    private volatile FileLockTable fileLockTable;

    @ReachabilitySensitive
    private final CloseGuard guard;

    /* renamed from: nd, reason: collision with root package name */
    private final FileDispatcher f53721nd;
    private final Object parent;
    private final String path;
    private final boolean readable;
    private final boolean writable;
    private static volatile boolean transferSupported = true;
    private static volatile boolean pipeSupported = true;
    private static volatile boolean fileSupported = true;
    private static final long allocationGranularity = initIDs();
    private final NativeThreadSet threads = new NativeThreadSet(2);
    private final Object positionLock = new Object();

    private static native long initIDs();

    private native long map0(int i10, long j10, long j11) throws IOException;

    private native long position0(FileDescriptor fileDescriptor, long j10);

    private native long transferTo0(FileDescriptor fileDescriptor, long j10, long j11, FileDescriptor fileDescriptor2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int unmap0(long j10, long j11);

    private FileChannelImpl(FileDescriptor fd2, String path, boolean readable, boolean writable, boolean append, Object parent) {
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.f53720fd = fd2;
        this.readable = readable;
        this.writable = writable;
        this.append = append;
        this.parent = parent;
        this.path = path;
        this.f53721nd = new FileDispatcherImpl(append);
        if (fd2 != null && fd2.valid()) {
            closeGuard.open("close");
        }
    }

    public static FileChannel open(FileDescriptor fd2, String path, boolean readable, boolean writable, Object parent) {
        return new FileChannelImpl(fd2, path, readable, writable, false, parent);
    }

    public static FileChannel open(FileDescriptor fd2, String path, boolean readable, boolean writable, boolean append, Object parent) {
        return new FileChannelImpl(fd2, path, readable, writable, append, parent);
    }

    private void ensureOpen() throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    @Override // java.nio.channels.spi.AbstractInterruptibleChannel
    protected void implCloseChannel() throws IOException {
        this.guard.close();
        if (this.fileLockTable != null) {
            for (FileLock fl : this.fileLockTable.removeAll()) {
                synchronized (fl) {
                    if (fl.isValid()) {
                        this.f53721nd.release(this.f53720fd, fl.position(), fl.size());
                        ((FileLockImpl) fl).invalidate();
                    }
                }
            }
        }
        this.threads.signalAndWait();
        Object obj = this.parent;
        if (obj != null) {
            ((Closeable) obj).close();
        } else {
            this.f53721nd.close(this.f53720fd);
        }
    }

    protected void finalize() throws Throwable {
        try {
            CloseGuard closeGuard = this.guard;
            if (closeGuard != null) {
                closeGuard.warnIfOpen();
            }
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // java.nio.channels.FileChannel, java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer dst) throws IOException {
        ensureOpen();
        if (!this.readable) {
            throw new NonReadableChannelException();
        }
        synchronized (this.positionLock) {
            int n10 = 0;
            int ti = -1;
            boolean z10 = true;
            try {
                begin();
                ti = this.threads.add();
                if (!isOpen()) {
                    return 0;
                }
                do {
                    n10 = IOUtil.read(this.f53720fd, dst, -1L, this.f53721nd);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
                int normalize = IOStatus.normalize(n10);
                this.threads.remove(ti);
                if (n10 <= 0) {
                    z10 = false;
                }
                end(z10);
                return normalize;
            } finally {
                this.threads.remove(ti);
                if (n10 <= 0) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    @Override // java.nio.channels.FileChannel, java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
        if (offset < 0 || length < 0 || offset > dsts.length - length) {
            throw new IndexOutOfBoundsException();
        }
        ensureOpen();
        if (!this.readable) {
            throw new NonReadableChannelException();
        }
        synchronized (this.positionLock) {
            long n10 = 0;
            int ti = -1;
            boolean z10 = true;
            try {
                begin();
                ti = this.threads.add();
                if (!isOpen()) {
                    return 0L;
                }
                do {
                    n10 = IOUtil.read(this.f53720fd, dsts, offset, length, this.f53721nd);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
                long normalize = IOStatus.normalize(n10);
                this.threads.remove(ti);
                if (n10 <= 0) {
                    z10 = false;
                }
                end(z10);
                return normalize;
            } finally {
                this.threads.remove(ti);
                if (n10 <= 0) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    @Override // java.nio.channels.FileChannel, java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer src) throws IOException {
        ensureOpen();
        if (!this.writable) {
            throw new NonWritableChannelException();
        }
        synchronized (this.positionLock) {
            int n10 = 0;
            int ti = -1;
            boolean z10 = true;
            try {
                begin();
                ti = this.threads.add();
                if (!isOpen()) {
                    return 0;
                }
                do {
                    n10 = IOUtil.write(this.f53720fd, src, -1L, this.f53721nd);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
                int normalize = IOStatus.normalize(n10);
                this.threads.remove(ti);
                if (n10 <= 0) {
                    z10 = false;
                }
                end(z10);
                return normalize;
            } finally {
                this.threads.remove(ti);
                if (n10 <= 0) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    @Override // java.nio.channels.FileChannel, java.nio.channels.GatheringByteChannel
    public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
        if (offset < 0 || length < 0 || offset > srcs.length - length) {
            throw new IndexOutOfBoundsException();
        }
        ensureOpen();
        if (!this.writable) {
            throw new NonWritableChannelException();
        }
        synchronized (this.positionLock) {
            long n10 = 0;
            int ti = -1;
            boolean z10 = true;
            try {
                begin();
                ti = this.threads.add();
                if (!isOpen()) {
                    return 0L;
                }
                do {
                    n10 = IOUtil.write(this.f53720fd, srcs, offset, length, this.f53721nd);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
                long normalize = IOStatus.normalize(n10);
                this.threads.remove(ti);
                if (n10 <= 0) {
                    z10 = false;
                }
                end(z10);
                return normalize;
            } finally {
                this.threads.remove(ti);
                if (n10 <= 0) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    @Override // java.nio.channels.FileChannel, java.nio.channels.SeekableByteChannel
    public long position() throws IOException {
        ensureOpen();
        synchronized (this.positionLock) {
            long p10 = -1;
            int ti = -1;
            boolean z10 = true;
            try {
                begin();
                ti = this.threads.add();
                if (isOpen()) {
                    if (this.append) {
                        BlockGuard.getThreadPolicy().onWriteToDisk();
                    }
                    do {
                        p10 = this.append ? this.f53721nd.size(this.f53720fd) : position0(this.f53720fd, -1L);
                        if (p10 != -3) {
                            break;
                        }
                    } while (isOpen());
                    return IOStatus.normalize(p10);
                }
                this.threads.remove(ti);
                if (-1 <= -1) {
                    z10 = false;
                }
                end(z10);
                return 0L;
            } finally {
                this.threads.remove(ti);
                if (p10 <= -1) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    @Override // java.nio.channels.FileChannel, java.nio.channels.SeekableByteChannel
    public FileChannel position(long newPosition) throws IOException {
        ensureOpen();
        if (newPosition < 0) {
            throw new IllegalArgumentException();
        }
        synchronized (this.positionLock) {
            long p10 = -1;
            int ti = -1;
            boolean z10 = true;
            try {
                begin();
                ti = this.threads.add();
                if (isOpen()) {
                    BlockGuard.getThreadPolicy().onReadFromDisk();
                    do {
                        p10 = position0(this.f53720fd, newPosition);
                        if (p10 != -3) {
                            break;
                        }
                    } while (isOpen());
                    return this;
                }
                this.threads.remove(ti);
                if (-1 <= -1) {
                    z10 = false;
                }
                end(z10);
                return null;
            } finally {
                this.threads.remove(ti);
                if (p10 <= -1) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    @Override // java.nio.channels.FileChannel, java.nio.channels.SeekableByteChannel
    public long size() throws IOException {
        ensureOpen();
        synchronized (this.positionLock) {
            long s2 = -1;
            int ti = -1;
            boolean z10 = true;
            try {
                begin();
                ti = this.threads.add();
                if (!isOpen()) {
                    return -1L;
                }
                do {
                    s2 = this.f53721nd.size(this.f53720fd);
                    if (s2 != -3) {
                        break;
                    }
                } while (isOpen());
                long normalize = IOStatus.normalize(s2);
                this.threads.remove(ti);
                if (s2 <= -1) {
                    z10 = false;
                }
                end(z10);
                return normalize;
            } finally {
                this.threads.remove(ti);
                if (s2 <= -1) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0092, code lost:
    
        if (r20 < r15) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0094, code lost:
    
        r5 = r19.f53721nd.truncate(r19.f53720fd, r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009e, code lost:
    
        if (r5 != (-3)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a4, code lost:
    
        if (isOpen() != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00aa, code lost:
    
        if (isOpen() != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ad, code lost:
    
        r19.threads.remove(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b2, code lost:
    
        if (r5 <= (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b4, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b7, code lost:
    
        end(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00bb, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b6, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00be, code lost:
    
        if (r6 <= r20) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c0, code lost:
    
        r6 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c2, code lost:
    
        r11 = position0(r19.f53720fd, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00cb, code lost:
    
        if (r11 != (-3)) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d1, code lost:
    
        if (isOpen() != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d4, code lost:
    
        r19.threads.remove(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00d9, code lost:
    
        if (r5 <= (-1)) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00db, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00de, code lost:
    
        end(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00e2, code lost:
    
        return r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00dd, code lost:
    
        r11 = false;
     */
    @Override // java.nio.channels.FileChannel, java.nio.channels.SeekableByteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.nio.channels.FileChannel truncate(long r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.truncate(long):java.nio.channels.FileChannel");
    }

    @Override // java.nio.channels.FileChannel
    public void force(boolean metaData) throws IOException {
        ensureOpen();
        int rv = -1;
        int ti = -1;
        try {
            begin();
            ti = this.threads.add();
            if (!isOpen()) {
                return;
            }
            do {
                rv = this.f53721nd.force(this.f53720fd, metaData);
                if (rv != -3) {
                    break;
                }
            } while (isOpen());
            this.threads.remove(ti);
            end(rv > -1);
        } finally {
            this.threads.remove(ti);
            end(rv > -1);
        }
    }

    private long transferToDirectlyInternal(long position, int icount, WritableByteChannel target, FileDescriptor targetFD) throws IOException {
        long n10 = -1;
        int ti = -1;
        try {
            begin();
            int ti2 = this.threads.add();
            try {
                if (!isOpen()) {
                    this.threads.remove(ti2);
                    end(-1 > -1);
                    return -1L;
                }
                BlockGuard.getThreadPolicy().onWriteToDisk();
                long n11 = -1;
                do {
                    try {
                        n11 = transferTo0(this.f53720fd, position, icount, targetFD);
                        if (n11 != -3) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        ti = ti2;
                        n10 = n11;
                        this.threads.remove(ti);
                        end(n10 > -1);
                        throw th;
                    }
                } while (isOpen());
                if (n11 == -6) {
                    if (target instanceof SinkChannelImpl) {
                        pipeSupported = false;
                    }
                    if (target instanceof FileChannelImpl) {
                        fileSupported = false;
                    }
                    this.threads.remove(ti2);
                    end(n11 > -1);
                    return -6L;
                }
                if (n11 == -4) {
                    transferSupported = false;
                    this.threads.remove(ti2);
                    end(n11 > -1);
                    return -4L;
                }
                long normalize = IOStatus.normalize(n11);
                this.threads.remove(ti2);
                end(n11 > -1);
                return normalize;
            } catch (Throwable th2) {
                th = th2;
                ti = ti2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long transferToDirectly(long position, int icount, WritableByteChannel writableByteChannel) throws IOException {
        FileDescriptor targetFD;
        long transferToDirectlyInternal;
        if (!transferSupported) {
            return -4L;
        }
        if (writableByteChannel instanceof FileChannelImpl) {
            if (!fileSupported) {
                return -6L;
            }
            FileDescriptor targetFD2 = ((FileChannelImpl) writableByteChannel).f53720fd;
            targetFD = targetFD2;
        } else if (!(writableByteChannel instanceof SelChImpl)) {
            targetFD = null;
        } else {
            if ((writableByteChannel instanceof SinkChannelImpl) && !pipeSupported) {
                return -6L;
            }
            SelectableChannel sc2 = (SelectableChannel) writableByteChannel;
            if (!this.f53721nd.canTransferToDirectly(sc2)) {
                return -6L;
            }
            FileDescriptor targetFD3 = ((SelChImpl) writableByteChannel).getFD();
            targetFD = targetFD3;
        }
        if (targetFD == null) {
            return -4L;
        }
        int thisFDVal = IOUtil.fdVal(this.f53720fd);
        int targetFDVal = IOUtil.fdVal(targetFD);
        if (thisFDVal == targetFDVal) {
            return -4L;
        }
        if (this.f53721nd.transferToDirectlyNeedsPositionLock()) {
            synchronized (this.positionLock) {
                long pos = position();
                try {
                    transferToDirectlyInternal = transferToDirectlyInternal(position, icount, writableByteChannel, targetFD);
                } finally {
                    position(pos);
                }
            }
            return transferToDirectlyInternal;
        }
        return transferToDirectlyInternal(position, icount, writableByteChannel, targetFD);
    }

    /* JADX WARN: Finally extract failed */
    private long transferToTrustedChannel(long position, long count, WritableByteChannel target) throws IOException {
        boolean isSelChImpl = target instanceof SelChImpl;
        if (!(target instanceof FileChannelImpl) && !isSelChImpl) {
            return -4L;
        }
        long remaining = count;
        long position2 = position;
        while (true) {
            if (remaining <= 0) {
                break;
            }
            long size = Math.min(remaining, MAPPED_TRANSFER_SIZE);
            try {
                MappedByteBuffer dbb = map(FileChannel.MapMode.READ_ONLY, position2, size);
                try {
                    int n10 = target.write(dbb);
                    remaining -= n10;
                    if (!isSelChImpl) {
                        position2 += n10;
                        unmap(dbb);
                    } else {
                        unmap(dbb);
                        break;
                    }
                } catch (Throwable th) {
                    unmap(dbb);
                    throw th;
                }
            } catch (ClosedByInterruptException e2) {
                try {
                    close();
                    throw e2;
                } catch (Throwable suppressed) {
                    e2.addSuppressed(suppressed);
                    throw e2;
                }
            } catch (IOException ioe) {
                if (remaining == count) {
                    throw ioe;
                }
            }
        }
        return count - remaining;
    }

    private long transferToArbitraryChannel(long position, int icount, WritableByteChannel target) throws IOException {
        int c4 = Math.min(icount, 8192);
        ByteBuffer bb2 = Util.getTemporaryDirectBuffer(c4);
        long tw = 0;
        long pos = position;
        try {
            Util.erase(bb2);
            while (tw < icount) {
                bb2.limit(Math.min((int) (icount - tw), 8192));
                int nr = read(bb2, pos);
                if (nr <= 0) {
                    break;
                }
                bb2.flip();
                int nw = target.write(bb2);
                tw += nw;
                if (nw != nr) {
                    break;
                }
                pos += nw;
                bb2.clear();
            }
            return tw;
        } catch (IOException x10) {
            if (tw > 0) {
                return tw;
            }
            throw x10;
        } finally {
            Util.releaseTemporaryDirectBuffer(bb2);
        }
    }

    @Override // java.nio.channels.FileChannel
    public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
        int icount;
        ensureOpen();
        if (!target.isOpen()) {
            throw new ClosedChannelException();
        }
        if (!this.readable) {
            throw new NonReadableChannelException();
        }
        if ((target instanceof FileChannelImpl) && !((FileChannelImpl) target).writable) {
            throw new NonWritableChannelException();
        }
        if (position < 0 || count < 0) {
            throw new IllegalArgumentException();
        }
        long sz = size();
        if (position > sz) {
            return 0L;
        }
        int icount2 = (int) Math.min(count, ZipUtils.UPPER_UNIXTIME_BOUND);
        if (sz - position >= icount2) {
            icount = icount2;
        } else {
            icount = (int) (sz - position);
        }
        long n10 = transferToDirectly(position, icount, target);
        if (n10 >= 0) {
            return n10;
        }
        int icount3 = icount;
        long n11 = transferToTrustedChannel(position, icount, target);
        return n11 >= 0 ? n11 : transferToArbitraryChannel(position, icount3, target);
    }

    private long transferFromFileChannel(FileChannelImpl src, long position, long count) throws IOException {
        long remaining;
        long position2;
        MappedByteBuffer bb2;
        if (!src.readable) {
            throw new NonReadableChannelException();
        }
        synchronized (src.positionLock) {
            try {
                long pos = src.position();
                long remaining2 = Math.min(count, src.size() - pos);
                long p10 = pos;
                long position3 = position;
                long remaining3 = remaining2;
                while (remaining3 > 0) {
                    try {
                        long size = Math.min(remaining3, MAPPED_TRANSFER_SIZE);
                        remaining = remaining3;
                        position2 = position3;
                        long position4 = p10;
                        try {
                            bb2 = src.map(FileChannel.MapMode.READ_ONLY, position4, size);
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        try {
                            long n10 = write(bb2, position2);
                            p10 += n10;
                            long position5 = position2 + n10;
                            long remaining4 = remaining - n10;
                            try {
                                unmap(bb2);
                                position3 = position5;
                                remaining3 = remaining4;
                            } catch (Throwable th3) {
                                th = th3;
                                throw th;
                            }
                        } catch (IOException ioe) {
                            if (remaining == remaining2) {
                                throw ioe;
                            }
                            unmap(bb2);
                        }
                    } finally {
                        unmap(bb2);
                    }
                }
                remaining = remaining3;
                long nwritten = remaining2 - remaining;
                src.position(pos + nwritten);
                return nwritten;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    private long transferFromArbitraryChannel(ReadableByteChannel src, long position, long count) throws IOException {
        int c4 = (int) Math.min(count, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        ByteBuffer bb2 = Util.getTemporaryDirectBuffer(c4);
        long tw = 0;
        long pos = position;
        try {
            Util.erase(bb2);
            while (tw < count) {
                bb2.limit((int) Math.min(count - tw, PlaybackStateCompat.ACTION_PLAY_FROM_URI));
                try {
                    int nr = src.read(bb2);
                    if (nr <= 0) {
                        break;
                    }
                    bb2.flip();
                    try {
                        try {
                            int nw = write(bb2, pos);
                            tw += nw;
                            if (nw != nr) {
                                break;
                            }
                            pos += nw;
                            bb2.clear();
                        } catch (Throwable th) {
                            x = th;
                            Util.releaseTemporaryDirectBuffer(bb2);
                            throw x;
                        }
                    } catch (IOException e2) {
                        x = e2;
                        if (tw <= 0) {
                            throw x;
                        }
                        Util.releaseTemporaryDirectBuffer(bb2);
                        return tw;
                    }
                } catch (IOException e10) {
                    x = e10;
                } catch (Throwable th2) {
                    x = th2;
                    Util.releaseTemporaryDirectBuffer(bb2);
                    throw x;
                }
            }
            Util.releaseTemporaryDirectBuffer(bb2);
            return tw;
        } catch (IOException e11) {
            x = e11;
        } catch (Throwable th3) {
            x = th3;
        }
    }

    @Override // java.nio.channels.FileChannel
    public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
        ensureOpen();
        if (!src.isOpen()) {
            throw new ClosedChannelException();
        }
        if (!this.writable) {
            throw new NonWritableChannelException();
        }
        if (position < 0 || count < 0) {
            throw new IllegalArgumentException();
        }
        if (position > size()) {
            return 0L;
        }
        if (src instanceof FileChannelImpl) {
            return transferFromFileChannel((FileChannelImpl) src, position, count);
        }
        return transferFromArbitraryChannel(src, position, count);
    }

    @Override // java.nio.channels.FileChannel
    public int read(ByteBuffer dst, long position) throws IOException {
        int readInternal;
        if (dst == null) {
            throw new NullPointerException();
        }
        if (position < 0) {
            throw new IllegalArgumentException("Negative position");
        }
        if (!this.readable) {
            throw new NonReadableChannelException();
        }
        ensureOpen();
        if (this.f53721nd.needsPositionLock()) {
            synchronized (this.positionLock) {
                readInternal = readInternal(dst, position);
            }
            return readInternal;
        }
        return readInternal(dst, position);
    }

    /* JADX WARN: Finally extract failed */
    private int readInternal(ByteBuffer dst, long position) throws IOException {
        int n10 = 0;
        int ti = -1;
        try {
            begin();
            ti = this.threads.add();
            if (!isOpen()) {
                this.threads.remove(ti);
                end(0 > 0);
                return -1;
            }
            do {
                n10 = IOUtil.read(this.f53720fd, dst, position, this.f53721nd);
                if (n10 != -3) {
                    break;
                }
            } while (isOpen());
            int normalize = IOStatus.normalize(n10);
            this.threads.remove(ti);
            end(n10 > 0);
            return normalize;
        } catch (Throwable th) {
            this.threads.remove(ti);
            end(n10 > 0);
            throw th;
        }
    }

    @Override // java.nio.channels.FileChannel
    public int write(ByteBuffer src, long position) throws IOException {
        int writeInternal;
        if (src == null) {
            throw new NullPointerException();
        }
        if (position < 0) {
            throw new IllegalArgumentException("Negative position");
        }
        if (!this.writable) {
            throw new NonWritableChannelException();
        }
        ensureOpen();
        if (this.f53721nd.needsPositionLock()) {
            synchronized (this.positionLock) {
                writeInternal = writeInternal(src, position);
            }
            return writeInternal;
        }
        return writeInternal(src, position);
    }

    /* JADX WARN: Finally extract failed */
    private int writeInternal(ByteBuffer src, long position) throws IOException {
        int n10 = 0;
        int ti = -1;
        try {
            begin();
            ti = this.threads.add();
            if (!isOpen()) {
                this.threads.remove(ti);
                end(0 > 0);
                return -1;
            }
            do {
                n10 = IOUtil.write(this.f53720fd, src, position, this.f53721nd);
                if (n10 != -3) {
                    break;
                }
            } while (isOpen());
            int normalize = IOStatus.normalize(n10);
            this.threads.remove(ti);
            end(n10 > 0);
            return normalize;
        } catch (Throwable th) {
            this.threads.remove(ti);
            end(n10 > 0);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Unmapper implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static volatile int count;

        /* renamed from: nd, reason: collision with root package name */
        private static final NativeDispatcher f53722nd = new FileDispatcherImpl();
        static volatile long totalCapacity;
        static volatile long totalSize;
        private volatile long address;
        private final int cap;

        /* renamed from: fd, reason: collision with root package name */
        private final FileDescriptor f53723fd;
        private final long size;

        private Unmapper(long address, long size, int cap, FileDescriptor fd2) {
            this.address = address;
            this.size = size;
            this.cap = cap;
            this.f53723fd = fd2;
            synchronized (Unmapper.class) {
                count++;
                totalSize += size;
                totalCapacity += cap;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.address == 0) {
                return;
            }
            FileChannelImpl.unmap0(this.address, this.size);
            this.address = 0L;
            if (this.f53723fd.valid()) {
                try {
                    f53722nd.close(this.f53723fd);
                } catch (IOException e2) {
                }
            }
            synchronized (Unmapper.class) {
                count--;
                totalSize -= this.size;
                totalCapacity -= this.cap;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void unmap(MappedByteBuffer mappedByteBuffer) {
        Cleaner cl = ((DirectBuffer) mappedByteBuffer).cleaner();
        if (cl != null) {
            cl.clean();
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:47:0x00ad */
    @Override // java.nio.channels.FileChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.nio.MappedByteBuffer map(java.nio.channels.FileChannel.MapMode r32, long r33, long r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.map(java.nio.channels.FileChannel$MapMode, long, long):java.nio.MappedByteBuffer");
    }

    private static boolean isSharedFileLockTable() {
        boolean z10;
        if (!propertyChecked) {
            synchronized (FileChannelImpl.class) {
                if (!propertyChecked) {
                    String value = (String) AccessController.doPrivileged(new GetPropertyAction("sun.nio.ch.disableSystemWideOverlappingFileLockCheck"));
                    if (value != null && !value.equals("false")) {
                        z10 = false;
                        isSharedFileLockTable = z10;
                        propertyChecked = true;
                    }
                    z10 = true;
                    isSharedFileLockTable = z10;
                    propertyChecked = true;
                }
            }
        }
        return isSharedFileLockTable;
    }

    private FileLockTable fileLockTable() throws IOException {
        if (this.fileLockTable == null) {
            synchronized (this) {
                if (this.fileLockTable == null) {
                    if (isSharedFileLockTable()) {
                        int ti = this.threads.add();
                        try {
                            ensureOpen();
                            this.fileLockTable = FileLockTable.newSharedFileLockTable(this, this.f53720fd);
                            this.threads.remove(ti);
                        } catch (Throwable th) {
                            this.threads.remove(ti);
                            throw th;
                        }
                    } else {
                        this.fileLockTable = new SimpleFileLockTable();
                    }
                }
            }
        }
        return this.fileLockTable;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00d6  */
    @Override // java.nio.channels.FileChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.nio.channels.FileLock lock(long r18, long r20, boolean r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.FileChannelImpl.lock(long, long, boolean):java.nio.channels.FileLock");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v4, types: [long] */
    /* JADX WARN: Type inference failed for: r12v5 */
    @Override // java.nio.channels.FileChannel
    public FileLock tryLock(long position, long size, boolean shared) throws IOException {
        int i10;
        ensureOpen();
        if (shared && !this.readable) {
            throw new NonReadableChannelException();
        }
        if (!shared && !this.writable) {
            throw new NonWritableChannelException();
        }
        FileLockImpl fli = new FileLockImpl(this, position, size, shared);
        FileLockTable flt = fileLockTable();
        flt.add(fli);
        int ti = this.threads.add();
        try {
            try {
                try {
                    ensureOpen();
                    i10 = position;
                    int result = this.f53721nd.lock(this.f53720fd, false, i10, size, shared);
                    if (result == -1) {
                        try {
                            flt.remove(fli);
                            this.threads.remove(ti);
                            return null;
                        } catch (Throwable th) {
                            e = th;
                            i10 = ti;
                            this.threads.remove(i10);
                            throw e;
                        }
                    }
                    if (result != 1) {
                        this.threads.remove(ti);
                        return fli;
                    }
                    FileLockImpl fli2 = new FileLockImpl((FileChannel) this, position, size, false);
                    flt.replace(fli, fli2);
                    this.threads.remove(ti);
                    return fli2;
                } catch (IOException e2) {
                    flt.remove(fli);
                    throw e2;
                }
            } catch (Throwable th2) {
                e = th2;
                i10 = ti;
            }
        } catch (Throwable th3) {
            e = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release(FileLockImpl fli) throws IOException {
        int ti = this.threads.add();
        try {
            ensureOpen();
            this.f53721nd.release(this.f53720fd, fli.position(), fli.size());
            this.threads.remove(ti);
            this.fileLockTable.remove(fli);
        } catch (Throwable th) {
            this.threads.remove(ti);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SimpleFileLockTable extends FileLockTable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<FileLock> lockList = new ArrayList(2);

        private void checkList(long position, long size) throws OverlappingFileLockException {
            for (FileLock fl : this.lockList) {
                if (fl.overlaps(position, size)) {
                    throw new OverlappingFileLockException();
                }
            }
        }

        @Override // sun.nio.ch.FileLockTable
        public void add(FileLock fl) throws OverlappingFileLockException {
            synchronized (this.lockList) {
                checkList(fl.position(), fl.size());
                this.lockList.add(fl);
            }
        }

        @Override // sun.nio.ch.FileLockTable
        public void remove(FileLock fl) {
            synchronized (this.lockList) {
                this.lockList.remove(fl);
            }
        }

        @Override // sun.nio.ch.FileLockTable
        public List<FileLock> removeAll() {
            List<FileLock> result;
            synchronized (this.lockList) {
                result = new ArrayList<>(this.lockList);
                this.lockList.clear();
            }
            return result;
        }

        @Override // sun.nio.ch.FileLockTable
        public void replace(FileLock fl1, FileLock fl2) {
            synchronized (this.lockList) {
                this.lockList.remove(fl1);
                this.lockList.add(fl2);
            }
        }
    }
}
