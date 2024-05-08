package sun.nio.ch;

import com.huawei.openalliance.ad.constant.u;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyBoundException;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.CompletionHandler;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NetworkChannel;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.ReadPendingException;
import java.nio.channels.WritePendingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import jdk.net.ExtendedSocketOptions;
import sun.net.ExtendedOptionsImpl;
import sun.net.NetHooks;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AsynchronousSocketChannelImpl extends AsynchronousSocketChannel implements Cancellable, Groupable {
    static final int ST_CONNECTED = 2;
    static final int ST_PENDING = 1;
    static final int ST_UNCONNECTED = 0;
    static final int ST_UNINITIALIZED = -1;
    private final ReadWriteLock closeLock;

    /* renamed from: fd, reason: collision with root package name */
    protected final FileDescriptor f53714fd;
    private boolean isReuseAddress;
    protected volatile InetSocketAddress localAddress;
    private volatile boolean open;
    private boolean readKilled;
    private final Object readLock;
    private boolean readShutdown;
    private boolean reading;
    protected volatile InetSocketAddress remoteAddress;
    protected volatile int state;
    protected final Object stateLock;
    private boolean writeKilled;
    private final Object writeLock;
    private boolean writeShutdown;
    private boolean writing;

    abstract void implClose() throws IOException;

    abstract <A> Future<Void> implConnect(SocketAddress socketAddress, A a10, CompletionHandler<Void, ? super A> completionHandler);

    abstract <V extends Number, A> Future<V> implRead(boolean z10, ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, long j10, TimeUnit timeUnit, A a10, CompletionHandler<V, ? super A> completionHandler);

    abstract <V extends Number, A> Future<V> implWrite(boolean z10, ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, long j10, TimeUnit timeUnit, A a10, CompletionHandler<V, ? super A> completionHandler);

    @Override // java.nio.channels.AsynchronousSocketChannel, java.nio.channels.NetworkChannel
    public /* bridge */ /* synthetic */ NetworkChannel setOption(SocketOption socketOption, Object obj) throws IOException {
        return setOption((SocketOption<SocketOption>) socketOption, (SocketOption) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsynchronousSocketChannelImpl(AsynchronousChannelGroupImpl group) throws IOException {
        super(group.provider());
        this.stateLock = new Object();
        this.localAddress = null;
        this.remoteAddress = null;
        this.state = -1;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.closeLock = new ReentrantReadWriteLock();
        this.open = true;
        this.f53714fd = Net.socket(true);
        this.state = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsynchronousSocketChannelImpl(AsynchronousChannelGroupImpl group, FileDescriptor fd2, InetSocketAddress remote) throws IOException {
        super(group.provider());
        this.stateLock = new Object();
        this.localAddress = null;
        this.remoteAddress = null;
        this.state = -1;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.closeLock = new ReentrantReadWriteLock();
        this.open = true;
        this.f53714fd = fd2;
        this.state = 2;
        this.localAddress = Net.localAddress(fd2);
        this.remoteAddress = remote;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void enableReading(boolean killed) {
        synchronized (this.readLock) {
            this.reading = false;
            if (killed) {
                this.readKilled = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void enableReading() {
        enableReading(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void enableWriting(boolean killed) {
        synchronized (this.writeLock) {
            this.writing = false;
            if (killed) {
                this.writeKilled = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void enableWriting() {
        enableWriting(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void killReading() {
        synchronized (this.readLock) {
            this.readKilled = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void killWriting() {
        synchronized (this.writeLock) {
            this.writeKilled = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void killConnect() {
        killReading();
        killWriting();
    }

    @Override // java.nio.channels.AsynchronousSocketChannel
    public final Future<Void> connect(SocketAddress remote) {
        return implConnect(remote, null, null);
    }

    @Override // java.nio.channels.AsynchronousSocketChannel
    public final <A> void connect(SocketAddress remote, A attachment, CompletionHandler<Void, ? super A> handler) {
        if (handler == null) {
            throw new NullPointerException("'handler' is null");
        }
        implConnect(remote, attachment, handler);
    }

    private <V extends Number, A> Future<V> read(boolean isScatteringRead, ByteBuffer dst, ByteBuffer[] dsts, long timeout, TimeUnit unit, A att, CompletionHandler<V, ? super A> handler) {
        Number result;
        if (!isOpen()) {
            Throwable e2 = new ClosedChannelException();
            if (handler == null) {
                return CompletedFuture.withFailure(e2);
            }
            Invoker.invoke(this, handler, att, null, e2);
            return null;
        }
        if (this.remoteAddress == null) {
            throw new NotYetConnectedException();
        }
        boolean hasSpaceToRead = isScatteringRead || dst.hasRemaining();
        boolean shutdown = false;
        synchronized (this.readLock) {
            if (this.readKilled) {
                throw new IllegalStateException("Reading not allowed due to timeout or cancellation");
            }
            if (this.reading) {
                throw new ReadPendingException();
            }
            if (this.readShutdown) {
                shutdown = true;
            } else if (hasSpaceToRead) {
                this.reading = true;
            }
        }
        if (shutdown || !hasSpaceToRead) {
            if (isScatteringRead) {
                result = Long.valueOf(shutdown ? -1L : 0L);
            } else {
                result = Integer.valueOf(shutdown ? -1 : 0);
            }
            if (handler == null) {
                return CompletedFuture.withResult(result);
            }
            Invoker.invoke(this, handler, att, result, null);
            return null;
        }
        return implRead(isScatteringRead, dst, dsts, timeout, unit, att, handler);
    }

    @Override // java.nio.channels.AsynchronousSocketChannel, java.nio.channels.AsynchronousByteChannel
    public final Future<Integer> read(ByteBuffer dst) {
        if (dst.isReadOnly()) {
            throw new IllegalArgumentException("Read-only buffer");
        }
        return read(false, dst, (ByteBuffer[]) null, 0L, TimeUnit.MILLISECONDS, (TimeUnit) null, (CompletionHandler<V, ? super TimeUnit>) null);
    }

    @Override // java.nio.channels.AsynchronousSocketChannel
    public final <A> void read(ByteBuffer dst, long timeout, TimeUnit unit, A attachment, CompletionHandler<Integer, ? super A> handler) {
        if (handler == null) {
            throw new NullPointerException("'handler' is null");
        }
        if (dst.isReadOnly()) {
            throw new IllegalArgumentException("Read-only buffer");
        }
        read(false, dst, (ByteBuffer[]) null, timeout, unit, (TimeUnit) attachment, (CompletionHandler<V, ? super TimeUnit>) handler);
    }

    @Override // java.nio.channels.AsynchronousSocketChannel
    public final <A> void read(ByteBuffer[] dsts, int offset, int length, long timeout, TimeUnit unit, A attachment, CompletionHandler<Long, ? super A> handler) {
        if (handler == null) {
            throw new NullPointerException("'handler' is null");
        }
        if (offset >= 0 && length >= 0) {
            if (offset <= dsts.length - length) {
                ByteBuffer[] bufs = Util.subsequence(dsts, offset, length);
                for (ByteBuffer byteBuffer : bufs) {
                    if (byteBuffer.isReadOnly()) {
                        throw new IllegalArgumentException("Read-only buffer");
                    }
                }
                read(true, (ByteBuffer) null, bufs, timeout, unit, (TimeUnit) attachment, (CompletionHandler<V, ? super TimeUnit>) handler);
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private <V extends Number, A> Future<V> write(boolean isGatheringWrite, ByteBuffer src, ByteBuffer[] srcs, long timeout, TimeUnit unit, A att, CompletionHandler<V, ? super A> handler) {
        boolean hasDataToWrite = isGatheringWrite || src.hasRemaining();
        boolean closed = false;
        if (isOpen()) {
            if (this.remoteAddress == null) {
                throw new NotYetConnectedException();
            }
            synchronized (this.writeLock) {
                if (this.writeKilled) {
                    throw new IllegalStateException("Writing not allowed due to timeout or cancellation");
                }
                if (this.writing) {
                    throw new WritePendingException();
                }
                if (this.writeShutdown) {
                    closed = true;
                } else if (hasDataToWrite) {
                    this.writing = true;
                }
            }
        } else {
            closed = true;
        }
        if (closed) {
            Throwable e2 = new ClosedChannelException();
            if (handler == null) {
                return CompletedFuture.withFailure(e2);
            }
            Invoker.invoke(this, handler, att, null, e2);
            return null;
        }
        if (!hasDataToWrite) {
            Number result = isGatheringWrite ? 0L : 0;
            if (handler == null) {
                return CompletedFuture.withResult(result);
            }
            Invoker.invoke(this, handler, att, result, null);
            return null;
        }
        return implWrite(isGatheringWrite, src, srcs, timeout, unit, att, handler);
    }

    @Override // java.nio.channels.AsynchronousSocketChannel, java.nio.channels.AsynchronousByteChannel
    public final Future<Integer> write(ByteBuffer src) {
        return write(false, src, (ByteBuffer[]) null, 0L, TimeUnit.MILLISECONDS, (TimeUnit) null, (CompletionHandler<V, ? super TimeUnit>) null);
    }

    @Override // java.nio.channels.AsynchronousSocketChannel
    public final <A> void write(ByteBuffer src, long timeout, TimeUnit unit, A attachment, CompletionHandler<Integer, ? super A> handler) {
        if (handler == null) {
            throw new NullPointerException("'handler' is null");
        }
        write(false, src, (ByteBuffer[]) null, timeout, unit, (TimeUnit) attachment, (CompletionHandler<V, ? super TimeUnit>) handler);
    }

    @Override // java.nio.channels.AsynchronousSocketChannel
    public final <A> void write(ByteBuffer[] srcs, int offset, int length, long timeout, TimeUnit unit, A attachment, CompletionHandler<Long, ? super A> handler) {
        if (handler == null) {
            throw new NullPointerException("'handler' is null");
        }
        if (offset >= 0 && length >= 0) {
            if (offset <= srcs.length - length) {
                write(true, (ByteBuffer) null, Util.subsequence(srcs, offset, length), timeout, unit, (TimeUnit) attachment, (CompletionHandler<V, ? super TimeUnit>) handler);
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.nio.channels.AsynchronousSocketChannel, java.nio.channels.NetworkChannel
    public final AsynchronousSocketChannel bind(SocketAddress local) throws IOException {
        try {
            begin();
            synchronized (this.stateLock) {
                if (this.state == 1) {
                    throw new ConnectionPendingException();
                }
                if (this.localAddress != null) {
                    throw new AlreadyBoundException();
                }
                InetSocketAddress isa = local == null ? new InetSocketAddress(0) : Net.checkAddress(local);
                SecurityManager sm = System.getSecurityManager();
                if (sm != null) {
                    sm.checkListen(isa.getPort());
                }
                NetHooks.beforeTcpBind(this.f53714fd, isa.getAddress(), isa.getPort());
                Net.bind(this.f53714fd, isa.getAddress(), isa.getPort());
                this.localAddress = Net.localAddress(this.f53714fd);
            }
            return this;
        } finally {
            end();
        }
    }

    @Override // java.nio.channels.AsynchronousSocketChannel, java.nio.channels.NetworkChannel
    public final SocketAddress getLocalAddress() throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        return Net.getRevealedLocalAddress(this.localAddress);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.nio.channels.AsynchronousSocketChannel, java.nio.channels.NetworkChannel
    public final <T> AsynchronousSocketChannel setOption(SocketOption<T> name, T t2) throws IOException {
        if (name == null) {
            throw new NullPointerException();
        }
        if (!supportedOptions().contains(name)) {
            throw new UnsupportedOperationException("'" + ((Object) name) + "' not supported");
        }
        try {
            begin();
            if (this.writeShutdown) {
                throw new IOException("Connection has been shutdown for writing");
            }
            if (name == StandardSocketOptions.SO_REUSEADDR && Net.useExclusiveBind()) {
                this.isReuseAddress = ((Boolean) t2).booleanValue();
            } else {
                Net.setSocketOption(this.f53714fd, Net.UNSPEC, name, t2);
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
            return (T) Net.getSocketOption(this.f53714fd, Net.UNSPEC, socketOption);
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
            HashSet<SocketOption<?>> set = new HashSet<>(5);
            set.add(StandardSocketOptions.SO_SNDBUF);
            set.add(StandardSocketOptions.SO_RCVBUF);
            set.add(StandardSocketOptions.SO_KEEPALIVE);
            set.add(StandardSocketOptions.SO_REUSEADDR);
            set.add(StandardSocketOptions.TCP_NODELAY);
            if (ExtendedOptionsImpl.flowSupported()) {
                set.add(ExtendedSocketOptions.SO_FLOW_SLA);
            }
            return Collections.unmodifiableSet(set);
        }
    }

    @Override // java.nio.channels.NetworkChannel
    public final Set<SocketOption<?>> supportedOptions() {
        return DefaultOptionsHolder.defaultOptions;
    }

    @Override // java.nio.channels.AsynchronousSocketChannel
    public final SocketAddress getRemoteAddress() throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        return this.remoteAddress;
    }

    @Override // java.nio.channels.AsynchronousSocketChannel
    public final AsynchronousSocketChannel shutdownInput() throws IOException {
        try {
            begin();
            if (this.remoteAddress == null) {
                throw new NotYetConnectedException();
            }
            synchronized (this.readLock) {
                if (!this.readShutdown) {
                    Net.shutdown(this.f53714fd, 0);
                    this.readShutdown = true;
                }
            }
            return this;
        } finally {
            end();
        }
    }

    @Override // java.nio.channels.AsynchronousSocketChannel
    public final AsynchronousSocketChannel shutdownOutput() throws IOException {
        try {
            begin();
            if (this.remoteAddress == null) {
                throw new NotYetConnectedException();
            }
            synchronized (this.writeLock) {
                if (!this.writeShutdown) {
                    Net.shutdown(this.f53714fd, 1);
                    this.writeShutdown = true;
                }
            }
            return this;
        } finally {
            end();
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getName());
        sb2.append('[');
        synchronized (this.stateLock) {
            if (!isOpen()) {
                sb2.append("closed");
            } else {
                switch (this.state) {
                    case 0:
                        sb2.append("unconnected");
                        break;
                    case 1:
                        sb2.append("connection-pending");
                        break;
                    case 2:
                        sb2.append(u.bf);
                        if (this.readShutdown) {
                            sb2.append(" ishut");
                        }
                        if (this.writeShutdown) {
                            sb2.append(" oshut");
                            break;
                        }
                        break;
                }
                if (this.localAddress != null) {
                    sb2.append(" local=");
                    sb2.append(Net.getRevealedLocalAddressAsString(this.localAddress));
                }
                if (this.remoteAddress != null) {
                    sb2.append(" remote=");
                    sb2.append(this.remoteAddress.toString());
                }
            }
        }
        sb2.append(']');
        return sb2.toString();
    }
}
