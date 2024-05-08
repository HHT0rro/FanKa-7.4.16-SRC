package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.AlreadyBoundException;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.CompletionHandler;
import java.nio.channels.NetworkChannel;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import sun.net.NetHooks;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
abstract class AsynchronousServerSocketChannelImpl extends AsynchronousServerSocketChannel implements Cancellable, Groupable {
    private volatile boolean acceptKilled;
    private ReadWriteLock closeLock;

    /* renamed from: fd, reason: collision with root package name */
    protected final FileDescriptor f53713fd;
    private boolean isReuseAddress;
    protected volatile InetSocketAddress localAddress;
    private volatile boolean open;
    private final Object stateLock;

    abstract Future<AsynchronousSocketChannel> implAccept(Object obj, CompletionHandler<AsynchronousSocketChannel, Object> completionHandler);

    abstract void implClose() throws IOException;

    @Override // java.nio.channels.AsynchronousServerSocketChannel, java.nio.channels.NetworkChannel
    public /* bridge */ /* synthetic */ NetworkChannel setOption(SocketOption socketOption, Object obj) throws IOException {
        return setOption((SocketOption<SocketOption>) socketOption, (SocketOption) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsynchronousServerSocketChannelImpl(AsynchronousChannelGroupImpl group) {
        super(group.provider());
        this.localAddress = null;
        this.stateLock = new Object();
        this.closeLock = new ReentrantReadWriteLock();
        this.open = true;
        this.f53713fd = Net.serverSocket(true);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.open;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void begin() throws IOException {
        this.closeLock.readLock().lock();
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void end() {
        this.closeLock.readLock().unlock();
    }

    @Override // java.nio.channels.AsynchronousChannel, java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.closeLock.writeLock().lock();
        try {
            if (!this.open) {
                return;
            }
            this.open = false;
            this.closeLock.writeLock().unlock();
            implClose();
        } finally {
            this.closeLock.writeLock().unlock();
        }
    }

    @Override // java.nio.channels.AsynchronousServerSocketChannel
    public final Future<AsynchronousSocketChannel> accept() {
        return implAccept(null, null);
    }

    @Override // java.nio.channels.AsynchronousServerSocketChannel
    public final <A> void accept(A attachment, CompletionHandler<AsynchronousSocketChannel, ? super A> handler) {
        if (handler == null) {
            throw new NullPointerException("'handler' is null");
        }
        implAccept(attachment, handler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isAcceptKilled() {
        return this.acceptKilled;
    }

    @Override // sun.nio.ch.Cancellable
    public final void onCancel(PendingFuture<?, ?> task) {
        this.acceptKilled = true;
    }

    @Override // java.nio.channels.AsynchronousServerSocketChannel
    public final AsynchronousServerSocketChannel bind(SocketAddress local, int backlog) throws IOException {
        InetSocketAddress isa = local == null ? new InetSocketAddress(0) : Net.checkAddress(local);
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkListen(isa.getPort());
        }
        try {
            begin();
            synchronized (this.stateLock) {
                if (this.localAddress != null) {
                    throw new AlreadyBoundException();
                }
                NetHooks.beforeTcpBind(this.f53713fd, isa.getAddress(), isa.getPort());
                Net.bind(this.f53713fd, isa.getAddress(), isa.getPort());
                Net.listen(this.f53713fd, backlog < 1 ? 50 : backlog);
                this.localAddress = Net.localAddress(this.f53713fd);
            }
            return this;
        } finally {
            end();
        }
    }

    @Override // java.nio.channels.AsynchronousServerSocketChannel, java.nio.channels.NetworkChannel
    public final SocketAddress getLocalAddress() throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        return Net.getRevealedLocalAddress(this.localAddress);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.nio.channels.AsynchronousServerSocketChannel, java.nio.channels.NetworkChannel
    public final <T> AsynchronousServerSocketChannel setOption(SocketOption<T> name, T t2) throws IOException {
        if (name == null) {
            throw new NullPointerException();
        }
        if (!supportedOptions().contains(name)) {
            throw new UnsupportedOperationException("'" + ((Object) name) + "' not supported");
        }
        try {
            begin();
            if (name == StandardSocketOptions.SO_REUSEADDR && Net.useExclusiveBind()) {
                this.isReuseAddress = ((Boolean) t2).booleanValue();
            } else {
                Net.setSocketOption(this.f53713fd, Net.UNSPEC, name, t2);
            }
            return this;
        } finally {
            end();
        }
    }

    @Override // java.nio.channels.NetworkChannel
    public final <T> T getOption(SocketOption<T> socketOption) throws IOException {
        if (socketOption == null) {
            throw new NullPointerException();
        }
        if (!supportedOptions().contains(socketOption)) {
            throw new UnsupportedOperationException("'" + ((Object) socketOption) + "' not supported");
        }
        try {
            begin();
            if (socketOption == StandardSocketOptions.SO_REUSEADDR && Net.useExclusiveBind()) {
                return (T) Boolean.valueOf(this.isReuseAddress);
            }
            return (T) Net.getSocketOption(this.f53713fd, Net.UNSPEC, socketOption);
        } finally {
            end();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class DefaultOptionsHolder {
        static final Set<SocketOption<?>> defaultOptions = defaultOptions();

        private DefaultOptionsHolder() {
        }

        private static Set<SocketOption<?>> defaultOptions() {
            HashSet<SocketOption<?>> set = new HashSet<>(2);
            set.add(StandardSocketOptions.SO_RCVBUF);
            set.add(StandardSocketOptions.SO_REUSEADDR);
            return Collections.unmodifiableSet(set);
        }
    }

    @Override // java.nio.channels.NetworkChannel
    public final Set<SocketOption<?>> supportedOptions() {
        return DefaultOptionsHolder.defaultOptions;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getName());
        sb2.append('[');
        if (!isOpen()) {
            sb2.append("closed");
        } else if (this.localAddress == null) {
            sb2.append("unbound");
        } else {
            sb2.append(Net.getRevealedLocalAddressAsString(this.localAddress));
        }
        sb2.append(']');
        return sb2.toString();
    }
}
