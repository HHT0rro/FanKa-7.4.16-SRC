package okhttp3;

import com.android.internal.logging.nano.MetricsProto;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Route.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Route {

    @NotNull
    private final Address address;

    @NotNull
    private final Proxy proxy;

    @NotNull
    private final InetSocketAddress socketAddress;

    public Route(@NotNull Address address, @NotNull Proxy proxy, @NotNull InetSocketAddress socketAddress) {
        s.i(address, "address");
        s.i(proxy, "proxy");
        s.i(socketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    @NotNull
    /* renamed from: -deprecated_address, reason: not valid java name */
    public final Address m3723deprecated_address() {
        return this.address;
    }

    @NotNull
    /* renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m3724deprecated_proxy() {
        return this.proxy;
    }

    @NotNull
    /* renamed from: -deprecated_socketAddress, reason: not valid java name */
    public final InetSocketAddress m3725deprecated_socketAddress() {
        return this.socketAddress;
    }

    @NotNull
    public final Address address() {
        return this.address;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (s.d(route.address, this.address) && s.d(route.proxy, this.proxy) && s.d(route.socketAddress, this.socketAddress)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.socketAddress.hashCode();
    }

    @NotNull
    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        return this.address.sslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    @NotNull
    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    @NotNull
    public String toString() {
        return "Route{" + ((Object) this.socketAddress) + '}';
    }
}
