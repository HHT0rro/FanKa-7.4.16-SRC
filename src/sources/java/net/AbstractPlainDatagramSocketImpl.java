package java.net;

import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.security.AccessController;
import java.util.Enumeration;
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import sun.net.ResourceManager;
import sun.security.action.GetPropertyAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractPlainDatagramSocketImpl extends DatagramSocketImpl {
    private static final boolean connectDisabled;
    private static final String os;
    int timeout = 0;
    boolean connected = false;
    private int trafficClass = 0;
    protected InetAddress connectedAddress = null;
    private int connectedPort = -1;
    private final CloseGuard guard = CloseGuard.get();

    protected abstract void bind0(int i10, InetAddress inetAddress) throws SocketException;

    protected abstract void connect0(InetAddress inetAddress, int i10) throws SocketException;

    protected abstract void datagramSocketClose();

    protected abstract void datagramSocketCreate() throws SocketException;

    protected abstract void disconnect0(int i10);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    @Deprecated
    public abstract byte getTTL() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public abstract int getTimeToLive() throws IOException;

    protected abstract void join(InetAddress inetAddress, NetworkInterface networkInterface) throws IOException;

    protected abstract void leave(InetAddress inetAddress, NetworkInterface networkInterface) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public abstract int peek(InetAddress inetAddress) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public abstract int peekData(DatagramPacket datagramPacket) throws IOException;

    protected abstract void receive0(DatagramPacket datagramPacket) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public abstract void send(DatagramPacket datagramPacket) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    @Deprecated
    public abstract void setTTL(byte b4) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public abstract void setTimeToLive(int i10) throws IOException;

    protected abstract Object socketGetOption(int i10) throws SocketException;

    protected abstract void socketSetOption(int i10, Object obj) throws SocketException;

    static {
        String str = (String) AccessController.doPrivileged(new GetPropertyAction("os.name"));
        os = str;
        connectDisabled = str.contains("OS X");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public synchronized void create() throws SocketException {
        ResourceManager.beforeUdpCreate();
        this.f50367fd = new FileDescriptor();
        try {
            datagramSocketCreate();
            if (this.f50367fd != null && this.f50367fd.valid()) {
                this.guard.open("close");
                IoUtils.setFdOwner(this.f50367fd, this);
            }
        } catch (SocketException ioe) {
            ResourceManager.afterUdpClose();
            this.f50367fd = null;
            throw ioe;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public synchronized void bind(int lport, InetAddress laddr) throws SocketException {
        bind0(lport, laddr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public void connect(InetAddress address, int port) throws SocketException {
        BlockGuard.getThreadPolicy().onNetwork();
        connect0(address, port);
        this.connectedAddress = address;
        this.connectedPort = port;
        this.connected = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public void disconnect() {
        disconnect0(this.connectedAddress.holder().getFamily());
        this.connected = false;
        this.connectedAddress = null;
        this.connectedPort = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public synchronized void receive(DatagramPacket p10) throws IOException {
        receive0(p10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public void join(InetAddress inetaddr) throws IOException {
        join(inetaddr, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public void leave(InetAddress inetaddr) throws IOException {
        leave(inetaddr, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public void joinGroup(SocketAddress mcastaddr, NetworkInterface netIf) throws IOException {
        if (mcastaddr == null || !(mcastaddr instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        }
        join(((InetSocketAddress) mcastaddr).getAddress(), netIf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public void leaveGroup(SocketAddress mcastaddr, NetworkInterface netIf) throws IOException {
        if (mcastaddr == null || !(mcastaddr instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        }
        leave(((InetSocketAddress) mcastaddr).getAddress(), netIf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.DatagramSocketImpl
    public void close() {
        this.guard.close();
        if (this.f50367fd != null) {
            datagramSocketClose();
            ResourceManager.afterUdpClose();
            this.f50367fd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isClosed() {
        return this.f50367fd == null;
    }

    protected void finalize() {
        CloseGuard closeGuard = this.guard;
        if (closeGuard != null) {
            closeGuard.warnIfOpen();
        }
        close();
    }

    @Override // java.net.SocketOptions
    public void setOption(int optID, Object o10) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket Closed");
        }
        switch (optID) {
            case 3:
                if (o10 == null || !(o10 instanceof Integer)) {
                    throw new SocketException("bad argument for IP_TOS");
                }
                this.trafficClass = ((Integer) o10).intValue();
                break;
                break;
            case 4:
                if (o10 == null || !(o10 instanceof Boolean)) {
                    throw new SocketException("bad argument for SO_REUSEADDR");
                }
                break;
            case 15:
                throw new SocketException("Cannot re-bind Socket");
            case 16:
                if (o10 == null || !(o10 instanceof InetAddress)) {
                    throw new SocketException("bad argument for IP_MULTICAST_IF");
                }
                break;
            case 18:
                if (o10 == null || !(o10 instanceof Boolean)) {
                    throw new SocketException("bad argument for IP_MULTICAST_LOOP");
                }
                break;
            case 31:
                if (o10 == null || (!(o10 instanceof Integer) && !(o10 instanceof NetworkInterface))) {
                    throw new SocketException("bad argument for IP_MULTICAST_IF2");
                }
                if (o10 instanceof NetworkInterface) {
                    o10 = new Integer(((NetworkInterface) o10).getIndex());
                    break;
                }
                break;
            case 32:
                if (o10 == null || !(o10 instanceof Boolean)) {
                    throw new SocketException("bad argument for SO_BROADCAST");
                }
                break;
            case 4097:
            case 4098:
                if (o10 == null || !(o10 instanceof Integer) || ((Integer) o10).intValue() < 0) {
                    throw new SocketException("bad argument for SO_SNDBUF or SO_RCVBUF");
                }
                break;
            case SocketOptions.SO_TIMEOUT /* 4102 */:
                if (o10 == null || !(o10 instanceof Integer)) {
                    throw new SocketException("bad argument for SO_TIMEOUT");
                }
                int tmp = ((Integer) o10).intValue();
                if (tmp < 0) {
                    throw new IllegalArgumentException("timeout < 0");
                }
                this.timeout = tmp;
                return;
            default:
                throw new SocketException("invalid option: " + optID);
        }
        socketSetOption(optID, o10);
    }

    @Override // java.net.SocketOptions
    public Object getOption(int optID) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket Closed");
        }
        switch (optID) {
            case 3:
                Object result = socketGetOption(optID);
                if (((Integer) result).intValue() == -1) {
                    return new Integer(this.trafficClass);
                }
                return result;
            case 4:
            case 15:
            case 16:
            case 18:
            case 31:
            case 32:
            case 4097:
            case 4098:
                Object result2 = socketGetOption(optID);
                if (optID == 16) {
                    return getNIFirstAddress(((Integer) result2).intValue());
                }
                return result2;
            case SocketOptions.SO_TIMEOUT /* 4102 */:
                return new Integer(this.timeout);
            default:
                throw new SocketException("invalid option: " + optID);
        }
    }

    static InetAddress getNIFirstAddress(int niIndex) throws SocketException {
        if (niIndex > 0) {
            NetworkInterface networkInterface = NetworkInterface.getByIndex(niIndex);
            Enumeration<InetAddress> addressesEnum = networkInterface.getInetAddresses();
            if (addressesEnum.hasMoreElements()) {
                return addressesEnum.nextElement();
            }
        }
        return InetAddress.anyLocalAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean nativeConnectDisabled() {
        return connectDisabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.net.DatagramSocketImpl
    public int dataAvailable() {
        try {
            return IoBridge.available(this.f50367fd);
        } catch (IOException e2) {
            return -1;
        }
    }
}
