package java.net;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MulticastSocket extends DatagramSocket {
    private static Set<SocketOption<?>> options;
    private static boolean optionsSet = false;
    private InetAddress infAddress;
    private Object infLock;
    private boolean interfaceSet;
    private Object ttlLock;

    public MulticastSocket() throws IOException {
        this(new InetSocketAddress(0));
    }

    public MulticastSocket(int port) throws IOException {
        this(new InetSocketAddress(port));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MulticastSocket(SocketAddress bindaddr) throws IOException {
        super((SocketAddress) null);
        this.ttlLock = new Object();
        this.infLock = new Object();
        this.infAddress = null;
        setReuseAddress(true);
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

    @Deprecated
    public void setTTL(byte ttl) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setTTL(ttl);
    }

    public void setTimeToLive(int ttl) throws IOException {
        if (ttl < 0 || ttl > 255) {
            throw new IllegalArgumentException("ttl out of range");
        }
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        getImpl().setTimeToLive(ttl);
    }

    @Deprecated
    public byte getTTL() throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        return getImpl().getTTL();
    }

    public int getTimeToLive() throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        return getImpl().getTimeToLive();
    }

    public void joinGroup(InetAddress mcastaddr) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        checkAddress(mcastaddr, "joinGroup");
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkMulticast(mcastaddr);
        }
        if (!mcastaddr.isMulticastAddress()) {
            throw new SocketException("Not a multicast address");
        }
        NetworkInterface defaultInterface = NetworkInterface.getDefault();
        if (!this.interfaceSet && defaultInterface != null) {
            setNetworkInterface(defaultInterface);
        }
        getImpl().join(mcastaddr);
    }

    public void leaveGroup(InetAddress mcastaddr) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        checkAddress(mcastaddr, "leaveGroup");
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkMulticast(mcastaddr);
        }
        if (!mcastaddr.isMulticastAddress()) {
            throw new SocketException("Not a multicast address");
        }
        getImpl().leave(mcastaddr);
    }

    public void joinGroup(SocketAddress mcastaddr, NetworkInterface netIf) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (mcastaddr == null || !(mcastaddr instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        }
        if (this.oldImpl) {
            throw new UnsupportedOperationException();
        }
        checkAddress(((InetSocketAddress) mcastaddr).getAddress(), "joinGroup");
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkMulticast(((InetSocketAddress) mcastaddr).getAddress());
        }
        if (!((InetSocketAddress) mcastaddr).getAddress().isMulticastAddress()) {
            throw new SocketException("Not a multicast address");
        }
        getImpl().joinGroup(mcastaddr, netIf);
    }

    public void leaveGroup(SocketAddress mcastaddr, NetworkInterface netIf) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (mcastaddr == null || !(mcastaddr instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        }
        if (this.oldImpl) {
            throw new UnsupportedOperationException();
        }
        checkAddress(((InetSocketAddress) mcastaddr).getAddress(), "leaveGroup");
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkMulticast(((InetSocketAddress) mcastaddr).getAddress());
        }
        if (!((InetSocketAddress) mcastaddr).getAddress().isMulticastAddress()) {
            throw new SocketException("Not a multicast address");
        }
        getImpl().leaveGroup(mcastaddr, netIf);
    }

    public void setInterface(InetAddress inf) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        checkAddress(inf, "setInterface");
        synchronized (this.infLock) {
            getImpl().setOption(16, inf);
            this.infAddress = inf;
            this.interfaceSet = true;
        }
    }

    public InetAddress getInterface() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        synchronized (this.infLock) {
            InetAddress ia2 = (InetAddress) getImpl().getOption(16);
            InetAddress inetAddress = this.infAddress;
            if (inetAddress == null) {
                return ia2;
            }
            if (ia2.equals(inetAddress)) {
                return ia2;
            }
            try {
                NetworkInterface ni = NetworkInterface.getByInetAddress(ia2);
                Enumeration<InetAddress> addrs = ni.getInetAddresses();
                while (addrs.hasMoreElements()) {
                    InetAddress addr = addrs.nextElement();
                    if (addr.equals(this.infAddress)) {
                        return this.infAddress;
                    }
                }
                this.infAddress = null;
                return ia2;
            } catch (Exception e2) {
                return ia2;
            }
        }
    }

    public void setNetworkInterface(NetworkInterface netIf) throws SocketException {
        synchronized (this.infLock) {
            getImpl().setOption(31, netIf);
            this.infAddress = null;
            this.interfaceSet = true;
        }
    }

    public NetworkInterface getNetworkInterface() throws SocketException {
        Integer niIndex = (Integer) getImpl().getOption(31);
        if (niIndex.intValue() == 0) {
            InetAddress[] addrs = {InetAddress.anyLocalAddress()};
            return new NetworkInterface(addrs[0].getHostName(), 0, addrs);
        }
        return NetworkInterface.getByIndex(niIndex.intValue());
    }

    public void setLoopbackMode(boolean disable) throws SocketException {
        getImpl().setOption(18, Boolean.valueOf(disable));
    }

    public boolean getLoopbackMode() throws SocketException {
        return ((Boolean) getImpl().getOption(18)).booleanValue();
    }

    @Deprecated
    public void send(DatagramPacket p10, byte ttl) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        checkAddress(p10.getAddress(), "send");
        synchronized (this.ttlLock) {
            synchronized (p10) {
                if (this.connectState == 0) {
                    SecurityManager security = System.getSecurityManager();
                    if (security != null) {
                        if (p10.getAddress().isMulticastAddress()) {
                            security.checkMulticast(p10.getAddress(), ttl);
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
                        throw new SecurityException("connected address and packet address differ");
                    }
                }
                byte dttl = getTTL();
                if (ttl != dttl) {
                    try {
                        getImpl().setTTL(ttl);
                    } finally {
                        if (ttl != dttl) {
                            getImpl().setTTL(dttl);
                        }
                    }
                }
                getImpl().send(p10);
            }
        }
    }

    @Override // java.net.DatagramSocket
    public Set<SocketOption<?>> supportedOptions() {
        synchronized (MulticastSocket.class) {
            if (optionsSet) {
                return options;
            }
            try {
                DatagramSocketImpl impl = getImpl();
                options = Collections.unmodifiableSet(impl.supportedOptions());
            } catch (SocketException e2) {
                options = Collections.emptySet();
            }
            optionsSet = true;
            return options;
        }
    }
}
