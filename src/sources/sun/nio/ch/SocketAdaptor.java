package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketOption;
import java.net.SocketTimeoutException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.SocketChannel;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SocketAdaptor extends Socket {

    /* renamed from: sc, reason: collision with root package name */
    private final SocketChannelImpl f53729sc;
    private InputStream socketInputStream;
    private volatile int timeout;

    private SocketAdaptor(SocketChannelImpl sc2) throws SocketException {
        super(new FileDescriptorHolderSocketImpl(sc2.getFD()));
        this.timeout = 0;
        this.socketInputStream = null;
        this.f53729sc = sc2;
    }

    public static Socket create(SocketChannelImpl sc2) {
        try {
            return new SocketAdaptor(sc2);
        } catch (SocketException e2) {
            throw new InternalError("Should not reach here");
        }
    }

    @Override // java.net.Socket
    public SocketChannel getChannel() {
        return this.f53729sc;
    }

    @Override // java.net.Socket
    public void connect(SocketAddress remote) throws IOException {
        connect(remote, 0);
    }

    @Override // java.net.Socket
    public void connect(SocketAddress remote, int timeout) throws IOException {
        if (remote == null) {
            throw new IllegalArgumentException("connect: The address can't be null");
        }
        if (timeout < 0) {
            throw new IllegalArgumentException("connect: timeout can't be negative");
        }
        synchronized (this.f53729sc.blockingLock()) {
            if (!this.f53729sc.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            try {
            } catch (Exception x10) {
                Net.translateException(x10, true);
            }
            if (timeout == 0) {
                try {
                    this.f53729sc.connect(remote);
                } catch (Exception ex) {
                    Net.translateException(ex);
                }
                return;
            }
            this.f53729sc.configureBlocking(false);
            try {
                if (this.f53729sc.connect(remote)) {
                    return;
                }
                long to = timeout;
                while (this.f53729sc.isOpen()) {
                    long st = System.currentTimeMillis();
                    int result = this.f53729sc.poll(Net.POLLCONN, to);
                    if (result <= 0 || !this.f53729sc.finishConnect()) {
                        to -= System.currentTimeMillis() - st;
                        if (to <= 0) {
                            try {
                                this.f53729sc.close();
                            } catch (IOException e2) {
                            }
                            throw new SocketTimeoutException();
                        }
                    } else {
                        if (this.f53729sc.isOpen()) {
                            this.f53729sc.configureBlocking(true);
                        }
                        return;
                    }
                }
                throw new ClosedChannelException();
            } finally {
                if (this.f53729sc.isOpen()) {
                    this.f53729sc.configureBlocking(true);
                }
            }
        }
    }

    @Override // java.net.Socket
    public void bind(SocketAddress local) throws IOException {
        try {
            this.f53729sc.bind(local);
        } catch (Exception x10) {
            Net.translateException(x10);
        }
    }

    @Override // java.net.Socket
    public InetAddress getInetAddress() {
        SocketAddress remote;
        if (isConnected() && (remote = this.f53729sc.remoteAddress()) != null) {
            return ((InetSocketAddress) remote).getAddress();
        }
        return null;
    }

    @Override // java.net.Socket
    public InetAddress getLocalAddress() {
        InetSocketAddress local;
        if (this.f53729sc.isOpen() && (local = this.f53729sc.localAddress()) != null) {
            return Net.getRevealedLocalAddress(local).getAddress();
        }
        return new InetSocketAddress(0).getAddress();
    }

    @Override // java.net.Socket
    public int getPort() {
        SocketAddress remote;
        if (isConnected() && (remote = this.f53729sc.remoteAddress()) != null) {
            return ((InetSocketAddress) remote).getPort();
        }
        return 0;
    }

    @Override // java.net.Socket
    public int getLocalPort() {
        SocketAddress local = this.f53729sc.localAddress();
        if (local == null) {
            return -1;
        }
        return ((InetSocketAddress) local).getPort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class SocketInputStream extends ChannelInputStream {
        private SocketInputStream() {
            super(SocketAdaptor.this.f53729sc);
        }

        @Override // sun.nio.ch.ChannelInputStream
        protected int read(ByteBuffer bb2) throws IOException {
            synchronized (SocketAdaptor.this.f53729sc.blockingLock()) {
                if (!SocketAdaptor.this.f53729sc.isBlocking()) {
                    throw new IllegalBlockingModeException();
                }
                if (SocketAdaptor.this.timeout == 0) {
                    return SocketAdaptor.this.f53729sc.read(bb2);
                }
                SocketAdaptor.this.f53729sc.configureBlocking(false);
                try {
                    int n10 = SocketAdaptor.this.f53729sc.read(bb2);
                    if (n10 != 0) {
                        return n10;
                    }
                    long to = SocketAdaptor.this.timeout;
                    while (SocketAdaptor.this.f53729sc.isOpen()) {
                        long st = System.currentTimeMillis();
                        int result = SocketAdaptor.this.f53729sc.poll(Net.POLLIN, to);
                        if (result > 0) {
                            int n11 = SocketAdaptor.this.f53729sc.read(bb2);
                            if (n11 != 0) {
                                if (SocketAdaptor.this.f53729sc.isOpen()) {
                                    SocketAdaptor.this.f53729sc.configureBlocking(true);
                                }
                                return n11;
                            }
                        }
                        to -= System.currentTimeMillis() - st;
                        if (to <= 0) {
                            throw new SocketTimeoutException();
                        }
                    }
                    throw new ClosedChannelException();
                } finally {
                    if (SocketAdaptor.this.f53729sc.isOpen()) {
                        SocketAdaptor.this.f53729sc.configureBlocking(true);
                    }
                }
            }
        }
    }

    @Override // java.net.Socket
    public InputStream getInputStream() throws IOException {
        if (!this.f53729sc.isOpen()) {
            throw new SocketException("Socket is closed");
        }
        if (!this.f53729sc.isConnected()) {
            throw new SocketException("Socket is not connected");
        }
        if (!this.f53729sc.isInputOpen()) {
            throw new SocketException("Socket input is shutdown");
        }
        if (this.socketInputStream == null) {
            try {
                this.socketInputStream = (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction<InputStream>() { // from class: sun.nio.ch.SocketAdaptor.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.security.PrivilegedExceptionAction
                    public InputStream run() throws IOException {
                        return new SocketInputStream();
                    }
                });
            } catch (PrivilegedActionException e2) {
                throw ((IOException) e2.getException());
            }
        }
        return this.socketInputStream;
    }

    @Override // java.net.Socket
    public OutputStream getOutputStream() throws IOException {
        if (!this.f53729sc.isOpen()) {
            throw new SocketException("Socket is closed");
        }
        if (!this.f53729sc.isConnected()) {
            throw new SocketException("Socket is not connected");
        }
        if (!this.f53729sc.isOutputOpen()) {
            throw new SocketException("Socket output is shutdown");
        }
        try {
            OutputStream os = (OutputStream) AccessController.doPrivileged(new PrivilegedExceptionAction<OutputStream>() { // from class: sun.nio.ch.SocketAdaptor.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public OutputStream run() throws IOException {
                    return Channels.newOutputStream(SocketAdaptor.this.f53729sc);
                }
            });
            return os;
        } catch (PrivilegedActionException e2) {
            throw ((IOException) e2.getException());
        }
    }

    private void setBooleanOption(SocketOption<Boolean> name, boolean value) throws SocketException {
        try {
            this.f53729sc.setOption((SocketOption<SocketOption<Boolean>>) name, (SocketOption<Boolean>) Boolean.valueOf(value));
        } catch (IOException x10) {
            Net.translateToSocketException(x10);
        }
    }

    private void setIntOption(SocketOption<Integer> name, int value) throws SocketException {
        try {
            this.f53729sc.setOption((SocketOption<SocketOption<Integer>>) name, (SocketOption<Integer>) Integer.valueOf(value));
        } catch (IOException x10) {
            Net.translateToSocketException(x10);
        }
    }

    private boolean getBooleanOption(SocketOption<Boolean> name) throws SocketException {
        try {
            return ((Boolean) this.f53729sc.getOption(name)).booleanValue();
        } catch (IOException x10) {
            Net.translateToSocketException(x10);
            return false;
        }
    }

    private int getIntOption(SocketOption<Integer> name) throws SocketException {
        try {
            return ((Integer) this.f53729sc.getOption(name)).intValue();
        } catch (IOException x10) {
            Net.translateToSocketException(x10);
            return -1;
        }
    }

    @Override // java.net.Socket
    public void setTcpNoDelay(boolean on) throws SocketException {
        setBooleanOption(StandardSocketOptions.TCP_NODELAY, on);
    }

    @Override // java.net.Socket
    public boolean getTcpNoDelay() throws SocketException {
        return getBooleanOption(StandardSocketOptions.TCP_NODELAY);
    }

    @Override // java.net.Socket
    public void setSoLinger(boolean on, int linger) throws SocketException {
        if (!on) {
            linger = -1;
        }
        setIntOption(StandardSocketOptions.SO_LINGER, linger);
    }

    @Override // java.net.Socket
    public int getSoLinger() throws SocketException {
        return getIntOption(StandardSocketOptions.SO_LINGER);
    }

    @Override // java.net.Socket
    public void sendUrgentData(int data) throws IOException {
        int n10 = this.f53729sc.sendOutOfBandData((byte) data);
        if (n10 == 0) {
            throw new IOException("Socket buffer full");
        }
    }

    @Override // java.net.Socket
    public void setOOBInline(boolean on) throws SocketException {
        setBooleanOption(ExtendedSocketOption.SO_OOBINLINE, on);
    }

    @Override // java.net.Socket
    public boolean getOOBInline() throws SocketException {
        return getBooleanOption(ExtendedSocketOption.SO_OOBINLINE);
    }

    @Override // java.net.Socket
    public void setSoTimeout(int timeout) throws SocketException {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout can't be negative");
        }
        this.timeout = timeout;
    }

    @Override // java.net.Socket
    public int getSoTimeout() throws SocketException {
        return this.timeout;
    }

    @Override // java.net.Socket
    public void setSendBufferSize(int size) throws SocketException {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid send size");
        }
        setIntOption(StandardSocketOptions.SO_SNDBUF, size);
    }

    @Override // java.net.Socket
    public int getSendBufferSize() throws SocketException {
        return getIntOption(StandardSocketOptions.SO_SNDBUF);
    }

    @Override // java.net.Socket
    public void setReceiveBufferSize(int size) throws SocketException {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid receive size");
        }
        setIntOption(StandardSocketOptions.SO_RCVBUF, size);
    }

    @Override // java.net.Socket
    public int getReceiveBufferSize() throws SocketException {
        return getIntOption(StandardSocketOptions.SO_RCVBUF);
    }

    @Override // java.net.Socket
    public void setKeepAlive(boolean on) throws SocketException {
        setBooleanOption(StandardSocketOptions.SO_KEEPALIVE, on);
    }

    @Override // java.net.Socket
    public boolean getKeepAlive() throws SocketException {
        return getBooleanOption(StandardSocketOptions.SO_KEEPALIVE);
    }

    @Override // java.net.Socket
    public void setTrafficClass(int tc2) throws SocketException {
        setIntOption(StandardSocketOptions.IP_TOS, tc2);
    }

    @Override // java.net.Socket
    public int getTrafficClass() throws SocketException {
        return getIntOption(StandardSocketOptions.IP_TOS);
    }

    @Override // java.net.Socket
    public void setReuseAddress(boolean on) throws SocketException {
        setBooleanOption(StandardSocketOptions.SO_REUSEADDR, on);
    }

    @Override // java.net.Socket
    public boolean getReuseAddress() throws SocketException {
        return getBooleanOption(StandardSocketOptions.SO_REUSEADDR);
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f53729sc.close();
    }

    @Override // java.net.Socket
    public void shutdownInput() throws IOException {
        try {
            this.f53729sc.shutdownInput();
        } catch (Exception x10) {
            Net.translateException(x10);
        }
    }

    @Override // java.net.Socket
    public void shutdownOutput() throws IOException {
        try {
            this.f53729sc.shutdownOutput();
        } catch (Exception x10) {
            Net.translateException(x10);
        }
    }

    @Override // java.net.Socket
    public String toString() {
        if (this.f53729sc.isConnected()) {
            return "Socket[addr=" + ((Object) getInetAddress()) + ",port=" + getPort() + ",localport=" + getLocalPort() + "]";
        }
        return "Socket[unconnected]";
    }

    @Override // java.net.Socket
    public boolean isConnected() {
        return this.f53729sc.isConnected();
    }

    @Override // java.net.Socket
    public boolean isBound() {
        return this.f53729sc.localAddress() != null;
    }

    @Override // java.net.Socket
    public boolean isClosed() {
        return !this.f53729sc.isOpen();
    }

    @Override // java.net.Socket
    public boolean isInputShutdown() {
        return !this.f53729sc.isInputOpen();
    }

    @Override // java.net.Socket
    public boolean isOutputShutdown() {
        return !this.f53729sc.isOutputOpen();
    }

    @Override // java.net.Socket
    public FileDescriptor getFileDescriptor$() {
        return this.f53729sc.getFD();
    }
}
