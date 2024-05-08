package sun.net;

import java.io.FileDescriptor;
import java.net.SocketOption;
import jdk.net.NetworkPermission;
import jdk.net.SocketFlow;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ExtendedOptionsImpl {
    private ExtendedOptionsImpl() {
    }

    public static void checkSetOptionPermission(SocketOption<?> option) {
        SecurityManager sm = System.getSecurityManager();
        if (sm == null) {
            return;
        }
        String check = "setOption." + option.name();
        sm.checkPermission(new NetworkPermission(check));
    }

    public static void checkGetOptionPermission(SocketOption<?> option) {
        SecurityManager sm = System.getSecurityManager();
        if (sm == null) {
            return;
        }
        String check = "getOption." + option.name();
        sm.checkPermission(new NetworkPermission(check));
    }

    public static void checkValueType(Object value, Class<?> type) {
        if (!type.isAssignableFrom(value.getClass())) {
            String s2 = "Found: " + value.getClass().toString() + " Expected: " + type.toString();
            throw new IllegalArgumentException(s2);
        }
    }

    public static void setFlowOption(FileDescriptor fd2, SocketFlow f10) {
        throw new UnsupportedOperationException("unsupported socket option");
    }

    public static void getFlowOption(FileDescriptor fd2, SocketFlow f10) {
        throw new UnsupportedOperationException("unsupported socket option");
    }

    public static boolean flowSupported() {
        return false;
    }
}
