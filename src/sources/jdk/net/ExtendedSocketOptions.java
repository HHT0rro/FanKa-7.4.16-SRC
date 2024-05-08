package jdk.net;

import java.io.FileDescriptor;
import java.net.SocketException;
import java.net.SocketOption;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import jdk.internal.misc.JavaIOFileDescriptorAccess;
import jdk.internal.misc.SharedSecrets;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ExtendedSocketOptions {
    private static final Set<SocketOption<?>> extendedOptions;
    private static final JavaIOFileDescriptorAccess fdAccess;
    private static final boolean flowSupported;
    private static final boolean keepAliveOptSupported;
    private static final PlatformSocketOptions platformSocketOptions;
    private static final boolean quickAckSupported;
    public static final SocketOption<SocketFlow> SO_FLOW_SLA = new ExtSocketOption("SO_FLOW_SLA", SocketFlow.class);
    public static final SocketOption<Boolean> TCP_QUICKACK = new ExtSocketOption("TCP_QUICKACK", Boolean.class);
    public static final SocketOption<Integer> TCP_KEEPIDLE = new ExtSocketOption("TCP_KEEPIDLE", Integer.class);
    public static final SocketOption<Integer> TCP_KEEPINTERVAL = new ExtSocketOption("TCP_KEEPINTERVAL", Integer.class);
    public static final SocketOption<Integer> TCP_KEEPCOUNT = new ExtSocketOption("TCP_KEEPCOUNT", Integer.class);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class ExtSocketOption<T> implements SocketOption<T> {
        private final String name;
        private final Class<T> type;

        ExtSocketOption(String name, Class<T> type) {
            this.name = name;
            this.type = type;
        }

        @Override // java.net.SocketOption
        public String name() {
            return this.name;
        }

        @Override // java.net.SocketOption
        public Class<T> type() {
            return this.type;
        }

        public String toString() {
            return this.name;
        }
    }

    private ExtendedSocketOptions() {
    }

    static {
        PlatformSocketOptions platformSocketOptions2 = PlatformSocketOptions.get();
        platformSocketOptions = platformSocketOptions2;
        flowSupported = platformSocketOptions2.flowSupported();
        quickAckSupported = platformSocketOptions2.quickAckSupported();
        keepAliveOptSupported = platformSocketOptions2.keepAliveOptionsSupported();
        Set<SocketOption<?>> options = options();
        extendedOptions = options;
        sun.net.ext.ExtendedSocketOptions.register(new sun.net.ext.ExtendedSocketOptions(options) { // from class: jdk.net.ExtendedSocketOptions.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // sun.net.ext.ExtendedSocketOptions
            public void setOption(FileDescriptor fd2, SocketOption<?> option, Object value) throws SocketException {
                SecurityManager sm = System.getSecurityManager();
                if (sm != null) {
                    sm.checkPermission(new NetworkPermission("setOption." + option.name()));
                }
                if (fd2 == null || !fd2.valid()) {
                    throw new SocketException("socket closed");
                }
                if (option == ExtendedSocketOptions.SO_FLOW_SLA) {
                    SocketFlow flow = (SocketFlow) ExtendedSocketOptions.checkValueType(value, option.type());
                    ExtendedSocketOptions.setFlowOption(fd2, flow);
                    return;
                }
                if (option == ExtendedSocketOptions.TCP_QUICKACK) {
                    ExtendedSocketOptions.setQuickAckOption(fd2, ((Boolean) value).booleanValue());
                    return;
                }
                if (option == ExtendedSocketOptions.TCP_KEEPCOUNT) {
                    ExtendedSocketOptions.setTcpkeepAliveProbes(fd2, ((Integer) value).intValue());
                } else if (option == ExtendedSocketOptions.TCP_KEEPIDLE) {
                    ExtendedSocketOptions.setTcpKeepAliveTime(fd2, ((Integer) value).intValue());
                } else {
                    if (option == ExtendedSocketOptions.TCP_KEEPINTERVAL) {
                        ExtendedSocketOptions.setTcpKeepAliveIntvl(fd2, ((Integer) value).intValue());
                        return;
                    }
                    throw new InternalError("Unexpected option " + ((Object) option));
                }
            }

            @Override // sun.net.ext.ExtendedSocketOptions
            public Object getOption(FileDescriptor fd2, SocketOption<?> option) throws SocketException {
                SecurityManager sm = System.getSecurityManager();
                if (sm != null) {
                    sm.checkPermission(new NetworkPermission("getOption." + option.name()));
                }
                if (fd2 == null || !fd2.valid()) {
                    throw new SocketException("socket closed");
                }
                if (option == ExtendedSocketOptions.SO_FLOW_SLA) {
                    SocketFlow flow = SocketFlow.create();
                    ExtendedSocketOptions.getFlowOption(fd2, flow);
                    return flow;
                }
                if (option == ExtendedSocketOptions.TCP_QUICKACK) {
                    return ExtendedSocketOptions.getQuickAckOption(fd2);
                }
                if (option == ExtendedSocketOptions.TCP_KEEPCOUNT) {
                    return Integer.valueOf(ExtendedSocketOptions.getTcpkeepAliveProbes(fd2));
                }
                if (option == ExtendedSocketOptions.TCP_KEEPIDLE) {
                    return Integer.valueOf(ExtendedSocketOptions.getTcpKeepAliveTime(fd2));
                }
                if (option == ExtendedSocketOptions.TCP_KEEPINTERVAL) {
                    return Integer.valueOf(ExtendedSocketOptions.getTcpKeepAliveIntvl(fd2));
                }
                throw new InternalError("Unexpected option " + ((Object) option));
            }
        });
        fdAccess = SharedSecrets.getJavaIOFileDescriptorAccess();
    }

    static Set<SocketOption<?>> options() {
        Set<SocketOption<?>> options = new HashSet<>();
        if (flowSupported) {
            options.add(SO_FLOW_SLA);
        }
        if (quickAckSupported) {
            options.add(TCP_QUICKACK);
        }
        if (keepAliveOptSupported) {
            options.addAll(Set.of(TCP_KEEPCOUNT, TCP_KEEPIDLE, TCP_KEEPINTERVAL));
        }
        return Collections.unmodifiableSet(options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T checkValueType(Object obj, Class<?> type) {
        if (!type.isAssignableFrom(obj.getClass())) {
            String s2 = "Found: " + ((Object) obj.getClass()) + ", Expected: " + ((Object) type);
            throw new IllegalArgumentException(s2);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setFlowOption(FileDescriptor fd2, SocketFlow f10) throws SocketException {
        int status = platformSocketOptions.setFlowOption(fdAccess.get(fd2), f10.priority(), f10.bandwidth());
        f10.status(status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getFlowOption(FileDescriptor fd2, SocketFlow f10) throws SocketException {
        int status = platformSocketOptions.getFlowOption(fdAccess.get(fd2), f10);
        f10.status(status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setQuickAckOption(FileDescriptor fd2, boolean enable) throws SocketException {
        platformSocketOptions.setQuickAck(fdAccess.get(fd2), enable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getQuickAckOption(FileDescriptor fd2) throws SocketException {
        return Boolean.valueOf(platformSocketOptions.getQuickAck(fdAccess.get(fd2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setTcpkeepAliveProbes(FileDescriptor fd2, int value) throws SocketException {
        platformSocketOptions.setTcpkeepAliveProbes(fdAccess.get(fd2), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setTcpKeepAliveTime(FileDescriptor fd2, int value) throws SocketException {
        platformSocketOptions.setTcpKeepAliveTime(fdAccess.get(fd2), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setTcpKeepAliveIntvl(FileDescriptor fd2, int value) throws SocketException {
        platformSocketOptions.setTcpKeepAliveIntvl(fdAccess.get(fd2), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getTcpkeepAliveProbes(FileDescriptor fd2) throws SocketException {
        return platformSocketOptions.getTcpkeepAliveProbes(fdAccess.get(fd2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getTcpKeepAliveTime(FileDescriptor fd2) throws SocketException {
        return platformSocketOptions.getTcpKeepAliveTime(fdAccess.get(fd2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getTcpKeepAliveIntvl(FileDescriptor fd2) throws SocketException {
        return platformSocketOptions.getTcpKeepAliveIntvl(fdAccess.get(fd2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class PlatformSocketOptions {
        private static final PlatformSocketOptions instance = create();

        protected PlatformSocketOptions() {
        }

        private static PlatformSocketOptions newInstance(String cn2) {
            try {
                return (PlatformSocketOptions) Class.forName(cn2).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ReflectiveOperationException x10) {
                throw new AssertionError(x10);
            }
        }

        private static PlatformSocketOptions create() {
            return new PlatformSocketOptions();
        }

        static PlatformSocketOptions get() {
            return instance;
        }

        int setFlowOption(int fd2, int priority, long bandwidth) throws SocketException {
            throw new UnsupportedOperationException("unsupported socket option");
        }

        int getFlowOption(int fd2, SocketFlow f10) throws SocketException {
            throw new UnsupportedOperationException("unsupported socket option");
        }

        boolean flowSupported() {
            return false;
        }

        void setQuickAck(int fd2, boolean on) throws SocketException {
            throw new UnsupportedOperationException("unsupported TCP_QUICKACK option");
        }

        boolean getQuickAck(int fd2) throws SocketException {
            throw new UnsupportedOperationException("unsupported TCP_QUICKACK option");
        }

        boolean quickAckSupported() {
            return false;
        }

        boolean keepAliveOptionsSupported() {
            return false;
        }

        void setTcpkeepAliveProbes(int fd2, int value) throws SocketException {
            throw new UnsupportedOperationException("unsupported TCP_KEEPCNT option");
        }

        void setTcpKeepAliveTime(int fd2, int value) throws SocketException {
            throw new UnsupportedOperationException("unsupported TCP_KEEPIDLE option");
        }

        void setTcpKeepAliveIntvl(int fd2, int value) throws SocketException {
            throw new UnsupportedOperationException("unsupported TCP_KEEPINTVL option");
        }

        int getTcpkeepAliveProbes(int fd2) throws SocketException {
            throw new UnsupportedOperationException("unsupported TCP_KEEPCNT option");
        }

        int getTcpKeepAliveTime(int fd2) throws SocketException {
            throw new UnsupportedOperationException("unsupported TCP_KEEPIDLE option");
        }

        int getTcpKeepAliveIntvl(int fd2) throws SocketException {
            throw new UnsupportedOperationException("unsupported TCP_KEEPINTVL option");
        }
    }
}
