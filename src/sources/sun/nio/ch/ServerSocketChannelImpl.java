package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProtocolFamily;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.channels.AlreadyBoundException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NetworkChannel;
import java.nio.channels.NotYetBoundException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import sun.net.NetHooks;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ServerSocketChannelImpl extends ServerSocketChannel implements SelChImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ST_INUSE = 0;
    private static final int ST_KILLED = 1;
    private static final int ST_UNINITIALIZED = -1;

    /* renamed from: nd, reason: collision with root package name */
    private static NativeDispatcher f53724nd;

    /* renamed from: fd, reason: collision with root package name */
    private final FileDescriptor f53725fd;
    private int fdVal;
    private boolean isReuseAddress;
    private InetSocketAddress localAddress;
    private final Object lock;
    ServerSocket socket;
    private int state;
    private final Object stateLock;
    private volatile long thread;

    private native int accept0(FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2, InetSocketAddress[] inetSocketAddressArr) throws IOException;

    private static native void initIDs();

    static {
        initIDs();
        f53724nd = new SocketDispatcher();
    }

    @Override // java.nio.channels.ServerSocketChannel, java.nio.channels.NetworkChannel
    public /* bridge */ /* synthetic */ NetworkChannel setOption(SocketOption socketOption, Object obj) throws IOException {
        return setOption((SocketOption<SocketOption>) socketOption, (SocketOption) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServerSocketChannelImpl(SelectorProvider sp) throws IOException {
        super(sp);
        this.thread = 0L;
        this.lock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        FileDescriptor serverSocket = Net.serverSocket(true);
        this.f53725fd = serverSocket;
        this.fdVal = IOUtil.fdVal(serverSocket);
        this.state = 0;
    }

    ServerSocketChannelImpl(SelectorProvider sp, FileDescriptor fd2, boolean bound) throws IOException {
        super(sp);
        this.thread = 0L;
        this.lock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        this.f53725fd = fd2;
        this.fdVal = IOUtil.fdVal(fd2);
        this.state = 0;
        if (bound) {
            this.localAddress = Net.localAddress(fd2);
        }
    }

    @Override // java.nio.channels.ServerSocketChannel
    public ServerSocket socket() {
        ServerSocket serverSocket;
        synchronized (this.stateLock) {
            if (this.socket == null) {
                this.socket = ServerSocketAdaptor.create(this);
            }
            serverSocket = this.socket;
        }
        return serverSocket;
    }

    @Override // java.nio.channels.ServerSocketChannel, java.nio.channels.NetworkChannel
    public SocketAddress getLocalAddress() throws IOException {
        InetSocketAddress inetSocketAddress;
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            inetSocketAddress = this.localAddress;
            if (inetSocketAddress != null) {
                inetSocketAddress = Net.getRevealedLocalAddress(Net.asInetSocketAddress(inetSocketAddress));
            }
        }
        return inetSocketAddress;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.nio.channels.ServerSocketChannel, java.nio.channels.NetworkChannel
    public <T> ServerSocketChannel setOption(SocketOption<T> name, T t2) throws IOException {
        if (name == null) {
            throw new NullPointerException();
        }
        if (!supportedOptions().contains(name)) {
            throw new UnsupportedOperationException("'" + ((Object) name) + "' not supported");
        }
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (name == StandardSocketOptions.IP_TOS) {
                ProtocolFamily family = Net.isIPv6Available() ? StandardProtocolFamily.INET6 : StandardProtocolFamily.INET;
                Net.setSocketOption(this.f53725fd, family, name, t2);
                return this;
            }
            if (name == StandardSocketOptions.SO_REUSEADDR && Net.useExclusiveBind()) {
                this.isReuseAddress = ((Boolean) t2).booleanValue();
            } else {
                Net.setSocketOption(this.f53725fd, Net.UNSPEC, name, t2);
            }
            return this;
        }
    }

    @Override // java.nio.channels.NetworkChannel
    public <T> T getOption(SocketOption<T> socketOption) throws IOException {
        if (socketOption == null) {
            throw new NullPointerException();
        }
        if (!supportedOptions().contains(socketOption)) {
            throw new UnsupportedOperationException("'" + ((Object) socketOption) + "' not supported");
        }
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (socketOption == StandardSocketOptions.SO_REUSEADDR && Net.useExclusiveBind()) {
                return (T) Boolean.valueOf(this.isReuseAddress);
            }
            return (T) Net.getSocketOption(this.f53725fd, Net.UNSPEC, socketOption);
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
            set.add(StandardSocketOptions.IP_TOS);
            return Collections.unmodifiableSet(set);
        }
    }

    @Override // java.nio.channels.NetworkChannel
    public final Set<SocketOption<?>> supportedOptions() {
        return DefaultOptionsHolder.defaultOptions;
    }

    public boolean isBound() {
        boolean z10;
        synchronized (this.stateLock) {
            z10 = this.localAddress != null;
        }
        return z10;
    }

    public InetSocketAddress localAddress() {
        InetSocketAddress inetSocketAddress;
        synchronized (this.stateLock) {
            inetSocketAddress = this.localAddress;
        }
        return inetSocketAddress;
    }

    @Override // java.nio.channels.ServerSocketChannel
    public ServerSocketChannel bind(SocketAddress local, int backlog) throws IOException {
        synchronized (this.lock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (isBound()) {
                throw new AlreadyBoundException();
            }
            InetSocketAddress isa = local == null ? new InetSocketAddress(0) : Net.checkAddress(local);
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkListen(isa.getPort());
            }
            NetHooks.beforeTcpBind(this.f53725fd, isa.getAddress(), isa.getPort());
            Net.bind(this.f53725fd, isa.getAddress(), isa.getPort());
            Net.listen(this.f53725fd, backlog < 1 ? 50 : backlog);
            synchronized (this.stateLock) {
                this.localAddress = Net.localAddress(this.f53725fd);
            }
        }
        return this;
    }

    @Override // java.nio.channels.ServerSocketChannel
    public SocketChannel accept() throws IOException {
        synchronized (this.lock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (!isBound()) {
                throw new NotYetBoundException();
            }
            int n10 = 0;
            FileDescriptor newfd = new FileDescriptor();
            boolean z10 = true;
            InetSocketAddress[] isaa = new InetSocketAddress[1];
            try {
                begin();
                if (!isOpen()) {
                    return null;
                }
                this.thread = NativeThread.current();
                do {
                    n10 = accept(this.f53725fd, newfd, isaa);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
                this.thread = 0L;
                end(n10 > 0);
                if (n10 < 1) {
                    return null;
                }
                IOUtil.configureBlocking(newfd, true);
                InetSocketAddress isa = isaa[0];
                SocketChannel sc2 = new SocketChannelImpl(provider(), newfd, isa);
                SecurityManager sm = System.getSecurityManager();
                if (sm != null) {
                    try {
                        sm.checkAccept(isa.getAddress().getHostAddress(), isa.getPort());
                    } catch (SecurityException x10) {
                        sc2.close();
                        throw x10;
                    }
                }
                return sc2;
            } finally {
                this.thread = 0L;
                if (n10 <= 0) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implConfigureBlocking(boolean block) throws IOException {
        IOUtil.configureBlocking(this.f53725fd, block);
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implCloseSelectableChannel() throws IOException {
        synchronized (this.stateLock) {
            if (this.state != 1) {
                f53724nd.preClose(this.f53725fd);
            }
            long th = this.thread;
            if (th != 0) {
                NativeThread.signal(th);
            }
            if (!isRegistered()) {
                kill();
            }
        }
    }

    @Override // sun.nio.ch.SelChImpl
    public void kill() throws IOException {
        synchronized (this.stateLock) {
            int i10 = this.state;
            if (i10 == 1) {
                return;
            }
            if (i10 == -1) {
                this.state = 1;
            } else {
                f53724nd.close(this.f53725fd);
                this.state = 1;
            }
        }
    }

    public boolean translateReadyOps(int ops, int initialOps, SelectionKeyImpl sk) {
        int intOps = sk.nioInterestOps();
        int oldOps = sk.nioReadyOps();
        int newOps = initialOps;
        if ((Net.POLLNVAL & ops) != 0) {
            return false;
        }
        if (((Net.POLLERR | Net.POLLHUP) & ops) != 0) {
            sk.nioReadyOps(intOps);
            return ((~oldOps) & intOps) != 0;
        }
        if ((Net.POLLIN & ops) != 0 && (intOps & 16) != 0) {
            newOps |= 16;
        }
        sk.nioReadyOps(newOps);
        return ((~oldOps) & newOps) != 0;
    }

    @Override // sun.nio.ch.SelChImpl
    public boolean translateAndUpdateReadyOps(int ops, SelectionKeyImpl sk) {
        return translateReadyOps(ops, sk.nioReadyOps(), sk);
    }

    @Override // sun.nio.ch.SelChImpl
    public boolean translateAndSetReadyOps(int ops, SelectionKeyImpl sk) {
        return translateReadyOps(ops, 0, sk);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int poll(int events, long timeout) throws IOException {
        synchronized (this.lock) {
            boolean z10 = true;
            try {
                begin();
                synchronized (this.stateLock) {
                    if (!isOpen()) {
                        return 0;
                    }
                    this.thread = NativeThread.current();
                    int n10 = Net.poll(this.f53725fd, events, timeout);
                    this.thread = 0L;
                    if (n10 <= 0) {
                        z10 = false;
                    }
                    end(z10);
                    return n10;
                }
            } finally {
                this.thread = 0L;
                if (0 <= 0) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    @Override // sun.nio.ch.SelChImpl
    public void translateAndSetInterestOps(int ops, SelectionKeyImpl sk) {
        int newOps = (ops & 16) != 0 ? 0 | Net.POLLIN : 0;
        sk.selector.putEventOps(sk, newOps);
    }

    @Override // sun.nio.ch.SelChImpl
    public FileDescriptor getFD() {
        return this.f53725fd;
    }

    @Override // sun.nio.ch.SelChImpl
    public int getFDVal() {
        return this.fdVal;
    }

    public String toString() {
        StringBuffer sb2 = new StringBuffer();
        sb2.append(getClass().getName());
        sb2.append('[');
        if (!isOpen()) {
            sb2.append("closed");
        } else {
            synchronized (this.stateLock) {
                InetSocketAddress addr = localAddress();
                if (addr == null) {
                    sb2.append("unbound");
                } else {
                    sb2.append(Net.getRevealedLocalAddressAsString(addr));
                }
            }
        }
        sb2.append(']');
        return sb2.toString();
    }

    private int accept(FileDescriptor ssfd, FileDescriptor newfd, InetSocketAddress[] isaa) throws IOException {
        return accept0(ssfd, newfd, isaa);
    }
}
