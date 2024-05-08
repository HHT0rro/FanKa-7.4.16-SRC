package sun.nio.ch;

import dalvik.annotation.optimization.ReachabilitySensitive;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AcceptPendingException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.CompletionHandler;
import java.nio.channels.NotYetBoundException;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import sun.nio.ch.Port;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class UnixAsynchronousServerSocketChannelImpl extends AsynchronousServerSocketChannelImpl implements Port.PollableChannel {

    /* renamed from: nd, reason: collision with root package name */
    private static final NativeDispatcher f53734nd = new SocketDispatcher();
    private AccessControlContext acceptAcc;
    private Object acceptAttachment;
    private PendingFuture<AsynchronousSocketChannel, Object> acceptFuture;
    private CompletionHandler<AsynchronousSocketChannel, Object> acceptHandler;
    private boolean acceptPending;
    private final AtomicBoolean accepting;
    private final int fdVal;

    @ReachabilitySensitive
    private final CloseGuard guard;
    private final Port port;
    private final Object updateLock;

    private native int accept0(FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2, InetSocketAddress[] inetSocketAddressArr) throws IOException;

    private static native void initIDs();

    static {
        initIDs();
    }

    private void enableAccept() {
        this.accepting.set(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixAsynchronousServerSocketChannelImpl(Port port) throws IOException {
        super(port);
        this.accepting = new AtomicBoolean();
        this.updateLock = new Object();
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        try {
            IOUtil.configureBlocking(this.f53713fd, false);
            this.port = port;
            int fdVal = IOUtil.fdVal(this.f53713fd);
            this.fdVal = fdVal;
            port.register(fdVal, this);
            closeGuard.open("close");
        } catch (IOException x10) {
            f53734nd.close(this.f53713fd);
            throw x10;
        }
    }

    @Override // sun.nio.ch.AsynchronousServerSocketChannelImpl
    void implClose() throws IOException {
        this.guard.close();
        this.port.unregister(this.fdVal);
        f53734nd.close(this.f53713fd);
        synchronized (this.updateLock) {
            if (this.acceptPending) {
                this.acceptPending = false;
                CompletionHandler<AsynchronousSocketChannel, Object> handler = this.acceptHandler;
                Object att = this.acceptAttachment;
                PendingFuture<AsynchronousSocketChannel, Object> future = this.acceptFuture;
                AsynchronousCloseException x10 = new AsynchronousCloseException();
                x10.setStackTrace(new StackTraceElement[0]);
                if (handler == null) {
                    future.setFailure(x10);
                } else {
                    Invoker.invokeIndirectly(this, handler, att, (Object) null, x10);
                }
            }
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

    @Override // sun.nio.ch.Groupable
    public AsynchronousChannelGroupImpl group() {
        return this.port;
    }

    @Override // sun.nio.ch.Port.PollableChannel
    public void onEvent(int events, boolean mayInvokeDirect) {
        synchronized (this.updateLock) {
            if (this.acceptPending) {
                this.acceptPending = false;
                FileDescriptor newfd = new FileDescriptor();
                InetSocketAddress[] isaa = new InetSocketAddress[1];
                Throwable exc = null;
                try {
                    begin();
                    int n10 = accept(this.f53713fd, newfd, isaa);
                    if (n10 == -2) {
                        synchronized (this.updateLock) {
                            this.acceptPending = true;
                        }
                        this.port.startPoll(this.fdVal, Net.POLLIN);
                        return;
                    }
                } catch (Throwable th) {
                    x = th;
                    try {
                        if (x instanceof ClosedChannelException) {
                            x = new AsynchronousCloseException();
                        }
                        exc = x;
                    } finally {
                        end();
                    }
                }
                end();
                AsynchronousSocketChannel child = null;
                if (exc == null) {
                    try {
                        child = finishAccept(newfd, isaa[0], this.acceptAcc);
                    } catch (Throwable th2) {
                        x = th2;
                        if (!(x instanceof IOException) && !(x instanceof SecurityException)) {
                            x = new IOException(x);
                        }
                        exc = x;
                    }
                }
                CompletionHandler<AsynchronousSocketChannel, Object> handler = this.acceptHandler;
                Object att = this.acceptAttachment;
                PendingFuture<AsynchronousSocketChannel, Object> future = this.acceptFuture;
                enableAccept();
                if (handler == null) {
                    future.setResult(child, exc);
                    if (child != null && future.isCancelled()) {
                        try {
                            child.close();
                            return;
                        } catch (IOException e2) {
                            return;
                        }
                    }
                    return;
                }
                Invoker.invoke(this, handler, att, child, exc);
            }
        }
    }

    private AsynchronousSocketChannel finishAccept(FileDescriptor newfd, final InetSocketAddress remote, AccessControlContext acc) throws IOException, SecurityException {
        try {
            AsynchronousSocketChannel ch = new UnixAsynchronousSocketChannelImpl(this.port, newfd, remote);
            try {
                if (acc != null) {
                    AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: sun.nio.ch.UnixAsynchronousServerSocketChannelImpl.1
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            SecurityManager sm = System.getSecurityManager();
                            if (sm != null) {
                                sm.checkAccept(remote.getAddress().getHostAddress(), remote.getPort());
                                return null;
                            }
                            return null;
                        }
                    }, acc);
                } else {
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        sm.checkAccept(remote.getAddress().getHostAddress(), remote.getPort());
                    }
                }
                return ch;
            } catch (SecurityException x10) {
                try {
                    ch.close();
                } catch (Throwable suppressed) {
                    x10.addSuppressed(suppressed);
                }
                throw x10;
            }
        } catch (IOException x11) {
            f53734nd.close(newfd);
            throw x11;
        }
    }

    @Override // sun.nio.ch.AsynchronousServerSocketChannelImpl
    Future<AsynchronousSocketChannel> implAccept(Object att, CompletionHandler<AsynchronousSocketChannel, Object> handler) {
        if (!isOpen()) {
            Throwable e2 = new ClosedChannelException();
            if (handler == null) {
                return CompletedFuture.withFailure(e2);
            }
            Invoker.invoke(this, handler, att, null, e2);
            return null;
        }
        if (this.localAddress == null) {
            throw new NotYetBoundException();
        }
        if (isAcceptKilled()) {
            throw new RuntimeException("Accept not allowed due cancellation");
        }
        if (!this.accepting.compareAndSet(false, true)) {
            throw new AcceptPendingException();
        }
        FileDescriptor newfd = new FileDescriptor();
        InetSocketAddress[] isaa = new InetSocketAddress[1];
        Throwable exc = null;
        try {
            begin();
            int n10 = accept(this.f53713fd, newfd, isaa);
            if (n10 == -2) {
                PendingFuture<AsynchronousSocketChannel, Object> result = null;
                synchronized (this.updateLock) {
                    if (handler == null) {
                        this.acceptHandler = null;
                        result = new PendingFuture<>(this);
                        this.acceptFuture = result;
                    } else {
                        this.acceptHandler = handler;
                        this.acceptAttachment = att;
                    }
                    this.acceptAcc = System.getSecurityManager() == null ? null : AccessController.getContext();
                    this.acceptPending = true;
                }
                this.port.startPoll(this.fdVal, Net.POLLIN);
                return result;
            }
        } catch (Throwable th) {
            x = th;
            try {
                if (x instanceof ClosedChannelException) {
                    x = new AsynchronousCloseException();
                }
                exc = x;
            } finally {
                end();
            }
        }
        end();
        AsynchronousSocketChannel child = null;
        if (exc == null) {
            try {
                child = finishAccept(newfd, isaa[0], null);
            } catch (Throwable x10) {
                exc = x10;
            }
        }
        enableAccept();
        if (handler == null) {
            return CompletedFuture.withResult(child, exc);
        }
        Invoker.invokeIndirectly(this, (CompletionHandler<AsynchronousSocketChannel, ? super Object>) handler, att, child, exc);
        return null;
    }

    private int accept(FileDescriptor ssfd, FileDescriptor newfd, InetSocketAddress[] isaa) throws IOException {
        return accept0(ssfd, newfd, isaa);
    }
}
