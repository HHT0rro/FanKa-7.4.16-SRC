package sun.nio.ch;

import dalvik.annotation.optimization.ReachabilitySensitive;
import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.PortUnreachableException;
import java.net.ProtocolFamily;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyBoundException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.MembershipKey;
import java.nio.channels.NetworkChannel;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.UnsupportedAddressTypeException;
import java.nio.channels.spi.SelectorProvider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import jdk.net.ExtendedSocketOptions;
import sun.net.ExtendedOptionsImpl;
import sun.net.ResourceManager;
import sun.nio.ch.MembershipKeyImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DatagramChannelImpl extends DatagramChannel implements SelChImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ST_CONNECTED = 1;
    private static final int ST_KILLED = 2;
    private static final int ST_UNCONNECTED = 0;
    private static final int ST_UNINITIALIZED = -1;

    /* renamed from: nd, reason: collision with root package name */
    private static NativeDispatcher f53717nd = new DatagramDispatcher();
    private InetAddress cachedSenderInetAddress;
    private int cachedSenderPort;
    private final ProtocolFamily family;

    /* renamed from: fd, reason: collision with root package name */
    @ReachabilitySensitive
    final FileDescriptor f53718fd;
    private final int fdVal;

    @ReachabilitySensitive
    private final CloseGuard guard;
    private boolean isReuseAddress;
    private InetSocketAddress localAddress;
    private final Object readLock;
    private volatile long readerThread;
    private MembershipRegistry registry;
    private InetSocketAddress remoteAddress;
    private boolean reuseAddressEmulated;
    private SocketAddress sender;
    private DatagramSocket socket;
    private int state;
    private final Object stateLock;
    private final Object writeLock;
    private volatile long writerThread;

    private static native void disconnect0(FileDescriptor fileDescriptor, boolean z10) throws IOException;

    private static native void initIDs();

    private native int receive0(FileDescriptor fileDescriptor, long j10, int i10, boolean z10) throws IOException;

    private native int send0(boolean z10, FileDescriptor fileDescriptor, long j10, int i10, InetAddress inetAddress, int i11) throws IOException;

    static {
        initIDs();
    }

    @Override // java.nio.channels.DatagramChannel, java.nio.channels.NetworkChannel
    public /* bridge */ /* synthetic */ NetworkChannel setOption(SocketOption socketOption, Object obj) throws IOException {
        return setOption((SocketOption<SocketOption>) socketOption, (SocketOption) obj);
    }

    public DatagramChannelImpl(SelectorProvider sp) throws IOException {
        super(sp);
        this.readerThread = 0L;
        this.writerThread = 0L;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        ResourceManager.beforeUdpCreate();
        try {
            StandardProtocolFamily standardProtocolFamily = Net.isIPv6Available() ? StandardProtocolFamily.INET6 : StandardProtocolFamily.INET;
            this.family = standardProtocolFamily;
            FileDescriptor socket = Net.socket(standardProtocolFamily, false);
            this.f53718fd = socket;
            this.fdVal = IOUtil.fdVal(socket);
            this.state = 0;
            if (socket != null && socket.valid()) {
                closeGuard.open("close");
            }
        } catch (IOException ioe) {
            ResourceManager.afterUdpClose();
            throw ioe;
        }
    }

    public DatagramChannelImpl(SelectorProvider sp, ProtocolFamily family) throws IOException {
        super(sp);
        this.readerThread = 0L;
        this.writerThread = 0L;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        if (family != StandardProtocolFamily.INET && family != StandardProtocolFamily.INET6) {
            if (family == null) {
                throw new NullPointerException("'family' is null");
            }
            throw new UnsupportedOperationException("Protocol family not supported");
        }
        if (family == StandardProtocolFamily.INET6 && !Net.isIPv6Available()) {
            throw new UnsupportedOperationException("IPv6 not available");
        }
        this.family = family;
        FileDescriptor socket = Net.socket(family, false);
        this.f53718fd = socket;
        this.fdVal = IOUtil.fdVal(socket);
        this.state = 0;
        if (socket != null && socket.valid()) {
            closeGuard.open("close");
        }
    }

    public DatagramChannelImpl(SelectorProvider sp, FileDescriptor fd2) throws IOException {
        super(sp);
        this.readerThread = 0L;
        this.writerThread = 0L;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.family = Net.isIPv6Available() ? StandardProtocolFamily.INET6 : StandardProtocolFamily.INET;
        this.f53718fd = fd2;
        this.fdVal = IOUtil.fdVal(fd2);
        this.state = 0;
        this.localAddress = Net.localAddress(fd2);
        if (fd2 != null && fd2.valid()) {
            closeGuard.open("close");
        }
    }

    @Override // java.nio.channels.DatagramChannel
    public DatagramSocket socket() {
        DatagramSocket datagramSocket;
        synchronized (this.stateLock) {
            if (this.socket == null) {
                this.socket = DatagramSocketAdaptor.create(this);
            }
            datagramSocket = this.socket;
        }
        return datagramSocket;
    }

    @Override // java.nio.channels.DatagramChannel, java.nio.channels.NetworkChannel
    public SocketAddress getLocalAddress() throws IOException {
        InetSocketAddress revealedLocalAddress;
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            revealedLocalAddress = Net.getRevealedLocalAddress(this.localAddress);
        }
        return revealedLocalAddress;
    }

    @Override // java.nio.channels.DatagramChannel
    public SocketAddress getRemoteAddress() throws IOException {
        InetSocketAddress inetSocketAddress;
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            inetSocketAddress = this.remoteAddress;
        }
        return inetSocketAddress;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.nio.channels.DatagramChannel, java.nio.channels.NetworkChannel
    public <T> DatagramChannel setOption(SocketOption<T> name, T t2) throws IOException {
        if (name == null) {
            throw new NullPointerException();
        }
        if (!supportedOptions().contains(name)) {
            throw new UnsupportedOperationException("'" + ((Object) name) + "' not supported");
        }
        synchronized (this.stateLock) {
            ensureOpen();
            if (name != StandardSocketOptions.IP_TOS && name != StandardSocketOptions.IP_MULTICAST_TTL && name != StandardSocketOptions.IP_MULTICAST_LOOP) {
                if (name == StandardSocketOptions.IP_MULTICAST_IF) {
                    if (t2 == 0) {
                        throw new IllegalArgumentException("Cannot set IP_MULTICAST_IF to 'null'");
                    }
                    NetworkInterface interf = (NetworkInterface) t2;
                    if (this.family == StandardProtocolFamily.INET6) {
                        int index = interf.getIndex();
                        if (index == -1) {
                            throw new IOException("Network interface cannot be identified");
                        }
                        Net.setInterface6(this.f53718fd, index);
                        Inet4Address target = Net.anyInet4Address(interf);
                        if (target != null) {
                            int targetAddress = Net.inet4AsInt(target);
                            Net.setInterface4(this.f53718fd, targetAddress);
                        }
                    } else {
                        Inet4Address target2 = Net.anyInet4Address(interf);
                        if (target2 == null) {
                            throw new IOException("Network interface not configured for IPv4");
                        }
                        int targetAddress2 = Net.inet4AsInt(target2);
                        Net.setInterface4(this.f53718fd, targetAddress2);
                    }
                    return this;
                }
                if (name == StandardSocketOptions.SO_REUSEADDR && Net.useExclusiveBind() && this.localAddress != null) {
                    this.reuseAddressEmulated = true;
                    this.isReuseAddress = ((Boolean) t2).booleanValue();
                }
                Net.setSocketOption(this.f53718fd, Net.UNSPEC, name, t2);
                return this;
            }
            Net.setSocketOption(this.f53718fd, this.family, name, t2);
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
            ensureOpen();
            if (socketOption != StandardSocketOptions.IP_TOS && socketOption != StandardSocketOptions.IP_MULTICAST_TTL && socketOption != StandardSocketOptions.IP_MULTICAST_LOOP) {
                if (socketOption == StandardSocketOptions.IP_MULTICAST_IF) {
                    if (this.family == StandardProtocolFamily.INET) {
                        int interface4 = Net.getInterface4(this.f53718fd);
                        if (interface4 == 0) {
                            return null;
                        }
                        T t2 = (T) NetworkInterface.getByInetAddress(Net.inet4FromInt(interface4));
                        if (t2 != null) {
                            return t2;
                        }
                        throw new IOException("Unable to map address to interface");
                    }
                    int interface6 = Net.getInterface6(this.f53718fd);
                    if (interface6 == 0) {
                        return null;
                    }
                    T t10 = (T) NetworkInterface.getByIndex(interface6);
                    if (t10 != null) {
                        return t10;
                    }
                    throw new IOException("Unable to map index to interface");
                }
                if (socketOption == StandardSocketOptions.SO_REUSEADDR && this.reuseAddressEmulated) {
                    return (T) Boolean.valueOf(this.isReuseAddress);
                }
                return (T) Net.getSocketOption(this.f53718fd, Net.UNSPEC, socketOption);
            }
            return (T) Net.getSocketOption(this.f53718fd, this.family, socketOption);
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
            HashSet<SocketOption<?>> set = new HashSet<>(8);
            set.add(StandardSocketOptions.SO_SNDBUF);
            set.add(StandardSocketOptions.SO_RCVBUF);
            set.add(StandardSocketOptions.SO_REUSEADDR);
            set.add(StandardSocketOptions.SO_BROADCAST);
            set.add(StandardSocketOptions.IP_TOS);
            set.add(StandardSocketOptions.IP_MULTICAST_IF);
            set.add(StandardSocketOptions.IP_MULTICAST_TTL);
            set.add(StandardSocketOptions.IP_MULTICAST_LOOP);
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

    private void ensureOpen() throws ClosedChannelException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2 A[Catch: all -> 0x00e4, TRY_ENTER, TryCatch #2 {, blocks: (B:7:0x000b, B:9:0x0015, B:17:0x002a, B:18:0x002d, B:21:0x0034, B:22:0x0037, B:59:0x006a, B:60:0x006d, B:63:0x0074, B:64:0x0077, B:44:0x00c2, B:45:0x00c5, B:48:0x00cc, B:49:0x00cf, B:77:0x00af, B:78:0x00b2, B:81:0x00b9, B:82:0x00bc, B:89:0x00d4, B:90:0x00d7, B:93:0x00de, B:94:0x00e3, B:14:0x001e, B:25:0x0039, B:29:0x004d, B:30:0x0056, B:32:0x005f, B:36:0x0079, B:38:0x007e, B:41:0x008e, B:42:0x00be, B:54:0x0096, B:70:0x009b, B:72:0x00a4), top: B:6:0x000b, inners: #0 }] */
    @Override // java.nio.channels.DatagramChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.net.SocketAddress receive(java.nio.ByteBuffer r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.DatagramChannelImpl.receive(java.nio.ByteBuffer):java.net.SocketAddress");
    }

    private int receive(FileDescriptor fd2, ByteBuffer dst) throws IOException {
        int pos = dst.position();
        int lim = dst.limit();
        int rem = pos <= lim ? lim - pos : 0;
        if ((dst instanceof DirectBuffer) && rem > 0) {
            return receiveIntoNativeBuffer(fd2, dst, rem, pos);
        }
        int newSize = Math.max(rem, 1);
        ByteBuffer bb2 = Util.getTemporaryDirectBuffer(newSize);
        try {
            BlockGuard.getThreadPolicy().onNetwork();
            int n10 = receiveIntoNativeBuffer(fd2, bb2, newSize, 0);
            bb2.flip();
            if (n10 > 0 && rem > 0) {
                dst.put(bb2);
            }
            return n10;
        } finally {
            Util.releaseTemporaryDirectBuffer(bb2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int receiveIntoNativeBuffer(FileDescriptor fd2, ByteBuffer byteBuffer, int rem, int pos) throws IOException {
        int n10 = receive0(fd2, ((DirectBuffer) byteBuffer).address() + pos, rem, isConnected());
        if (n10 > 0) {
            byteBuffer.position(pos + n10);
        }
        return n10;
    }

    @Override // java.nio.channels.DatagramChannel
    public int send(ByteBuffer src, SocketAddress target) throws IOException {
        if (src == null) {
            throw new NullPointerException();
        }
        synchronized (this.writeLock) {
            ensureOpen();
            InetSocketAddress isa = Net.checkAddress(target);
            InetAddress ia2 = isa.getAddress();
            if (ia2 == null) {
                throw new IOException("Target address not resolved");
            }
            synchronized (this.stateLock) {
                if (!isConnected()) {
                    if (target == null) {
                        throw new NullPointerException();
                    }
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        if (ia2.isMulticastAddress()) {
                            sm.checkMulticast(ia2);
                        } else {
                            sm.checkConnect(ia2.getHostAddress(), isa.getPort());
                        }
                    }
                    int n10 = 0;
                    boolean z10 = true;
                    try {
                        begin();
                        if (!isOpen()) {
                            return 0;
                        }
                        this.writerThread = NativeThread.current();
                        BlockGuard.getThreadPolicy().onNetwork();
                        do {
                            n10 = send(this.f53718fd, src, isa);
                            if (n10 != -3) {
                                break;
                            }
                        } while (isOpen());
                        synchronized (this.stateLock) {
                            if (isOpen() && this.localAddress == null) {
                                this.localAddress = Net.localAddress(this.f53718fd);
                            }
                        }
                        int normalize = IOStatus.normalize(n10);
                        this.writerThread = 0L;
                        if (n10 <= 0 && n10 != -2) {
                            z10 = false;
                        }
                        end(z10);
                        return normalize;
                    } finally {
                        this.writerThread = 0L;
                        if (n10 <= 0 && n10 != -2) {
                            z10 = false;
                        }
                        end(z10);
                    }
                }
                if (!target.equals(this.remoteAddress)) {
                    throw new IllegalArgumentException("Connected address not equal to target address");
                }
                return write(src);
            }
        }
    }

    private int send(FileDescriptor fd2, ByteBuffer src, InetSocketAddress target) throws IOException {
        if (src instanceof DirectBuffer) {
            return sendFromNativeBuffer(fd2, src, target);
        }
        int pos = src.position();
        int lim = src.limit();
        int rem = pos <= lim ? lim - pos : 0;
        ByteBuffer bb2 = Util.getTemporaryDirectBuffer(rem);
        try {
            bb2.put(src);
            bb2.flip();
            src.position(pos);
            int n10 = sendFromNativeBuffer(fd2, bb2, target);
            if (n10 > 0) {
                src.position(pos + n10);
            }
            return n10;
        } finally {
            Util.releaseTemporaryDirectBuffer(bb2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int sendFromNativeBuffer(FileDescriptor fd2, ByteBuffer byteBuffer, InetSocketAddress target) throws IOException {
        int written;
        int pos = byteBuffer.position();
        int lim = byteBuffer.limit();
        int rem = pos <= lim ? lim - pos : 0;
        boolean preferIPv6 = this.family != StandardProtocolFamily.INET;
        try {
            written = send0(preferIPv6, fd2, ((DirectBuffer) byteBuffer).address() + pos, rem, target.getAddress(), target.getPort());
        } catch (PortUnreachableException pue) {
            if (isConnected()) {
                throw pue;
            }
            written = rem;
        }
        if (written > 0) {
            byteBuffer.position(pos + written);
        }
        return written;
    }

    @Override // java.nio.channels.DatagramChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer buf) throws IOException {
        if (buf == null) {
            throw new NullPointerException();
        }
        synchronized (this.readLock) {
            synchronized (this.stateLock) {
                ensureOpen();
                if (!isConnected()) {
                    throw new NotYetConnectedException();
                }
            }
            int n10 = 0;
            boolean z10 = true;
            try {
                begin();
                if (!isOpen()) {
                    return 0;
                }
                this.readerThread = NativeThread.current();
                do {
                    n10 = IOUtil.read(this.f53718fd, buf, -1L, f53717nd);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
                int normalize = IOStatus.normalize(n10);
                this.readerThread = 0L;
                if (n10 <= 0 && n10 != -2) {
                    z10 = false;
                }
                end(z10);
                return normalize;
            } finally {
                this.readerThread = 0L;
                if (n10 <= 0 && n10 != -2) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    @Override // java.nio.channels.DatagramChannel, java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
        if (offset < 0 || length < 0 || offset > dsts.length - length) {
            throw new IndexOutOfBoundsException();
        }
        synchronized (this.readLock) {
            synchronized (this.stateLock) {
                ensureOpen();
                if (!isConnected()) {
                    throw new NotYetConnectedException();
                }
            }
            long n10 = 0;
            try {
                begin();
                if (!isOpen()) {
                    return 0L;
                }
                this.readerThread = NativeThread.current();
                do {
                    n10 = IOUtil.read(this.f53718fd, dsts, offset, length, f53717nd);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
                long normalize = IOStatus.normalize(n10);
                this.readerThread = 0L;
                end(n10 > 0 || n10 == -2);
                return normalize;
            } finally {
                this.readerThread = 0L;
                end(n10 > 0 || n10 == -2);
            }
        }
    }

    @Override // java.nio.channels.DatagramChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer buf) throws IOException {
        if (buf == null) {
            throw new NullPointerException();
        }
        synchronized (this.writeLock) {
            synchronized (this.stateLock) {
                ensureOpen();
                if (!isConnected()) {
                    throw new NotYetConnectedException();
                }
            }
            int n10 = 0;
            boolean z10 = true;
            try {
                begin();
                if (!isOpen()) {
                    return 0;
                }
                this.writerThread = NativeThread.current();
                do {
                    n10 = IOUtil.write(this.f53718fd, buf, -1L, f53717nd);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
                int normalize = IOStatus.normalize(n10);
                this.writerThread = 0L;
                if (n10 <= 0 && n10 != -2) {
                    z10 = false;
                }
                end(z10);
                return normalize;
            } finally {
                this.writerThread = 0L;
                if (n10 <= 0 && n10 != -2) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    @Override // java.nio.channels.DatagramChannel, java.nio.channels.GatheringByteChannel
    public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
        if (offset < 0 || length < 0 || offset > srcs.length - length) {
            throw new IndexOutOfBoundsException();
        }
        synchronized (this.writeLock) {
            synchronized (this.stateLock) {
                ensureOpen();
                if (!isConnected()) {
                    throw new NotYetConnectedException();
                }
            }
            long n10 = 0;
            try {
                begin();
                if (!isOpen()) {
                    return 0L;
                }
                this.writerThread = NativeThread.current();
                do {
                    n10 = IOUtil.write(this.f53718fd, srcs, offset, length, f53717nd);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
                long normalize = IOStatus.normalize(n10);
                this.writerThread = 0L;
                end(n10 > 0 || n10 == -2);
                return normalize;
            } finally {
                this.writerThread = 0L;
                end(n10 > 0 || n10 == -2);
            }
        }
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implConfigureBlocking(boolean block) throws IOException {
        IOUtil.configureBlocking(this.f53718fd, block);
    }

    public SocketAddress localAddress() {
        InetSocketAddress inetSocketAddress;
        synchronized (this.stateLock) {
            inetSocketAddress = this.localAddress;
        }
        return inetSocketAddress;
    }

    public SocketAddress remoteAddress() {
        InetSocketAddress inetSocketAddress;
        synchronized (this.stateLock) {
            inetSocketAddress = this.remoteAddress;
        }
        return inetSocketAddress;
    }

    @Override // java.nio.channels.DatagramChannel, java.nio.channels.NetworkChannel
    public DatagramChannel bind(SocketAddress local) throws IOException {
        InetSocketAddress isa;
        synchronized (this.readLock) {
            synchronized (this.writeLock) {
                synchronized (this.stateLock) {
                    ensureOpen();
                    if (this.localAddress != null) {
                        throw new AlreadyBoundException();
                    }
                    if (local == null) {
                        isa = this.family == StandardProtocolFamily.INET ? new InetSocketAddress(InetAddress.getByName("0.0.0.0"), 0) : new InetSocketAddress(0);
                    } else {
                        isa = Net.checkAddress(local);
                        if (this.family == StandardProtocolFamily.INET) {
                            InetAddress addr = isa.getAddress();
                            if (!(addr instanceof Inet4Address)) {
                                throw new UnsupportedAddressTypeException();
                            }
                        }
                    }
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        sm.checkListen(isa.getPort());
                    }
                    Net.bind(this.family, this.f53718fd, isa.getAddress(), isa.getPort());
                    this.localAddress = Net.localAddress(this.f53718fd);
                }
            }
        }
        return this;
    }

    @Override // java.nio.channels.DatagramChannel
    public boolean isConnected() {
        boolean z10;
        synchronized (this.stateLock) {
            z10 = true;
            if (this.state != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    void ensureOpenAndUnconnected() throws IOException {
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (this.state != 0) {
                throw new IllegalStateException("Connect already invoked");
            }
        }
    }

    @Override // java.nio.channels.DatagramChannel
    public DatagramChannel connect(SocketAddress sa2) throws IOException {
        synchronized (this.readLock) {
            synchronized (this.writeLock) {
                synchronized (this.stateLock) {
                    ensureOpenAndUnconnected();
                    InetSocketAddress isa = Net.checkAddress(sa2);
                    SecurityManager sm = System.getSecurityManager();
                    if (sm != null) {
                        sm.checkConnect(isa.getAddress().getHostAddress(), isa.getPort());
                    }
                    int n10 = Net.connect(this.family, this.f53718fd, isa.getAddress(), isa.getPort());
                    if (n10 <= 0) {
                        throw new Error();
                    }
                    this.state = 1;
                    this.remoteAddress = isa;
                    this.sender = isa;
                    this.cachedSenderInetAddress = isa.getAddress();
                    this.cachedSenderPort = isa.getPort();
                    this.localAddress = Net.localAddress(this.f53718fd);
                    boolean blocking = false;
                    synchronized (blockingLock()) {
                        try {
                            blocking = isBlocking();
                            ByteBuffer tmpBuf = ByteBuffer.allocate(1);
                            if (blocking) {
                                configureBlocking(false);
                            }
                            do {
                                tmpBuf.clear();
                            } while (receive(tmpBuf) != null);
                        } finally {
                            if (blocking) {
                                configureBlocking(true);
                            }
                        }
                    }
                }
            }
        }
        return this;
    }

    @Override // java.nio.channels.DatagramChannel
    public DatagramChannel disconnect() throws IOException {
        synchronized (this.readLock) {
            synchronized (this.writeLock) {
                synchronized (this.stateLock) {
                    if (isConnected() && isOpen()) {
                        InetSocketAddress isa = this.remoteAddress;
                        SecurityManager sm = System.getSecurityManager();
                        if (sm != null) {
                            sm.checkConnect(isa.getAddress().getHostAddress(), isa.getPort());
                        }
                        boolean isIPv6 = this.family == StandardProtocolFamily.INET6;
                        disconnect0(this.f53718fd, isIPv6);
                        this.remoteAddress = null;
                        this.state = 0;
                        this.localAddress = Net.localAddress(this.f53718fd);
                        return this;
                    }
                    return this;
                }
            }
        }
    }

    private MembershipKey innerJoin(InetAddress group, NetworkInterface interf, InetAddress source) throws IOException {
        MembershipKeyImpl key;
        if (!group.isMulticastAddress()) {
            throw new IllegalArgumentException("Group not a multicast address");
        }
        if (group instanceof Inet4Address) {
            if (this.family == StandardProtocolFamily.INET6 && !Net.canIPv6SocketJoinIPv4Group()) {
                throw new IllegalArgumentException("IPv6 socket cannot join IPv4 multicast group");
            }
        } else {
            if (!(group instanceof Inet6Address)) {
                throw new IllegalArgumentException("Address type not supported");
            }
            if (this.family != StandardProtocolFamily.INET6) {
                throw new IllegalArgumentException("Only IPv6 sockets can join IPv6 multicast group");
            }
        }
        if (source != null) {
            if (source.isAnyLocalAddress()) {
                throw new IllegalArgumentException("Source address is a wildcard address");
            }
            if (source.isMulticastAddress()) {
                throw new IllegalArgumentException("Source address is multicast address");
            }
            if (source.getClass() != group.getClass()) {
                throw new IllegalArgumentException("Source address is different type to group");
            }
        }
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkMulticast(group);
        }
        synchronized (this.stateLock) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (!isOpen()) {
                    throw new ClosedChannelException();
                }
                MembershipRegistry membershipRegistry = this.registry;
                if (membershipRegistry == null) {
                    this.registry = new MembershipRegistry();
                } else {
                    MembershipKey key2 = membershipRegistry.checkMembership(group, interf, source);
                    if (key2 != null) {
                        return key2;
                    }
                }
                if (this.family == StandardProtocolFamily.INET6 && ((group instanceof Inet6Address) || Net.canJoin6WithIPv4Group())) {
                    int index = interf.getIndex();
                    if (index == -1) {
                        throw new IOException("Network interface cannot be identified");
                    }
                    byte[] groupAddress = Net.inet6AsByteArray(group);
                    byte[] sourceAddress = source == null ? null : Net.inet6AsByteArray(source);
                    int n10 = Net.join6(this.f53718fd, groupAddress, index, sourceAddress);
                    if (n10 == -2) {
                        throw new UnsupportedOperationException();
                    }
                    key = new MembershipKeyImpl.Type6(this, group, interf, source, groupAddress, index, sourceAddress);
                } else {
                    Inet4Address target = Net.anyInet4Address(interf);
                    if (target == null) {
                        throw new IOException("Network interface not configured for IPv4");
                    }
                    int groupAddress2 = Net.inet4AsInt(group);
                    int targetAddress = Net.inet4AsInt(target);
                    int sourceAddress2 = source == null ? 0 : Net.inet4AsInt(source);
                    int n11 = Net.join4(this.f53718fd, groupAddress2, targetAddress, sourceAddress2);
                    if (n11 == -2) {
                        throw new UnsupportedOperationException();
                    }
                    key = new MembershipKeyImpl.Type4(this, group, interf, source, groupAddress2, targetAddress, sourceAddress2);
                }
                this.registry.add(key);
                return key;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // java.nio.channels.MulticastChannel
    public MembershipKey join(InetAddress group, NetworkInterface interf) throws IOException {
        return innerJoin(group, interf, null);
    }

    @Override // java.nio.channels.MulticastChannel
    public MembershipKey join(InetAddress group, NetworkInterface interf, InetAddress source) throws IOException {
        if (source == null) {
            throw new NullPointerException("source address is null");
        }
        return innerJoin(group, interf, source);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drop(MembershipKeyImpl key) {
        synchronized (this.stateLock) {
            if (key.isValid()) {
                try {
                    if (key instanceof MembershipKeyImpl.Type6) {
                        MembershipKeyImpl.Type6 key6 = (MembershipKeyImpl.Type6) key;
                        Net.drop6(this.f53718fd, key6.groupAddress(), key6.index(), key6.source());
                    } else {
                        MembershipKeyImpl.Type4 key4 = (MembershipKeyImpl.Type4) key;
                        Net.drop4(this.f53718fd, key4.groupAddress(), key4.interfaceAddress(), key4.source());
                    }
                    key.invalidate();
                    this.registry.remove(key);
                } catch (IOException ioe) {
                    throw new AssertionError(ioe);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void block(MembershipKeyImpl key, InetAddress source) throws IOException {
        int n10;
        synchronized (this.stateLock) {
            if (!key.isValid()) {
                throw new IllegalStateException("key is no longer valid");
            }
            if (source.isAnyLocalAddress()) {
                throw new IllegalArgumentException("Source address is a wildcard address");
            }
            if (source.isMulticastAddress()) {
                throw new IllegalArgumentException("Source address is multicast address");
            }
            if (source.getClass() != key.group().getClass()) {
                throw new IllegalArgumentException("Source address is different type to group");
            }
            if (key instanceof MembershipKeyImpl.Type6) {
                MembershipKeyImpl.Type6 key6 = (MembershipKeyImpl.Type6) key;
                n10 = Net.block6(this.f53718fd, key6.groupAddress(), key6.index(), Net.inet6AsByteArray(source));
            } else {
                MembershipKeyImpl.Type4 key4 = (MembershipKeyImpl.Type4) key;
                n10 = Net.block4(this.f53718fd, key4.groupAddress(), key4.interfaceAddress(), Net.inet4AsInt(source));
            }
            if (n10 == -2) {
                throw new UnsupportedOperationException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unblock(MembershipKeyImpl key, InetAddress source) {
        synchronized (this.stateLock) {
            if (!key.isValid()) {
                throw new IllegalStateException("key is no longer valid");
            }
            try {
                if (key instanceof MembershipKeyImpl.Type6) {
                    MembershipKeyImpl.Type6 key6 = (MembershipKeyImpl.Type6) key;
                    Net.unblock6(this.f53718fd, key6.groupAddress(), key6.index(), Net.inet6AsByteArray(source));
                } else {
                    MembershipKeyImpl.Type4 key4 = (MembershipKeyImpl.Type4) key;
                    Net.unblock4(this.f53718fd, key4.groupAddress(), key4.interfaceAddress(), Net.inet4AsInt(source));
                }
            } catch (IOException ioe) {
                throw new AssertionError(ioe);
            }
        }
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implCloseSelectableChannel() throws IOException {
        synchronized (this.stateLock) {
            this.guard.close();
            if (this.state != 2) {
                f53717nd.preClose(this.f53718fd);
            }
            ResourceManager.afterUdpClose();
            MembershipRegistry membershipRegistry = this.registry;
            if (membershipRegistry != null) {
                membershipRegistry.invalidateAll();
            }
            long th = this.readerThread;
            if (th != 0) {
                NativeThread.signal(th);
            }
            long th2 = this.writerThread;
            if (th2 != 0) {
                NativeThread.signal(th2);
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
            if (i10 == 2) {
                return;
            }
            if (i10 == -1) {
                this.state = 2;
            } else {
                f53717nd.close(this.f53718fd);
                this.state = 2;
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            CloseGuard closeGuard = this.guard;
            if (closeGuard != null) {
                closeGuard.warnIfOpen();
            }
            if (this.f53718fd != null) {
                close();
            }
        } finally {
            super.finalize();
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
        if ((Net.POLLIN & ops) != 0 && (intOps & 1) != 0) {
            newOps |= 1;
        }
        if ((Net.POLLOUT & ops) != 0 && (intOps & 4) != 0) {
            newOps |= 4;
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
        synchronized (this.readLock) {
            boolean z10 = true;
            try {
                begin();
                synchronized (this.stateLock) {
                    if (!isOpen()) {
                        return 0;
                    }
                    this.readerThread = NativeThread.current();
                    int n10 = Net.poll(this.f53718fd, events, timeout);
                    this.readerThread = 0L;
                    if (n10 <= 0) {
                        z10 = false;
                    }
                    end(z10);
                    return n10;
                }
            } finally {
                this.readerThread = 0L;
                if (0 <= 0) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    @Override // sun.nio.ch.SelChImpl
    public void translateAndSetInterestOps(int ops, SelectionKeyImpl sk) {
        int newOps = (ops & 1) != 0 ? 0 | Net.POLLIN : 0;
        if ((ops & 4) != 0) {
            newOps |= Net.POLLOUT;
        }
        if ((ops & 8) != 0) {
            newOps |= Net.POLLIN;
        }
        sk.selector.putEventOps(sk, newOps);
    }

    @Override // sun.nio.ch.SelChImpl
    public FileDescriptor getFD() {
        return this.f53718fd;
    }

    @Override // sun.nio.ch.SelChImpl
    public int getFDVal() {
        return this.fdVal;
    }
}
