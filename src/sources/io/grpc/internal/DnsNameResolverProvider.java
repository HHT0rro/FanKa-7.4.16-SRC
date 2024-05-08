package io.grpc.internal;

import com.google.common.base.o;
import com.google.common.base.r;
import io.grpc.InternalServiceProviders;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import io.grpc.internal.ExponentialBackoffPolicy;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DnsNameResolverProvider extends NameResolverProvider {
    private static final String SCHEME = "dns";

    @Override // io.grpc.NameResolver.Factory
    public String getDefaultScheme() {
        return SCHEME;
    }

    @Override // io.grpc.NameResolverProvider
    public Collection<Class<? extends SocketAddress>> getProducedSocketAddressTypes() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // io.grpc.NameResolverProvider
    public boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.NameResolver.Factory
    public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
        if (!SCHEME.equals(uri.getScheme())) {
            return null;
        }
        String str = (String) o.s(uri.getPath(), "targetPath");
        o.n(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new RetryingNameResolver(new DnsNameResolver(uri.getAuthority(), str.substring(1), args, GrpcUtil.SHARED_CHANNEL_EXECUTOR, r.d(), InternalServiceProviders.isAndroid(DnsNameResolverProvider.class.getClassLoader())), new BackoffPolicyRetryScheduler(new ExponentialBackoffPolicy.Provider(), args.getScheduledExecutorService(), args.getSynchronizationContext()), args.getSynchronizationContext());
    }

    @Override // io.grpc.NameResolverProvider
    public int priority() {
        return 5;
    }
}
