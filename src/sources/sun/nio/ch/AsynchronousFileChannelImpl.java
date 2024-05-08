package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
abstract class AsynchronousFileChannelImpl extends AsynchronousFileChannel {
    protected final ReadWriteLock closeLock = new ReentrantReadWriteLock();
    protected volatile boolean closed;
    protected final ExecutorService executor;
    protected final FileDescriptor fdObj;
    private volatile FileLockTable fileLockTable;
    protected final boolean reading;
    protected final boolean writing;

    abstract <A> Future<FileLock> implLock(long j10, long j11, boolean z10, A a10, CompletionHandler<FileLock, ? super A> completionHandler);

    abstract <A> Future<Integer> implRead(ByteBuffer byteBuffer, long j10, A a10, CompletionHandler<Integer, ? super A> completionHandler);

    protected abstract void implRelease(FileLockImpl fileLockImpl) throws IOException;

    abstract <A> Future<Integer> implWrite(ByteBuffer byteBuffer, long j10, A a10, CompletionHandler<Integer, ? super A> completionHandler);

    /* JADX INFO: Access modifiers changed from: protected */
    public AsynchronousFileChannelImpl(FileDescriptor fdObj, boolean reading, boolean writing, ExecutorService executor) {
        this.fdObj = fdObj;
        this.reading = reading;
        this.writing = writing;
        this.executor = executor;
    }

    final ExecutorService executor() {
        return this.executor;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void begin() throws IOException {
        this.closeLock.readLock().lock();
        if (this.closed) {
            throw new ClosedChannelException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void end() {
        this.closeLock.readLock().unlock();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void end(boolean completed) throws IOException {
        end();
        if (!completed && !isOpen()) {
            throw new AsynchronousCloseException();
        }
    }

    @Override // java.nio.channels.AsynchronousFileChannel
    public final Future<FileLock> lock(long position, long size, boolean shared) {
        return implLock(position, size, shared, null, null);
    }

    @Override // java.nio.channels.AsynchronousFileChannel
    public final <A> void lock(long position, long size, boolean shared, A attachment, CompletionHandler<FileLock, ? super A> handler) {
        if (handler == null) {
            throw new NullPointerException("'handler' is null");
        }
        implLock(position, size, shared, attachment, handler);
    }

    final void ensureFileLockTableInitialized() throws IOException {
        if (this.fileLockTable == null) {
            synchronized (this) {
                if (this.fileLockTable == null) {
                    this.fileLockTable = FileLockTable.newSharedFileLockTable(this, this.fdObj);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void invalidateAllLocks() throws IOException {
        if (this.fileLockTable != null) {
            for (FileLock fl : this.fileLockTable.removeAll()) {
                synchronized (fl) {
                    if (fl.isValid()) {
                        FileLockImpl fli = (FileLockImpl) fl;
                        implRelease(fli);
                        fli.invalidate();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FileLockImpl addToFileLockTable(long position, long size, boolean shared) {
        try {
            this.closeLock.readLock().lock();
            if (!this.closed) {
                try {
                    ensureFileLockTableInitialized();
                    FileLockImpl fli = new FileLockImpl(this, position, size, shared);
                    this.fileLockTable.add(fli);
                    return fli;
                } catch (IOException x10) {
                    throw new AssertionError(x10);
                }
            }
            end();
            return null;
        } finally {
            end();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void removeFromFileLockTable(FileLockImpl fli) {
        this.fileLockTable.remove(fli);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void release(FileLockImpl fli) throws IOException {
        try {
            begin();
            implRelease(fli);
            removeFromFileLockTable(fli);
        } finally {
            end();
        }
    }

    @Override // java.nio.channels.AsynchronousFileChannel
    public final Future<Integer> read(ByteBuffer dst, long position) {
        return implRead(dst, position, null, null);
    }

    @Override // java.nio.channels.AsynchronousFileChannel
    public final <A> void read(ByteBuffer dst, long position, A attachment, CompletionHandler<Integer, ? super A> handler) {
        if (handler == null) {
            throw new NullPointerException("'handler' is null");
        }
        implRead(dst, position, attachment, handler);
    }

    @Override // java.nio.channels.AsynchronousFileChannel
    public final Future<Integer> write(ByteBuffer src, long position) {
        return implWrite(src, position, null, null);
    }

    @Override // java.nio.channels.AsynchronousFileChannel
    public final <A> void write(ByteBuffer src, long position, A attachment, CompletionHandler<Integer, ? super A> handler) {
        if (handler == null) {
            throw new NullPointerException("'handler' is null");
        }
        implWrite(src, position, attachment, handler);
    }
}
