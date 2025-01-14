package java.net;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import sun.security.util.SecurityConstants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CookieHandler {
    private static CookieHandler cookieHandler;

    public abstract Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException;

    public abstract void put(URI uri, Map<String, List<String>> map) throws IOException;

    public static synchronized CookieHandler getDefault() {
        CookieHandler cookieHandler2;
        synchronized (CookieHandler.class) {
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkPermission(SecurityConstants.GET_COOKIEHANDLER_PERMISSION);
            }
            cookieHandler2 = cookieHandler;
        }
        return cookieHandler2;
    }

    public static synchronized void setDefault(CookieHandler cHandler) {
        synchronized (CookieHandler.class) {
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkPermission(SecurityConstants.SET_COOKIEHANDLER_PERMISSION);
            }
            cookieHandler = cHandler;
        }
    }
}
