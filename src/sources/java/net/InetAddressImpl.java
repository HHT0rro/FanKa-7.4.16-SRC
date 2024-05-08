package java.net;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface InetAddressImpl {
    InetAddress anyLocalAddress();

    void clearAddressCache();

    String getHostByAddr(byte[] bArr) throws UnknownHostException;

    boolean isReachable(InetAddress inetAddress, int i10, NetworkInterface networkInterface, int i11) throws IOException;

    InetAddress[] lookupAllHostAddr(String str, int i10) throws UnknownHostException;

    InetAddress[] loopbackAddresses();
}
