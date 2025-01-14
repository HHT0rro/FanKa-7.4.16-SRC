package java.net;

import android.system.OsConstants;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.ObjectStreamException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Inet4Address extends InetAddress {
    static final int INADDRSZ = 4;
    private static final long serialVersionUID = 3286316764910316507L;
    public static final InetAddress ANY = new Inet4Address((String) null, new byte[]{0, 0, 0, 0});
    public static final InetAddress ALL = new Inet4Address((String) null, new byte[]{-1, -1, -1, -1});
    public static final InetAddress LOOPBACK = new Inet4Address("localhost", new byte[]{Byte.MAX_VALUE, 0, 0, 1});

    Inet4Address() {
        holder().hostName = null;
        holder().address = 0;
        holder().family = OsConstants.AF_INET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Inet4Address(String hostName, byte[] addr) {
        holder().hostName = hostName;
        holder().family = OsConstants.AF_INET;
        if (addr != null && addr.length == 4) {
            int address = addr[3] & 255;
            holder().address = address | ((addr[2] << 8) & 65280) | ((addr[1] << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((addr[0] << 24) & (-16777216));
        }
        holder().originalHostName = hostName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Inet4Address(String hostName, int address) {
        holder().hostName = hostName;
        holder().family = OsConstants.AF_INET;
        holder().address = address;
        holder().originalHostName = hostName;
    }

    private Object writeReplace() throws ObjectStreamException {
        InetAddress inet = new InetAddress();
        inet.holder().hostName = holder().getHostName();
        inet.holder().address = holder().getAddress();
        inet.holder().family = 2;
        return inet;
    }

    @Override // java.net.InetAddress
    public boolean isMulticastAddress() {
        return (holder().getAddress() & (-268435456)) == -536870912;
    }

    @Override // java.net.InetAddress
    public boolean isAnyLocalAddress() {
        return holder().getAddress() == 0;
    }

    @Override // java.net.InetAddress
    public boolean isLoopbackAddress() {
        byte[] byteAddr = getAddress();
        return byteAddr[0] == Byte.MAX_VALUE;
    }

    @Override // java.net.InetAddress
    public boolean isLinkLocalAddress() {
        int address = holder().getAddress();
        return ((address >>> 24) & 255) == 169 && ((address >>> 16) & 255) == 254;
    }

    @Override // java.net.InetAddress
    public boolean isSiteLocalAddress() {
        int address = holder().getAddress();
        return ((address >>> 24) & 255) == 10 || (((address >>> 24) & 255) == 172 && ((address >>> 16) & 240) == 16) || (((address >>> 24) & 255) == 192 && ((address >>> 16) & 255) == 168);
    }

    @Override // java.net.InetAddress
    public boolean isMCGlobal() {
        byte[] byteAddr = getAddress();
        if ((byteAddr[0] & 255) < 224 || (byteAddr[0] & 255) > 238) {
            return false;
        }
        return ((byteAddr[0] & 255) == 224 && byteAddr[1] == 0 && byteAddr[2] == 0) ? false : true;
    }

    @Override // java.net.InetAddress
    public boolean isMCNodeLocal() {
        return false;
    }

    @Override // java.net.InetAddress
    public boolean isMCLinkLocal() {
        int address = holder().getAddress();
        return ((address >>> 24) & 255) == 224 && ((address >>> 16) & 255) == 0 && ((address >>> 8) & 255) == 0;
    }

    @Override // java.net.InetAddress
    public boolean isMCSiteLocal() {
        int address = holder().getAddress();
        return ((address >>> 24) & 255) == 239 && ((address >>> 16) & 255) == 255;
    }

    @Override // java.net.InetAddress
    public boolean isMCOrgLocal() {
        int address = holder().getAddress();
        return ((address >>> 24) & 255) == 239 && ((address >>> 16) & 255) >= 192 && ((address >>> 16) & 255) <= 195;
    }

    @Override // java.net.InetAddress
    public byte[] getAddress() {
        int address = holder().getAddress();
        byte[] addr = {(byte) ((address >>> 24) & 255), (byte) ((address >>> 16) & 255), (byte) ((address >>> 8) & 255), (byte) (address & 255)};
        return addr;
    }

    @Override // java.net.InetAddress
    public String getHostAddress() {
        return numericToTextFormat(getAddress());
    }

    @Override // java.net.InetAddress
    public int hashCode() {
        return holder().getAddress();
    }

    @Override // java.net.InetAddress
    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Inet4Address) && ((InetAddress) obj).holder().getAddress() == holder().getAddress();
    }

    static String numericToTextFormat(byte[] src) {
        return (src[0] & 255) + "." + (src[1] & 255) + "." + (src[2] & 255) + "." + (src[3] & 255);
    }
}
