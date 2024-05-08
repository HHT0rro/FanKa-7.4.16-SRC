package sun.net.spi.nameservice;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface NameService {
    String getHostByAddr(byte[] bArr) throws UnknownHostException;

    InetAddress[] lookupAllHostAddr(String str, int i10) throws UnknownHostException;
}
