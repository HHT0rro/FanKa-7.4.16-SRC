package com.irisdt.util;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import com.irisdt.OnHostNameResolver;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import io.grpc.NameResolverRegistry;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DnsResolver {
    private NameResolverProvider defaultNameResolverProvider = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class DirectAddressNameResolverProvider extends NameResolverProvider {
        private String mAddr;
        private String mHost;
        private int mPort;

        public DirectAddressNameResolverProvider(String str, int i10, String str2) {
            this.mHost = str;
            this.mPort = i10;
            this.mAddr = str2;
        }

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            return TextUtils.isEmpty(this.mHost) ? "IP" : URI.create(this.mHost).getScheme();
        }

        @Override // io.grpc.NameResolverProvider
        public boolean isAvailable() {
            return true;
        }

        @Override // io.grpc.NameResolver.Factory
        public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
            if (uri == null || TextUtils.isEmpty(this.mHost) || !uri.getScheme().equals(this.mHost)) {
                return null;
            }
            return new NameResolver() { // from class: com.irisdt.util.DnsResolver.DirectAddressNameResolverProvider.1
                @Override // io.grpc.NameResolver
                public String getServiceAuthority() {
                    return DirectAddressNameResolverProvider.this.mHost + u.bD + DirectAddressNameResolverProvider.this.mPort;
                }

                @Override // io.grpc.NameResolver
                public void shutdown() {
                }

                @Override // io.grpc.NameResolver
                public void start(NameResolver.Listener listener) {
                    InetSocketAddress inetSocketAddress;
                    if (TextUtils.isEmpty(DirectAddressNameResolverProvider.this.mAddr)) {
                        try {
                            InetAddress byName = InetAddress.getByName(DirectAddressNameResolverProvider.this.mHost);
                            inetSocketAddress = new InetSocketAddress(byName, DirectAddressNameResolverProvider.this.mPort);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("newNameResolver inetAddress : ");
                            sb2.append((Object) byName);
                        } catch (UnknownHostException e2) {
                            inetSocketAddress = new InetSocketAddress(DirectAddressNameResolverProvider.this.mPort);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Broken system behaviour for dns lookup of ");
                            sb3.append(DirectAddressNameResolverProvider.this.mHost);
                            e2.printStackTrace();
                        }
                    } else {
                        inetSocketAddress = new InetSocketAddress(DirectAddressNameResolverProvider.this.mAddr, DirectAddressNameResolverProvider.this.mPort);
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("newNameResolver socketAddress : ");
                    sb4.append(inetSocketAddress.toString());
                    listener.onAddresses(Collections.singletonList(new EquivalentAddressGroup(inetSocketAddress)), Attributes.EMPTY);
                }
            };
        }

        @Override // io.grpc.NameResolverProvider
        public int priority() {
            return 5;
        }
    }

    public void start(final String str, final int i10, final OnHostNameResolver onHostNameResolver) {
        if (this.defaultNameResolverProvider != null) {
            NameResolverRegistry.getDefaultRegistry().deregister(this.defaultNameResolverProvider);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("dns deregister : ");
            sb2.append((Object) this.defaultNameResolverProvider);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManager.startThread(new Runnable() { // from class: com.irisdt.util.DnsResolver.1
            @Override // java.lang.Runnable
            public void run() {
                OnHostNameResolver onHostNameResolver2 = onHostNameResolver;
                final String obtainIP = onHostNameResolver2 != null ? onHostNameResolver2.obtainIP(str) : "";
                StringBuilder sb3 = new StringBuilder();
                sb3.append("dns ipAddr : ");
                sb3.append(obtainIP);
                if (TextUtils.isEmpty(obtainIP)) {
                    return;
                }
                Utils.postUIRunnable(new Runnable() { // from class: com.irisdt.util.DnsResolver.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        DnsResolver dnsResolver = DnsResolver.this;
                        dnsResolver.defaultNameResolverProvider = new DirectAddressNameResolverProvider(str, i10, obtainIP);
                        NameResolverRegistry.getDefaultRegistry().register(DnsResolver.this.defaultNameResolverProvider);
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("dns register : ");
                        sb4.append((Object) DnsResolver.this.defaultNameResolverProvider);
                    }
                });
            }
        });
    }
}
