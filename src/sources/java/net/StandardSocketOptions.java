package java.net;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class StandardSocketOptions {
    public static final SocketOption<Boolean> SO_BROADCAST = new StdSocketOption("SO_BROADCAST", Boolean.class);
    public static final SocketOption<Boolean> SO_KEEPALIVE = new StdSocketOption("SO_KEEPALIVE", Boolean.class);
    public static final SocketOption<Integer> SO_SNDBUF = new StdSocketOption("SO_SNDBUF", Integer.class);
    public static final SocketOption<Integer> SO_RCVBUF = new StdSocketOption("SO_RCVBUF", Integer.class);
    public static final SocketOption<Boolean> SO_REUSEADDR = new StdSocketOption("SO_REUSEADDR", Boolean.class);
    public static final SocketOption<Boolean> SO_REUSEPORT = new StdSocketOption("SO_REUSEPORT", Boolean.class);
    public static final SocketOption<Integer> SO_LINGER = new StdSocketOption("SO_LINGER", Integer.class);
    public static final SocketOption<Integer> IP_TOS = new StdSocketOption("IP_TOS", Integer.class);
    public static final SocketOption<NetworkInterface> IP_MULTICAST_IF = new StdSocketOption("IP_MULTICAST_IF", NetworkInterface.class);
    public static final SocketOption<Integer> IP_MULTICAST_TTL = new StdSocketOption("IP_MULTICAST_TTL", Integer.class);
    public static final SocketOption<Boolean> IP_MULTICAST_LOOP = new StdSocketOption("IP_MULTICAST_LOOP", Boolean.class);
    public static final SocketOption<Boolean> TCP_NODELAY = new StdSocketOption("TCP_NODELAY", Boolean.class);

    private StandardSocketOptions() {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class StdSocketOption<T> implements SocketOption<T> {
        private final String name;
        private final Class<T> type;

        StdSocketOption(String name, Class<T> type) {
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
}
