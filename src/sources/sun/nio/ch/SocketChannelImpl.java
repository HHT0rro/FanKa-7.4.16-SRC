package sun.nio.ch;

import com.huawei.openalliance.ad.constant.u;
import dalvik.annotation.optimization.ReachabilitySensitive;
import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProtocolFamily;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyBoundException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NetworkChannel;
import java.nio.channels.NoConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import jdk.net.ExtendedSocketOptions;
import sun.net.ExtendedOptionsImpl;
import sun.net.NetHooks;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SocketChannelImpl extends SocketChannel implements SelChImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ST_CONNECTED = 2;
    private static final int ST_KILLED = 4;
    private static final int ST_KILLPENDING = 3;
    private static final int ST_PENDING = 1;
    private static final int ST_UNCONNECTED = 0;
    private static final int ST_UNINITIALIZED = -1;

    /* renamed from: nd, reason: collision with root package name */
    private static NativeDispatcher f53730nd = new SocketDispatcher();

    /* renamed from: fd, reason: collision with root package name */
    private final FileDescriptor f53731fd;
    private final int fdVal;

    @ReachabilitySensitive
    private final CloseGuard guard;
    private boolean isInputOpen;
    private boolean isOutputOpen;
    private boolean isReuseAddress;
    private InetSocketAddress localAddress;
    private final Object readLock;
    private volatile long readerThread;
    private boolean readyToConnect;
    private InetSocketAddress remoteAddress;
    private Socket socket;
    private int state;
    private final Object stateLock;
    private final Object writeLock;
    private volatile long writerThread;

    private static native int checkConnect(FileDescriptor fileDescriptor, boolean z10, boolean z11) throws IOException;

    private static native int sendOutOfBandData(FileDescriptor fileDescriptor, byte b4) throws IOException;

    @Override // java.nio.channels.SocketChannel, java.nio.channels.NetworkChannel
    public /* bridge */ /* synthetic */ NetworkChannel setOption(SocketOption socketOption, Object obj) throws IOException {
        return setOption((SocketOption<SocketOption>) socketOption, (SocketOption) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SocketChannelImpl(SelectorProvider sp) throws IOException {
        super(sp);
        this.readerThread = 0L;
        this.writerThread = 0L;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        this.isInputOpen = true;
        this.isOutputOpen = true;
        this.readyToConnect = false;
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        FileDescriptor socket = Net.socket(true);
        this.f53731fd = socket;
        this.fdVal = IOUtil.fdVal(socket);
        this.state = 0;
        if (socket != null && socket.valid()) {
            closeGuard.open("close");
        }
    }

    SocketChannelImpl(SelectorProvider sp, FileDescriptor fd2, boolean bound) throws IOException {
        super(sp);
        this.readerThread = 0L;
        this.writerThread = 0L;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        this.isInputOpen = true;
        this.isOutputOpen = true;
        this.readyToConnect = false;
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.f53731fd = fd2;
        this.fdVal = IOUtil.fdVal(fd2);
        this.state = 0;
        if (fd2 != null && fd2.valid()) {
            closeGuard.open("close");
        }
        if (bound) {
            this.localAddress = Net.localAddress(fd2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SocketChannelImpl(SelectorProvider sp, FileDescriptor fd2, InetSocketAddress remote) throws IOException {
        super(sp);
        this.readerThread = 0L;
        this.writerThread = 0L;
        this.readLock = new Object();
        this.writeLock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        this.isInputOpen = true;
        this.isOutputOpen = true;
        this.readyToConnect = false;
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.f53731fd = fd2;
        this.fdVal = IOUtil.fdVal(fd2);
        this.state = 2;
        this.localAddress = Net.localAddress(fd2);
        this.remoteAddress = remote;
        if (fd2 != null && fd2.valid()) {
            closeGuard.open("close");
        }
    }

    @Override // java.nio.channels.SocketChannel
    public Socket socket() {
        Socket socket;
        synchronized (this.stateLock) {
            if (this.socket == null) {
                this.socket = SocketAdaptor.create(this);
            }
            socket = this.socket;
        }
        return socket;
    }

    @Override // java.nio.channels.SocketChannel, java.nio.channels.NetworkChannel
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

    @Override // java.nio.channels.SocketChannel
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
    @Override // java.nio.channels.SocketChannel, java.nio.channels.NetworkChannel
    public <T> SocketChannel setOption(SocketOption<T> name, T t2) throws IOException {
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
                Net.setSocketOption(this.f53731fd, family, name, t2);
                return this;
            }
            if (name == StandardSocketOptions.SO_REUSEADDR && Net.useExclusiveBind()) {
                this.isReuseAddress = ((Boolean) t2).booleanValue();
                return this;
            }
            Net.setSocketOption(this.f53731fd, Net.UNSPEC, name, t2);
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
            if (socketOption == StandardSocketOptions.IP_TOS) {
                return (T) Net.getSocketOption(this.f53731fd, Net.isIPv6Available() ? StandardProtocolFamily.INET6 : StandardProtocolFamily.INET, socketOption);
            }
            return (T) Net.getSocketOption(this.f53731fd, Net.UNSPEC, socketOption);
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
            set.add(StandardSocketOptions.SO_KEEPALIVE);
            set.add(StandardSocketOptions.SO_REUSEADDR);
            set.add(StandardSocketOptions.SO_LINGER);
            set.add(StandardSocketOptions.TCP_NODELAY);
            set.add(StandardSocketOptions.IP_TOS);
            set.add(ExtendedSocketOption.SO_OOBINLINE);
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

    private boolean ensureReadOpen() throws ClosedChannelException {
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (isConnected()) {
                return this.isInputOpen;
            }
            throw new NotYetConnectedException();
        }
    }

    private void ensureWriteOpen() throws ClosedChannelException {
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (!this.isOutputOpen) {
                throw new ClosedChannelException();
            }
            if (!isConnected()) {
                throw new NotYetConnectedException();
            }
        }
    }

    private void readerCleanup() throws IOException {
        synchronized (this.stateLock) {
            this.readerThread = 0L;
            if (this.state == 3) {
                kill();
            }
        }
    }

    private void writerCleanup() throws IOException {
        synchronized (this.stateLock) {
            this.writerThread = 0L;
            if (this.state == 3) {
                kill();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // java.nio.channels.SocketChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new NullPointerException();
        }
        synchronized (this.readLock) {
            int i10 = -1;
            i10 = -1;
            i10 = -1;
            if (!ensureReadOpen()) {
                return -1;
            }
            int i11 = 0;
            int i12 = -2;
            i12 = -2;
            i12 = -2;
            boolean z10 = true;
            try {
                begin();
                synchronized (this.stateLock) {
                    if (!isOpen()) {
                        readerCleanup();
                        if (0 <= 0 && 0 != -2) {
                            z10 = false;
                        }
                        end(z10);
                        Object obj = this.stateLock;
                        synchronized (obj) {
                            if (0 <= 0) {
                                try {
                                    if (!this.isInputOpen) {
                                        return -1;
                                    }
                                } catch (Throwable th) {
                                    i10 = th;
                                    i12 = obj;
                                }
                            }
                            return 0;
                        }
                    }
                    this.readerThread = NativeThread.current();
                    do {
                        i11 = IOUtil.read(this.f53731fd, byteBuffer, -1L, f53730nd);
                        if (i11 != -3) {
                            break;
                        }
                    } while (isOpen());
                    int normalize = IOStatus.normalize(i11);
                    readerCleanup();
                    if (i11 <= 0 && i11 != -2) {
                        z10 = false;
                    }
                    end(z10);
                    Object obj2 = this.stateLock;
                    synchronized (obj2) {
                        if (i11 <= 0) {
                            try {
                                if (!this.isInputOpen) {
                                    return -1;
                                }
                            } catch (Throwable th2) {
                                i10 = th2;
                                i12 = obj2;
                            }
                        }
                        return normalize;
                    }
                    throw i10;
                }
            } catch (Throwable th3) {
                readerCleanup();
                if (i11 <= 0 && i11 != i12) {
                    z10 = false;
                }
                end(z10);
                synchronized (this.stateLock) {
                    if (i11 <= 0) {
                        if (!this.isInputOpen) {
                            return i10;
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b9  */
    @Override // java.nio.channels.SocketChannel, java.nio.channels.ScatteringByteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long read(java.nio.ByteBuffer[] r17, int r18, int r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.read(java.nio.ByteBuffer[], int, int):long");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    @Override // java.nio.channels.SocketChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new NullPointerException();
        }
        synchronized (this.writeLock) {
            ensureWriteOpen();
            int i10 = 0;
            int i11 = -2;
            i11 = -2;
            ?? r32 = 1;
            r3 = true;
            boolean z10 = true;
            r3 = true;
            boolean z11 = true;
            r32 = 1;
            try {
                begin();
                synchronized (this.stateLock) {
                    if (!isOpen()) {
                        writerCleanup();
                        if (0 <= 0 && 0 != -2) {
                            z10 = false;
                        }
                        end(z10);
                        Object obj = this.stateLock;
                        synchronized (obj) {
                            if (0 <= 0) {
                                try {
                                    if (!this.isOutputOpen) {
                                        throw new AsynchronousCloseException();
                                    }
                                } catch (Throwable th) {
                                    i11 = obj;
                                    r32 = th;
                                }
                            }
                        }
                        return 0;
                    }
                    this.writerThread = NativeThread.current();
                    do {
                        i10 = IOUtil.write(this.f53731fd, byteBuffer, -1L, f53730nd);
                        if (i10 != -3) {
                            break;
                        }
                    } while (isOpen());
                    int normalize = IOStatus.normalize(i10);
                    writerCleanup();
                    if (i10 <= 0 && i10 != -2) {
                        z11 = false;
                    }
                    end(z11);
                    Object obj2 = this.stateLock;
                    synchronized (obj2) {
                        if (i10 <= 0) {
                            try {
                                if (!this.isOutputOpen) {
                                    throw new AsynchronousCloseException();
                                }
                            } catch (Throwable th2) {
                                i11 = obj2;
                                r32 = th2;
                            }
                        }
                    }
                    return normalize;
                    throw r32;
                }
            } catch (Throwable th3) {
                writerCleanup();
                boolean z12 = r32;
                if (i10 <= 0) {
                    z12 = i10 == i11 ? r32 : false;
                }
                end(z12);
                synchronized (this.stateLock) {
                    if (i10 <= 0) {
                        if (!this.isOutputOpen) {
                            throw new AsynchronousCloseException();
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x009f, code lost:
    
        if (r1 == r4) goto L71;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    @Override // java.nio.channels.SocketChannel, java.nio.channels.GatheringByteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long write(java.nio.ByteBuffer[] r13, int r14, int r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 199
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.write(java.nio.ByteBuffer[], int, int):long");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public int sendOutOfBandData(byte b4) throws IOException {
        synchronized (this.writeLock) {
            ensureWriteOpen();
            int i10 = 0;
            int i11 = -2;
            i11 = -2;
            i11 = -2;
            ?? r32 = 1;
            r3 = true;
            boolean z10 = true;
            r3 = true;
            boolean z11 = true;
            r32 = 1;
            r32 = 1;
            try {
                begin();
                synchronized (this.stateLock) {
                    if (!isOpen()) {
                        writerCleanup();
                        if (0 <= 0 && 0 != -2) {
                            z10 = false;
                        }
                        end(z10);
                        Object obj = this.stateLock;
                        synchronized (obj) {
                            if (0 <= 0) {
                                try {
                                    if (!this.isOutputOpen) {
                                        throw new AsynchronousCloseException();
                                    }
                                } catch (Throwable th) {
                                    i11 = obj;
                                    r32 = th;
                                }
                            }
                        }
                        return 0;
                    }
                    this.writerThread = NativeThread.current();
                    do {
                        i10 = sendOutOfBandData(this.f53731fd, b4);
                        if (i10 != -3) {
                            break;
                        }
                    } while (isOpen());
                    int normalize = IOStatus.normalize(i10);
                    writerCleanup();
                    if (i10 <= 0 && i10 != -2) {
                        z11 = false;
                    }
                    end(z11);
                    Object obj2 = this.stateLock;
                    synchronized (obj2) {
                        if (i10 <= 0) {
                            try {
                                if (!this.isOutputOpen) {
                                    throw new AsynchronousCloseException();
                                }
                            } catch (Throwable th2) {
                                i11 = obj2;
                                r32 = th2;
                            }
                        }
                    }
                    return normalize;
                    throw r32;
                }
            } catch (Throwable th3) {
                writerCleanup();
                boolean z12 = r32;
                if (i10 <= 0) {
                    z12 = i10 == i11 ? r32 : false;
                }
                end(z12);
                synchronized (this.stateLock) {
                    if (i10 <= 0) {
                        if (!this.isOutputOpen) {
                            throw new AsynchronousCloseException();
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implConfigureBlocking(boolean block) throws IOException {
        IOUtil.configureBlocking(this.f53731fd, block);
    }

    public InetSocketAddress localAddress() {
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

    @Override // java.nio.channels.SocketChannel, java.nio.channels.NetworkChannel
    public SocketChannel bind(SocketAddress local) throws IOException {
        synchronized (this.readLock) {
            synchronized (this.writeLock) {
                synchronized (this.stateLock) {
                    if (!isOpen()) {
                        throw new ClosedChannelException();
                    }
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
                    NetHooks.beforeTcpBind(this.f53731fd, isa.getAddress(), isa.getPort());
                    Net.bind(this.f53731fd, isa.getAddress(), isa.getPort());
                    this.localAddress = Net.localAddress(this.f53731fd);
                }
            }
        }
        return this;
    }

    @Override // java.nio.channels.SocketChannel
    public boolean isConnected() {
        boolean z10;
        synchronized (this.stateLock) {
            z10 = this.state == 2;
        }
        return z10;
    }

    @Override // java.nio.channels.SocketChannel
    public boolean isConnectionPending() {
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
            int i10 = this.state;
            if (i10 == 2) {
                throw new AlreadyConnectedException();
            }
            if (i10 == 1) {
                throw new ConnectionPendingException();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.nio.channels.SocketChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean connect(java.net.SocketAddress r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SocketChannelImpl.connect(java.net.SocketAddress):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [int] */
    @Override // java.nio.channels.SocketChannel
    public boolean finishConnect() throws IOException {
        synchronized (this.readLock) {
            synchronized (this.writeLock) {
                synchronized (this.stateLock) {
                    if (!isOpen()) {
                        throw new ClosedChannelException();
                    }
                    int i10 = this.state;
                    boolean z10 = true;
                    if (i10 == 2) {
                        return true;
                    }
                    if (i10 != 1) {
                        throw new NoConnectionPendingException();
                    }
                    int i11 = 0;
                    ?? r32 = -2;
                    r32 = -2;
                    r32 = -2;
                    r32 = -2;
                    long j10 = 0;
                    ?? r72 = 0;
                    ?? r73 = 0;
                    j10 = 0;
                    j10 = 0;
                    j10 = 0;
                    try {
                        try {
                            begin();
                            synchronized (blockingLock()) {
                                synchronized (this.stateLock) {
                                    if (!isOpen()) {
                                        synchronized (this.stateLock) {
                                            try {
                                                this.readerThread = 0L;
                                                r72 = this.state;
                                                if (r72 == 3) {
                                                    kill();
                                                    i11 = 0;
                                                }
                                            } catch (Throwable th) {
                                                r32 = th;
                                                j10 = r72;
                                            }
                                        }
                                        if (i11 <= 0 && i11 != -2) {
                                            z10 = false;
                                        }
                                        end(z10);
                                        return false;
                                    }
                                    this.readerThread = NativeThread.current();
                                    BlockGuard.getThreadPolicy().onNetwork();
                                    if (!isBlocking()) {
                                        do {
                                            i11 = checkConnect(this.f53731fd, false, this.readyToConnect);
                                            if (i11 != -3) {
                                                break;
                                            }
                                        } while (isOpen());
                                    } else {
                                        while (true) {
                                            i11 = checkConnect(this.f53731fd, true, this.readyToConnect);
                                            if (i11 != 0) {
                                                if (i11 != -3 || !isOpen()) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    synchronized (this.stateLock) {
                                        try {
                                            this.readerThread = 0L;
                                            r73 = this.state;
                                            if (r73 == 3) {
                                                kill();
                                                i11 = 0;
                                            }
                                        } catch (Throwable th2) {
                                            r32 = th2;
                                            j10 = r73;
                                        }
                                    }
                                    end(i11 > 0 || i11 == -2);
                                    if (i11 <= 0) {
                                        return false;
                                    }
                                    synchronized (this.stateLock) {
                                        this.state = 2;
                                        if (isOpen()) {
                                            this.localAddress = Net.localAddress(this.f53731fd);
                                        }
                                    }
                                    return true;
                                    throw r32;
                                }
                            }
                        } catch (Throwable th3) {
                            synchronized (this.stateLock) {
                                this.readerThread = j10;
                                if (this.state == 3) {
                                    kill();
                                    i11 = 0;
                                }
                                if (i11 <= 0 && i11 != r32) {
                                    z10 = false;
                                }
                                end(z10);
                                throw th3;
                            }
                        }
                    } catch (IOException e2) {
                        close();
                        throw e2;
                    }
                }
            }
        }
    }

    @Override // java.nio.channels.SocketChannel
    public SocketChannel shutdownInput() throws IOException {
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (!isConnected()) {
                throw new NotYetConnectedException();
            }
            if (this.isInputOpen) {
                Net.shutdown(this.f53731fd, 0);
                if (this.readerThread != 0) {
                    NativeThread.signal(this.readerThread);
                }
                this.isInputOpen = false;
            }
        }
        return this;
    }

    @Override // java.nio.channels.SocketChannel
    public SocketChannel shutdownOutput() throws IOException {
        synchronized (this.stateLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (!isConnected()) {
                throw new NotYetConnectedException();
            }
            if (this.isOutputOpen) {
                Net.shutdown(this.f53731fd, 1);
                if (this.writerThread != 0) {
                    NativeThread.signal(this.writerThread);
                }
                this.isOutputOpen = false;
            }
        }
        return this;
    }

    public boolean isInputOpen() {
        boolean z10;
        synchronized (this.stateLock) {
            z10 = this.isInputOpen;
        }
        return z10;
    }

    public boolean isOutputOpen() {
        boolean z10;
        synchronized (this.stateLock) {
            z10 = this.isOutputOpen;
        }
        return z10;
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implCloseSelectableChannel() throws IOException {
        synchronized (this.stateLock) {
            this.isInputOpen = false;
            this.isOutputOpen = false;
            if (this.state != 4) {
                this.guard.close();
                f53730nd.preClose(this.f53731fd);
            }
            if (this.readerThread != 0) {
                NativeThread.signal(this.readerThread);
            }
            if (this.writerThread != 0) {
                NativeThread.signal(this.writerThread);
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
            if (i10 == 4) {
                return;
            }
            if (i10 == -1) {
                this.state = 4;
                return;
            }
            if (this.readerThread == 0 && this.writerThread == 0) {
                f53730nd.close(this.f53731fd);
                this.state = 4;
            } else {
                this.state = 3;
            }
        }
    }

    protected void finalize() throws IOException {
        CloseGuard closeGuard = this.guard;
        if (closeGuard != null) {
            closeGuard.warnIfOpen();
        }
        if (this.f53731fd != null) {
            close();
        }
    }

    public boolean translateReadyOps(int ops, int initialOps, SelectionKeyImpl sk) {
        int i10;
        int intOps = sk.nioInterestOps();
        int oldOps = sk.nioReadyOps();
        int newOps = initialOps;
        if ((Net.POLLNVAL & ops) != 0) {
            return false;
        }
        if (((Net.POLLERR | Net.POLLHUP) & ops) != 0) {
            sk.nioReadyOps(intOps);
            this.readyToConnect = true;
            return ((~oldOps) & intOps) != 0;
        }
        if ((Net.POLLIN & ops) != 0 && (intOps & 1) != 0 && this.state == 2) {
            newOps |= 1;
        }
        if ((Net.POLLCONN & ops) != 0 && (intOps & 8) != 0 && ((i10 = this.state) == 0 || i10 == 1)) {
            newOps |= 8;
            this.readyToConnect = true;
        }
        if ((Net.POLLOUT & ops) != 0 && (intOps & 4) != 0 && this.state == 2) {
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
                    int n10 = Net.poll(this.f53731fd, events, timeout);
                    readerCleanup();
                    if (n10 <= 0) {
                        z10 = false;
                    }
                    end(z10);
                    return n10;
                }
            } finally {
                readerCleanup();
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
            newOps |= Net.POLLCONN;
        }
        sk.selector.putEventOps(sk, newOps);
    }

    @Override // sun.nio.ch.SelChImpl
    public FileDescriptor getFD() {
        return this.f53731fd;
    }

    @Override // sun.nio.ch.SelChImpl
    public int getFDVal() {
        return this.fdVal;
    }

    public String toString() {
        StringBuffer sb2 = new StringBuffer();
        sb2.append(getClass().getSuperclass().getName());
        sb2.append('[');
        if (!isOpen()) {
            sb2.append("closed");
        } else {
            synchronized (this.stateLock) {
                switch (this.state) {
                    case 0:
                        sb2.append("unconnected");
                        break;
                    case 1:
                        sb2.append("connection-pending");
                        break;
                    case 2:
                        sb2.append(u.bf);
                        if (!this.isInputOpen) {
                            sb2.append(" ishut");
                        }
                        if (!this.isOutputOpen) {
                            sb2.append(" oshut");
                            break;
                        }
                        break;
                }
                InetSocketAddress addr = localAddress();
                if (addr != null) {
                    sb2.append(" local=");
                    sb2.append(Net.getRevealedLocalAddressAsString(addr));
                }
                if (remoteAddress() != null) {
                    sb2.append(" remote=");
                    sb2.append(remoteAddress().toString());
                }
            }
        }
        sb2.append(']');
        return sb2.toString();
    }
}
