package io.grpc.okhttp;

import com.google.common.base.o;
import io.grpc.ExperimentalApi;
import javax.net.ssl.SSLSocketFactory;

@ExperimentalApi("There is no plan to make this API stable, given transport API instability")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SslSocketFactoryChannelCredentials {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ChannelCredentials extends io.grpc.ChannelCredentials {
        private final SSLSocketFactory factory;

        public SSLSocketFactory getFactory() {
            return this.factory;
        }

        @Override // io.grpc.ChannelCredentials
        public io.grpc.ChannelCredentials withoutBearerTokens() {
            return this;
        }

        private ChannelCredentials(SSLSocketFactory sSLSocketFactory) {
            this.factory = (SSLSocketFactory) o.s(sSLSocketFactory, "factory");
        }
    }

    private SslSocketFactoryChannelCredentials() {
    }

    public static io.grpc.ChannelCredentials create(SSLSocketFactory sSLSocketFactory) {
        return new ChannelCredentials(sSLSocketFactory);
    }
}
