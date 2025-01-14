package java.net;

import android.system.OsConstants;
import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.util.Arrays;
import java.util.Enumeration;
import libcore.io.Libcore;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Inet6Address extends InetAddress {
    private static final long FIELDS_OFFSET;
    static final int INADDRSZ = 16;
    private static final int INT16SZ = 2;
    private static final Unsafe UNSAFE;
    private static final long serialVersionUID = 6880410070516793377L;
    private final transient Inet6AddressHolder holder6;
    public static final InetAddress ANY = new Inet6Address("::", new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0);
    public static final InetAddress LOOPBACK = new Inet6Address("ip6-localhost", new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 0);
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("ipaddress", byte[].class), new ObjectStreamField("scope_id", Integer.TYPE), new ObjectStreamField("scope_id_set", Boolean.TYPE), new ObjectStreamField("scope_ifname_set", Boolean.TYPE), new ObjectStreamField("ifname", String.class)};

    static {
        try {
            Unsafe unsafe = Unsafe.getUnsafe();
            FIELDS_OFFSET = unsafe.objectFieldOffset(Inet6Address.class.getDeclaredField("holder6"));
            UNSAFE = unsafe;
        } catch (ReflectiveOperationException e2) {
            throw new Error(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class Inet6AddressHolder {
        byte[] ipaddress;
        int scope_id;
        boolean scope_id_set;
        NetworkInterface scope_ifname;
        boolean scope_ifname_set;

        private Inet6AddressHolder() {
            this.ipaddress = new byte[16];
        }

        private Inet6AddressHolder(byte[] ipaddress, int scope_id, boolean scope_id_set, NetworkInterface ifname, boolean scope_ifname_set) {
            this.ipaddress = ipaddress;
            this.scope_id = scope_id;
            this.scope_id_set = scope_id_set;
            this.scope_ifname_set = scope_ifname_set;
            this.scope_ifname = ifname;
        }

        void setAddr(byte[] addr) {
            if (addr.length == 16) {
                System.arraycopy((Object) addr, 0, (Object) this.ipaddress, 0, 16);
            }
        }

        void init(byte[] addr, int scope_id) {
            setAddr(addr);
            if (scope_id > 0) {
                this.scope_id = scope_id;
                this.scope_id_set = true;
            }
        }

        void init(byte[] addr, NetworkInterface nif) throws UnknownHostException {
            setAddr(addr);
            if (nif != null) {
                this.scope_id = Inet6Address.deriveNumericScope(this.ipaddress, nif);
                this.scope_id_set = true;
                this.scope_ifname = nif;
                this.scope_ifname_set = true;
            }
        }

        public boolean equals(Object o10) {
            if (!(o10 instanceof Inet6AddressHolder)) {
                return false;
            }
            Inet6AddressHolder that = (Inet6AddressHolder) o10;
            return Arrays.equals(this.ipaddress, that.ipaddress);
        }

        public int hashCode() {
            if (this.ipaddress != null) {
                int hash = 0;
                int i10 = 0;
                while (i10 < 16) {
                    int j10 = 0;
                    int component = 0;
                    while (j10 < 4 && i10 < 16) {
                        component = (component << 8) + this.ipaddress[i10];
                        j10++;
                        i10++;
                    }
                    hash += component;
                }
                return hash;
            }
            return 0;
        }

        boolean isIPv4CompatibleAddress() {
            byte[] bArr = this.ipaddress;
            return bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 0 && bArr[4] == 0 && bArr[5] == 0 && bArr[6] == 0 && bArr[7] == 0 && bArr[8] == 0 && bArr[9] == 0 && bArr[10] == 0 && bArr[11] == 0;
        }

        boolean isMulticastAddress() {
            return (this.ipaddress[0] & 255) == 255;
        }

        boolean isAnyLocalAddress() {
            byte test = 0;
            for (int i10 = 0; i10 < 16; i10++) {
                test = (byte) (this.ipaddress[i10] | test);
            }
            return test == 0;
        }

        boolean isLoopbackAddress() {
            byte test = 0;
            for (int i10 = 0; i10 < 15; i10++) {
                test = (byte) (this.ipaddress[i10] | test);
            }
            return test == 0 && this.ipaddress[15] == 1;
        }

        boolean isLinkLocalAddress() {
            byte[] bArr = this.ipaddress;
            return (bArr[0] & 255) == 254 && (bArr[1] & 192) == 128;
        }

        boolean isSiteLocalAddress() {
            byte[] bArr = this.ipaddress;
            return (bArr[0] & 255) == 254 && (bArr[1] & 192) == 192;
        }

        boolean isMCGlobal() {
            byte[] bArr = this.ipaddress;
            return (bArr[0] & 255) == 255 && (bArr[1] & 15) == 14;
        }

        boolean isMCNodeLocal() {
            byte[] bArr = this.ipaddress;
            return (bArr[0] & 255) == 255 && (bArr[1] & 15) == 1;
        }

        boolean isMCLinkLocal() {
            byte[] bArr = this.ipaddress;
            return (bArr[0] & 255) == 255 && (bArr[1] & 15) == 2;
        }

        boolean isMCSiteLocal() {
            byte[] bArr = this.ipaddress;
            return (bArr[0] & 255) == 255 && (bArr[1] & 15) == 5;
        }

        boolean isMCOrgLocal() {
            byte[] bArr = this.ipaddress;
            return (bArr[0] & 255) == 255 && (bArr[1] & 15) == 8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Inet6Address() {
        this.holder.init(null, OsConstants.AF_INET6);
        this.holder6 = new Inet6AddressHolder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Inet6Address(String hostName, byte[] addr, int scope_id) {
        this.holder.init(hostName, OsConstants.AF_INET6);
        Inet6AddressHolder inet6AddressHolder = new Inet6AddressHolder();
        this.holder6 = inet6AddressHolder;
        inet6AddressHolder.init(addr, scope_id);
    }

    Inet6Address(String hostName, byte[] addr) {
        this.holder6 = new Inet6AddressHolder();
        try {
            initif(hostName, addr, null);
        } catch (UnknownHostException e2) {
        }
    }

    Inet6Address(String hostName, byte[] addr, NetworkInterface nif) throws UnknownHostException {
        this.holder6 = new Inet6AddressHolder();
        initif(hostName, addr, nif);
    }

    Inet6Address(String hostName, byte[] addr, String ifname) throws UnknownHostException {
        this.holder6 = new Inet6AddressHolder();
        initstr(hostName, addr, ifname);
    }

    public static Inet6Address getByAddress(String host, byte[] addr, NetworkInterface nif) throws UnknownHostException {
        if (host != null && host.length() > 0 && host.charAt(0) == '[' && host.charAt(host.length() - 1) == ']') {
            host = host.substring(1, host.length() - 1);
        }
        if (addr != null && addr.length == 16) {
            return new Inet6Address(host, addr, nif);
        }
        throw new UnknownHostException("addr is of illegal length");
    }

    public static Inet6Address getByAddress(String host, byte[] addr, int scope_id) throws UnknownHostException {
        if (host != null && host.length() > 0 && host.charAt(0) == '[' && host.charAt(host.length() - 1) == ']') {
            host = host.substring(1, host.length() - 1);
        }
        if (addr != null && addr.length == 16) {
            return new Inet6Address(host, addr, scope_id);
        }
        throw new UnknownHostException("addr is of illegal length");
    }

    private void initstr(String hostName, byte[] addr, String ifname) throws UnknownHostException {
        try {
            NetworkInterface nif = NetworkInterface.getByName(ifname);
            if (nif == null) {
                throw new UnknownHostException("no such interface " + ifname);
            }
            initif(hostName, addr, nif);
        } catch (SocketException e2) {
            throw new UnknownHostException("SocketException thrown" + ifname);
        }
    }

    private void initif(String hostName, byte[] addr, NetworkInterface nif) throws UnknownHostException {
        int family = -1;
        this.holder6.init(addr, nif);
        if (addr.length == 16) {
            family = OsConstants.AF_INET6;
        }
        this.holder.init(hostName, family);
    }

    private static boolean isDifferentLocalAddressType(byte[] thisAddr, byte[] otherAddr) {
        if (!isLinkLocalAddress(thisAddr) || isLinkLocalAddress(otherAddr)) {
            return !isSiteLocalAddress(thisAddr) || isSiteLocalAddress(otherAddr);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int deriveNumericScope(byte[] thisAddr, NetworkInterface ifc) throws UnknownHostException {
        Enumeration<InetAddress> addresses = ifc.getInetAddresses();
        while (addresses.hasMoreElements()) {
            InetAddress addr = addresses.nextElement();
            if (addr instanceof Inet6Address) {
                Inet6Address ia6_addr = (Inet6Address) addr;
                if (isDifferentLocalAddressType(thisAddr, ia6_addr.getAddress())) {
                    return ia6_addr.getScopeId();
                }
            }
        }
        throw new UnknownHostException("no scope_id found");
    }

    private int deriveNumericScope(String ifname) throws UnknownHostException {
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface ifc = en.nextElement();
                if (ifc.getName().equals(ifname)) {
                    return deriveNumericScope(this.holder6.ipaddress, ifc);
                }
            }
            throw new UnknownHostException("No matching address found for interface : " + ifname);
        } catch (SocketException e2) {
            throw new UnknownHostException("could not enumerate local network interfaces");
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        NetworkInterface scope_ifname = null;
        if (getClass().getClassLoader() != Class.class.getClassLoader()) {
            throw new SecurityException("invalid address type");
        }
        ObjectInputStream.GetField gf = s2.readFields();
        byte[] ipaddress = (byte[]) gf.get("ipaddress", (Object) null);
        int scope_id = gf.get("scope_id", -1);
        boolean scope_id_set = gf.get("scope_id_set", false);
        boolean scope_ifname_set = gf.get("scope_ifname_set", false);
        String ifname = (String) gf.get("ifname", (Object) null);
        if (ifname != null && !"".equals(ifname)) {
            try {
                scope_ifname = NetworkInterface.getByName(ifname);
                if (scope_ifname == null) {
                    scope_ifname_set = false;
                    scope_id = 0;
                    scope_id_set = false;
                } else {
                    scope_ifname_set = true;
                    try {
                        scope_id = deriveNumericScope(ipaddress, scope_ifname);
                    } catch (UnknownHostException e2) {
                    }
                }
            } catch (SocketException e10) {
            }
        }
        byte[] ipaddress2 = (byte[]) ipaddress.clone();
        if (ipaddress2.length != 16) {
            throw new InvalidObjectException("invalid address length: " + ipaddress2.length);
        }
        if (holder().getFamily() != OsConstants.AF_INET6) {
            throw new InvalidObjectException("invalid address family type");
        }
        Inet6AddressHolder h10 = new Inet6AddressHolder(ipaddress2, scope_id, scope_id_set, scope_ifname, scope_ifname_set);
        UNSAFE.putObject(this, FIELDS_OFFSET, h10);
    }

    private synchronized void writeObject(ObjectOutputStream s2) throws IOException {
        String ifname = null;
        if (this.holder6.scope_ifname != null) {
            ifname = this.holder6.scope_ifname.getName();
            this.holder6.scope_ifname_set = true;
        }
        ObjectOutputStream.PutField pfields = s2.putFields();
        pfields.put("ipaddress", this.holder6.ipaddress);
        pfields.put("scope_id", this.holder6.scope_id);
        pfields.put("scope_id_set", this.holder6.scope_id_set);
        pfields.put("scope_ifname_set", this.holder6.scope_ifname_set);
        pfields.put("ifname", ifname);
        s2.writeFields();
    }

    @Override // java.net.InetAddress
    public boolean isMulticastAddress() {
        return this.holder6.isMulticastAddress();
    }

    @Override // java.net.InetAddress
    public boolean isAnyLocalAddress() {
        return this.holder6.isAnyLocalAddress();
    }

    @Override // java.net.InetAddress
    public boolean isLoopbackAddress() {
        return this.holder6.isLoopbackAddress();
    }

    @Override // java.net.InetAddress
    public boolean isLinkLocalAddress() {
        return this.holder6.isLinkLocalAddress();
    }

    static boolean isLinkLocalAddress(byte[] ipaddress) {
        return (ipaddress[0] & 255) == 254 && (ipaddress[1] & 192) == 128;
    }

    @Override // java.net.InetAddress
    public boolean isSiteLocalAddress() {
        return this.holder6.isSiteLocalAddress();
    }

    static boolean isSiteLocalAddress(byte[] ipaddress) {
        return (ipaddress[0] & 255) == 254 && (ipaddress[1] & 192) == 192;
    }

    @Override // java.net.InetAddress
    public boolean isMCGlobal() {
        return this.holder6.isMCGlobal();
    }

    @Override // java.net.InetAddress
    public boolean isMCNodeLocal() {
        return this.holder6.isMCNodeLocal();
    }

    @Override // java.net.InetAddress
    public boolean isMCLinkLocal() {
        return this.holder6.isMCLinkLocal();
    }

    @Override // java.net.InetAddress
    public boolean isMCSiteLocal() {
        return this.holder6.isMCSiteLocal();
    }

    @Override // java.net.InetAddress
    public boolean isMCOrgLocal() {
        return this.holder6.isMCOrgLocal();
    }

    @Override // java.net.InetAddress
    public byte[] getAddress() {
        return (byte[]) this.holder6.ipaddress.clone();
    }

    public int getScopeId() {
        return this.holder6.scope_id;
    }

    public NetworkInterface getScopedInterface() {
        return this.holder6.scope_ifname;
    }

    @Override // java.net.InetAddress
    public String getHostAddress() {
        return Libcore.os.getnameinfo(this, OsConstants.NI_NUMERICHOST);
    }

    @Override // java.net.InetAddress
    public int hashCode() {
        return this.holder6.hashCode();
    }

    @Override // java.net.InetAddress
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Inet6Address)) {
            return false;
        }
        Inet6Address inetAddr = (Inet6Address) obj;
        return this.holder6.equals(inetAddr.holder6);
    }

    public boolean isIPv4CompatibleAddress() {
        return this.holder6.isIPv4CompatibleAddress();
    }

    static String numericToTextFormat(byte[] src) {
        StringBuilder sb2 = new StringBuilder(39);
        for (int i10 = 0; i10 < 8; i10++) {
            sb2.append(Integer.toHexString(((src[i10 << 1] << 8) & 65280) | (src[(i10 << 1) + 1] & 255)));
            if (i10 < 7) {
                sb2.append(u.bD);
            }
        }
        return sb2.toString();
    }
}
