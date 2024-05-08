package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.DatagramSocketImpl;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketOption;
import java.net.SocketTimeoutException;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.IllegalBlockingModeException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DatagramSocketAdaptor extends DatagramSocket {
    private static final DatagramSocketImpl dummyDatagramSocket = new DatagramSocketImpl() { // from class: sun.nio.ch.DatagramSocketAdaptor.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public void create() throws SocketException {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public void bind(int lport, InetAddress laddr) throws SocketException {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public void send(DatagramPacket p10) throws IOException {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public int peek(InetAddress i10) throws IOException {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public int peekData(DatagramPacket p10) throws IOException {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public void receive(DatagramPacket p10) throws IOException {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        @Deprecated
        public void setTTL(byte ttl) throws IOException {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        @Deprecated
        public byte getTTL() throws IOException {
            return (byte) 0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public void setTimeToLive(int ttl) throws IOException {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public int getTimeToLive() throws IOException {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public void join(InetAddress inetaddr) throws IOException {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public void leave(InetAddress inetaddr) throws IOException {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public void joinGroup(SocketAddress mcastaddr, NetworkInterface netIf) throws IOException {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public void leaveGroup(SocketAddress mcastaddr, NetworkInterface netIf) throws IOException {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.net.DatagramSocketImpl
        public void close() {
        }

        @Override // java.net.SocketOptions
        public Object getOption(int optID) throws SocketException {
            return null;
        }

        @Override // java.net.SocketOptions
        public void setOption(int optID, Object value) throws SocketException {
        }
    };

    /* renamed from: dc, reason: collision with root package name */
    private final DatagramChannelImpl f53719dc;
    private volatile int timeout;

    private DatagramSocketAdaptor(DatagramChannelImpl dc2) throws IOException {
        super(dummyDatagramSocket);
        this.timeout = 0;
        this.f53719dc = dc2;
    }

    public static DatagramSocket create(DatagramChannelImpl dc2) {
        try {
            return new DatagramSocketAdaptor(dc2);
        } catch (IOException x10) {
            throw new Error(x10);
        }
    }

    private void connectInternal(SocketAddress remote) throws SocketException {
        InetSocketAddress isa = Net.asInetSocketAddress(remote);
        int port = isa.getPort();
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("connect: " + port);
        }
        if (remote == null) {
            throw new IllegalArgumentException("connect: null address");
        }
        if (isClosed()) {
            return;
        }
        try {
            this.f53719dc.connect(remote);
        } catch (Exception x10) {
            Net.translateToSocketException(x10);
        }
    }

    @Override // java.net.DatagramSocket
    public void bind(SocketAddress local) throws SocketException {
        if (local == null) {
            try {
                local = new InetSocketAddress(0);
            } catch (Exception x10) {
                Net.translateToSocketException(x10);
                return;
            }
        }
        this.f53719dc.bind(local);
    }

    @Override // java.net.DatagramSocket
    public void connect(InetAddress address, int port) {
        try {
            connectInternal(new InetSocketAddress(address, port));
        } catch (SocketException e2) {
        }
    }

    @Override // java.net.DatagramSocket
    public void connect(SocketAddress remote) throws SocketException {
        if (remote == null) {
            throw new IllegalArgumentException("Address can't be null");
        }
        connectInternal(remote);
    }

    @Override // java.net.DatagramSocket
    public void disconnect() {
        try {
            this.f53719dc.disconnect();
        } catch (IOException x10) {
            throw new Error(x10);
        }
    }

    @Override // java.net.DatagramSocket
    public boolean isBound() {
        return this.f53719dc.localAddress() != null;
    }

    @Override // java.net.DatagramSocket
    public boolean isConnected() {
        return this.f53719dc.remoteAddress() != null;
    }

    @Override // java.net.DatagramSocket
    public InetAddress getInetAddress() {
        if (isConnected()) {
            return Net.asInetSocketAddress(this.f53719dc.remoteAddress()).getAddress();
        }
        return null;
    }

    @Override // java.net.DatagramSocket
    public int getPort() {
        if (isConnected()) {
            return Net.asInetSocketAddress(this.f53719dc.remoteAddress()).getPort();
        }
        return -1;
    }

    @Override // java.net.DatagramSocket
    public void send(DatagramPacket p10) throws IOException {
        synchronized (this.f53719dc.blockingLock()) {
            if (!this.f53719dc.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            try {
                synchronized (p10) {
                    ByteBuffer bb2 = ByteBuffer.wrap(p10.getData(), p10.getOffset(), p10.getLength());
                    if (this.f53719dc.isConnected()) {
                        if (p10.getAddress() == null) {
                            InetSocketAddress isa = (InetSocketAddress) this.f53719dc.remoteAddress();
                            p10.setPort(isa.getPort());
                            p10.setAddress(isa.getAddress());
                            this.f53719dc.write(bb2);
                        } else {
                            this.f53719dc.send(bb2, p10.getSocketAddress());
                        }
                    } else {
                        this.f53719dc.send(bb2, p10.getSocketAddress());
                    }
                }
            } catch (IOException x10) {
                Net.translateException(x10);
            }
        }
    }

    private SocketAddress receive(ByteBuffer bb2) throws IOException {
        if (this.timeout == 0) {
            return this.f53719dc.receive(bb2);
        }
        this.f53719dc.configureBlocking(false);
        try {
            SocketAddress sender = this.f53719dc.receive(bb2);
            if (sender != null) {
                return sender;
            }
            long to = this.timeout;
            while (this.f53719dc.isOpen()) {
                long st = System.currentTimeMillis();
                int result = this.f53719dc.poll(Net.POLLIN, to);
                if (result > 0 && (Net.POLLIN & result) != 0) {
                    SocketAddress sender2 = this.f53719dc.receive(bb2);
                    if (sender2 != null) {
                        if (this.f53719dc.isOpen()) {
                            this.f53719dc.configureBlocking(true);
                        }
                        return sender2;
                    }
                }
                to -= System.currentTimeMillis() - st;
                if (to <= 0) {
                    throw new SocketTimeoutException();
                }
            }
            throw new ClosedChannelException();
        } finally {
            if (this.f53719dc.isOpen()) {
                this.f53719dc.configureBlocking(true);
            }
        }
    }

    @Override // java.net.DatagramSocket
    public void receive(DatagramPacket p10) throws IOException {
        synchronized (this.f53719dc.blockingLock()) {
            if (!this.f53719dc.isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            try {
                synchronized (p10) {
                    ByteBuffer bb2 = ByteBuffer.wrap(p10.getData(), p10.getOffset(), p10.getLength());
                    SocketAddress sender = receive(bb2);
                    p10.setSocketAddress(sender);
                    p10.setLength(bb2.position() - p10.getOffset());
                }
            } catch (IOException x10) {
                Net.translateException(x10);
            }
        }
    }

    @Override // java.net.DatagramSocket
    public InetAddress getLocalAddress() {
        if (isClosed()) {
            return null;
        }
        SocketAddress local = this.f53719dc.localAddress();
        if (local == null) {
            local = new InetSocketAddress(0);
        }
        InetAddress result = ((InetSocketAddress) local).getAddress();
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            try {
                sm.checkConnect(result.getHostAddress(), -1);
            } catch (SecurityException e2) {
                return new InetSocketAddress(0).getAddress();
            }
        }
        return result;
    }

    @Override // java.net.DatagramSocket
    public int getLocalPort() {
        if (isClosed()) {
            return -1;
        }
        try {
            SocketAddress local = this.f53719dc.getLocalAddress();
            if (local != null) {
                return ((InetSocketAddress) local).getPort();
            }
            return 0;
        } catch (Exception e2) {
            return 0;
        }
    }

    @Override // java.net.DatagramSocket
    public void setSoTimeout(int timeout) throws SocketException {
        this.timeout = timeout;
    }

    @Override // java.net.DatagramSocket
    public int getSoTimeout() throws SocketException {
        return this.timeout;
    }

    private void setBooleanOption(SocketOption<Boolean> name, boolean value) throws SocketException {
        try {
            this.f53719dc.setOption((SocketOption<SocketOption<Boolean>>) name, (SocketOption<Boolean>) Boolean.valueOf(value));
        } catch (IOException x10) {
            Net.translateToSocketException(x10);
        }
    }

    private void setIntOption(SocketOption<Integer> name, int value) throws SocketException {
        try {
            this.f53719dc.setOption((SocketOption<SocketOption<Integer>>) name, (SocketOption<Integer>) Integer.valueOf(value));
        } catch (IOException x10) {
            Net.translateToSocketException(x10);
        }
    }

    private boolean getBooleanOption(SocketOption<Boolean> name) throws SocketException {
        try {
            return ((Boolean) this.f53719dc.getOption(name)).booleanValue();
        } catch (IOException x10) {
            Net.translateToSocketException(x10);
            return false;
        }
    }

    private int getIntOption(SocketOption<Integer> name) throws SocketException {
        try {
            return ((Integer) this.f53719dc.getOption(name)).intValue();
        } catch (IOException x10) {
            Net.translateToSocketException(x10);
            return -1;
        }
    }

    @Override // java.net.DatagramSocket
    public void setSendBufferSize(int size) throws SocketException {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid send size");
        }
        setIntOption(StandardSocketOptions.SO_SNDBUF, size);
    }

    @Override // java.net.DatagramSocket
    public int getSendBufferSize() throws SocketException {
        return getIntOption(StandardSocketOptions.SO_SNDBUF);
    }

    @Override // java.net.DatagramSocket
    public void setReceiveBufferSize(int size) throws SocketException {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid receive size");
        }
        setIntOption(StandardSocketOptions.SO_RCVBUF, size);
    }

    @Override // java.net.DatagramSocket
    public int getReceiveBufferSize() throws SocketException {
        return getIntOption(StandardSocketOptions.SO_RCVBUF);
    }

    @Override // java.net.DatagramSocket
    public void setReuseAddress(boolean on) throws SocketException {
        setBooleanOption(StandardSocketOptions.SO_REUSEADDR, on);
    }

    @Override // java.net.DatagramSocket
    public boolean getReuseAddress() throws SocketException {
        return getBooleanOption(StandardSocketOptions.SO_REUSEADDR);
    }

    @Override // java.net.DatagramSocket
    public void setBroadcast(boolean on) throws SocketException {
        setBooleanOption(StandardSocketOptions.SO_BROADCAST, on);
    }

    @Override // java.net.DatagramSocket
    public boolean getBroadcast() throws SocketException {
        return getBooleanOption(StandardSocketOptions.SO_BROADCAST);
    }

    @Override // java.net.DatagramSocket
    public void setTrafficClass(int tc2) throws SocketException {
        setIntOption(StandardSocketOptions.IP_TOS, tc2);
    }

    @Override // java.net.DatagramSocket
    public int getTrafficClass() throws SocketException {
        return getIntOption(StandardSocketOptions.IP_TOS);
    }

    @Override // java.net.DatagramSocket, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f53719dc.close();
        } catch (IOException x10) {
            throw new Error(x10);
        }
    }

    @Override // java.net.DatagramSocket
    public boolean isClosed() {
        return !this.f53719dc.isOpen();
    }

    @Override // java.net.DatagramSocket
    public DatagramChannel getChannel() {
        return this.f53719dc;
    }

    @Override // java.net.DatagramSocket
    public final FileDescriptor getFileDescriptor$() {
        return this.f53719dc.f53718fd;
    }
}
