package java.net;

import dalvik.annotation.optimization.ReachabilitySensitive;
import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import sun.net.ConnectionResetException;
import sun.net.NetHooks;
import sun.net.ResourceManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractPlainSocketImpl extends SocketImpl {
    public static final int SHUT_RD = 0;
    public static final int SHUT_WR = 1;
    private int resetState;
    protected boolean stream;
    int timeout;
    private boolean shut_rd = false;
    private boolean shut_wr = false;
    private SocketInputStream socketInputStream = null;
    private SocketOutputStream socketOutputStream = null;
    protected int fdUseCount = 0;

    @ReachabilitySensitive
    protected final Object fdLock = new Object();
    protected boolean closePending = false;
    private int CONNECTION_NOT_RESET = 0;
    private int CONNECTION_RESET_PENDING = 1;
    private int CONNECTION_RESET = 2;
    private final Object resetLock = new Object();

    @ReachabilitySensitive
    private final CloseGuard guard = CloseGuard.get();

    abstract void socketAccept(SocketImpl socketImpl) throws IOException;

    abstract int socketAvailable() throws IOException;

    abstract void socketBind(InetAddress inetAddress, int i10) throws IOException;

    abstract void socketClose0(boolean z10) throws IOException;

    abstract void socketConnect(InetAddress inetAddress, int i10, int i11) throws IOException;

    abstract void socketCreate(boolean z10) throws IOException;

    abstract Object socketGetOption(int i10) throws SocketException;

    abstract void socketListen(int i10) throws IOException;

    abstract void socketSendUrgentData(int i10) throws IOException;

    abstract void socketSetOption(int i10, Object obj) throws SocketException;

    abstract void socketShutdown(int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public synchronized void create(boolean stream) throws IOException {
        this.stream = stream;
        if (!stream) {
            ResourceManager.beforeUdpCreate();
            try {
                socketCreate(false);
            } catch (IOException ioe) {
                ResourceManager.afterUdpClose();
                throw ioe;
            }
        } else {
            socketCreate(true);
        }
        if (this.socket != null) {
            this.socket.setCreated();
        }
        if (this.serverSocket != null) {
            this.serverSocket.setCreated();
        }
        if (this.f50370fd != null && this.f50370fd.valid()) {
            this.guard.open("close");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void connect(String host, int port) throws UnknownHostException, IOException {
        try {
            InetAddress address = InetAddress.getByName(host);
            this.port = port;
            this.address = address;
            connectToAddress(address, port, this.timeout);
            if (1 == 0) {
                try {
                    close();
                } catch (IOException e2) {
                }
            }
        } catch (Throwable th) {
            if (0 == 0) {
                try {
                    close();
                } catch (IOException e10) {
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void connect(InetAddress address, int port) throws IOException {
        this.port = port;
        this.address = address;
        try {
            connectToAddress(address, port, this.timeout);
        } catch (IOException e2) {
            close();
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void connect(SocketAddress address, int timeout) throws IOException {
        if (address != null) {
            try {
                if (address instanceof InetSocketAddress) {
                    InetSocketAddress addr = (InetSocketAddress) address;
                    if (addr.isUnresolved()) {
                        throw new UnknownHostException(addr.getHostName());
                    }
                    this.port = addr.getPort();
                    this.address = addr.getAddress();
                    connectToAddress(this.address, this.port, timeout);
                    if (1 == 0) {
                        try {
                            close();
                            return;
                        } catch (IOException e2) {
                            return;
                        }
                    }
                    return;
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    try {
                        close();
                    } catch (IOException e10) {
                    }
                }
                throw th;
            }
        }
        throw new IllegalArgumentException("unsupported address type");
    }

    private void connectToAddress(InetAddress address, int port, int timeout) throws IOException {
        if (address.isAnyLocalAddress()) {
            doConnect(InetAddress.getLocalHost(), port, timeout);
        } else {
            doConnect(address, port, timeout);
        }
    }

    @Override // java.net.SocketOptions
    public void setOption(int opt, Object val) throws SocketException {
        if (isClosedOrPending()) {
            throw new SocketException("Socket Closed");
        }
        if (opt == 4102) {
            this.timeout = ((Integer) val).intValue();
        }
        socketSetOption(opt, val);
    }

    @Override // java.net.SocketOptions
    public Object getOption(int opt) throws SocketException {
        if (isClosedOrPending()) {
            throw new SocketException("Socket Closed");
        }
        if (opt == 4102) {
            return new Integer(this.timeout);
        }
        return socketGetOption(opt);
    }

    synchronized void doConnect(InetAddress address, int port, int timeout) throws IOException {
        synchronized (this.fdLock) {
            try {
                if (!this.closePending) {
                    try {
                        if (this.socket == null || !this.socket.isBound()) {
                            NetHooks.beforeTcpConnect(this.f50370fd, address, port);
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
                try {
                    acquireFD();
                    try {
                        BlockGuard.getThreadPolicy().onNetwork();
                        socketConnect(address, port, timeout);
                        synchronized (this.fdLock) {
                            try {
                                if (this.closePending) {
                                    throw new SocketException("Socket closed");
                                }
                                try {
                                    try {
                                        if (this.socket != null) {
                                            this.socket.setBound();
                                            this.socket.setConnected();
                                        }
                                        releaseFD();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        releaseFD();
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (IOException e2) {
                    close();
                    throw e2;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public synchronized void bind(InetAddress address, int lport) throws IOException {
        synchronized (this.fdLock) {
            try {
                if (!this.closePending) {
                    try {
                        if (this.socket == null || !this.socket.isBound()) {
                            NetHooks.beforeTcpBind(this.f50370fd, address, lport);
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
                socketBind(address, lport);
                if (this.socket != null) {
                    this.socket.setBound();
                }
                if (this.serverSocket != null) {
                    this.serverSocket.setBound();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public synchronized void listen(int count) throws IOException {
        socketListen(count);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void accept(SocketImpl s2) throws IOException {
        acquireFD();
        try {
            BlockGuard.getThreadPolicy().onNetwork();
            socketAccept(s2);
        } finally {
            releaseFD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public synchronized InputStream getInputStream() throws IOException {
        try {
            synchronized (this.fdLock) {
                try {
                    if (isClosedOrPending()) {
                        throw new IOException("Socket Closed");
                    }
                    if (this.shut_rd) {
                        throw new IOException("Socket input is shutdown");
                    }
                    if (this.socketInputStream == null) {
                        this.socketInputStream = new SocketInputStream(this);
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return this.socketInputStream;
    }

    void setInputStream(SocketInputStream in) {
        this.socketInputStream = in;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public synchronized OutputStream getOutputStream() throws IOException {
        try {
            synchronized (this.fdLock) {
                try {
                    if (isClosedOrPending()) {
                        throw new IOException("Socket Closed");
                    }
                    if (this.shut_wr) {
                        throw new IOException("Socket output is shutdown");
                    }
                    if (this.socketOutputStream == null) {
                        this.socketOutputStream = new SocketOutputStream(this);
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return this.socketOutputStream;
    }

    void setAddress(InetAddress address) {
        this.address = address;
    }

    void setPort(int port) {
        this.port = port;
    }

    void setLocalPort(int localport) {
        this.localport = localport;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public synchronized int available() throws IOException {
        if (isClosedOrPending()) {
            throw new IOException("Stream closed.");
        }
        if (isConnectionReset() || this.shut_rd) {
            return 0;
        }
        int n10 = 0;
        try {
            n10 = socketAvailable();
            if (n10 == 0 && isConnectionResetPending()) {
                setConnectionReset();
            }
        } catch (ConnectionResetException e2) {
            setConnectionResetPending();
            try {
                n10 = socketAvailable();
                if (n10 == 0) {
                    setConnectionReset();
                }
            } catch (ConnectionResetException e10) {
            }
        }
        return n10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void close() throws IOException {
        synchronized (this.fdLock) {
            if (this.f50370fd != null && this.f50370fd.valid()) {
                if (!this.stream) {
                    ResourceManager.afterUdpClose();
                }
                if (!this.closePending) {
                    this.closePending = true;
                    this.guard.close();
                    int i10 = this.fdUseCount;
                    if (i10 == 0) {
                        try {
                            socketPreClose();
                            return;
                        } finally {
                            socketClose();
                        }
                    }
                    this.fdUseCount = i10 - 1;
                    socketPreClose();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.net.SocketImpl
    public void reset() throws IOException {
        if (this.f50370fd != null && this.f50370fd.valid()) {
            socketClose();
            this.guard.close();
        }
        super.reset();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void shutdownInput() throws IOException {
        if (this.f50370fd != null && this.f50370fd.valid()) {
            socketShutdown(0);
            SocketInputStream socketInputStream = this.socketInputStream;
            if (socketInputStream != null) {
                socketInputStream.setEOF(true);
            }
            this.shut_rd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void shutdownOutput() throws IOException {
        if (this.f50370fd != null && this.f50370fd.valid()) {
            socketShutdown(1);
            this.shut_wr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public boolean supportsUrgentData() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public void sendUrgentData(int data) throws IOException {
        if (this.f50370fd == null || !this.f50370fd.valid()) {
            throw new IOException("Socket Closed");
        }
        socketSendUrgentData(data);
    }

    protected void finalize() throws IOException {
        CloseGuard closeGuard = this.guard;
        if (closeGuard != null) {
            closeGuard.warnIfOpen();
        }
        close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileDescriptor acquireFD() {
        FileDescriptor fileDescriptor;
        synchronized (this.fdLock) {
            this.fdUseCount++;
            fileDescriptor = this.f50370fd;
        }
        return fileDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void releaseFD() {
        synchronized (this.fdLock) {
            int i10 = this.fdUseCount - 1;
            this.fdUseCount = i10;
            if (i10 == -1 && this.f50370fd != null) {
                try {
                    socketClose();
                } catch (IOException e2) {
                }
            }
        }
    }

    public boolean isConnectionReset() {
        boolean z10;
        synchronized (this.resetLock) {
            z10 = this.resetState == this.CONNECTION_RESET;
        }
        return z10;
    }

    public boolean isConnectionResetPending() {
        boolean z10;
        synchronized (this.resetLock) {
            z10 = this.resetState == this.CONNECTION_RESET_PENDING;
        }
        return z10;
    }

    public void setConnectionReset() {
        synchronized (this.resetLock) {
            this.resetState = this.CONNECTION_RESET;
        }
    }

    public void setConnectionResetPending() {
        synchronized (this.resetLock) {
            if (this.resetState == this.CONNECTION_NOT_RESET) {
                this.resetState = this.CONNECTION_RESET_PENDING;
            }
        }
    }

    public boolean isClosedOrPending() {
        synchronized (this.fdLock) {
            if (!this.closePending && this.f50370fd != null && this.f50370fd.valid()) {
                return false;
            }
            return true;
        }
    }

    public int getTimeout() {
        return this.timeout;
    }

    private void socketPreClose() throws IOException {
        socketClose0(true);
    }

    protected void socketClose() throws IOException {
        socketClose0(false);
    }
}
