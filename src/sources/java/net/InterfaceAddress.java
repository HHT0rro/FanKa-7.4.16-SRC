package java.net;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class InterfaceAddress {
    private InetAddress address;
    private Inet4Address broadcast;
    private short maskLength;

    InterfaceAddress() {
        this.address = null;
        this.broadcast = null;
        this.maskLength = (short) 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterfaceAddress(InetAddress address, Inet4Address broadcast, InetAddress netmask) {
        this.address = null;
        this.broadcast = null;
        this.maskLength = (short) 0;
        this.address = address;
        this.broadcast = broadcast;
        this.maskLength = countPrefixLength(netmask);
    }

    private short countPrefixLength(InetAddress netmask) {
        short count = 0;
        for (byte b4 : netmask.getAddress()) {
            while (b4 != 0) {
                b4 = (byte) (b4 << 1);
                count = (short) (count + 1);
            }
        }
        return count;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public InetAddress getBroadcast() {
        return this.broadcast;
    }

    public short getNetworkPrefixLength() {
        return this.maskLength;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InterfaceAddress)) {
            return false;
        }
        InterfaceAddress cmp = (InterfaceAddress) obj;
        InetAddress inetAddress = this.address;
        if (inetAddress != null ? !inetAddress.equals(cmp.address) : cmp.address != null) {
            return false;
        }
        Inet4Address inet4Address = this.broadcast;
        if (inet4Address != null ? inet4Address.equals(cmp.broadcast) : cmp.broadcast == null) {
            return this.maskLength == cmp.maskLength;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.address.hashCode();
        Inet4Address inet4Address = this.broadcast;
        return hashCode + (inet4Address != null ? inet4Address.hashCode() : 0) + this.maskLength;
    }

    public String toString() {
        return ((Object) this.address) + "/" + ((int) this.maskLength) + " [" + ((Object) this.broadcast) + "]";
    }
}
