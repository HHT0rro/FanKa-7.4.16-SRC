package jdk.net;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.DatagramSocket;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import sun.net.ExtendedOptionsImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Sockets {
    private static Method dsiGetOption;
    private static Method dsiSetOption;
    private static final HashMap<Class<?>, Set<SocketOption<?>>> options = new HashMap<>();
    private static Method siGetOption;
    private static Method siSetOption;

    static {
        initOptionSets();
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: jdk.net.Sockets.1
            @Override // java.security.PrivilegedAction
            public Void run() {
                Sockets.initMethods();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initMethods() {
        try {
            Class<?> clazz = Class.forName("java.net.SocketSecrets");
            Method declaredMethod = clazz.getDeclaredMethod("setOption", Object.class, SocketOption.class, Object.class);
            siSetOption = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = clazz.getDeclaredMethod("getOption", Object.class, SocketOption.class);
            siGetOption = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = clazz.getDeclaredMethod("setOption", DatagramSocket.class, SocketOption.class, Object.class);
            dsiSetOption = declaredMethod3;
            declaredMethod3.setAccessible(true);
            Method declaredMethod4 = clazz.getDeclaredMethod("getOption", DatagramSocket.class, SocketOption.class);
            dsiGetOption = declaredMethod4;
            declaredMethod4.setAccessible(true);
        } catch (ReflectiveOperationException e2) {
            throw new InternalError(e2);
        }
    }

    private static <T> void invokeSet(Method method, Object socket, SocketOption<T> option, T value) throws IOException {
        try {
            method.invoke(null, socket, option, value);
        } catch (Exception e2) {
            if (e2 instanceof InvocationTargetException) {
                Throwable t2 = ((InvocationTargetException) e2).getTargetException();
                if (t2 instanceof IOException) {
                    throw ((IOException) t2);
                }
                if (t2 instanceof RuntimeException) {
                    throw ((RuntimeException) t2);
                }
            }
            throw new RuntimeException(e2);
        }
    }

    private static <T> T invokeGet(Method method, Object obj, SocketOption<T> socketOption) throws IOException {
        try {
            return (T) method.invoke(null, obj, socketOption);
        } catch (Exception e2) {
            if (e2 instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) e2).getTargetException();
                if (targetException instanceof IOException) {
                    throw ((IOException) targetException);
                }
                if (targetException instanceof RuntimeException) {
                    throw ((RuntimeException) targetException);
                }
            }
            throw new RuntimeException(e2);
        }
    }

    private Sockets() {
    }

    public static <T> void setOption(Socket s2, SocketOption<T> name, T value) throws IOException {
        if (!isSupported(Socket.class, name)) {
            throw new UnsupportedOperationException(name.name());
        }
        invokeSet(siSetOption, s2, name, value);
    }

    public static <T> T getOption(Socket socket, SocketOption<T> socketOption) throws IOException {
        if (!isSupported(Socket.class, socketOption)) {
            throw new UnsupportedOperationException(socketOption.name());
        }
        return (T) invokeGet(siGetOption, socket, socketOption);
    }

    public static <T> void setOption(ServerSocket s2, SocketOption<T> name, T value) throws IOException {
        if (!isSupported(ServerSocket.class, name)) {
            throw new UnsupportedOperationException(name.name());
        }
        invokeSet(siSetOption, s2, name, value);
    }

    public static <T> T getOption(ServerSocket serverSocket, SocketOption<T> socketOption) throws IOException {
        if (!isSupported(ServerSocket.class, socketOption)) {
            throw new UnsupportedOperationException(socketOption.name());
        }
        return (T) invokeGet(siGetOption, serverSocket, socketOption);
    }

    public static <T> void setOption(DatagramSocket s2, SocketOption<T> name, T value) throws IOException {
        if (!isSupported(s2.getClass(), name)) {
            throw new UnsupportedOperationException(name.name());
        }
        invokeSet(dsiSetOption, s2, name, value);
    }

    public static <T> T getOption(DatagramSocket datagramSocket, SocketOption<T> socketOption) throws IOException {
        if (!isSupported(datagramSocket.getClass(), socketOption)) {
            throw new UnsupportedOperationException(socketOption.name());
        }
        return (T) invokeGet(dsiGetOption, datagramSocket, socketOption);
    }

    public static Set<SocketOption<?>> supportedOptions(Class<?> socketType) {
        Set<SocketOption<?>> set = options.get(socketType);
        if (set == null) {
            throw new IllegalArgumentException("unknown socket type");
        }
        return set;
    }

    private static boolean isSupported(Class<?> type, SocketOption<?> option) {
        Set<SocketOption<?>> options2 = supportedOptions(type);
        return options2.contains(option);
    }

    private static void initOptionSets() {
        boolean flowsupported = ExtendedOptionsImpl.flowSupported();
        Set<SocketOption<?>> set = new HashSet<>();
        set.add(StandardSocketOptions.SO_KEEPALIVE);
        set.add(StandardSocketOptions.SO_SNDBUF);
        set.add(StandardSocketOptions.SO_RCVBUF);
        set.add(StandardSocketOptions.SO_REUSEADDR);
        set.add(StandardSocketOptions.SO_LINGER);
        set.add(StandardSocketOptions.IP_TOS);
        set.add(StandardSocketOptions.TCP_NODELAY);
        if (flowsupported) {
            set.add(ExtendedSocketOptions.SO_FLOW_SLA);
        }
        Set<SocketOption<?>> set2 = Collections.unmodifiableSet(set);
        HashMap<Class<?>, Set<SocketOption<?>>> hashMap = options;
        hashMap.put(Socket.class, set2);
        Set<SocketOption<?>> set3 = new HashSet<>();
        set3.add(StandardSocketOptions.SO_RCVBUF);
        set3.add(StandardSocketOptions.SO_REUSEADDR);
        set3.add(StandardSocketOptions.IP_TOS);
        hashMap.put(ServerSocket.class, Collections.unmodifiableSet(set3));
        Set<SocketOption<?>> set4 = new HashSet<>();
        set4.add(StandardSocketOptions.SO_SNDBUF);
        set4.add(StandardSocketOptions.SO_RCVBUF);
        set4.add(StandardSocketOptions.SO_REUSEADDR);
        set4.add(StandardSocketOptions.IP_TOS);
        if (flowsupported) {
            set4.add(ExtendedSocketOptions.SO_FLOW_SLA);
        }
        hashMap.put(DatagramSocket.class, Collections.unmodifiableSet(set4));
        Set<SocketOption<?>> set5 = new HashSet<>();
        set5.add(StandardSocketOptions.SO_SNDBUF);
        set5.add(StandardSocketOptions.SO_RCVBUF);
        set5.add(StandardSocketOptions.SO_REUSEADDR);
        set5.add(StandardSocketOptions.IP_TOS);
        set5.add(StandardSocketOptions.IP_MULTICAST_IF);
        set5.add(StandardSocketOptions.IP_MULTICAST_TTL);
        set5.add(StandardSocketOptions.IP_MULTICAST_LOOP);
        if (flowsupported) {
            set5.add(ExtendedSocketOptions.SO_FLOW_SLA);
        }
        hashMap.put(MulticastSocket.class, Collections.unmodifiableSet(set5));
    }
}
