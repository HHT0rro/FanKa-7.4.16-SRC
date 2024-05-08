package java.net;

import android.view.textclassifier.TextClassifier;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import libcore.io.Libcore;
import libcore.net.InetAddressUtils;
import sun.net.spi.nameservice.NameService;
import sun.net.util.IPAddressUtil;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class InetAddress implements Serializable {
    static final int NETID_UNSET = 0;
    private static final long serialVersionUID = 3286316764910316507L;
    private transient String canonicalHostName = null;
    transient InetAddressHolder holder = new InetAddressHolder();
    static final InetAddressImpl impl = new Inet6AddressImpl();
    private static final NameService nameService = new NameService() { // from class: java.net.InetAddress.1
        @Override // sun.net.spi.nameservice.NameService
        public InetAddress[] lookupAllHostAddr(String host, int netId) throws UnknownHostException {
            return InetAddress.impl.lookupAllHostAddr(host, netId);
        }

        @Override // sun.net.spi.nameservice.NameService
        public String getHostByAddr(byte[] addr) throws UnknownHostException {
            return InetAddress.impl.getHostByAddr(addr);
        }
    };
    private static final ClassLoader BOOT_CLASSLOADER = Object.class.getClassLoader();
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("hostName", String.class), new ObjectStreamField(TextClassifier.TYPE_ADDRESS, Integer.TYPE), new ObjectStreamField("family", Integer.TYPE)};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class InetAddressHolder {
        int address;
        int family;
        String hostName;
        String originalHostName;

        InetAddressHolder() {
        }

        InetAddressHolder(String hostName, int address, int family) {
            this.originalHostName = hostName;
            this.hostName = hostName;
            this.address = address;
            this.family = family;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void init(String hostName, int family) {
            this.originalHostName = hostName;
            this.hostName = hostName;
            if (family != -1) {
                this.family = family;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getHostName() {
            return this.hostName;
        }

        String getOriginalHostName() {
            return this.originalHostName;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getAddress() {
            return this.address;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getFamily() {
            return this.family;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InetAddressHolder holder() {
        return this.holder;
    }

    private Object readResolve() throws ObjectStreamException {
        return new Inet4Address(holder().getHostName(), holder().getAddress());
    }

    public boolean isMulticastAddress() {
        return false;
    }

    public boolean isAnyLocalAddress() {
        return false;
    }

    public boolean isLoopbackAddress() {
        return false;
    }

    public boolean isLinkLocalAddress() {
        return false;
    }

    public boolean isSiteLocalAddress() {
        return false;
    }

    public boolean isMCGlobal() {
        return false;
    }

    public boolean isMCNodeLocal() {
        return false;
    }

    public boolean isMCLinkLocal() {
        return false;
    }

    public boolean isMCSiteLocal() {
        return false;
    }

    public boolean isMCOrgLocal() {
        return false;
    }

    public boolean isReachable(int timeout) throws IOException {
        return isReachable(null, 0, timeout);
    }

    public boolean isReachable(NetworkInterface netif, int ttl, int timeout) throws IOException {
        if (ttl < 0) {
            throw new IllegalArgumentException("ttl can't be negative");
        }
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout can't be negative");
        }
        return impl.isReachable(this, timeout, netif, ttl);
    }

    public boolean isReachableByICMP(int timeout) throws IOException {
        return ((Inet6AddressImpl) impl).icmpEcho(this, timeout, null, 0);
    }

    public String getHostName() {
        if (holder().getHostName() == null) {
            holder().hostName = getHostFromNameService(this);
        }
        return holder().getHostName();
    }

    public String getCanonicalHostName() {
        if (this.canonicalHostName == null) {
            this.canonicalHostName = getHostFromNameService(this);
        }
        return this.canonicalHostName;
    }

    private static String getHostFromNameService(InetAddress addr) {
        try {
            NameService nameService2 = nameService;
            String host = nameService2.getHostByAddr(addr.getAddress());
            InetAddress[] arr = nameService2.lookupAllHostAddr(host, 0);
            boolean ok = false;
            if (arr != null) {
                for (int i10 = 0; !ok && i10 < arr.length; i10++) {
                    ok = addr.equals(arr[i10]);
                }
            }
            if (ok) {
                return host;
            }
            return addr.getHostAddress();
        } catch (UnknownHostException e2) {
            return addr.getHostAddress();
        }
    }

    public byte[] getAddress() {
        return null;
    }

    public String getHostAddress() {
        return null;
    }

    public int hashCode() {
        return -1;
    }

    public boolean equals(Object obj) {
        return false;
    }

    public String toString() {
        String hostName = holder().getHostName();
        return (hostName != null ? hostName : "") + "/" + getHostAddress();
    }

    public static InetAddress getByAddress(String host, byte[] addr) throws UnknownHostException {
        return getByAddress(host, addr, -1);
    }

    private static InetAddress getByAddress(String host, byte[] addr, int scopeId) throws UnknownHostException {
        if (host != null && host.length() > 0 && host.charAt(0) == '[' && host.charAt(host.length() - 1) == ']') {
            host = host.substring(1, host.length() - 1);
        }
        if (addr != null) {
            if (addr.length == 4) {
                return new Inet4Address(host, addr);
            }
            if (addr.length == 16) {
                byte[] newAddr = IPAddressUtil.convertFromIPv4MappedAddress(addr);
                if (newAddr != null) {
                    return new Inet4Address(host, newAddr);
                }
                return new Inet6Address(host, addr, scopeId);
            }
        }
        throw new UnknownHostException("addr is of illegal length");
    }

    public static InetAddress getByName(String host) throws UnknownHostException {
        return impl.lookupAllHostAddr(host, 0)[0];
    }

    public static InetAddress[] getAllByName(String host) throws UnknownHostException {
        return (InetAddress[]) impl.lookupAllHostAddr(host, 0).clone();
    }

    public static InetAddress getLoopbackAddress() {
        return impl.loopbackAddresses()[0];
    }

    public static InetAddress getByAddress(byte[] addr) throws UnknownHostException {
        return getByAddress(null, addr);
    }

    public static InetAddress getLocalHost() throws UnknownHostException {
        String local = Libcore.os.uname().nodename;
        return impl.lookupAllHostAddr(local, 0)[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InetAddress anyLocalAddress() {
        return impl.anyLocalAddress();
    }

    private void readObjectNoData(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        if (getClass().getClassLoader() != BOOT_CLASSLOADER) {
            throw new SecurityException("invalid address type");
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        if (getClass().getClassLoader() != BOOT_CLASSLOADER) {
            throw new SecurityException("invalid address type");
        }
        ObjectInputStream.GetField gf = s2.readFields();
        String host = (String) gf.get("hostName", (Object) null);
        int address = gf.get(TextClassifier.TYPE_ADDRESS, 0);
        int family = gf.get("family", 0);
        this.holder = new InetAddressHolder(host, address, family);
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        if (getClass().getClassLoader() != BOOT_CLASSLOADER) {
            throw new SecurityException("invalid address type");
        }
        ObjectOutputStream.PutField pf = s2.putFields();
        pf.put("hostName", holder().hostName);
        pf.put(TextClassifier.TYPE_ADDRESS, holder().address);
        pf.put("family", holder().family);
        s2.writeFields();
        s2.flush();
    }

    @Deprecated
    public static boolean isNumeric(String address) {
        return InetAddressUtils.parseNumericAddressNoThrowStripOptionalBrackets(address) != null;
    }

    @Deprecated
    public static InetAddress parseNumericAddress(String numericAddress) {
        if (numericAddress == null || numericAddress.isEmpty()) {
            return Inet6Address.LOOPBACK;
        }
        InetAddress result = InetAddressUtils.parseNumericAddressNoThrowStripOptionalBrackets(numericAddress);
        if (result == null) {
            throw new IllegalArgumentException("Not a numeric address: " + numericAddress);
        }
        return result;
    }

    public static void clearDnsCache() {
        impl.clearAddressCache();
    }

    public static InetAddress getByNameOnNet(String host, int netId) throws UnknownHostException {
        return impl.lookupAllHostAddr(host, netId)[0];
    }

    public static InetAddress[] getAllByNameOnNet(String host, int netId) throws UnknownHostException {
        return (InetAddress[]) impl.lookupAllHostAddr(host, netId).clone();
    }
}
