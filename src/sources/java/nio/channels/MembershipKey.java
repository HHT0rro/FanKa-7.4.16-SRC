package java.nio.channels;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class MembershipKey {
    public abstract MembershipKey block(InetAddress inetAddress) throws IOException;

    public abstract MulticastChannel channel();

    public abstract void drop();

    public abstract InetAddress group();

    public abstract boolean isValid();

    public abstract NetworkInterface networkInterface();

    public abstract InetAddress sourceAddress();

    public abstract MembershipKey unblock(InetAddress inetAddress);
}
