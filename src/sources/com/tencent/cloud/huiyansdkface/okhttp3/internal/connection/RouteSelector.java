package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.huawei.openalliance.ad.constant.u;
import com.tencent.cloud.huiyansdkface.okhttp3.Address;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Route;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RouteSelector {

    /* renamed from: a, reason: collision with root package name */
    private final Address f41730a;

    /* renamed from: b, reason: collision with root package name */
    private final RouteDatabase f41731b;

    /* renamed from: c, reason: collision with root package name */
    private final Call f41732c;

    /* renamed from: d, reason: collision with root package name */
    private final EventListener f41733d;

    /* renamed from: f, reason: collision with root package name */
    private int f41735f;

    /* renamed from: e, reason: collision with root package name */
    private List<Proxy> f41734e = Collections.emptyList();

    /* renamed from: g, reason: collision with root package name */
    private List<InetSocketAddress> f41736g = Collections.emptyList();

    /* renamed from: h, reason: collision with root package name */
    private final List<Route> f41737h = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Selection {

        /* renamed from: a, reason: collision with root package name */
        private final List<Route> f41738a;

        /* renamed from: b, reason: collision with root package name */
        private int f41739b = 0;

        public Selection(List<Route> list) {
            this.f41738a = list;
        }

        public List<Route> getAll() {
            return new ArrayList(this.f41738a);
        }

        public boolean hasNext() {
            return this.f41739b < this.f41738a.size();
        }

        public Route next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            List<Route> list = this.f41738a;
            int i10 = this.f41739b;
            this.f41739b = i10 + 1;
            return list.get(i10);
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        this.f41730a = address;
        this.f41731b = routeDatabase;
        this.f41732c = call;
        this.f41733d = eventListener;
        a(address.url(), address.proxy());
    }

    public static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void a(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> immutableList;
        if (proxy != null) {
            immutableList = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f41730a.proxySelector().select(httpUrl.uri());
            immutableList = (select == null || select.isEmpty()) ? Util.immutableList(Proxy.NO_PROXY) : Util.immutableList(select);
        }
        this.f41734e = immutableList;
        this.f41735f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String host;
        int port;
        this.f41736g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            host = this.f41730a.url().host();
            port = this.f41730a.url().port();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + ((Object) address.getClass()));
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            host = a(inetSocketAddress);
            port = inetSocketAddress.getPort();
        }
        if (port < 1 || port > 65535) {
            throw new SocketException("No route to " + host + u.bD + port + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f41736g.add(InetSocketAddress.createUnresolved(host, port));
            return;
        }
        this.f41733d.dnsStart(this.f41732c, host);
        List<InetAddress> lookup = this.f41730a.dns().lookup(host);
        if (lookup.isEmpty()) {
            throw new UnknownHostException(((Object) this.f41730a.dns()) + " returned no addresses for " + host);
        }
        this.f41733d.dnsEnd(this.f41732c, host, lookup);
        int size = lookup.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f41736g.add(new InetSocketAddress(lookup.get(i10), port));
        }
    }

    private boolean a() {
        return this.f41735f < this.f41734e.size();
    }

    private Proxy b() throws IOException {
        if (a()) {
            List<Proxy> list = this.f41734e;
            int i10 = this.f41735f;
            this.f41735f = i10 + 1;
            Proxy proxy = list.get(i10);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f41730a.url().host() + "; exhausted proxy configurations: " + ((Object) this.f41734e));
    }

    public void connectFailed(Route route, IOException iOException) {
        if (route.proxy().type() != Proxy.Type.DIRECT && this.f41730a.proxySelector() != null) {
            this.f41730a.proxySelector().connectFailed(this.f41730a.url().uri(), route.proxy().address(), iOException);
        }
        this.f41731b.failed(route);
    }

    public boolean hasNext() {
        return a() || !this.f41737h.isEmpty();
    }

    public Selection next() throws IOException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (a()) {
            Proxy b4 = b();
            int size = this.f41736g.size();
            for (int i10 = 0; i10 < size; i10++) {
                Route route = new Route(this.f41730a, b4, this.f41736g.get(i10));
                if (this.f41731b.shouldPostpone(route)) {
                    this.f41737h.add(route);
                } else {
                    arrayList.add(route);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f41737h);
            this.f41737h.clear();
        }
        return new Selection(arrayList);
    }
}
