package java.net;

import android.compat.Compatibility;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.system.StructIfaddrs;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import libcore.io.IoUtils;
import libcore.io.Libcore;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class NetworkInterface {
    private static final byte[] DEFAULT_MAC_ADDRESS = {2, 0, 0, 0, 0, 0};
    public static final long RETURN_NULL_HARDWARE_ADDRESS = 170188668;
    private static final int defaultIndex;
    private static final NetworkInterface defaultInterface;
    private InetAddress[] addrs;
    private InterfaceAddress[] bindings;
    private List<NetworkInterface> childs;
    private String displayName;
    private byte[] hardwareAddr;
    private int index;
    private String name;
    private NetworkInterface parent = null;
    private boolean virtual = false;

    static {
        NetworkInterface networkInterface = DefaultInterface.getDefault();
        defaultInterface = networkInterface;
        if (networkInterface != null) {
            defaultIndex = networkInterface.getIndex();
        } else {
            defaultIndex = 0;
        }
    }

    NetworkInterface() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NetworkInterface(String name, int index, InetAddress[] addrs) {
        this.name = name;
        this.index = index;
        this.addrs = addrs;
    }

    public String getName() {
        return this.name;
    }

    public Enumeration<InetAddress> getInetAddresses() {
        return new Enumeration<InetAddress>() { // from class: java.net.NetworkInterface.1checkedAddresses
            private int count;

            /* renamed from: i, reason: collision with root package name */
            private int f50368i = 0;
            private InetAddress[] local_addrs;

            {
                this.count = 0;
                this.local_addrs = new InetAddress[NetworkInterface.this.addrs.length];
                boolean trusted = true;
                SecurityManager sec = System.getSecurityManager();
                if (sec != null) {
                    try {
                        sec.checkPermission(new NetPermission("getNetworkInformation"));
                    } catch (SecurityException e2) {
                        trusted = false;
                    }
                }
                for (int j10 = 0; j10 < NetworkInterface.this.addrs.length; j10++) {
                    if (sec != null && !trusted) {
                        try {
                            sec.checkConnect(NetworkInterface.this.addrs[j10].getHostAddress(), -1);
                        } catch (SecurityException e10) {
                        }
                    }
                    InetAddress[] inetAddressArr = this.local_addrs;
                    int i10 = this.count;
                    this.count = i10 + 1;
                    inetAddressArr[i10] = NetworkInterface.this.addrs[j10];
                }
            }

            @Override // java.util.Enumeration
            public InetAddress nextElement() {
                int i10 = this.f50368i;
                if (i10 < this.count) {
                    InetAddress[] inetAddressArr = this.local_addrs;
                    this.f50368i = i10 + 1;
                    return inetAddressArr[i10];
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.f50368i < this.count;
            }
        };
    }

    public List<InterfaceAddress> getInterfaceAddresses() {
        List<InterfaceAddress> lst = new ArrayList<>(1);
        if (this.bindings != null) {
            SecurityManager sec = System.getSecurityManager();
            int j10 = 0;
            while (true) {
                InterfaceAddress[] interfaceAddressArr = this.bindings;
                if (j10 >= interfaceAddressArr.length) {
                    break;
                }
                if (sec != null) {
                    try {
                        sec.checkConnect(interfaceAddressArr[j10].getAddress().getHostAddress(), -1);
                    } catch (SecurityException e2) {
                    }
                }
                lst.add(this.bindings[j10]);
                j10++;
            }
        }
        return lst;
    }

    public Enumeration<NetworkInterface> getSubInterfaces() {
        return Collections.enumeration(this.childs);
    }

    public NetworkInterface getParent() {
        return this.parent;
    }

    public int getIndex() {
        return this.index;
    }

    public String getDisplayName() {
        if ("".equals(this.displayName)) {
            return null;
        }
        return this.displayName;
    }

    public static NetworkInterface getByName(String name) throws SocketException {
        if (name == null) {
            throw new NullPointerException();
        }
        NetworkInterface[] nis = getAll();
        for (NetworkInterface ni : nis) {
            if (ni.getName().equals(name)) {
                return ni;
            }
        }
        return null;
    }

    public static NetworkInterface getByIndex(int index) throws SocketException {
        if (index < 0) {
            throw new IllegalArgumentException("Interface index can't be negative");
        }
        NetworkInterface[] nis = getAll();
        for (NetworkInterface ni : nis) {
            if (ni.getIndex() == index) {
                return ni;
            }
        }
        return null;
    }

    public static NetworkInterface getByInetAddress(InetAddress addr) throws SocketException {
        if (addr == null) {
            throw new NullPointerException();
        }
        if (!(addr instanceof Inet4Address) && !(addr instanceof Inet6Address)) {
            throw new IllegalArgumentException("invalid address type");
        }
        NetworkInterface[] nis = getAll();
        for (NetworkInterface ni : nis) {
            Iterator iterator2 = Collections.list(ni.getInetAddresses()).iterator2();
            while (iterator2.hasNext()) {
                InetAddress inetAddress = (InetAddress) iterator2.next();
                if (inetAddress.equals(addr)) {
                    return ni;
                }
            }
        }
        return null;
    }

    public static Enumeration<NetworkInterface> getNetworkInterfaces() throws SocketException {
        NetworkInterface[] netifs = getAll();
        if (netifs.length == 0) {
            return null;
        }
        return Collections.enumeration(Arrays.asList(netifs));
    }

    private static NetworkInterface[] getAll() throws SocketException {
        Map<String, List<StructIfaddrs>> inetMap = new HashMap<>();
        try {
            StructIfaddrs[] ifaddrs = Libcore.os.getifaddrs();
            if (ifaddrs == null) {
                throw new SocketException("Failed to query network interfaces.");
            }
            for (StructIfaddrs ifa : ifaddrs) {
                String name = ifa.ifa_name;
                List<StructIfaddrs> list = inetMap.get(name);
                List<StructIfaddrs> ifas = list;
                if (list == null) {
                    ifas = new ArrayList<>();
                    inetMap.put(name, ifas);
                }
                ifas.add(ifa);
            }
            Map<String, NetworkInterface> nis = new HashMap<>(inetMap.size());
            for (Map.Entry<String, List<StructIfaddrs>> e2 : inetMap.entrySet()) {
                String name2 = e2.getKey();
                int index = Libcore.os.if_nametoindex(e2.getKey());
                if (index != 0) {
                    NetworkInterface ni = new NetworkInterface(name2, index, null);
                    ni.displayName = name2;
                    List<InetAddress> addrs = new ArrayList<>();
                    List<InterfaceAddress> binds = new ArrayList<>();
                    for (StructIfaddrs ifa2 : e2.getValue()) {
                        if (ifa2.ifa_addr != null) {
                            addrs.add(ifa2.ifa_addr);
                            binds.add(new InterfaceAddress(ifa2.ifa_addr, (Inet4Address) ifa2.ifa_broadaddr, ifa2.ifa_netmask));
                        }
                        if (ifa2.hwaddr != null) {
                            ni.hardwareAddr = ifa2.hwaddr;
                        }
                    }
                    ni.addrs = (InetAddress[]) addrs.toArray(new InetAddress[addrs.size()]);
                    ni.bindings = (InterfaceAddress[]) binds.toArray(new InterfaceAddress[binds.size()]);
                    ni.childs = new ArrayList(0);
                    nis.put(name2, ni);
                }
            }
            for (Map.Entry<String, NetworkInterface> e10 : nis.entrySet()) {
                NetworkInterface ni2 = e10.getValue();
                String niName = ni2.getName();
                int colonIdx = niName.indexOf(58);
                if (colonIdx != -1) {
                    String parentName = niName.substring(0, colonIdx);
                    NetworkInterface parent = nis.get(parentName);
                    ni2.virtual = true;
                    if (parent != null) {
                        ni2.parent = parent;
                        parent.childs.add(ni2);
                    }
                }
            }
            return (NetworkInterface[]) nis.values().toArray(new NetworkInterface[nis.size()]);
        } catch (ErrnoException e11) {
            throw e11.rethrowAsSocketException();
        }
    }

    public boolean isUp() throws SocketException {
        int mask = OsConstants.IFF_UP | OsConstants.IFF_RUNNING;
        return (getFlags() & mask) == mask;
    }

    public boolean isLoopback() throws SocketException {
        return (getFlags() & OsConstants.IFF_LOOPBACK) != 0;
    }

    public boolean isPointToPoint() throws SocketException {
        return (getFlags() & OsConstants.IFF_POINTOPOINT) != 0;
    }

    public boolean supportsMulticast() throws SocketException {
        return (getFlags() & OsConstants.IFF_MULTICAST) != 0;
    }

    public byte[] getHardwareAddress() throws SocketException {
        NetworkInterface ni = getByName(this.name);
        if (ni == null) {
            throw new SocketException("NetworkInterface doesn't exist anymore");
        }
        if (ni.hardwareAddr == null && !"lo".equals(this.name) && !Compatibility.isChangeEnabled(RETURN_NULL_HARDWARE_ADDRESS)) {
            return (byte[]) DEFAULT_MAC_ADDRESS.clone();
        }
        return ni.hardwareAddr;
    }

    public int getMTU() throws SocketException {
        FileDescriptor fd2 = null;
        try {
            try {
                fd2 = Libcore.rawOs.socket(OsConstants.AF_INET, OsConstants.SOCK_DGRAM, 0);
                return Libcore.rawOs.ioctlMTU(fd2, this.name);
            } catch (ErrnoException e2) {
                throw e2.rethrowAsSocketException();
            } catch (Exception ex) {
                throw new SocketException(ex);
            }
        } finally {
            IoUtils.closeQuietly(fd2);
        }
    }

    public boolean isVirtual() {
        return this.virtual;
    }

    private int getFlags() throws SocketException {
        FileDescriptor fd2 = null;
        try {
            try {
                fd2 = Libcore.rawOs.socket(OsConstants.AF_INET, OsConstants.SOCK_DGRAM, 0);
                return Libcore.rawOs.ioctlFlags(fd2, this.name);
            } catch (ErrnoException e2) {
                throw e2.rethrowAsSocketException();
            } catch (Exception ex) {
                throw new SocketException(ex);
            }
        } finally {
            IoUtils.closeQuietly(fd2);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NetworkInterface)) {
            return false;
        }
        NetworkInterface that = (NetworkInterface) obj;
        String str = this.name;
        if (str != null) {
            if (!str.equals(that.name)) {
                return false;
            }
        } else if (that.name != null) {
            return false;
        }
        InetAddress[] inetAddressArr = this.addrs;
        if (inetAddressArr == null) {
            return that.addrs == null;
        }
        InetAddress[] inetAddressArr2 = that.addrs;
        if (inetAddressArr2 == null || inetAddressArr.length != inetAddressArr2.length) {
            return false;
        }
        InetAddress[] thatAddrs = that.addrs;
        int count = thatAddrs.length;
        for (int i10 = 0; i10 < count; i10++) {
            boolean found = false;
            int j10 = 0;
            while (true) {
                if (j10 >= count) {
                    break;
                }
                if (!this.addrs[i10].equals(thatAddrs[j10])) {
                    j10++;
                } else {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.name;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("name:");
        String str = this.name;
        if (str == null) {
            str = "null";
        }
        String result = append.append(str).toString();
        if (this.displayName != null) {
            return result + " (" + this.displayName + ")";
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NetworkInterface getDefault() {
        return defaultInterface;
    }
}
