package io.grpc.okhttp;

import com.google.common.base.o;
import io.grpc.ExperimentalApi;
import io.grpc.okhttp.internal.ConnectionSpec;
import javax.net.ssl.SSLSocketFactory;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1785")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SslSocketFactoryServerCredentials {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ServerCredentials extends io.grpc.ServerCredentials {
        private final ConnectionSpec connectionSpec;
        private final SSLSocketFactory factory;

        public ServerCredentials(SSLSocketFactory sSLSocketFactory) {
            this(sSLSocketFactory, OkHttpChannelBuilder.INTERNAL_DEFAULT_CONNECTION_SPEC);
        }

        public ConnectionSpec getConnectionSpec() {
            return this.connectionSpec;
        }

        public SSLSocketFactory getFactory() {
            return this.factory;
        }

        public ServerCredentials(SSLSocketFactory sSLSocketFactory, ConnectionSpec connectionSpec) {
            this.factory = (SSLSocketFactory) o.s(sSLSocketFactory, "factory");
            this.connectionSpec = (ConnectionSpec) o.s(connectionSpec, "connectionSpec");
        }
    }

    private SslSocketFactoryServerCredentials() {
    }

    public static io.grpc.ServerCredentials create(SSLSocketFactory sSLSocketFactory) {
        return new ServerCredentials(sSLSocketFactory);
    }

    public static io.grpc.ServerCredentials create(SSLSocketFactory sSLSocketFactory, com.squareup.okhttp.ConnectionSpec connectionSpec) {
        return new ServerCredentials(sSLSocketFactory, Utils.convertSpec(connectionSpec));
    }
}
