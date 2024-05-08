package java.net;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.nio.channels.SocketChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Collections;
import java.util.Set;
import sun.net.ApplicationProxy;
import sun.security.util.SecurityConstants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Socket implements Closeable {
    private static Set<SocketOption<?>> options;
    private boolean bound;
    private Object closeLock;
    private boolean closed;
    private boolean connected;
    private boolean created;
    SocketImpl impl;
    private boolean oldImpl;
    private boolean shutIn;
    private boolean shutOut;
    private static SocketImplFactory factory = null;
    private static boolean optionsSet = false;

    public Socket() {
        this.created = false;
        this.bound = false;
        this.connected = false;
        this.closed = false;
        this.closeLock = new Object();
        this.shutIn = false;
        this.shutOut = false;
        this.oldImpl = false;
        setImpl();
    }

    public Socket(Proxy proxy) {
        this.created = false;
        this.bound = false;
        this.connected = false;
        this.closed = false;
        this.closeLock = new Object();
        this.shutIn = false;
        this.shutOut = false;
        this.oldImpl = false;
        if (proxy == null) {
            throw new IllegalArgumentException("Invalid Proxy");
        }
        Proxy p10 = proxy == Proxy.NO_PROXY ? Proxy.NO_PROXY : ApplicationProxy.create(proxy);
        Proxy.Type type = p10.type();
        if (type == Proxy.Type.SOCKS) {
            SecurityManager security = System.getSecurityManager();
            InetSocketAddress epoint = (InetSocketAddress) p10.address();
            if (epoint.getAddress() != null) {
                checkAddress(epoint.getAddress(), "Socket");
            }
            if (security != null) {
                epoint = epoint.isUnresolved() ? new InetSocketAddress(epoint.getHostName(), epoint.getPort()) : epoint;
                if (epoint.isUnresolved()) {
                    security.checkConnect(epoint.getHostName(), epoint.getPort());
                } else {
                    security.checkConnect(epoint.getAddress().getHostAddress(), epoint.getPort());
                }
            }
            SocksSocketImpl socksSocketImpl = new SocksSocketImpl(p10);
            this.impl = socksSocketImpl;
            socksSocketImpl.setSocket(this);
            return;
        }
        if (p10 == Proxy.NO_PROXY) {
            if (factory == null) {
                PlainSocketImpl plainSocketImpl = new PlainSocketImpl();
                this.impl = plainSocketImpl;
                plainSocketImpl.setSocket(this);
                return;
            }
            setImpl();
            return;
        }
        throw new IllegalArgumentException("Invalid Proxy");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Socket(SocketImpl impl) throws SocketException {
        this.created = false;
        this.bound = false;
        this.connected = false;
        this.closed = false;
        this.closeLock = new Object();
        this.shutIn = false;
        this.shutOut = false;
        this.oldImpl = false;
        checkPermission(impl);
        this.impl = impl;
        if (impl != null) {
            checkOldImpl();
            this.impl.setSocket(this);
        }
    }

    private static Void checkPermission(SocketImpl impl) {
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Socket(String host, int port) throws UnknownHostException, IOException {
        this(InetAddress.getAllByName(host), port, (SocketAddress) null, true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Socket(InetAddress address, int port) throws IOException {
        this(nonNullAddress(address), port, (SocketAddress) null, true);
    }

    public Socket(String host, int port, InetAddress localAddr, int localPort) throws IOException {
        this(InetAddress.getAllByName(host), port, (SocketAddress) new InetSocketAddress(localAddr, localPort), true);
    }

    public Socket(InetAddress address, int port, InetAddress localAddr, int localPort) throws IOException {
        this(nonNullAddress(address), port, (SocketAddress) new InetSocketAddress(localAddr, localPort), true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public Socket(String host, int port, boolean stream) throws IOException {
        this(InetAddress.getAllByName(host), port, (SocketAddress) null, stream);
    }

    @Deprecated
    public Socket(InetAddress host, int port, boolean stream) throws IOException {
        this(nonNullAddress(host), port, new InetSocketAddress(0), stream);
    }

    private static InetAddress[] nonNullAddress(InetAddress address) {
        if (address == null) {
            throw new NullPointerException();
        }
        return new InetAddress[]{address};
    }

    private Socket(InetAddress[] addresses, int port, SocketAddress localAddr, boolean stream) throws IOException {
        this.created = false;
        this.bound = false;
        this.connected = false;
        this.closed = false;
        this.closeLock = new Object();
        this.shutIn = false;
        this.shutOut = false;
        this.oldImpl = false;
        if (addresses == null || addresses.length == 0) {
            throw new SocketException("Impossible: empty address list");
        }
        for (int i10 = 0; i10 < addresses.length; i10++) {
            setImpl();
            try {
                InetSocketAddress address = new InetSocketAddress(addresses[i10], port);
                createImpl(stream);
                if (localAddr != null) {
                    bind(localAddr);
                }
                connect(address);
                return;
            } catch (IOException | IllegalArgumentException | SecurityException e2) {
                try {
                    this.impl.close();
                    this.closed = true;
                } catch (IOException ce2) {
                    e2.addSuppressed(ce2);
                }
                if (i10 == addresses.length - 1) {
                    throw e2;
                }
                this.impl = null;
                this.created = false;
                this.bound = false;
                this.closed = false;
            }
        }
    }

    void createImpl(boolean stream) throws SocketException {
        if (this.impl == null) {
            setImpl();
        }
        try {
            this.impl.create(stream);
            this.created = true;
        } catch (IOException e2) {
            throw new SocketException(e2.getMessage());
        }
    }

    private void checkOldImpl() {
        if (this.impl == null) {
            return;
        }
        this.oldImpl = ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: java.net.Socket.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                Class<?> clazz = Socket.this.impl.getClass();
                do {
                    try {
                        clazz.getDeclaredMethod(SecurityConstants.SOCKET_CONNECT_ACTION, SocketAddress.class, Integer.TYPE);
                        return Boolean.FALSE;
                    } catch (NoSuchMethodException e2) {
                        clazz = clazz.getSuperclass();
                    }
                } while (!clazz.equals(SocketImpl.class));
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setImpl() {
        SocketImplFactory socketImplFactory = factory;
        if (socketImplFactory != null) {
            this.impl = socketImplFactory.createSocketImpl();
            checkOldImpl();
        } else {
            this.impl = new SocksSocketImpl();
        }
        SocketImpl socketImpl = this.impl;
        if (socketImpl != null) {
            socketImpl.setSocket(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SocketImpl getImpl() throws SocketException {
        if (!this.created) {
            createImpl(true);
        }
        return this.impl;
    }

    public void connect(SocketAddress endpoint) throws IOException {
        connect(endpoint, 0);
    }

    public void connect(SocketAddress endpoint, int timeout) throws IOException {
        if (endpoint == null) {
            throw new IllegalArgumentException("connect: The address can't be null");
        }
        if (timeout < 0) {
            throw new IllegalArgumentException("connect: timeout can't be negative");
        }
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!this.oldImpl && isConnected()) {
            throw new SocketException("already connected");
        }
        if (!(endpoint instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        }
        InetSocketAddress epoint = (InetSocketAddress) endpoint;
        InetAddress addr = epoint.getAddress();
        int port = epoint.getPort();
        checkAddress(addr, SecurityConstants.SOCKET_CONNECT_ACTION);
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            if (epoint.isUnresolved()) {
                security.checkConnect(epoint.getHostName(), port);
            } else {
                security.checkConnect(addr.getHostAddress(), port);
            }
        }
        if (!this.created) {
            createImpl(true);
        }
        if (!this.oldImpl) {
            this.impl.connect(epoint, timeout);
        } else if (timeout == 0) {
            if (epoint.isUnresolved()) {
                this.impl.connect(addr.getHostName(), port);
            } else {
                this.impl.connect(addr, port);
            }
        } else {
            throw new UnsupportedOperationException("SocketImpl.connect(addr, timeout)");
        }
        this.connected = true;
        this.bound = true;
    }

    public void bind(SocketAddress bindpoint) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!this.oldImpl && isBound()) {
            throw new SocketException("Already bound");
        }
        if (bindpoint != null && !(bindpoint instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        }
        InetSocketAddress epoint = (InetSocketAddress) bindpoint;
        if (epoint != null && epoint.isUnresolved()) {
            throw new SocketException("Unresolved address");
        }
        if (epoint == null) {
            epoint = new InetSocketAddress(0);
        }
        InetAddress addr = epoint.getAddress();
        int port = epoint.getPort();
        checkAddress(addr, "bind");
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkListen(port);
        }
        getImpl().bind(addr, port);
        this.bound = true;
    }

    private void checkAddress(InetAddress addr, String op) {
        if (addr != null && !(addr instanceof Inet4Address) && !(addr instanceof Inet6Address)) {
            throw new IllegalArgumentException(op + ": invalid address type");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void postAccept() {
        this.connected = true;
        this.created = true;
        this.bound = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCreated() {
        this.created = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBound() {
        this.bound = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConnected() {
        this.connected = true;
    }

    public InetAddress getInetAddress() {
        if (!isConnected()) {
            return null;
        }
        try {
            return getImpl().getInetAddress();
        } catch (SocketException e2) {
            return null;
        }
    }

    public InetAddress getLocalAddress() {
        if (!isBound()) {
            return InetAddress.anyLocalAddress();
        }
        try {
            InetAddress in = (InetAddress) getImpl().getOption(15);
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkConnect(in.getHostAddress(), -1);
            }
            if (!in.isAnyLocalAddress()) {
                return in;
            }
            InetAddress in2 = InetAddress.anyLocalAddress();
            return in2;
        } catch (SecurityException e2) {
            InetAddress in3 = InetAddress.getLoopbackAddress();
            return in3;
        } catch (Exception e10) {
            InetAddress in4 = InetAddress.anyLocalAddress();
            return in4;
        }
    }

    public int getPort() {
        if (!isConnected()) {
            return 0;
        }
        try {
            return getImpl().getPort();
        } catch (SocketException e2) {
            return -1;
        }
    }

    public int getLocalPort() {
        if (!isBound()) {
            return -1;
        }
        try {
            return getImpl().getLocalPort();
        } catch (SocketException e2) {
            return -1;
        }
    }

    public SocketAddress getRemoteSocketAddress() {
        if (!isConnected()) {
            return null;
        }
        return new InetSocketAddress(getInetAddress(), getPort());
    }

    public SocketAddress getLocalSocketAddress() {
        if (!isBound()) {
            return null;
        }
        return new InetSocketAddress(getLocalAddress(), getLocalPort());
    }

    public SocketChannel getChannel() {
        return null;
    }

    public InputStream getInputStream() throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!isConnected()) {
            throw new SocketException("Socket is not connected");
        }
        if (isInputShutdown()) {
            throw new SocketException("Socket input is shutdown");
        }
        try {
            InputStream is = (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction<InputStream>() { // from class: java.net.Socket.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public InputStream run() throws IOException {
                    return Socket.this.impl.getInputStream();
                }
            });
            return is;
        } catch (PrivilegedActionException e2) {
            throw ((IOException) e2.getException());
        }
    }

    public OutputStream getOutputStream() throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!isConnected()) {
            throw new SocketException("Socket is not connected");
        }
        if (isOutputShutdown()) {
            throw new SocketException("Socket output is shutdown");
        }
        try {
            OutputStream os = (OutputStream) AccessController.doPrivileged(new PrivilegedExceptionAction<OutputStream>() { // from class: java.net.Socket.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public OutputStream run() throws IOException {
                    return Socket.this.impl.getOutputStream();
                }
            });
            return os;
        } catch (PrivilegedActionException e2) {
            throw ((IOException) e2.getException());
        }
    }

    public void setTcpNoDelay(boolean on) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setOption(1, Boolean.valueOf(on));
    }

    public boolean getTcpNoDelay() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        return ((Boolean) getImpl().getOption(1)).booleanValue();
    }

    public void setSoLinger(boolean on, int linger) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!on) {
            getImpl().setOption(128, Boolean.valueOf(on));
        } else {
            if (linger < 0) {
                throw new IllegalArgumentException("invalid value for SO_LINGER");
            }
            if (linger > 65535) {
                linger = 65535;
            }
            getImpl().setOption(128, Integer.valueOf(linger));
        }
    }

    public int getSoLinger() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        Object o10 = getImpl().getOption(128);
        if (o10 instanceof Integer) {
            return ((Integer) o10).intValue();
        }
        return -1;
    }

    public void sendUrgentData(int data) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!getImpl().supportsUrgentData()) {
            throw new SocketException("Urgent data not supported");
        }
        getImpl().sendUrgentData(data);
    }

    public void setOOBInline(boolean on) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setOption(4099, Boolean.valueOf(on));
    }

    public boolean getOOBInline() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        return ((Boolean) getImpl().getOption(4099)).booleanValue();
    }

    public synchronized void setSoTimeout(int timeout) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout can't be negative");
        }
        getImpl().setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    public synchronized int getSoTimeout() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        Object o10 = getImpl().getOption(SocketOptions.SO_TIMEOUT);
        if (!(o10 instanceof Integer)) {
            return 0;
        }
        return ((Integer) o10).intValue();
    }

    public synchronized void setSendBufferSize(int size) throws SocketException {
        try {
            if (size <= 0) {
                throw new IllegalArgumentException("negative send size");
            }
            if (isClosed()) {
                throw new SocketException("Socket is closed");
            }
            getImpl().setOption(4097, Integer.valueOf(size));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int getSendBufferSize() throws SocketException {
        int result;
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        result = 0;
        Object o10 = getImpl().getOption(4097);
        if (o10 instanceof Integer) {
            result = ((Integer) o10).intValue();
        }
        return result;
    }

    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        try {
            if (size <= 0) {
                throw new IllegalArgumentException("invalid receive size");
            }
            if (isClosed()) {
                throw new SocketException("Socket is closed");
            }
            getImpl().setOption(4098, Integer.valueOf(size));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int getReceiveBufferSize() throws SocketException {
        int result;
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        result = 0;
        Object o10 = getImpl().getOption(4098);
        if (o10 instanceof Integer) {
            result = ((Integer) o10).intValue();
        }
        return result;
    }

    public void setKeepAlive(boolean on) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setOption(8, Boolean.valueOf(on));
    }

    public boolean getKeepAlive() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        return ((Boolean) getImpl().getOption(8)).booleanValue();
    }

    public void setTrafficClass(int tc2) throws SocketException {
        if (tc2 < 0 || tc2 > 255) {
            throw new IllegalArgumentException("tc is not in range 0 -- 255");
        }
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        try {
            getImpl().setOption(3, Integer.valueOf(tc2));
        } catch (SocketException se) {
            if (!isConnected()) {
                throw se;
            }
        }
    }

    public int getTrafficClass() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        return ((Integer) getImpl().getOption(3)).intValue();
    }

    public void setReuseAddress(boolean on) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setOption(4, Boolean.valueOf(on));
    }

    public boolean getReuseAddress() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        return ((Boolean) getImpl().getOption(4)).booleanValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        synchronized (this.closeLock) {
            try {
                if (isClosed()) {
                    return;
                }
                if (this.created) {
                    this.impl.close();
                }
                this.closed = true;
            } finally {
                th = th;
                while (true) {
                    try {
                        break;
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            }
        }
    }

    public void shutdownInput() throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!isConnected()) {
            throw new SocketException("Socket is not connected");
        }
        if (isInputShutdown()) {
            throw new SocketException("Socket input is already shutdown");
        }
        getImpl().shutdownInput();
        this.shutIn = true;
    }

    public void shutdownOutput() throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!isConnected()) {
            throw new SocketException("Socket is not connected");
        }
        if (isOutputShutdown()) {
            throw new SocketException("Socket output is already shutdown");
        }
        getImpl().shutdownOutput();
        this.shutOut = true;
    }

    public String toString() {
        try {
            if (isConnected()) {
                return "Socket[address=" + ((Object) getImpl().getInetAddress()) + ",port=" + getImpl().getPort() + ",localPort=" + getImpl().getLocalPort() + "]";
            }
            return "Socket[unconnected]";
        } catch (SocketException e2) {
            return "Socket[unconnected]";
        }
    }

    public boolean isConnected() {
        return this.connected || this.oldImpl;
    }

    public boolean isBound() {
        return this.bound || this.oldImpl;
    }

    public boolean isClosed() {
        boolean z10;
        synchronized (this.closeLock) {
            z10 = this.closed;
        }
        return z10;
    }

    public boolean isInputShutdown() {
        return this.shutIn;
    }

    public boolean isOutputShutdown() {
        return this.shutOut;
    }

    public static synchronized void setSocketImplFactory(SocketImplFactory fac) throws IOException {
        synchronized (Socket.class) {
            if (factory != null) {
                throw new SocketException("factory already defined");
            }
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkSetFactory();
            }
            factory = fac;
        }
    }

    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
    }

    public <T> Socket setOption(SocketOption<T> name, T value) throws IOException {
        getImpl().setOption((SocketOption<SocketOption<T>>) name, (SocketOption<T>) value);
        return this;
    }

    public <T> T getOption(SocketOption<T> socketOption) throws IOException {
        return (T) getImpl().getOption(socketOption);
    }

    public Set<SocketOption<?>> supportedOptions() {
        synchronized (Socket.class) {
            if (optionsSet) {
                return options;
            }
            try {
                SocketImpl impl = getImpl();
                options = Collections.unmodifiableSet(impl.supportedOptions());
            } catch (IOException e2) {
                options = Collections.emptySet();
            }
            optionsSet = true;
            return options;
        }
    }

    public FileDescriptor getFileDescriptor$() {
        return this.impl.getFileDescriptor();
    }
}
