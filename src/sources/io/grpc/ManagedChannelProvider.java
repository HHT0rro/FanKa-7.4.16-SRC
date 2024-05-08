package io.grpc;

import com.google.common.base.o;
import java.net.SocketAddress;
import java.util.Collection;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ManagedChannelProvider {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NewChannelBuilderResult {
        private final ManagedChannelBuilder<?> channelBuilder;
        private final String error;

        private NewChannelBuilderResult(ManagedChannelBuilder<?> managedChannelBuilder, String str) {
            this.channelBuilder = managedChannelBuilder;
            this.error = str;
        }

        public static NewChannelBuilderResult channelBuilder(ManagedChannelBuilder<?> managedChannelBuilder) {
            return new NewChannelBuilderResult((ManagedChannelBuilder) o.r(managedChannelBuilder), null);
        }

        public static NewChannelBuilderResult error(String str) {
            return new NewChannelBuilderResult(null, (String) o.r(str));
        }

        public ManagedChannelBuilder<?> getChannelBuilder() {
            return this.channelBuilder;
        }

        public String getError() {
            return this.error;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String str) {
            super(str);
        }
    }

    public static ManagedChannelProvider provider() {
        ManagedChannelProvider provider = ManagedChannelRegistry.getDefaultRegistry().provider();
        if (provider != null) {
            return provider;
        }
        throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    public abstract ManagedChannelBuilder<?> builderForAddress(String str, int i10);

    public abstract ManagedChannelBuilder<?> builderForTarget(String str);

    public abstract Collection<Class<? extends SocketAddress>> getSupportedSocketAddressTypes();

    public abstract boolean isAvailable();

    public NewChannelBuilderResult newChannelBuilder(String str, ChannelCredentials channelCredentials) {
        return NewChannelBuilderResult.error("ChannelCredentials are unsupported");
    }

    public abstract int priority();
}
