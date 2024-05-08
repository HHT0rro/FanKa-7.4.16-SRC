package com.tencent.cloud.huiyansdkface.okhttp3;

import com.alipay.sdk.util.i;
import com.android.internal.logging.nano.MetricsProto;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Route {

    /* renamed from: a, reason: collision with root package name */
    public final Address f41588a;

    /* renamed from: b, reason: collision with root package name */
    public final Proxy f41589b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f41590c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(address, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        this.f41588a = address;
        this.f41589b = proxy;
        this.f41590c = inetSocketAddress;
    }

    public Address address() {
        return this.f41588a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (route.f41588a.equals(this.f41588a) && route.f41589b.equals(this.f41589b) && route.f41590c.equals(this.f41590c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f41588a.hashCode()) * 31) + this.f41589b.hashCode()) * 31) + this.f41590c.hashCode();
    }

    public Proxy proxy() {
        return this.f41589b;
    }

    public boolean requiresTunnel() {
        return this.f41588a.f41229i != null && this.f41589b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress socketAddress() {
        return this.f41590c;
    }

    public String toString() {
        return "Route{" + ((Object) this.f41590c) + i.f4738d;
    }
}
