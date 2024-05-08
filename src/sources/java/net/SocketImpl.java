package java.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SocketImpl implements SocketOptions {
    protected InetAddress address;

    /* renamed from: fd, reason: collision with root package name */
    protected FileDescriptor f50370fd;
    protected int localport;
    protected int port;
    private static final Set<SocketOption<?>> socketOptions = Set.of(StandardSocketOptions.SO_KEEPALIVE, StandardSocketOptions.SO_SNDBUF, StandardSocketOptions.SO_RCVBUF, StandardSocketOptions.SO_REUSEADDR, StandardSocketOptions.SO_LINGER, StandardSocketOptions.IP_TOS, StandardSocketOptions.TCP_NODELAY);
    private static final Set<SocketOption<?>> serverSocketOptions = Set.of(StandardSocketOptions.SO_RCVBUF, StandardSocketOptions.SO_REUSEADDR, StandardSocketOptions.IP_TOS);
    Socket socket = null;
    ServerSocket serverSocket = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void accept(SocketImpl socketImpl) throws IOException;

    protected abstract int available() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void bind(InetAddress inetAddress, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void close() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void connect(String str, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void connect(InetAddress inetAddress, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void connect(SocketAddress socketAddress, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void create(boolean z10) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract InputStream getInputStream() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract OutputStream getOutputStream() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void listen(int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void sendUrgentData(int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void shutdownInput() throws IOException {
        throw new IOException("Method not implemented!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void shutdownOutput() throws IOException {
        throw new IOException("Method not implemented!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FileDescriptor getFileDescriptor() {
        return this.f50370fd;
    }

    public FileDescriptor getFD$() {
        return this.f50370fd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InetAddress getInetAddress() {
        return this.address;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPort() {
        return this.port;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean supportsUrgentData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLocalPort() {
        return this.localport;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSocket(Socket soc) {
        this.socket = soc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Socket getSocket() {
        return this.socket;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setServerSocket(ServerSocket soc) {
        this.serverSocket = soc;
    }

    ServerSocket getServerSocket() {
        return this.serverSocket;
    }

    public String toString() {
        return "Socket[addr=" + ((Object) getInetAddress()) + ",port=" + getPort() + ",localport=" + getLocalPort() + "]";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() throws IOException {
        this.address = null;
        this.port = 0;
        this.localport = 0;
    }

    protected void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> void setOption(SocketOption<T> name, T value) throws IOException {
        if (name == StandardSocketOptions.SO_KEEPALIVE && getSocket() != null) {
            setOption(8, value);
            return;
        }
        if (name == StandardSocketOptions.SO_SNDBUF && getSocket() != null) {
            setOption(4097, value);
            return;
        }
        if (name == StandardSocketOptions.SO_RCVBUF) {
            setOption(4098, value);
            return;
        }
        if (name == StandardSocketOptions.SO_REUSEADDR) {
            setOption(4, value);
            return;
        }
        if (name == StandardSocketOptions.SO_REUSEPORT && supportedOptions().contains(name)) {
            setOption(14, value);
            return;
        }
        if (name == StandardSocketOptions.SO_LINGER && getSocket() != null) {
            setOption(128, value);
            return;
        }
        if (name == StandardSocketOptions.IP_TOS) {
            setOption(3, value);
        } else {
            if (name == StandardSocketOptions.TCP_NODELAY && getSocket() != null) {
                setOption(1, value);
                return;
            }
            throw new UnsupportedOperationException("unsupported option");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T getOption(SocketOption<T> socketOption) throws IOException {
        if (socketOption == StandardSocketOptions.SO_KEEPALIVE && getSocket() != null) {
            return (T) getOption(8);
        }
        if (socketOption == StandardSocketOptions.SO_SNDBUF && getSocket() != null) {
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
        if (socketOption == StandardSocketOptions.SO_LINGER && getSocket() != null) {
            return (T) getOption(128);
        }
        if (socketOption == StandardSocketOptions.IP_TOS) {
            return (T) getOption(3);
        }
        if (socketOption == StandardSocketOptions.TCP_NODELAY && getSocket() != null) {
            return (T) getOption(1);
        }
        throw new UnsupportedOperationException("unsupported option");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Set<SocketOption<?>> supportedOptions() {
        if (getSocket() != null) {
            return socketOptions;
        }
        return serverSocketOptions;
    }
}
