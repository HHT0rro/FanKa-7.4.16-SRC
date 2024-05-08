package javax.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SocketFactory {
    private static SocketFactory theFactory;

    public abstract Socket createSocket(String str, int i10) throws IOException, UnknownHostException;

    public abstract Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) throws IOException, UnknownHostException;

    public abstract Socket createSocket(InetAddress inetAddress, int i10) throws IOException;

    public abstract Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) throws IOException;

    public static SocketFactory getDefault() {
        synchronized (SocketFactory.class) {
            if (theFactory == null) {
                theFactory = new DefaultSocketFactory();
            }
        }
        return theFactory;
    }

    public static void setDefault(SocketFactory factory) {
        synchronized (SocketFactory.class) {
            theFactory = factory;
        }
    }

    public Socket createSocket() throws IOException {
        UnsupportedOperationException uop = new UnsupportedOperationException();
        SocketException se = new SocketException("Unconnected sockets not implemented");
        se.initCause(uop);
        throw se;
    }
}
