package java.net;

import java.io.IOException;
import java.util.List;
import sun.security.util.SecurityConstants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ProxySelector {
    private static ProxySelector theProxySelector;

    public abstract void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException);

    public abstract List<Proxy> select(URI uri);

    static {
        try {
            Class<?> c4 = Class.forName("sun.net.spi.DefaultProxySelector");
            if (c4 != null && ProxySelector.class.isAssignableFrom(c4)) {
                theProxySelector = (ProxySelector) c4.newInstance();
            }
        } catch (Exception e2) {
            theProxySelector = null;
        }
    }

    public static ProxySelector getDefault() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(SecurityConstants.GET_PROXYSELECTOR_PERMISSION);
        }
        return theProxySelector;
    }

    public static void setDefault(ProxySelector ps) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(SecurityConstants.SET_PROXYSELECTOR_PERMISSION);
        }
        theProxySelector = ps;
    }
}
