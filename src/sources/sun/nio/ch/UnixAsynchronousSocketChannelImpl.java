package sun.nio.ch;

import dalvik.annotation.optimization.ReachabilitySensitive;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.CompletionHandler;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.InterruptedByTimeoutException;
import java.nio.channels.ShutdownChannelGroupException;
import java.security.AccessController;
import java.util.concurrent.Future;
import sun.net.NetHooks;
import sun.nio.ch.Port;
import sun.security.action.GetPropertyAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class UnixAsynchronousSocketChannelImpl extends AsynchronousSocketChannelImpl implements Port.PollableChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean disableSynchronousRead;

    /* renamed from: nd, reason: collision with root package name */
    private static final NativeDispatcher f53735nd = new SocketDispatcher();
    private Object connectAttachment;
    private PendingFuture<Void, Object> connectFuture;
    private CompletionHandler<Void, Object> connectHandler;
    private boolean connectPending;
    private final int fdVal;

    @ReachabilitySensitive
    private final CloseGuard guard;
    private boolean isGatheringWrite;
    private boolean isScatteringRead;
    private SocketAddress pendingRemote;
    private final Port port;
    private Object readAttachment;
    private ByteBuffer readBuffer;
    private ByteBuffer[] readBuffers;
    private PendingFuture<Number, Object> readFuture;
    private CompletionHandler<Number, Object> readHandler;
    private boolean readPending;
    private Runnable readTimeoutTask;
    private Future<?> readTimer;
    private final Object updateLock;
    private Object writeAttachment;
    private ByteBuffer writeBuffer;
    private ByteBuffer[] writeBuffers;
    private PendingFuture<Number, Object> writeFuture;
    private CompletionHandler<Number, Object> writeHandler;
    private boolean writePending;
    private Runnable writeTimeoutTask;
    private Future<?> writeTimer;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private enum OpType {
        CONNECT,
        READ,
        WRITE
    }

    private static native void checkConnect(int i10) throws IOException;

    static {
        String propValue = (String) AccessController.doPrivileged(new GetPropertyAction("sun.nio.ch.disableSynchronousRead", "false"));
        disableSynchronousRead = propValue.length() == 0 ? true : Boolean.valueOf(propValue).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixAsynchronousSocketChannelImpl(Port port) throws IOException {
        super(port);
        this.updateLock = new Object();
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.readTimeoutTask = new Runnable() { // from class: sun.nio.ch.UnixAsynchronousSocketChannelImpl.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (UnixAsynchronousSocketChannelImpl.this.updateLock) {
                    if (UnixAsynchronousSocketChannelImpl.this.readPending) {
                        UnixAsynchronousSocketChannelImpl.this.readPending = false;
                        CompletionHandler<Number, Object> handler = UnixAsynchronousSocketChannelImpl.this.readHandler;
                        Object att = UnixAsynchronousSocketChannelImpl.this.readAttachment;
                        PendingFuture<Number, Object> future = UnixAsynchronousSocketChannelImpl.this.readFuture;
                        UnixAsynchronousSocketChannelImpl.this.enableReading(true);
                        Exception exc = new InterruptedByTimeoutException();
                        if (handler == null) {
                            future.setFailure(exc);
                        } else {
                            AsynchronousChannel ch = UnixAsynchronousSocketChannelImpl.this;
                            Invoker.invokeIndirectly(ch, handler, att, (Object) null, exc);
                        }
                    }
                }
            }
        };
        this.writeTimeoutTask = new Runnable() { // from class: sun.nio.ch.UnixAsynchronousSocketChannelImpl.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (UnixAsynchronousSocketChannelImpl.this.updateLock) {
                    if (UnixAsynchronousSocketChannelImpl.this.writePending) {
                        UnixAsynchronousSocketChannelImpl.this.writePending = false;
                        CompletionHandler<Number, Object> handler = UnixAsynchronousSocketChannelImpl.this.writeHandler;
                        Object att = UnixAsynchronousSocketChannelImpl.this.writeAttachment;
                        PendingFuture<Number, Object> future = UnixAsynchronousSocketChannelImpl.this.writeFuture;
                        UnixAsynchronousSocketChannelImpl.this.enableWriting(true);
                        Exception exc = new InterruptedByTimeoutException();
                        if (handler != null) {
                            Invoker.invokeIndirectly(UnixAsynchronousSocketChannelImpl.this, handler, att, (Object) null, exc);
                        } else {
                            future.setFailure(exc);
                        }
                    }
                }
            }
        };
        try {
            IOUtil.configureBlocking(this.f53714fd, false);
            this.port = port;
            int fdVal = IOUtil.fdVal(this.f53714fd);
            this.fdVal = fdVal;
            port.register(fdVal, this);
            closeGuard.open("close");
        } catch (IOException x10) {
            f53735nd.close(this.f53714fd);
            throw x10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixAsynchronousSocketChannelImpl(Port port, FileDescriptor fd2, InetSocketAddress remote) throws IOException {
        super(port, fd2, remote);
        this.updateLock = new Object();
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.readTimeoutTask = new Runnable() { // from class: sun.nio.ch.UnixAsynchronousSocketChannelImpl.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (UnixAsynchronousSocketChannelImpl.this.updateLock) {
                    if (UnixAsynchronousSocketChannelImpl.this.readPending) {
                        UnixAsynchronousSocketChannelImpl.this.readPending = false;
                        CompletionHandler<Number, Object> handler = UnixAsynchronousSocketChannelImpl.this.readHandler;
                        Object att = UnixAsynchronousSocketChannelImpl.this.readAttachment;
                        PendingFuture<Number, Object> future = UnixAsynchronousSocketChannelImpl.this.readFuture;
                        UnixAsynchronousSocketChannelImpl.this.enableReading(true);
                        Exception exc = new InterruptedByTimeoutException();
                        if (handler == null) {
                            future.setFailure(exc);
                        } else {
                            AsynchronousChannel ch = UnixAsynchronousSocketChannelImpl.this;
                            Invoker.invokeIndirectly(ch, handler, att, (Object) null, exc);
                        }
                    }
                }
            }
        };
        this.writeTimeoutTask = new Runnable() { // from class: sun.nio.ch.UnixAsynchronousSocketChannelImpl.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (UnixAsynchronousSocketChannelImpl.this.updateLock) {
                    if (UnixAsynchronousSocketChannelImpl.this.writePending) {
                        UnixAsynchronousSocketChannelImpl.this.writePending = false;
                        CompletionHandler<Number, Object> handler = UnixAsynchronousSocketChannelImpl.this.writeHandler;
                        Object att = UnixAsynchronousSocketChannelImpl.this.writeAttachment;
                        PendingFuture<Number, Object> future = UnixAsynchronousSocketChannelImpl.this.writeFuture;
                        UnixAsynchronousSocketChannelImpl.this.enableWriting(true);
                        Exception exc = new InterruptedByTimeoutException();
                        if (handler != null) {
                            Invoker.invokeIndirectly(UnixAsynchronousSocketChannelImpl.this, handler, att, (Object) null, exc);
                        } else {
                            future.setFailure(exc);
                        }
                    }
                }
            }
        };
        int fdVal = IOUtil.fdVal(fd2);
        this.fdVal = fdVal;
        IOUtil.configureBlocking(fd2, false);
        try {
            port.register(fdVal, this);
            this.port = port;
            closeGuard.open("close");
        } catch (ShutdownChannelGroupException x10) {
            throw new IOException(x10);
        }
    }

    @Override // sun.nio.ch.Groupable
    public AsynchronousChannelGroupImpl group() {
        return this.port;
    }

    private void updateEvents() {
        int events = this.readPending ? 0 | Net.POLLIN : 0;
        if (this.connectPending || this.writePending) {
            events |= Net.POLLOUT;
        }
        if (events != 0) {
            this.port.startPoll(this.fdVal, events);
        }
    }

    private void lockAndUpdateEvents() {
        synchronized (this.updateLock) {
            updateEvents();
        }
    }

    private void finish(boolean mayInvokeDirect, boolean readable, boolean writable) {
        boolean finishRead = false;
        boolean finishWrite = false;
        boolean finishConnect = false;
        synchronized (this.updateLock) {
            if (readable) {
                try {
                    if (this.readPending) {
                        this.readPending = false;
                        finishRead = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (writable) {
                if (this.writePending) {
                    this.writePending = false;
                    finishWrite = true;
                } else if (this.connectPending) {
                    this.connectPending = false;
                    finishConnect = true;
                }
            }
        }
        if (finishRead) {
            if (finishWrite) {
                finishWrite(false);
            }
            finishRead(mayInvokeDirect);
        } else {
            if (finishWrite) {
                finishWrite(mayInvokeDirect);
            }
            if (finishConnect) {
                finishConnect(mayInvokeDirect);
            }
        }
    }

    @Override // sun.nio.ch.Port.PollableChannel
    public void onEvent(int events, boolean mayInvokeDirect) {
        boolean readable = (Net.POLLIN & events) > 0;
        boolean writable = (Net.POLLOUT & events) > 0;
        if (((Net.POLLERR | Net.POLLHUP) & events) > 0) {
            readable = true;
            writable = true;
        }
        finish(mayInvokeDirect, readable, writable);
    }

    @Override // sun.nio.ch.AsynchronousSocketChannelImpl
    void implClose() throws IOException {
        this.guard.close();
        this.port.unregister(this.fdVal);
        f53735nd.close(this.f53714fd);
        finish(false, true, true);
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

    @Override // sun.nio.ch.Cancellable
    public void onCancel(PendingFuture<?, ?> task) {
        if (task.getContext() == OpType.CONNECT) {
            killConnect();
        }
        if (task.getContext() == OpType.READ) {
            killReading();
        }
        if (task.getContext() == OpType.WRITE) {
            killWriting();
        }
    }

    private void setConnected() throws IOException {
        synchronized (this.stateLock) {
            this.state = 2;
            this.localAddress = Net.localAddress(this.f53714fd);
            this.remoteAddress = (InetSocketAddress) this.pendingRemote;
        }
    }

    private void finishConnect(boolean mayInvokeDirect) {
        Throwable e2 = null;
        try {
            begin();
            checkConnect(this.fdVal);
            setConnected();
        } catch (Throwable th) {
            x = th;
            try {
                if (x instanceof ClosedChannelException) {
                    x = new AsynchronousCloseException();
                }
                e2 = x;
            } finally {
                end();
            }
        }
        if (e2 != null) {
            try {
                close();
            } catch (Throwable suppressed) {
                e2.addSuppressed(suppressed);
            }
        }
        CompletionHandler<Void, Object> handler = this.connectHandler;
        Object att = this.connectAttachment;
        PendingFuture<Void, Object> future = this.connectFuture;
        if (handler == null) {
            future.setResult(null, e2);
        } else if (mayInvokeDirect) {
            Invoker.invokeUnchecked(handler, att, null, e2);
        } else {
            Invoker.invokeIndirectly(this, handler, att, (Object) null, e2);
        }
    }

    @Override // sun.nio.ch.AsynchronousSocketChannelImpl
    <A> Future<Void> implConnect(SocketAddress remote, A attachment, CompletionHandler<Void, ? super A> handler) {
        boolean notifyBeforeTcpConnect;
        int n10;
        if (!isOpen()) {
            Throwable e2 = new ClosedChannelException();
            if (handler == null) {
                return CompletedFuture.withFailure(e2);
            }
            Invoker.invoke(this, handler, attachment, null, e2);
            return null;
        }
        InetSocketAddress isa = Net.checkAddress(remote);
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkConnect(isa.getAddress().getHostAddress(), isa.getPort());
        }
        synchronized (this.stateLock) {
            if (this.state == 2) {
                throw new AlreadyConnectedException();
            }
            if (this.state == 1) {
                throw new ConnectionPendingException();
            }
            this.state = 1;
            this.pendingRemote = remote;
            notifyBeforeTcpConnect = this.localAddress == null;
        }
        Throwable e10 = null;
        try {
            begin();
            if (notifyBeforeTcpConnect) {
                NetHooks.beforeTcpConnect(this.f53714fd, isa.getAddress(), isa.getPort());
            }
            n10 = Net.connect(this.f53714fd, isa.getAddress(), isa.getPort());
        } catch (Throwable th) {
            x = th;
            try {
                if (x instanceof ClosedChannelException) {
                    x = new AsynchronousCloseException();
                }
                e10 = x;
            } finally {
                end();
            }
        }
        if (n10 == -2) {
            PendingFuture<Void, A> result = null;
            synchronized (this.updateLock) {
                if (handler == null) {
                    result = new PendingFuture<>(this, OpType.CONNECT);
                    this.connectFuture = result;
                } else {
                    this.connectHandler = handler;
                    this.connectAttachment = attachment;
                }
                this.connectPending = true;
                updateEvents();
            }
            return result;
        }
        setConnected();
        if (e10 != null) {
            try {
                close();
            } catch (Throwable suppressed) {
                e10.addSuppressed(suppressed);
            }
        }
        if (handler == null) {
            return CompletedFuture.withResult(null, e10);
        }
        Invoker.invoke(this, handler, attachment, null, e10);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
    
        if ((r1 instanceof java.nio.channels.AsynchronousCloseException) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
    
        end();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        if (r6 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        r6.cancel(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
    
        if (r1 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        if (r2 == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
    
        r7 = java.lang.Long.valueOf(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        r7 = java.lang.Integer.valueOf(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
    
        if (r3 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
    
        r5.setResult(r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        if (r14 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0089, code lost:
    
        sun.nio.ch.Invoker.invokeUnchecked(r3, r4, r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008d, code lost:
    
        sun.nio.ch.Invoker.invokeIndirectly(r13, (java.nio.channels.CompletionHandler<java.lang.Number, ? super java.lang.Object>) r3, r4, r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0064, code lost:
    
        lockAndUpdateEvents();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0062, code lost:
    
        if ((r1 instanceof java.nio.channels.AsynchronousCloseException) != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void finishRead(boolean r14) {
        /*
            r13 = this;
            r0 = -1
            r1 = 0
            boolean r2 = r13.isScatteringRead
            java.nio.channels.CompletionHandler<java.lang.Number, java.lang.Object> r3 = r13.readHandler
            java.lang.Object r4 = r13.readAttachment
            sun.nio.ch.PendingFuture<java.lang.Number, java.lang.Object> r5 = r13.readFuture
            java.util.concurrent.Future<?> r6 = r13.readTimer
            r7 = 0
            r13.begin()     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L1e
            java.io.FileDescriptor r8 = r13.f53714fd     // Catch: java.lang.Throwable -> L51
            java.nio.ByteBuffer[] r9 = r13.readBuffers     // Catch: java.lang.Throwable -> L51
            sun.nio.ch.NativeDispatcher r10 = sun.nio.ch.UnixAsynchronousSocketChannelImpl.f53735nd     // Catch: java.lang.Throwable -> L51
            long r8 = sun.nio.ch.IOUtil.read(r8, r9, r10)     // Catch: java.lang.Throwable -> L51
            int r0 = (int) r8     // Catch: java.lang.Throwable -> L51
            goto L2b
        L1e:
            java.io.FileDescriptor r8 = r13.f53714fd     // Catch: java.lang.Throwable -> L51
            java.nio.ByteBuffer r9 = r13.readBuffer     // Catch: java.lang.Throwable -> L51
            sun.nio.ch.NativeDispatcher r10 = sun.nio.ch.UnixAsynchronousSocketChannelImpl.f53735nd     // Catch: java.lang.Throwable -> L51
            r11 = -1
            int r8 = sun.nio.ch.IOUtil.read(r8, r9, r11, r10)     // Catch: java.lang.Throwable -> L51
            r0 = r8
        L2b:
            r8 = -2
            if (r0 != r8) goto L43
            java.lang.Object r8 = r13.updateLock     // Catch: java.lang.Throwable -> L51
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L51
            r9 = 1
            r13.readPending = r9     // Catch: java.lang.Throwable -> L40
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L40
            boolean r7 = r1 instanceof java.nio.channels.AsynchronousCloseException
            if (r7 != 0) goto L3c
            r13.lockAndUpdateEvents()
        L3c:
            r13.end()
            return
        L40:
            r9 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L40
            throw r9     // Catch: java.lang.Throwable -> L51
        L43:
            r13.readBuffer = r7     // Catch: java.lang.Throwable -> L51
            r13.readBuffers = r7     // Catch: java.lang.Throwable -> L51
            r13.readAttachment = r7     // Catch: java.lang.Throwable -> L51
            r13.enableReading()     // Catch: java.lang.Throwable -> L51
            boolean r8 = r1 instanceof java.nio.channels.AsynchronousCloseException
            if (r8 != 0) goto L67
            goto L64
        L51:
            r8 = move-exception
            r13.enableReading()     // Catch: java.lang.Throwable -> L91
            boolean r9 = r8 instanceof java.nio.channels.ClosedChannelException     // Catch: java.lang.Throwable -> L91
            if (r9 == 0) goto L5f
            java.nio.channels.AsynchronousCloseException r9 = new java.nio.channels.AsynchronousCloseException     // Catch: java.lang.Throwable -> L91
            r9.<init>()     // Catch: java.lang.Throwable -> L91
            r8 = r9
        L5f:
            r1 = r8
            boolean r8 = r1 instanceof java.nio.channels.AsynchronousCloseException
            if (r8 != 0) goto L67
        L64:
            r13.lockAndUpdateEvents()
        L67:
            r13.end()
            if (r6 == 0) goto L71
            r8 = 0
            r6.cancel(r8)
        L71:
            if (r1 == 0) goto L74
            goto L80
        L74:
            if (r2 == 0) goto L7c
            long r7 = (long) r0
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            goto L80
        L7c:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
        L80:
            if (r3 != 0) goto L87
            r5.setResult(r7, r1)
            goto L90
        L87:
            if (r14 == 0) goto L8d
            sun.nio.ch.Invoker.invokeUnchecked(r3, r4, r7, r1)
            goto L90
        L8d:
            sun.nio.ch.Invoker.invokeIndirectly(r13, r3, r4, r7, r1)
        L90:
            return
        L91:
            r7 = move-exception
            boolean r8 = r1 instanceof java.nio.channels.AsynchronousCloseException
            if (r8 != 0) goto L99
            r13.lockAndUpdateEvents()
        L99:
            r13.end()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.UnixAsynchronousSocketChannelImpl.finishRead(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f2, code lost:
    
        if (0 == 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f5, code lost:
    
        if (r14 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f7, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0105, code lost:
    
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0106, code lost:
    
        if (r27 == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0108, code lost:
    
        if (r10 == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010a, code lost:
    
        sun.nio.ch.Invoker.invokeDirect(r9, r27, r26, r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010e, code lost:
    
        sun.nio.ch.Invoker.invokeIndirectly(r19, r27, r26, r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0111, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0117, code lost:
    
        return sun.nio.ch.CompletedFuture.withResult(r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f9, code lost:
    
        if (r20 == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fb, code lost:
    
        r3 = java.lang.Long.valueOf(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0101, code lost:
    
        r3 = java.lang.Integer.valueOf(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bf, code lost:
    
        if (1 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c1, code lost:
    
        enableReading();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c4, code lost:
    
        end();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c7, code lost:
    
        return r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00eb A[Catch: all -> 0x0118, TRY_LEAVE, TryCatch #4 {all -> 0x0118, blocks: (B:27:0x00e7, B:29:0x00eb), top: B:26:0x00e7 }] */
    @Override // sun.nio.ch.AsynchronousSocketChannelImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    <V extends java.lang.Number, A> java.util.concurrent.Future<V> implRead(boolean r20, java.nio.ByteBuffer r21, java.nio.ByteBuffer[] r22, long r23, java.util.concurrent.TimeUnit r25, A r26, java.nio.channels.CompletionHandler<V, ? super A> r27) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.UnixAsynchronousSocketChannelImpl.implRead(boolean, java.nio.ByteBuffer, java.nio.ByteBuffer[], long, java.util.concurrent.TimeUnit, java.lang.Object, java.nio.channels.CompletionHandler):java.util.concurrent.Future");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
    
        if ((r1 instanceof java.nio.channels.AsynchronousCloseException) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
    
        end();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        if (r6 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        r6.cancel(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
    
        if (r1 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        if (r2 == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
    
        r7 = java.lang.Long.valueOf(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        r7 = java.lang.Integer.valueOf(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
    
        if (r3 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0083, code lost:
    
        r5.setResult(r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        if (r14 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0089, code lost:
    
        sun.nio.ch.Invoker.invokeUnchecked(r3, r4, r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008d, code lost:
    
        sun.nio.ch.Invoker.invokeIndirectly(r13, (java.nio.channels.CompletionHandler<java.lang.Number, ? super java.lang.Object>) r3, r4, r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0064, code lost:
    
        lockAndUpdateEvents();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0062, code lost:
    
        if ((r1 instanceof java.nio.channels.AsynchronousCloseException) != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void finishWrite(boolean r14) {
        /*
            r13 = this;
            r0 = -1
            r1 = 0
            boolean r2 = r13.isGatheringWrite
            java.nio.channels.CompletionHandler<java.lang.Number, java.lang.Object> r3 = r13.writeHandler
            java.lang.Object r4 = r13.writeAttachment
            sun.nio.ch.PendingFuture<java.lang.Number, java.lang.Object> r5 = r13.writeFuture
            java.util.concurrent.Future<?> r6 = r13.writeTimer
            r7 = 0
            r13.begin()     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L1e
            java.io.FileDescriptor r8 = r13.f53714fd     // Catch: java.lang.Throwable -> L51
            java.nio.ByteBuffer[] r9 = r13.writeBuffers     // Catch: java.lang.Throwable -> L51
            sun.nio.ch.NativeDispatcher r10 = sun.nio.ch.UnixAsynchronousSocketChannelImpl.f53735nd     // Catch: java.lang.Throwable -> L51
            long r8 = sun.nio.ch.IOUtil.write(r8, r9, r10)     // Catch: java.lang.Throwable -> L51
            int r0 = (int) r8     // Catch: java.lang.Throwable -> L51
            goto L2b
        L1e:
            java.io.FileDescriptor r8 = r13.f53714fd     // Catch: java.lang.Throwable -> L51
            java.nio.ByteBuffer r9 = r13.writeBuffer     // Catch: java.lang.Throwable -> L51
            sun.nio.ch.NativeDispatcher r10 = sun.nio.ch.UnixAsynchronousSocketChannelImpl.f53735nd     // Catch: java.lang.Throwable -> L51
            r11 = -1
            int r8 = sun.nio.ch.IOUtil.write(r8, r9, r11, r10)     // Catch: java.lang.Throwable -> L51
            r0 = r8
        L2b:
            r8 = -2
            if (r0 != r8) goto L43
            java.lang.Object r8 = r13.updateLock     // Catch: java.lang.Throwable -> L51
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L51
            r9 = 1
            r13.writePending = r9     // Catch: java.lang.Throwable -> L40
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L40
            boolean r7 = r1 instanceof java.nio.channels.AsynchronousCloseException
            if (r7 != 0) goto L3c
            r13.lockAndUpdateEvents()
        L3c:
            r13.end()
            return
        L40:
            r9 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L40
            throw r9     // Catch: java.lang.Throwable -> L51
        L43:
            r13.writeBuffer = r7     // Catch: java.lang.Throwable -> L51
            r13.writeBuffers = r7     // Catch: java.lang.Throwable -> L51
            r13.writeAttachment = r7     // Catch: java.lang.Throwable -> L51
            r13.enableWriting()     // Catch: java.lang.Throwable -> L51
            boolean r8 = r1 instanceof java.nio.channels.AsynchronousCloseException
            if (r8 != 0) goto L67
            goto L64
        L51:
            r8 = move-exception
            r13.enableWriting()     // Catch: java.lang.Throwable -> L91
            boolean r9 = r8 instanceof java.nio.channels.ClosedChannelException     // Catch: java.lang.Throwable -> L91
            if (r9 == 0) goto L5f
            java.nio.channels.AsynchronousCloseException r9 = new java.nio.channels.AsynchronousCloseException     // Catch: java.lang.Throwable -> L91
            r9.<init>()     // Catch: java.lang.Throwable -> L91
            r8 = r9
        L5f:
            r1 = r8
            boolean r8 = r1 instanceof java.nio.channels.AsynchronousCloseException
            if (r8 != 0) goto L67
        L64:
            r13.lockAndUpdateEvents()
        L67:
            r13.end()
            if (r6 == 0) goto L71
            r8 = 0
            r6.cancel(r8)
        L71:
            if (r1 == 0) goto L74
            goto L80
        L74:
            if (r2 == 0) goto L7c
            long r7 = (long) r0
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            goto L80
        L7c:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
        L80:
            if (r3 != 0) goto L87
            r5.setResult(r7, r1)
            goto L90
        L87:
            if (r14 == 0) goto L8d
            sun.nio.ch.Invoker.invokeUnchecked(r3, r4, r7, r1)
            goto L90
        L8d:
            sun.nio.ch.Invoker.invokeIndirectly(r13, r3, r4, r7, r1)
        L90:
            return
        L91:
            r7 = move-exception
            boolean r8 = r1 instanceof java.nio.channels.AsynchronousCloseException
            if (r8 != 0) goto L99
            r13.lockAndUpdateEvents()
        L99:
            r13.end()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.UnixAsynchronousSocketChannelImpl.finishWrite(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bb, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c5, code lost:
    
        return r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00eb A[Catch: all -> 0x011e, TRY_LEAVE, TryCatch #7 {all -> 0x011e, blocks: (B:54:0x00e7, B:56:0x00eb), top: B:53:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ff  */
    @Override // sun.nio.ch.AsynchronousSocketChannelImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    <V extends java.lang.Number, A> java.util.concurrent.Future<V> implWrite(boolean r20, java.nio.ByteBuffer r21, java.nio.ByteBuffer[] r22, long r23, java.util.concurrent.TimeUnit r25, A r26, java.nio.channels.CompletionHandler<V, ? super A> r27) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.UnixAsynchronousSocketChannelImpl.implWrite(boolean, java.nio.ByteBuffer, java.nio.ByteBuffer[], long, java.util.concurrent.TimeUnit, java.lang.Object, java.nio.channels.CompletionHandler):java.util.concurrent.Future");
    }
}
