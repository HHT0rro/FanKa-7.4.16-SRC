package java.net;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Proxy {
    public static final Proxy NO_PROXY = new Proxy();

    /* renamed from: sa, reason: collision with root package name */
    private SocketAddress f50369sa;
    private Type type;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Type {
        DIRECT,
        HTTP,
        SOCKS
    }

    private Proxy() {
        this.type = Type.DIRECT;
        this.f50369sa = null;
    }

    public Proxy(Type type, SocketAddress sa2) {
        if (type == Type.DIRECT || !(sa2 instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("type " + ((Object) type) + " is not compatible with address " + ((Object) sa2));
        }
        this.type = type;
        this.f50369sa = sa2;
    }

    public Type type() {
        return this.type;
    }

    public SocketAddress address() {
        return this.f50369sa;
    }

    public String toString() {
        if (type() == Type.DIRECT) {
            return "DIRECT";
        }
        return ((Object) type()) + " @ " + ((Object) address());
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Proxy)) {
            return false;
        }
        Proxy p10 = (Proxy) obj;
        if (p10.type() != type()) {
            return false;
        }
        if (address() == null) {
            return p10.address() == null;
        }
        return address().equals(p10.address());
    }

    public final int hashCode() {
        if (address() == null) {
            return type().hashCode();
        }
        return type().hashCode() + address().hashCode();
    }
}
