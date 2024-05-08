package io.grpc;

import io.grpc.Attributes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import javax.net.ssl.SSLSession;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Grpc {

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1710")
    public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_REMOTE_ADDR = Attributes.Key.create("io.grpc.Grpc.TRANSPORT_ATTR_REMOTE_ADDR");

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1710")
    public static final Attributes.Key<SocketAddress> TRANSPORT_ATTR_LOCAL_ADDR = Attributes.Key.create("io.grpc.Grpc.TRANSPORT_ATTR_LOCAL_ADDR");

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1710")
    public static final Attributes.Key<SSLSession> TRANSPORT_ATTR_SSL_SESSION = Attributes.Key.create("io.grpc.Grpc.TRANSPORT_ATTR_SSL_SESSION");

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4972")
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public @interface TransportAttr {
    }

    private Grpc() {
    }

    private static String authorityFromHostAndPort(String str, int i10) {
        try {
            return new URI(null, null, str, i10, null, null, null).getAuthority();
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException("Invalid host or port: " + str + " " + i10, e2);
        }
    }

    public static ManagedChannelBuilder<?> newChannelBuilder(String str, ChannelCredentials channelCredentials) {
        return ManagedChannelRegistry.getDefaultRegistry().newChannelBuilder(str, channelCredentials);
    }

    public static ManagedChannelBuilder<?> newChannelBuilderForAddress(String str, int i10, ChannelCredentials channelCredentials) {
        return newChannelBuilder(authorityFromHostAndPort(str, i10), channelCredentials);
    }

    public static ServerBuilder<?> newServerBuilderForPort(int i10, ServerCredentials serverCredentials) {
        return ServerRegistry.getDefaultRegistry().newServerBuilderForPort(i10, serverCredentials);
    }
}
