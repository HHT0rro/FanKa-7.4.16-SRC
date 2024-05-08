package java.net;

import java.security.AccessController;
import sun.security.action.GetPropertyAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DefaultDatagramSocketImplFactory {
    static Class<?> prefixImplClass;

    DefaultDatagramSocketImplFactory() {
    }

    static {
        prefixImplClass = null;
        String prefix = null;
        try {
            prefix = (String) AccessController.doPrivileged(new GetPropertyAction("impl.prefix", null));
            if (prefix != null) {
                prefixImplClass = Class.forName("java.net." + prefix + "DatagramSocketImpl");
            }
        } catch (Exception e2) {
            System.err.println("Can't find class: java.net." + prefix + "DatagramSocketImpl: check impl.prefix property");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DatagramSocketImpl createDatagramSocketImpl(boolean isMulticast) throws SocketException {
        Class<?> cls = prefixImplClass;
        if (cls != null) {
            try {
                return (DatagramSocketImpl) cls.newInstance();
            } catch (Exception e2) {
                throw new SocketException("can't instantiate DatagramSocketImpl");
            }
        }
        return new PlainDatagramSocketImpl();
    }
}
