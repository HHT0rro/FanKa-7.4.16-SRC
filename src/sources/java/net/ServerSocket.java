package java.net;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
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
public class ServerSocket implements Closeable {
    private static Set<SocketOption<?>> options;
    private boolean bound;
    private Object closeLock;
    private boolean closed;
    private boolean created;
    private SocketImpl impl;
    private boolean oldImpl;
    private static SocketImplFactory factory = null;
    private static boolean optionsSet = false;

    ServerSocket(SocketImpl impl) {
        this.created = false;
        this.bound = false;
        this.closed = false;
        this.closeLock = new Object();
        this.oldImpl = false;
        checkPermission();
        this.impl = impl;
        impl.setServerSocket(this);
    }

    private static Void checkPermission() {
        return null;
    }

    public ServerSocket() throws IOException {
        this.created = false;
        this.bound = false;
        this.closed = false;
        this.closeLock = new Object();
        this.oldImpl = false;
        setImpl();
    }

    public ServerSocket(int port) throws IOException {
        this(port, 50, null);
    }

    public ServerSocket(int port, int backlog) throws IOException {
        this(port, backlog, null);
    }

    public ServerSocket(int port, int backlog, InetAddress bindAddr) throws IOException {
        this.created = false;
        this.bound = false;
        this.closed = false;
        this.closeLock = new Object();
        this.oldImpl = false;
        setImpl();
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("Port value out of range: " + port);
        }
        try {
            bind(new InetSocketAddress(bindAddr, port), backlog < 1 ? 50 : backlog);
        } catch (IOException e2) {
            close();
            throw e2;
        } catch (SecurityException e10) {
            close();
            throw e10;
        }
    }

    public SocketImpl getImpl() throws SocketException {
        if (!this.created) {
            createImpl();
        }
        return this.impl;
    }

    private void checkOldImpl() {
        if (this.impl == null) {
            return;
        }
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: java.net.ServerSocket.1
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws NoSuchMethodException {
                    ServerSocket.this.impl.getClass().getDeclaredMethod(SecurityConstants.SOCKET_CONNECT_ACTION, SocketAddress.class, Integer.TYPE);
                    return null;
                }
            });
        } catch (PrivilegedActionException e2) {
            this.oldImpl = true;
        }
    }

    private void setImpl() {
        SocketImplFactory socketImplFactory = factory;
        if (socketImplFactory != null) {
            this.impl = socketImplFactory.createSocketImpl();
            checkOldImpl();
        } else {
            this.impl = new SocksSocketImpl();
        }
        SocketImpl socketImpl = this.impl;
        if (socketImpl != null) {
            socketImpl.setServerSocket(this);
        }
    }

    void createImpl() throws SocketException {
        if (this.impl == null) {
            setImpl();
        }
        try {
            this.impl.create(true);
            this.created = true;
        } catch (IOException e2) {
            throw new SocketException(e2.getMessage());
        }
    }

    public void bind(SocketAddress endpoint) throws IOException {
        bind(endpoint, 50);
    }

    public void bind(SocketAddress endpoint, int backlog) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!this.oldImpl && isBound()) {
            throw new SocketException("Already bound");
        }
        if (endpoint == null) {
            endpoint = new InetSocketAddress(0);
        }
        if (!(endpoint instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        }
        InetSocketAddress epoint = (InetSocketAddress) endpoint;
        if (epoint.isUnresolved()) {
            throw new SocketException("Unresolved address");
        }
        if (backlog < 1) {
            backlog = 50;
        }
        try {
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkListen(epoint.getPort());
            }
            getImpl().bind(epoint.getAddress(), epoint.getPort());
            getImpl().listen(backlog);
            this.bound = true;
        } catch (IOException e2) {
            this.bound = false;
            throw e2;
        } catch (SecurityException e10) {
            this.bound = false;
            throw e10;
        }
    }

    public InetAddress getInetAddress() {
        if (!isBound()) {
            return null;
        }
        try {
            InetAddress in = getImpl().getInetAddress();
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkConnect(in.getHostAddress(), -1);
            }
            return in;
        } catch (SecurityException e2) {
            return InetAddress.getLoopbackAddress();
        } catch (SocketException e10) {
            return null;
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

    public SocketAddress getLocalSocketAddress() {
        if (!isBound()) {
            return null;
        }
        return new InetSocketAddress(getInetAddress(), getLocalPort());
    }

    public Socket accept() throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!isBound()) {
            throw new SocketException("Socket is not bound yet");
        }
        Socket s2 = new Socket((SocketImpl) null);
        implAccept(s2);
        return s2;
    }

    protected final void implAccept(Socket s2) throws IOException {
        SocketImpl si = null;
        try {
            if (s2.impl == null) {
                s2.setImpl();
            } else {
                s2.impl.reset();
            }
            si = s2.impl;
            s2.impl = null;
            si.address = new InetAddress();
            si.f50370fd = new FileDescriptor();
            getImpl().accept(si);
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkAccept(si.getInetAddress().getHostAddress(), si.getPort());
            }
            s2.impl = si;
            s2.postAccept();
        } catch (IOException e2) {
            if (si != null) {
                si.reset();
            }
            s2.impl = si;
            throw e2;
        } catch (SecurityException e10) {
            if (si != null) {
                si.reset();
            }
            s2.impl = si;
            throw e10;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.closeLock) {
            if (isClosed()) {
                return;
            }
            if (this.created) {
                this.impl.close();
            }
            this.closed = true;
        }
    }

    public ServerSocketChannel getChannel() {
        return null;
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

    public synchronized void setSoTimeout(int timeout) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    public synchronized int getSoTimeout() throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        Object o10 = getImpl().getOption(SocketOptions.SO_TIMEOUT);
        if (!(o10 instanceof Integer)) {
            return 0;
        }
        return ((Integer) o10).intValue();
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

    public String toString() {
        InetAddress in;
        if (!isBound()) {
            return "ServerSocket[unbound]";
        }
        if (System.getSecurityManager() != null) {
            in = InetAddress.getLoopbackAddress();
        } else {
            in = this.impl.getInetAddress();
        }
        return "ServerSocket[addr=" + ((Object) in) + ",localport=" + this.impl.getLocalPort() + "]";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBound() {
        this.bound = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCreated() {
        this.created = true;
    }

    public static synchronized void setSocketFactory(SocketImplFactory fac) throws IOException {
        synchronized (ServerSocket.class) {
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

    public synchronized void setReceiveBufferSize(int size) throws SocketException {
        try {
            if (size <= 0) {
                throw new IllegalArgumentException("negative receive size");
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

    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
    }

    public <T> ServerSocket setOption(SocketOption<T> name, T value) throws IOException {
        getImpl().setOption((SocketOption<SocketOption<T>>) name, (SocketOption<T>) value);
        return this;
    }

    public <T> T getOption(SocketOption<T> socketOption) throws IOException {
        return (T) getImpl().getOption(socketOption);
    }

    public Set<SocketOption<?>> supportedOptions() {
        synchronized (ServerSocket.class) {
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
