package javax.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ServerSocketFactory {
    private static ServerSocketFactory theFactory;

    public abstract ServerSocket createServerSocket(int i10) throws IOException;

    public abstract ServerSocket createServerSocket(int i10, int i11) throws IOException;

    public abstract ServerSocket createServerSocket(int i10, int i11, InetAddress inetAddress) throws IOException;

    public static ServerSocketFactory getDefault() {
        synchronized (ServerSocketFactory.class) {
            if (theFactory == null) {
                theFactory = new DefaultServerSocketFactory();
            }
        }
        return theFactory;
    }

    public ServerSocket createServerSocket() throws IOException {
        throw new SocketException("Unbound server sockets not implemented");
    }
}
