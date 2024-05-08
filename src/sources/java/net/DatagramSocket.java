package java.net;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Collections;
import java.util.Set;
import sun.security.util.SecurityConstants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DatagramSocket implements Closeable {
    static final int ST_CONNECTED = 1;
    static final int ST_CONNECTED_NO_IMPL = 2;
    static final int ST_NOT_CONNECTED = 0;
    static DatagramSocketImplFactory factory;
    private static Set<SocketOption<?>> options;
    private boolean bound;
    private int bytesLeftToFilter;
    private Object closeLock;
    private boolean closed;
    int connectState;
    InetAddress connectedAddress;
    int connectedPort;
    private boolean created;
    private boolean explicitFilter;
    DatagramSocketImpl impl;
    boolean oldImpl;
    private SocketException pendingConnectException;
    static Class<?> implClass = null;
    private static boolean optionsSet = false;

    private synchronized void connectInternal(InetAddress address, int port) throws SocketException {
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("connect: " + port);
        }
        if (address == null) {
            throw new IllegalArgumentException("connect: null address");
        }
        checkAddress(address, SecurityConstants.SOCKET_CONNECT_ACTION);
        if (isClosed()) {
            return;
        }
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            if (address.isMulticastAddress()) {
                security.checkMulticast(address);
            } else {
                security.checkConnect(address.getHostAddress(), port);
                security.checkAccept(address.getHostAddress(), port);
            }
        }
        if (!isBound()) {
            bind(new InetSocketAddress(0));
        }
        try {
            if (!this.oldImpl) {
                try {
                    DatagramSocketImpl datagramSocketImpl = this.impl;
                    if (!(datagramSocketImpl instanceof AbstractPlainDatagramSocketImpl) || !((AbstractPlainDatagramSocketImpl) datagramSocketImpl).nativeConnectDisabled()) {
                        try {
                            getImpl().connect(address, port);
                            this.connectState = 1;
                            int avail = getImpl().dataAvailable();
                            if (avail == -1) {
                                throw new SocketException();
                            }
                            boolean z10 = avail > 0;
                            try {
                                this.explicitFilter = z10;
                                if (z10) {
                                    this.bytesLeftToFilter = getReceiveBufferSize();
                                }
                                this.connectedAddress = address;
                                this.connectedPort = port;
                            } catch (SocketException e2) {
                                se = e2;
                                this.connectState = 2;
                                throw se;
                            }
                        } catch (SocketException e10) {
                            se = e10;
                        }
                    }
                } catch (Throwable th) {
                    se = th;
                    this.connectedAddress = address;
                    this.connectedPort = port;
                    throw se;
                }
            }
            this.connectState = 2;
            this.connectedAddress = address;
            this.connectedPort = port;
        } catch (Throwable th2) {
            se = th2;
        }
    }

    public DatagramSocket() throws SocketException {
        this(new InetSocketAddress(0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DatagramSocket(DatagramSocketImpl impl) {
        this.created = false;
        this.bound = false;
        this.closed = false;
        this.closeLock = new Object();
        this.oldImpl = false;
        this.explicitFilter = false;
        this.connectState = 0;
        this.connectedAddress = null;
        this.connectedPort = -1;
        if (impl == null) {
            throw new NullPointerException();
        }
        this.impl = impl;
        checkOldImpl();
    }

    public DatagramSocket(SocketAddress bindaddr) throws SocketException {
        this.created = false;
        this.bound = false;
        this.closed = false;
        this.closeLock = new Object();
        this.oldImpl = false;
        this.explicitFilter = false;
        this.connectState = 0;
        this.connectedAddress = null;
        this.connectedPort = -1;
        createImpl();
        if (bindaddr != null) {
            try {
                bind(bindaddr);
            } finally {
                if (!isBound()) {
                    close();
                }
            }
        }
    }

    public DatagramSocket(int port) throws SocketException {
        this(port, null);
    }

    public DatagramSocket(int port, InetAddress laddr) throws SocketException {
        this(new InetSocketAddress(laddr, port));
    }

    private void checkOldImpl() {
        if (this.impl == null) {
            return;
        }
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() { // from class: java.net.DatagramSocket.1
                @Override // java.security.PrivilegedExceptionAction
                public Object run() throws NoSuchMethodException {
                    Class<?>[] cl = {DatagramPacket.class};
                    DatagramSocket.this.impl.getClass().getDeclaredMethod("peekData", cl);
                    return null;
                }
            });
        } catch (PrivilegedActionException e2) {
            this.oldImpl = true;
        }
    }

    void createImpl() throws SocketException {
        if (this.impl == null) {
            DatagramSocketImplFactory datagramSocketImplFactory = factory;
            if (datagramSocketImplFactory != null) {
                this.impl = datagramSocketImplFactory.createDatagramSocketImpl();
                checkOldImpl();
            } else {
                boolean isMulticast = this instanceof MulticastSocket;
                this.impl = DefaultDatagramSocketImplFactory.createDatagramSocketImpl(isMulticast);
                checkOldImpl();
            }
        }
        this.impl.create();
        this.impl.setDatagramSocket(this);
        this.created = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DatagramSocketImpl getImpl() throws SocketException {
        if (!this.created) {
            createImpl();
        }
        return this.impl;
    }

    public synchronized void bind(SocketAddress addr) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (isBound()) {
            throw new SocketException("already bound");
        }
        if (addr == null) {
            addr = new InetSocketAddress(0);
        }
        if (!(addr instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type!");
        }
        InetSocketAddress epoint = (InetSocketAddress) addr;
        if (epoint.isUnresolved()) {
            throw new SocketException("Unresolved address");
        }
        InetAddress iaddr = epoint.getAddress();
        int port = epoint.getPort();
        checkAddress(iaddr, "bind");
        SecurityManager sec = System.getSecurityManager();
        if (sec != null) {
            sec.checkListen(port);
        }
        try {
            getImpl().bind(port, iaddr);
            this.bound = true;
        } catch (SocketException e2) {
            getImpl().close();
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkAddress(InetAddress addr, String op) {
        if (addr != null && !(addr instanceof Inet4Address) && !(addr instanceof Inet6Address)) {
            throw new IllegalArgumentException(op + ": invalid address type");
        }
    }

    public void connect(InetAddress address, int port) {
        try {
            connectInternal(address, port);
        } catch (SocketException se) {
            this.pendingConnectException = se;
        }
    }

    public void connect(SocketAddress addr) throws SocketException {
        if (addr == null) {
            throw new IllegalArgumentException("Address can't be null");
        }
        if (!(addr instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        }
        InetSocketAddress epoint = (InetSocketAddress) addr;
        if (epoint.isUnresolved()) {
            throw new SocketException("Unresolved address");
        }
        connectInternal(epoint.getAddress(), epoint.getPort());
    }

    public void disconnect() {
        synchronized (this) {
            if (isClosed()) {
                return;
            }
            if (this.connectState == 1) {
                this.impl.disconnect();
            }
            this.connectedAddress = null;
            this.connectedPort = -1;
            this.connectState = 0;
            this.explicitFilter = false;
        }
    }

    public boolean isBound() {
        return this.bound;
    }

    public boolean isConnected() {
        return this.connectState != 0;
    }

    public InetAddress getInetAddress() {
        return this.connectedAddress;
    }

    public int getPort() {
        return this.connectedPort;
    }

    public SocketAddress getRemoteSocketAddress() {
        if (!isConnected()) {
            return null;
        }
        return new InetSocketAddress(getInetAddress(), getPort());
    }

    public SocketAddress getLocalSocketAddress() {
        if (!isClosed() && isBound()) {
            return new InetSocketAddress(getLocalAddress(), getLocalPort());
        }
        return null;
    }

    public void send(DatagramPacket p10) throws IOException {
        synchronized (p10) {
            SocketException socketException = this.pendingConnectException;
            if (socketException != null) {
                throw new SocketException("Pending connect failure", socketException);
            }
            if (isClosed()) {
                throw new SocketException("Socket is closed");
            }
            checkAddress(p10.getAddress(), "send");
            if (this.connectState == 0) {
                SecurityManager security = System.getSecurityManager();
                if (security != null) {
                    if (p10.getAddress().isMulticastAddress()) {
                        security.checkMulticast(p10.getAddress());
                    } else {
                        security.checkConnect(p10.getAddress().getHostAddress(), p10.getPort());
                    }
                }
            } else {
                InetAddress packetAddress = p10.getAddress();
                if (packetAddress == null) {
                    p10.setAddress(this.connectedAddress);
                    p10.setPort(this.connectedPort);
                } else if (!packetAddress.equals(this.connectedAddress) || p10.getPort() != this.connectedPort) {
                    throw new IllegalArgumentException("connected address and packet address differ");
                }
            }
            if (!isBound()) {
                bind(new InetSocketAddress(0));
            }
            getImpl().send(p10);
        }
    }

    public synchronized void receive(DatagramPacket p10) throws IOException {
        InetAddress peekAddress;
        int peekPort;
        SecurityManager security;
        int peekPort2;
        String peekAd;
        synchronized (p10) {
            try {
                if (!isBound()) {
                    bind(new InetSocketAddress(0));
                }
                SocketException socketException = this.pendingConnectException;
                if (socketException != null) {
                    throw new SocketException("Pending connect failure", socketException);
                }
                if (this.connectState == 0 && (security = System.getSecurityManager()) != null) {
                    while (true) {
                        if (!this.oldImpl) {
                            DatagramPacket peekPacket = new DatagramPacket(new byte[1], 1);
                            peekPort2 = getImpl().peekData(peekPacket);
                            peekAd = peekPacket.getAddress().getHostAddress();
                        } else {
                            InetAddress adr = new InetAddress();
                            peekPort2 = getImpl().peek(adr);
                            peekAd = adr.getHostAddress();
                        }
                        try {
                            security.checkAccept(peekAd, peekPort2);
                            break;
                        } catch (SecurityException e2) {
                            getImpl().receive(new DatagramPacket(new byte[1], 1));
                        }
                    }
                }
                DatagramPacket tmp = null;
                if (this.connectState == 2 || this.explicitFilter) {
                    boolean stop = false;
                    while (!stop) {
                        if (!this.oldImpl) {
                            DatagramPacket peekPacket2 = new DatagramPacket(new byte[1], 1);
                            peekPort = getImpl().peekData(peekPacket2);
                            peekAddress = peekPacket2.getAddress();
                        } else {
                            peekAddress = new InetAddress();
                            peekPort = getImpl().peek(peekAddress);
                        }
                        if (this.connectedAddress.equals(peekAddress) && this.connectedPort == peekPort) {
                            stop = true;
                        }
                        tmp = new DatagramPacket(new byte[1024], 1024);
                        getImpl().receive(tmp);
                        if (this.explicitFilter && checkFiltering(tmp)) {
                            stop = true;
                        }
                    }
                }
                getImpl().receive(p10);
                if (this.explicitFilter && tmp == null) {
                    checkFiltering(p10);
                }
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

    private boolean checkFiltering(DatagramPacket p10) throws SocketException {
        int length = this.bytesLeftToFilter - p10.getLength();
        this.bytesLeftToFilter = length;
        if (length > 0 && getImpl().dataAvailable() > 0) {
            return false;
        }
        this.explicitFilter = false;
        return true;
    }

    public InetAddress getLocalAddress() {
        if (isClosed()) {
            return null;
        }
        try {
            InetAddress in = (InetAddress) getImpl().getOption(15);
            if (in.isAnyLocalAddress()) {
                in = InetAddress.anyLocalAddress();
            }
            SecurityManager s2 = System.getSecurityManager();
            if (s2 != null) {
                s2.checkConnect(in.getHostAddress(), -1);
                return in;
            }
            return in;
        } catch (Exception e2) {
            return InetAddress.anyLocalAddress();
        }
    }

    public int getLocalPort() {
        if (isClosed()) {
            return -1;
        }
        try {
            return getImpl().getLocalPort();
        } catch (Exception e2) {
            return 0;
        }
    }

    public synchronized void setSoTimeout(int timeout) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    public synchronized int getSoTimeout() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (getImpl() == null) {
            return 0;
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

    public synchronized void setReuseAddress(boolean on) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (this.oldImpl) {
            getImpl().setOption(4, Integer.valueOf(on ? -1 : 0));
        } else {
            getImpl().setOption(4, Boolean.valueOf(on));
        }
    }

    public synchronized boolean getReuseAddress() throws SocketException {
        Object o10;
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        o10 = getImpl().getOption(4);
        return ((Boolean) o10).booleanValue();
    }

    public synchronized void setBroadcast(boolean on) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setOption(32, Boolean.valueOf(on));
    }

    public synchronized boolean getBroadcast() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        return ((Boolean) getImpl().getOption(32)).booleanValue();
    }

    public synchronized void setTrafficClass(int tc2) throws SocketException {
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

    public synchronized int getTrafficClass() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        return ((Integer) getImpl().getOption(3)).intValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.closeLock) {
            if (isClosed()) {
                return;
            }
            this.impl.close();
            this.closed = true;
        }
    }

    public boolean isClosed() {
        boolean z10;
        synchronized (this.closeLock) {
            z10 = this.closed;
        }
        return z10;
    }

    public DatagramChannel getChannel() {
        return null;
    }

    public static synchronized void setDatagramSocketImplFactory(DatagramSocketImplFactory fac) throws IOException {
        synchronized (DatagramSocket.class) {
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

    public <T> DatagramSocket setOption(SocketOption<T> name, T value) throws IOException {
        getImpl().setOption((SocketOption<SocketOption<T>>) name, (SocketOption<T>) value);
        return this;
    }

    public <T> T getOption(SocketOption<T> socketOption) throws IOException {
        return (T) getImpl().getOption(socketOption);
    }

    public Set<SocketOption<?>> supportedOptions() {
        synchronized (DatagramSocket.class) {
            if (optionsSet) {
                return options;
            }
            try {
                DatagramSocketImpl impl = getImpl();
                options = Collections.unmodifiableSet(impl.supportedOptions());
            } catch (IOException e2) {
                options = Collections.emptySet();
            }
            optionsSet = true;
            return options;
        }
    }

    public FileDescriptor getFileDescriptor$() {
        return this.impl.f50367fd;
    }
}
