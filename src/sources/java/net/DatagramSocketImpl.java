package java.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class DatagramSocketImpl implements SocketOptions {
    private static final Set<SocketOption<?>> dgSocketOptions = Set.of(StandardSocketOptions.SO_SNDBUF, StandardSocketOptions.SO_RCVBUF, StandardSocketOptions.SO_REUSEADDR, StandardSocketOptions.IP_TOS);
    private static final Set<SocketOption<?>> mcSocketOptions = Set.of(StandardSocketOptions.SO_SNDBUF, StandardSocketOptions.SO_RCVBUF, StandardSocketOptions.SO_REUSEADDR, StandardSocketOptions.IP_TOS, StandardSocketOptions.IP_MULTICAST_IF, StandardSocketOptions.IP_MULTICAST_TTL, StandardSocketOptions.IP_MULTICAST_LOOP);

    /* renamed from: fd, reason: collision with root package name */
    protected FileDescriptor f50367fd;
    protected int localPort;
    DatagramSocket socket;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bind(int i10, InetAddress inetAddress) throws SocketException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void close();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void create() throws SocketException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public abstract byte getTTL() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getTimeToLive() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void join(InetAddress inetAddress) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void joinGroup(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void leave(InetAddress inetAddress) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void leaveGroup(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int peek(InetAddress inetAddress) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int peekData(DatagramPacket datagramPacket) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void receive(DatagramPacket datagramPacket) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void send(DatagramPacket datagramPacket) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public abstract void setTTL(byte b4) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setTimeToLive(int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDatagramSocket(DatagramSocket socket) {
        this.socket = socket;
    }

    DatagramSocket getDatagramSocket() {
        return this.socket;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dataAvailable() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void connect(InetAddress address, int port) throws SocketException {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void disconnect() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLocalPort() {
        return this.localPort;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FileDescriptor getFileDescriptor() {
        return this.f50367fd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> void setOption(SocketOption<T> name, T t2) throws IOException {
        if (name == StandardSocketOptions.SO_SNDBUF) {
            setOption(4097, t2);
            return;
        }
        if (name == StandardSocketOptions.SO_RCVBUF) {
            setOption(4098, t2);
            return;
        }
        if (name == StandardSocketOptions.SO_REUSEADDR) {
            setOption(4, t2);
            return;
        }
        if (name == StandardSocketOptions.SO_REUSEPORT && supportedOptions().contains(name)) {
            setOption(14, t2);
            return;
        }
        if (name == StandardSocketOptions.IP_TOS) {
            setOption(3, t2);
            return;
        }
        if (name == StandardSocketOptions.IP_MULTICAST_IF && (getDatagramSocket() instanceof MulticastSocket)) {
            setOption(31, t2);
            return;
        }
        if (name == StandardSocketOptions.IP_MULTICAST_TTL && (getDatagramSocket() instanceof MulticastSocket)) {
            if (!(t2 instanceof Integer)) {
                throw new IllegalArgumentException("not an integer");
            }
            setTimeToLive(((Integer) t2).intValue());
        } else {
            if (name == StandardSocketOptions.IP_MULTICAST_LOOP && (getDatagramSocket() instanceof MulticastSocket)) {
                setOption(18, t2);
                return;
            }
            throw new UnsupportedOperationException("unsupported option");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T getOption(SocketOption<T> socketOption) throws IOException {
        if (socketOption == StandardSocketOptions.SO_SNDBUF) {
            return (T) getOption(4097);
        }
        if (socketOption == StandardSocketOptions.SO_RCVBUF) {
            return (T) getOption(4098);
        }
        if (socketOption == StandardSocketOptions.SO_REUSEADDR) {
            return (T) getOption(4);
        }
        if (socketOption == StandardSocketOptions.SO_REUSEPORT && supportedOptions().contains(socketOption)) {
            return (T) getOption(14);
        }
        if (socketOption == StandardSocketOptions.IP_TOS) {
            return (T) getOption(3);
        }
        if (socketOption == StandardSocketOptions.IP_MULTICAST_IF && (getDatagramSocket() instanceof MulticastSocket)) {
            return (T) getOption(31);
        }
        if (socketOption == StandardSocketOptions.IP_MULTICAST_TTL && (getDatagramSocket() instanceof MulticastSocket)) {
            return (T) Integer.valueOf(getTimeToLive());
        }
        if (socketOption == StandardSocketOptions.IP_MULTICAST_LOOP && (getDatagramSocket() instanceof MulticastSocket)) {
            return (T) getOption(18);
        }
        throw new UnsupportedOperationException("unsupported option");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Set<SocketOption<?>> supportedOptions() {
        if (getDatagramSocket() instanceof MulticastSocket) {
            return mcSocketOptions;
        }
        return dgSocketOptions;
    }
}
