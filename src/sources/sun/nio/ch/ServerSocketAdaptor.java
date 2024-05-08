package sun.nio.ch;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketOption;
import java.net.SocketTimeoutException;
import java.net.StandardSocketOptions;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ServerSocketAdaptor extends ServerSocket {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ServerSocketChannelImpl ssc;
    private volatile int timeout = 0;

    public static ServerSocket create(ServerSocketChannelImpl ssc) {
        try {
            return new ServerSocketAdaptor(ssc);
        } catch (IOException x10) {
            throw new Error(x10);
        }
    }

    private ServerSocketAdaptor(ServerSocketChannelImpl ssc) throws IOException {
        this.ssc = ssc;
    }

    @Override // java.net.ServerSocket
    public void bind(SocketAddress local) throws IOException {
        bind(local, 50);
    }

    @Override // java.net.ServerSocket
    public void bind(SocketAddress local, int backlog) throws IOException {
        if (local == null) {
            local = new InetSocketAddress(0);
        }
        try {
            this.ssc.bind(local, backlog);
        } catch (Exception x10) {
            Net.translateException(x10);
        }
    }

    @Override // java.net.ServerSocket
    public InetAddress getInetAddress() {
        if (!this.ssc.isBound()) {
            return null;
        }
        return Net.getRevealedLocalAddress(this.ssc.localAddress()).getAddress();
    }

    @Override // java.net.ServerSocket
    public int getLocalPort() {
        if (!this.ssc.isBound()) {
            return -1;
        }
        return Net.asInetSocketAddress(this.ssc.localAddress()).getPort();
    }

    @Override // java.net.ServerSocket
    public Socket accept() throws IOException {
        SocketChannel sc2;
        synchronized (this.ssc.blockingLock()) {
            if (!this.ssc.isBound()) {
                throw new IllegalBlockingModeException();
            }
            try {
                if (this.timeout == 0) {
                    SocketChannel sc3 = this.ssc.accept();
                    if (sc3 == null && !this.ssc.isBlocking()) {
                        throw new IllegalBlockingModeException();
                    }
                    return sc3.socket();
                }
                this.ssc.configureBlocking(false);
                try {
                    SocketChannel sc4 = this.ssc.accept();
                    if (sc4 != null) {
                        return sc4.socket();
                    }
                    long to = this.timeout;
                    while (this.ssc.isOpen()) {
                        long st = System.currentTimeMillis();
                        int result = this.ssc.poll(Net.POLLIN, to);
                        if (result > 0 && (sc2 = this.ssc.accept()) != null) {
                            Socket socket = sc2.socket();
                            if (this.ssc.isOpen()) {
                                this.ssc.configureBlocking(true);
                            }
                            return socket;
                        }
                        to -= System.currentTimeMillis() - st;
                        if (to <= 0) {
                            throw new SocketTimeoutException();
                        }
                    }
                    throw new ClosedChannelException();
                } finally {
                    if (this.ssc.isOpen()) {
                        this.ssc.configureBlocking(true);
                    }
                }
            } catch (Exception x10) {
                Net.translateException(x10);
                return null;
            }
        }
    }

    @Override // java.net.ServerSocket, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ssc.close();
    }

    @Override // java.net.ServerSocket
    public ServerSocketChannel getChannel() {
        return this.ssc;
    }

    @Override // java.net.ServerSocket
    public boolean isBound() {
        return this.ssc.isBound();
    }

    @Override // java.net.ServerSocket
    public boolean isClosed() {
        return !this.ssc.isOpen();
    }

    @Override // java.net.ServerSocket
    public void setSoTimeout(int timeout) throws SocketException {
        this.timeout = timeout;
    }

    @Override // java.net.ServerSocket
    public int getSoTimeout() throws SocketException {
        return this.timeout;
    }

    @Override // java.net.ServerSocket
    public void setReuseAddress(boolean on) throws SocketException {
        try {
            this.ssc.setOption((SocketOption<SocketOption<Boolean>>) StandardSocketOptions.SO_REUSEADDR, (SocketOption<Boolean>) Boolean.valueOf(on));
        } catch (IOException x10) {
            Net.translateToSocketException(x10);
        }
    }

    @Override // java.net.ServerSocket
    public boolean getReuseAddress() throws SocketException {
        try {
            return ((Boolean) this.ssc.getOption(StandardSocketOptions.SO_REUSEADDR)).booleanValue();
        } catch (IOException x10) {
            Net.translateToSocketException(x10);
            return false;
        }
    }

    @Override // java.net.ServerSocket
    public String toString() {
        if (!isBound()) {
            return "ServerSocket[unbound]";
        }
        return "ServerSocket[addr=" + ((Object) getInetAddress()) + ",localport=" + getLocalPort() + "]";
    }

    @Override // java.net.ServerSocket
    public void setReceiveBufferSize(int size) throws SocketException {
        if (size <= 0) {
            throw new IllegalArgumentException("size cannot be 0 or negative");
        }
        try {
            this.ssc.setOption((SocketOption<SocketOption<Integer>>) StandardSocketOptions.SO_RCVBUF, (SocketOption<Integer>) Integer.valueOf(size));
        } catch (IOException x10) {
            Net.translateToSocketException(x10);
        }
    }

    @Override // java.net.ServerSocket
    public int getReceiveBufferSize() throws SocketException {
        try {
            return ((Integer) this.ssc.getOption(StandardSocketOptions.SO_RCVBUF)).intValue();
        } catch (IOException x10) {
            Net.translateToSocketException(x10);
            return -1;
        }
    }
}
