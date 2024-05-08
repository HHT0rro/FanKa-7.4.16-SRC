package io.grpc;

import io.grpc.NameResolver;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4159")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class NameResolverProvider extends NameResolver.Factory {
    public Collection<Class<? extends SocketAddress>> getProducedSocketAddressTypes() {
        return Collections.singleton(InetSocketAddress.class);
    }

    public String getScheme() {
        return getDefaultScheme();
    }

    public abstract boolean isAvailable();

    public abstract int priority();
}
