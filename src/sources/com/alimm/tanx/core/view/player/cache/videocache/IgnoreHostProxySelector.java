package com.alimm.tanx.core.view.player.cache.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class IgnoreHostProxySelector extends ProxySelector {
    public static final List<Proxy> NO_PROXY_LIST = Arrays.asList(Proxy.NO_PROXY);
    public final ProxySelector defaultProxySelector;
    public final String hostToIgnore;
    public final int portToIgnore;

    public IgnoreHostProxySelector(ProxySelector proxySelector, String str, int i10) {
        this.defaultProxySelector = (ProxySelector) Preconditions.checkNotNull(proxySelector);
        this.hostToIgnore = (String) Preconditions.checkNotNull(str);
        this.portToIgnore = i10;
    }

    public static void install(String str, int i10) {
        ProxySelector.setDefault(new IgnoreHostProxySelector(ProxySelector.getDefault(), str, i10));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.defaultProxySelector.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.hostToIgnore.equals(uri.getHost()) && this.portToIgnore == uri.getPort() ? NO_PROXY_LIST : this.defaultProxySelector.select(uri);
    }
}
