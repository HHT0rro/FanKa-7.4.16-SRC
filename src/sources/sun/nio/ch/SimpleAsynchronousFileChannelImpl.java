package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.channels.NonReadableChannelException;
import java.nio.channels.NonWritableChannelException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SimpleAsynchronousFileChannelImpl extends AsynchronousFileChannelImpl {

    /* renamed from: nd, reason: collision with root package name */
    private static final FileDispatcher f53726nd = new FileDispatcherImpl();
    private final NativeThreadSet threads;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class DefaultExecutorHolder {
        static final ExecutorService defaultExecutor = ThreadPool.createDefault().executor();

        private DefaultExecutorHolder() {
        }
    }

    SimpleAsynchronousFileChannelImpl(FileDescriptor fdObj, boolean reading, boolean writing, ExecutorService executor) {
        super(fdObj, reading, writing, executor);
        this.threads = new NativeThreadSet(2);
    }

    public static AsynchronousFileChannel open(FileDescriptor fdo, boolean reading, boolean writing, ThreadPool pool) {
        ExecutorService executor = pool == null ? DefaultExecutorHolder.defaultExecutor : pool.executor();
        return new SimpleAsynchronousFileChannelImpl(fdo, reading, writing, executor);
    }

    @Override // java.nio.channels.AsynchronousChannel, java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.fdObj) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            invalidateAllLocks();
            this.threads.signalAndWait();
            this.closeLock.writeLock().lock();
            this.closeLock.writeLock().unlock();
            f53726nd.close(this.fdObj);
        }
    }

    @Override // java.nio.channels.AsynchronousFileChannel
    public long size() throws IOException {
        int ti = this.threads.add();
        long n10 = 0;
        try {
            try {
                begin();
                do {
                    n10 = f53726nd.size(this.fdObj);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
                return n10;
            } finally {
                end(n10 >= 0);
            }
        } finally {
            this.threads.remove(ti);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        if (isOpen() != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        r3 = sun.nio.ch.SimpleAsynchronousFileChannelImpl.f53726nd.truncate(r11.fdObj, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r3 != (-3)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        if (isOpen() != false) goto L49;
     */
    @Override // java.nio.channels.AsynchronousFileChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.nio.channels.AsynchronousFileChannel truncate(long r12) throws java.io.IOException {
        /*
            r11 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 < 0) goto L72
            boolean r2 = r11.writing
            if (r2 == 0) goto L6c
            sun.nio.ch.NativeThreadSet r2 = r11.threads
            int r2 = r2.add()
            r3 = 0
            r5 = 1
            r6 = 0
            r11.begin()     // Catch: java.lang.Throwable -> L59
        L17:
            sun.nio.ch.FileDispatcher r7 = sun.nio.ch.SimpleAsynchronousFileChannelImpl.f53726nd     // Catch: java.lang.Throwable -> L59
            java.io.FileDescriptor r8 = r11.fdObj     // Catch: java.lang.Throwable -> L59
            long r7 = r7.size(r8)     // Catch: java.lang.Throwable -> L59
            r3 = r7
            r7 = -3
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 != 0) goto L2c
            boolean r9 = r11.isOpen()     // Catch: java.lang.Throwable -> L59
            if (r9 != 0) goto L17
        L2c:
            int r9 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r9 >= 0) goto L49
            boolean r9 = r11.isOpen()     // Catch: java.lang.Throwable -> L59
            if (r9 == 0) goto L49
        L36:
            sun.nio.ch.FileDispatcher r9 = sun.nio.ch.SimpleAsynchronousFileChannelImpl.f53726nd     // Catch: java.lang.Throwable -> L59
            java.io.FileDescriptor r10 = r11.fdObj     // Catch: java.lang.Throwable -> L59
            int r9 = r9.truncate(r10, r12)     // Catch: java.lang.Throwable -> L59
            long r3 = (long) r9     // Catch: java.lang.Throwable -> L59
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 != 0) goto L49
            boolean r9 = r11.isOpen()     // Catch: java.lang.Throwable -> L59
            if (r9 != 0) goto L36
        L49:
        L4a:
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L4f
            goto L50
        L4f:
            r5 = r6
        L50:
            r11.end(r5)     // Catch: java.lang.Throwable -> L65
            sun.nio.ch.NativeThreadSet r0 = r11.threads
            r0.remove(r2)
            return r11
        L59:
            r7 = move-exception
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L5f
            goto L60
        L5f:
            r5 = r6
        L60:
            r11.end(r5)     // Catch: java.lang.Throwable -> L65
            throw r7     // Catch: java.lang.Throwable -> L65
        L65:
            r0 = move-exception
            sun.nio.ch.NativeThreadSet r1 = r11.threads
            r1.remove(r2)
            throw r0
        L6c:
            java.nio.channels.NonWritableChannelException r0 = new java.nio.channels.NonWritableChannelException
            r0.<init>()
            throw r0
        L72:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Negative size"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SimpleAsynchronousFileChannelImpl.truncate(long):java.nio.channels.AsynchronousFileChannel");
    }

    @Override // java.nio.channels.AsynchronousFileChannel
    public void force(boolean metaData) throws IOException {
        int ti = this.threads.add();
        int n10 = 0;
        try {
            try {
                begin();
                do {
                    n10 = f53726nd.force(this.fdObj, metaData);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
            } finally {
                end(n10 >= 0);
            }
        } finally {
            this.threads.remove(ti);
        }
    }

    @Override // sun.nio.ch.AsynchronousFileChannelImpl
    <A> Future<FileLock> implLock(final long position, final long size, final boolean shared, final A attachment, final CompletionHandler<FileLock, ? super A> handler) {
        if (shared && !this.reading) {
            throw new NonReadableChannelException();
        }
        if (!shared && !this.writing) {
            throw new NonWritableChannelException();
        }
        final FileLockImpl fli = addToFileLockTable(position, size, shared);
        PendingFuture<FileLock, A> pendingFuture = null;
        if (fli == null) {
            Throwable exc = new ClosedChannelException();
            if (handler != null) {
                Invoker.invokeIndirectly(handler, attachment, (Object) null, exc, this.executor);
                return null;
            }
            return CompletedFuture.withFailure(exc);
        }
        if (handler == null) {
            pendingFuture = new PendingFuture<>(this);
        }
        final PendingFuture<FileLock, A> result = pendingFuture;
        Runnable task = new Runnable() { // from class: sun.nio.ch.SimpleAsynchronousFileChannelImpl.1
            @Override // java.lang.Runnable
            public void run() {
                int n10;
                Throwable exc2 = null;
                int ti = SimpleAsynchronousFileChannelImpl.this.threads.add();
                try {
                    try {
                        SimpleAsynchronousFileChannelImpl.this.begin();
                        do {
                            n10 = SimpleAsynchronousFileChannelImpl.f53726nd.lock(SimpleAsynchronousFileChannelImpl.this.fdObj, true, position, size, shared);
                            if (n10 != 2) {
                                break;
                            }
                        } while (SimpleAsynchronousFileChannelImpl.this.isOpen());
                    } catch (IOException e2) {
                        x = e2;
                        SimpleAsynchronousFileChannelImpl.this.removeFromFileLockTable(fli);
                        if (!SimpleAsynchronousFileChannelImpl.this.isOpen()) {
                            x = new AsynchronousCloseException();
                        }
                        exc2 = x;
                    } finally {
                        SimpleAsynchronousFileChannelImpl.this.end();
                    }
                    if (n10 != 0 || !SimpleAsynchronousFileChannelImpl.this.isOpen()) {
                        throw new AsynchronousCloseException();
                    }
                    SimpleAsynchronousFileChannelImpl.this.threads.remove(ti);
                    CompletionHandler completionHandler = handler;
                    if (completionHandler == null) {
                        result.setResult(fli, exc2);
                    } else {
                        Invoker.invokeUnchecked(completionHandler, attachment, fli, exc2);
                    }
                } catch (Throwable th) {
                    SimpleAsynchronousFileChannelImpl.this.threads.remove(ti);
                    throw th;
                }
            }
        };
        boolean executed = false;
        try {
            this.executor.execute(task);
            executed = true;
            return result;
        } finally {
            if (!executed) {
                removeFromFileLockTable(fli);
            }
        }
    }

    @Override // java.nio.channels.AsynchronousFileChannel
    public FileLock tryLock(long position, long size, boolean shared) throws IOException {
        int n10;
        if (shared && !this.reading) {
            throw new NonReadableChannelException();
        }
        if (!shared && !this.writing) {
            throw new NonWritableChannelException();
        }
        FileLockImpl fli = addToFileLockTable(position, size, shared);
        if (fli == null) {
            throw new ClosedChannelException();
        }
        int ti = this.threads.add();
        boolean gotLock = false;
        try {
            begin();
            do {
                n10 = f53726nd.lock(this.fdObj, false, position, size, shared);
                if (n10 != 2) {
                    break;
                }
            } while (isOpen());
            if (n10 == 0 && isOpen()) {
                gotLock = true;
                return fli;
            }
            if (n10 != -1) {
                if (n10 == 2) {
                    throw new AsynchronousCloseException();
                }
                throw new AssertionError();
            }
            if (!gotLock) {
                removeFromFileLockTable(fli);
            }
            end();
            this.threads.remove(ti);
            return null;
        } finally {
            if (!gotLock) {
                removeFromFileLockTable(fli);
            }
            end();
            this.threads.remove(ti);
        }
    }

    @Override // sun.nio.ch.AsynchronousFileChannelImpl
    protected void implRelease(FileLockImpl fli) throws IOException {
        f53726nd.release(this.fdObj, fli.position(), fli.size());
    }

    @Override // sun.nio.ch.AsynchronousFileChannelImpl
    <A> Future<Integer> implRead(final ByteBuffer dst, final long position, final A attachment, final CompletionHandler<Integer, ? super A> handler) {
        if (position < 0) {
            throw new IllegalArgumentException("Negative position");
        }
        if (!this.reading) {
            throw new NonReadableChannelException();
        }
        if (dst.isReadOnly()) {
            throw new IllegalArgumentException("Read-only buffer");
        }
        if (!isOpen() || dst.remaining() == 0) {
            Throwable exc = isOpen() ? null : new ClosedChannelException();
            if (handler == null) {
                return CompletedFuture.withResult(0, exc);
            }
            Invoker.invokeIndirectly((CompletionHandler<int, ? super A>) handler, (Object) attachment, 0, exc, (Executor) this.executor);
            return null;
        }
        final PendingFuture<Integer, A> result = handler == null ? new PendingFuture<>(this) : null;
        Runnable task = new Runnable() { // from class: sun.nio.ch.SimpleAsynchronousFileChannelImpl.2
            @Override // java.lang.Runnable
            public void run() {
                int n10 = 0;
                Throwable exc2 = null;
                int ti = SimpleAsynchronousFileChannelImpl.this.threads.add();
                try {
                    try {
                        SimpleAsynchronousFileChannelImpl.this.begin();
                        do {
                            n10 = IOUtil.read(SimpleAsynchronousFileChannelImpl.this.fdObj, dst, position, SimpleAsynchronousFileChannelImpl.f53726nd);
                            if (n10 != -3) {
                                break;
                            }
                        } while (SimpleAsynchronousFileChannelImpl.this.isOpen());
                        if (n10 < 0 && !SimpleAsynchronousFileChannelImpl.this.isOpen()) {
                            throw new AsynchronousCloseException();
                        }
                    } catch (IOException e2) {
                        x = e2;
                        if (!SimpleAsynchronousFileChannelImpl.this.isOpen()) {
                            x = new AsynchronousCloseException();
                        }
                        exc2 = x;
                    }
                    SimpleAsynchronousFileChannelImpl.this.end();
                    SimpleAsynchronousFileChannelImpl.this.threads.remove(ti);
                    CompletionHandler completionHandler = handler;
                    if (completionHandler == null) {
                        result.setResult(Integer.valueOf(n10), exc2);
                    } else {
                        Invoker.invokeUnchecked(completionHandler, attachment, Integer.valueOf(n10), exc2);
                    }
                } catch (Throwable th) {
                    SimpleAsynchronousFileChannelImpl.this.end();
                    SimpleAsynchronousFileChannelImpl.this.threads.remove(ti);
                    throw th;
                }
            }
        };
        this.executor.execute(task);
        return result;
    }

    @Override // sun.nio.ch.AsynchronousFileChannelImpl
    <A> Future<Integer> implWrite(final ByteBuffer src, final long position, final A attachment, final CompletionHandler<Integer, ? super A> handler) {
        if (position < 0) {
            throw new IllegalArgumentException("Negative position");
        }
        if (!this.writing) {
            throw new NonWritableChannelException();
        }
        if (!isOpen() || src.remaining() == 0) {
            Throwable exc = isOpen() ? null : new ClosedChannelException();
            if (handler == null) {
                return CompletedFuture.withResult(0, exc);
            }
            Invoker.invokeIndirectly((CompletionHandler<int, ? super A>) handler, (Object) attachment, 0, exc, (Executor) this.executor);
            return null;
        }
        final PendingFuture<Integer, A> result = handler == null ? new PendingFuture<>(this) : null;
        Runnable task = new Runnable() { // from class: sun.nio.ch.SimpleAsynchronousFileChannelImpl.3
            @Override // java.lang.Runnable
            public void run() {
                int n10 = 0;
                Throwable exc2 = null;
                int ti = SimpleAsynchronousFileChannelImpl.this.threads.add();
                try {
                    try {
                        SimpleAsynchronousFileChannelImpl.this.begin();
                        do {
                            n10 = IOUtil.write(SimpleAsynchronousFileChannelImpl.this.fdObj, src, position, SimpleAsynchronousFileChannelImpl.f53726nd);
                            if (n10 != -3) {
                                break;
                            }
                        } while (SimpleAsynchronousFileChannelImpl.this.isOpen());
                        if (n10 < 0 && !SimpleAsynchronousFileChannelImpl.this.isOpen()) {
                            throw new AsynchronousCloseException();
                        }
                    } catch (IOException e2) {
                        x = e2;
                        if (!SimpleAsynchronousFileChannelImpl.this.isOpen()) {
                            x = new AsynchronousCloseException();
                        }
                        exc2 = x;
                    }
                    SimpleAsynchronousFileChannelImpl.this.end();
                    SimpleAsynchronousFileChannelImpl.this.threads.remove(ti);
                    CompletionHandler completionHandler = handler;
                    if (completionHandler == null) {
                        result.setResult(Integer.valueOf(n10), exc2);
                    } else {
                        Invoker.invokeUnchecked(completionHandler, attachment, Integer.valueOf(n10), exc2);
                    }
                } catch (Throwable th) {
                    SimpleAsynchronousFileChannelImpl.this.end();
                    SimpleAsynchronousFileChannelImpl.this.threads.remove(ti);
                    throw th;
                }
            }
        };
        this.executor.execute(task);
        return result;
    }
}
