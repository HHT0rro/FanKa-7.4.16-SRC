package sun.net;

import java.net.SocketException;
import java.security.AccessController;
import java.util.concurrent.atomic.AtomicInteger;
import sun.security.action.GetPropertyAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ResourceManager {
    private static final int DEFAULT_MAX_SOCKETS = 25;
    private static final int maxSockets;
    private static final AtomicInteger numSockets;

    static {
        String prop = (String) AccessController.doPrivileged(new GetPropertyAction("sun.net.maxDatagramSockets"));
        int defmax = 25;
        if (prop != null) {
            try {
                defmax = Integer.parseInt(prop);
            } catch (NumberFormatException e2) {
            }
        }
        maxSockets = defmax;
        numSockets = new AtomicInteger(0);
    }

    public static void beforeUdpCreate() throws SocketException {
        if (System.getSecurityManager() != null) {
            AtomicInteger atomicInteger = numSockets;
            if (atomicInteger.incrementAndGet() > maxSockets) {
                atomicInteger.decrementAndGet();
                throw new SocketException("maximum number of DatagramSockets reached");
            }
        }
    }

    public static void afterUdpClose() {
        if (System.getSecurityManager() != null) {
            numSockets.decrementAndGet();
        }
    }
}
