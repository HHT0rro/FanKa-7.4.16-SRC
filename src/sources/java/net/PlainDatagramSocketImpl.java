package java.net;

import android.system.ErrnoException;
import android.system.OsConstants;
import android.system.StructGroupReq;
import java.io.IOException;
import jdk.net.ExtendedSocketOptions;
import jdk.net.SocketFlow;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.util.EmptyArray;
import sun.net.ExtendedOptionsImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PlainDatagramSocketImpl extends AbstractPlainDatagramSocketImpl {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.net.DatagramSocketImpl
    public <T> void setOption(SocketOption<T> name, T t2) throws IOException {
        if (!name.equals(ExtendedSocketOptions.SO_FLOW_SLA)) {
            super.setOption((SocketOption<SocketOption<T>>) name, (SocketOption<T>) t2);
        } else {
            if (isClosed()) {
                throw new SocketException("Socket closed");
            }
            ExtendedOptionsImpl.checkSetOptionPermission(name);
            ExtendedOptionsImpl.checkValueType(t2, SocketFlow.class);
            ExtendedOptionsImpl.setFlowOption(getFileDescriptor(), (SocketFlow) t2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, jdk.net.SocketFlow] */
    @Override // java.net.DatagramSocketImpl
    public <T> T getOption(SocketOption<T> socketOption) throws IOException {
        if (!socketOption.equals(ExtendedSocketOptions.SO_FLOW_SLA)) {
            return (T) super.getOption(socketOption);
        }
        if (isClosed()) {
            throw new SocketException("Socket closed");
        }
        ExtendedOptionsImpl.checkGetOptionPermission(socketOption);
        ?? r02 = (T) SocketFlow.create();
        ExtendedOptionsImpl.getFlowOption(getFileDescriptor(), r02);
        return r02;
    }

    @Override // java.net.AbstractPlainDatagramSocketImpl
    protected void socketSetOption(int opt, Object val) throws SocketException {
        try {
            socketSetOption0(opt, val);
        } catch (SocketException se) {
            if (!this.connected) {
                throw se;
            }
        }
    }

    @Override // java.net.AbstractPlainDatagramSocketImpl
    protected synchronized void bind0(int lport, InetAddress laddr) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket closed");
        }
        IoBridge.bind(this.f50367fd, laddr, lport);
        if (lport == 0) {
            this.localPort = IoBridge.getLocalInetSocketAddress(this.f50367fd).getPort();
        } else {
            this.localPort = lport;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.AbstractPlainDatagramSocketImpl, java.net.DatagramSocketImpl
    public void send(DatagramPacket p10) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket closed");
        }
        if (p10.getData() == null || p10.getAddress() == null) {
            throw new NullPointerException("null buffer || null address");
        }
        int port = this.connected ? 0 : p10.getPort();
        InetAddress address = this.connected ? null : p10.getAddress();
        IoBridge.sendto(this.f50367fd, p10.getData(), p10.getOffset(), p10.getLength(), 0, address, port);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.AbstractPlainDatagramSocketImpl, java.net.DatagramSocketImpl
    public synchronized int peek(InetAddress i10) throws IOException {
        DatagramPacket p10;
        p10 = new DatagramPacket(EmptyArray.BYTE, 0);
        doRecv(p10, OsConstants.MSG_PEEK);
        i10.holder().address = p10.getAddress().holder().address;
        return p10.getPort();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.AbstractPlainDatagramSocketImpl, java.net.DatagramSocketImpl
    public synchronized int peekData(DatagramPacket p10) throws IOException {
        doRecv(p10, OsConstants.MSG_PEEK);
        return p10.getPort();
    }

    @Override // java.net.AbstractPlainDatagramSocketImpl
    protected synchronized void receive0(DatagramPacket p10) throws IOException {
        doRecv(p10, 0);
    }

    private void doRecv(DatagramPacket p10, int flags) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket closed");
        }
        if (this.timeout != 0) {
            IoBridge.poll(this.f50367fd, OsConstants.POLLIN | OsConstants.POLLERR, this.timeout);
        }
        IoBridge.recvfrom(false, this.f50367fd, p10.getData(), p10.getOffset(), p10.bufLength, flags, p10, this.connected);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.AbstractPlainDatagramSocketImpl, java.net.DatagramSocketImpl
    public void setTimeToLive(int ttl) throws IOException {
        IoBridge.setSocketOption(this.f50367fd, 17, Integer.valueOf(ttl));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.AbstractPlainDatagramSocketImpl, java.net.DatagramSocketImpl
    public int getTimeToLive() throws IOException {
        return ((Integer) IoBridge.getSocketOption(this.f50367fd, 17)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.AbstractPlainDatagramSocketImpl, java.net.DatagramSocketImpl
    public void setTTL(byte ttl) throws IOException {
        setTimeToLive(ttl & 255);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.AbstractPlainDatagramSocketImpl, java.net.DatagramSocketImpl
    public byte getTTL() throws IOException {
        return (byte) getTimeToLive();
    }

    private static StructGroupReq makeGroupReq(InetAddress gr_group, NetworkInterface networkInterface) {
        int gr_interface = networkInterface != null ? networkInterface.getIndex() : 0;
        return new StructGroupReq(gr_interface, gr_group);
    }

    @Override // java.net.AbstractPlainDatagramSocketImpl
    protected void join(InetAddress inetaddr, NetworkInterface netIf) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket closed");
        }
        IoBridge.setSocketOption(this.f50367fd, 19, makeGroupReq(inetaddr, netIf));
    }

    @Override // java.net.AbstractPlainDatagramSocketImpl
    protected void leave(InetAddress inetaddr, NetworkInterface netIf) throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket closed");
        }
        IoBridge.setSocketOption(this.f50367fd, 20, makeGroupReq(inetaddr, netIf));
    }

    @Override // java.net.AbstractPlainDatagramSocketImpl
    protected void datagramSocketCreate() throws SocketException {
        this.f50367fd = IoBridge.socket(OsConstants.AF_INET6, OsConstants.SOCK_DGRAM, 0);
        IoBridge.setSocketOption(this.f50367fd, 32, true);
        try {
            Libcore.os.setsockoptInt(this.f50367fd, OsConstants.IPPROTO_IP, OsConstants.IP_MULTICAST_ALL, 0);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    @Override // java.net.AbstractPlainDatagramSocketImpl
    protected void datagramSocketClose() {
        try {
            IoBridge.closeAndSignalBlockedThreads(this.f50367fd);
        } catch (IOException e2) {
        }
    }

    protected void socketSetOption0(int opt, Object val) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket closed");
        }
        IoBridge.setSocketOption(this.f50367fd, opt, val);
    }

    @Override // java.net.AbstractPlainDatagramSocketImpl
    protected Object socketGetOption(int opt) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket closed");
        }
        return IoBridge.getSocketOption(this.f50367fd, opt);
    }

    @Override // java.net.AbstractPlainDatagramSocketImpl
    protected void connect0(InetAddress address, int port) throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket closed");
        }
        IoBridge.connect(this.f50367fd, address, port);
    }

    @Override // java.net.AbstractPlainDatagramSocketImpl
    protected void disconnect0(int family) {
        if (isClosed()) {
            return;
        }
        InetAddress inetAddressUnspec = new InetAddress();
        inetAddressUnspec.holder().family = OsConstants.AF_UNSPEC;
        try {
            IoBridge.connect(this.f50367fd, inetAddressUnspec, 0);
        } catch (SocketException e2) {
        }
    }
}
