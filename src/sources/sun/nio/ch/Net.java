package sun.nio.ch;

import androidx.recyclerview.widget.ItemTouchHelper;
import dalvik.system.BlockGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.ProtocolFamily;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketOption;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.net.UnknownHostException;
import java.nio.channels.AlreadyBoundException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetBoundException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.UnresolvedAddressException;
import java.nio.channels.UnsupportedAddressTypeException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import jdk.net.NetworkPermission;
import jdk.net.SocketFlow;
import sun.net.ExtendedOptionsImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Net {
    public static final int SHUT_RD = 0;
    public static final int SHUT_RDWR = 2;
    public static final int SHUT_WR = 1;
    private static final boolean exclusiveBind;
    private static final boolean fastLoopback;
    private static volatile boolean isIPv6Available;
    static final ProtocolFamily UNSPEC = new ProtocolFamily() { // from class: sun.nio.ch.Net.1
        @Override // java.net.ProtocolFamily
        public String name() {
            return "UNSPEC";
        }
    };
    private static volatile boolean checkedIPv6 = false;
    public static final short POLLIN = pollinValue();
    public static final short POLLOUT = polloutValue();
    public static final short POLLERR = pollerrValue();
    public static final short POLLHUP = pollhupValue();
    public static final short POLLNVAL = pollnvalValue();
    public static final short POLLCONN = pollconnValue();

    private static native void bind0(FileDescriptor fileDescriptor, boolean z10, boolean z11, InetAddress inetAddress, int i10) throws IOException;

    private static native int blockOrUnblock4(boolean z10, FileDescriptor fileDescriptor, int i10, int i11, int i12) throws IOException;

    static native int blockOrUnblock6(boolean z10, FileDescriptor fileDescriptor, byte[] bArr, int i10, byte[] bArr2) throws IOException;

    private static native boolean canIPv6SocketJoinIPv4Group0();

    private static native boolean canJoin6WithIPv4Group0();

    private static native int connect0(boolean z10, FileDescriptor fileDescriptor, InetAddress inetAddress, int i10) throws IOException;

    private static native int getIntOption0(FileDescriptor fileDescriptor, boolean z10, int i10, int i11) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getInterface4(FileDescriptor fileDescriptor) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getInterface6(FileDescriptor fileDescriptor) throws IOException;

    private static native int isExclusiveBindAvailable();

    private static native boolean isIPv6Available0();

    private static native int joinOrDrop4(boolean z10, FileDescriptor fileDescriptor, int i10, int i11, int i12) throws IOException;

    private static native int joinOrDrop6(boolean z10, FileDescriptor fileDescriptor, byte[] bArr, int i10, byte[] bArr2) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void listen(FileDescriptor fileDescriptor, int i10) throws IOException;

    private static native InetAddress localInetAddress(FileDescriptor fileDescriptor) throws IOException;

    private static native int localPort(FileDescriptor fileDescriptor) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int poll(FileDescriptor fileDescriptor, int i10, long j10) throws IOException;

    static native short pollconnValue();

    static native short pollerrValue();

    static native short pollhupValue();

    static native short pollinValue();

    static native short pollnvalValue();

    static native short polloutValue();

    private static native InetAddress remoteInetAddress(FileDescriptor fileDescriptor) throws IOException;

    private static native int remotePort(FileDescriptor fileDescriptor) throws IOException;

    private static native void setIntOption0(FileDescriptor fileDescriptor, boolean z10, int i10, int i11, int i12, boolean z11) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setInterface4(FileDescriptor fileDescriptor, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setInterface6(FileDescriptor fileDescriptor, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void shutdown(FileDescriptor fileDescriptor, int i10) throws IOException;

    private static native int socket0(boolean z10, boolean z11, boolean z12, boolean z13);

    private Net() {
    }

    static {
        int availLevel = isExclusiveBindAvailable();
        if (availLevel >= 0) {
            String exclBindProp = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: sun.nio.ch.Net.4
                @Override // java.security.PrivilegedAction
                public String run() {
                    return System.getProperty("sun.net.useExclusiveBind");
                }
            });
            if (exclBindProp != null) {
                exclusiveBind = exclBindProp.length() != 0 ? Boolean.parseBoolean(exclBindProp) : true;
            } else if (availLevel == 1) {
                exclusiveBind = true;
            } else {
                exclusiveBind = false;
            }
        } else {
            exclusiveBind = false;
        }
        fastLoopback = isFastTcpLoopbackRequested();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isIPv6Available() {
        if (!checkedIPv6) {
            isIPv6Available = isIPv6Available0();
            checkedIPv6 = true;
        }
        return isIPv6Available;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean useExclusiveBind() {
        return exclusiveBind;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean canIPv6SocketJoinIPv4Group() {
        return canIPv6SocketJoinIPv4Group0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean canJoin6WithIPv4Group() {
        return canJoin6WithIPv4Group0();
    }

    public static InetSocketAddress checkAddress(SocketAddress sa2) {
        if (sa2 == null) {
            throw new IllegalArgumentException("sa == null");
        }
        if (!(sa2 instanceof InetSocketAddress)) {
            throw new UnsupportedAddressTypeException();
        }
        InetSocketAddress isa = (InetSocketAddress) sa2;
        if (isa.isUnresolved()) {
            throw new UnresolvedAddressException();
        }
        InetAddress addr = isa.getAddress();
        if (!(addr instanceof Inet4Address) && !(addr instanceof Inet6Address)) {
            throw new IllegalArgumentException("Invalid address type");
        }
        return isa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InetSocketAddress asInetSocketAddress(SocketAddress sa2) {
        if (!(sa2 instanceof InetSocketAddress)) {
            throw new UnsupportedAddressTypeException();
        }
        return (InetSocketAddress) sa2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void translateToSocketException(Exception x10) throws SocketException {
        if (x10 instanceof SocketException) {
            throw ((SocketException) x10);
        }
        Exception nx = x10;
        if (x10 instanceof ClosedChannelException) {
            nx = new SocketException("Socket is closed");
        } else if (x10 instanceof NotYetConnectedException) {
            nx = new SocketException("Socket is not connected");
        } else if (x10 instanceof AlreadyBoundException) {
            nx = new SocketException("Already bound");
        } else if (x10 instanceof NotYetBoundException) {
            nx = new SocketException("Socket is not bound yet");
        } else if (x10 instanceof UnsupportedAddressTypeException) {
            nx = new SocketException("Unsupported address type");
        } else if (x10 instanceof UnresolvedAddressException) {
            nx = new SocketException("Unresolved address");
        } else if (x10 instanceof AlreadyConnectedException) {
            nx = new SocketException("Already connected");
        }
        if (nx != x10) {
            nx.initCause(x10);
        }
        if (nx instanceof SocketException) {
            throw ((SocketException) nx);
        }
        if (nx instanceof RuntimeException) {
            throw ((RuntimeException) nx);
        }
        throw new Error("Untranslated exception", nx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void translateException(Exception x10, boolean unknownHostForUnresolved) throws IOException {
        if (x10 instanceof IOException) {
            throw ((IOException) x10);
        }
        if (unknownHostForUnresolved && (x10 instanceof UnresolvedAddressException)) {
            throw new UnknownHostException();
        }
        translateToSocketException(x10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void translateException(Exception x10) throws IOException {
        translateException(x10, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InetSocketAddress getRevealedLocalAddress(InetSocketAddress addr) {
        SecurityManager sm = System.getSecurityManager();
        if (addr == null || sm == null) {
            return addr;
        }
        try {
            sm.checkConnect(addr.getAddress().getHostAddress(), -1);
            return addr;
        } catch (SecurityException e2) {
            return getLoopbackAddress(addr.getPort());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getRevealedLocalAddressAsString(InetSocketAddress addr) {
        return System.getSecurityManager() == null ? addr.toString() : getLoopbackAddress(addr.getPort()).toString();
    }

    private static InetSocketAddress getLoopbackAddress(int port) {
        return new InetSocketAddress(InetAddress.getLoopbackAddress(), port);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Inet4Address anyInet4Address(final NetworkInterface interf) {
        return (Inet4Address) AccessController.doPrivileged(new PrivilegedAction<Inet4Address>() { // from class: sun.nio.ch.Net.2
            @Override // java.security.PrivilegedAction
            public Inet4Address run() {
                Enumeration<InetAddress> addrs = NetworkInterface.this.getInetAddresses();
                while (addrs.hasMoreElements()) {
                    InetAddress addr = addrs.nextElement();
                    if (addr instanceof Inet4Address) {
                        return (Inet4Address) addr;
                    }
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int inet4AsInt(InetAddress ia2) {
        if (ia2 instanceof Inet4Address) {
            byte[] addr = ia2.getAddress();
            int address = addr[3] & 255;
            return address | ((addr[2] << 8) & 65280) | ((addr[1] << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((addr[0] << 24) & (-16777216));
        }
        throw new AssertionError((Object) "Should not reach here");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InetAddress inet4FromInt(int address) {
        byte[] addr = {(byte) ((address >>> 24) & 255), (byte) ((address >>> 16) & 255), (byte) ((address >>> 8) & 255), (byte) (address & 255)};
        try {
            return InetAddress.getByAddress(addr);
        } catch (UnknownHostException e2) {
            throw new AssertionError((Object) "Should not reach here");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] inet6AsByteArray(InetAddress ia2) {
        if (ia2 instanceof Inet6Address) {
            return ia2.getAddress();
        }
        if (ia2 instanceof Inet4Address) {
            byte[] ip4address = ia2.getAddress();
            byte[] address = new byte[16];
            address[10] = -1;
            address[11] = -1;
            address[12] = ip4address[0];
            address[13] = ip4address[1];
            address[14] = ip4address[2];
            address[15] = ip4address[3];
            return address;
        }
        throw new AssertionError((Object) "Should not reach here");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    public static void setSocketOption(FileDescriptor fileDescriptor, ProtocolFamily protocolFamily, SocketOption<?> socketOption, Object obj) throws IOException {
        boolean z10;
        int intValue;
        int intValue2;
        if (obj == null) {
            throw new IllegalArgumentException("Invalid option value");
        }
        Class<?> type = socketOption.type();
        if (type == SocketFlow.class) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(new NetworkPermission("setOption.SO_FLOW_SLA"));
            }
            ExtendedOptionsImpl.setFlowOption(fileDescriptor, (SocketFlow) obj);
            return;
        }
        if (type != Integer.class && type != Boolean.class) {
            throw new AssertionError((Object) "Should not reach here");
        }
        if ((socketOption == StandardSocketOptions.SO_RCVBUF || socketOption == StandardSocketOptions.SO_SNDBUF) && ((Integer) obj).intValue() < 0) {
            throw new IllegalArgumentException("Invalid send/receive buffer size");
        }
        if (socketOption == StandardSocketOptions.SO_LINGER) {
            int intValue3 = ((Integer) obj).intValue();
            if (intValue3 < 0) {
                obj = -1;
            }
            if (intValue3 > 65535) {
                obj = 65535;
            }
        }
        if (socketOption == StandardSocketOptions.IP_TOS && ((intValue2 = ((Integer) obj).intValue()) < 0 || intValue2 > 255)) {
            throw new IllegalArgumentException("Invalid IP_TOS value");
        }
        if (socketOption == StandardSocketOptions.IP_MULTICAST_TTL && ((intValue = ((Integer) obj).intValue()) < 0 || intValue > 255)) {
            throw new IllegalArgumentException("Invalid TTL/hop value");
        }
        OptionKey findOption = SocketOptionRegistry.findOption(socketOption, protocolFamily);
        if (findOption == null) {
            throw new AssertionError((Object) "Option not found");
        }
        if (type == Integer.class) {
            z10 = ((Integer) obj).intValue();
        } else {
            z10 = ((Boolean) obj).booleanValue();
        }
        setIntOption0(fileDescriptor, protocolFamily == UNSPEC, findOption.level(), findOption.name(), z10, protocolFamily == StandardProtocolFamily.INET6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getSocketOption(FileDescriptor fd2, ProtocolFamily family, SocketOption<?> name) throws IOException {
        Class<?> type = name.type();
        if (type == SocketFlow.class) {
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkPermission(new NetworkPermission("getOption.SO_FLOW_SLA"));
            }
            SocketFlow flow = SocketFlow.create();
            ExtendedOptionsImpl.getFlowOption(fd2, flow);
            return flow;
        }
        if (type != Integer.class && type != Boolean.class) {
            throw new AssertionError((Object) "Should not reach here");
        }
        OptionKey key = SocketOptionRegistry.findOption(name, family);
        if (key == null) {
            throw new AssertionError((Object) "Option not found");
        }
        boolean mayNeedConversion = family == UNSPEC;
        int value = getIntOption0(fd2, mayNeedConversion, key.level(), key.name());
        if (type == Integer.class) {
            return Integer.valueOf(value);
        }
        return value == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static boolean isFastTcpLoopbackRequested() {
        String loopbackProp = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: sun.nio.ch.Net.3
            @Override // java.security.PrivilegedAction
            public String run() {
                return System.getProperty("jdk.net.useFastTcpLoopback");
            }
        });
        if ("".equals(loopbackProp)) {
            return true;
        }
        boolean enable = Boolean.parseBoolean(loopbackProp);
        return enable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FileDescriptor socket(boolean stream) throws IOException {
        return socket(UNSPEC, stream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FileDescriptor socket(ProtocolFamily family, boolean stream) throws IOException {
        boolean preferIPv6 = isIPv6Available() && family != StandardProtocolFamily.INET;
        return IOUtil.newFD(socket0(preferIPv6, stream, false, fastLoopback));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FileDescriptor serverSocket(boolean stream) {
        return IOUtil.newFD(socket0(isIPv6Available(), stream, true, fastLoopback));
    }

    public static void bind(FileDescriptor fd2, InetAddress addr, int port) throws IOException {
        bind(UNSPEC, fd2, addr, port);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void bind(ProtocolFamily family, FileDescriptor fd2, InetAddress addr, int port) throws IOException {
        boolean preferIPv6 = isIPv6Available() && family != StandardProtocolFamily.INET;
        bind0(fd2, preferIPv6, exclusiveBind, addr, port);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int connect(FileDescriptor fd2, InetAddress remote, int remotePort) throws IOException {
        return connect(UNSPEC, fd2, remote, remotePort);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int connect(ProtocolFamily family, FileDescriptor fd2, InetAddress remote, int remotePort) throws IOException {
        BlockGuard.getThreadPolicy().onNetwork();
        boolean preferIPv6 = isIPv6Available() && family != StandardProtocolFamily.INET;
        return connect0(preferIPv6, fd2, remote, remotePort);
    }

    public static InetSocketAddress localAddress(FileDescriptor fd2) throws IOException {
        return new InetSocketAddress(localInetAddress(fd2), localPort(fd2));
    }

    static InetSocketAddress remoteAddress(FileDescriptor fd2) throws IOException {
        return new InetSocketAddress(remoteInetAddress(fd2), remotePort(fd2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int join4(FileDescriptor fd2, int group, int interf, int source) throws IOException {
        return joinOrDrop4(true, fd2, group, interf, source);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void drop4(FileDescriptor fd2, int group, int interf, int source) throws IOException {
        joinOrDrop4(false, fd2, group, interf, source);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int block4(FileDescriptor fd2, int group, int interf, int source) throws IOException {
        return blockOrUnblock4(true, fd2, group, interf, source);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unblock4(FileDescriptor fd2, int group, int interf, int source) throws IOException {
        blockOrUnblock4(false, fd2, group, interf, source);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int join6(FileDescriptor fd2, byte[] group, int index, byte[] source) throws IOException {
        return joinOrDrop6(true, fd2, group, index, source);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void drop6(FileDescriptor fd2, byte[] group, int index, byte[] source) throws IOException {
        joinOrDrop6(false, fd2, group, index, source);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int block6(FileDescriptor fd2, byte[] group, int index, byte[] source) throws IOException {
        return blockOrUnblock6(true, fd2, group, index, source);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unblock6(FileDescriptor fd2, byte[] group, int index, byte[] source) throws IOException {
        blockOrUnblock6(false, fd2, group, index, source);
    }
}
