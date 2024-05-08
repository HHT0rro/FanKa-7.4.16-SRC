package com.alibaba.security.common.http.ok.internal.connection;

import com.alibaba.security.common.http.ok.Address;
import com.alibaba.security.common.http.ok.EventListener;
import com.alibaba.security.common.http.ok.HttpUrl;
import com.alibaba.security.common.http.ok.RPCall;
import com.alibaba.security.common.http.ok.Route;
import com.alibaba.security.common.http.ok.internal.Util;
import com.huawei.openalliance.ad.constant.u;
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

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RouteSelector {
    private final Address address;
    private final RPCall call;
    private final EventListener eventListener;
    private int nextProxyIndex;
    private final RouteDatabase routeDatabase;
    private List<Proxy> proxies = Collections.emptyList();
    private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
    private final List<Route> postponedRoutes = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Selection {
        private int nextRouteIndex = 0;
        private final List<Route> routes;

        public Selection(List<Route> list) {
            this.routes = list;
        }

        public List<Route> getAll() {
            return new ArrayList(this.routes);
        }

        public boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        public Route next() {
            if (hasNext()) {
                List<Route> list = this.routes;
                int i10 = this.nextRouteIndex;
                this.nextRouteIndex = i10 + 1;
                return list.get(i10);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, RPCall rPCall, EventListener eventListener) {
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = rPCall;
        this.eventListener = eventListener;
        resetNextProxy(address.url(), address.proxy());
    }

    public static String getHostString(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    private boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List<Proxy> list = this.proxies;
            int i10 = this.nextProxyIndex;
            this.nextProxyIndex = i10 + 1;
            Proxy proxy = list.get(i10);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + ((Object) this.proxies));
    }

    private void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String host;
        int port;
        this.inetSocketAddresses = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                host = getHostString(inetSocketAddress);
                port = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + ((Object) address.getClass()));
            }
        } else {
            host = this.address.url().host();
            port = this.address.url().port();
        }
        if (port >= 1 && port <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.inetSocketAddresses.add(InetSocketAddress.createUnresolved(host, port));
                return;
            }
            this.eventListener.dnsStart(this.call, host);
            List<InetAddress> lookup = this.address.dns().lookup(host);
            if (!lookup.isEmpty()) {
                this.eventListener.dnsEnd(this.call, host, lookup);
                int size = lookup.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.inetSocketAddresses.add(new InetSocketAddress(lookup.get(i10), port));
                }
                return;
            }
            throw new UnknownHostException(((Object) this.address.dns()) + " returned no addresses for " + host);
        }
        throw new SocketException("No route to " + host + u.bD + port + "; port is out of range");
    }

    private void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> immutableList;
        if (proxy != null) {
            this.proxies = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.address.proxySelector().select(httpUrl.uri());
            if (select != null && !select.isEmpty()) {
                immutableList = Util.immutableList(select);
            } else {
                immutableList = Util.immutableList(Proxy.NO_PROXY);
            }
            this.proxies = immutableList;
        }
        this.nextProxyIndex = 0;
    }

    public void connectFailed(Route route, IOException iOException) {
        if (route.proxy().type() != Proxy.Type.DIRECT && this.address.proxySelector() != null) {
            this.address.proxySelector().connectFailed(this.address.url().uri(), route.proxy().address(), iOException);
        }
        this.routeDatabase.failed(route);
    }

    public boolean hasNext() {
        return hasNextProxy() || !this.postponedRoutes.isEmpty();
    }

    public Selection next() throws IOException {
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (hasNextProxy()) {
                Proxy nextProxy = nextProxy();
                int size = this.inetSocketAddresses.size();
                for (int i10 = 0; i10 < size; i10++) {
                    Route route = new Route(this.address, nextProxy, this.inetSocketAddresses.get(i10));
                    if (this.routeDatabase.shouldPostpone(route)) {
                        this.postponedRoutes.add(route);
                    } else {
                        arrayList.add(route);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.postponedRoutes);
                this.postponedRoutes.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }
}
