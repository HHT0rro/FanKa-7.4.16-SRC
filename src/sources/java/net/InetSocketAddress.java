package java.net;

import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import jdk.internal.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class InetSocketAddress extends SocketAddress {
    private static final long FIELDS_OFFSET;
    private static final Unsafe UNSAFE;
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("hostname", String.class), new ObjectStreamField("addr", InetAddress.class), new ObjectStreamField("port", Integer.TYPE)};
    private static final long serialVersionUID = 5076001401234631237L;
    private final transient InetSocketAddressHolder holder;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class InetSocketAddressHolder {
        private InetAddress addr;
        private String hostname;
        private int port;

        private InetSocketAddressHolder(String hostname, InetAddress addr, int port) {
            this.hostname = hostname;
            this.addr = addr;
            this.port = port;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getPort() {
            return this.port;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public InetAddress getAddress() {
            return this.addr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getHostName() {
            String str = this.hostname;
            if (str != null) {
                return str;
            }
            InetAddress inetAddress = this.addr;
            if (inetAddress != null) {
                return inetAddress.getHostName();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getHostString() {
            String str = this.hostname;
            if (str != null) {
                return str;
            }
            InetAddress inetAddress = this.addr;
            if (inetAddress != null) {
                if (inetAddress.holder().getHostName() != null) {
                    return this.addr.holder().getHostName();
                }
                return this.addr.getHostAddress();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isUnresolved() {
            return this.addr == null;
        }

        public String toString() {
            String formatted;
            if (isUnresolved()) {
                formatted = this.hostname + "/<unresolved>";
            } else {
                formatted = this.addr.toString();
                if (this.addr instanceof Inet6Address) {
                    int i10 = formatted.lastIndexOf("/");
                    formatted = formatted.substring(0, i10 + 1) + "[" + formatted.substring(i10 + 1) + "]";
                }
            }
            return formatted + u.bD + this.port;
        }

        public final boolean equals(Object obj) {
            boolean sameIP;
            if (obj == null || !(obj instanceof InetSocketAddressHolder)) {
                return false;
            }
            InetSocketAddressHolder that = (InetSocketAddressHolder) obj;
            InetAddress inetAddress = this.addr;
            if (inetAddress != null) {
                sameIP = inetAddress.equals(that.addr);
            } else {
                String str = this.hostname;
                if (str != null) {
                    sameIP = that.addr == null && str.equalsIgnoreCase(that.hostname);
                } else {
                    sameIP = that.addr == null && that.hostname == null;
                }
            }
            return sameIP && this.port == that.port;
        }

        public final int hashCode() {
            InetAddress inetAddress = this.addr;
            if (inetAddress != null) {
                return inetAddress.hashCode() + this.port;
            }
            String str = this.hostname;
            if (str != null) {
                return str.toLowerCase().hashCode() + this.port;
            }
            return this.port;
        }
    }

    private static int checkPort(int port) {
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("port out of range:" + port);
        }
        return port;
    }

    private static String checkHost(String hostname) {
        if (hostname == null) {
            throw new IllegalArgumentException("hostname can't be null");
        }
        return hostname;
    }

    public InetSocketAddress() {
        this.holder = new InetSocketAddressHolder(null, 0 == true ? 1 : 0, 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InetSocketAddress(int port) {
        this((InetAddress) null, port);
    }

    public InetSocketAddress(InetAddress inetAddress, int i10) {
        this.holder = new InetSocketAddressHolder(null, inetAddress == null ? Inet6Address.ANY : inetAddress, checkPort(i10));
    }

    public InetSocketAddress(String hostname, int port) {
        checkHost(hostname);
        InetAddress addr = null;
        String host = null;
        try {
            addr = InetAddress.getByName(hostname);
        } catch (UnknownHostException e2) {
            host = hostname;
        }
        this.holder = new InetSocketAddressHolder(host, addr, checkPort(port));
    }

    private InetSocketAddress(int i10, String str) {
        this.holder = new InetSocketAddressHolder(str, null, i10);
    }

    public static InetSocketAddress createUnresolved(String host, int port) {
        return new InetSocketAddress(checkPort(port), checkHost(host));
    }

    static {
        Unsafe unsafe = Unsafe.getUnsafe();
        UNSAFE = unsafe;
        FIELDS_OFFSET = unsafe.objectFieldOffset(InetSocketAddress.class, "holder");
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField pfields = out.putFields();
        pfields.put("hostname", this.holder.hostname);
        pfields.put("addr", this.holder.addr);
        pfields.put("port", this.holder.port);
        out.writeFields();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField oisFields = in.readFields();
        String oisHostname = (String) oisFields.get("hostname", (Object) null);
        InetAddress oisAddr = (InetAddress) oisFields.get("addr", (Object) null);
        int oisPort = oisFields.get("port", -1);
        checkPort(oisPort);
        if (oisHostname == null && oisAddr == null) {
            throw new InvalidObjectException("hostname and addr can't both be null");
        }
        InetSocketAddressHolder h10 = new InetSocketAddressHolder(oisHostname, oisAddr, oisPort);
        UNSAFE.putReference(this, FIELDS_OFFSET, h10);
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Stream data required");
    }

    public final int getPort() {
        return this.holder.getPort();
    }

    public final InetAddress getAddress() {
        return this.holder.getAddress();
    }

    public final String getHostName() {
        return this.holder.getHostName();
    }

    public final String getHostString() {
        return this.holder.getHostString();
    }

    public final boolean isUnresolved() {
        return this.holder.isUnresolved();
    }

    public String toString() {
        return this.holder.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof InetSocketAddress)) {
            return false;
        }
        return this.holder.equals(((InetSocketAddress) obj).holder);
    }

    public final int hashCode() {
        return this.holder.hashCode();
    }
}
